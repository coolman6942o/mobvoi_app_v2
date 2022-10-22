package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.c.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class d {
    public static synchronized Map<String, String> a() {
        HashMap hashMap;
        synchronized (d.class) {
            hashMap = new HashMap();
            try {
                new b();
                hashMap.put("AE16", "");
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    public static synchronized Map<String, String> a(Context context) {
        HashMap hashMap;
        synchronized (d.class) {
            e4.d.a();
            e4.b.d();
            hashMap = new HashMap();
            hashMap.put("AE1", e4.d.d());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e4.d.e() ? "1" : "0");
            hashMap.put("AE2", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(e4.d.c(context) ? "1" : "0");
            hashMap.put("AE3", sb3.toString());
            hashMap.put("AE4", e4.d.f());
            hashMap.put("AE5", e4.d.g());
            hashMap.put("AE6", e4.d.h());
            hashMap.put("AE7", e4.d.i());
            hashMap.put("AE8", e4.d.j());
            hashMap.put("AE9", e4.d.k());
            hashMap.put("AE10", e4.d.l());
            hashMap.put("AE11", e4.d.m());
            hashMap.put("AE12", e4.d.n());
            hashMap.put("AE13", e4.d.o());
            hashMap.put("AE14", e4.d.p());
            hashMap.put("AE15", e4.d.q());
            hashMap.put("AE21", e4.b.n());
        }
        return hashMap;
    }
}
