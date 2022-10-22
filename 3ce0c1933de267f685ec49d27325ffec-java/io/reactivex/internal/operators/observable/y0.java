package io.reactivex.internal.operators.observable;

import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.o;
/* compiled from: ObservableFlatMapMaybe.java */
/* loaded from: classes3.dex */
public final class y0<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends i<? extends R>> f29137b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f29138c;

    /* compiled from: ObservableFlatMapMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements r<T>, b {
        private static final long serialVersionUID = 8600231336733376951L;
        volatile boolean cancelled;
        final boolean delayErrors;
        final r<? super R> downstream;
        final o<? super T, ? extends i<? extends R>> mapper;
        b upstream;
        final xn.a set = new xn.a();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<io.reactivex.internal.queue.b<R>> queue = new AtomicReference<>();

        /* compiled from: ObservableFlatMapMaybe.java */
        /* renamed from: io.reactivex.internal.operators.observable.y0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0340a extends AtomicReference<b> implements h<R>, b {
            private static final long serialVersionUID = -502562646270949838L;

            C0340a() {
            }

            @Override // xn.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // xn.b
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.h
            public void onComplete() {
                a.this.g(this);
            }

            @Override // io.reactivex.h
            public void onError(Throwable th2) {
                a.this.h(this, th2);
            }

            @Override // io.reactivex.h
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.h
            public void onSuccess(R r10) {
                a.this.i(this, r10);
            }
        }

        a(r<? super R> rVar, o<? super T, ? extends i<? extends R>> oVar, boolean z10) {
            this.downstream = rVar;
            this.mapper = oVar;
            this.delayErrors = z10;
        }

        void a() {
            io.reactivex.internal.queue.b<R> bVar = this.queue.get();
            if (bVar != null) {
                bVar.clear();
            }
        }

        void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        void c() {
            r<? super R> rVar = this.downstream;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<io.reactivex.internal.queue.b<R>> atomicReference = this.queue;
            int i10 = 1;
            while (!this.cancelled) {
                if (this.delayErrors || this.errors.get() == null) {
                    boolean z10 = false;
                    boolean z11 = atomicInteger.get() == 0;
                    io.reactivex.internal.queue.b<R> bVar = atomicReference.get();
                    R poll = bVar != null ? bVar.poll() : (Object) null;
                    if (poll == null) {
                        z10 = true;
                    }
                    if (z11 && z10) {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            rVar.onError(terminate);
                            return;
                        } else {
                            rVar.onComplete();
                            return;
                        }
                    } else if (z10) {
                        i10 = addAndGet(-i10);
                        if (i10 == 0) {
                            return;
                        }
                    } else {
                        rVar.onNext(poll);
                    }
                } else {
                    Throwable terminate2 = this.errors.terminate();
                    a();
                    rVar.onError(terminate2);
                    return;
                }
            }
            a();
        }

        io.reactivex.internal.queue.b<R> d() {
            io.reactivex.internal.queue.b<R> bVar;
            do {
                io.reactivex.internal.queue.b<R> bVar2 = this.queue.get();
                if (bVar2 != null) {
                    return bVar2;
                }
                bVar = new io.reactivex.internal.queue.b<>(k.bufferSize());
            } while (!this.queue.compareAndSet(null, bVar));
            return bVar;
        }

        @Override // xn.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        void g(a<T, R>.C0340a aVar) {
            this.set.a(aVar);
            if (get() == 0) {
                boolean z10 = false;
                if (compareAndSet(0, 1)) {
                    if (this.active.decrementAndGet() == 0) {
                        z10 = true;
                    }
                    io.reactivex.internal.queue.b<R> bVar = this.queue.get();
                    if (z10 && (bVar == null || bVar.isEmpty())) {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            this.downstream.onError(terminate);
                            return;
                        } else {
                            this.downstream.onComplete();
                            return;
                        }
                    } else if (decrementAndGet() != 0) {
                        c();
                        return;
                    } else {
                        return;
                    }
                }
            }
            this.active.decrementAndGet();
            b();
        }

        void h(a<T, R>.C0340a aVar, Throwable th2) {
            this.set.a(aVar);
            if (this.errors.addThrowable(th2)) {
                if (!this.delayErrors) {
                    this.upstream.dispose();
                    this.set.dispose();
                }
                this.active.decrementAndGet();
                b();
                return;
            }
            fo.a.s(th2);
        }

        void i(a<T, R>.C0340a aVar, R r10) {
            this.set.a(aVar);
            if (get() == 0) {
                boolean z10 = false;
                if (compareAndSet(0, 1)) {
                    this.downstream.onNext(r10);
                    if (this.active.decrementAndGet() == 0) {
                        z10 = true;
                    }
                    io.reactivex.internal.queue.b<R> bVar = this.queue.get();
                    if (!z10 || (bVar != null && !bVar.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        c();
                    }
                    Throwable terminate = this.errors.terminate();
                    if (terminate != null) {
                        this.downstream.onError(terminate);
                        return;
                    } else {
                        this.downstream.onComplete();
                        return;
                    }
                }
            }
            io.reactivex.internal.queue.b<R> d10 = d();
            synchronized (d10) {
                d10.offer(r10);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.active.decrementAndGet();
            b();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.active.decrementAndGet();
            if (this.errors.addThrowable(th2)) {
                if (!this.delayErrors) {
                    this.set.dispose();
                }
                b();
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            try {
                i iVar = (i) bo.b.e(this.mapper.apply(t10), "The mapper returned a null MaybeSource");
                this.active.getAndIncrement();
                C0340a aVar = new C0340a();
                if (!this.cancelled && this.set.b(aVar)) {
                    iVar.b(aVar);
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

    public y0(p<T> pVar, o<? super T, ? extends i<? extends R>> oVar, boolean z10) {
        super(pVar);
        this.f29137b = oVar;
        this.f29138c = z10;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super R> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f29137b, this.f29138c));
    }
}
