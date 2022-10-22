package io.reactivex.internal.subscriptions;

import co.d;
import vp.b;
/* loaded from: classes3.dex */
public enum EmptySubscription implements d<Object> {
    INSTANCE;

    public static void complete(b<?> bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onComplete();
    }

    public static void error(Throwable th2, b<?> bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th2);
    }

    @Override // vp.c
    public void cancel() {
    }

    @Override // co.g
    public void clear() {
    }

    @Override // co.g
    public boolean isEmpty() {
        return true;
    }

    @Override // co.g
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // co.g
    public Object poll() {
        return null;
    }

    @Override // vp.c
    public void request(long j10) {
        SubscriptionHelper.validate(j10);
    }

    @Override // co.c
    public int requestFusion(int i10) {
        return i10 & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
