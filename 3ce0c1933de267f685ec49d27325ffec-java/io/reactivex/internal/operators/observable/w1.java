package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
/* compiled from: ObservableMaterialize.java */
/* loaded from: classes3.dex */
public final class w1<T> extends io.reactivex.internal.operators.observable.a<T, j<T>> {

    /* compiled from: ObservableMaterialize.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super j<T>> f29104a;

        /* renamed from: b  reason: collision with root package name */
        b f29105b;

        a(r<? super j<T>> rVar) {
            this.f29104a = rVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f29105b.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29105b.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f29104a.onNext(j.a());
            this.f29104a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f29104a.onNext(j.b(th2));
            this.f29104a.onComplete();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f29104a.onNext(j.c(t10));
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f29105b, bVar)) {
                this.f29105b = bVar;
                this.f29104a.onSubscribe(this);
            }
        }
    }

    public w1(p<T> pVar) {
        super(pVar);
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super j<T>> rVar) {
        this.f28426a.subscribe(new a(rVar));
    }
}
