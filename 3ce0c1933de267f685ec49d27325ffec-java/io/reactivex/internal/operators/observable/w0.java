package io.reactivex.internal.operators.observable;

import io.reactivex.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.o;
/* compiled from: ObservableFlatMapCompletable.java */
/* loaded from: classes3.dex */
public final class w0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends c> f29102b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f29103c;

    /* compiled from: ObservableFlatMapCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends BasicIntQueueDisposable<T> implements r<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final r<? super T> downstream;
        final o<? super T, ? extends c> mapper;
        b upstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final xn.a set = new xn.a();

        /* compiled from: ObservableFlatMapCompletable.java */
        /* renamed from: io.reactivex.internal.operators.observable.w0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0337a extends AtomicReference<b> implements io.reactivex.b, b {
            private static final long serialVersionUID = 8606673141535671828L;

            C0337a() {
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

        a(r<? super T> rVar, o<? super T, ? extends c> oVar, boolean z10) {
            this.downstream = rVar;
            this.mapper = oVar;
            this.delayErrors = z10;
            lazySet(1);
        }

        void a(a<T>.C0337a aVar) {
            this.set.a(aVar);
            onComplete();
        }

        void b(a<T>.C0337a aVar, Throwable th2) {
            this.set.a(aVar);
            onError(th2);
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
        public void clear() {
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, xn.b
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, xn.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
        public boolean isEmpty() {
            return true;
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
                C0337a aVar = new C0337a();
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

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
        public T poll() throws Exception {
            return null;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.c
        public int requestFusion(int i10) {
            return i10 & 2;
        }
    }

    public w0(p<T> pVar, o<? super T, ? extends c> oVar, boolean z10) {
        super(pVar);
        this.f29102b = oVar;
        this.f29103c = z10;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f29102b, this.f29103c));
    }
}
