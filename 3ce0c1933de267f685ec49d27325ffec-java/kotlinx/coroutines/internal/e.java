package kotlinx.coroutines.internal;

import io.m;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.f;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w0;
/* compiled from: DispatchedContinuation.kt */
/* loaded from: classes3.dex */
public final class e<T> extends r0<T> implements c, kotlin.coroutines.c<T> {

    /* renamed from: h  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f30210h = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_reusableCancellableContinuation");

    /* renamed from: d  reason: collision with root package name */
    public final g0 f30211d;

    /* renamed from: e  reason: collision with root package name */
    public final kotlin.coroutines.c<T> f30212e;

    /* renamed from: f  reason: collision with root package name */
    public Object f30213f = f.a();

    /* renamed from: g  reason: collision with root package name */
    public final Object f30214g = a0.b(getContext());
    private volatile /* synthetic */ Object _reusableCancellableContinuation = null;

    /* JADX WARN: Multi-variable type inference failed */
    public e(g0 g0Var, kotlin.coroutines.c<? super T> cVar) {
        super(-1);
        this.f30211d = g0Var;
        this.f30212e = cVar;
    }

    private final n<?> o() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof n) {
            return (n) obj;
        }
        return null;
    }

    @Override // kotlinx.coroutines.r0
    public void c(Object obj, Throwable th2) {
        if (obj instanceof b0) {
            ((b0) obj).f30122b.invoke(th2);
        }
    }

    @Override // kotlinx.coroutines.r0
    public kotlin.coroutines.c<T> d() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    public c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f30212e;
        if (cVar instanceof c) {
            return (c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.c
    public f getContext() {
        return this.f30212e.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.c
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.r0
    public Object i() {
        Object obj = this.f30213f;
        if (n0.a()) {
            if (!(obj != f.a())) {
                throw new AssertionError();
            }
        }
        this.f30213f = f.a();
        return obj;
    }

    public final void l() {
        do {
        } while (this._reusableCancellableContinuation == f.f30216b);
    }

    public final n<T> m() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = f.f30216b;
                return null;
            } else if (obj instanceof n) {
                if (f30210h.compareAndSet(this, obj, f.f30216b)) {
                    return (n) obj;
                }
            } else if (obj != f.f30216b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(i.n("Inconsistent state ", obj).toString());
            }
        }
    }

    public final void n(f fVar, T t10) {
        this.f30213f = t10;
        this.f30284c = 1;
        this.f30211d.T(fVar, this);
    }

    public final boolean p() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean q(Throwable th2) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            w wVar = f.f30216b;
            if (i.b(obj, wVar)) {
                if (f30210h.compareAndSet(this, wVar, th2)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (f30210h.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void r() {
        l();
        n<?> o10 = o();
        if (o10 != null) {
            o10.r();
        }
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(Object obj) {
        f context = this.f30212e.getContext();
        Object d10 = d0.d(obj, null, 1, null);
        if (this.f30211d.V(context)) {
            this.f30213f = d10;
            this.f30284c = 0;
            this.f30211d.Q(context, this);
            return;
        }
        n0.a();
        w0 b10 = a2.f30119a.b();
        if (b10.o0()) {
            this.f30213f = d10;
            this.f30284c = 0;
            b10.i0(this);
            return;
        }
        b10.k0(true);
        try {
            f context2 = getContext();
            Object c10 = a0.c(context2, this.f30214g);
            this.f30212e.resumeWith(obj);
            m mVar = m.f28349a;
            a0.a(context2, c10);
            do {
            } while (b10.u0());
        } finally {
            try {
            } finally {
            }
        }
    }

    public final Throwable s(kotlinx.coroutines.m<?> mVar) {
        w wVar;
        do {
            Object obj = this._reusableCancellableContinuation;
            wVar = f.f30216b;
            if (obj != wVar) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(i.n("Inconsistent state ", obj).toString());
                } else if (f30210h.compareAndSet(this, obj, null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!f30210h.compareAndSet(this, wVar, mVar));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f30211d + ", " + o0.c(this.f30212e) + ']';
    }
}
