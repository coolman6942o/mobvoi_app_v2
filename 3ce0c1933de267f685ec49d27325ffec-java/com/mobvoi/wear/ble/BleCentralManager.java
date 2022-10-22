package com.mobvoi.wear.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.wear.ble.BleCentralManager;
import com.mobvoi.wear.ble.MessageParser;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class BleCentralManager implements BleCentralHelperDelegate, MessageParser.MessageParserCallback {
    private static final String CLIENT_DESCRIPTOR_CONFIG_UUID = "00002902-0000-1000-8000-00805f9b34fb";
    private static final String COMPANION_SERVICE_UUID = "735dc4fa-348e-11e7-a919-92ebcb67fe33";
    private static final String READ_CHARACTERISTIC_UUID = "c5b1d8c4-3496-11e7-b687-92ebcb67fe33";
    private static final int STATE_CONNECTED = 2;
    private static final int STATE_CONNECTING = 3;
    private static final int STATE_DISCONNECTED = 0;
    private static final int STATE_DISCONNECTING = 1;
    private static final String TAG = "BleCentralManager";
    private static final String WRITE_CHARACTERISTIC_UUID = "c5b1dc5c-3496-11e7-b687-92ebcb67fe33";
    private Context mAppContext;
    private BleCentralHelper mBleCentralHelper;
    private Handler mBleHandler;
    private Callback mCallback;
    private AtomicInteger mConnectionState = new AtomicInteger(0);
    private boolean mGattServerConnected = false;
    private MessageParser mMessageParser = new MessageParser(this);
    private UUID mCompanionServiceUuid = UUID.fromString(COMPANION_SERVICE_UUID);
    private UUID mReadCharacteristicUuid = UUID.fromString(READ_CHARACTERISTIC_UUID);
    private UUID mWriteCharacteristicUuid = UUID.fromString(WRITE_CHARACTERISTIC_UUID);
    private UUID mClientDescriptorUuid = UUID.fromString(CLIENT_DESCRIPTOR_CONFIG_UUID);

    /* loaded from: classes2.dex */
    public interface Callback {
        void onCompanionServiceNotFound();

        void onGattConnected(BluetoothDevice bluetoothDevice);

        void onGattDataReceived(byte[] bArr);

        void onGattDisconnected();
    }

    /* loaded from: classes2.dex */
    private class LocalReceiver extends BroadcastReceiver {
        private LocalReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            k.c(BleCentralManager.TAG, "onReceive: %s", intent);
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction()) && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1) == 10) {
                BleCentralManager.this.onGattDisconnected();
            }
        }
    }

    public BleCentralManager(Context context, Callback callback) {
        this.mAppContext = context;
        this.mCallback = callback;
        this.mBleCentralHelper = new BleCentralHelper(context, this);
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        this.mBleHandler = new Handler(handlerThread.getLooper());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.mAppContext.registerReceiver(new LocalReceiver(), intentFilter);
    }

    private void checkBleTaskThread() {
        if (Looper.myLooper() != this.mBleHandler.getLooper()) {
            throw new RuntimeException("Not in BLE task thread!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCompanionService() {
        boolean z10;
        checkBleTaskThread();
        try {
            this.mBleCentralHelper.prepareForServiceDiscovery();
            SystemClock.sleep(1000L);
            k.a(TAG, "check companion service...");
            Iterator<BluetoothGattService> it = this.mBleCentralHelper.getServices().iterator();
            while (true) {
                z10 = true;
                if (!it.hasNext()) {
                    z10 = false;
                    break;
                }
                BluetoothGattService next = it.next();
                k.c(TAG, "found service: %s", next.getUuid());
                if (next.getUuid().equals(this.mCompanionServiceUuid)) {
                    k.h(TAG, "Companion service found");
                    connectCompanion(next);
                    break;
                }
            }
            if (!z10) {
                k.h(TAG, "No companion service found");
                onCompanionServiceNotFound();
            }
        } catch (Exception e10) {
            k.e(TAG, "Failed to get services", e10);
            onError();
        }
    }

    private void connectCompanion(BluetoothGattService bluetoothGattService) {
        checkBleTaskThread();
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
            if (bluetoothGattCharacteristic.getUuid().equals(this.mReadCharacteristicUuid)) {
                enableReadCharacteristicNotification(bluetoothGattCharacteristic);
                return;
            }
        }
    }

    private String connectStateToStr() {
        int i10 = this.mConnectionState.get();
        if (i10 == 0) {
            return "DISCONNECTED";
        }
        if (i10 == 1) {
            return "DISCONNECTING";
        }
        if (i10 == 2) {
            return "CONNECTED";
        }
        if (i10 == 3) {
            return "CONNECTING";
        }
        return "unknown-state-[" + i10 + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doConnect */
    public void lambda$connect$0(BluetoothDevice bluetoothDevice) {
        checkBleTaskThread();
        if (!this.mConnectionState.compareAndSet(0, 3)) {
            k.c(TAG, "connect in wrong state: %s", connectStateToStr());
            return;
        }
        try {
            if (this.mGattServerConnected) {
                k.a(TAG, "GattServer is already connected");
                checkCompanionService();
            } else {
                this.mBleCentralHelper.connectGatt(bluetoothDevice);
            }
        } catch (Exception e10) {
            k.e(TAG, "Failed to connect to GATT server", e10);
            onError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDisconnect() {
        checkBleTaskThread();
        if (!this.mConnectionState.compareAndSet(2, 1)) {
            k.c(TAG, "disconnect in wrong state: %s", connectStateToStr());
            return;
        }
        try {
            this.mBleCentralHelper.disconnectGatt("disconnect");
        } catch (Exception e10) {
            k.e(TAG, "Failed to disconnect to GATT server", e10);
            onError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doSendData */
    public void lambda$sendData$4(byte[] bArr) {
        k.c(TAG, "sendData: %d", Integer.valueOf(bArr.length));
        checkBleTaskThread();
        if (this.mConnectionState.get() != 2) {
            k.q(TAG, "send data but not connected");
            return;
        }
        try {
            this.mMessageParser.setMtu(this.mBleCentralHelper.getMtu());
            List<byte[]> packetWriteData = this.mMessageParser.packetWriteData(bArr);
            BluetoothGattCharacteristic characteristic = this.mBleCentralHelper.getService(this.mCompanionServiceUuid).getCharacteristic(this.mWriteCharacteristicUuid);
            for (byte[] bArr2 : packetWriteData) {
                this.mBleCentralHelper.writeCharacteristic(characteristic, bArr2);
            }
        } catch (Exception e10) {
            k.f(TAG, "failed to send data: %s", e10.toString());
            onError();
        }
        k.a(TAG, "sendData done");
    }

    private void enableReadCharacteristicNotification(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        k.a(TAG, "enableReadCharacteristicNotification");
        checkBleTaskThread();
        try {
            this.mBleCentralHelper.enableCharacteristicNotification(bluetoothGattCharacteristic);
            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(this.mClientDescriptorUuid);
            if (descriptor != null) {
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                this.mBleCentralHelper.writeDescriptor(descriptor);
            } else {
                k.q(TAG, "No descriptor found");
            }
        } catch (Exception e10) {
            k.e(TAG, "Error when subscribing to characteristic", e10);
            onError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDescriptorWrite$2(BluetoothGatt bluetoothGatt) {
        this.mConnectionState.set(2);
        this.mMessageParser.reset();
        this.mCallback.onGattConnected(bluetoothGatt.getDevice());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onError$5() {
        if (this.mConnectionState.getAndSet(0) != 0) {
            this.mCallback.onGattDisconnected();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onGattDisconnected$1() {
        if (this.mConnectionState.getAndSet(0) != 0) {
            this.mCallback.onGattDisconnected();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onIncomingData$3(byte[] bArr) {
        this.mCallback.onGattDataReceived(bArr);
    }

    private void onCompanionServiceNotFound() {
        checkBleTaskThread();
        if (this.mConnectionState.get() == 3) {
            this.mAppContext.sendBroadcast(new Intent(BleProtocol.ACTION_CONNECT_FAILED));
        }
        this.mConnectionState.set(0);
        l a10 = l.a();
        final Callback callback = this.mCallback;
        Objects.requireNonNull(callback);
        a10.post(new Runnable() { // from class: com.mobvoi.wear.ble.a
            @Override // java.lang.Runnable
            public final void run() {
                BleCentralManager.Callback.this.onCompanionServiceNotFound();
            }
        });
    }

    private void onError() {
        checkBleTaskThread();
        if (this.mConnectionState.get() == 3) {
            this.mAppContext.sendBroadcast(new Intent(BleProtocol.ACTION_CONNECT_FAILED));
        }
        try {
            this.mBleCentralHelper.disconnectGatt("onError");
        } catch (Exception e10) {
            k.e(TAG, "error during onError", e10);
        }
        l.a().post(new Runnable() { // from class: com.mobvoi.wear.ble.e
            @Override // java.lang.Runnable
            public final void run() {
                BleCentralManager.this.lambda$onError$5();
            }
        });
    }

    public void connect(final BluetoothDevice bluetoothDevice) {
        this.mBleHandler.post(new Runnable() { // from class: com.mobvoi.wear.ble.f
            @Override // java.lang.Runnable
            public final void run() {
                BleCentralManager.this.lambda$connect$0(bluetoothDevice);
            }
        });
    }

    public void disconnect() {
        this.mBleHandler.post(new Runnable() { // from class: com.mobvoi.wear.ble.d
            @Override // java.lang.Runnable
            public final void run() {
                BleCentralManager.this.doDisconnect();
            }
        });
    }

    public boolean isConnected() {
        return this.mConnectionState.get() == 2;
    }

    @Override // com.mobvoi.wear.ble.BleCentralHelperDelegate
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (!bluetoothGattCharacteristic.getUuid().equals(this.mReadCharacteristicUuid)) {
            k.s(TAG, "Unknown characteristic uuid: %s", bluetoothGattCharacteristic.getUuid());
        } else {
            this.mMessageParser.parseIncomingData(bluetoothGattCharacteristic.getValue());
        }
    }

    @Override // com.mobvoi.wear.ble.BleCentralHelperDelegate
    public void onDescriptorWrite(final BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor) {
        if (bluetoothGattDescriptor.getCharacteristic().getUuid().equals(this.mReadCharacteristicUuid)) {
            k.h(TAG, "Companion connected");
            l.a().post(new Runnable() { // from class: com.mobvoi.wear.ble.g
                @Override // java.lang.Runnable
                public final void run() {
                    BleCentralManager.this.lambda$onDescriptorWrite$2(bluetoothGatt);
                }
            });
        }
    }

    @Override // com.mobvoi.wear.ble.BleCentralHelperDelegate
    public void onGattConnected(BluetoothDevice bluetoothDevice) {
        k.h(TAG, "onGattConnected");
        this.mGattServerConnected = true;
        this.mBleHandler.post(new Runnable() { // from class: com.mobvoi.wear.ble.c
            @Override // java.lang.Runnable
            public final void run() {
                BleCentralManager.this.checkCompanionService();
            }
        });
    }

    @Override // com.mobvoi.wear.ble.BleCentralHelperDelegate
    public void onGattDisconnected() {
        k.h(TAG, "onGattDisconnected");
        this.mGattServerConnected = false;
        l.a().post(new Runnable() { // from class: com.mobvoi.wear.ble.b
            @Override // java.lang.Runnable
            public final void run() {
                BleCentralManager.this.lambda$onGattDisconnected$1();
            }
        });
    }

    @Override // com.mobvoi.wear.ble.MessageParser.MessageParserCallback
    public void onIncomingData(final byte[] bArr) {
        l.a().post(new Runnable() { // from class: com.mobvoi.wear.ble.i
            @Override // java.lang.Runnable
            public final void run() {
                BleCentralManager.this.lambda$onIncomingData$3(bArr);
            }
        });
    }

    public void sendData(final byte[] bArr) {
        this.mBleHandler.post(new Runnable() { // from class: com.mobvoi.wear.ble.h
            @Override // java.lang.Runnable
            public final void run() {
                BleCentralManager.this.lambda$sendData$4(bArr);
            }
        });
    }
}
