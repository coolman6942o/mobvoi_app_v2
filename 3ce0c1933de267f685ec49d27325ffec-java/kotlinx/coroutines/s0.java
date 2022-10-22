package kotlinx.coroutines;

import io.h;
import io.m;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.e;
/* compiled from: DispatchedTask.kt */
/* loaded from: classes3.dex */
public final class s0 {
    public static final <T> void a(r0<? super T> r0Var, int i10) {
        boolean z10 = true;
        if (n0.a()) {
            if (!(i10 != -1)) {
                throw new AssertionError();
            }
        }
        c<? super T> d10 = r0Var.d();
        if (i10 != 4) {
            z10 = false;
        }
        if (z10 || !(d10 instanceof e) || b(i10) != b(r0Var.f30284c)) {
            d(r0Var, d10, z10);
            return;
        }
        g0 g0Var = ((e) d10).f30211d;
        f context = d10.getContext();
        if (g0Var.V(context)) {
            g0Var.Q(context, r0Var);
        } else {
            e(r0Var);
        }
    }

    public static final boolean b(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public static final boolean c(int i10) {
        return i10 == 2;
    }

    public static final <T> void d(r0<? super T> r0Var, c<? super T> cVar, boolean z10) {
        Object obj;
        Object i10 = r0Var.i();
        Throwable e10 = r0Var.e(i10);
        if (e10 != null) {
            Result.a aVar = Result.Companion;
            obj = h.a(e10);
        } else {
            Result.a aVar2 = Result.Companion;
            obj = r0Var.f(i10);
        }
        Object obj2 = Result.m28constructorimpl(obj);
        if (z10) {
            e eVar = (e) cVar;
            c<T> cVar2 = eVar.f30212e;
            Object obj3 = eVar.f30214g;
            f context = cVar2.getContext();
            Object c10 = a0.c(context, obj3);
            c2<?> e11 = c10 != a0.f30198a ? f0.e(cVar2, context, c10) : null;
            try {
                eVar.f30212e.resumeWith(obj2);
                m mVar = m.f28349a;
            } finally {
                if (e11 == null || e11.x0()) {
                    a0.a(context, c10);
                }
            }
        } else {
            cVar.resumeWith(obj2);
        }
    }

    private static final void e(r0<?> r0Var) {
        w0 b10 = a2.f30119a.b();
        if (b10.o0()) {
            b10.i0(r0Var);
            return;
        }
        b10.k0(true);
        try {
            d(r0Var, r0Var.d(), true);
            do {
            } while (b10.u0());
        } finally {
            try {
            } finally {
            }
        }
    }
}
