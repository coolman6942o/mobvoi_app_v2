package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static b a(String str) {
        try {
            if (!c4.a.d(str)) {
                JSONObject jSONObject = new JSONObject(str);
                return new b(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"));
            }
        } catch (Exception e10) {
            com.alipay.apmobilesecuritysdk.c.a.a(e10);
        }
        return null;
    }

    public static synchronized void a() {
        synchronized (a.class) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid", "");
            com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx", "");
        }
    }

    public static synchronized void a(Context context, b bVar) {
        synchronized (a.class) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apdid", bVar.f6816a);
                jSONObject.put("deviceInfoHash", bVar.f6817b);
                jSONObject.put("timestamp", bVar.f6818c);
                String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid", jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx", jSONObject2);
            } catch (Exception e10) {
                com.alipay.apmobilesecuritysdk.c.a.a(e10);
            }
        }
    }

    public static synchronized b b() {
        synchronized (a.class) {
            String a10 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
            if (c4.a.d(a10)) {
                return null;
            }
            return a(a10);
        }
    }

    public static synchronized b b(Context context) {
        b a10;
        synchronized (a.class) {
            String a11 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid");
            if (c4.a.d(a11)) {
                a11 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
            }
            a10 = a(a11);
        }
        return a10;
    }

    public static synchronized b c(Context context) {
        synchronized (a.class) {
            String a10 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid");
            if (c4.a.d(a10)) {
                return null;
            }
            return a(a10);
        }
    }
}
