package com.mobvoi.wear.msgproxy.server;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import ca.e;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.c;
import com.mobvoi.android.common.utils.f;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.ble.BleCentralManager;
import com.mobvoi.wear.ble.BleProtocol;
import com.mobvoi.wear.msgproxy.MessageProxyDispatcher;
import com.mobvoi.wear.msgproxy.NodeInfo;
import com.mobvoi.wear.msgproxy.server.BleHeartbeat;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import t9.a;
import t9.d;
/* loaded from: classes2.dex */
public class BleWearableClient implements WearableClient, BleCentralManager.Callback, BleHeartbeat.Callback {
    private static final long BLUETOOTH_ACL_EVENT_DELAY = 3000;
    private static final long RECONNECT_DELAY_MAX = 300000;
    private static final long RECONNECT_DELAY_START = 1000;
    private static final String TAG = "BleWearableClient";
    private Context mAppContext;
    private BleCentralManager mBleCentralManager;
    private BleHeartbeat mBleHeartbeat;
    private BluetoothDevice mRemoteDevice;
    private long mReconnectDelay = 1000;
    private Runnable mReconnectTask = new Runnable() { // from class: com.mobvoi.wear.msgproxy.server.BleWearableClient.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(BleProtocol.ACTION_CONNECT);
            intent.setPackage(BleWearableClient.this.mAppContext.getPackageName());
            BleWearableClient.this.mAppContext.sendBroadcast(intent);
        }
    };
    private d mTaskScheduler = new d(new a(Looper.getMainLooper()), "BleReconnect");
    private Handler mAclEventsHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes2.dex */
    private class ConnectReceiver extends BroadcastReceiver {
        private ConnectReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            k.c(BleWearableClient.TAG, "onReceive: %s", intent);
            String action = intent.getAction();
            if (BleProtocol.ACTION_CONNECT.equals(action)) {
                if (!BleWearableClient.this.mBleCentralManager.isConnected()) {
                    BleWearableClient.this.connect("Reconnect");
                }
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                if (!BleWearableClient.this.mBleCentralManager.isConnected()) {
                    BleWearableClient.this.connect("ScreenOn");
                } else {
                    BleWearableClient.this.mBleHeartbeat.onScreenOn();
                }
            } else if ("android.bluetooth.device.action.ACL_CONNECTED".equals(action)) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice.equals(BleWearableClient.this.mRemoteDevice)) {
                    BleWearableClient.this.mAclEventsHandler.removeCallbacksAndMessages(null);
                    Handler handler = BleWearableClient.this.mAclEventsHandler;
                    final BleWearableClient bleWearableClient = BleWearableClient.this;
                    handler.postDelayed(new Runnable() { // from class: com.mobvoi.wear.msgproxy.server.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            BleWearableClient.access$700(BleWearableClient.this);
                        }
                    }, 3000L);
                    return;
                }
                k.c(BleWearableClient.TAG, "unknown BT device [%s] connected", bluetoothDevice);
            } else if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice2.equals(BleWearableClient.this.mRemoteDevice)) {
                    BleWearableClient.this.mAclEventsHandler.removeCallbacksAndMessages(null);
                    BleWearableClient.this.onPeerDisconnected();
                    return;
                }
                k.c(BleWearableClient.TAG, "unknown BT device [%s] disconnected", bluetoothDevice2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BleWearableClient(Context context) {
        k.a(TAG, "Create BleWearableClient");
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mBleCentralManager = new BleCentralManager(applicationContext, this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BleProtocol.ACTION_CONNECT);
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        context.registerReceiver(new ConnectReceiver(), intentFilter);
        this.mBleHeartbeat = new BleHeartbeat(this.mAppContext, this);
        connect("AppStart");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void access$700(BleWearableClient bleWearableClient) {
        bleWearableClient.onPeerConnected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connect(String str) {
        k.c(TAG, "try to setup connection: %s", str);
        BluetoothManager bluetoothManager = (BluetoothManager) this.mAppContext.getSystemService("bluetooth");
        if (bluetoothManager == null) {
            k.q(TAG, "Failed to get BluetoothManager. Cannot connect GATT server.");
            reconnectWithDelay();
            return;
        }
        List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(8);
        if (connectedDevices.size() == 0) {
            k.q(TAG, "No connected GATT server");
            this.mAppContext.sendBroadcast(new Intent(BleProtocol.ACTION_CONNECT_FAILED));
            reconnectWithDelay();
            return;
        }
        BluetoothDevice bluetoothDevice = connectedDevices.get(0);
        this.mRemoteDevice = bluetoothDevice;
        this.mBleCentralManager.connect(bluetoothDevice);
    }

    @SuppressLint({"MissingPermission"})
    private NodeInfo createNodeInfo(BluetoothDevice bluetoothDevice) {
        try {
            return new NodeInfo(4, f.k(bluetoothDevice.getAddress()), bluetoothDevice.getName(), true);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e10) {
            k.e(TAG, "Could not hash device address", e10);
            return new NodeInfo(4, bluetoothDevice.getAddress(), bluetoothDevice.getName(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPeerConnected() {
        k.a(TAG, "onPeerConnected");
        connect("AclConnected");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPeerDisconnected() {
        k.a(TAG, "onPeerDisconnected");
        if (this.mBleCentralManager.isConnected()) {
            this.mBleCentralManager.disconnect();
        }
        this.mBleHeartbeat.onBleConnectionChange(false);
    }

    private void reconnectWithDelay() {
        k.c(TAG, "schedule reconnect task with delay %ds", Long.valueOf(this.mReconnectDelay / 1000));
        this.mTaskScheduler.f(this.mReconnectTask);
        this.mTaskScheduler.l(this.mReconnectTask, this.mReconnectDelay);
        long j10 = this.mReconnectDelay * 2;
        this.mReconnectDelay = j10;
        if (j10 > RECONNECT_DELAY_MAX) {
            this.mReconnectDelay = RECONNECT_DELAY_MAX;
        }
    }

    @Override // com.mobvoi.wear.msgproxy.server.WearableClient
    public List<NodeInfo> getConnectedNodes() {
        ArrayList arrayList = new ArrayList();
        BluetoothManager bluetoothManager = (BluetoothManager) this.mAppContext.getSystemService("bluetooth");
        if (bluetoothManager == null) {
            k.q(TAG, "Failed to get BluetoothManager. Cannot get connected nodes.");
            return arrayList;
        }
        for (BluetoothDevice bluetoothDevice : bluetoothManager.getConnectedDevices(8)) {
            arrayList.add(createNodeInfo(bluetoothDevice));
        }
        return arrayList;
    }

    @Override // com.mobvoi.wear.msgproxy.server.WearableClient
    public boolean hasConnectedNodes() {
        return this.mBleCentralManager.isConnected();
    }

    @Override // com.mobvoi.wear.ble.BleCentralManager.Callback
    public void onCompanionServiceNotFound() {
        k.a(TAG, "onCompanionServiceNotFound");
        reconnectWithDelay();
    }

    @Override // com.mobvoi.wear.ble.BleCentralManager.Callback
    @SuppressLint({"MissingPermission"})
    public void onGattConnected(BluetoothDevice bluetoothDevice) {
        k.c(TAG, "onGattConnected: %s", bluetoothDevice);
        this.mReconnectDelay = 1000L;
        this.mTaskScheduler.h();
        ArrayList<NodeInfo> arrayList = new ArrayList<>();
        arrayList.add(createNodeInfo(bluetoothDevice));
        MessageProxyDispatcher.getInstance(this.mAppContext).onConnectedNodesChanged(4, arrayList);
        this.mBleHeartbeat.onBleConnectionChange(true);
    }

    @Override // com.mobvoi.wear.ble.BleCentralManager.Callback
    public void onGattDataReceived(byte[] bArr) {
        try {
            e c10 = e.c(bArr);
            int i10 = c10.f5650a;
            if (i10 == 0) {
                this.mBleHeartbeat.onDataReceived();
                ca.f fVar = c10.f5651b;
                k.c(TAG, "rpcRequest received: %s", fVar);
                if (!TextUtils.isEmpty(fVar.f5663f)) {
                    String valueOf = String.valueOf(f.a(fVar.f5660c));
                    if (!fVar.f5663f.equals(valueOf)) {
                        k.s(TAG, "mismatch data checksum, real: [%s], discard: %s", valueOf, fVar.f5659b);
                        return;
                    }
                }
                MessageProxyDispatcher.getInstance(this.mAppContext).onMessageReceived(fVar.f5658a, fVar.f5659b, fVar.f5660c);
                return;
            }
            k.s(TAG, "unknown data received with type: %d", Integer.valueOf(i10));
        } catch (InvalidProtocolBufferNanoException e10) {
            k.e(TAG, "Failed to parse request", e10);
        }
    }

    @Override // com.mobvoi.wear.ble.BleCentralManager.Callback
    public void onGattDisconnected() {
        k.a(TAG, "onGattDisconnected");
        MessageProxyDispatcher.getInstance(this.mAppContext).onConnectedNodesChanged(4, new ArrayList<>());
        reconnectWithDelay();
    }

    @Override // com.mobvoi.wear.msgproxy.server.BleHeartbeat.Callback
    public void onRemoteDeviceLost() {
        k.a(TAG, "onRemoteDeviceLost, disconnect GATT client");
        this.mBleCentralManager.disconnect();
    }

    @Override // com.mobvoi.wear.msgproxy.server.WearableClient
    public void sendMessage(String str, String str2, byte[] bArr) {
        k.c(TAG, "sendMessage, nodeId=%s, path=%s, len=%d", str, str2, Integer.valueOf(bArr.length));
        ca.f fVar = new ca.f();
        fVar.f5658a = str;
        fVar.f5659b = str2;
        fVar.f5660c = bArr;
        fVar.f5663f = String.valueOf(f.a(bArr));
        e eVar = new e();
        eVar.f5650a = 0;
        eVar.f5651b = fVar;
        this.mBleCentralManager.sendData(c.toByteArray(eVar));
    }
}
