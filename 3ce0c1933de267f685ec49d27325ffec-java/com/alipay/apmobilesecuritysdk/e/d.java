package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import c4.a;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d {
    public static c a(String str) {
        try {
            if (!a.d(str)) {
                JSONObject jSONObject = new JSONObject(str);
                return new c(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"), jSONObject.optString("tid"), jSONObject.optString("utdid"));
            }
        } catch (Exception e10) {
            com.alipay.apmobilesecuritysdk.c.a.a(e10);
        }
        return null;
    }

    public static synchronized void a() {
        synchronized (d.class) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", "");
            com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", "");
        }
    }

    public static synchronized void a(Context context, c cVar) {
        synchronized (d.class) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apdid", cVar.f6819a);
                jSONObject.put("deviceInfoHash", cVar.f6820b);
                jSONObject.put("timestamp", cVar.f6821c);
                jSONObject.put("tid", cVar.f6822d);
                jSONObject.put("utdid", cVar.f6823e);
                String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", jSONObject2);
            } catch (Exception e10) {
                com.alipay.apmobilesecuritysdk.c.a.a(e10);
            }
        }
    }

    public static synchronized c b() {
        synchronized (d.class) {
            String a10 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
            if (a.d(a10)) {
                return null;
            }
            return a(a10);
        }
    }

    public static synchronized c b(Context context) {
        c a10;
        synchronized (d.class) {
            String a11 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
            if (a.d(a11)) {
                a11 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
            }
            a10 = a(a11);
        }
        return a10;
    }

    public static synchronized c c(Context context) {
        synchronized (d.class) {
            String a10 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
            if (a.d(a10)) {
                return null;
            }
            return a(a10);
        }
    }
}
