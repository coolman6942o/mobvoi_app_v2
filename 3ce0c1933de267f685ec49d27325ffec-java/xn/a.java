package xn;

import bo.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.f;
import io.reactivex.internal.util.i;
import java.util.ArrayList;
/* compiled from: CompositeDisposable.java */
/* loaded from: classes2.dex */
public final class a implements b, ao.a {

    /* renamed from: a  reason: collision with root package name */
    i<b> f36620a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f36621b;

    @Override // ao.a
    public boolean a(b bVar) {
        b.e(bVar, "disposables is null");
        if (this.f36621b) {
            return false;
        }
        synchronized (this) {
            if (this.f36621b) {
                return false;
            }
            i<b> iVar = this.f36620a;
            if (iVar != null && iVar.e(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // ao.a
    public boolean b(b bVar) {
        b.e(bVar, "disposable is null");
        if (!this.f36621b) {
            synchronized (this) {
                if (!this.f36621b) {
                    i<b> iVar = this.f36620a;
                    if (iVar == null) {
                        iVar = new i<>();
                        this.f36620a = iVar;
                    }
                    iVar.a(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // ao.a
    public boolean c(b bVar) {
        if (!a(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    public void d() {
        if (!this.f36621b) {
            synchronized (this) {
                if (!this.f36621b) {
                    i<b> iVar = this.f36620a;
                    this.f36620a = null;
                    e(iVar);
                }
            }
        }
    }

    @Override // xn.b
    public void dispose() {
        if (!this.f36621b) {
            synchronized (this) {
                if (!this.f36621b) {
                    this.f36621b = true;
                    i<b> iVar = this.f36620a;
                    this.f36620a = null;
                    e(iVar);
                }
            }
        }
    }

    void e(i<b> iVar) {
        Object[] b10;
        if (iVar != null) {
            ArrayList arrayList = null;
            for (Object obj : iVar.b()) {
                if (obj instanceof b) {
                    try {
                        ((b) obj).dispose();
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th2);
                    }
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

    public int f() {
        int i10 = 0;
        if (this.f36621b) {
            return 0;
        }
        synchronized (this) {
            if (this.f36621b) {
                return 0;
            }
            i<b> iVar = this.f36620a;
            if (iVar != null) {
                i10 = iVar.g();
            }
            return i10;
        }
    }

    @Override // xn.b
    public boolean isDisposed() {
        return this.f36621b;
    }
}
