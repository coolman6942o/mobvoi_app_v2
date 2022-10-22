package com.google.android.material.bottomappbar;

import w7.f;
import w7.m;
/* compiled from: BottomAppBarTopEdgeTreatment.java */
/* loaded from: classes.dex */
public class a extends f implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private float f10502a;

    /* renamed from: b  reason: collision with root package name */
    private float f10503b;

    /* renamed from: c  reason: collision with root package name */
    private float f10504c;

    /* renamed from: d  reason: collision with root package name */
    private float f10505d;

    /* renamed from: e  reason: collision with root package name */
    private float f10506e;

    /* renamed from: f  reason: collision with root package name */
    private float f10507f;

    @Override // w7.f
    public void b(float f10, float f11, float f12, m mVar) {
        float f13;
        float f14;
        float f15 = this.f10504c;
        if (f15 == 0.0f) {
            mVar.m(f10, 0.0f);
            return;
        }
        float f16 = ((this.f10503b * 2.0f) + f15) / 2.0f;
        float f17 = f12 * this.f10502a;
        float f18 = f11 + this.f10506e;
        float f19 = (this.f10505d * f12) + ((1.0f - f12) * f16);
        if (f19 / f16 >= 1.0f) {
            mVar.m(f10, 0.0f);
            return;
        }
        float f20 = this.f10507f;
        float f21 = f20 * f12;
        boolean z10 = f20 == -1.0f || Math.abs((f20 * 2.0f) - f15) < 0.1f;
        if (!z10) {
            f14 = 1.75f;
            f13 = 0.0f;
        } else {
            f13 = f19;
            f14 = 0.0f;
        }
        float f22 = f16 + f17;
        float f23 = f13 + f17;
        float sqrt = (float) Math.sqrt((f22 * f22) - (f23 * f23));
        float f24 = f18 - sqrt;
        float f25 = f18 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f23));
        float f26 = (90.0f - degrees) + f14;
        mVar.m(f24, 0.0f);
        float f27 = f17 * 2.0f;
        mVar.a(f24 - f17, 0.0f, f24 + f17, f27, 270.0f, degrees);
        if (z10) {
            mVar.a(f18 - f16, (-f16) - f13, f18 + f16, f16 - f13, 180.0f - f26, (f26 * 2.0f) - 180.0f);
        } else {
            float f28 = this.f10503b;
            float f29 = f21 * 2.0f;
            float f30 = f18 - f16;
            mVar.a(f30, -(f21 + f28), f30 + f28 + f29, f28 + f21, 180.0f - f26, ((f26 * 2.0f) - 180.0f) / 2.0f);
            float f31 = f18 + f16;
            float f32 = this.f10503b;
            mVar.m(f31 - ((f32 / 2.0f) + f21), f32 + f21);
            float f33 = this.f10503b;
            mVar.a(f31 - (f29 + f33), -(f21 + f33), f31, f33 + f21, 90.0f, f26 - 90.0f);
        }
        mVar.a(f25 - f17, 0.0f, f25 + f17, f27, 270.0f - degrees, degrees);
        mVar.m(f10, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f10505d;
    }

    public float d() {
        return this.f10507f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.f10503b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.f10502a;
    }

    public float g() {
        return this.f10504c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(float f10) {
        if (f10 >= 0.0f) {
            this.f10505d = f10;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void j(float f10) {
        this.f10507f = f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(float f10) {
        this.f10503b = f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(float f10) {
        this.f10502a = f10;
    }

    public void m(float f10) {
        this.f10504c = f10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(float f10) {
        this.f10506e = f10;
    }
}
