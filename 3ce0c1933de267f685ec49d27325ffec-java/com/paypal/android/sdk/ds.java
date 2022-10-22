package com.paypal.android.sdk;
/* loaded from: classes2.dex */
public enum ds {
    AMEX,
    DINERSCLUB,
    DISCOVER,
    JCB,
    MASTERCARD,
    VISA,
    MAESTRO,
    UNKNOWN,
    INSUFFICIENT_DIGITS;

    public static ds a(String str) {
        ds[] values;
        if (str == null) {
            return UNKNOWN;
        }
        for (ds dsVar : values()) {
            if (!(dsVar == UNKNOWN || dsVar == INSUFFICIENT_DIGITS || !str.equalsIgnoreCase(dsVar.toString()))) {
                return dsVar;
            }
        }
        return UNKNOWN;
    }
}
