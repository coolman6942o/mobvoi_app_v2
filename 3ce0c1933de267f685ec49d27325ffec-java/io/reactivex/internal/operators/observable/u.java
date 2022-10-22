package io.reactivex.internal.operators.observable;

import co.g;
import eo.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import zn.o;
/* compiled from: ObservableConcatMap.java */
/* loaded from: classes3.dex */
public final class u<T, U> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends p<? extends U>> f29057b;

    /* renamed from: c  reason: collision with root package name */
    final int f29058c;

    /* renamed from: d  reason: collision with root package name */
    final ErrorMode f29059d;

    /* compiled from: ObservableConcatMap.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements r<T>, xn.b {
        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final r<? super R> downstream;
        final AtomicThrowable error = new AtomicThrowable();
        final o<? super T, ? extends p<? extends R>> mapper;
        final C0336a<R> observer;
        g<T> queue;
        int sourceMode;
        final boolean tillTheEnd;
        xn.b upstream;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMap.java */
        /* renamed from: io.reactivex.internal.operators.observable.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0336a<R> extends AtomicReference<xn.b> implements r<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final r<? super R> downstream;
            final a<?, R> parent;

            C0336a(r<? super R> rVar, a<?, R> aVar) {
                this.downstream = rVar;
                this.parent = aVar;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.r
            public void onComplete() {
                a<?, R> aVar = this.parent;
                aVar.active = false;
                aVar.a();
            }

            @Override // io.reactivex.r
            public void onError(Throwable th2) {
                a<?, R> aVar = this.parent;
                if (aVar.error.addThrowable(th2)) {
                    if (!aVar.tillTheEnd) {
                        aVar.upstream.dispose();
                    }
                    aVar.active = false;
                    aVar.a();
                    return;
                }
                fo.a.s(th2);
            }

            @Override // io.reactivex.r
            public void onNext(R r10) {
                this.downstream.onNext(r10);
            }

            @Override // io.reactivex.r
            public void onSubscribe(xn.b bVar) {
                DisposableHelper.replace(this, bVar);
            }
        }

        a(r<? super R> rVar, o<? super T, ? extends p<? extends R>> oVar, int i10, boolean z10) {
            this.downstream = rVar;
            this.mapper = oVar;
            this.bufferSize = i10;
            this.tillTheEnd = z10;
            this.observer = new C0336a<>(rVar, this);
        }

        void a() {
            if (getAndIncrement() == 0) {
                r<? super R> rVar = this.downstream;
                g<T> gVar = this.queue;
                AtomicThrowable atomicThrowable = this.error;
                while (true) {
                    if (!this.active) {
                        if (this.cancelled) {
                            gVar.clear();
                            return;
                        } else if (this.tillTheEnd || atomicThrowable.get() == null) {
                            boolean z10 = this.done;
                            try {
                                T poll = gVar.poll();
                                boolean z11 = poll == null;
                                if (z10 && z11) {
                                    this.cancelled = true;
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate != null) {
                                        rVar.onError(terminate);
                                        return;
                                    } else {
                                        rVar.onComplete();
                                        return;
                                    }
                                } else if (!z11) {
                                    try {
                                        p pVar = (p) bo.b.e(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                        if (pVar instanceof Callable) {
                                            try {
                                                Object obj = (Object) ((Callable) pVar).call();
                                                if (obj != 0 && !this.cancelled) {
                                                    rVar.onNext(obj);
                                                }
                                            } catch (Throwable th2) {
                                                io.reactivex.exceptions.a.b(th2);
                                                atomicThrowable.addThrowable(th2);
                                            }
                                        } else {
                                            this.active = true;
                                            pVar.subscribe(this.observer);
                                        }
                                    } catch (Throwable th3) {
                                        io.reactivex.exceptions.a.b(th3);
                                        this.cancelled = true;
                                        this.upstream.dispose();
                                        gVar.clear();
                                        atomicThrowable.addThrowable(th3);
                                        rVar.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } catch (Throwable th4) {
                                io.reactivex.exceptions.a.b(th4);
                                this.cancelled = true;
                                this.upstream.dispose();
                                atomicThrowable.addThrowable(th4);
                                rVar.onError(atomicThrowable.terminate());
                                return;
                            }
                        } else {
                            gVar.clear();
                            this.cancelled = true;
                            rVar.onError(atomicThrowable.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // xn.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.observer.a();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.error.addThrowable(th2)) {
                this.done = true;
                a();
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (this.sourceMode == 0) {
                this.queue.offer(t10);
            }
            a();
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof co.b) {
                    co.b bVar2 = (co.b) bVar;
                    int requestFusion = bVar2.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar2;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar2;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.b(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }
    }

    /* compiled from: ObservableConcatMap.java */
    /* loaded from: classes3.dex */
    static final class b<T, U> extends AtomicInteger implements r<T>, xn.b {
        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        final r<? super U> downstream;
        int fusionMode;
        final a<U> inner;
        final o<? super T, ? extends p<? extends U>> mapper;
        g<T> queue;
        xn.b upstream;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMap.java */
        /* loaded from: classes3.dex */
        public static final class a<U> extends AtomicReference<xn.b> implements r<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final r<? super U> downstream;
            final b<?, ?> parent;

            a(r<? super U> rVar, b<?, ?> bVar) {
                this.downstream = rVar;
                this.parent = bVar;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.r
            public void onComplete() {
                this.parent.b();
            }

            @Override // io.reactivex.r
            public void onError(Throwable th2) {
                this.parent.dispose();
                this.downstream.onError(th2);
            }

            @Override // io.reactivex.r
            public void onNext(U u10) {
                this.downstream.onNext(u10);
            }

            @Override // io.reactivex.r
            public void onSubscribe(xn.b bVar) {
                DisposableHelper.replace(this, bVar);
            }
        }

        b(r<? super U> rVar, o<? super T, ? extends p<? extends U>> oVar, int i10) {
            this.downstream = rVar;
            this.mapper = oVar;
            this.bufferSize = i10;
            this.inner = new a<>(rVar, this);
        }

        void a() {
            if (getAndIncrement() == 0) {
                while (!this.disposed) {
                    if (!this.active) {
                        boolean z10 = this.done;
                        try {
                            T poll = this.queue.poll();
                            boolean z11 = poll == null;
                            if (z10 && z11) {
                                this.disposed = true;
                                this.downstream.onComplete();
                                return;
                            } else if (!z11) {
                                try {
                                    p pVar = (p) bo.b.e(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                    this.active = true;
                                    pVar.subscribe(this.inner);
                                } catch (Throwable th2) {
                                    io.reactivex.exceptions.a.b(th2);
                                    dispose();
                                    this.queue.clear();
                                    this.downstream.onError(th2);
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            dispose();
                            this.queue.clear();
                            this.downstream.onError(th3);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.queue.clear();
            }
        }

        void b() {
            this.active = false;
            a();
        }

        @Override // xn.b
        public void dispose() {
            this.disposed = true;
            this.inner.a();
            this.upstream.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                a();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.done) {
                fo.a.s(th2);
                return;
            }
            this.done = true;
            dispose();
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.done) {
                if (this.fusionMode == 0) {
                    this.queue.offer(t10);
                }
                a();
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof co.b) {
                    co.b bVar2 = (co.b) bVar;
                    int requestFusion = bVar2.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = bVar2;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = bVar2;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.b(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }
    }

    public u(p<T> pVar, o<? super T, ? extends p<? extends U>> oVar, int i10, ErrorMode errorMode) {
        super(pVar);
        this.f29057b = oVar;
        this.f29059d = errorMode;
        this.f29058c = Math.max(8, i10);
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super U> rVar) {
        if (!ObservableScalarXMap.b(this.f28426a, rVar, this.f29057b)) {
            if (this.f29059d == ErrorMode.IMMEDIATE) {
                this.f28426a.subscribe(new b(new d(rVar), this.f29057b, this.f29058c));
            } else {
                this.f28426a.subscribe(new a(rVar, this.f29057b, this.f29058c, this.f29059d == ErrorMode.END));
            }
        }
    }
}
