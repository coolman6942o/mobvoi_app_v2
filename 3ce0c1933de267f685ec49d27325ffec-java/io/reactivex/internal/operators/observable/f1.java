package io.reactivex.internal.operators.observable;

import io.reactivex.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import io.reactivex.r;
import vp.c;
import xn.b;
/* compiled from: ObservableFromPublisher.java */
/* loaded from: classes3.dex */
public final class f1<T> extends k<T> {

    /* renamed from: a  reason: collision with root package name */
    final vp.a<? extends T> f28599a;

    /* compiled from: ObservableFromPublisher.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements f<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28600a;

        /* renamed from: b  reason: collision with root package name */
        c f28601b;

        a(r<? super T> rVar) {
            this.f28600a = rVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28601b.cancel();
            this.f28601b = SubscriptionHelper.CANCELLED;
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28601b == SubscriptionHelper.CANCELLED;
        }

        @Override // vp.b
        public void onComplete() {
            this.f28600a.onComplete();
        }

        @Override // vp.b
        public void onError(Throwable th2) {
            this.f28600a.onError(th2);
        }

        @Override // vp.b
        public void onNext(T t10) {
            this.f28600a.onNext(t10);
        }

        @Override // vp.b
        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.validate(this.f28601b, cVar)) {
                this.f28601b = cVar;
                this.f28600a.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }

    public f1(vp.a<? extends T> aVar) {
        this.f28599a = aVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28599a.a(new a(rVar));
    }
}
