package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReferenceArray;
import vp.c;
import xn.b;
/* loaded from: classes3.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<c> implements b {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int i10) {
        super(i10);
    }

    @Override // xn.b
    public void dispose() {
        c andSet;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i10 = 0; i10 < length; i10++) {
                c cVar = get(i10);
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (!(cVar == subscriptionHelper || (andSet = getAndSet(i10, subscriptionHelper)) == subscriptionHelper || andSet == null)) {
                    andSet.cancel();
                }
            }
        }
    }

    @Override // xn.b
    public boolean isDisposed() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }

    public c replaceResource(int i10, c cVar) {
        c cVar2;
        do {
            cVar2 = get(i10);
            if (cVar2 == SubscriptionHelper.CANCELLED) {
                if (cVar == null) {
                    return null;
                }
                cVar.cancel();
                return null;
            }
        } while (!compareAndSet(i10, cVar2, cVar));
        return cVar2;
    }

    public boolean setResource(int i10, c cVar) {
        c cVar2;
        do {
            cVar2 = get(i10);
            if (cVar2 == SubscriptionHelper.CANCELLED) {
                if (cVar == null) {
                    return false;
                }
                cVar.cancel();
                return false;
            }
        } while (!compareAndSet(i10, cVar2, cVar));
        if (cVar2 == null) {
            return true;
        }
        cVar2.cancel();
        return true;
    }
}
