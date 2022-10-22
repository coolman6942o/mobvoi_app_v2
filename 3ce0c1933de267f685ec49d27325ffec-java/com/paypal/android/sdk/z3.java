package com.paypal.android.sdk;

import java.util.Set;
/* loaded from: classes2.dex */
public final class z3 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f22069a;

    /* renamed from: b  reason: collision with root package name */
    private static final h4 f22070b = new h4(ft.class, m5.f21462a);

    /* renamed from: c  reason: collision with root package name */
    private static Set f22071c = new a4();

    public static String a(ft ftVar) {
        return f22070b.b(ftVar);
    }

    public static String b(String str) {
        return str.equals(by.DEVICE_OS_TOO_OLD.toString()) ? f22070b.b(ft.ANDROID_OS_TOO_OLD) : str.equals(by.SERVER_COMMUNICATION_ERROR.toString()) ? f22070b.b(ft.SERVER_PROBLEM) : str.equals(by.INTERNAL_SERVER_ERROR.toString()) ? f22070b.c("INTERNAL_SERVICE_ERROR", ft.SYSTEM_ERROR_WITH_CODE) : str.equals(by.PARSE_RESPONSE_ERROR.toString()) ? f22070b.b(ft.PP_SERVICE_ERROR_JSON_PARSE_ERROR) : f22070b.c(str, ft.SYSTEM_ERROR_WITH_CODE);
    }

    public static void c(String str) {
        f22070b.d(str);
        f22069a = y1.m(str) && f22071c.contains(str);
    }

    public static String d(String str) {
        String a10 = f22070b.a();
        if (a10.contains("_")) {
            return a10;
        }
        return a10 + "_" + str;
    }
}
