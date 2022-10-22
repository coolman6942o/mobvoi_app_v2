package ap;

import io.h;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.q1;
import qo.l;
import qo.p;
/* compiled from: Undispatched.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final <T> void a(l<? super c<? super T>, ? extends Object> lVar, c<? super T> cVar) {
        Object d10;
        c a10 = f.a(cVar);
        try {
            kotlin.coroutines.f context = cVar.getContext();
            Object c10 = a0.c(context, null);
            if (lVar != null) {
                Object invoke = ((l) o.b(lVar, 1)).invoke(a10);
                a0.a(context, c10);
                d10 = kotlin.coroutines.intrinsics.b.d();
                if (invoke != d10) {
                    Result.a aVar = Result.Companion;
                    a10.resumeWith(Result.m28constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            a10.resumeWith(Result.m28constructorimpl(h.a(th2)));
        }
    }

    public static final <R, T> void b(p<? super R, ? super c<? super T>, ? extends Object> pVar, R r10, c<? super T> cVar) {
        Object d10;
        c a10 = f.a(cVar);
        try {
            kotlin.coroutines.f context = cVar.getContext();
            Object c10 = a0.c(context, null);
            if (pVar != null) {
                Object invoke = ((p) o.b(pVar, 2)).invoke(r10, a10);
                a0.a(context, c10);
                d10 = kotlin.coroutines.intrinsics.b.d();
                if (invoke != d10) {
                    Result.a aVar = Result.Companion;
                    a10.resumeWith(Result.m28constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            a10.resumeWith(Result.m28constructorimpl(h.a(th2)));
        }
    }

    public static final <T, R> Object c(u<? super T> uVar, R r10, p<? super R, ? super c<? super T>, ? extends Object> pVar) {
        Object obj;
        Object d10;
        Throwable j10;
        Object d11;
        Object d12;
        try {
        } catch (Throwable th2) {
            obj = new kotlinx.coroutines.a0(th2, false, 2, null);
        }
        if (pVar != null) {
            obj = ((p) o.b(pVar, 2)).invoke(r10, uVar);
            d10 = kotlin.coroutines.intrinsics.b.d();
            if (obj == d10) {
                d12 = kotlin.coroutines.intrinsics.b.d();
                return d12;
            }
            Object V = uVar.V(obj);
            if (V == q1.f30277b) {
                d11 = kotlin.coroutines.intrinsics.b.d();
                return d11;
            } else if (!(V instanceof kotlinx.coroutines.a0)) {
                return q1.h(V);
            } else {
                Throwable th3 = ((kotlinx.coroutines.a0) V).f30116a;
                c<? super T> cVar = uVar.f30242c;
                if (!n0.d() || !(cVar instanceof kotlin.coroutines.jvm.internal.c)) {
                    throw th3;
                }
                j10 = v.j(th3, (kotlin.coroutines.jvm.internal.c) cVar);
                throw j10;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
    }
}
