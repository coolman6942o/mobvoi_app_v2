package kotlinx.coroutines;

import io.m;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.internal.e;
/* compiled from: Yield.kt */
/* loaded from: classes3.dex */
public final class f2 {
    public static final Object a(c<? super m> cVar) {
        c c10;
        Object obj;
        Object d10;
        Object d11;
        f context = cVar.getContext();
        m1.e(context);
        c10 = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
        e eVar = c10 instanceof e ? (e) c10 : null;
        if (eVar == null) {
            obj = m.f28349a;
        } else {
            if (eVar.f30211d.V(context)) {
                eVar.n(context, m.f28349a);
            } else {
                e2 e2Var = new e2();
                f plus = context.plus(e2Var);
                m mVar = m.f28349a;
                eVar.n(plus, mVar);
                if (e2Var.f30168a) {
                    obj = kotlinx.coroutines.internal.f.d(eVar) ? b.d() : mVar;
                }
            }
            obj = b.d();
        }
        d10 = b.d();
        if (obj == d10) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        d11 = b.d();
        return obj == d11 ? obj : m.f28349a;
    }
}
