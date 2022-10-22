package dq;

import rx.internal.subscriptions.SequentialSubscription;
import rx.j;
/* compiled from: MultipleAssignmentSubscription.java */
/* loaded from: classes3.dex */
public final class c implements j {

    /* renamed from: a  reason: collision with root package name */
    final SequentialSubscription f25695a = new SequentialSubscription();

    public void a(j jVar) {
        if (jVar != null) {
            this.f25695a.replace(jVar);
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    @Override // rx.j
    public boolean isUnsubscribed() {
        return this.f25695a.isUnsubscribed();
    }

    @Override // rx.j
    public void unsubscribe() {
        this.f25695a.unsubscribe();
    }
}
