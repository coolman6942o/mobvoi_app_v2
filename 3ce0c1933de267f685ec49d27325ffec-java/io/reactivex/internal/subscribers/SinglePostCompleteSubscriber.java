package io.reactivex.internal.subscribers;

import io.reactivex.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import vp.b;
import vp.c;
/* loaded from: classes3.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements f<T>, c {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final b<? super R> downstream;
    protected long produced;
    protected c upstream;
    protected R value;

    public SinglePostCompleteSubscriber(b<? super R> bVar) {
        this.downstream = bVar;
    }

    @Override // vp.c
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // vp.b
    public abstract /* synthetic */ void onComplete();

    @Override // vp.b
    public abstract /* synthetic */ void onError(Throwable th2);

    @Override // vp.b
    public abstract /* synthetic */ void onNext(T t10);

    @Override // vp.b
    public void onSubscribe(c cVar) {
        if (SubscriptionHelper.validate(this.upstream, cVar)) {
            this.upstream = cVar;
            this.downstream.onSubscribe(this);
        }
    }

    @Override // vp.c
    public final void request(long j10) {
        long j11;
        if (SubscriptionHelper.validate(j10)) {
            do {
                j11 = get();
                if ((j11 & COMPLETE_MASK) != 0) {
                    if (compareAndSet(COMPLETE_MASK, -9223372036854775807L)) {
                        this.downstream.onNext((R) this.value);
                        this.downstream.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j11, io.reactivex.internal.util.b.b(j11, j10)));
            this.upstream.request(j10);
        }
    }
}
