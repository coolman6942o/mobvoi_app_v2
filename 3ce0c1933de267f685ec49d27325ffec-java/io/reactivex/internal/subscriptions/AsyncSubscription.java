package io.reactivex.internal.subscriptions;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import vp.c;
import xn.b;
/* loaded from: classes3.dex */
public final class AsyncSubscription extends AtomicLong implements c, b {
    private static final long serialVersionUID = 7028635084060361255L;
    final AtomicReference<c> actual;
    final AtomicReference<b> resource;

    public AsyncSubscription() {
        this.resource = new AtomicReference<>();
        this.actual = new AtomicReference<>();
    }

    @Override // vp.c
    public void cancel() {
        dispose();
    }

    @Override // xn.b
    public void dispose() {
        SubscriptionHelper.cancel(this.actual);
        DisposableHelper.dispose(this.resource);
    }

    @Override // xn.b
    public boolean isDisposed() {
        return this.actual.get() == SubscriptionHelper.CANCELLED;
    }

    public boolean replaceResource(b bVar) {
        return DisposableHelper.replace(this.resource, bVar);
    }

    @Override // vp.c
    public void request(long j10) {
        SubscriptionHelper.deferredRequest(this.actual, this, j10);
    }

    public boolean setResource(b bVar) {
        return DisposableHelper.set(this.resource, bVar);
    }

    public void setSubscription(c cVar) {
        SubscriptionHelper.deferredSetOnce(this.actual, this, cVar);
    }

    public AsyncSubscription(b bVar) {
        this();
        this.resource.lazySet(bVar);
    }
}
