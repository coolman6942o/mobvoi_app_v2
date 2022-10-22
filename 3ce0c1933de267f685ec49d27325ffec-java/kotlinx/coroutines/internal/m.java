package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes3.dex */
public class m<E> {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f30225a = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public m(boolean z10) {
        this._cur = new n(8, z10);
    }

    public final boolean a(E e10) {
        while (true) {
            n nVar = (n) this._cur;
            int a10 = nVar.a(e10);
            if (a10 == 0) {
                return true;
            }
            if (a10 == 1) {
                f30225a.compareAndSet(this, nVar, nVar.i());
            } else if (a10 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            n nVar = (n) this._cur;
            if (!nVar.d()) {
                f30225a.compareAndSet(this, nVar, nVar.i());
            } else {
                return;
            }
        }
    }

    public final int c() {
        return ((n) this._cur).f();
    }

    public final E d() {
        while (true) {
            n nVar = (n) this._cur;
            E e10 = (E) nVar.j();
            if (e10 != n.f30229h) {
                return e10;
            }
            f30225a.compareAndSet(this, nVar, nVar.i());
        }
    }
}
