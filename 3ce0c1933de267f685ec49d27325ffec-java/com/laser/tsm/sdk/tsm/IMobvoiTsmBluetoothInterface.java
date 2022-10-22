package com.laser.tsm.sdk.tsm;

import com.laser.tsm.sdk.bean.Capdu;
import com.laser.tsm.sdk.bean.DeviceInfo;
import com.laser.tsm.sdk.bean.Rapdu;
import java.util.List;
/* loaded from: classes2.dex */
public interface IMobvoiTsmBluetoothInterface {
    void closeSEChannel();

    int connectBluetoothDevice(DeviceInfo deviceInfo);

    void disconnectBluetoothDevice();

    int getDeviceInfo(DeviceInfo deviceInfo);

    boolean queryBluetoothState();

    List<Rapdu> transiveAPDU(List<Capdu> list);
}
