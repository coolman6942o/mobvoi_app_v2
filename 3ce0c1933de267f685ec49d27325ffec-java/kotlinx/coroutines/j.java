package kotlinx.coroutines;

import ap.a;
import ap.b;
import io.m;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.u;
import qo.p;
/* compiled from: Builders.common.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class j {
    public static final j1 a(l0 l0Var, f fVar, CoroutineStart coroutineStart, p<? super l0, ? super c<? super m>, ? extends Object> pVar) {
        a aVar;
        f c10 = f0.c(l0Var, fVar);
        if (coroutineStart.isLazy()) {
            aVar = new r1(c10, pVar);
        } else {
            aVar = new y1(c10, true);
        }
        aVar.v0(coroutineStart, aVar, pVar);
        return aVar;
    }

    public static /* synthetic */ j1 b(l0 l0Var, f fVar, CoroutineStart coroutineStart, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return h.a(l0Var, fVar, coroutineStart, pVar);
    }

    /* JADX WARN: Finally extract failed */
    public static final <T> Object c(f fVar, p<? super l0, ? super c<? super T>, ? extends Object> pVar, c<? super T> cVar) {
        Object obj;
        Object d10;
        f context = cVar.getContext();
        f plus = context.plus(fVar);
        m1.e(plus);
        if (plus == context) {
            u uVar = new u(plus, cVar);
            obj = b.c(uVar, uVar, pVar);
        } else {
            d.b bVar = d.f30064e0;
            if (i.b(plus.get(bVar), context.get(bVar))) {
                c2 c2Var = new c2(plus, cVar);
                Object c10 = a0.c(plus, null);
                try {
                    Object c11 = b.c(c2Var, c2Var, pVar);
                    a0.a(plus, c10);
                    obj = c11;
                } catch (Throwable th2) {
                    a0.a(plus, c10);
                    throw th2;
                }
            } else {
                q0 q0Var = new q0(plus, cVar);
                a.f(pVar, q0Var, q0Var, null, 4, null);
                obj = q0Var.x0();
            }
        }
        d10 = kotlin.coroutines.intrinsics.b.d();
        if (obj == d10) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        return obj;
    }
}
