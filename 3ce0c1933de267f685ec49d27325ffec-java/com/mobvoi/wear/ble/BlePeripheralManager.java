package com.mobvoi.wear.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.ble.MessageParser;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes2.dex */
public class BlePeripheralManager implements MessageParser.MessageParserCallback {
    private static final int COMPANY_ID = 70;
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final int DEFAULT_MTU = 155;
    private static final String ENABLE_NOTIFICATION_UUID = "00002902-0000-1000-8000-00805f9b34fb";
    private static final String READ_CHARACTERISTIC_UUID = "c5b1d8c4-3496-11e7-b687-92ebcb67fe33";
    private static final String SERVICE_UUID = "735dc4fa-348e-11e7-a919-92ebcb67fe33";
    private static final String TAG = "BlePeripheralManager";
    private static final String WRITE_CHARACTERISTIC_UUID = "c5b1dc5c-3496-11e7-b687-92ebcb67fe33";
    private static final long WRITE_TIMEOUT = 20000;
    private Context mAppContext;
    private Callback mCallback;
    private BluetoothDevice mDevice;
    private BluetoothGattServer mGattServer;
    private MessageParser mMessageParser;
    private final Object mWriteLock = new Object();
    private ByteBuffer mWriteBuffer = ByteBuffer.allocate(1024);
    private int mMtu = DEFAULT_MTU;
    private volatile boolean mIsAdvertising = false;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private BluetoothGattServerCallback mGattServerCallback = new BluetoothGattServerCallbackImpl();
    private AdvertiseCallback mAdvertiseCallback = new AdvertiseCallbackImpl();

