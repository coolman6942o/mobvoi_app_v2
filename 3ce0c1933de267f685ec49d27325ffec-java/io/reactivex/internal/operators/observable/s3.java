package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.r;
import io.reactivex.s;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: ObservableThrottleLatest.java */
/* loaded from: classes3.dex */
public final class s3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f29035b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f29036c;

    /* renamed from: d  reason: collision with root package name */
    final s f29037d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f29038e;

    /* compiled from: ObservableThrottleLatest.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements r<T>, b, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        volatile boolean cancelled;
        volatile boolean done;
        final r<? super T> downstream;
        final boolean emitLast;
        Throwable error;
        final AtomicReference<T> latest = new AtomicReference<>();
        final long timeout;
        volatile boolean timerFired;
        boolean timerRunning;
        final TimeUnit unit;
        b upstream;
        final s.c worker;

        a(r<? super T> rVar, long j10, TimeUnit timeUnit, s.c cVar, boolean z10) {
            this.downstream = rVar;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = cVar;
            this.emitLast = z10;
        }

        void a() {
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.latest;
                r<? super T> rVar = this.downstream;
                int i10 = 1;
                while (!this.cancelled) {
                    boolean z10 = this.done;
                    if (!z10 || this.error == null) {
                        boolean z11 = atomicReference.get() == null;
                        if (z10) {
                            T andSet = atomicReference.getAndSet(null);
                            if (!z11 && this.emitLast) {
                                rVar.onNext(andSet);
                            }
                            rVar.onComplete();
                            this.worker.dispose();
                            return;
                        }
                        if (z11) {
                            if (this.timerFired) {
                                this.timerRunning = false;
                                this.timerFired = false;
                            }
                        } else if (!this.timerRunning || this.timerFired) {
                            rVar.onNext(atomicReference.getAndSet(null));
                            this.timerFired = false;
                            this.timerRunning = true;
                            this.worker.c(this, this.timeout, this.unit);
                        }
                        i10 = addAndGet(-i10);
                        if (i10 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.lazySet(null);
                        rVar.onError(this.error);
                        this.worker.dispose();
                        return;
                    }
                }
                atomicReference.lazySet(null);
            }
        }

        @Override // xn.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.latest.lazySet(null);
            }
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
            this.error = th2;
            this.done = true;
            a();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.latest.set(t10);
            a();
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.timerFired = true;
            a();
        }
    }

    public s3(k<T> kVar, long j10, TimeUnit timeUnit, s sVar, boolean z10) {
        super(kVar);
        this.f29035b = j10;
        this.f29036c = timeUnit;
        this.f29037d = sVar;
        this.f29038e = z10;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f29035b, this.f29036c, this.f29037d.a(), this.f29038e));
    }
}
