package s0;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import s0.b;
/* compiled from: SpringAnimation.java */
/* loaded from: classes.dex */
public final class d extends b<d> {

    /* renamed from: s  reason: collision with root package name */
    private e f34264s = null;

    /* renamed from: t  reason: collision with root package name */
    private float f34265t = Float.MAX_VALUE;

    /* renamed from: u  reason: collision with root package name */
    private boolean f34266u = false;

    public <K> d(K k10, c<K> cVar) {
        super(k10, cVar);
    }

    private void o() {
        e eVar = this.f34264s;
        if (eVar != null) {
            double a10 = eVar.a();
            if (a10 > this.f34256g) {
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            } else if (a10 < this.f34257h) {
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
        } else {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    @Override // s0.b
    public void i() {
        o();
        this.f34264s.g(d());
        super.i();
    }

    @Override // s0.b
    boolean k(long j10) {
        if (this.f34266u) {
            float f10 = this.f34265t;
            if (f10 != Float.MAX_VALUE) {
                this.f34264s.e(f10);
                this.f34265t = Float.MAX_VALUE;
            }
            this.f34251b = this.f34264s.a();
            this.f34250a = 0.0f;
            this.f34266u = false;
            return true;
        }
        if (this.f34265t != Float.MAX_VALUE) {
            this.f34264s.a();
            long j11 = j10 / 2;
            b.o h10 = this.f34264s.h(this.f34251b, this.f34250a, j11);
            this.f34264s.e(this.f34265t);
            this.f34265t = Float.MAX_VALUE;
            b.o h11 = this.f34264s.h(h10.f34262a, h10.f34263b, j11);
            this.f34251b = h11.f34262a;
            this.f34250a = h11.f34263b;
        } else {
            b.o h12 = this.f34264s.h(this.f34251b, this.f34250a, j10);
            this.f34251b = h12.f34262a;
            this.f34250a = h12.f34263b;
        }
        float max = Math.max(this.f34251b, this.f34257h);
        this.f34251b = max;
        float min = Math.min(max, this.f34256g);
        this.f34251b = min;
        if (!n(min, this.f34250a)) {
            return false;
        }
        this.f34251b = this.f34264s.a();
        this.f34250a = 0.0f;
        return true;
    }

    public void l(float f10) {
        if (e()) {
            this.f34265t = f10;
            return;
        }
        if (this.f34264s == null) {
            this.f34264s = new e(f10);
        }
        this.f34264s.e(f10);
        i();
    }

    public boolean m() {
        return this.f34264s.f34268b > 0.0d;
    }

    boolean n(float f10, float f11) {
        return this.f34264s.c(f10, f11);
    }

    public d p(e eVar) {
        this.f34264s = eVar;
        return this;
    }

    public void q() {
        if (!m()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (this.f34255f) {
            this.f34266u = true;
        }
    }
}
