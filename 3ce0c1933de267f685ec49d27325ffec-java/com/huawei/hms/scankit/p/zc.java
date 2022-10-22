package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
/* compiled from: Particle.java */
/* loaded from: classes2.dex */
public class zc {

    /* renamed from: b  reason: collision with root package name */
    private float f15030b;

    /* renamed from: c  reason: collision with root package name */
    private float f15031c;

    /* renamed from: g  reason: collision with root package name */
    private int f15035g;

    /* renamed from: h  reason: collision with root package name */
    private long f15036h;

    /* renamed from: i  reason: collision with root package name */
    private float f15037i;

    /* renamed from: j  reason: collision with root package name */
    private float f15038j;

    /* renamed from: k  reason: collision with root package name */
    private float f15039k;

    /* renamed from: l  reason: collision with root package name */
    private float f15040l;

    /* renamed from: m  reason: collision with root package name */
    private float f15041m;

    /* renamed from: n  reason: collision with root package name */
    private int f15042n;

    /* renamed from: o  reason: collision with root package name */
    private int f15043o;

    /* renamed from: p  reason: collision with root package name */
    private long f15044p;

    /* renamed from: r  reason: collision with root package name */
    private Cc f15046r;

    /* renamed from: a  reason: collision with root package name */
    private float f15029a = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private int f15032d = 255;

    /* renamed from: e  reason: collision with root package name */
    private float f15033e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f15034f = 0.0f;

    /* renamed from: q  reason: collision with root package name */
    private int f15045q = 0;

    public zc(Bitmap bitmap) {
        this.f15035g = 255;
        this.f15039k = 1.0f;
        this.f15039k = 1.0f;
        this.f15035g = 255;
        if (bitmap != null) {
            this.f15042n = bitmap.getWidth() / 2;
            this.f15043o = bitmap.getHeight() / 2;
        }
    }

    public void a(long j10, float f10, float f11, long j11, Cc cc2) {
        float f12 = f10 - this.f15042n;
        this.f15040l = f12;
        float f13 = f11 - this.f15043o;
        this.f15041m = f13;
        this.f15037i = f12;
        this.f15038j = f13;
        this.f15044p = j10;
        this.f15036h = j11;
        this.f15046r = cc2;
    }

    public void b(float f10) {
        this.f15039k = f10;
    }

    public float c() {
        return this.f15037i;
    }

    public float d() {
        return this.f15038j;
    }

    public int e() {
        return this.f15032d;
    }

    public float f() {
        return this.f15039k;
    }

    public int b() {
        return this.f15045q;
    }

    public void b(int i10) {
        this.f15045q = i10;
    }

    public boolean a(long j10) {
        long j11 = j10 - this.f15036h;
        if (j11 > this.f15044p) {
            return false;
        }
        float f10 = (float) j11;
        float f11 = (float) (j11 * j11);
        this.f15037i = this.f15040l + (this.f15033e * f10) + (this.f15030b * f11);
        this.f15038j = this.f15041m + (this.f15034f * f10) + (this.f15031c * f11);
        this.f15046r.a(this, j11);
        return true;
    }

    public int a() {
        return this.f15035g;
    }

    public void a(int i10) {
        this.f15035g = i10;
    }

    public void a(float f10) {
        this.f15029a = f10;
    }
}
