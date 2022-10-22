package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.i;
/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f30220a = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_next");

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f30221b = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_prev");

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f30222c = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes3.dex */
    public static abstract class a extends c<l> {

        /* renamed from: b  reason: collision with root package name */
        public final l f30223b;

        /* renamed from: c  reason: collision with root package name */
        public l f30224c;

        public a(l lVar) {
            this.f30223b = lVar;
        }

        /* renamed from: h */
        public void d(l lVar, Object obj) {
            boolean z10 = obj == null;
            l lVar2 = z10 ? this.f30223b : this.f30224c;
            if (lVar2 != null && l.f30220a.compareAndSet(lVar, this, lVar2) && z10) {
                l lVar3 = this.f30223b;
                l lVar4 = this.f30224c;
                i.d(lVar4);
                lVar3.l(lVar4);
            }
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes3.dex */
    public static final class b extends s {
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
        if (kotlinx.coroutines.internal.l.f30220a.compareAndSet(r3, r2, ((kotlinx.coroutines.internal.t) r4).f30241a) != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final l j(s sVar) {
        while (true) {
            l lVar = (l) this._prev;
            l lVar2 = lVar;
            while (true) {
                l lVar3 = null;
                while (true) {
                    Object obj = lVar2._next;
                    if (obj == this) {
                        if (lVar == lVar2 || f30221b.compareAndSet(this, lVar, lVar2)) {
                            return lVar2;
                        }
                    } else if (r()) {
                        return null;
                    } else {
                        if (obj == sVar) {
                            return lVar2;
                        }
                        if (obj instanceof s) {
                            if (sVar != null && sVar.b((s) obj)) {
                                return null;
                            }
                            ((s) obj).c(lVar2);
                        } else if (!(obj instanceof t)) {
                            lVar3 = lVar2;
                            lVar2 = (l) obj;
                        } else if (lVar3 != null) {
                            break;
                        } else {
                            lVar2 = (l) lVar2._prev;
                        }
                    }
                }
                lVar2 = lVar3;
            }
        }
    }

    private final l k(l lVar) {
        while (lVar.r()) {
            lVar = (l) lVar._prev;
        }
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(l lVar) {
        l lVar2;
        do {
            lVar2 = (l) lVar._prev;
            if (m() != lVar) {
                return;
            }
        } while (!f30221b.compareAndSet(lVar, lVar2, this));
        if (r()) {
            lVar.j(null);
        }
    }

    private final t u() {
        t tVar = (t) this._removedRef;
        if (tVar != null) {
            return tVar;
        }
        t tVar2 = new t(this);
        f30222c.lazySet(this, tVar2);
        return tVar2;
    }

    public final boolean h(l lVar, l lVar2) {
        f30221b.lazySet(lVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30220a;
        atomicReferenceFieldUpdater.lazySet(lVar, lVar2);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, lVar2, lVar)) {
            return false;
        }
        lVar.l(lVar2);
        return true;
    }

    public final boolean i(l lVar) {
        f30221b.lazySet(lVar, this);
        f30220a.lazySet(lVar, this);
        while (m() == this) {
            if (f30220a.compareAndSet(this, this, lVar)) {
                lVar.l(this);
                return true;
            }
        }
        return false;
    }

    public final Object m() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof s)) {
                return obj;
            }
            ((s) obj).c(this);
        }
    }

    public final l n() {
        return k.b(m());
    }

    public final l o() {
        l j10 = j(null);
        return j10 == null ? k((l) this._prev) : j10;
    }

    public final void p() {
        ((t) m()).f30241a.j(null);
    }

    public final void q() {
        l lVar = this;
        while (true) {
            Object m10 = lVar.m();
            if (!(m10 instanceof t)) {
                lVar.j(null);
                return;
            }
            lVar = ((t) m10).f30241a;
        }
    }

    public boolean r() {
        return m() instanceof t;
    }

    public boolean s() {
        return t() == null;
    }

    public final l t() {
        Object m10;
        l lVar;
        do {
            m10 = m();
            if (m10 instanceof t) {
                return ((t) m10).f30241a;
            }
            if (m10 == this) {
                return (l) m10;
            }
            lVar = (l) m10;
        } while (!f30220a.compareAndSet(this, m10, lVar.u()));
        lVar.j(null);
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) getClass().getSimpleName());
        sb2.append('@');
        sb2.append((Object) Integer.toHexString(System.identityHashCode(this)));
        return sb2.toString();
    }

    public final int v(l lVar, l lVar2, a aVar) {
        f30221b.lazySet(lVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30220a;
        atomicReferenceFieldUpdater.lazySet(lVar, lVar2);
        aVar.f30224c = lVar2;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, lVar2, aVar)) {
            return 0;
        }
        return aVar.c(this) == null ? 1 : 2;
    }
}
