package g3;

import android.graphics.PointF;
/* compiled from: CubicCurveData.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f27226a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f27227b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f27228c;

    public a() {
        this.f27226a = new PointF();
        this.f27227b = new PointF();
        this.f27228c = new PointF();
    }

    public PointF a() {
        return this.f27226a;
    }

    public PointF b() {
        return this.f27227b;
    }

    public PointF c() {
        return this.f27228c;
    }

    public void d(float f10, float f11) {
        this.f27226a.set(f10, f11);
    }

    public void e(float f10, float f11) {
        this.f27227b.set(f10, f11);
    }

    public void f(float f10, float f11) {
        this.f27228c.set(f10, f11);
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f27226a = pointF;
        this.f27227b = pointF2;
        this.f27228c = pointF3;
    }
}
