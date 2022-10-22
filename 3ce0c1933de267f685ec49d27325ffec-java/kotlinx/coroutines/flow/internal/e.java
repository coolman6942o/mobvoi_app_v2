package kotlinx.coroutines.flow.internal;

import ap.b;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.l0;
import qo.p;
/* compiled from: FlowCoroutine.kt */
/* loaded from: classes3.dex */
public final class e {
    public static final <R> Object a(p<? super l0, ? super c<? super R>, ? extends Object> pVar, c<? super R> cVar) {
        Object d10;
        d dVar = new d(cVar.getContext(), cVar);
        Object c10 = b.c(dVar, dVar, pVar);
        d10 = kotlin.coroutines.intrinsics.b.d();
        if (c10 == d10) {
            f.c(cVar);
        }
        return c10;
    }
}
