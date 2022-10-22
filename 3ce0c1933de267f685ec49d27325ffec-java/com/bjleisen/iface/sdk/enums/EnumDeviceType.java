package com.bjleisen.iface.sdk.enums;
/* loaded from: classes.dex */
public enum EnumDeviceType {
    DEVICE_TYPE_MOBILE(1),
    DEVICE_TYPE_BLUETOOTH(2),
    DEVICE_TYPE_NFC(3),
    DEVICE_TYPE_MULTI_BLUETOOTH(4),
    DEVICE_TYPE_PARTENER(5);
    
    private int value;

    EnumDeviceType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
