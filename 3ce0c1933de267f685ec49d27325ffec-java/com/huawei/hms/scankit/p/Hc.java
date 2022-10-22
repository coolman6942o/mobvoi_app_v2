package com.huawei.hms.scankit.p;
/* compiled from: ParticleScale.java */
/* loaded from: classes2.dex */
public class Hc implements Fc {

    /* renamed from: a  reason: collision with root package name */
    private final float f14542a;

    /* renamed from: b  reason: collision with root package name */
    private final float f14543b;

    public Hc(float f10, float f11) {
        this.f14543b = f10;
        this.f14542a = f11;
    }

    @Override // com.huawei.hms.scankit.p.Fc
    public void a(zc zcVar) {
        float f10 = this.f14542a;
        float f11 = this.f14543b;
        if (f10 != f11) {
            f10 = Ic.a(f10 - f11) + this.f14543b;
        }
        zcVar.b(f10);
        zcVar.a(f10);
    }
}
