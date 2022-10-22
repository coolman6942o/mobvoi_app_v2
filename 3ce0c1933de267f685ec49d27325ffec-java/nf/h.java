package nf;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* compiled from: Observable.java */
/* loaded from: classes2.dex */
public class h<T> {

    /* renamed from: a  reason: collision with root package name */
    List<k<T>> f31237a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    boolean f31238b = false;

    public void a(k<T> kVar) {
        Objects.requireNonNull(kVar, "observer == null");
        synchronized (this) {
            if (!this.f31237a.contains(kVar)) {
                this.f31237a.add(kVar);
            }
        }
    }

    protected void b() {
        this.f31238b = false;
    }

    public synchronized void c(k<T> kVar) {
        this.f31237a.remove(kVar);
    }

    public synchronized void d() {
        this.f31237a.clear();
    }

    public boolean e() {
        return this.f31238b;
    }

    public void f(T t10) {
        k[] kVarArr;
        synchronized (this) {
            if (e()) {
                b();
                kVarArr = new k[this.f31237a.size()];
                this.f31237a.toArray(kVarArr);
            } else {
                kVarArr = null;
            }
        }
        if (kVarArr != null) {
            for (k kVar : kVarArr) {
                kVar.i(this, t10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        this.f31238b = true;
    }
}