    /* loaded from: classes2.dex */
    private class AdvertiseCallbackImpl extends AdvertiseCallback {
        private AdvertiseCallbackImpl() {
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartFailure(int i10) {
            Log.e(BlePeripheralManager.TAG, "onStartFailure " + i10);
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartSuccess(AdvertiseSettings advertiseSettings) {
            k.a(BlePeripheralManager.TAG, "onStartSuccess");
        }
    }

    /* loaded from: classes2.dex */
    private class BluetoothGattServerCallbackImpl extends BluetoothGattServerCallback {
        private BluetoothGattServerCallbackImpl() {
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i10, int i11, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            k.a(BlePeripheralManager.TAG, String.format("onCharacteristicReadRequest requestId=%d offset=%d characteristic=%s", Integer.valueOf(i10), Integer.valueOf(i11), bluetoothGattCharacteristic.getUuid().toString()));
            byte[] bArr = new byte[20];
            new Random().nextBytes(bArr);
            BlePeripheralManager.this.mGattServer.sendResponse(bluetoothDevice, i10, 0, 0, bArr);
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i10, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z10, boolean z11, int i11, byte[] bArr) {
            k.a(BlePeripheralManager.TAG, String.format("onCharacteristicWriteRequest requestId=%d characteristic=%s preparedWrite=%b responseNeeded=%b offset=%d byteLen=%d", Integer.valueOf(i10), bluetoothGattCharacteristic.getUuid().toString(), Boolean.valueOf(z10), Boolean.valueOf(z11), Integer.valueOf(i11), Integer.valueOf(bArr.length)));
            if (!z10) {
                BlePeripheralManager.this.mMessageParser.parseIncomingData(Arrays.copyOf(bArr, bArr.length));
            } else if (BlePeripheralManager.this.mWriteBuffer.remaining() > bArr.length) {
                BlePeripheralManager.this.mWriteBuffer.put(bArr);
            } else {
                ByteBuffer allocate = ByteBuffer.allocate(BlePeripheralManager.this.mWriteBuffer.capacity() * 2);
                BlePeripheralManager.this.mWriteBuffer.flip();
                allocate.put(BlePeripheralManager.this.mWriteBuffer);
                allocate.put(bArr);
                BlePeripheralManager.this.mWriteBuffer = allocate;
            }
            if (z11) {
                BlePeripheralManager.this.mGattServer.sendResponse(bluetoothDevice, i10, 0, 0, bArr);
            }
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i10, int i11) {
            k.a(BlePeripheralManager.TAG, String.format("onConnectionStateChange device=%s status=%d newState=%d", bluetoothDevice, Integer.valueOf(i10), Integer.valueOf(i11)));
            if (BlePeripheralManager.this.mDevice != null && BlePeripheralManager.this.mDevice.equals(bluetoothDevice)) {
                BlePeripheralManager.this.handleDisconnect();
            }
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onDescriptorReadRequest(BluetoothDevice bluetoothDevice, int i10, int i11, BluetoothGattDescriptor bluetoothGattDescriptor) {
            k.a(BlePeripheralManager.TAG, String.format("onDescriptorReadRequest characteristic %srequest=%d offset=%d descriptor=%s", bluetoothGattDescriptor.getCharacteristic().getUuid(), Integer.valueOf(i10), Integer.valueOf(i11), bluetoothGattDescriptor.getUuid().toString()));
            BlePeripheralManager.this.mGattServer.sendResponse(bluetoothDevice, i10, 0, 0, null);
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onDescriptorWriteRequest(BluetoothDevice bluetoothDevice, int i10, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z10, boolean z11, int i11, byte[] bArr) {
            k.a(BlePeripheralManager.TAG, String.format("onDescriptorWriteRequest characteristic=%s requestId=%d descriptor=%s preparedWrite=%b responseNeeded=%b offset=%d valueLen=%d", bluetoothGattDescriptor.getCharacteristic().getUuid(), Integer.valueOf(i10), bluetoothGattDescriptor.getUuid(), Boolean.valueOf(z10), Boolean.valueOf(z11), Integer.valueOf(i11), Integer.valueOf(bArr.length)));
            if (bluetoothGattDescriptor.getUuid().toString().equals(BlePeripheralManager.ENABLE_NOTIFICATION_UUID) && bluetoothGattDescriptor.getCharacteristic().getUuid().toString().equals(BlePeripheralManager.READ_CHARACTERISTIC_UUID)) {
                if (Arrays.equals(bArr, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE)) {
                    BlePeripheralManager.this.mDevice = bluetoothDevice;
                    BlePeripheralManager.this.mCallback.onConnected(bluetoothDevice);
                } else if (Arrays.equals(bArr, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE) && BlePeripheralManager.this.mDevice != null && BlePeripheralManager.this.mDevice.equals(bluetoothDevice)) {
                    BlePeripheralManager.this.mCallback.onDisconnected(BlePeripheralManager.this.mDevice);
                    BlePeripheralManager.this.mDevice = null;
                }
            }
            if (z11) {
                BlePeripheralManager.this.mGattServer.sendResponse(bluetoothDevice, i10, 0, 0, null);
            }
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onExecuteWrite(BluetoothDevice bluetoothDevice, int i10, boolean z10) {
            k.a(BlePeripheralManager.TAG, String.format("onExecuteWrite requestId=%d execute=%b", Integer.valueOf(i10), Boolean.valueOf(z10)));
            BlePeripheralManager.this.mGattServer.sendResponse(bluetoothDevice, i10, 0, 0, null);
            if (z10) {
                BlePeripheralManager.this.mWriteBuffer.flip();
                byte[] bArr = new byte[BlePeripheralManager.this.mWriteBuffer.remaining()];
                BlePeripheralManager.this.mWriteBuffer.get(bArr);
                BlePeripheralManager.this.mMessageParser.parseIncomingData(bArr);
                BlePeripheralManager.this.mWriteBuffer.clear();
            }
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onMtuChanged(BluetoothDevice bluetoothDevice, int i10) {
            k.a(BlePeripheralManager.TAG, String.format("onMtuChanged mtu=%d", Integer.valueOf(i10)));
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onNotificationSent(BluetoothDevice bluetoothDevice, int i10) {
            k.a(BlePeripheralManager.TAG, String.format("onNotificationSent status=%d", Integer.valueOf(i10)));
            synchronized (BlePeripheralManager.this.mWriteLock) {
                BlePeripheralManager.this.mWriteLock.notifyAll();
            }
        }

        @Override // android.bluetooth.BluetoothGattServerCallback
        public void onServiceAdded(int i10, BluetoothGattService bluetoothGattService) {
            k.a(BlePeripheralManager.TAG, String.format("onServiceAdded %s", bluetoothGattService.getUuid().toString()));
        }
    }

    /* loaded from: classes2.dex */
    private class BroadcastReceiverImpl extends BroadcastReceiver {
        private BroadcastReceiverImpl() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            k.a(BlePeripheralManager.TAG, "onReceive " + intent.getAction());
            String action = intent.getAction();
            action.hashCode();
            char c10 = 65535;
            switch (action.hashCode()) {
                case -1613316113:
                    if (action.equals(BleProtocol.ACTION_STOP_ADVERTISING)) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1530327060:
                    if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 715230687:
                    if (action.equals(BleProtocol.ACTION_START_ADVERTISING)) {
                        c10 = 2;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    BlePeripheralManager.this.stopAdvertising();
                    return;
                case 1:
                    BlePeripheralManager.this.handleBluetoothAdapterStateChanged(intent);
                    return;
                case 2:
                    BlePeripheralManager.this.startAdvertising();
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface Callback {
        void onConnected(BluetoothDevice bluetoothDevice);

        void onData(byte[] bArr);

        void onDisconnected(BluetoothDevice bluetoothDevice);
    }

    @SuppressLint({"MissingPermission"})
    public BlePeripheralManager(Context context, Callback callback) {
        this.mAppContext = context;
        this.mCallback = callback;
        if (((BluetoothManager) this.mAppContext.getSystemService("bluetooth")).getAdapter().getState() == 12) {
            prepareGattServices();
        }
        MessageParser messageParser = new MessageParser(this);
        this.mMessageParser = messageParser;
        messageParser.setMtu(DEFAULT_MTU);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BleProtocol.ACTION_START_ADVERTISING);
        intentFilter.addAction(BleProtocol.ACTION_STOP_ADVERTISING);
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        context.registerReceiver(new BroadcastReceiverImpl(), intentFilter);
    }

    private void blockingSend(byte[] bArr, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        k.a(TAG, "blockingSend " + bArr.length);
        if (this.mDevice == null) {
            k.q(TAG, "No device connected");
            return;
        }
        bluetoothGattCharacteristic.setValue(bArr);
        this.mGattServer.notifyCharacteristicChanged(this.mDevice, bluetoothGattCharacteristic, false);
        try {
            this.mWriteLock.wait(WRITE_TIMEOUT);
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e10);
        }
    }

    private AdvertiseData buildAdvertiseData() {
        AdvertiseData.Builder builder = new AdvertiseData.Builder();
        builder.setIncludeDeviceName(true);
        builder.addManufacturerData(70, new byte[]{(byte) (Math.round(Math.random() * 254.0d) + 1), (byte) (Math.round(Math.random() * 254.0d) + 1), (byte) (Math.round(Math.random() * 254.0d) + 1)});
        return builder.build();
    }

    private AdvertiseSettings buildAdvertiseSettings() {
        AdvertiseSettings.Builder builder = new AdvertiseSettings.Builder();
        builder.setAdvertiseMode(1);
        builder.setConnectable(true);
        builder.setTimeout(0);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBluetoothAdapterStateChanged(Intent intent) {
        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
        k.a(TAG, "new state " + intExtra);
        if (intExtra == 10) {
            handleDisconnect();
            stopAdvertising();
            BluetoothGattServer bluetoothGattServer = this.mGattServer;
            if (bluetoothGattServer != null) {
                bluetoothGattServer.clearServices();
                this.mGattServer = null;
            }
        } else if (intExtra == 12) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.mobvoi.wear.ble.BlePeripheralManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BlePeripheralManager.this.mGattServer != null) {
                        BlePeripheralManager.this.mGattServer = null;
                    }
                    BlePeripheralManager.this.prepareGattServices();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDisconnect() {
        if (this.mDevice != null) {
            this.mMessageParser.reset();
            this.mCallback.onDisconnected(this.mDevice);
            this.mDevice = null;
            synchronized (this.mWriteLock) {
                this.mWriteLock.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareGattServices() {
        int i10 = 0;
        while (this.mGattServer == null) {
            i10++;
            if (i10 < 3) {
                k.q(TAG, "Gatt server is null, try to get it");
                SystemClock.sleep(1000L);
                BluetoothGattServer openGattServer = ((BluetoothManager) this.mAppContext.getSystemService("bluetooth")).openGattServer(this.mAppContext, this.mGattServerCallback);
                this.mGattServer = openGattServer;
                if (openGattServer != null) {
                    try {
                        BluetoothGattService bluetoothGattService = new BluetoothGattService(UUID.fromString(SERVICE_UUID), 0);
                        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(UUID.fromString(WRITE_CHARACTERISTIC_UUID), 8, 32));
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UUID.fromString(READ_CHARACTERISTIC_UUID), 18, 2);
                        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(UUID.fromString("00002902-0000-1000-8000-00805F9B34FB"), 34));
                        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
                        this.mGattServer.addService(bluetoothGattService);
                    } catch (Exception e10) {
                        k.r(TAG, "Failed to add service", e10, new Object[0]);
                        this.mGattServer = null;
                    }
                }
            } else {
                return;
            }
        }
    }

    public BluetoothDevice getConnectedDevice() {
        return this.mDevice;
    }

    @Override // com.mobvoi.wear.ble.MessageParser.MessageParserCallback
    public void onIncomingData(byte[] bArr) {
        k.a(TAG, "onIncomingData " + bArr.length);
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onData(bArr);
        }
    }

    public void sendData(byte[] bArr) {
        if (this.mDevice == null) {
            k.q(TAG, "No device connected");
            return;
        }
        BluetoothGattCharacteristic characteristic = this.mGattServer.getService(UUID.fromString(SERVICE_UUID)).getCharacteristic(UUID.fromString(READ_CHARACTERISTIC_UUID));
        List<byte[]> packetWriteData = this.mMessageParser.packetWriteData(bArr);
        synchronized (this.mWriteLock) {
            for (byte[] bArr2 : packetWriteData) {
                blockingSend(bArr2, characteristic);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public synchronized void startAdvertising() {
        k.a(TAG, "startAdvertising " + this.mIsAdvertising);
        if (!this.mIsAdvertising) {
            this.mIsAdvertising = true;
            BluetoothAdapter adapter = ((BluetoothManager) this.mAppContext.getSystemService("bluetooth")).getAdapter();
            if (adapter.getState() == 12) {
                adapter.getBluetoothLeAdvertiser().startAdvertising(buildAdvertiseSettings(), buildAdvertiseData(), this.mAdvertiseCallback);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public synchronized void stopAdvertising() {
        k.a(TAG, "stopAdvertising " + this.mIsAdvertising);
        if (this.mIsAdvertising) {
            this.mIsAdvertising = false;
            BluetoothAdapter adapter = ((BluetoothManager) this.mAppContext.getSystemService("bluetooth")).getAdapter();
            if (adapter.getState() == 12) {
                adapter.getBluetoothLeAdvertiser().stopAdvertising(this.mAdvertiseCallback);
            }
        }
    }
}
