package io.reactivex.internal.operators.mixed;

import co.g;
import io.reactivex.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.f;
import io.reactivex.k;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.o;
/* compiled from: ObservableConcatMapCompletable.java */
/* loaded from: classes2.dex */
public final class a<T> extends io.reactivex.a {

    /* renamed from: a  reason: collision with root package name */
    final k<T> f28390a;

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends c> f28391b;

    /* renamed from: c  reason: collision with root package name */
    final ErrorMode f28392c;

    /* renamed from: d  reason: collision with root package name */
    final int f28393d;

    /* compiled from: ObservableConcatMapCompletable.java */
    /* renamed from: io.reactivex.internal.operators.mixed.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0320a<T> extends AtomicInteger implements r<T>, b {
        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        volatile boolean disposed;
        volatile boolean done;
        final io.reactivex.b downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final C0321a inner = new C0321a(this);
        final o<? super T, ? extends c> mapper;
        final int prefetch;
        g<T> queue;
        b upstream;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMapCompletable.java */
        /* renamed from: io.reactivex.internal.operators.mixed.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0321a extends AtomicReference<b> implements io.reactivex.b {
            private static final long serialVersionUID = 5638352172918776687L;
            final C0320a<?> parent;

            C0321a(C0320a<?> aVar) {
                this.parent = aVar;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.b
            public void onComplete() {
                this.parent.b();
            }

            @Override // io.reactivex.b
            public void onError(Throwable th2) {
                this.parent.c(th2);
            }

            @Override // io.reactivex.b
            public void onSubscribe(b bVar) {
                DisposableHelper.replace(this, bVar);
            }
        }

        C0320a(io.reactivex.b bVar, o<? super T, ? extends c> oVar, ErrorMode errorMode, int i10) {
            this.downstream = bVar;
            this.mapper = oVar;
            this.errorMode = errorMode;
            this.prefetch = i10;
        }

        void a() {
            boolean z10;
            if (getAndIncrement() == 0) {
                AtomicThrowable atomicThrowable = this.errors;
                ErrorMode errorMode = this.errorMode;
                while (!this.disposed) {
                    if (!this.active) {
                        if (errorMode != ErrorMode.BOUNDARY || atomicThrowable.get() == null) {
                            boolean z11 = this.done;
                            c cVar = null;
                            try {
                                T poll = this.queue.poll();
                                if (poll != null) {
                                    cVar = (c) bo.b.e(this.mapper.apply(poll), "The mapper returned a null CompletableSource");
                                    z10 = false;
                                } else {
                                    z10 = true;
                                }
                                if (z11 && z10) {
                                    this.disposed = true;
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate != null) {
                                        this.downstream.onError(terminate);
                                        return;
                                    } else {
                                        this.downstream.onComplete();
                                        return;
                                    }
                                } else if (!z10) {
                                    this.active = true;
                                    cVar.b(this.inner);
                                }
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.b(th2);
                                this.disposed = true;
                                this.queue.clear();
                                this.upstream.dispose();
                                atomicThrowable.addThrowable(th2);
                                this.downstream.onError(atomicThrowable.terminate());
                                return;
                            }
                        } else {
                            this.disposed = true;
                            this.queue.clear();
                            this.downstream.onError(atomicThrowable.terminate());
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

        void c(Throwable th2) {
            if (!this.errors.addThrowable(th2)) {
                fo.a.s(th2);
            } else if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.disposed = true;
                this.upstream.dispose();
                Throwable terminate = this.errors.terminate();
                if (terminate != f.f29256a) {
                    this.downstream.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            } else {
                this.active = false;
                a();
            }
        }

        @Override // xn.b
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.inner.a();
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
            this.done = true;
            a();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (!this.errors.addThrowable(th2)) {
                fo.a.s(th2);
            } else if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.disposed = true;
                this.inner.a();
                Throwable terminate = this.errors.terminate();
                if (terminate != f.f29256a) {
                    this.downstream.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            } else {
                this.done = true;
                a();
            }
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (t10 != null) {
                this.queue.offer(t10);
            }
            a();
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof co.b) {
                    co.b bVar2 = (co.b) bVar;
                    int requestFusion = bVar2.requestFusion(3);
                    if (requestFusion == 1) {
                        this.queue = bVar2;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.queue = bVar2;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.b(this.prefetch);
                this.downstream.onSubscribe(this);
            }
        }
    }

    public a(k<T> kVar, o<? super T, ? extends c> oVar, ErrorMode errorMode, int i10) {
        this.f28390a = kVar;
        this.f28391b = oVar;
        this.f28392c = errorMode;
        this.f28393d = i10;
    }

    @Override // io.reactivex.a
    protected void c(io.reactivex.b bVar) {
        if (!g.a(this.f28390a, this.f28391b, bVar)) {
            this.f28390a.subscribe(new C0320a(bVar, this.f28391b, this.f28392c, this.f28393d));
        }
    }
}
