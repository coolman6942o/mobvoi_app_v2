package rx.internal.subscriptions;

import rx.j;
/* loaded from: classes3.dex */
public enum Unsubscribed implements j {
    INSTANCE;

    @Override // rx.j
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // rx.j
    public void unsubscribe() {
    }
}
