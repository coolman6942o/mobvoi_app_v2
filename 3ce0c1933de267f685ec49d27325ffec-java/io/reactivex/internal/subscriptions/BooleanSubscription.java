package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicBoolean;
import vp.c;
/* loaded from: classes3.dex */
public final class BooleanSubscription extends AtomicBoolean implements c {
    private static final long serialVersionUID = -8127758972444290902L;

    @Override // vp.c
    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    @Override // vp.c
    public void request(long j10) {
        SubscriptionHelper.validate(j10);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + ")";
    }
}
