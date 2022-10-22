package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import c4.a;
import com.mobvoi.wear.util.LogCleaner;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static String f6830a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f6831b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f6832c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f6833d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f6834e = "";

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, String> f6835f = new HashMap();

    public static synchronized String a(String str) {
        synchronized (i.class) {
            String str2 = "apdidTokenCache" + str;
            if (f6835f.containsKey(str2)) {
                String str3 = f6835f.get(str2);
                if (a.g(str3)) {
                    return str3;
                }
            }
            return "";
        }
    }

    public static synchronized void a() {
        synchronized (i.class) {
        }
    }

    public static synchronized void a(b bVar) {
        synchronized (i.class) {
            if (bVar != null) {
                f6830a = bVar.f6816a;
                f6831b = bVar.f6817b;
                f6832c = bVar.f6818c;
            }
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (i.class) {
            if (cVar != null) {
                f6830a = cVar.f6819a;
                f6831b = cVar.f6820b;
                f6833d = cVar.f6822d;
                f6834e = cVar.f6823e;
                f6832c = cVar.f6821c;
            }
        }
    }

    public static synchronized void a(String str, String str2) {
        synchronized (i.class) {
            String str3 = "apdidTokenCache" + str;
            if (f6835f.containsKey(str3)) {
                f6835f.remove(str3);
            }
            f6835f.put(str3, str2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
        if (r1 < 0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(Context context, String str) {
        long j10;
        boolean z10;
        synchronized (i.class) {
            try {
                j10 = h.a(context);
            } catch (Throwable unused) {
            }
        }
        return z10;
        z10 = false;
        return z10;
        j10 = LogCleaner.ONE_DAY;
        try {
        } catch (Throwable th2) {
            com.alipay.apmobilesecuritysdk.c.a.a(th2);
        }
        if (Math.abs(System.currentTimeMillis() - h.h(context, str)) < j10) {
            z10 = true;
            return z10;
        }
        z10 = false;
        return z10;
    }

    public static synchronized String b() {
        String str;
        synchronized (i.class) {
            str = f6830a;
        }
        return str;
    }

    public static void b(String str) {
        f6830a = str;
    }

    public static synchronized String c() {
        String str;
        synchronized (i.class) {
            str = f6831b;
        }
        return str;
    }

    public static void c(String str) {
        f6831b = str;
    }

    public static synchronized String d() {
        String str;
        synchronized (i.class) {
            str = f6833d;
        }
        return str;
    }

    public static void d(String str) {
        f6832c = str;
    }

    public static synchronized String e() {
        String str;
        synchronized (i.class) {
            str = f6834e;
        }
        return str;
    }

    public static void e(String str) {
        f6833d = str;
    }

    public static synchronized String f() {
        String str;
        synchronized (i.class) {
            str = f6832c;
        }
        return str;
    }

    public static void f(String str) {
        f6834e = str;
    }

    public static synchronized c g() {
        c cVar;
        synchronized (i.class) {
            cVar = new c(f6830a, f6831b, f6832c, f6833d, f6834e);
        }
        return cVar;
    }

    public static void h() {
        f6835f.clear();
        f6830a = "";
        f6831b = "";
        f6833d = "";
        f6834e = "";
        f6832c = "";
    }
}
