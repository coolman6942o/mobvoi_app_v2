package com.bjleisen.iface.sdk.enums;
/* loaded from: classes.dex */
public enum EnumEnvType {
    ENV_DEV(1),
    ENV_BETA(2),
    ENV_PRD(3),
    ENV_BETA_BJ(4);
    
    private int value;

    EnumEnvType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
