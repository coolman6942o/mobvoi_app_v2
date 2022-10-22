package io.reactivex.internal.operators.observable;

import eo.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.s;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: ObservableThrottleFirstTimed.java */
/* loaded from: classes3.dex */
public final class r3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f29016b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f29017c;

    /* renamed from: d  reason: collision with root package name */
    final s f29018d;

    /* compiled from: ObservableThrottleFirstTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<b> implements r<T>, b, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        boolean done;
        final r<? super T> downstream;
        volatile boolean gate;
        final long timeout;
        final TimeUnit unit;
        b upstream;
        final s.c worker;

        a(r<? super T> rVar, long j10, TimeUnit timeUnit, s.c cVar) {
            this.downstream = rVar;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // xn.b
        public void dispose() {
            this.upstream.dispose();
            this.worker.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.done) {
                fo.a.s(th2);
                return;
            }
            this.done = true;
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.gate && !this.done) {
                this.gate = true;
                this.downstream.onNext(t10);
                b bVar = get();
                if (bVar != null) {
                    bVar.dispose();
                }
                DisposableHelper.replace(this, this.worker.c(this, this.timeout, this.unit));
            }
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
            this.gate = false;
        }
    }

    public r3(p<T> pVar, long j10, TimeUnit timeUnit, s sVar) {
        super(pVar);
        this.f29016b = j10;
        this.f29017c = timeUnit;
        this.f29018d = sVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(new d(rVar), this.f29016b, this.f29017c, this.f29018d.a()));
    }
}
