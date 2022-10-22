package com.bjleisen.bluetooth;

import com.bjleisen.iface.sdk.bean.Capdu;
import com.bjleisen.iface.sdk.bean.Rapdu;
import java.util.List;
/* loaded from: classes.dex */
public interface IMultiBluetoothInterface {
    void closeSEChannel();

    int connectBluetoothDevice(DeviceInfo deviceInfo);

    void disconnectBluetoothDevice();

    int getDeviceInfo(DeviceInfo deviceInfo);

    boolean queryBluetoothState();

    List<Rapdu> transiveAPDU(List<Capdu> list);
}
