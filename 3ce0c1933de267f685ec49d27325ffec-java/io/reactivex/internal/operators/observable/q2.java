package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import xn.b;
import zn.d;
/* compiled from: ObservableRetryBiPredicate.java */
/* loaded from: classes3.dex */
public final class q2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final d<? super Integer, ? super Throwable> f28988b;

    /* compiled from: ObservableRetryBiPredicate.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements r<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final r<? super T> downstream;
        final d<? super Integer, ? super Throwable> predicate;
        int retries;
        final p<? extends T> source;
        final SequentialDisposable upstream;

        a(r<? super T> rVar, d<? super Integer, ? super Throwable> dVar, SequentialDisposable sequentialDisposable, p<? extends T> pVar) {
            this.downstream = rVar;
            this.upstream = sequentialDisposable;
            this.source = pVar;
            this.predicate = dVar;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i10 = 1;
                while (!this.upstream.isDisposed()) {
                    this.source.subscribe(this);
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            try {
                d<? super Integer, ? super Throwable> dVar = this.predicate;
                int i10 = this.retries + 1;
                this.retries = i10;
                if (!dVar.test(Integer.valueOf(i10), th2)) {
                    this.downstream.onError(th2);
                } else {
                    a();
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            this.upstream.replace(bVar);
        }
    }

    public q2(k<T> kVar, d<? super Integer, ? super Throwable> dVar) {
        super(kVar);
        this.f28988b = dVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        rVar.onSubscribe(sequentialDisposable);
        new a(rVar, this.f28988b, sequentialDisposable, this.f28426a).a();
    }
}
