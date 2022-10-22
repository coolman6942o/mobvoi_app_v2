package rx;

import dq.e;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import rx.Emitter;
import rx.exceptions.OnErrorFailedException;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.a0;
import rx.internal.operators.b0;
import rx.internal.operators.c0;
import rx.internal.operators.d0;
import rx.internal.operators.e0;
import rx.internal.operators.f0;
import rx.internal.operators.g0;
import rx.internal.operators.h;
import rx.internal.operators.h0;
import rx.internal.operators.k;
import rx.internal.operators.l;
import rx.internal.operators.m;
import rx.internal.operators.n;
import rx.internal.operators.o;
import rx.internal.operators.p;
import rx.internal.operators.q;
import rx.internal.operators.r;
import rx.internal.operators.s;
import rx.internal.operators.t;
import rx.internal.operators.u;
import rx.internal.operators.w;
import rx.internal.operators.x;
import rx.internal.operators.y;
import rx.internal.operators.z;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.j;
import yp.d;
import yp.f;
import yp.g;
import yp.i;
/* compiled from: Observable.java */
/* loaded from: classes3.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    final a<T> f33696a;

    /* compiled from: Observable.java */
    /* loaded from: classes3.dex */
    public interface a<T> extends yp.b<i<? super T>> {
    }

    /* compiled from: Observable.java */
    /* loaded from: classes3.dex */
    public interface b<R, T> extends g<i<? super R>, i<? super T>> {
    }

    /* compiled from: Observable.java */
    /* renamed from: rx.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface AbstractC0468c<T, R> extends g<c<T>, c<R>> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(a<T> aVar) {
        this.f33696a = aVar;
    }

    public static <T> c<T> A(T t10) {
        return rx.internal.util.g.m0(t10);
    }

    public static <T> c<T> B(T t10, T t11, T t12) {
        return w(new Object[]{t10, t11, t12});
    }

    public static <T> c<T> E(c<? extends c<? extends T>> cVar) {
        if (cVar.getClass() == rx.internal.util.g.class) {
            return ((rx.internal.util.g) cVar).p0(j.b());
        }
        return (c<T>) cVar.C(z.b(false));
    }

    public static <T> c<T> F(c<? extends T> cVar, c<? extends T> cVar2, c<? extends T> cVar3) {
        return G(new c[]{cVar, cVar2, cVar3});
    }

    public static <T> c<T> G(c<? extends T>[] cVarArr) {
        return E(w(cVarArr));
    }

    static <T> j W(i<? super T> iVar, c<T> cVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        } else if (cVar.f33696a != null) {
            iVar.onStart();
            if (!(iVar instanceof aq.b)) {
                iVar = new aq.b(iVar);
            }
            try {
                bq.c.o(cVar, cVar.f33696a).call(iVar);
                return bq.c.n(iVar);
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                if (iVar.isUnsubscribed()) {
                    bq.c.i(bq.c.l(th2));
                } else {
                    try {
                        iVar.onError(bq.c.l(th2));
                    } catch (Throwable th3) {
                        rx.exceptions.a.e(th3);
                        OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th2.getMessage() + "] and then again while trying to pass to onError.", th3);
                        bq.c.l(onErrorFailedException);
                        throw onErrorFailedException;
                    }
                }
                return e.c();
            }
        } else {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
    }

    public static <T> c<T> d(c<? extends c<? extends T>> cVar) {
        return (c<T>) cVar.f(j.b());
    }

    public static <T> c<T> e(c<? extends T> cVar, c<? extends T> cVar2, c<? extends T> cVar3) {
        return d(B(cVar, cVar2, cVar3));
    }

    public static c<Long> e0(long j10, TimeUnit timeUnit) {
        return f0(j10, timeUnit, cq.a.a());
    }

    public static c<Long> f0(long j10, TimeUnit timeUnit, f fVar) {
        return i0(new t(j10, timeUnit, fVar));
    }

    @Deprecated
    public static <T> c<T> g(a<T> aVar) {
        return new c<>(bq.c.g(aVar));
    }

    public static <T> c<T> h(yp.b<Emitter<T>> bVar, Emitter.BackpressureMode backpressureMode) {
        return i0(new rx.internal.operators.g(bVar, backpressureMode));
    }

    public static <T> c<T> i0(a<T> aVar) {
        return new c<>(bq.c.g(aVar));
    }

    public static <T> c<T> k(f<c<T>> fVar) {
        return i0(new h(fVar));
    }

    public static <T1, T2, T3, T4, R> c<R> k0(c<? extends T1> cVar, c<? extends T2> cVar2, c<? extends T3> cVar3, c<? extends T4> cVar4, i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        return A(new c[]{cVar, cVar2, cVar3, cVar4}).C(new h0(iVar));
    }

    public static <T1, T2, R> c<R> l0(c<? extends T1> cVar, c<? extends T2> cVar2, yp.h<? super T1, ? super T2, ? extends R> hVar) {
        return A(new c[]{cVar, cVar2}).C(new h0(hVar));
    }

    public static <T> c<T> s() {
        return EmptyObservableHolder.instance();
    }

    public static <T> c<T> t(Throwable th2) {
        return i0(new r(th2));
    }

    public static <T> c<T> w(T[] tArr) {
        int length = tArr.length;
        if (length == 0) {
            return s();
        }
        if (length == 1) {
            return A(tArr[0]);
        }
        return i0(new l(tArr));
    }

    public static <T> c<T> x(Callable<? extends T> callable) {
        return i0(new m(callable));
    }

    public static c<Long> y(long j10, long j11, TimeUnit timeUnit) {
        return z(j10, j11, timeUnit, cq.a.a());
    }

    public static c<Long> z(long j10, long j11, TimeUnit timeUnit, f fVar) {
        return i0(new u(j10, j11, timeUnit, fVar));
    }

    public final <R> c<R> C(b<? extends R, ? super T> bVar) {
        return i0(new n(this.f33696a, bVar));
    }

    public final <R> c<R> D(g<? super T, ? extends R> gVar) {
        return i0(new o(this, gVar));
    }

    public final c<T> H(f fVar) {
        return I(fVar, rx.internal.util.f.f34130c);
    }

    public final c<T> I(f fVar, int i10) {
        return J(fVar, false, i10);
    }

    public final c<T> J(f fVar, boolean z10, int i10) {
        if (this instanceof rx.internal.util.g) {
            return ((rx.internal.util.g) this).q0(fVar);
        }
        return (c<T>) C(new a0(fVar, z10, i10));
    }

    public final c<T> K() {
        return (c<T>) C(b0.b());
    }

    public final c<T> L() {
        return (c<T>) C(c0.b());
    }

    public final c<T> M(c<? extends T> cVar) {
        return (c<T>) C(d0.b(cVar));
    }

    public final c<T> N(g<? super Throwable, ? extends T> gVar) {
        return (c<T>) C(d0.c(gVar));
    }

    public final zp.a<T> O() {
        return e0.n0(this);
    }

    public final zp.a<T> P(int i10) {
        return e0.o0(this, i10);
    }

    public final zp.a<T> Q(int i10, long j10, TimeUnit timeUnit, f fVar) {
        if (i10 >= 0) {
            return e0.q0(this, j10, timeUnit, fVar, i10);
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final zp.a<T> R(long j10, TimeUnit timeUnit, f fVar) {
        return e0.p0(this, j10, timeUnit, fVar);
    }

    public final c<T> S(g<? super c<? extends Throwable>, ? extends c<?>> gVar) {
        return p.b(this, InternalObservableUtils.createRetryDematerializer(gVar));
    }

    public final j T() {
        return V(new rx.internal.util.b(d.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, d.a()));
    }

    public final j U(d<? super T> dVar) {
        if (dVar instanceof i) {
            return V((i) dVar);
        }
        Objects.requireNonNull(dVar, "observer is null");
        return V(new rx.internal.util.c(dVar));
    }

    public final j V(i<? super T> iVar) {
        return W(iVar, this);
    }

    public final j X(yp.b<? super T> bVar) {
        if (bVar != null) {
            return V(new rx.internal.util.b(bVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, d.a()));
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final j Y(yp.b<? super T> bVar, yp.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        } else if (bVar2 != null) {
            return V(new rx.internal.util.b(bVar, bVar2, d.a()));
        } else {
            throw new IllegalArgumentException("onError can not be null");
        }
    }

    public final c<T> Z(f fVar) {
        return a0(fVar, !(this.f33696a instanceof rx.internal.operators.g));
    }

    public final c<T> a0(f fVar, boolean z10) {
        if (this instanceof rx.internal.util.g) {
            return ((rx.internal.util.g) this).q0(fVar);
        }
        return i0(new f0(this, fVar, z10));
    }

    public final <R> c<R> b(f<R> fVar, yp.c<R, ? super T> cVar) {
        return i0(new rx.internal.operators.e(this, fVar, cVar));
    }

    public final c<T> b0(g<? super T, Boolean> gVar) {
        return (c<T>) C(new g0(gVar));
    }

    public <R> c<R> c(AbstractC0468c<? super T, ? extends R> cVar) {
        return (c) cVar.call(this);
    }

    public final c<T> c0(long j10, TimeUnit timeUnit, c<? extends T> cVar) {
        return d0(j10, timeUnit, cVar, cq.a.a());
    }

    public final c<T> d0(long j10, TimeUnit timeUnit, c<? extends T> cVar, f fVar) {
        return i0(new s(this, j10, timeUnit, fVar, cVar));
    }

    public final <R> c<R> f(g<? super T, ? extends c<? extends R>> gVar) {
        if (this instanceof rx.internal.util.g) {
            return ((rx.internal.util.g) this).p0(gVar);
        }
        return i0(new rx.internal.operators.f(this, gVar, 2, 0));
    }

    public rx.a g0() {
        return rx.a.f(this);
    }

    public g<T> h0() {
        return new g<>(q.b(this));
    }

    public final c<T> i(long j10, TimeUnit timeUnit) {
        return j(j10, timeUnit, cq.a.a());
    }

    public final c<T> j(long j10, TimeUnit timeUnit, f fVar) {
        return (c<T>) C(new w(j10, timeUnit, fVar));
    }

    public final j j0(i<? super T> iVar) {
        try {
            iVar.onStart();
            bq.c.o(this, this.f33696a).call(iVar);
            return bq.c.n(iVar);
        } catch (Throwable th2) {
            rx.exceptions.a.e(th2);
            try {
                iVar.onError(bq.c.l(th2));
                return e.c();
            } catch (Throwable th3) {
                rx.exceptions.a.e(th3);
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th2.getMessage() + "] and then again while trying to pass to onError.", th3);
                bq.c.l(onErrorFailedException);
                throw onErrorFailedException;
            }
        }
    }

    public final c<T> l(long j10, TimeUnit timeUnit) {
        return m(j10, timeUnit, cq.a.a());
    }

    public final c<T> m(long j10, TimeUnit timeUnit, f fVar) {
        return (c<T>) C(new x(j10, timeUnit, fVar));
    }

    public final <U> c<T> n(c<U> cVar) {
        Objects.requireNonNull(cVar);
        return i0(new rx.internal.operators.i(this, cVar));
    }

    public final c<T> o(yp.a aVar) {
        return i0(new rx.internal.operators.j(this, new rx.internal.util.a(d.a(), d.a(), aVar)));
    }

    public final c<T> p(yp.b<? super T> bVar) {
        return i0(new rx.internal.operators.j(this, new rx.internal.util.a(bVar, d.a(), d.a())));
    }

    public final c<T> q(yp.a aVar) {
        return (c<T>) C(new y(aVar));
    }

    public final c<T> r(yp.a aVar) {
        return i0(new rx.internal.operators.j(this, new rx.internal.util.a(d.a(), d.b(aVar), aVar)));
    }

    public final c<T> u(g<? super T, Boolean> gVar) {
        return i0(new k(this, gVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> c<R> v(g<? super T, ? extends c<? extends R>> gVar) {
        if (getClass() == rx.internal.util.g.class) {
            return ((rx.internal.util.g) this).p0(gVar);
        }
        return E(D(gVar));
    }
}
