package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class d2 {

    /* renamed from: a  reason: collision with root package name */
    private static Map f21104a = new HashMap();

    public static dt a(String str) {
        dt dtVar = (dt) f21104a.get(str);
        Objects.toString(dtVar);
        return dtVar;
    }

    public static void b(dt dtVar, String str) {
        f21104a.put(str, dtVar);
        Objects.toString(dtVar);
    }

    public static void c(String str) {
        f21104a.remove(str);
    }
}
