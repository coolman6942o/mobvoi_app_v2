package io.reactivex.internal.operators.observable;

import eo.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.s;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableSampleTimed.java */
/* loaded from: classes3.dex */
public final class t2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f29046b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f29047c;

    /* renamed from: d  reason: collision with root package name */
    final s f29048d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f29049e;

    /* compiled from: ObservableSampleTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip = new AtomicInteger(1);

        a(r<? super T> rVar, long j10, TimeUnit timeUnit, s sVar) {
            super(rVar, j10, timeUnit, sVar);
        }

        @Override // io.reactivex.internal.operators.observable.t2.c
        void b() {
            c();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                c();
                if (this.wip.decrementAndGet() == 0) {
                    this.downstream.onComplete();
                }
            }
        }
    }

    /* compiled from: ObservableSampleTimed.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        b(r<? super T> rVar, long j10, TimeUnit timeUnit, s sVar) {
            super(rVar, j10, timeUnit, sVar);
        }

        @Override // io.reactivex.internal.operators.observable.t2.c
        void b() {
            this.downstream.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            c();
        }
    }

    /* compiled from: ObservableSampleTimed.java */
    /* loaded from: classes3.dex */
    static abstract class c<T> extends AtomicReference<T> implements r<T>, xn.b, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final r<? super T> downstream;
        final long period;
        final s scheduler;
        final AtomicReference<xn.b> timer = new AtomicReference<>();
        final TimeUnit unit;
        xn.b upstream;

        c(r<? super T> rVar, long j10, TimeUnit timeUnit, s sVar) {
            this.downstream = rVar;
            this.period = j10;
            this.unit = timeUnit;
            this.scheduler = sVar;
        }

        void a() {
            DisposableHelper.dispose(this.timer);
        }

        abstract void b();

        void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }

        @Override // xn.b
        public void dispose() {
            a();
            this.upstream.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            a();
            b();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            a();
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            lazySet(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
                s sVar = this.scheduler;
                long j10 = this.period;
                DisposableHelper.replace(this.timer, sVar.e(this, j10, j10, this.unit));
            }
        }
    }

    public t2(p<T> pVar, long j10, TimeUnit timeUnit, s sVar, boolean z10) {
        super(pVar);
        this.f29046b = j10;
        this.f29047c = timeUnit;
        this.f29048d = sVar;
        this.f29049e = z10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        d dVar = new d(rVar);
        if (this.f29049e) {
            this.f28426a.subscribe(new a(dVar, this.f29046b, this.f29047c, this.f29048d));
        } else {
            this.f28426a.subscribe(new b(dVar, this.f29046b, this.f29047c, this.f29048d));
        }
    }
}
