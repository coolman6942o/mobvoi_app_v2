package io.reactivex.internal.subscribers;

import io.reactivex.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import vp.c;
/* loaded from: classes3.dex */
public final class BlockingSubscriber<T> extends AtomicReference<c> implements f<T>, c {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public BlockingSubscriber(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // vp.c
    public void cancel() {
        if (SubscriptionHelper.cancel(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    public boolean isCancelled() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // vp.b
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // vp.b
    public void onError(Throwable th2) {
        this.queue.offer(NotificationLite.error(th2));
    }

    @Override // vp.b
    public void onNext(T t10) {
        this.queue.offer(NotificationLite.next(t10));
    }

    @Override // vp.b
    public void onSubscribe(c cVar) {
        if (SubscriptionHelper.setOnce(this, cVar)) {
            this.queue.offer(NotificationLite.subscription(this));
        }
    }

    @Override // vp.c
    public void request(long j10) {
        get().request(j10);
    }
}
