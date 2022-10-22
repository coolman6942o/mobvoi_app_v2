package com.tendcloud.tenddata;

import android.content.Context;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class bv {
    public static boolean a() {
        try {
            if (!bk.a()) {
                return false;
            }
            Class.forName("com.android.id.impl.IdProviderImpl");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void reflectMiUi(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            Object newInstance = cls.newInstance();
            try {
                co.a().setUDID((String) cls.getMethod("getUDID", Context.class).invoke(newInstance, context));
            } catch (Throwable unused) {
            }
            try {
                co.a().setOAID((String) cls.getMethod("getOAID", Context.class).invoke(newInstance, context));
            } catch (Throwable unused2) {
            }
            try {
                co.a().setVAID((String) cls.getMethod("getVAID", Context.class).invoke(newInstance, context));
            } catch (Throwable unused3) {
            }
            co.a().setAAID((String) cls.getMethod("getAAID", Context.class).invoke(newInstance, context));
        } catch (Throwable unused4) {
        }
    }
}
