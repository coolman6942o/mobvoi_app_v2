package rx.internal.subscriptions;

import dq.e;
import java.util.concurrent.atomic.AtomicReference;
import rx.j;
/* loaded from: classes3.dex */
public final class SequentialSubscription extends AtomicReference<j> implements j {
    private static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public j current() {
        j jVar = (j) super.get();
        return jVar == Unsubscribed.INSTANCE ? e.c() : jVar;
    }

    @Override // rx.j
    public boolean isUnsubscribed() {
        return get() == Unsubscribed.INSTANCE;
    }

    public boolean replace(j jVar) {
        j jVar2;
        do {
            jVar2 = get();
            if (jVar2 == Unsubscribed.INSTANCE) {
                if (jVar == null) {
                    return false;
                }
                jVar.unsubscribe();
                return false;
            }
        } while (!compareAndSet(jVar2, jVar));
        return true;
    }

    public boolean replaceWeak(j jVar) {
        j jVar2 = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (jVar2 == unsubscribed) {
            if (jVar != null) {
                jVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(jVar2, jVar) || get() != unsubscribed) {
            return true;
        } else {
            if (jVar != null) {
                jVar.unsubscribe();
            }
            return false;
        }
    }

    @Override // rx.j
    public void unsubscribe() {
        j andSet;
        j jVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (jVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != unsubscribed) {
            andSet.unsubscribe();
        }
    }

    public boolean update(j jVar) {
        j jVar2;
        do {
            jVar2 = get();
            if (jVar2 == Unsubscribed.INSTANCE) {
                if (jVar == null) {
                    return false;
                }
                jVar.unsubscribe();
                return false;
            }
        } while (!compareAndSet(jVar2, jVar));
        if (jVar2 == null) {
            return true;
        }
        jVar2.unsubscribe();
        return true;
    }

    public boolean updateWeak(j jVar) {
        j jVar2 = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (jVar2 == unsubscribed) {
            if (jVar != null) {
                jVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(jVar2, jVar)) {
            return true;
        } else {
            j jVar3 = get();
            if (jVar != null) {
                jVar.unsubscribe();
            }
            return jVar3 == unsubscribed;
        }
    }

    public SequentialSubscription(j jVar) {
        lazySet(jVar);
    }
}
