package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Job.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class n1 {
    public static final y a(j1 j1Var) {
        return new l1(j1Var);
    }

    public static /* synthetic */ y b(j1 j1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j1Var = null;
        }
        return m1.a(j1Var);
    }

    public static final void c(f fVar, CancellationException cancellationException) {
        j1 j1Var = (j1) fVar.get(j1.f30248g0);
        if (j1Var != null) {
            j1Var.E(cancellationException);
        }
    }

    public static /* synthetic */ void d(f fVar, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        m1.c(fVar, cancellationException);
    }

    public static final void e(f fVar) {
        j1 j1Var = (j1) fVar.get(j1.f30248g0);
        if (j1Var != null) {
            m1.f(j1Var);
        }
    }

    public static final void f(j1 j1Var) {
        if (!j1Var.c()) {
            throw j1Var.o();
        }
    }
}
