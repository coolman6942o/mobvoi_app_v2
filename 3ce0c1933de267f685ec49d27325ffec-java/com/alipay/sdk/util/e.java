package com.alipay.sdk.util;

import com.mobvoi.wear.common.base.Constants;
/* loaded from: classes.dex */
public enum e {
    WIFI(0, "WIFI"),
    NETWORK_TYPE_1(1, "unicom2G"),
    NETWORK_TYPE_2(2, "mobile2G"),
    NETWORK_TYPE_4(4, "telecom2G"),
    NETWORK_TYPE_5(5, "telecom3G"),
    NETWORK_TYPE_6(6, "telecom3G"),
    NETWORK_TYPE_12(12, "telecom3G"),
    NETWORK_TYPE_8(8, "unicom3G"),
    NETWORK_TYPE_3(3, "unicom3G"),
    NETWORK_TYPE_13(13, "LTE"),
    NETWORK_TYPE_11(11, "IDEN"),
    NETWORK_TYPE_9(9, "HSUPA"),
    NETWORK_TYPE_10(10, "HSPA"),
    NETWORK_TYPE_15(15, "HSPAP"),
    NETWORK_TYPE_20(20, "5G"),
    NONE(-1, Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_NONE);
    

    /* renamed from: a  reason: collision with root package name */
    public int f6955a;

    /* renamed from: b  reason: collision with root package name */
    public String f6956b;

    e(int i10, String str) {
        this.f6955a = i10;
        this.f6956b = str;
    }

    public final int a() {
        return this.f6955a;
    }

    public final String b() {
        return this.f6956b;
    }

    public static e a(int i10) {
        e[] values;
        for (e eVar : values()) {
            if (eVar.a() == i10) {
                return eVar;
            }
        }
        return NONE;
    }
}
