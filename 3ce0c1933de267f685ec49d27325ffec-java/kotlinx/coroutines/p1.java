package kotlinx.coroutines;

import io.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.internal.k;
import kotlinx.coroutines.internal.l;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.j1;
import qo.p;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public class p1 implements j1, u, w1 {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f30266a = AtomicReferenceFieldUpdater.newUpdater(p1.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    /* loaded from: classes3.dex */
    public static final class a extends o1 {

        /* renamed from: e  reason: collision with root package name */
        private final p1 f30267e;

        /* renamed from: f  reason: collision with root package name */
        private final b f30268f;

        /* renamed from: g  reason: collision with root package name */
        private final t f30269g;

        /* renamed from: h  reason: collision with root package name */
        private final Object f30270h;

        public a(p1 p1Var, b bVar, t tVar, Object obj) {
            this.f30267e = p1Var;
            this.f30268f = bVar;
            this.f30269g = tVar;
            this.f30270h = obj;
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(Throwable th2) {
            w(th2);
            return m.f28349a;
        }

        @Override // kotlinx.coroutines.c0
        public void w(Throwable th2) {
            this.f30267e.B(this.f30268f, this.f30269g, this.f30270h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    /* loaded from: classes3.dex */
    public static final class b implements e1 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: a  reason: collision with root package name */
        private final t1 f30271a;

        public b(t1 t1Var, boolean z10, Throwable th2) {
            this.f30271a = t1Var;
            this._isCompleting = z10 ? 1 : 0;
            this._rootCause = th2;
        }

        private final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        private final Object e() {
            return this._exceptionsHolder;
        }

        private final void l(Object obj) {
            this._exceptionsHolder = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Throwable th2) {
            Throwable f10 = f();
            if (f10 == null) {
                m(th2);
            } else if (th2 != f10) {
                Object e10 = e();
                if (e10 == null) {
                    l(th2);
                } else if (e10 instanceof Throwable) {
                    if (th2 != e10) {
                        ArrayList<Throwable> b10 = b();
                        b10.add(e10);
                        b10.add(th2);
                        m mVar = m.f28349a;
                        l(b10);
                    }
                } else if (e10 instanceof ArrayList) {
                    ((ArrayList) e10).add(th2);
                } else {
                    throw new IllegalStateException(i.n("State is ", e10).toString());
                }
            }
        }

        @Override // kotlinx.coroutines.e1
        public boolean c() {
            return f() == null;
        }

        @Override // kotlinx.coroutines.e1
        public t1 d() {
            return this.f30271a;
        }

        public final Throwable f() {
            return (Throwable) this._rootCause;
        }

        public final boolean g() {
            return f() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
        public final boolean h() {
            return this._isCompleting;
        }

        public final boolean i() {
            w wVar;
            Object e10 = e();
            wVar = q1.f30280e;
            return e10 == wVar;
        }

        public final List<Throwable> j(Throwable th2) {
            ArrayList<Throwable> arrayList;
            w wVar;
            Object e10 = e();
            if (e10 == null) {
                arrayList = b();
            } else if (e10 instanceof Throwable) {
                ArrayList<Throwable> b10 = b();
                b10.add(e10);
                arrayList = b10;
            } else if (e10 instanceof ArrayList) {
                arrayList = (ArrayList) e10;
            } else {
                throw new IllegalStateException(i.n("State is ", e10).toString());
            }
            Throwable f10 = f();
            if (f10 != null) {
                arrayList.add(0, f10);
            }
            if (th2 != null && !i.b(th2, f10)) {
                arrayList.add(th2);
            }
            wVar = q1.f30280e;
            l(wVar);
            return arrayList;
        }

        public final void k(boolean z10) {
            this._isCompleting = z10 ? 1 : 0;
        }

        public final void m(Throwable th2) {
            this._rootCause = th2;
        }

        public String toString() {
            return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + f() + ", exceptions=" + e() + ", list=" + d() + ']';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes3.dex */
    public static final class c extends l.a {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ p1 f30272d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f30273e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l lVar, p1 p1Var, Object obj) {
            super(lVar);
            this.f30272d = p1Var;
            this.f30273e = obj;
        }

        /* renamed from: i */
        public Object g(l lVar) {
            if (this.f30272d.N() == this.f30273e) {
                return null;
            }
            return k.a();
        }
    }

    public p1(boolean z10) {
        this._state = z10 ? q1.f30282g : q1.f30281f;
        this._parentHandle = null;
    }

    private final void A(e1 e1Var, Object obj) {
        s M = M();
        if (M != null) {
            M.dispose();
            h0(u1.f30338a);
        }
        Throwable th2 = null;
        a0 a0Var = obj instanceof a0 ? (a0) obj : null;
        if (a0Var != null) {
            th2 = a0Var.f30116a;
        }
        if (e1Var instanceof o1) {
            try {
                ((o1) e1Var).w(th2);
            } catch (Throwable th3) {
                Q(new CompletionHandlerException("Exception in completion handler " + e1Var + " for " + this, th3));
            }
        } else {
            t1 d10 = e1Var.d();
            if (d10 != null) {
                a0(d10, th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(b bVar, t tVar, Object obj) {
        if (n0.a()) {
            if (!(N() == bVar)) {
                throw new AssertionError();
            }
        }
        t Y = Y(tVar);
        if (Y == null || !r0(bVar, Y, obj)) {
            n(D(bVar, obj));
        }
    }

    private final Throwable C(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th2 = (Throwable) obj;
            return th2 == null ? new JobCancellationException(y(), null, this) : th2;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((w1) obj).w();
    }

    private final Object D(b bVar, Object obj) {
        boolean g10;
        Throwable H;
        boolean z10 = true;
        if (n0.a()) {
            if (!(N() == bVar)) {
                throw new AssertionError();
            }
        }
        if (n0.a() && !(!bVar.i())) {
            throw new AssertionError();
        } else if (!n0.a() || bVar.h()) {
            a0 a0Var = obj instanceof a0 ? (a0) obj : null;
            Throwable th2 = a0Var == null ? null : a0Var.f30116a;
            synchronized (bVar) {
                g10 = bVar.g();
                List<Throwable> j10 = bVar.j(th2);
                H = H(bVar, j10);
                if (H != null) {
                    m(H, j10);
                }
            }
            if (!(H == null || H == th2)) {
                obj = new a0(H, false, 2, null);
            }
            if (H != null) {
                if (!u(H) && !P(H)) {
                    z10 = false;
                }
                if (z10) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                    ((a0) obj).b();
                }
            }
            if (!g10) {
                b0(H);
            }
            c0(obj);
            boolean compareAndSet = f30266a.compareAndSet(this, bVar, q1.g(obj));
            if (!n0.a() || compareAndSet) {
                A(bVar, obj);
                return obj;
            }
            throw new AssertionError();
        } else {
            throw new AssertionError();
        }
    }

    private final t F(e1 e1Var) {
        t tVar = e1Var instanceof t ? (t) e1Var : null;
        if (tVar != null) {
            return tVar;
        }
        t1 d10 = e1Var.d();
        if (d10 == null) {
            return null;
        }
        return Y(d10);
    }

    private final Throwable G(Object obj) {
        a0 a0Var = obj instanceof a0 ? (a0) obj : null;
        if (a0Var == null) {
            return null;
        }
        return a0Var.f30116a;
    }

    private final Throwable H(b bVar, List<? extends Throwable> list) {
        Object obj;
        boolean z10;
        Object obj2 = null;
        if (!list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (!(((Throwable) obj) instanceof CancellationException)) {
                    break;
                }
            }
            Throwable th2 = (Throwable) obj;
            if (th2 != null) {
                return th2;
            }
            Throwable th3 = list.get(0);
            if (th3 instanceof TimeoutCancellationException) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    Throwable th4 = (Throwable) next;
                    if (th4 == th3 || !(th4 instanceof TimeoutCancellationException)) {
                        z10 = false;
                        continue;
                    } else {
                        z10 = true;
                        continue;
                    }
                    if (z10) {
                        obj2 = next;
                        break;
                    }
                }
                Throwable th5 = (Throwable) obj2;
                if (th5 != null) {
                    return th5;
                }
            }
            return th3;
        } else if (bVar.g()) {
            return new JobCancellationException(y(), null, this);
        } else {
            return null;
        }
    }

    private final t1 L(e1 e1Var) {
        t1 d10 = e1Var.d();
        if (d10 != null) {
            return d10;
        }
        if (e1Var instanceof v0) {
            return new t1();
        }
        if (e1Var instanceof o1) {
            f0((o1) e1Var);
            return null;
        }
        throw new IllegalStateException(i.n("State should have list: ", e1Var).toString());
    }

    private final Object U(Object obj) {
        w wVar;
        w wVar2;
        w wVar3;
        w wVar4;
        w wVar5;
        w wVar6;
        Throwable th2 = null;
        Throwable th3 = null;
        while (true) {
            Object N = N();
            if (N instanceof b) {
                synchronized (N) {
                    if (((b) N).i()) {
                        wVar2 = q1.f30279d;
                        return wVar2;
                    }
                    boolean g10 = ((b) N).g();
                    if (obj != null || !g10) {
                        if (th3 == null) {
                            th3 = C(obj);
                        }
                        ((b) N).a(th3);
                    }
                    th2 = ((b) N).f();
                    if (!g10) {
                    }
                    if (th2 != null) {
                        Z(((b) N).d(), th2);
                    }
                    wVar = q1.f30276a;
                    return wVar;
                }
            } else if (N instanceof e1) {
                if (th3 == null) {
                    th3 = C(obj);
                }
                e1 e1Var = (e1) N;
                if (!e1Var.c()) {
                    Object p02 = p0(N, new a0(th3, false, 2, null));
                    wVar5 = q1.f30276a;
                    if (p02 != wVar5) {
                        wVar6 = q1.f30278c;
                        if (p02 != wVar6) {
                            return p02;
                        }
                    } else {
                        throw new IllegalStateException(i.n("Cannot happen in ", N).toString());
                    }
                } else if (o0(e1Var, th3)) {
                    wVar4 = q1.f30276a;
                    return wVar4;
                }
            } else {
                wVar3 = q1.f30279d;
                return wVar3;
            }
        }
    }

    private final o1 W(qo.l<? super Throwable, m> lVar, boolean z10) {
        o1 o1Var = null;
        if (z10) {
            if (lVar instanceof k1) {
                o1Var = (k1) lVar;
            }
            if (o1Var == null) {
                o1Var = new h1(lVar);
            }
        } else {
            o1 o1Var2 = lVar instanceof o1 ? (o1) lVar : null;
            if (o1Var2 != null) {
                if (!n0.a() || (!(o1Var2 instanceof k1))) {
                    o1Var = o1Var2;
                } else {
                    throw new AssertionError();
                }
            }
            if (o1Var == null) {
                o1Var = new i1(lVar);
            }
        }
        o1Var.y(this);
        return o1Var;
    }

    private final t Y(l lVar) {
        while (lVar.r()) {
            lVar = lVar.o();
        }
        while (true) {
            lVar = lVar.n();
            if (!lVar.r()) {
                if (lVar instanceof t) {
                    return (t) lVar;
                }
                if (lVar instanceof t1) {
                    return null;
                }
            }
        }
    }

    private final void Z(t1 t1Var, Throwable th2) {
        CompletionHandlerException completionHandlerException;
        b0(th2);
        CompletionHandlerException completionHandlerException2 = null;
        for (l lVar = (l) t1Var.m(); !i.b(lVar, t1Var); lVar = lVar.n()) {
            if (lVar instanceof k1) {
                o1 o1Var = (o1) lVar;
                try {
                    o1Var.w(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        io.b.a(completionHandlerException2, th3);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new CompletionHandlerException("Exception in completion handler " + o1Var + " for " + this, th3);
                    }
                }
            }
        }
        if (completionHandlerException2 != null) {
            Q(completionHandlerException2);
        }
        u(th2);
    }

    private final void a0(t1 t1Var, Throwable th2) {
        CompletionHandlerException completionHandlerException;
        CompletionHandlerException completionHandlerException2 = null;
        for (l lVar = (l) t1Var.m(); !i.b(lVar, t1Var); lVar = lVar.n()) {
            if (lVar instanceof o1) {
                o1 o1Var = (o1) lVar;
                try {
                    o1Var.w(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        io.b.a(completionHandlerException2, th3);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new CompletionHandlerException("Exception in completion handler " + o1Var + " for " + this, th3);
                    }
                }
            }
        }
        if (completionHandlerException2 != null) {
            Q(completionHandlerException2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlinx.coroutines.d1] */
    private final void e0(v0 v0Var) {
        t1 t1Var = new t1();
        t1 t1Var2 = t1Var;
        if (!v0Var.c()) {
            t1Var2 = new d1(t1Var);
        }
        f30266a.compareAndSet(this, v0Var, t1Var2);
    }

    private final void f0(o1 o1Var) {
        o1Var.i(new t1());
        f30266a.compareAndSet(this, o1Var, o1Var.n());
    }

    private final int i0(Object obj) {
        v0 v0Var;
        if (obj instanceof v0) {
            if (((v0) obj).c()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30266a;
            v0Var = q1.f30282g;
            if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, v0Var)) {
                return -1;
            }
            d0();
            return 1;
        } else if (!(obj instanceof d1)) {
            return 0;
        } else {
            if (!f30266a.compareAndSet(this, obj, ((d1) obj).d())) {
                return -1;
            }
            d0();
            return 1;
        }
    }

    private final String j0(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof e1 ? ((e1) obj).c() ? "Active" : "New" : obj instanceof a0 ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.g() ? "Cancelling" : bVar.h() ? "Completing" : "Active";
    }

    private final boolean l(Object obj, t1 t1Var, o1 o1Var) {
        int v10;
        c cVar = new c(o1Var, this, obj);
        do {
            v10 = t1Var.o().v(o1Var, t1Var, cVar);
            if (v10 == 1) {
                return true;
            }
        } while (v10 != 2);
        return false;
    }

    public static /* synthetic */ CancellationException l0(p1 p1Var, Throwable th2, String str, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                str = null;
            }
            return p1Var.k0(th2, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final void m(Throwable th2, List<? extends Throwable> list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            Throwable l10 = !n0.d() ? th2 : v.l(th2);
            for (Throwable th3 : list) {
                if (n0.d()) {
                    th3 = v.l(th3);
                }
                if (th3 != th2 && th3 != l10 && !(th3 instanceof CancellationException) && newSetFromMap.add(th3)) {
                    io.b.a(th2, th3);
                }
            }
        }
    }

    private final boolean n0(e1 e1Var, Object obj) {
        if (n0.a()) {
            if (!((e1Var instanceof v0) || (e1Var instanceof o1))) {
                throw new AssertionError();
            }
        }
        if (n0.a() && !(!(obj instanceof a0))) {
            throw new AssertionError();
        } else if (!f30266a.compareAndSet(this, e1Var, q1.g(obj))) {
            return false;
        } else {
            b0(null);
            c0(obj);
            A(e1Var, obj);
            return true;
        }
    }

    private final boolean o0(e1 e1Var, Throwable th2) {
        if (n0.a() && !(!(e1Var instanceof b))) {
            throw new AssertionError();
        } else if (!n0.a() || e1Var.c()) {
            t1 L = L(e1Var);
            if (L == null) {
                return false;
            }
            if (!f30266a.compareAndSet(this, e1Var, new b(L, false, th2))) {
                return false;
            }
            Z(L, th2);
            return true;
        } else {
            throw new AssertionError();
        }
    }

    private final Object p0(Object obj, Object obj2) {
        w wVar;
        w wVar2;
        if (!(obj instanceof e1)) {
            wVar2 = q1.f30276a;
            return wVar2;
        } else if ((!(obj instanceof v0) && !(obj instanceof o1)) || (obj instanceof t) || (obj2 instanceof a0)) {
            return q0((e1) obj, obj2);
        } else {
            if (n0((e1) obj, obj2)) {
                return obj2;
            }
            wVar = q1.f30278c;
            return wVar;
        }
    }

    private final Object q0(e1 e1Var, Object obj) {
        w wVar;
        w wVar2;
        w wVar3;
        t1 L = L(e1Var);
        if (L == null) {
            wVar3 = q1.f30278c;
            return wVar3;
        }
        Throwable th2 = null;
        b bVar = e1Var instanceof b ? (b) e1Var : null;
        if (bVar == null) {
            bVar = new b(L, false, null);
        }
        synchronized (bVar) {
            if (bVar.h()) {
                wVar2 = q1.f30276a;
                return wVar2;
            }
            bVar.k(true);
            if (bVar == e1Var || f30266a.compareAndSet(this, e1Var, bVar)) {
                if (n0.a() && !(!bVar.i())) {
                    throw new AssertionError();
                }
                boolean g10 = bVar.g();
                a0 a0Var = obj instanceof a0 ? (a0) obj : null;
                if (a0Var != null) {
                    bVar.a(a0Var.f30116a);
                }
                Throwable f10 = bVar.f();
                if (true ^ g10) {
                    th2 = f10;
                }
                m mVar = m.f28349a;
                if (th2 != null) {
                    Z(L, th2);
                }
                t F = F(e1Var);
                if (F == null || !r0(bVar, F, obj)) {
                    return D(bVar, obj);
                }
                return q1.f30277b;
            }
            wVar = q1.f30278c;
            return wVar;
        }
    }

    private final boolean r0(b bVar, t tVar, Object obj) {
        while (j1.a.d(tVar.f30335e, false, false, new a(this, bVar, tVar, obj), 1, null) == u1.f30338a) {
            tVar = Y(tVar);
            if (tVar == null) {
                return false;
            }
        }
        return true;
    }

    private final Object t(Object obj) {
        w wVar;
        Object p02;
        w wVar2;
        do {
            Object N = N();
            if (!(N instanceof e1) || ((N instanceof b) && ((b) N).h())) {
                wVar = q1.f30276a;
                return wVar;
            }
            p02 = p0(N, new a0(C(obj), false, 2, null));
            wVar2 = q1.f30278c;
        } while (p02 == wVar2);
        return p02;
    }

    private final boolean u(Throwable th2) {
        if (T()) {
            return true;
        }
        boolean z10 = th2 instanceof CancellationException;
        s M = M();
        return (M == null || M == u1.f30338a) ? z10 : M.b(th2) || z10;
    }

    @Override // kotlinx.coroutines.j1
    public void E(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(y(), null, this);
        }
        s(cancellationException);
    }

    public boolean J() {
        return true;
    }

    public boolean K() {
        return false;
    }

    public final s M() {
        return (s) this._parentHandle;
    }

    public final Object N() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof s)) {
                return obj;
            }
            ((s) obj).c(this);
        }
    }

    @Override // kotlinx.coroutines.j1
    public final s O(u uVar) {
        return (s) j1.a.d(this, true, false, new t(uVar), 2, null);
    }

    protected boolean P(Throwable th2) {
        return false;
    }

    public void Q(Throwable th2) {
        throw th2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void R(j1 j1Var) {
        if (n0.a()) {
            if (!(M() == null)) {
                throw new AssertionError();
            }
        }
        if (j1Var == null) {
            h0(u1.f30338a);
            return;
        }
        j1Var.start();
        s O = j1Var.O(this);
        h0(O);
        if (S()) {
            O.dispose();
            h0(u1.f30338a);
        }
    }

    public final boolean S() {
        return !(N() instanceof e1);
    }

    protected boolean T() {
        return false;
    }

    public final Object V(Object obj) {
        Object p02;
        w wVar;
        w wVar2;
        do {
            p02 = p0(N(), obj);
            wVar = q1.f30276a;
            if (p02 != wVar) {
                wVar2 = q1.f30278c;
            } else {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, G(obj));
            }
        } while (p02 == wVar2);
        return p02;
    }

    public String X() {
        return o0.a(this);
    }

    protected void b0(Throwable th2) {
    }

    @Override // kotlinx.coroutines.j1
    public boolean c() {
        Object N = N();
        return (N instanceof e1) && ((e1) N).c();
    }

    protected void c0(Object obj) {
    }

    protected void d0() {
    }

    @Override // kotlin.coroutines.f
    public <R> R fold(R r10, p<? super R, ? super f.b, ? extends R> pVar) {
        return (R) j1.a.b(this, r10, pVar);
    }

    public final void g0(o1 o1Var) {
        Object N;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        v0 v0Var;
        do {
            N = N();
            if (N instanceof o1) {
                if (N == o1Var) {
                    atomicReferenceFieldUpdater = f30266a;
                    v0Var = q1.f30282g;
                } else {
                    return;
                }
            } else if ((N instanceof e1) && ((e1) N).d() != null) {
                o1Var.s();
                return;
            } else {
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, N, v0Var));
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    public <E extends f.b> E get(f.c<E> cVar) {
        return (E) j1.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.f.b
    public final f.c<?> getKey() {
        return j1.f30248g0;
    }

    public final void h0(s sVar) {
        this._parentHandle = sVar;
    }

    @Override // kotlinx.coroutines.j1
    public final u0 i(qo.l<? super Throwable, m> lVar) {
        return x(false, true, lVar);
    }

    protected final CancellationException k0(Throwable th2, String str) {
        CancellationException cancellationException = th2 instanceof CancellationException ? (CancellationException) th2 : null;
        if (cancellationException == null) {
            if (str == null) {
                str = y();
            }
            cancellationException = new JobCancellationException(str, th2, this);
        }
        return cancellationException;
    }

    public final String m0() {
        return X() + '{' + j0(N()) + '}';
    }

    @Override // kotlin.coroutines.f
    public f minusKey(f.c<?> cVar) {
        return j1.a.e(this, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(Object obj) {
    }

    @Override // kotlinx.coroutines.j1
    public final CancellationException o() {
        Object N = N();
        if (N instanceof b) {
            Throwable f10 = ((b) N).f();
            if (f10 != null) {
                return k0(f10, i.n(o0.a(this), " is cancelling"));
            }
            throw new IllegalStateException(i.n("Job is still new or active: ", this).toString());
        } else if (!(N instanceof e1)) {
            return N instanceof a0 ? l0(this, ((a0) N).f30116a, null, 1, null) : new JobCancellationException(i.n(o0.a(this), " has completed normally"), null, this);
        } else {
            throw new IllegalStateException(i.n("Job is still new or active: ", this).toString());
        }
    }

    public final boolean p(Throwable th2) {
        return r(th2);
    }

    @Override // kotlin.coroutines.f
    public f plus(f fVar) {
        return j1.a.f(this, fVar);
    }

    @Override // kotlinx.coroutines.u
    public final void q(w1 w1Var) {
        r(w1Var);
    }

    public final boolean r(Object obj) {
        Object obj2;
        w wVar;
        w wVar2;
        w wVar3;
        obj2 = q1.f30276a;
        if (K() && (obj2 = t(obj)) == q1.f30277b) {
            return true;
        }
        wVar = q1.f30276a;
        if (obj2 == wVar) {
            obj2 = U(obj);
        }
        wVar2 = q1.f30276a;
        if (obj2 == wVar2 || obj2 == q1.f30277b) {
            return true;
        }
        wVar3 = q1.f30279d;
        if (obj2 == wVar3) {
            return false;
        }
        n(obj2);
        return true;
    }

    public void s(Throwable th2) {
        r(th2);
    }

    @Override // kotlinx.coroutines.j1
    public final boolean start() {
        int i02;
        do {
            i02 = i0(N());
            if (i02 == 0) {
                return false;
            }
        } while (i02 != 1);
        return true;
    }

    public String toString() {
        return m0() + '@' + o0.b(this);
    }

    @Override // kotlinx.coroutines.w1
    public CancellationException w() {
        Throwable th2;
        Object N = N();
        CancellationException cancellationException = null;
        if (N instanceof b) {
            th2 = ((b) N).f();
        } else if (N instanceof a0) {
            th2 = ((a0) N).f30116a;
        } else if (!(N instanceof e1)) {
            th2 = null;
        } else {
            throw new IllegalStateException(i.n("Cannot be cancelling child in this state: ", N).toString());
        }
        if (th2 instanceof CancellationException) {
            cancellationException = th2;
        }
        return cancellationException == null ? new JobCancellationException(i.n("Parent job is ", j0(N)), th2, this) : cancellationException;
    }

    @Override // kotlinx.coroutines.j1
    public final u0 x(boolean z10, boolean z11, qo.l<? super Throwable, m> lVar) {
        o1 W = W(lVar, z10);
        while (true) {
            Object N = N();
            if (N instanceof v0) {
                v0 v0Var = (v0) N;
                if (!v0Var.c()) {
                    e0(v0Var);
                } else if (f30266a.compareAndSet(this, N, W)) {
                    return W;
                }
            } else {
                Throwable th2 = null;
                if (N instanceof e1) {
                    t1 d10 = ((e1) N).d();
                    if (d10 == null) {
                        Objects.requireNonNull(N, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        f0((o1) N);
                    } else {
                        u0 u0Var = u1.f30338a;
                        if (z10 && (N instanceof b)) {
                            synchronized (N) {
                                th2 = ((b) N).f();
                                if (th2 == null || ((lVar instanceof t) && !((b) N).h())) {
                                    if (l(N, d10, W)) {
                                        if (th2 == null) {
                                            return W;
                                        }
                                        u0Var = W;
                                    }
                                }
                                m mVar = m.f28349a;
                            }
                        }
                        if (th2 != null) {
                            if (z11) {
                                lVar.invoke(th2);
                            }
                            return u0Var;
                        } else if (l(N, d10, W)) {
                            return W;
                        }
                    }
                } else {
                    if (z11) {
                        a0 a0Var = N instanceof a0 ? (a0) N : null;
                        if (a0Var != null) {
                            th2 = a0Var.f30116a;
                        }
                        lVar.invoke(th2);
                    }
                    return u1.f30338a;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String y() {
        return "Job was cancelled";
    }

    public boolean z(Throwable th2) {
        if (th2 instanceof CancellationException) {
            return true;
        }
        return r(th2) && J();
    }
}
