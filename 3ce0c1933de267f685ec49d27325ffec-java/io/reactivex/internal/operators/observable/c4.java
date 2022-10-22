package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.subjects.d;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableWindowBoundary.java */
/* loaded from: classes3.dex */
public final class c4<T, B> extends io.reactivex.internal.operators.observable.a<T, k<T>> {

    /* renamed from: b  reason: collision with root package name */
    final p<B> f28496b;

    /* renamed from: c  reason: collision with root package name */
    final int f28497c;

    /* compiled from: ObservableWindowBoundary.java */
    /* loaded from: classes3.dex */
    static final class a<T, B> extends eo.b<B> {

        /* renamed from: b  reason: collision with root package name */
        final b<T, B> f28498b;

        /* renamed from: c  reason: collision with root package name */
        boolean f28499c;

        a(b<T, B> bVar) {
            this.f28498b = bVar;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28499c) {
                this.f28499c = true;
                this.f28498b.b();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28499c) {
                fo.a.s(th2);
                return;
            }
            this.f28499c = true;
            this.f28498b.c(th2);
        }

        @Override // io.reactivex.r
        public void onNext(B b10) {
            if (!this.f28499c) {
                this.f28498b.d();
            }
        }
    }

    /* compiled from: ObservableWindowBoundary.java */
    /* loaded from: classes3.dex */
    static final class b<T, B> extends AtomicInteger implements r<T>, xn.b, Runnable {
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final int capacityHint;
        volatile boolean done;
        final r<? super k<T>> downstream;
        d<T> window;
        final a<T, B> boundaryObserver = new a<>(this);
        final AtomicReference<xn.b> upstream = new AtomicReference<>();
        final AtomicInteger windows = new AtomicInteger(1);
        final io.reactivex.internal.queue.a<Object> queue = new io.reactivex.internal.queue.a<>();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicBoolean stopWindows = new AtomicBoolean();

        b(r<? super k<T>> rVar, int i10) {
            this.downstream = rVar;
            this.capacityHint = i10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            if (getAndIncrement() == 0) {
                r<? super k<T>> rVar = this.downstream;
                io.reactivex.internal.queue.a<Object> aVar = this.queue;
                AtomicThrowable atomicThrowable = this.errors;
                int i10 = 1;
                while (this.windows.get() != 0) {
                    d<T> dVar = this.window;
                    boolean z10 = this.done;
                    if (!z10 || atomicThrowable.get() == null) {
                        Object poll = aVar.poll();
                        boolean z11 = poll == null;
                        if (z10 && z11) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate == null) {
                                if (dVar != 0) {
                                    this.window = null;
                                    dVar.onComplete();
                                }
                                rVar.onComplete();
                                return;
                            }
                            if (dVar != 0) {
                                this.window = null;
                                dVar.onError(terminate);
                            }
                            rVar.onError(terminate);
                            return;
                        } else if (z11) {
                            i10 = addAndGet(-i10);
                            if (i10 == 0) {
                                return;
                            }
                        } else if (poll != NEXT_WINDOW) {
                            dVar.onNext(poll);
                        } else {
                            if (dVar != 0) {
                                this.window = null;
                                dVar.onComplete();
                            }
                            if (!this.stopWindows.get()) {
                                d<T> e10 = d.e(this.capacityHint, this);
                                this.window = e10;
                                this.windows.getAndIncrement();
                                rVar.onNext(e10);
                            }
                        }
                    } else {
                        aVar.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (dVar != 0) {
                            this.window = null;
                            dVar.onError(terminate2);
                        }
                        rVar.onError(terminate2);
                        return;
                    }
                }
                aVar.clear();
                this.window = null;
            }
        }

        void b() {
            DisposableHelper.dispose(this.upstream);
            this.done = true;
            a();
        }

        void c(Throwable th2) {
            DisposableHelper.dispose(this.upstream);
            if (this.errors.addThrowable(th2)) {
                this.done = true;
                a();
                return;
            }
            fo.a.s(th2);
        }

        void d() {
            this.queue.offer(NEXT_WINDOW);
            a();
        }

        @Override // xn.b
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                this.boundaryObserver.dispose();
                if (this.windows.decrementAndGet() == 0) {
                    DisposableHelper.dispose(this.upstream);
                }
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.boundaryObserver.dispose();
            this.done = true;
            a();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.boundaryObserver.dispose();
            if (this.errors.addThrowable(th2)) {
                this.done = true;
                a();
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.queue.offer(t10);
            a();
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.setOnce(this.upstream, bVar)) {
                d();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.upstream);
            }
        }
    }

    public c4(p<T> pVar, p<B> pVar2, int i10) {
        super(pVar);
        this.f28496b = pVar2;
        this.f28497c = i10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super k<T>> rVar) {
        b bVar = new b(rVar, this.f28497c);
        rVar.onSubscribe(bVar);
        this.f28496b.subscribe(bVar.boundaryObserver);
        this.f28426a.subscribe(bVar);
    }
}
