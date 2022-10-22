package ap;

import io.h;
import io.m;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.internal.f;
import qo.l;
import qo.p;
/* compiled from: Cancellable.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final void b(c<?> cVar, Throwable th2) {
        Result.a aVar = Result.Companion;
        cVar.resumeWith(Result.m28constructorimpl(h.a(th2)));
        throw th2;
    }

    public static final void c(c<? super m> cVar, c<?> cVar2) {
        c c10;
        try {
            c10 = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
            Result.a aVar = Result.Companion;
            f.c(c10, Result.m28constructorimpl(m.f28349a), null, 2, null);
        } catch (Throwable th2) {
            b(cVar2, th2);
        }
    }

    public static final <T> void d(l<? super c<? super T>, ? extends Object> lVar, c<? super T> cVar) {
        c<m> a10;
        c c10;
        try {
            a10 = IntrinsicsKt__IntrinsicsJvmKt.a(lVar, cVar);
            c10 = IntrinsicsKt__IntrinsicsJvmKt.c(a10);
            Result.a aVar = Result.Companion;
            f.c(c10, Result.m28constructorimpl(m.f28349a), null, 2, null);
        } catch (Throwable th2) {
            b(cVar, th2);
        }
    }

    public static final <R, T> void e(p<? super R, ? super c<? super T>, ? extends Object> pVar, R r10, c<? super T> cVar, l<? super Throwable, m> lVar) {
        c<m> b10;
        c c10;
        try {
            b10 = IntrinsicsKt__IntrinsicsJvmKt.b(pVar, r10, cVar);
            c10 = IntrinsicsKt__IntrinsicsJvmKt.c(b10);
            Result.a aVar = Result.Companion;
            f.b(c10, Result.m28constructorimpl(m.f28349a), lVar);
        } catch (Throwable th2) {
            b(cVar, th2);
        }
    }

    public static /* synthetic */ void f(p pVar, Object obj, c cVar, l lVar, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            lVar = null;
        }
        e(pVar, obj, cVar, lVar);
    }
}
