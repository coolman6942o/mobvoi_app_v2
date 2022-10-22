package kotlinx.coroutines;

import io.b;
import io.m;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.e;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.scheduling.h;
/* compiled from: DispatchedTask.kt */
/* loaded from: classes3.dex */
public abstract class r0<T> extends h {

    /* renamed from: c  reason: collision with root package name */
    public int f30284c;

    public r0(int i10) {
        this.f30284c = i10;
    }

    public void c(Object obj, Throwable th2) {
    }

    public abstract c<T> d();

    public Throwable e(Object obj) {
        a0 a0Var = obj instanceof a0 ? (a0) obj : null;
        if (a0Var == null) {
            return null;
        }
        return a0Var.f30116a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T f(Object obj) {
        return obj;
    }

    public final void h(Throwable th2, Throwable th3) {
        if (th2 != null || th3 != null) {
            if (!(th2 == null || th3 == null)) {
                b.a(th2, th3);
            }
            if (th2 == null) {
                th2 = th3;
            }
            i.d(th2);
            i0.a(d().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th2));
        }
    }

    public abstract Object i();

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Object obj2;
        if (n0.a()) {
            if (!(this.f30284c != -1)) {
                throw new AssertionError();
            }
        }
        kotlinx.coroutines.scheduling.i iVar = this.f30323b;
        try {
            e eVar = (e) d();
            c<T> cVar = eVar.f30212e;
            Object obj3 = eVar.f30214g;
            f context = cVar.getContext();
            Object c10 = a0.c(context, obj3);
            c2<?> e10 = c10 != a0.f30198a ? f0.e(cVar, context, c10) : null;
            f context2 = cVar.getContext();
            Object i10 = i();
            Throwable e11 = e(i10);
            j1 j1Var = (e11 != null || !s0.b(this.f30284c)) ? null : (j1) context2.get(j1.f30248g0);
            if (j1Var != null && !j1Var.c()) {
                Throwable o10 = j1Var.o();
                c(i10, o10);
                Result.a aVar = Result.Companion;
                if (n0.d() && (cVar instanceof kotlin.coroutines.jvm.internal.c)) {
                    o10 = v.a(o10, (kotlin.coroutines.jvm.internal.c) cVar);
                }
                cVar.resumeWith(Result.m28constructorimpl(io.h.a(o10)));
            } else if (e11 != null) {
                Result.a aVar2 = Result.Companion;
                cVar.resumeWith(Result.m28constructorimpl(io.h.a(e11)));
            } else {
                T f10 = f(i10);
                Result.a aVar3 = Result.Companion;
                cVar.resumeWith(Result.m28constructorimpl(f10));
            }
            m mVar = m.f28349a;
            if (e10 == null || e10.x0()) {
                a0.a(context, c10);
            }
            try {
                Result.a aVar4 = Result.Companion;
                iVar.n();
                obj2 = Result.m28constructorimpl(mVar);
            } catch (Throwable th2) {
                Result.a aVar5 = Result.Companion;
                obj2 = Result.m28constructorimpl(io.h.a(th2));
            }
            h(null, Result.m31exceptionOrNullimpl(obj2));
        } catch (Throwable th3) {
            try {
                Result.a aVar6 = Result.Companion;
                iVar.n();
                obj = Result.m28constructorimpl(m.f28349a);
            } catch (Throwable th4) {
                Result.a aVar7 = Result.Companion;
                obj = Result.m28constructorimpl(io.h.a(th4));
            }
            h(th3, Result.m31exceptionOrNullimpl(obj));
        }
    }
}
