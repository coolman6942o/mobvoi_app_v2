package com.paypal.android.sdk;
/* loaded from: classes2.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    private static String f22051a;

    /* renamed from: b  reason: collision with root package name */
    private static long f22052b;

    /* renamed from: c  reason: collision with root package name */
    private static long f22053c;

    public static synchronized void a() {
        synchronized (x.class) {
            f22051a = m0.v(true);
            f22052b = System.currentTimeMillis();
        }
    }

    public static synchronized void b(long j10) {
        synchronized (x.class) {
            f22053c = j10;
        }
    }

    public static synchronized String c() {
        String str;
        synchronized (x.class) {
            if (f22051a == null) {
                a();
            }
            str = f22051a;
        }
        return str;
    }

    public static synchronized boolean d() {
        boolean z10;
        synchronized (x.class) {
            z10 = System.currentTimeMillis() - e() <= f22053c;
        }
        return z10;
    }

    private static synchronized long e() {
        long j10;
        synchronized (x.class) {
            if (f22052b == 0) {
                a();
            }
            j10 = f22052b;
        }
        return j10;
    }
}
