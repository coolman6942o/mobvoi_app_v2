package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
/* compiled from: ObservableHide.java */
/* loaded from: classes3.dex */
public final class j1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* compiled from: ObservableHide.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28753a;

        /* renamed from: b  reason: collision with root package name */
        b f28754b;

        a(r<? super T> rVar) {
            this.f28753a = rVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28754b.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28754b.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28753a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28753a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f28753a.onNext(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28754b, bVar)) {
                this.f28754b = bVar;
                this.f28753a.onSubscribe(this);
            }
        }
    }

    public j1(p<T> pVar) {
        super(pVar);
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar));
    }
}
