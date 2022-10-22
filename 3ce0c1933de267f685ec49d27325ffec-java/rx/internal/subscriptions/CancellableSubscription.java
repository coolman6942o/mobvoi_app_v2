package rx.internal.subscriptions;

import bq.c;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.a;
import rx.j;
import yp.e;
/* loaded from: classes3.dex */
public final class CancellableSubscription extends AtomicReference<e> implements j {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(e eVar) {
        super(eVar);
    }

    @Override // rx.j
    public boolean isUnsubscribed() {
        return get() == null;
    }

    @Override // rx.j
    public void unsubscribe() {
        e andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e10) {
                a.e(e10);
                c.i(e10);
            }
        }
    }
}
