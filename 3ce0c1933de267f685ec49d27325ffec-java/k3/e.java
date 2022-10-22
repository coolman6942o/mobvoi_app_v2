package k3;

import android.view.Choreographer;
import com.airbnb.lottie.c;
import com.airbnb.lottie.d;
/* compiled from: LottieValueAnimator.java */
/* loaded from: classes.dex */
public class e extends a implements Choreographer.FrameCallback {

    /* renamed from: j  reason: collision with root package name */
    private d f29732j;

    /* renamed from: c  reason: collision with root package name */
    private float f29725c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29726d = false;

    /* renamed from: e  reason: collision with root package name */
    private long f29727e = 0;

    /* renamed from: f  reason: collision with root package name */
    private float f29728f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private int f29729g = 0;

    /* renamed from: h  reason: collision with root package name */
    private float f29730h = -2.14748365E9f;

    /* renamed from: i  reason: collision with root package name */
    private float f29731i = 2.14748365E9f;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f29733k = false;

    private void C() {
        if (this.f29732j != null) {
            float f10 = this.f29728f;
            if (f10 < this.f29730h || f10 > this.f29731i) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f29730h), Float.valueOf(this.f29731i), Float.valueOf(this.f29728f)));
            }
        }
    }

    private float k() {
        d dVar = this.f29732j;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.h()) / Math.abs(this.f29725c);
    }

    private boolean o() {
        return n() < 0.0f;
    }

    public void A(int i10) {
        z(i10, (int) this.f29731i);
    }

    public void B(float f10) {
        this.f29725c = f10;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        a();
        s();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j10) {
        r();
        if (this.f29732j != null && isRunning()) {
            c.a("LottieValueAnimator#doFrame");
            long j11 = this.f29727e;
            long j12 = 0;
            if (j11 != 0) {
                j12 = j10 - j11;
            }
            float k10 = ((float) j12) / k();
            float f10 = this.f29728f;
            if (o()) {
                k10 = -k10;
            }
            float f11 = f10 + k10;
            this.f29728f = f11;
            boolean z10 = !g.d(f11, m(), l());
            this.f29728f = g.b(this.f29728f, m(), l());
            this.f29727e = j10;
            e();
            if (z10) {
                if (getRepeatCount() == -1 || this.f29729g < getRepeatCount()) {
                    c();
                    this.f29729g++;
                    if (getRepeatMode() == 2) {
                        this.f29726d = !this.f29726d;
                        v();
                    } else {
                        this.f29728f = o() ? l() : m();
                    }
                    this.f29727e = j10;
                } else {
                    this.f29728f = this.f29725c < 0.0f ? m() : l();
                    s();
                    b(o());
                }
            }
            C();
            c.b("LottieValueAnimator#doFrame");
        }
    }

    public void f() {
        this.f29732j = null;
        this.f29730h = -2.14748365E9f;
        this.f29731i = 2.14748365E9f;
    }

    public void g() {
        s();
        b(o());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float m10;
        float l10;
        float m11;
        if (this.f29732j == null) {
            return 0.0f;
        }
        if (o()) {
            m10 = l() - this.f29728f;
            l10 = l();
            m11 = m();
        } else {
            m10 = this.f29728f - m();
            l10 = l();
            m11 = m();
        }
        return m10 / (l10 - m11);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(i());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        d dVar = this.f29732j;
        if (dVar == null) {
            return 0L;
        }
        return dVar.d();
    }

    public float i() {
        d dVar = this.f29732j;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.f29728f - dVar.o()) / (this.f29732j.f() - this.f29732j.o());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f29733k;
    }

    public float j() {
        return this.f29728f;
    }

    public float l() {
        d dVar = this.f29732j;
        if (dVar == null) {
            return 0.0f;
        }
        float f10 = this.f29731i;
        return f10 == 2.14748365E9f ? dVar.f() : f10;
    }

    public float m() {
        d dVar = this.f29732j;
        if (dVar == null) {
            return 0.0f;
        }
        float f10 = this.f29730h;
        return f10 == -2.14748365E9f ? dVar.o() : f10;
    }

    public float n() {
        return this.f29725c;
    }

    public void p() {
        s();
    }

    public void q() {
        this.f29733k = true;
        d(o());
        x((int) (o() ? l() : m()));
        this.f29727e = 0L;
        this.f29729g = 0;
        r();
    }

    protected void r() {
        if (isRunning()) {
            t(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void s() {
        t(true);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i10) {
        super.setRepeatMode(i10);
        if (i10 != 2 && this.f29726d) {
            this.f29726d = false;
            v();
        }
    }

    protected void t(boolean z10) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z10) {
            this.f29733k = false;
        }
    }

    public void u() {
        this.f29733k = true;
        r();
        this.f29727e = 0L;
        if (o() && j() == m()) {
            this.f29728f = l();
        } else if (!o() && j() == l()) {
            this.f29728f = m();
        }
    }

    public void v() {
        B(-n());
    }

    public void w(d dVar) {
        boolean z10 = this.f29732j == null;
        this.f29732j = dVar;
        if (z10) {
            z((int) Math.max(this.f29730h, dVar.o()), (int) Math.min(this.f29731i, dVar.f()));
        } else {
            z((int) dVar.o(), (int) dVar.f());
        }
        float f10 = this.f29728f;
        this.f29728f = 0.0f;
        x((int) f10);
        e();
    }

    public void x(float f10) {
        if (this.f29728f != f10) {
            this.f29728f = g.b(f10, m(), l());
            this.f29727e = 0L;
            e();
        }
    }

    public void y(float f10) {
        z(this.f29730h, f10);
    }

    public void z(float f10, float f11) {
        if (f10 <= f11) {
            d dVar = this.f29732j;
            float o10 = dVar == null ? -3.4028235E38f : dVar.o();
            d dVar2 = this.f29732j;
            float f12 = dVar2 == null ? Float.MAX_VALUE : dVar2.f();
            this.f29730h = g.b(f10, o10, f12);
            this.f29731i = g.b(f11, o10, f12);
            x((int) g.b(this.f29728f, f10, f11));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f10), Float.valueOf(f11)));
    }
}
