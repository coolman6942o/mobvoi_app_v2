package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import xn.b;
import zn.e;
/* compiled from: ObservableRepeatUntil.java */
/* loaded from: classes3.dex */
public final class n2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final e f28870b;

    /* compiled from: ObservableRepeatUntil.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements r<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final r<? super T> downstream;
        final p<? extends T> source;
        final e stop;
        final SequentialDisposable upstream;

        a(r<? super T> rVar, e eVar, SequentialDisposable sequentialDisposable, p<? extends T> pVar) {
            this.downstream = rVar;
            this.upstream = sequentialDisposable;
            this.source = pVar;
            this.stop = eVar;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i10 = 1;
                do {
                    this.source.subscribe(this);
                    i10 = addAndGet(-i10);
                } while (i10 != 0);
            }
        }

        @Override // io.reactivex.r
        public void onComplete() {
            try {
                if (this.stop.a()) {
                    this.downstream.onComplete();
                } else {
                    a();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.downstream.onError(th2);
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
            this.upstream.replace(bVar);
        }
    }

    public n2(k<T> kVar, e eVar) {
        super(kVar);
        this.f28870b = eVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        rVar.onSubscribe(sequentialDisposable);
        new a(rVar, this.f28870b, sequentialDisposable, this.f28426a).a();
    }
}
