package rx.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.exceptions.a;
import rx.j;
/* compiled from: SubscriptionList.java */
/* loaded from: classes3.dex */
public final class i implements j {

    /* renamed from: a  reason: collision with root package name */
    private List<j> f34154a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f34155b;

    public i() {
    }

    private static void c(Collection<j> collection) {
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
            if (!this.f34155b) {
                synchronized (this) {
                    if (!this.f34155b) {
                        List list = this.f34154a;
                        if (list == null) {
                            list = new LinkedList();
                            this.f34154a = list;
                        }
                        list.add(jVar);
                        return;
                    }
                }
            }
            jVar.unsubscribe();
        }
    }

    public void b(j jVar) {
        if (!this.f34155b) {
            synchronized (this) {
                List<j> list = this.f34154a;
                if (!this.f34155b && list != null) {
                    boolean remove = list.remove(jVar);
                    if (remove) {
                        jVar.unsubscribe();
                    }
                }
            }
        }
    }

    @Override // rx.j
    public boolean isUnsubscribed() {
        return this.f34155b;
    }

    @Override // rx.j
    public void unsubscribe() {
        if (!this.f34155b) {
            synchronized (this) {
                if (!this.f34155b) {
                    this.f34155b = true;
                    List<j> list = this.f34154a;
                    this.f34154a = null;
                    c(list);
                }
            }
        }
    }

    public i(j... jVarArr) {
        this.f34154a = new LinkedList(Arrays.asList(jVarArr));
    }

    public i(j jVar) {
        LinkedList linkedList = new LinkedList();
        this.f34154a = linkedList;
        linkedList.add(jVar);
    }
}
