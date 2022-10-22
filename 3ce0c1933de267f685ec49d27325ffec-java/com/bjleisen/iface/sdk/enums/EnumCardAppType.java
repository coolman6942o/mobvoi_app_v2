package com.bjleisen.iface.sdk.enums;
/* loaded from: classes.dex */
public enum EnumCardAppType {
    CARD_APP_TYPE_SZT(0),
    CARD_APP_TYPE_BJT(1),
    CARD_APP_TYPE_WHT(2),
    CARD_APP_TYPE_TFT(3),
    CARD_APP_TYPE_TJT(4),
    CARD_APP_TYPE_WHT2(5),
    CARD_APP_TYPE_HCT(6),
    CARD_APP_TYPE_SHT(7);
    
    private int value;

    EnumCardAppType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
