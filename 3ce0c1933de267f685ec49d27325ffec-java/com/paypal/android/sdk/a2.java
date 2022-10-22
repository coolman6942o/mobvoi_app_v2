package com.paypal.android.sdk;

import java.util.Locale;
/* loaded from: classes2.dex */
public final class a2 implements c3 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a2 f20974a;

    private a2() {
    }

    public static a2 a() {
        if (f20974a == null) {
            synchronized (a2.class) {
                if (f20974a == null) {
                    f20974a = new a2();
                }
            }
        }
        return f20974a;
    }

    @Override // com.paypal.android.sdk.c3
    public final String a(String str) {
        return str;
    }

    @Override // com.paypal.android.sdk.c3
    public final Locale b() {
        return Locale.getDefault();
    }

    @Override // com.paypal.android.sdk.c3
    public final ef c() {
        return new ef(Locale.getDefault().getCountry());
    }

    @Override // com.paypal.android.sdk.c3
    public final ef d() {
        return c();
    }
}
