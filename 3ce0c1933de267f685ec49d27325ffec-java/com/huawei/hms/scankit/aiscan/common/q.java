package com.huawei.hms.scankit.aiscan.common;
/* compiled from: PerspectiveTransform.java */
/* loaded from: classes2.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private final float f14257a;

    /* renamed from: b  reason: collision with root package name */
    private final float f14258b;

    /* renamed from: c  reason: collision with root package name */
    private final float f14259c;

    /* renamed from: d  reason: collision with root package name */
    private final float f14260d;

    /* renamed from: e  reason: collision with root package name */
    private final float f14261e;

    /* renamed from: f  reason: collision with root package name */
    private final float f14262f;

    /* renamed from: g  reason: collision with root package name */
    private final float f14263g;

    /* renamed from: h  reason: collision with root package name */
    private final float f14264h;

    /* renamed from: i  reason: collision with root package name */
    private final float f14265i;

    /* renamed from: j  reason: collision with root package name */
    private float f14266j;

    /* renamed from: k  reason: collision with root package name */
    private float f14267k;

    /* renamed from: l  reason: collision with root package name */
    private float f14268l;

    /* renamed from: m  reason: collision with root package name */
    private float f14269m;

    /* renamed from: n  reason: collision with root package name */
    private float f14270n;

    /* renamed from: o  reason: collision with root package name */
    private float f14271o;

    /* renamed from: p  reason: collision with root package name */
    private float f14272p;

    /* renamed from: q  reason: collision with root package name */
    private float f14273q;

    /* renamed from: r  reason: collision with root package name */
    private float f14274r;

    /* renamed from: s  reason: collision with root package name */
    private float f14275s = 0.0f;

    /* renamed from: t  reason: collision with root package name */
    private float f14276t = 0.0f;

    /* renamed from: u  reason: collision with root package name */
    private float f14277u = 0.0f;

    /* renamed from: v  reason: collision with root package name */
    private float f14278v = 0.0f;

    /* renamed from: w  reason: collision with root package name */
    private float f14279w = 0.0f;

    public q(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.f14257a = f10;
        this.f14258b = f13;
        this.f14259c = f16;
        this.f14260d = f11;
        this.f14261e = f14;
        this.f14262f = f17;
        this.f14263g = f12;
        this.f14264h = f15;
        this.f14265i = f18;
        this.f14266j = f10;
        this.f14267k = f11;
        this.f14268l = f12;
        this.f14269m = f13;
        this.f14270n = f14;
        this.f14271o = f15;
        this.f14272p = f16;
        this.f14273q = f17;
        this.f14274r = f18;
    }

    public void a(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23) {
        this.f14266j = f10;
        this.f14267k = f11;
        this.f14268l = f12;
        this.f14269m = f13;
        this.f14270n = f14;
        this.f14271o = f15;
        this.f14272p = f16;
        this.f14273q = f17;
        this.f14274r = f18;
        this.f14275s = f19;
        this.f14276t = f20;
        this.f14277u = f21;
        this.f14278v = f22;
        this.f14279w = f23;
    }

    public void b(float[] fArr) {
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10 += 2) {
            float f10 = fArr[i10];
            int i11 = i10 + 1;
            float f11 = fArr[i11];
            float f12 = (this.f14276t * f10) + (this.f14277u * f11) + (this.f14278v * f10 * f10) + (this.f14279w * f11 * f11) + 1.0f;
            fArr[i10] = (((((this.f14266j * f10) + (this.f14267k * f11)) + ((this.f14268l * f10) * f10)) + ((this.f14269m * f11) * f11)) + this.f14270n) / f12;
            fArr[i11] = (((((this.f14271o * f10) + (this.f14272p * f11)) + ((this.f14273q * f10) * f10)) + ((this.f14274r * f11) * f11)) + this.f14275s) / f12;
        }
    }

    public static q b(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        float f18 = ((f10 - f12) + f14) - f16;
        float f19 = ((f11 - f13) + f15) - f17;
        if (f18 == 0.0f && f19 == 0.0f) {
            return new q(f12 - f10, f14 - f12, f10, f13 - f11, f15 - f13, f11, 0.0f, 0.0f, 1.0f);
        }
        float f20 = f12 - f14;
        float f21 = f16 - f14;
        float f22 = f13 - f15;
        float f23 = f17 - f15;
        float f24 = (f20 * f23) - (f21 * f22);
        float f25 = ((f23 * f18) - (f21 * f19)) / f24;
        float f26 = ((f20 * f19) - (f18 * f22)) / f24;
        return new q((f25 * f12) + (f12 - f10), (f26 * f16) + (f16 - f10), f10, (f13 - f11) + (f25 * f13), (f17 - f11) + (f26 * f17), f11, f25, f26, 1.0f);
    }

    public static q a(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25) {
        return b(f18, f19, f20, f21, f22, f23, f24, f25).a(a(f10, f11, f12, f13, f14, f15, f16, f17));
    }

    public void a(float[] fArr) {
        int length = fArr.length;
        float f10 = this.f14257a;
        float f11 = this.f14258b;
        float f12 = this.f14259c;
        float f13 = this.f14260d;
        float f14 = this.f14261e;
        float f15 = this.f14262f;
        float f16 = this.f14263g;
        float f17 = this.f14264h;
        float f18 = this.f14265i;
        for (int i10 = 0; i10 < length; i10 += 2) {
            float f19 = fArr[i10];
            int i11 = i10 + 1;
            float f20 = fArr[i11];
            float f21 = (f12 * f19) + (f15 * f20) + f18;
            fArr[i10] = (((f10 * f19) + (f13 * f20)) + f16) / f21;
            fArr[i11] = (((f19 * f11) + (f20 * f14)) + f17) / f21;
        }
    }

    public static q a(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return b(f10, f11, f12, f13, f14, f15, f16, f17).a();
    }

    q a() {
        float f10 = this.f14261e;
        float f11 = this.f14265i;
        float f12 = this.f14262f;
        float f13 = this.f14264h;
        float f14 = (f10 * f11) - (f12 * f13);
        float f15 = this.f14263g;
        float f16 = this.f14260d;
        float f17 = (f12 * f15) - (f16 * f11);
        float f18 = (f16 * f13) - (f10 * f15);
        float f19 = this.f14259c;
        float f20 = this.f14258b;
        float f21 = (f19 * f13) - (f20 * f11);
        float f22 = this.f14257a;
        return new q(f14, f17, f18, f21, (f11 * f22) - (f19 * f15), (f15 * f20) - (f13 * f22), (f20 * f12) - (f19 * f10), (f19 * f16) - (f12 * f22), (f22 * f10) - (f20 * f16));
    }

    q a(q qVar) {
        float f10 = this.f14257a;
        float f11 = qVar.f14257a;
        float f12 = this.f14260d;
        float f13 = qVar.f14258b;
        float f14 = this.f14263g;
        float f15 = qVar.f14259c;
        float f16 = (f10 * f11) + (f12 * f13) + (f14 * f15);
        float f17 = qVar.f14260d;
        float f18 = qVar.f14261e;
        float f19 = qVar.f14262f;
        float f20 = (f10 * f17) + (f12 * f18) + (f14 * f19);
        float f21 = qVar.f14263g;
        float f22 = qVar.f14264h;
        float f23 = qVar.f14265i;
        float f24 = (f10 * f21) + (f12 * f22) + (f14 * f23);
        float f25 = this.f14258b;
        float f26 = this.f14261e;
        float f27 = this.f14264h;
        float f28 = (f27 * f23) + (f25 * f21) + (f26 * f22);
        float f29 = this.f14259c;
        float f30 = this.f14262f;
        float f31 = (f11 * f29) + (f13 * f30);
        float f32 = this.f14265i;
        return new q(f16, f20, f24, (f25 * f11) + (f26 * f13) + (f27 * f15), (f25 * f17) + (f26 * f18) + (f27 * f19), f28, (f15 * f32) + f31, (f17 * f29) + (f18 * f30) + (f19 * f32), (f29 * f21) + (f30 * f22) + (f32 * f23));
    }
}
