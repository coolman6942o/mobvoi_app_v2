package com.mobvoi.wear.ble;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.p;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
@TargetApi(21)
/* loaded from: classes2.dex */
public class BleCentralHelper {
    private static final long DEFAULT_OPERATION_TIMEOUT = 5000;
    private static final String TAG = "BleCentralHelper";
    private BluetoothGatt mBluetoothGatt;
    private Method mBluetoothGattRefresh;
    private Context mContext;
    private BleCentralHelperDelegate mDelegate;
    private BluetoothException mException;
    private UUID mObjectUuid;
    private boolean mServicesDiscovered;
    private final Object mOperationLock = new Object();
    private Operation mOperation = Operation.NO_OPERATION;
    private BluetoothGattCallback mGattCallback = new BleCentralGattCallback();
    private int mMtuSize = 20;

    /* loaded from: classes2.dex */
    private class BleCentralGattCallback extends BluetoothGattCallback {
        private BleCentralGattCallback() {
        }

        private void checkAndNotify(BluetoothGatt bluetoothGatt, int i10, Operation operation) {
            checkAndNotify(bluetoothGatt, i10, operation, null);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            BleCentralHelper.this.mDelegate.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            checkAndNotify(bluetoothGatt, i10, Operation.READ_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            checkAndNotify(bluetoothGatt, i10, Operation.WRITE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i10, int i11) {
            k.i(BleCentralHelper.TAG, "onConnectionStateChange status=%s, newStats=%s", BleCentralHelper.gattStatusCodeToStr(i10), BleCentralHelper.profileStateToStr(i11));
            synchronized (BleCentralHelper.this.mOperationLock) {
                try {
                } catch (BluetoothException e10) {
                    BleCentralHelper.this.notifyExceptionLocked(e10);
                }
                if (i11 == 0) {
                    BleCentralHelper.this.notifyCompletionLocked();
                    BleCentralHelper.this.mServicesDiscovered = false;
                    BleCentralHelper.this.mBluetoothGatt.close();
                    BleCentralHelper.this.mBluetoothGatt = null;
                    BleCentralHelper.this.mDelegate.onGattDisconnected();
                } else if (i11 == 1) {
                    BleCentralHelper bleCentralHelper = BleCentralHelper.this;
                    Operation operation = Operation.CONNECT;
                    bleCentralHelper.checkGattStatusCodeLocked(bluetoothGatt, i10, operation);
                    BleCentralHelper.this.checkOperationLocked(bluetoothGatt, operation);
                } else if (i11 == 2) {
                    BleCentralHelper.this.mBluetoothGatt = bluetoothGatt;
                    checkAndNotify(bluetoothGatt, i10, Operation.CONNECT);
                    BleCentralHelper.this.mDelegate.onGattConnected(bluetoothGatt.getDevice());
                } else if (i11 == 3) {
                    BleCentralHelper bleCentralHelper2 = BleCentralHelper.this;
                    Operation operation2 = Operation.DISCONNECT;
                    bleCentralHelper2.checkGattStatusCodeLocked(bluetoothGatt, i10, operation2);
                    BleCentralHelper.this.checkOperationLocked(bluetoothGatt, operation2);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            checkAndNotify(bluetoothGatt, i10, Operation.READ_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            checkAndNotify(bluetoothGatt, i10, Operation.WRITE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
            if (i10 == 0) {
                BleCentralHelper.this.mDelegate.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i10, int i11) {
            BleCentralHelper.this.mMtuSize = i10 - 3;
            k.a(BleCentralHelper.TAG, "onMtuChanged to MTU: " + i10);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i10, int i11) {
            checkAndNotify(bluetoothGatt, i11, Operation.READ_REMOTE_RSSI);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i10) {
            checkAndNotify(bluetoothGatt, i10, Operation.DISCOVER_SERVICES);
        }

        private void checkAndNotify(BluetoothGatt bluetoothGatt, int i10, Operation operation, UUID uuid) {
            synchronized (BleCentralHelper.this.mOperationLock) {
                try {
                    BluetoothGatt checkDeviceLocked = BleCentralHelper.this.checkDeviceLocked(bluetoothGatt);
                    BleCentralHelper.this.checkGattStatusCodeLocked(checkDeviceLocked, i10, operation);
                    if (uuid != null) {
                        BleCentralHelper.this.checkObjectUuidLocked(checkDeviceLocked, uuid);
                    }
                    BleCentralHelper.this.checkOperationLocked(checkDeviceLocked, operation);
                    BleCentralHelper.this.notifyCompletionLocked();
                } catch (BluetoothException e10) {
                    BleCentralHelper.this.notifyExceptionLocked(e10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum Operation {
        NO_OPERATION,
        CONNECT,
        DISCONNECT,
        DISCOVER_SERVICES,
        READ_CHARACTERISTIC,
        READ_DESCRIPTOR,
        WRITE_CHARACTERISTIC,
        WRITE_DESCRIPTOR,
        READ_REMOTE_RSSI
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BleCentralHelper(Context context, BleCentralHelperDelegate bleCentralHelperDelegate) {
        this.mContext = context;
        this.mDelegate = bleCentralHelperDelegate;
        if (Build.VERSION.SDK_INT < 28) {
            try {
                this.mBluetoothGattRefresh = p.b(BluetoothGatt.class, "refresh", new Class[0]);
            } catch (Exception e10) {
                k.r(TAG, "Failed to find BluetoothGatt#refresh()", e10, new Object[0]);
            }
        }
    }

    private BluetoothGatt checkConnectedDeviceLocked() throws BluetoothException {
        BluetoothException bluetoothException = this.mException;
        if (bluetoothException == null) {
            BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
            if (bluetoothGatt != null) {
                return bluetoothGatt;
            }
            throw new BluetoothException("Bluetooth gatt not connected");
        }
        try {
            throw bluetoothException;
        } catch (Throwable th2) {
            this.mException = null;
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BluetoothGatt checkDeviceLocked(BluetoothGatt bluetoothGatt) throws BluetoothException {
        if (this.mBluetoothGatt == null) {
            throw new BluetoothException("Received an event from device [%s] when not connected.", bluetoothGatt.getDevice().getAddress());
        } else if (bluetoothGatt.getDevice().equals(this.mBluetoothGatt.getDevice())) {
            return this.mBluetoothGatt;
        } else {
            throw new BluetoothException("Received an event from an unexpected device [%s]. Expected [%s]", bluetoothGatt.getDevice().getAddress(), this.mBluetoothGatt.getDevice().getAddress());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkGattStatusCodeLocked(BluetoothGatt bluetoothGatt, int i10, Operation operation) throws BluetoothException {
        if (i10 == 0) {
            return;
        }
        if (i10 != 15) {
            throw new BluetoothException("Operation [%s] on device [%s] failed: %s", operation, bluetoothGatt.getDevice().getAddress(), gattStatusCodeToStr(i10));
        }
        throw new BluetoothException("Not paired yet");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkObjectUuidLocked(BluetoothGatt bluetoothGatt, UUID uuid) {
        if (this.mObjectUuid == null) {
            k.s(TAG, "Received an unexpected event from characteristic [%s] on device [%s] while expecting operation [%s].", uuid, bluetoothGatt.getDevice().getAddress(), this.mOperation);
        }
        if (!uuid.equals(this.mObjectUuid)) {
            k.s(TAG, "Received from an unexpected characteristic [%s] on device [%s] while expecting operation [%s] and characteristic [%s].", uuid, bluetoothGatt.getDevice().getAddress(), this.mOperation, this.mObjectUuid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkOperationLocked(BluetoothGatt bluetoothGatt, Operation operation) {
        Operation operation2 = this.mOperation;
        if (operation2 != operation) {
            k.s(TAG, "Received result for an operation [%s] while expecting [%s] on device [%s].", operation, operation2, bluetoothGatt.getDevice().getAddress());
        }
    }

    private void discoverServicesLocked() throws BluetoothException {
        BluetoothGatt checkConnectedDeviceLocked = checkConnectedDeviceLocked();
        if (checkConnectedDeviceLocked.discoverServices()) {
            waitForCompletionLocked(checkConnectedDeviceLocked, Operation.DISCOVER_SERVICES);
            this.mServicesDiscovered = true;
            return;
        }
        throw new BluetoothException("Cannot start discovering services on device [%s].", checkConnectedDeviceLocked.getDevice().getAddress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String gattStatusCodeToStr(int i10) {
        if (i10 == 13) {
            return "GATT_INVALID_ATTRIBUTE_LENGTH";
        }
        if (i10 == 15) {
            return "GATT_INSUFFICIENT_ENCRYPTION";
        }
        if (i10 == 128) {
            return "GATT_NO_RESOURCES";
        }
        if (i10 == 257) {
            return "GATT_FAILURE";
        }
        if (i10 == 132) {
            return "GATT_BUSY";
        }
        if (i10 == 133) {
            return "GATT_ERROR";
        }
        switch (i10) {
            case 0:
                return "GATT_SUCCESS";
            case 1:
                return "GATT_INVALID_HANDLE";
            case 2:
                return "GATT_READ_NOT_PERMITTED";
            case 3:
                return "GATT_WRITE_NOT_PERMITTED";
            case 4:
                return "GATT_INVALID_PDU";
            case 5:
                return "GATT_INSUFFICIENT_AUTHENTICATION";
            case 6:
                return "GATT_REQUEST_NOT_SUPPORTED";
            case 7:
                return "GATT_INVALID_OFFSET";
            case 8:
                return "GATT_INSUF_AUTHORIZATION";
            default:
                return String.format(Locale.US, "Unknown-status-code-[0x%x]", Integer.valueOf(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCompletionLocked() {
        k.c(TAG, "notifyCompletion: %s", this.mOperation);
        this.mOperationLock.notify();
        this.mOperation = Operation.NO_OPERATION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyExceptionLocked(BluetoothException bluetoothException) {
        k.s(TAG, "notifyException: %s", bluetoothException.toString());
        this.mException = bluetoothException;
        notifyCompletionLocked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String profileStateToStr(int i10) {
        if (i10 == 0) {
            return "DISCONNECTED";
        }
        if (i10 == 1) {
            return "CONNECTING";
        }
        if (i10 == 2) {
            return "CONNECTED";
        }
        if (i10 == 3) {
            return "DISCONNECTING";
        }
        return "unknown-state-[" + i10 + "]";
    }

    private void waitForCompletionLocked(BluetoothGatt bluetoothGatt, Operation operation) throws BluetoothException {
        waitForCompletionLocked(bluetoothGatt, operation, null, DEFAULT_OPERATION_TIMEOUT);
    }

    public void connectGatt(BluetoothDevice bluetoothDevice) throws BluetoothException {
        k.i(TAG, "connectGatt: %s", bluetoothDevice);
        synchronized (this.mOperationLock) {
            this.mOperation = Operation.CONNECT;
            BluetoothGatt connectGatt = bluetoothDevice.connectGatt(this.mContext, false, this.mGattCallback);
            this.mBluetoothGatt = connectGatt;
            if (connectGatt == null) {
                k.f(TAG, "Failed to connect to gatt server [%s]", bluetoothDevice);
                throw new BluetoothException("Failed to initialize gatt");
            }
        }
    }

    public void disconnectGatt(String str) throws BluetoothException {
        k.c(TAG, "disconnectGatt, reason: %s", str);
        synchronized (this.mOperationLock) {
            try {
                if (this.mBluetoothGatt != null) {
                    BluetoothManager bluetoothManager = (BluetoothManager) this.mContext.getSystemService("bluetooth");
                    if (bluetoothManager != null) {
                        int connectionState = bluetoothManager.getConnectionState(this.mBluetoothGatt.getDevice(), 7);
                        if (!(connectionState == 2 || connectionState == 1)) {
                            throw new BluetoothException("Bluetooth is not connected");
                        }
                        this.mBluetoothGatt.disconnect();
                        waitForCompletionLocked(this.mBluetoothGatt, Operation.DISCONNECT);
                    } else {
                        throw new BluetoothException("Failed to get BluetoothManager");
                    }
                }
                BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
                if (bluetoothGatt != null) {
                    bluetoothGatt.close();
                    this.mBluetoothGatt = null;
                }
                this.mServicesDiscovered = false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void enableCharacteristicNotification(BluetoothGattCharacteristic bluetoothGattCharacteristic) throws BluetoothException {
        synchronized (this.mOperationLock) {
            BluetoothGatt checkConnectedDeviceLocked = checkConnectedDeviceLocked();
            if (!checkConnectedDeviceLocked.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                throw new BluetoothException("Failed to enable characteristic notification [%s] on device [%s].", bluetoothGattCharacteristic.getUuid(), checkConnectedDeviceLocked.getDevice().getAddress());
            }
        }
    }

    public int getMtu() {
        return this.mMtuSize;
    }

    public BluetoothGattService getService(UUID uuid) throws BluetoothException {
        BluetoothGattService service;
        synchronized (this.mOperationLock) {
            BluetoothGatt checkConnectedDeviceLocked = checkConnectedDeviceLocked();
            if (this.mServicesDiscovered) {
                service = checkConnectedDeviceLocked.getService(uuid);
                if (service == null) {
                    throw new BluetoothException("GATT service %s not found", uuid);
                }
            } else {
                throw new BluetoothException("Run service discovery first");
            }
        }
        return service;
    }

    public List<BluetoothGattService> getServices() throws BluetoothException {
        List<BluetoothGattService> services;
        k.a(TAG, "getServices");
        synchronized (this.mOperationLock) {
            BluetoothGatt checkConnectedDeviceLocked = checkConnectedDeviceLocked();
            if (!this.mServicesDiscovered) {
                discoverServicesLocked();
            }
            services = checkConnectedDeviceLocked.getServices();
        }
        return services;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void prepareForServiceDiscovery() {
        BluetoothGatt bluetoothGatt;
        synchronized (this.mOperationLock) {
            Method method = this.mBluetoothGattRefresh;
            if (!(method == null || (bluetoothGatt = this.mBluetoothGatt) == null)) {
                try {
                    method.invoke(bluetoothGatt, new Object[0]);
                } catch (Exception e10) {
                    k.r(TAG, "Failed to invoke BluetoothGatt#refresh()", e10, new Object[0]);
                }
            }
            this.mServicesDiscovered = false;
        }
    }

    public void writeCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) throws BluetoothException {
        synchronized (this.mOperationLock) {
            BluetoothGatt checkConnectedDeviceLocked = checkConnectedDeviceLocked();
            if (!bluetoothGattCharacteristic.setValue(bArr) || !checkConnectedDeviceLocked.writeCharacteristic(bluetoothGattCharacteristic)) {
                throw new BluetoothException("Cannot write characteristic %s on device %s.", bluetoothGattCharacteristic, checkConnectedDeviceLocked.getDevice().getAddress());
            }
            waitForCompletionLocked(checkConnectedDeviceLocked, Operation.WRITE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        }
    }

    public void writeDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor) throws BluetoothException {
        synchronized (this.mOperationLock) {
            BluetoothGatt checkConnectedDeviceLocked = checkConnectedDeviceLocked();
            if (this.mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor)) {
                waitForCompletionLocked(checkConnectedDeviceLocked, Operation.WRITE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
            } else {
                throw new BluetoothException("Cannot write descriptor %s on device %s.", bluetoothGattDescriptor, checkConnectedDeviceLocked.getDevice().getAddress());
            }
        }
    }

    private void waitForCompletionLocked(BluetoothGatt bluetoothGatt, Operation operation, UUID uuid) throws BluetoothException {
        waitForCompletionLocked(bluetoothGatt, operation, uuid, DEFAULT_OPERATION_TIMEOUT);
    }

    private void waitForCompletionLocked(BluetoothGatt bluetoothGatt, Operation operation, UUID uuid, long j10) throws BluetoothException {
        k.c(TAG, "waitForCompletion [%s]", operation);
        try {
            try {
                this.mOperation = operation;
                this.mObjectUuid = uuid;
                this.mException = null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.mOperationLock.wait(j10);
                Operation operation2 = this.mOperation;
                Operation operation3 = Operation.NO_OPERATION;
                if (operation2 == operation3) {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    k.c(TAG, "waitForCompletion [%s] completed, time used: %dms", operation, Long.valueOf(elapsedRealtime2));
                    if (elapsedRealtime2 > 1000) {
                        k.s(TAG, "found longtime waiting %dms", Long.valueOf(elapsedRealtime2));
                    }
                    BluetoothException bluetoothException = this.mException;
                    if (bluetoothException == null) {
                        this.mOperation = operation3;
                        this.mObjectUuid = null;
                        this.mException = null;
                        return;
                    }
                    throw bluetoothException;
                }
                throw new BluetoothException("Operation [%s] on device [%s] timed out after %dms.", operation, bluetoothGatt.getDevice().getAddress(), Long.valueOf(j10));
            } catch (InterruptedException e10) {
                throw new RuntimeException(e10);
            }
        } catch (Throwable th2) {
            this.mOperation = Operation.NO_OPERATION;
            this.mObjectUuid = null;
            this.mException = null;
            throw th2;
        }
    }
}
