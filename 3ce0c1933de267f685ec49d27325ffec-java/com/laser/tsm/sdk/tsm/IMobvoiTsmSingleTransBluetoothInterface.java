package com.laser.tsm.sdk.tsm;

import com.laser.tsm.sdk.bean.DeviceInfo;
/* loaded from: classes2.dex */
public interface IMobvoiTsmSingleTransBluetoothInterface {
    void closeSEChannel();

    int connectBluetoothDevice(DeviceInfo deviceInfo);

    void disconnectBluetoothDevice();

    int getDeviceInfo(DeviceInfo deviceInfo);

    boolean queryBluetoothState();

    byte[] transiveAPDU(byte[] bArr);
}
