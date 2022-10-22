package com.alipay.android.phone.mrpc.core;

import android.content.Context;
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f6794a;

    public static final boolean a(Context context) {
        Boolean bool = f6794a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0);
            f6794a = valueOf;
            return valueOf.booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
