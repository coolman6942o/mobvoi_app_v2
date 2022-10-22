package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableSampleWithObservable.java */
/* loaded from: classes3.dex */
public final class u2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final p<?> f29064b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f29065c;

    /* compiled from: ObservableSampleWithObservable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip = new AtomicInteger();

        a(r<? super T> rVar, p<?> pVar) {
            super(rVar, pVar);
        }

        @Override // io.reactivex.internal.operators.observable.u2.c
        void b() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                c();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.u2.c
        void g() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z10 = this.done;
                    c();
                    if (z10) {
                        this.downstream.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    /* compiled from: ObservableSampleWithObservable.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        b(r<? super T> rVar, p<?> pVar) {
            super(rVar, pVar);
        }

        @Override // io.reactivex.internal.operators.observable.u2.c
        void b() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.u2.c
        void g() {
            c();
        }
    }

    /* compiled from: ObservableSampleWithObservable.java */
    /* loaded from: classes3.dex */
    static abstract class c<T> extends AtomicReference<T> implements r<T>, xn.b {
        private static final long serialVersionUID = -3517602651313910099L;
        final r<? super T> downstream;
        final AtomicReference<xn.b> other = new AtomicReference<>();
        final p<?> sampler;
        xn.b upstream;

        c(r<? super T> rVar, p<?> pVar) {
            this.downstream = rVar;
            this.sampler = pVar;
        }

        public void a() {
            this.upstream.dispose();
            b();
        }

        abstract void b();

        void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }

        public void d(Throwable th2) {
            this.upstream.dispose();
            this.downstream.onError(th2);
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this.other);
            this.upstream.dispose();
        }

        abstract void g();

        boolean h(xn.b bVar) {
            return DisposableHelper.setOnce(this.other, bVar);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.other.get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            b();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.other);
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
                if (this.other.get() == null) {
                    this.sampler.subscribe(new d(this));
                }
            }
        }
    }

    /* compiled from: ObservableSampleWithObservable.java */
    /* loaded from: classes3.dex */
    static final class d<T> implements r<Object> {

        /* renamed from: a  reason: collision with root package name */
        final c<T> f29066a;

        d(c<T> cVar) {
            this.f29066a = cVar;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f29066a.a();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f29066a.d(th2);
        }

        @Override // io.reactivex.r
        public void onNext(Object obj) {
            this.f29066a.g();
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            this.f29066a.h(bVar);
        }
    }

    public u2(p<T> pVar, p<?> pVar2, boolean z10) {
        super(pVar);
        this.f29064b = pVar2;
        this.f29065c = z10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        eo.d dVar = new eo.d(rVar);
        if (this.f29065c) {
            this.f28426a.subscribe(new a(dVar, this.f29064b));
        } else {
            this.f28426a.subscribe(new b(dVar, this.f29064b));
        }
    }
}
