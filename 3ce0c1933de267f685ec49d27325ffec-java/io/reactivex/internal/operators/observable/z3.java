package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.s;
import java.util.concurrent.atomic.AtomicBoolean;
import xn.b;
/* compiled from: ObservableUnsubscribeOn.java */
/* loaded from: classes3.dex */
public final class z3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final s f29162b;

    /* compiled from: ObservableUnsubscribeOn.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicBoolean implements r<T>, b {
        private static final long serialVersionUID = 1015244841293359600L;
        final r<? super T> downstream;
        final s scheduler;
        b upstream;

        /* compiled from: ObservableUnsubscribeOn.java */
        /* renamed from: io.reactivex.internal.operators.observable.z3$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class RunnableC0344a implements Runnable {
            RunnableC0344a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.upstream.dispose();
            }
        }

        a(r<? super T> rVar, s sVar) {
            this.downstream = rVar;
            this.scheduler = sVar;
        }

        @Override // xn.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.scheduler.c(new RunnableC0344a());
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (get()) {
                fo.a.s(th2);
            } else {
                this.downstream.onError(th2);
            }
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!get()) {
                this.downstream.onNext(t10);
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

    public z3(p<T> pVar, s sVar) {
        super(pVar);
        this.f29162b = sVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f29162b));
    }
}
