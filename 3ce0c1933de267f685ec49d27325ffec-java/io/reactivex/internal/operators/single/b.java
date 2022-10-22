package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.k;
import io.reactivex.r;
import io.reactivex.u;
import io.reactivex.v;
/* compiled from: SingleToObservable.java */
/* loaded from: classes3.dex */
public final class b<T> extends k<T> {

    /* renamed from: a  reason: collision with root package name */
    final v<? extends T> f29168a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleToObservable.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends DeferredScalarDisposable<T> implements u<T> {
        private static final long serialVersionUID = 3786543492451018833L;
        xn.b upstream;

        a(r<? super T> rVar) {
            super(rVar);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, xn.b
        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th2) {
            error(th2);
        }

        @Override // io.reactivex.u
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onSuccess(T t10) {
            complete(t10);
        }
    }

    public b(v<? extends T> vVar) {
        this.f29168a = vVar;
    }

    public static <T> u<T> b(r<? super T> rVar) {
        return new a(rVar);
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f29168a.b(b(rVar));
    }
}
