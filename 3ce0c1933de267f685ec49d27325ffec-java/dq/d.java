package dq;

import rx.internal.subscriptions.SequentialSubscription;
import rx.j;
/* compiled from: SerialSubscription.java */
/* loaded from: classes3.dex */
public final class d implements j {

    /* renamed from: a  reason: collision with root package name */
    final SequentialSubscription f25696a = new SequentialSubscription();

    public void a(j jVar) {
        if (jVar != null) {
            this.f25696a.update(jVar);
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    @Override // rx.j
    public boolean isUnsubscribed() {
        return this.f25696a.isUnsubscribed();
    }

    @Override // rx.j
    public void unsubscribe() {
        this.f25696a.unsubscribe();
    }
}
