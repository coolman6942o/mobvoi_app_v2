package io.reactivex.internal.subscribers;

import io.reactivex.f;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import vp.b;
import vp.c;
/* loaded from: classes3.dex */
public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements f<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    protected boolean hasValue;
    protected c upstream;

    public DeferredScalarSubscriber(b<? super R> bVar) {
        super(bVar);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vp.c
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // vp.b
    public void onComplete() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            this.downstream.onComplete();
        }
    }

    @Override // vp.b
    public void onError(Throwable th2) {
        this.value = null;
        this.downstream.onError(th2);
    }

    @Override // vp.b
    public abstract /* synthetic */ void onNext(T t10);

    @Override // vp.b
    public void onSubscribe(c cVar) {
        if (SubscriptionHelper.validate(this.upstream, cVar)) {
            this.upstream = cVar;
            this.downstream.onSubscribe(this);
            cVar.request(Long.MAX_VALUE);
        }
    }
}
