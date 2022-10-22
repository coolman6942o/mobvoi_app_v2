package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import c4.a;
import d4.c;
import f4.e;
/* loaded from: classes.dex */
public final class g {
    public static synchronized String a(Context context, String str) {
        synchronized (g.class) {
            String a10 = e.a(context, "openapi_file_pri", "openApi" + str, "");
            if (a.d(a10)) {
                return "";
            }
            String e10 = c.e(c.a(), a10);
            return a.d(e10) ? "" : e10;
        }
    }

    public static synchronized void a() {
        synchronized (g.class) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (g.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (edit != null) {
                edit.clear();
                edit.commit();
            }
        }
    }

    public static synchronized void a(Context context, String str, String str2) {
        synchronized (g.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
                if (edit != null) {
                    edit.putString("openApi" + str, c.b(c.a(), str2));
                    edit.commit();
                }
            } catch (Throwable unused) {
            }
        }
    }
}
