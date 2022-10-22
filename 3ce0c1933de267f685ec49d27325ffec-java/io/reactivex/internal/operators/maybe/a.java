package io.reactivex.internal.operators.maybe;

import io.reactivex.e;
import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import xn.b;
/* compiled from: MaybeToFlowable.java */
/* loaded from: classes2.dex */
public final class a<T> extends e<T> {

    /* renamed from: b  reason: collision with root package name */
    final i<T> f28389b;

    /* compiled from: MaybeToFlowable.java */
    /* renamed from: io.reactivex.internal.operators.maybe.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0319a<T> extends DeferredScalarSubscription<T> implements h<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        b upstream;

        C0319a(vp.b<? super T> bVar) {
            super(bVar);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vp.c
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        @Override // io.reactivex.h
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.h
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.h
        public void onSubscribe(b bVar) {
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

    public a(i<T> iVar) {
        this.f28389b = iVar;
    }

    @Override // io.reactivex.e
    protected void h(vp.b<? super T> bVar) {
        this.f28389b.b(new C0319a(bVar));
    }
}
