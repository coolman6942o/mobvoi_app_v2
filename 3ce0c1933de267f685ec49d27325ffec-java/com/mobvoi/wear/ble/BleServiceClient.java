package com.mobvoi.wear.ble;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.mobvoi.android.common.utils.f;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.o;
import com.mobvoi.wear.ble.IBluetoothLowEnergyService;
import com.mobvoi.wear.msgproxy.NodeInfo;
import com.mobvoi.wear.msgproxy.server.WearableClient;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class BleServiceClient implements WearableClient {
    private static final String TAG = "BleServiceClient";
    private IBluetoothLowEnergyService mBleService;
    private String mConnectedDeviceName;
    private Context mContext;
    private final Object mLock = new Object();
    private boolean mIsAncsConnected = false;
    private boolean mIsCompanionConnected = false;
    private volatile boolean mIsClosed = false;
    private ArrayList<BleListener> mBleListeners = null;
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.mobvoi.wear.ble.BleServiceClient.1
        @Override // android.content.ServiceConnection
        @SuppressLint({"MissingPermission"})
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (BleServiceClient.this) {
                if (BleServiceClient.this.mIsClosed) {
                    Log.d(BleServiceClient.TAG, "onServiceConnected after closed, unbind the service");
                    BleServiceClient.this.mContext.unbindService(this);
                    return;
                }
                BleServiceClient.this.mBleService = IBluetoothLowEnergyService.Stub.asInterface(iBinder);
                try {
                    BleServiceClient bleServiceClient = BleServiceClient.this;
                    bleServiceClient.mIsAncsConnected = bleServiceClient.mBleService.isAncsConnected();
                    BleServiceClient bleServiceClient2 = BleServiceClient.this;
                    bleServiceClient2.mIsCompanionConnected = bleServiceClient2.mBleService.isCompanionConnected();
                    if (BleServiceClient.this.mIsCompanionConnected) {
                        BleServiceClient bleServiceClient3 = BleServiceClient.this;
                        bleServiceClient3.mConnectedDeviceName = bleServiceClient3.mBleService.getConnectedDevice();
                    }
                    synchronized (BleServiceClient.this.mLock) {
                        if (BleServiceClient.this.mBleListeners != null) {
                            Iterator it = BleServiceClient.this.mBleListeners.iterator();
                            while (it.hasNext()) {
                                ((BleListener) it.next()).onInitialStatus(BleServiceClient.this.mIsCompanionConnected, BleServiceClient.this.mIsAncsConnected);
                            }
                        }
                    }
                } catch (RemoteException e10) {
                    Log.e(BleServiceClient.TAG, "RemoteException:" + e10.getMessage());
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            BleServiceClient.this.mBleService = null;
        }
    };
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.mobvoi.wear.ble.BleServiceClient.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(BleProtocol.ACTION_ANCS_CONNECTED)) {
                BleServiceClient.this.mIsAncsConnected = true;
            } else if (action.equals(BleProtocol.ACTION_ANCS_DISCONNECTED)) {
                BleServiceClient.this.mIsAncsConnected = false;
            } else if (action.equals(BleProtocol.ACTION_COMPANION_CONNECTED)) {
                BleServiceClient.this.mIsCompanionConnected = true;
                BleServiceClient.this.mConnectedDeviceName = intent.getStringExtra(BleProtocol.EXTRA_DEVICE_NAME);
                synchronized (BleServiceClient.this.mLock) {
                    if (BleServiceClient.this.mBleListeners != null) {
                        Iterator it = BleServiceClient.this.mBleListeners.iterator();
                        while (it.hasNext()) {
                            ((BleListener) it.next()).onCompanionConnected();
                        }
                    }
                }
            } else if (action.equals(BleProtocol.ACTION_COMPANION_DISCONNECTED)) {
                BleServiceClient.this.mIsCompanionConnected = false;
                BleServiceClient.this.mConnectedDeviceName = null;
                synchronized (BleServiceClient.this.mLock) {
                    if (BleServiceClient.this.mBleListeners != null) {
                        Iterator it2 = BleServiceClient.this.mBleListeners.iterator();
                        while (it2.hasNext()) {
                            ((BleListener) it2.next()).onCompanionDisconnected();
                        }
                    }
                }
            } else if (action.equals(BleProtocol.ACTION_RECEIVE_MESSAGE)) {
                synchronized (BleServiceClient.this.mLock) {
                    if (BleServiceClient.this.mBleListeners != null) {
                        intent.getStringExtra(BleProtocol.EXTRA_NODE);
                        String stringExtra = intent.getStringExtra("path");
                        byte[] byteArrayExtra = intent.getByteArrayExtra(BleProtocol.EXTRA_PAYLOAD);
                        Iterator it3 = BleServiceClient.this.mBleListeners.iterator();
                        while (it3.hasNext()) {
                            ((BleListener) it3.next()).onMessageReceived(stringExtra, byteArrayExtra);
                        }
                    }
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface BleListener {
        void onCompanionConnected();

        void onCompanionDisconnected();

        void onInitialStatus(boolean z10, boolean z11);

        void onMessageReceived(String str, byte[] bArr);
    }

    public BleServiceClient(Context context) {
        k.a(TAG, "Create BleServiceClient");
        o.e(context);
        this.mContext = context;
        Intent intent = new Intent(BleProtocol.BLE_SERVICE);
        intent.setPackage("com.mobvoi.ticwear.home");
        this.mContext.bindService(intent, this.mConnection, 1);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BleProtocol.ACTION_ANCS_CONNECTED);
        intentFilter.addAction(BleProtocol.ACTION_ANCS_DISCONNECTED);
        intentFilter.addAction(BleProtocol.ACTION_COMPANION_CONNECTED);
        intentFilter.addAction(BleProtocol.ACTION_COMPANION_DISCONNECTED);
        intentFilter.addAction(BleProtocol.ACTION_RECEIVE_MESSAGE);
        this.mContext.registerReceiver(this.mReceiver, intentFilter);
    }

    private void removeAllListeners() {
        synchronized (this.mLock) {
            ArrayList<BleListener> arrayList = this.mBleListeners;
            if (arrayList != null) {
                arrayList.clear();
                this.mBleListeners = null;
            }
        }
    }

    public void addListener(BleListener bleListener) {
        synchronized (this.mLock) {
            if (this.mBleListeners == null) {
                this.mBleListeners = new ArrayList<>();
            }
            this.mBleListeners.add(bleListener);
        }
    }

    public void close() {
        synchronized (this) {
            if (!this.mIsClosed) {
                this.mIsClosed = true;
                if (this.mBleService != null) {
                    this.mContext.unbindService(this.mConnection);
                }
                this.mContext.unregisterReceiver(this.mReceiver);
                removeAllListeners();
            }
        }
    }

    @Override // com.mobvoi.wear.msgproxy.server.WearableClient
    public List<NodeInfo> getConnectedNodes() {
        NodeInfo nodeInfo;
        ArrayList arrayList = new ArrayList();
        if (this.mIsCompanionConnected) {
            try {
                nodeInfo = new NodeInfo(4, f.k(this.mConnectedDeviceName), this.mConnectedDeviceName, true);
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException e10) {
                k.e(TAG, "Could not hash device address", e10);
                String str = this.mConnectedDeviceName;
                nodeInfo = new NodeInfo(4, str, str, true);
            }
            arrayList.add(nodeInfo);
        }
        return arrayList;
    }

    @Override // com.mobvoi.wear.msgproxy.server.WearableClient
    public boolean hasConnectedNodes() {
        return this.mIsCompanionConnected;
    }

    public boolean isAncsConnected() {
        return this.mIsAncsConnected;
    }

    public boolean isCompanionConnected() {
        return this.mIsCompanionConnected;
    }

    public boolean isGattConnected() {
        try {
            IBluetoothLowEnergyService iBluetoothLowEnergyService = this.mBleService;
            if (iBluetoothLowEnergyService != null) {
                return iBluetoothLowEnergyService.isConnected();
            }
            return false;
        } catch (RemoteException e10) {
            Log.e(TAG, e10.getMessage());
            return false;
        }
    }

    public void removeListener(BleListener bleListener) {
        synchronized (this.mLock) {
            ArrayList<BleListener> arrayList = this.mBleListeners;
            if (arrayList != null) {
                arrayList.remove(bleListener);
                if (this.mBleListeners.isEmpty()) {
                    this.mBleListeners = null;
                }
            }
        }
    }

    public void sendMessage(String str, byte[] bArr) {
        o.f(str != null, "sendMessage: invalid arguments");
        sendMessage("default_node", str, bArr);
    }

    @Override // com.mobvoi.wear.msgproxy.server.WearableClient
    public void sendMessage(String str, String str2, byte[] bArr) {
        o.f((str == null || str2 == null || bArr == null) ? false : true, "sendMessage: invalid arguments");
        Intent intent = new Intent(BleProtocol.ACTION_SEND_MESSAGE);
        intent.putExtra(BleProtocol.EXTRA_NODE, str);
        intent.putExtra("path", str2);
        intent.putExtra(BleProtocol.EXTRA_PAYLOAD, bArr);
        this.mContext.sendBroadcast(intent);
    }
}
