package kotlinx.coroutines;

import io.h;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlinx.coroutines.internal.e;
/* compiled from: DebugStrings.kt */
/* loaded from: classes3.dex */
public final class o0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(c<?> cVar) {
        Object obj;
        if (cVar instanceof e) {
            return cVar.toString();
        }
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m28constructorimpl(cVar + '@' + b(cVar));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m28constructorimpl(h.a(th2));
        }
        Throwable th3 = Result.m31exceptionOrNullimpl(obj);
        String str = obj;
        if (th3 != null) {
            str = ((Object) cVar.getClass().getName()) + '@' + b(cVar);
        }
        return (String) str;
    }
}
