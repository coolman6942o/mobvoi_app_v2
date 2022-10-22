package com.laser.tsm.sdk.apdu;
/* loaded from: classes2.dex */
public enum EnumDeviceType {
    DEVICE_TYPE_MOBILE(1),
    DEVICE_TYPE_MULTI_BLUETOOTH(2),
    DEVICE_TYPE_BLUETOOTH(3);
    
    private int value;

    EnumDeviceType(int i10) {
        this.value = i10;
    }

    public int getValue() {
        return this.value;
    }
}
