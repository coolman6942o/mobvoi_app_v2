package io.reactivex.internal.operators.observable;

import io.reactivex.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.o;
/* compiled from: ObservableFlatMapCompletableCompletable.java */
/* loaded from: classes3.dex */
public final class x0<T> extends io.reactivex.a implements co.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f29117a;

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends c> f29118b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f29119c;

    /* compiled from: ObservableFlatMapCompletableCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements b, r<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final io.reactivex.b downstream;
        final o<? super T, ? extends c> mapper;
        b upstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final xn.a set = new xn.a();

        /* compiled from: ObservableFlatMapCompletableCompletable.java */
        /* renamed from: io.reactivex.internal.operators.observable.x0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0338a extends AtomicReference<b> implements io.reactivex.b, b {
            private static final long serialVersionUID = 8606673141535671828L;

            C0338a() {
            }

            @Override // xn.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // xn.b
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.b
            public void onComplete() {
                a.this.a(this);
            }

            @Override // io.reactivex.b
            public void onError(Throwable th2) {
                a.this.b(this, th2);
            }

            @Override // io.reactivex.b
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        a(io.reactivex.b bVar, o<? super T, ? extends c> oVar, boolean z10) {
            this.downstream = bVar;
            this.mapper = oVar;
            this.delayErrors = z10;
            lazySet(1);
        }

        void a(a<T>.C0338a aVar) {
            this.set.a(aVar);
            onComplete();
        }

        void b(a<T>.C0338a aVar, Throwable th2) {
            this.set.a(aVar);
            onError(th2);
        }

        @Override // xn.b
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.errors.terminate();
                if (terminate != null) {
                    this.downstream.onError(terminate);
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (!this.errors.addThrowable(th2)) {
                fo.a.s(th2);
            } else if (!this.delayErrors) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.downstream.onError(this.errors.terminate());
                }
            } else if (decrementAndGet() == 0) {
                this.downstream.onError(this.errors.terminate());
            }
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            try {
                c cVar = (c) bo.b.e(this.mapper.apply(t10), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0338a aVar = new C0338a();
                if (!this.disposed && this.set.b(aVar)) {
                    cVar.b(aVar);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.dispose();
                onError(th2);
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public x0(p<T> pVar, o<? super T, ? extends c> oVar, boolean z10) {
        this.f29117a = pVar;
        this.f29118b = oVar;
        this.f29119c = z10;
    }

    @Override // co.a
    public k<T> a() {
        return fo.a.o(new w0(this.f29117a, this.f29118b, this.f29119c));
    }

    @Override // io.reactivex.a
    protected void c(io.reactivex.b bVar) {
        this.f29117a.subscribe(new a(bVar, this.f29118b, this.f29119c));
    }
}
