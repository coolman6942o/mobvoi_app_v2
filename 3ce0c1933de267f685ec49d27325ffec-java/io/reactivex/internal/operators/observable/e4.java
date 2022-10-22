package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.subjects.d;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableWindowBoundarySupplier.java */
/* loaded from: classes3.dex */
public final class e4<T, B> extends io.reactivex.internal.operators.observable.a<T, k<T>> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends p<B>> f28575b;

    /* renamed from: c  reason: collision with root package name */
    final int f28576c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableWindowBoundarySupplier.java */
    /* loaded from: classes3.dex */
    public static final class a<T, B> extends eo.b<B> {

        /* renamed from: b  reason: collision with root package name */
        final b<T, B> f28577b;

        /* renamed from: c  reason: collision with root package name */
        boolean f28578c;

        a(b<T, B> bVar) {
            this.f28577b = bVar;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28578c) {
                this.f28578c = true;
                this.f28577b.c();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28578c) {
                fo.a.s(th2);
                return;
            }
            this.f28578c = true;
            this.f28577b.d(th2);
        }

        @Override // io.reactivex.r
        public void onNext(B b10) {
            if (!this.f28578c) {
                this.f28578c = true;
                dispose();
                this.f28577b.g(this);
            }
        }
    }

    /* compiled from: ObservableWindowBoundarySupplier.java */
    /* loaded from: classes3.dex */
    static final class b<T, B> extends AtomicInteger implements r<T>, xn.b, Runnable {
        static final a<Object, Object> BOUNDARY_DISPOSED = new a<>(null);
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final int capacityHint;
        volatile boolean done;
        final r<? super k<T>> downstream;
        final Callable<? extends p<B>> other;
        xn.b upstream;
        d<T> window;
        final AtomicReference<a<T, B>> boundaryObserver = new AtomicReference<>();
        final AtomicInteger windows = new AtomicInteger(1);
        final io.reactivex.internal.queue.a<Object> queue = new io.reactivex.internal.queue.a<>();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicBoolean stopWindows = new AtomicBoolean();

        b(r<? super k<T>> rVar, int i10, Callable<? extends p<B>> callable) {
            this.downstream = rVar;
            this.capacityHint = i10;
            this.other = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            a<Object, Object> aVar = BOUNDARY_DISPOSED;
            xn.b bVar = (xn.b) this.boundaryObserver.getAndSet(aVar);
            if (bVar != null && bVar != aVar) {
                bVar.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b() {
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
                                try {
                                    p pVar = (p) bo.b.e(this.other.call(), "The other Callable returned a null ObservableSource");
                                    a<T, B> aVar2 = new a<>(this);
                                    if (this.boundaryObserver.compareAndSet(null, aVar2)) {
                                        pVar.subscribe(aVar2);
                                        rVar.onNext(e10);
                                    }
                                } catch (Throwable th2) {
                                    io.reactivex.exceptions.a.b(th2);
                                    atomicThrowable.addThrowable(th2);
                                    this.done = true;
                                }
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

        void c() {
            this.upstream.dispose();
            this.done = true;
            b();
        }

        void d(Throwable th2) {
            this.upstream.dispose();
            if (this.errors.addThrowable(th2)) {
                this.done = true;
                b();
                return;
            }
            fo.a.s(th2);
        }

        @Override // xn.b
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                a();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.dispose();
                }
            }
        }

        void g(a<T, B> aVar) {
            this.boundaryObserver.compareAndSet(aVar, null);
            this.queue.offer(NEXT_WINDOW);
            b();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            a();
            this.done = true;
            b();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            a();
            if (this.errors.addThrowable(th2)) {
                this.done = true;
                b();
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.queue.offer(t10);
            b();
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
                this.queue.offer(NEXT_WINDOW);
                b();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }
    }

    public e4(p<T> pVar, Callable<? extends p<B>> callable, int i10) {
        super(pVar);
        this.f28575b = callable;
        this.f28576c = i10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super k<T>> rVar) {
        this.f28426a.subscribe(new b(rVar, this.f28576c, this.f28575b));
    }
}
