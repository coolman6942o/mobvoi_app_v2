package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import c4.a;
import com.alipay.apmobilesecuritysdk.e.h;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class b {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap hashMap;
        synchronized (b.class) {
            hashMap = new HashMap();
            String c10 = a.c(map, "tid", "");
            String c11 = a.c(map, "utdid", "");
            String c12 = a.c(map, "userId", "");
            String c13 = a.c(map, "appName", "");
            String c14 = a.c(map, "appKeyClient", "");
            String c15 = a.c(map, "tmxSessionId", "");
            String f10 = h.f(context);
            String c16 = a.c(map, "sessionId", "");
            hashMap.put("AC1", c10);
            hashMap.put("AC2", c11);
            hashMap.put("AC3", "");
            hashMap.put("AC4", f10);
            hashMap.put("AC5", c12);
            hashMap.put("AC6", c15);
            hashMap.put("AC7", "");
            hashMap.put("AC8", c13);
            hashMap.put("AC9", c14);
            if (a.g(c16)) {
                hashMap.put("AC10", c16);
            }
        }
        return hashMap;
    }
}
