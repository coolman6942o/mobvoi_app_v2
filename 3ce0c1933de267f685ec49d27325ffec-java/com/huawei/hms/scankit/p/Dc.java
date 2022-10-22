package com.huawei.hms.scankit.p;

import android.view.animation.Interpolator;
/* compiled from: OpacityAnimator.java */
/* loaded from: classes2.dex */
public class Dc implements Cc {

    /* renamed from: a  reason: collision with root package name */
    private final int f14493a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14494b;

    /* renamed from: c  reason: collision with root package name */
    private final long f14495c;

    /* renamed from: d  reason: collision with root package name */
    private final long f14496d;

    /* renamed from: e  reason: collision with root package name */
    private final float f14497e;

    /* renamed from: f  reason: collision with root package name */
    private final Interpolator f14498f;

    public Dc(int i10, int i11, long j10, long j11, Interpolator interpolator) {
        this.f14493a = i10;
        this.f14494b = i11;
        this.f14495c = j10;
        this.f14496d = j11;
        this.f14497e = (float) (j11 - j10);
        this.f14498f = interpolator;
    }

    private int a(zc zcVar) {
        int i10 = this.f14494b;
        return i10 == -1 ? zcVar.e() : i10;
    }

    private int b(zc zcVar) {
        int i10 = this.f14493a;
        return i10 == -1 ? zcVar.a() : i10;
    }

    private int c(zc zcVar) {
        return a(zcVar) - b(zcVar);
    }

    @Override // com.huawei.hms.scankit.p.Cc
    public void a(zc zcVar, long j10) {
        if (j10 >= this.f14495c && j10 <= this.f14496d && Float.compare(this.f14497e, 0.0f) != 0) {
            zcVar.a((int) (b(zcVar) + (c(zcVar) * this.f14498f.getInterpolation(((float) (j10 - this.f14495c)) / this.f14497e))));
        }
    }
}
