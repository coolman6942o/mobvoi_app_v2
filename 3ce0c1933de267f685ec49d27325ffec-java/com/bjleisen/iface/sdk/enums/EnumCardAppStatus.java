package com.bjleisen.iface.sdk.enums;
/* loaded from: classes.dex */
public enum EnumCardAppStatus {
    CARD_STATUS_OK(0),
    CARD_STATUS_INVALID_DATE(1),
    CARD_STATUS_BLACKLIST(2),
    CARD_STATUS_DISABLE(3),
    CARD_STATUS_WALLET_ERROR(4),
    CARD_STATUS_UNENABLED_DATE(5),
    CARD_STATUS_OUT_DATE(6),
    CARD_STATUS_APPLET_NO_EXIST(7),
    CARD_STATUS_UNKNOWN(8);
    
    private int value;

    EnumCardAppStatus(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
