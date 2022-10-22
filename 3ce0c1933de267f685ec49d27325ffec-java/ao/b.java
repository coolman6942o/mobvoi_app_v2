package ao;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.internal.util.f;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* compiled from: ListCompositeDisposable.java */
/* loaded from: classes.dex */
public final class b implements xn.b, a {

    /* renamed from: a  reason: collision with root package name */
    List<xn.b> f4905a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f4906b;

    @Override // ao.a
    public boolean a(xn.b bVar) {
        bo.b.e(bVar, "Disposable item is null");
        if (this.f4906b) {
            return false;
        }
        synchronized (this) {
            if (this.f4906b) {
                return false;
            }
            List<xn.b> list = this.f4905a;
            if (list != null && list.remove(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // ao.a
    public boolean b(xn.b bVar) {
        bo.b.e(bVar, "d is null");
        if (!this.f4906b) {
            synchronized (this) {
                if (!this.f4906b) {
                    List list = this.f4905a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f4905a = list;
                    }
                    list.add(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // ao.a
    public boolean c(xn.b bVar) {
        if (!a(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    void d(List<xn.b> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (xn.b bVar : list) {
                try {
                    bVar.dispose();
                } catch (Throwable th2) {
                    a.b(th2);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw f.d((Throwable) arrayList.get(0));
            }
            throw new CompositeException(arrayList);
        }
    }

    @Override // xn.b
    public void dispose() {
        if (!this.f4906b) {
            synchronized (this) {
                if (!this.f4906b) {
                    this.f4906b = true;
                    List<xn.b> list = this.f4905a;
                    this.f4905a = null;
                    d(list);
                }
            }
        }
    }

    @Override // xn.b
    public boolean isDisposed() {
        return this.f4906b;
    }
}
