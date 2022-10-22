package com.airbnb.lottie;

import g0.j;
/* compiled from: L.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6417a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f6418b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f6419c;

    /* renamed from: d  reason: collision with root package name */
    private static long[] f6420d;

    /* renamed from: e  reason: collision with root package name */
    private static int f6421e;

    /* renamed from: f  reason: collision with root package name */
    private static int f6422f;

    public static void a(String str) {
        if (f6418b) {
            int i10 = f6421e;
            if (i10 == 20) {
                f6422f++;
                return;
            }
            f6419c[i10] = str;
            f6420d[i10] = System.nanoTime();
            j.a(str);
            f6421e++;
        }
    }

    public static float b(String str) {
        int i10 = f6422f;
        if (i10 > 0) {
            f6422f = i10 - 1;
            return 0.0f;
        } else if (!f6418b) {
            return 0.0f;
        } else {
            int i11 = f6421e - 1;
            f6421e = i11;
            if (i11 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(f6419c[i11])) {
                j.b();
                return ((float) (System.nanoTime() - f6420d[f6421e])) / 1000000.0f;
            } else {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f6419c[f6421e] + ".");
            }
        }
    }
}
