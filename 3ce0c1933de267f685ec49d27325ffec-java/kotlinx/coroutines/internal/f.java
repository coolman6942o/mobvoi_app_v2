package kotlinx.coroutines.internal;

import io.h;
import io.m;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.f0;
import kotlinx.coroutines.j1;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.w0;
import qo.l;
/* compiled from: DispatchedContinuation.kt */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final w f30215a = new w("UNDEFINED");

    /* renamed from: b  reason: collision with root package name */
    public static final w f30216b = new w("REUSABLE_CLAIMED");

    public static final /* synthetic */ w a() {
        return f30215a;
    }

    public static final <T> void b(c<? super T> cVar, Object obj, l<? super Throwable, m> lVar) {
        boolean z10;
        if (cVar instanceof e) {
            e eVar = (e) cVar;
            Object c10 = d0.c(obj, lVar);
            if (eVar.f30211d.V(eVar.getContext())) {
                eVar.f30213f = c10;
                eVar.f30284c = 1;
                eVar.f30211d.Q(eVar.getContext(), eVar);
                return;
            }
            n0.a();
            w0 b10 = a2.f30119a.b();
            if (b10.o0()) {
                eVar.f30213f = c10;
                eVar.f30284c = 1;
                b10.i0(eVar);
                return;
            }
            b10.k0(true);
            try {
                j1 j1Var = (j1) eVar.getContext().get(j1.f30248g0);
                if (j1Var == null || j1Var.c()) {
                    z10 = false;
                } else {
                    CancellationException o10 = j1Var.o();
                    eVar.c(c10, o10);
                    Result.a aVar = Result.Companion;
                    eVar.resumeWith(Result.m28constructorimpl(h.a(o10)));
                    z10 = true;
                }
                if (!z10) {
                    c<T> cVar2 = eVar.f30212e;
                    Object obj2 = eVar.f30214g;
                    kotlin.coroutines.f context = cVar2.getContext();
                    Object c11 = a0.c(context, obj2);
                    c2<?> e10 = c11 != a0.f30198a ? f0.e(cVar2, context, c11) : null;
                    eVar.f30212e.resumeWith(obj);
                    m mVar = m.f28349a;
                    if (e10 == null || e10.x0()) {
                        a0.a(context, c11);
                    }
                }
                do {
                } while (b10.u0());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        cVar.resumeWith(obj);
    }

    public static /* synthetic */ void c(c cVar, Object obj, l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        b(cVar, obj, lVar);
    }

    public static final boolean d(e<? super m> eVar) {
        m mVar = m.f28349a;
        n0.a();
        w0 b10 = a2.f30119a.b();
        if (b10.r0()) {
            return false;
        }
        if (b10.o0()) {
            eVar.f30213f = mVar;
            eVar.f30284c = 1;
            b10.i0(eVar);
            return true;
        }
        b10.k0(true);
        try {
            eVar.run();
            do {
            } while (b10.u0());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
