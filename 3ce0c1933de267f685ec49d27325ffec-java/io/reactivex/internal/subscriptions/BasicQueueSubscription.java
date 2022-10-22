package io.reactivex.internal.subscriptions;

import co.d;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes3.dex */
public abstract class BasicQueueSubscription<T> extends AtomicLong implements d<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    @Override // vp.c
    public abstract /* synthetic */ void cancel();

    @Override // co.g
    public abstract /* synthetic */ void clear();

    @Override // co.g
    public abstract /* synthetic */ boolean isEmpty();

    @Override // co.g
    public final boolean offer(T t10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // co.g
    public abstract /* synthetic */ T poll() throws Exception;

    @Override // vp.c
    public abstract /* synthetic */ void request(long j10);

    @Override // co.c
    public abstract /* synthetic */ int requestFusion(int i10);

    public final boolean offer(T t10, T t11) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
