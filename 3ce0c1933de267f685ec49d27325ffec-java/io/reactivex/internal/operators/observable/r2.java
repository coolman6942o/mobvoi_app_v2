package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.k;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import xn.b;
import zn.p;
/* compiled from: ObservableRetryPredicate.java */
/* loaded from: classes3.dex */
public final class r2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final p<? super Throwable> f29014b;

    /* renamed from: c  reason: collision with root package name */
    final long f29015c;

    /* compiled from: ObservableRetryPredicate.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements r<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final r<? super T> downstream;
        final p<? super Throwable> predicate;
        long remaining;
        final io.reactivex.p<? extends T> source;
        final SequentialDisposable upstream;

        a(r<? super T> rVar, long j10, p<? super Throwable> pVar, SequentialDisposable sequentialDisposable, io.reactivex.p<? extends T> pVar2) {
            this.downstream = rVar;
            this.upstream = sequentialDisposable;
            this.source = pVar2;
            this.predicate = pVar;
            this.remaining = j10;
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
            long j10 = this.remaining;
            if (j10 != Long.MAX_VALUE) {
                this.remaining = j10 - 1;
            }
            if (j10 == 0) {
                this.downstream.onError(th2);
                return;
            }
            try {
                if (!this.predicate.test(th2)) {
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

    public r2(k<T> kVar, long j10, p<? super Throwable> pVar) {
        super(kVar);
        this.f29014b = pVar;
        this.f29015c = j10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        rVar.onSubscribe(sequentialDisposable);
        new a(rVar, this.f29015c, this.f29014b, sequentialDisposable, this.f28426a).a();
    }
}
