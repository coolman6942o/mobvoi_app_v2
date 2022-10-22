package com.mobvoi.companion.base.ui.view.numberpicker;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* compiled from: NumberScroller.java */
/* loaded from: classes2.dex */
public class a {
    private static float B;
    private static float C;

    /* renamed from: a  reason: collision with root package name */
    private int f16627a;

    /* renamed from: b  reason: collision with root package name */
    private int f16628b;

    /* renamed from: c  reason: collision with root package name */
    private int f16629c;

    /* renamed from: d  reason: collision with root package name */
    private int f16630d;

    /* renamed from: e  reason: collision with root package name */
    private int f16631e;

    /* renamed from: f  reason: collision with root package name */
    private int f16632f;

    /* renamed from: g  reason: collision with root package name */
    private int f16633g;

    /* renamed from: h  reason: collision with root package name */
    private int f16634h;

    /* renamed from: i  reason: collision with root package name */
    private int f16635i;

    /* renamed from: j  reason: collision with root package name */
    private int f16636j;

    /* renamed from: k  reason: collision with root package name */
    private int f16637k;

    /* renamed from: l  reason: collision with root package name */
    private long f16638l;

    /* renamed from: m  reason: collision with root package name */
    private int f16639m;

    /* renamed from: n  reason: collision with root package name */
    private float f16640n;

    /* renamed from: o  reason: collision with root package name */
    private float f16641o;

    /* renamed from: p  reason: collision with root package name */
    private float f16642p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f16643q;

    /* renamed from: r  reason: collision with root package name */
    private Interpolator f16644r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f16645s;

    /* renamed from: t  reason: collision with root package name */
    private float f16646t;

    /* renamed from: u  reason: collision with root package name */
    private float f16647u;

    /* renamed from: v  reason: collision with root package name */
    private final float f16648v;

    /* renamed from: w  reason: collision with root package name */
    private static float f16623w = (float) (Math.log(0.75d) / Math.log(0.9d));

    /* renamed from: x  reason: collision with root package name */
    private static float f16624x = 800.0f;

    /* renamed from: y  reason: collision with root package name */
    private static float f16625y = 0.4f;

    /* renamed from: z  reason: collision with root package name */
    private static float f16626z = 1.0f - 0.4f;
    private static final float[] A = new float[101];

    static {
        float f10;
        float f11;
        float f12 = 0.0f;
        for (int i10 = 0; i10 <= 100; i10++) {
            float f13 = i10 / 100.0f;
            float f14 = 1.0f;
            while (true) {
                float f15 = ((f14 - f12) / 2.0f) + f12;
                float f16 = 1.0f - f15;
                f10 = 3.0f * f15 * f16;
                f11 = f15 * f15 * f15;
                float f17 = (((f16 * f16625y) + (f16626z * f15)) * f10) + f11;
                if (Math.abs(f17 - f13) < 1.0E-5d) {
                    break;
                } else if (f17 > f13) {
                    f14 = f15;
                } else {
                    f12 = f15;
                }
            }
            A[i10] = f10 + f11;
        }
        A[100] = 1.0f;
        B = 8.0f;
        C = 1.0f;
        C = 1.0f / l(1.0f);
    }

