package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.v3;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import zn.o;
/* compiled from: ObservableTimeout.java */
/* loaded from: classes3.dex */
public final class u3<T, U, V> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final p<U> f29067b;

    /* renamed from: c  reason: collision with root package name */
    final o<? super T, ? extends p<V>> f29068c;

    /* renamed from: d  reason: collision with root package name */
    final p<? extends T> f29069d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeout.java */
    /* loaded from: classes3.dex */
    public static final class a extends AtomicReference<xn.b> implements r<Object>, xn.b {
        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final d parent;

        a(long j10, d dVar) {
            this.idx = j10;
            this.parent = dVar;
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.parent.a(this.idx);
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.parent.b(this.idx, th2);
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(Object obj) {
            xn.b bVar = (xn.b) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar != disposableHelper) {
                bVar.dispose();
                lazySet(disposableHelper);
                this.parent.a(this.idx);
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    /* compiled from: ObservableTimeout.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends AtomicReference<xn.b> implements r<T>, xn.b, d {
        private static final long serialVersionUID = -7508389464265974549L;
        final r<? super T> downstream;
        p<? extends T> fallback;
        final o<? super T, ? extends p<?>> itemTimeoutIndicator;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicLong index = new AtomicLong();
        final AtomicReference<xn.b> upstream = new AtomicReference<>();

        b(r<? super T> rVar, o<? super T, ? extends p<?>> oVar, p<? extends T> pVar) {
            this.downstream = rVar;
            this.itemTimeoutIndicator = oVar;
            this.fallback = pVar;
        }

        @Override // io.reactivex.internal.operators.observable.v3.d
        public void a(long j10) {
            if (this.index.compareAndSet(j10, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                p<? extends T> pVar = this.fallback;
                this.fallback = null;
                pVar.subscribe(new v3.a(this.downstream, this));
            }
        }

        @Override // io.reactivex.internal.operators.observable.u3.d
        public void b(long j10, Throwable th2) {
            if (this.index.compareAndSet(j10, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this);
                this.downstream.onError(th2);
                return;
            }
            fo.a.s(th2);
        }

        void c(p<?> pVar) {
            if (pVar != null) {
                a aVar = new a(0L, this);
                if (this.task.replace(aVar)) {
                    pVar.subscribe(aVar);
                }
            }
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.task.dispose();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th2);
                this.task.dispose();
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            long j10 = this.index.get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = 1 + j10;
                if (this.index.compareAndSet(j10, j11)) {
                    xn.b bVar = this.task.get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    this.downstream.onNext(t10);
                    try {
                        p pVar = (p) bo.b.e(this.itemTimeoutIndicator.apply(t10), "The itemTimeoutIndicator returned a null ObservableSource.");
                        a aVar = new a(j11, this);
                        if (this.task.replace(aVar)) {
                            pVar.subscribe(aVar);
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.upstream.get().dispose();
                        this.index.getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th2);
                    }
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    /* compiled from: ObservableTimeout.java */
    /* loaded from: classes3.dex */
    static final class c<T> extends AtomicLong implements r<T>, xn.b, d {
        private static final long serialVersionUID = 3764492702657003550L;
        final r<? super T> downstream;
        final o<? super T, ? extends p<?>> itemTimeoutIndicator;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<xn.b> upstream = new AtomicReference<>();

        c(r<? super T> rVar, o<? super T, ? extends p<?>> oVar) {
            this.downstream = rVar;
            this.itemTimeoutIndicator = oVar;
        }

        @Override // io.reactivex.internal.operators.observable.v3.d
        public void a(long j10) {
            if (compareAndSet(j10, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                this.downstream.onError(new TimeoutException());
            }
        }

        @Override // io.reactivex.internal.operators.observable.u3.d
        public void b(long j10, Throwable th2) {
            if (compareAndSet(j10, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                this.downstream.onError(th2);
                return;
            }
            fo.a.s(th2);
        }

        void c(p<?> pVar) {
            if (pVar != null) {
                a aVar = new a(0L, this);
                if (this.task.replace(aVar)) {
                    pVar.subscribe(aVar);
                }
            }
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.task.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th2);
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            long j10 = get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = 1 + j10;
                if (compareAndSet(j10, j11)) {
                    xn.b bVar = this.task.get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    this.downstream.onNext(t10);
                    try {
                        p pVar = (p) bo.b.e(this.itemTimeoutIndicator.apply(t10), "The itemTimeoutIndicator returned a null ObservableSource.");
                        a aVar = new a(j11, this);
                        if (this.task.replace(aVar)) {
                            pVar.subscribe(aVar);
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.upstream.get().dispose();
                        getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th2);
                    }
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeout.java */
    /* loaded from: classes3.dex */
    public interface d extends v3.d {
        void b(long j10, Throwable th2);
    }

    public u3(k<T> kVar, p<U> pVar, o<? super T, ? extends p<V>> oVar, p<? extends T> pVar2) {
        super(kVar);
        this.f29067b = pVar;
        this.f29068c = oVar;
        this.f29069d = pVar2;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        if (this.f29069d == null) {
            c cVar = new c(rVar, this.f29068c);
            rVar.onSubscribe(cVar);
            cVar.c(this.f29067b);
            this.f28426a.subscribe(cVar);
            return;
        }
        b bVar = new b(rVar, this.f29068c, this.f29069d);
        rVar.onSubscribe(bVar);
        bVar.c(this.f29067b);
        this.f28426a.subscribe(bVar);
    }
}
