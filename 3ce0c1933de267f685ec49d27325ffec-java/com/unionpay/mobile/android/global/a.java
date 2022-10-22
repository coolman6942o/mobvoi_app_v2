package com.unionpay.mobile.android.global;

import android.content.Context;
import com.unionpay.mobile.android.utils.g;
/* loaded from: classes2.dex */
public final class a {
    public static int A = 45;
    public static int B = 32;
    public static int C = 6;
    public static int D = 25;
    public static int E = 95;
    public static int F = 25;
    public static int G = 25;
    public static int H = 1;
    public static int I = 0;
    public static int J = 5;
    public static int K = 1;
    public static boolean L = true;
    public static int M = 0;
    public static int N = 0;
    private static boolean O = false;

    /* renamed from: a  reason: collision with root package name */
    public static int f23310a = 48;

    /* renamed from: b  reason: collision with root package name */
    public static int f23311b = 8;

    /* renamed from: c  reason: collision with root package name */
    public static int f23312c = 4;

    /* renamed from: d  reason: collision with root package name */
    public static int f23313d = 12;

    /* renamed from: e  reason: collision with root package name */
    public static int f23314e = 8;

    /* renamed from: f  reason: collision with root package name */
    public static int f23315f = 8;

    /* renamed from: g  reason: collision with root package name */
    public static int f23316g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static int f23317h = 8;

    /* renamed from: i  reason: collision with root package name */
    public static int f23318i = 2;

    /* renamed from: j  reason: collision with root package name */
    public static int f23319j = 16;

    /* renamed from: k  reason: collision with root package name */
    public static int f23320k = 52;

    /* renamed from: l  reason: collision with root package name */
    public static int f23321l = 320;

    /* renamed from: m  reason: collision with root package name */
    public static int f23322m = 32;

    /* renamed from: n  reason: collision with root package name */
    public static int f23323n = 54;

    /* renamed from: o  reason: collision with root package name */
    public static int f23324o = 45;

    /* renamed from: p  reason: collision with root package name */
    public static int f23325p = 35;

    /* renamed from: q  reason: collision with root package name */
    public static int f23326q = 40;

    /* renamed from: r  reason: collision with root package name */
    public static int f23327r = 54;

    /* renamed from: s  reason: collision with root package name */
    public static int f23328s = 10;

    /* renamed from: t  reason: collision with root package name */
    public static int f23329t = 0;

    /* renamed from: u  reason: collision with root package name */
    public static int f23330u = 28;

    /* renamed from: v  reason: collision with root package name */
    public static int f23331v = 30;

    /* renamed from: w  reason: collision with root package name */
    public static int f23332w = 22;

    /* renamed from: x  reason: collision with root package name */
    public static int f23333x = 40;

    /* renamed from: y  reason: collision with root package name */
    public static int f23334y = 54;

    /* renamed from: z  reason: collision with root package name */
    public static int f23335z = 46;

    public static void a(Context context) {
        b.a(context);
        if (!O) {
            f23310a = g.a(context, f23310a);
            f23311b = g.a(context, f23311b);
            f23312c = g.a(context, f23312c);
            f23313d = g.a(context, f23313d);
            f23314e = g.a(context, f23314e);
            f23315f = g.a(context, f23315f);
            f23316g = g.a(context, f23316g);
            f23317h = g.a(context, f23317h);
            f23318i = g.a(context, f23318i);
            f23319j = g.a(context, f23319j);
            f23320k = g.a(context, f23320k);
            f23322m = g.a(context, f23322m);
            f23323n = g.a(context, f23323n);
            f23324o = g.a(context, f23324o);
            f23325p = g.a(context, f23325p);
            f23326q = g.a(context, f23326q);
            f23327r = g.a(context, f23327r);
            f23328s = g.a(context, f23328s);
            f23330u = g.a(context, f23330u);
            f23331v = g.a(context, f23331v);
            f23332w = g.a(context, f23332w);
            f23335z = g.a(context, f23335z);
            f23333x = g.a(context, f23333x);
            A = g.a(context, A);
            B = g.a(context, B);
            C = g.a(context, C);
            f23334y = g.a(context, f23334y);
            D = g.a(context, D);
            E = g.a(context, E);
            F = g.a(context, F);
            G = g.a(context, G);
            H = g.a(context, H);
            K = (int) (context.getResources().getDisplayMetrics().density + 0.5d);
            I = context.getResources().getDisplayMetrics().widthPixels;
            int i10 = context.getResources().getDisplayMetrics().heightPixels;
            f23329t = i10;
            int i11 = I;
            if (i11 > i10) {
                int i12 = i11 + i10;
                I = i12;
                int i13 = i12 - i10;
                f23329t = i13;
                I = i12 - i13;
            }
            J = g.a(context, J);
            O = true;
        }
    }

    public static int b(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("mz_action_button_min_height").get(cls.newInstance()).toString()));
        } catch (Exception unused) {
            return 0;
        }
    }
}
