package io.reactivex.internal.operators.maybe;

import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.k;
import io.reactivex.r;
/* compiled from: MaybeToObservable.java */
/* loaded from: classes2.dex */
public final class b<T> extends k<T> {

    /* compiled from: MaybeToObservable.java */
    /* loaded from: classes2.dex */
    static final class a<T> extends DeferredScalarDisposable<T> implements h<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        xn.b upstream;

        a(r<? super T> rVar) {
            super(rVar);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, xn.b
        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // io.reactivex.h
        public void onComplete() {
            complete();
        }

        @Override // io.reactivex.h
        public void onError(Throwable th2) {
            error(th2);
        }

        @Override // io.reactivex.h
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.h
        public void onSuccess(T t10) {
            complete(t10);
        }
    }

    public static <T> h<T> b(r<? super T> rVar) {
        return new a(rVar);
    }
}
