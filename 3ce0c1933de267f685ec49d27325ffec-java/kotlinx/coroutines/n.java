package kotlinx.coroutines;

import io.m;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.internal.e;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.j1;
import qo.l;
/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes3.dex */
public class n<T> extends r0<T> implements m<T>, c {

    /* renamed from: g  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f30253g = AtomicIntegerFieldUpdater.newUpdater(n.class, "_decision");

    /* renamed from: h  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f30254h = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.coroutines.c<T> f30255d;

    /* renamed from: e  reason: collision with root package name */
    private final f f30256e;

    /* renamed from: f  reason: collision with root package name */
    private u0 f30257f;

    /* JADX WARN: Multi-variable type inference failed */
    public n(kotlin.coroutines.c<? super T> cVar, int i10) {
        super(i10);
        this.f30255d = cVar;
        if (n0.a()) {
            if (!(i10 != -1)) {
                throw new AssertionError();
            }
        }
        this.f30256e = cVar.getContext();
        this._decision = 0;
        this._state = d.f30164a;
    }

    private final k A(l<? super Throwable, m> lVar) {
        return lVar instanceof k ? (k) lVar : new g1(lVar);
    }

    private final void B(l<? super Throwable, m> lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    private final void E() {
        kotlin.coroutines.c<T> cVar = this.f30255d;
        Throwable th2 = null;
        e eVar = cVar instanceof e ? (e) cVar : null;
        if (eVar != null) {
            th2 = eVar.s(this);
        }
        if (th2 != null) {
            r();
            p(th2);
        }
    }

    private final void G(Object obj, int i10, l<? super Throwable, m> lVar) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof v1) {
            } else {
                if (obj2 instanceof q) {
                    q qVar = (q) obj2;
                    if (qVar.c()) {
                        if (lVar != null) {
                            o(lVar, qVar.f30116a);
                            return;
                        }
                        return;
                    }
                }
                l(obj);
                throw new KotlinNothingValueException();
            }
        } while (!f30254h.compareAndSet(this, obj2, I((v1) obj2, obj, i10, lVar, null)));
        s();
        t(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void H(n nVar, Object obj, int i10, l lVar, int i11, Object obj2) {
        if (obj2 == null) {
            if ((i11 & 4) != 0) {
                lVar = null;
            }
            nVar.G(obj, i10, lVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object I(v1 v1Var, Object obj, int i10, l<? super Throwable, m> lVar, Object obj2) {
        if (obj instanceof a0) {
            boolean z10 = true;
            if (n0.a()) {
                if (!(obj2 == null)) {
                    throw new AssertionError();
                }
            }
            if (!n0.a()) {
                return obj;
            }
            if (lVar != null) {
                z10 = false;
            }
            if (z10) {
                return obj;
            }
            throw new AssertionError();
        } else if (!s0.b(i10) && obj2 == null) {
            return obj;
        } else {
            if (lVar == null && ((!(v1Var instanceof k) || (v1Var instanceof e)) && obj2 == null)) {
                return obj;
            }
            return new z(obj, v1Var instanceof k ? (k) v1Var : null, lVar, obj2, null, 16, null);
        }
    }

    private final boolean J() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f30253g.compareAndSet(this, 0, 2));
        return true;
    }

    private final w K(Object obj, Object obj2, l<? super Throwable, m> lVar) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof v1) {
            } else if (!(obj3 instanceof z) || obj2 == null) {
                return null;
            } else {
                z zVar = (z) obj3;
                if (zVar.f30358d != obj2) {
                    return null;
                }
                if (!n0.a() || i.b(zVar.f30355a, obj)) {
                    return o.f30262a;
                }
                throw new AssertionError();
            }
        } while (!f30254h.compareAndSet(this, obj3, I((v1) obj3, obj, this.f30284c, lVar, obj2)));
        s();
        return o.f30262a;
    }

    private final boolean L() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f30253g.compareAndSet(this, 0, 1));
        return true;
    }

    private final Void l(Object obj) {
        throw new IllegalStateException(i.n("Already resumed, but proposed with update ", obj).toString());
    }

    private final void n(l<? super Throwable, m> lVar, Throwable th2) {
        try {
            lVar.invoke(th2);
        } catch (Throwable th3) {
            i0.a(getContext(), new CompletionHandlerException(i.n("Exception in invokeOnCancellation handler for ", this), th3));
        }
    }

    private final boolean q(Throwable th2) {
        if (!z()) {
            return false;
        }
        return ((e) this.f30255d).q(th2);
    }

    private final void s() {
        if (!z()) {
            r();
        }
    }

    private final void t(int i10) {
        if (!J()) {
            s0.a(this, i10);
        }
    }

    private final String x() {
        Object w10 = w();
        return w10 instanceof v1 ? "Active" : w10 instanceof q ? "Cancelled" : "Completed";
    }

    private final u0 y() {
        j1 j1Var = (j1) getContext().get(j1.f30248g0);
        if (j1Var == null) {
            return null;
        }
        u0 d10 = j1.a.d(j1Var, true, false, new r(this), 2, null);
        this.f30257f = d10;
        return d10;
    }

    private final boolean z() {
        return s0.c(this.f30284c) && ((e) this.f30255d).p();
    }

    protected String C() {
        return "CancellableContinuation";
    }

    public final void D(Throwable th2) {
        if (!q(th2)) {
            p(th2);
            s();
        }
    }

    public final boolean F() {
        if (n0.a()) {
            if (!(this.f30284c == 2)) {
                throw new AssertionError();
            }
        }
        if (n0.a()) {
            if (!(this.f30257f != u1.f30338a)) {
                throw new AssertionError();
            }
        }
        Object obj = this._state;
        if (n0.a() && !(!(obj instanceof v1))) {
            throw new AssertionError();
        } else if (!(obj instanceof z) || ((z) obj).f30358d == null) {
            this._decision = 0;
            this._state = d.f30164a;
            return true;
        } else {
            r();
            return false;
        }
    }

    @Override // kotlinx.coroutines.m
    public Object a(T t10, Object obj) {
        return K(t10, obj, null);
    }

    @Override // kotlinx.coroutines.m
    public Object b(T t10, Object obj, l<? super Throwable, m> lVar) {
        return K(t10, obj, lVar);
    }

    @Override // kotlinx.coroutines.r0
    public void c(Object obj, Throwable th2) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof v1) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof a0)) {
                if (obj2 instanceof z) {
                    z zVar = (z) obj2;
                    if (!zVar.c()) {
                        if (f30254h.compareAndSet(this, obj2, z.b(zVar, null, null, null, null, th2, 15, null))) {
                            zVar.d(this, th2);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (f30254h.compareAndSet(this, obj2, new z(obj2, null, null, null, th2, 14, null))) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.r0
    public final kotlin.coroutines.c<T> d() {
        return this.f30255d;
    }

    @Override // kotlinx.coroutines.r0
    public Throwable e(Object obj) {
        Throwable j10;
        Throwable e10 = super.e(obj);
        if (e10 == null) {
            return null;
        }
        kotlin.coroutines.c<T> d10 = d();
        if (!n0.d() || !(d10 instanceof c)) {
            return e10;
        }
        j10 = v.j(e10, (c) d10);
        return j10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.r0
    public <T> T f(Object obj) {
        return obj instanceof z ? (T) ((z) obj).f30355a : obj;
    }

    @Override // kotlinx.coroutines.m
    public void g(T t10, l<? super Throwable, m> lVar) {
        G(t10, this.f30284c, lVar);
    }

    @Override // kotlin.coroutines.jvm.internal.c
    public c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f30255d;
        if (cVar instanceof c) {
            return (c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.c
    public f getContext() {
        return this.f30256e;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.r0
    public Object i() {
        return w();
    }

    @Override // kotlinx.coroutines.m
    public void j(l<? super Throwable, m> lVar) {
        k A = A(lVar);
        while (true) {
            Object obj = this._state;
            if (obj instanceof d) {
                if (f30254h.compareAndSet(this, obj, A)) {
                    return;
                }
            } else if (obj instanceof k) {
                B(lVar, obj);
            } else {
                boolean z10 = obj instanceof a0;
                if (z10) {
                    a0 a0Var = (a0) obj;
                    if (!a0Var.b()) {
                        B(lVar, obj);
                    }
                    if (obj instanceof q) {
                        Throwable th2 = null;
                        if (!z10) {
                            a0Var = null;
                        }
                        if (a0Var != null) {
                            th2 = a0Var.f30116a;
                        }
                        n(lVar, th2);
                        return;
                    }
                    return;
                } else if (obj instanceof z) {
                    z zVar = (z) obj;
                    if (zVar.f30356b != null) {
                        B(lVar, obj);
                    }
                    if (!(A instanceof e)) {
                        if (zVar.c()) {
                            n(lVar, zVar.f30359e);
                            return;
                        }
                        if (f30254h.compareAndSet(this, obj, z.b(zVar, null, A, null, null, null, 29, null))) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (!(A instanceof e)) {
                    if (f30254h.compareAndSet(this, obj, new z(obj, A, null, null, null, 28, null))) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.m
    public void k(Object obj) {
        if (n0.a()) {
            if (!(obj == o.f30262a)) {
                throw new AssertionError();
            }
        }
        t(this.f30284c);
    }

    public final void m(k kVar, Throwable th2) {
        try {
            kVar.a(th2);
        } catch (Throwable th3) {
            i0.a(getContext(), new CompletionHandlerException(i.n("Exception in invokeOnCancellation handler for ", this), th3));
        }
    }

    public final void o(l<? super Throwable, m> lVar, Throwable th2) {
        try {
            lVar.invoke(th2);
        } catch (Throwable th3) {
            i0.a(getContext(), new CompletionHandlerException(i.n("Exception in resume onCancellation handler for ", this), th3));
        }
    }

    public boolean p(Throwable th2) {
        Object obj;
        boolean z10;
        do {
            obj = this._state;
            if (!(obj instanceof v1)) {
                return false;
            }
            z10 = obj instanceof k;
        } while (!f30254h.compareAndSet(this, obj, new q(this, th2, z10)));
        k kVar = z10 ? (k) obj : null;
        if (kVar != null) {
            m(kVar, th2);
        }
        s();
        t(this.f30284c);
        return true;
    }

    public final void r() {
        u0 u0Var = this.f30257f;
        if (u0Var != null) {
            u0Var.dispose();
            this.f30257f = u1.f30338a;
        }
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(Object obj) {
        H(this, d0.b(obj, this), this.f30284c, null, 4, null);
    }

    public String toString() {
        return C() + '(' + o0.c(this.f30255d) + "){" + x() + "}@" + o0.b(this);
    }

    public Throwable u(j1 j1Var) {
        return j1Var.o();
    }

    public final Object v() {
        j1 j1Var;
        Throwable j10;
        Throwable j11;
        Object d10;
        boolean z10 = z();
        if (L()) {
            if (this.f30257f == null) {
                y();
            }
            if (z10) {
                E();
            }
            d10 = b.d();
            return d10;
        }
        if (z10) {
            E();
        }
        Object w10 = w();
        if (w10 instanceof a0) {
            Throwable th2 = ((a0) w10).f30116a;
            if (!n0.d()) {
                throw th2;
            }
            j11 = v.j(th2, this);
            throw j11;
        } else if (!s0.b(this.f30284c) || (j1Var = (j1) getContext().get(j1.f30248g0)) == null || j1Var.c()) {
            return f(w10);
        } else {
            CancellationException o10 = j1Var.o();
            c(w10, o10);
            if (!n0.d()) {
                throw o10;
            }
            j10 = v.j(o10, this);
            throw j10;
        }
    }

    public final Object w() {
        return this._state;
    }
}
