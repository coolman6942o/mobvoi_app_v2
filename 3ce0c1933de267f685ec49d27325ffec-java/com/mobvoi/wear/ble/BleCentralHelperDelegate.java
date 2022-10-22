package com.mobvoi.wear.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
/* loaded from: classes2.dex */
public interface BleCentralHelperDelegate {
    void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic);

    void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor);

    void onGattConnected(BluetoothDevice bluetoothDevice);

    void onGattDisconnected();
}
