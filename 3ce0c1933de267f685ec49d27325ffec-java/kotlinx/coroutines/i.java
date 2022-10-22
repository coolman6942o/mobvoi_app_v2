package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.f;
import qo.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class i {
    public static final <T> T a(f fVar, p<? super l0, ? super c<? super T>, ? extends Object> pVar) throws InterruptedException {
        f fVar2;
        w0 w0Var;
        Thread currentThread = Thread.currentThread();
        d dVar = (d) fVar.get(d.f30064e0);
        if (dVar == null) {
            w0Var = a2.f30119a.b();
            fVar2 = f0.c(c1.f30125a, fVar.plus(w0Var));
        } else {
            w0 w0Var2 = null;
            w0 w0Var3 = dVar instanceof w0 ? (w0) dVar : null;
            if (w0Var3 != null && w0Var3.w0()) {
                w0Var2 = w0Var3;
            }
            w0Var = w0Var2 == null ? a2.f30119a.a() : w0Var2;
            fVar2 = f0.c(c1.f30125a, fVar);
        }
        f fVar3 = new f(fVar2, currentThread, w0Var);
        fVar3.v0(CoroutineStart.DEFAULT, fVar3, pVar);
        return (T) fVar3.w0();
    }
}
