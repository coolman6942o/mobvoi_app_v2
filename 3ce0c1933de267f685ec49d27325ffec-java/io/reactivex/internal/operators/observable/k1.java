package io.reactivex.internal.operators.observable;

import io.reactivex.p;
import io.reactivex.r;
import xn.b;
/* compiled from: ObservableIgnoreElements.java */
/* loaded from: classes3.dex */
public final class k1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* compiled from: ObservableIgnoreElements.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28779a;

        /* renamed from: b  reason: collision with root package name */
        b f28780b;

        a(r<? super T> rVar) {
            this.f28779a = rVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28780b.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28780b.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28779a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28779a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            this.f28780b = bVar;
            this.f28779a.onSubscribe(this);
        }
    }

    public k1(p<T> pVar) {
        super(pVar);
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar));
    }
}
