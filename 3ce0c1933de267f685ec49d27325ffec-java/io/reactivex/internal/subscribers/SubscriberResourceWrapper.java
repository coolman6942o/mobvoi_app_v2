package io.reactivex.internal.subscribers;

import io.reactivex.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import vp.c;
import xn.b;
/* loaded from: classes3.dex */
public final class SubscriberResourceWrapper<T> extends AtomicReference<b> implements f<T>, b, c {
    private static final long serialVersionUID = -8612022020200669122L;
    final vp.b<? super T> downstream;
    final AtomicReference<c> upstream = new AtomicReference<>();

    public SubscriberResourceWrapper(vp.b<? super T> bVar) {
        this.downstream = bVar;
    }

    @Override // vp.c
    public void cancel() {
        dispose();
    }

    @Override // xn.b
    public void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // xn.b
    public boolean isDisposed() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // vp.b
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    @Override // vp.b
    public void onError(Throwable th2) {
        DisposableHelper.dispose(this);
        this.downstream.onError(th2);
    }

    @Override // vp.b
    public void onNext(T t10) {
        this.downstream.onNext(t10);
    }

    @Override // vp.b
    public void onSubscribe(c cVar) {
        if (SubscriptionHelper.setOnce(this.upstream, cVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    @Override // vp.c
    public void request(long j10) {
        if (SubscriptionHelper.validate(j10)) {
            this.upstream.get().request(j10);
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.set(this, bVar);
    }
}
