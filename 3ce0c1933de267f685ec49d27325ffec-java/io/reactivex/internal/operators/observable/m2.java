package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import xn.b;
/* compiled from: ObservableRepeat.java */
/* loaded from: classes3.dex */
public final class m2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f28841b;

    /* compiled from: ObservableRepeat.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements r<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final r<? super T> downstream;
        long remaining;

        /* renamed from: sd  reason: collision with root package name */
        final SequentialDisposable f28842sd;
        final p<? extends T> source;

        a(r<? super T> rVar, long j10, SequentialDisposable sequentialDisposable, p<? extends T> pVar) {
            this.downstream = rVar;
            this.f28842sd = sequentialDisposable;
            this.source = pVar;
            this.remaining = j10;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i10 = 1;
                while (!this.f28842sd.isDisposed()) {
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
            long j10 = this.remaining;
            if (j10 != Long.MAX_VALUE) {
                this.remaining = j10 - 1;
            }
            if (j10 != 0) {
                a();
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            this.f28842sd.replace(bVar);
        }
    }

    public m2(k<T> kVar, long j10) {
        super(kVar);
        this.f28841b = j10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        rVar.onSubscribe(sequentialDisposable);
        long j10 = this.f28841b;
        long j11 = Long.MAX_VALUE;
        if (j10 != Long.MAX_VALUE) {
            j11 = j10 - 1;
        }
        new a(rVar, j11, sequentialDisposable, this.f28426a).a();
    }
}
