package io.reactivex.subjects;

import co.g;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.b;
import io.reactivex.k;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: UnicastSubject.java */
/* loaded from: classes3.dex */
public final class d<T> extends c<T> {

    /* renamed from: a  reason: collision with root package name */
    final b<T> f29297a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<r<? super T>> f29298b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<Runnable> f29299c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f29300d;

    /* renamed from: e  reason: collision with root package name */
    volatile boolean f29301e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f29302f;

    /* renamed from: g  reason: collision with root package name */
    Throwable f29303g;

    /* renamed from: h  reason: collision with root package name */
    final AtomicBoolean f29304h;

    /* renamed from: i  reason: collision with root package name */
    final BasicIntQueueDisposable<T> f29305i;

    /* renamed from: j  reason: collision with root package name */
    boolean f29306j;

    /* compiled from: UnicastSubject.java */
    /* loaded from: classes3.dex */
    final class a extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        a() {
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
        public void clear() {
            d.this.f29297a.clear();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, xn.b
        public void dispose() {
            if (!d.this.f29301e) {
                d.this.f29301e = true;
                d.this.f();
                d.this.f29298b.lazySet(null);
                if (d.this.f29305i.getAndIncrement() == 0) {
                    d.this.f29298b.lazySet(null);
                    d.this.f29297a.clear();
                }
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, xn.b
        public boolean isDisposed() {
            return d.this.f29301e;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
        public boolean isEmpty() {
            return d.this.f29297a.isEmpty();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
        public T poll() throws Exception {
            return d.this.f29297a.poll();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.c
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            d.this.f29306j = true;
            return 2;
        }
    }

    d(int i10, boolean z10) {
        this.f29297a = new b<>(bo.b.f(i10, "capacityHint"));
        this.f29299c = new AtomicReference<>();
        this.f29300d = z10;
        this.f29298b = new AtomicReference<>();
        this.f29304h = new AtomicBoolean();
        this.f29305i = new a();
    }

    public static <T> d<T> c() {
        return new d<>(k.bufferSize(), true);
    }

    public static <T> d<T> d(int i10) {
        return new d<>(i10, true);
    }

    public static <T> d<T> e(int i10, Runnable runnable) {
        return new d<>(i10, runnable, true);
    }

    void f() {
        Runnable runnable = this.f29299c.get();
        if (runnable != null && this.f29299c.compareAndSet(runnable, null)) {
            runnable.run();
        }
    }

    void g() {
        if (this.f29305i.getAndIncrement() == 0) {
            r<? super T> rVar = this.f29298b.get();
            int i10 = 1;
            while (rVar == null) {
                i10 = this.f29305i.addAndGet(-i10);
                if (i10 != 0) {
                    rVar = this.f29298b.get();
                } else {
                    return;
                }
            }
            if (this.f29306j) {
                h(rVar);
            } else {
                i(rVar);
            }
        }
    }

    void h(r<? super T> rVar) {
        b<T> bVar = this.f29297a;
        int i10 = 1;
        boolean z10 = !this.f29300d;
        while (!this.f29301e) {
            boolean z11 = this.f29302f;
            if (!z10 || !z11 || !k(bVar, rVar)) {
                rVar.onNext(null);
                if (z11) {
                    j(rVar);
                    return;
                }
                i10 = this.f29305i.addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
        this.f29298b.lazySet(null);
        bVar.clear();
    }

    void i(r<? super T> rVar) {
        b<T> bVar = this.f29297a;
        boolean z10 = !this.f29300d;
        boolean z11 = true;
        int i10 = 1;
        while (!this.f29301e) {
            boolean z12 = this.f29302f;
            Object obj = (T) this.f29297a.poll();
            boolean z13 = obj == null;
            if (z12) {
                if (z10 && z11) {
                    if (!k(bVar, rVar)) {
                        z11 = false;
                    } else {
                        return;
                    }
                }
                if (z13) {
                    j(rVar);
                    return;
                }
            }
            if (z13) {
                i10 = this.f29305i.addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            } else {
                rVar.onNext(obj);
            }
        }
        this.f29298b.lazySet(null);
        bVar.clear();
    }

    void j(r<? super T> rVar) {
        this.f29298b.lazySet(null);
        Throwable th2 = this.f29303g;
        if (th2 != null) {
            rVar.onError(th2);
        } else {
            rVar.onComplete();
        }
    }

    boolean k(g<T> gVar, r<? super T> rVar) {
        Throwable th2 = this.f29303g;
        if (th2 == null) {
            return false;
        }
        this.f29298b.lazySet(null);
        gVar.clear();
        rVar.onError(th2);
        return true;
    }

    @Override // io.reactivex.r
    public void onComplete() {
        if (!this.f29302f && !this.f29301e) {
            this.f29302f = true;
            f();
            g();
        }
    }

    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        bo.b.e(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f29302f || this.f29301e) {
            fo.a.s(th2);
            return;
        }
        this.f29303g = th2;
        this.f29302f = true;
        f();
        g();
    }

    @Override // io.reactivex.r
    public void onNext(T t10) {
        bo.b.e(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f29302f && !this.f29301e) {
            this.f29297a.offer(t10);
            g();
        }
    }

    @Override // io.reactivex.r
    public void onSubscribe(xn.b bVar) {
        if (this.f29302f || this.f29301e) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        if (this.f29304h.get() || !this.f29304h.compareAndSet(false, true)) {
            EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), rVar);
            return;
        }
        rVar.onSubscribe(this.f29305i);
        this.f29298b.lazySet(rVar);
        if (this.f29301e) {
            this.f29298b.lazySet(null);
        } else {
            g();
        }
    }

    d(int i10, Runnable runnable, boolean z10) {
        this.f29297a = new b<>(bo.b.f(i10, "capacityHint"));
        this.f29299c = new AtomicReference<>(bo.b.e(runnable, "onTerminate"));
        this.f29300d = z10;
        this.f29298b = new AtomicReference<>();
        this.f29304h = new AtomicBoolean();
        this.f29305i = new a();
    }
}
