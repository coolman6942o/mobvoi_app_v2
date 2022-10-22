package dq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.exceptions.a;
import rx.j;
/* compiled from: CompositeSubscription.java */
/* loaded from: classes3.dex */
public final class b implements j {

    /* renamed from: a  reason: collision with root package name */
    private Set<j> f25693a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f25694b;

    private static void d(Collection<j> collection) {
        if (collection != null) {
            ArrayList arrayList = null;
            for (j jVar : collection) {
                try {
                    jVar.unsubscribe();
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            a.d(arrayList);
        }
    }

    public void a(j jVar) {
        if (!jVar.isUnsubscribed()) {
            if (!this.f25694b) {
                synchronized (this) {
                    if (!this.f25694b) {
                        if (this.f25693a == null) {
                            this.f25693a = new HashSet(4);
                        }
                        this.f25693a.add(jVar);
                        return;
                    }
                }
            }
            jVar.unsubscribe();
        }
    }

    public void b() {
        Set<j> set;
        if (!this.f25694b) {
            synchronized (this) {
                if (!this.f25694b && (set = this.f25693a) != null) {
                    this.f25693a = null;
                    d(set);
                }
            }
        }
    }

    public void c(j jVar) {
        Set<j> set;
        if (!this.f25694b) {
            synchronized (this) {
                if (!this.f25694b && (set = this.f25693a) != null) {
                    boolean remove = set.remove(jVar);
                    if (remove) {
                        jVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.j
    public boolean isUnsubscribed() {
        return this.f25694b;
    }

    @Override // rx.j
    public void unsubscribe() {
        if (!this.f25694b) {
            synchronized (this) {
                if (!this.f25694b) {
                    this.f25694b = true;
                    Set<j> set = this.f25693a;
                    this.f25693a = null;
                    d(set);
                }
            }
        }
    }
}
