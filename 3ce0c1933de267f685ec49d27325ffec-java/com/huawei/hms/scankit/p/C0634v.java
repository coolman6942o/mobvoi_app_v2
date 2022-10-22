package com.huawei.hms.scankit.p;
/* compiled from: DetectorResult.java */
/* renamed from: com.huawei.hms.scankit.p.v  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0634v implements Comparable<C0634v> {

    /* renamed from: a  reason: collision with root package name */
    private float f14969a;

    /* renamed from: b  reason: collision with root package name */
    private float f14970b;

    /* renamed from: c  reason: collision with root package name */
    private float f14971c;

    /* renamed from: d  reason: collision with root package name */
    private float f14972d;

    /* renamed from: e  reason: collision with root package name */
    private float f14973e;

    /* renamed from: f  reason: collision with root package name */
    private float f14974f;

    /* renamed from: g  reason: collision with root package name */
    private float f14975g;

    /* renamed from: h  reason: collision with root package name */
    private float f14976h;

    /* renamed from: i  reason: collision with root package name */
    private float f14977i;

    /* renamed from: j  reason: collision with root package name */
    private float f14978j;

    /* renamed from: k  reason: collision with root package name */
    private float f14979k;

    /* renamed from: l  reason: collision with root package name */
    public C0587g f14980l;

    /* renamed from: m  reason: collision with root package name */
    public float[] f14981m = new float[5];

    /* renamed from: n  reason: collision with root package name */
    public float f14982n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    public float f14983o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    public int f14984p = 0;

    /* renamed from: q  reason: collision with root package name */
    public int f14985q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f14986r = 0;

    /* renamed from: s  reason: collision with root package name */
    public int f14987s = 0;

    /* renamed from: t  reason: collision with root package name */
    public int f14988t = 0;

    /* renamed from: u  reason: collision with root package name */
    public int f14989u = 0;

    /* renamed from: v  reason: collision with root package name */
    public float f14990v = 0.0f;

    public C0634v(boolean z10, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        this.f14969a = f10;
        this.f14970b = f11;
        this.f14971c = f12;
        this.f14972d = f13;
        this.f14973e = f14;
        this.f14974f = f15;
        this.f14979k = f19;
        if (z10) {
            this.f14975g = f16;
            this.f14976h = f17;
            this.f14978j = f18;
            return;
        }
        this.f14977i = f18;
        this.f14978j = f17;
    }

    private float a(float f10, int i10, int i11) {
        float f11 = i10;
        if (f10 <= f11) {
            f10 = f11;
        }
        float f12 = i11 - 1;
        return f10 < f12 ? f10 : f12;
    }

    public void a(int i10, int i11, float f10, float f11) {
        float f12 = this.f14969a + f10;
        this.f14969a = f12;
        float f13 = this.f14970b + f11;
        this.f14970b = f13;
        if (f12 < 0.0f) {
            this.f14971c += f12;
        }
        if (f13 < 0.0f) {
            this.f14972d += f13;
        }
        this.f14973e += f10;
        this.f14974f += f11;
        this.f14969a = a(f12, 0, i10);
        this.f14973e = a(this.f14973e, 0, i10);
        this.f14970b = a(this.f14970b, 0, i11);
        this.f14974f = a(this.f14974f, 0, i11);
        float f14 = this.f14969a;
        float f15 = i10 - f10;
        if (this.f14971c + f14 >= f15) {
            this.f14971c = (f15 - 1.0f) - f14;
        }
        float f16 = this.f14970b;
        float f17 = i11 - f11;
        if (this.f14972d + f16 >= f17) {
            this.f14972d = (f17 - 1.0f) - f16;
        }
    }

    public void b(float f10, float f11) {
        this.f14969a = 0.0f;
        this.f14970b = 0.0f;
        this.f14971c = f10;
        this.f14972d = f11;
        this.f14973e = f10 / 2.0f;
        this.f14974f = f11 / 2.0f;
        this.f14975g = f10;
        this.f14976h = f11;
        this.f14978j = 0.0f;
    }

    public float c() {
        return this.f14972d;
    }

    public float d() {
        return this.f14969a;
    }

    public float e() {
        return this.f14970b;
    }

    public float f() {
        return this.f14971c;
    }

    public float g() {
        return this.f14979k;
    }

    public float h() {
        return this.f14977i;
    }

    public float i() {
        return this.f14978j;
    }

    public float j() {
        return this.f14973e;
    }

    public float k() {
        return this.f14974f;
    }

    public float l() {
        return this.f14976h;
    }

    public float m() {
        return this.f14975g;
    }

    public float n() {
        return this.f14990v;
    }

    public float b() {
        return this.f14982n;
    }

    public void a(float f10, float f11) {
        this.f14969a += f10;
        this.f14970b += f11;
        this.f14973e += f10;
        this.f14974f += f11;
    }

    public float a() {
        return this.f14983o;
    }

    /* renamed from: a */
    public int compareTo(C0634v vVar) {
        return Float.compare((-vVar.g()) + vVar.h(), (-g()) + h());
    }
}
