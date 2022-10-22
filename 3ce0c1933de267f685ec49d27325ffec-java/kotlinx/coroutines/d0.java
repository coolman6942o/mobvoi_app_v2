package kotlinx.coroutines;

import io.h;
import io.m;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlinx.coroutines.internal.v;
import qo.l;
/* compiled from: CompletionState.kt */
/* loaded from: classes3.dex */
public final class d0 {
    public static final <T> Object a(Object obj, c<? super T> cVar) {
        if (obj instanceof a0) {
            Result.a aVar = Result.Companion;
            Throwable th2 = ((a0) obj).f30116a;
            if (n0.d() && (cVar instanceof kotlin.coroutines.jvm.internal.c)) {
                th2 = v.j(th2, (kotlin.coroutines.jvm.internal.c) cVar);
            }
            return Result.m28constructorimpl(h.a(th2));
        }
        Result.a aVar2 = Result.Companion;
        return Result.m28constructorimpl(obj);
    }

    public static final <T> Object b(Object obj, m<?> mVar) {
        Throwable th2 = Result.m31exceptionOrNullimpl(obj);
        if (th2 != null) {
            if (n0.d() && (mVar instanceof kotlin.coroutines.jvm.internal.c)) {
                th2 = v.j(th2, (kotlin.coroutines.jvm.internal.c) mVar);
            }
            obj = new a0(th2, false, 2, null);
        }
        return obj;
    }

    public static final <T> Object c(Object obj, l<? super Throwable, m> lVar) {
        Throwable th2 = Result.m31exceptionOrNullimpl(obj);
        if (th2 == null) {
            return lVar != null ? new b0(obj, lVar) : obj;
        }
        return new a0(th2, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, l lVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            lVar = null;
        }
        return c(obj, lVar);
    }
}
