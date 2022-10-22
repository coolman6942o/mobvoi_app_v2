package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.E;
import com.huawei.hms.scankit.util.a;
import java.util.Stack;
/* compiled from: GlobalVariable.java */
/* loaded from: classes2.dex */
public class Ka {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f14563a = true;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f14565c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f14566d = false;

    /* renamed from: e  reason: collision with root package name */
    public static float f14567e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    public static int f14568f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f14569g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f14570h = false;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f14571i = false;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f14572j = false;

    /* renamed from: k  reason: collision with root package name */
    public static boolean f14573k = false;

    /* renamed from: l  reason: collision with root package name */
    public static boolean f14574l = false;

    /* renamed from: m  reason: collision with root package name */
    public static boolean f14575m = false;

    /* renamed from: n  reason: collision with root package name */
    public static boolean f14576n = false;

    /* renamed from: o  reason: collision with root package name */
    public static boolean f14577o = false;

    /* renamed from: p  reason: collision with root package name */
    public static boolean f14578p = false;

    /* renamed from: q  reason: collision with root package name */
    public static boolean[] f14579q = new boolean[8];

    /* renamed from: r  reason: collision with root package name */
    public static Stack<Integer> f14580r = new Stack<>();

    /* renamed from: s  reason: collision with root package name */
    public static boolean f14581s = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f14564b = true;

    static {
        a.c("BUILDING FLAG", "use lite sdk");
    }

    public static void a() {
        f14566d = false;
        f14567e = -1.0f;
        f14568f = 0;
        f14573k = false;
        f14574l = false;
        f14575m = false;
        f14577o = false;
        f14570h = false;
        f14571i = false;
        f14572j = false;
        f14576n = false;
        f14579q = new boolean[8];
        f14580r = new Stack<>();
        f14581s = true;
    }

    public static void a(int i10) {
        if (i10 % 2 == 1) {
            f14573k = true;
        }
        if (i10 % 3 == 2) {
            f14574l = true;
        }
        if (i10 % 5 == 4) {
            f14575m = true;
        }
    }

    public static void a(E e10) {
        a();
        boolean z10 = e10.f14076e;
        f14565c = z10;
        f14581s = e10.f14078g;
        if (!z10) {
            a(e10.f14077f);
        } else {
            a(1);
        }
    }
}