    public a(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    private float a(float f10) {
        return this.f16648v * 386.0878f * f10;
    }

    static float l(float f10) {
        float f11;
        float f12 = f10 * B;
        if (f12 < 1.0f) {
            f11 = f12 - (1.0f - ((float) Math.exp(-f12)));
        } else {
            f11 = ((1.0f - ((float) Math.exp(1.0f - f12))) * 0.63212055f) + 0.36787945f;
        }
        return f11 * C;
    }

    public boolean b() {
        float f10;
        if (this.f16643q) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.f16638l);
        int i10 = this.f16639m;
        if (currentAnimationTimeMillis < i10) {
            int i11 = this.f16627a;
            if (i11 == 0) {
                float f11 = currentAnimationTimeMillis * this.f16640n;
                Interpolator interpolator = this.f16644r;
                if (interpolator == null) {
                    f10 = l(f11);
                } else {
                    f10 = interpolator.getInterpolation(f11);
                }
                this.f16636j = this.f16628b + Math.round(this.f16641o * f10);
                this.f16637k = this.f16629c + Math.round(f10 * this.f16642p);
            } else if (i11 == 1) {
                float f12 = currentAnimationTimeMillis / i10;
                int i12 = (int) (f12 * 100.0f);
                float f13 = i12 / 100.0f;
                int i13 = i12 + 1;
                float[] fArr = A;
                float f14 = fArr[i12];
                float f15 = f14 + (((f12 - f13) / ((i13 / 100.0f) - f13)) * (fArr[i13] - f14));
                int i14 = this.f16628b;
                int round = i14 + Math.round((this.f16630d - i14) * f15);
                this.f16636j = round;
                int min = Math.min(round, this.f16633g);
                this.f16636j = min;
                this.f16636j = Math.max(min, this.f16632f);
                int i15 = this.f16629c;
                int round2 = i15 + Math.round(f15 * (this.f16631e - i15));
                this.f16637k = round2;
                int min2 = Math.min(round2, this.f16635i);
                this.f16637k = min2;
                int max = Math.max(min2, this.f16634h);
                this.f16637k = max;
                if (this.f16636j == this.f16630d && max == this.f16631e) {
                    this.f16643q = true;
                }
            }
        } else {
            this.f16636j = this.f16630d;
            this.f16637k = this.f16631e;
            this.f16643q = true;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18;
        int i19;
        int i20;
        if (!this.f16645s || this.f16643q) {
            i19 = i12;
        } else {
            float e10 = e();
            float f10 = this.f16630d - this.f16628b;
            float f11 = this.f16631e - this.f16629c;
            float sqrt = (float) Math.sqrt((f10 * f10) + (f11 * f11));
            float f12 = (f10 / sqrt) * e10;
            float f13 = (f11 / sqrt) * e10;
            i19 = i12;
            float f14 = i19;
            if (Math.signum(f14) == Math.signum(f12)) {
                i18 = i13;
                float f15 = i18;
                if (Math.signum(f15) == Math.signum(f13)) {
                    i19 = (int) (f14 + f12);
                    i18 = (int) (f15 + f13);
                }
                this.f16627a = 1;
                this.f16643q = false;
                float sqrt2 = (float) Math.sqrt((i19 * i19) + (i18 * i18));
                this.f16646t = sqrt2;
                double log = Math.log((f16625y * sqrt2) / f16624x);
                this.f16639m = (int) (Math.exp(log / (f16623w - 1.0d)) * 1000.0d);
                this.f16638l = AnimationUtils.currentAnimationTimeMillis();
                this.f16628b = i10;
                this.f16629c = i11;
                i20 = (sqrt2 > 0.0f ? 1 : (sqrt2 == 0.0f ? 0 : -1));
                float f16 = 1.0f;
                float f17 = i20 != 0 ? 1.0f : i19 / sqrt2;
                if (i20 != 0) {
                    f16 = i18 / sqrt2;
                }
                double d10 = f16624x;
                float f18 = f16623w;
                this.f16632f = i14;
                this.f16633g = i15;
                this.f16634h = i16;
                this.f16635i = i17;
                float exp = (int) (d10 * Math.exp((f18 / (f18 - 1.0d)) * log));
                int round = i10 + Math.round(f17 * exp);
                this.f16630d = round;
                int min = Math.min(round, this.f16633g);
                this.f16630d = min;
                this.f16630d = Math.max(min, this.f16632f);
                int round2 = Math.round(exp * f16) + i11;
                this.f16631e = round2;
                int min2 = Math.min(round2, this.f16635i);
                this.f16631e = min2;
                this.f16631e = Math.max(min2, this.f16634h);
            }
        }
        i18 = i13;
        this.f16627a = 1;
        this.f16643q = false;
        float sqrt22 = (float) Math.sqrt((i19 * i19) + (i18 * i18));
        this.f16646t = sqrt22;
        double log2 = Math.log((f16625y * sqrt22) / f16624x);
        this.f16639m = (int) (Math.exp(log2 / (f16623w - 1.0d)) * 1000.0d);
        this.f16638l = AnimationUtils.currentAnimationTimeMillis();
        this.f16628b = i10;
        this.f16629c = i11;
        i20 = (sqrt22 > 0.0f ? 1 : (sqrt22 == 0.0f ? 0 : -1));
        float f162 = 1.0f;
        if (i20 != 0) {
        }
        if (i20 != 0) {
        }
        double d102 = f16624x;
        float f182 = f16623w;
        this.f16632f = i14;
        this.f16633g = i15;
        this.f16634h = i16;
        this.f16635i = i17;
        float exp2 = (int) (d102 * Math.exp((f182 / (f182 - 1.0d)) * log2));
        int round3 = i10 + Math.round(f17 * exp2);
        this.f16630d = round3;
        int min3 = Math.min(round3, this.f16633g);
        this.f16630d = min3;
        this.f16630d = Math.max(min3, this.f16632f);
        int round22 = Math.round(exp2 * f162) + i11;
        this.f16631e = round22;
        int min22 = Math.min(round22, this.f16635i);
        this.f16631e = min22;
        this.f16631e = Math.max(min22, this.f16634h);
    }

    public final void d(boolean z10) {
        this.f16643q = z10;
    }

    public float e() {
        return this.f16646t - ((this.f16647u * k()) / 2000.0f);
    }

    public final int f() {
        return this.f16637k;
    }

    public final int g() {
        return this.f16631e;
    }

    public final int h() {
        return this.f16629c;
    }

    public final boolean i() {
        return this.f16643q;
    }

    public void j(int i10, int i11, int i12, int i13, int i14) {
        this.f16627a = 0;
        this.f16643q = false;
        this.f16639m = i14;
        this.f16638l = AnimationUtils.currentAnimationTimeMillis();
        this.f16628b = i10;
        this.f16629c = i11;
        this.f16630d = i10 + i12;
        this.f16631e = i11 + i13;
        this.f16641o = i12;
        this.f16642p = i13;
        this.f16640n = 1.0f / this.f16639m;
    }

    public int k() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.f16638l);
    }

    public a(Context context, Interpolator interpolator, boolean z10) {
        this.f16643q = true;
        this.f16644r = interpolator;
        this.f16648v = context.getResources().getDisplayMetrics().density * 160.0f;
        this.f16647u = a(ViewConfiguration.getScrollFriction());
        this.f16645s = z10;
    }
}
