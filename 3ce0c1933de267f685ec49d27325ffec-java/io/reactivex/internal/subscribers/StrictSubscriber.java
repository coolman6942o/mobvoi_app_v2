package io.reactivex.internal.subscribers;

import io.reactivex.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import vp.b;
import vp.c;
/* loaded from: classes3.dex */
public class StrictSubscriber<T> extends AtomicInteger implements f<T>, c {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final b<? super T> downstream;
    final AtomicThrowable error = new AtomicThrowable();
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<c> upstream = new AtomicReference<>();
    final AtomicBoolean once = new AtomicBoolean();

    public StrictSubscriber(b<? super T> bVar) {
        this.downstream = bVar;
    }

    @Override // vp.c
    public void cancel() {
        if (!this.done) {
            SubscriptionHelper.cancel(this.upstream);
        }
    }

    @Override // vp.b
    public void onComplete() {
        this.done = true;
        g.b(this.downstream, this, this.error);
    }

    @Override // vp.b
    public void onError(Throwable th2) {
        this.done = true;
        g.d(this.downstream, th2, this, this.error);
    }

    @Override // vp.b
    public void onNext(T t10) {
        g.f(this.downstream, t10, this, this.error);
    }

    @Override // vp.b
    public void onSubscribe(c cVar) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, cVar);
            return;
        }
        cVar.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    @Override // vp.c
    public void request(long j10) {
        if (j10 <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j10));
            return;
        }
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j10);
    }
}
