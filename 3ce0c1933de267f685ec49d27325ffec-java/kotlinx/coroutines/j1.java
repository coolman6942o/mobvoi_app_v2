package kotlinx.coroutines;

import io.m;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.f;
import qo.l;
import qo.p;
/* compiled from: Job.kt */
/* loaded from: classes3.dex */
public interface j1 extends f.b {

    /* renamed from: g0  reason: collision with root package name */
    public static final b f30248g0 = b.f30249a;

    /* compiled from: Job.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ void a(j1 j1Var, CancellationException cancellationException, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    cancellationException = null;
                }
                j1Var.E(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R b(j1 j1Var, R r10, p<? super R, ? super f.b, ? extends R> pVar) {
            return (R) f.b.a.a(j1Var, r10, pVar);
        }

        public static <E extends f.b> E c(j1 j1Var, f.c<E> cVar) {
            return (E) f.b.a.b(j1Var, cVar);
        }

        public static /* synthetic */ u0 d(j1 j1Var, boolean z10, boolean z11, l lVar, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    z10 = false;
                }
                if ((i10 & 2) != 0) {
                    z11 = true;
                }
                return j1Var.x(z10, z11, lVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static f e(j1 j1Var, f.c<?> cVar) {
            return f.b.a.c(j1Var, cVar);
        }

        public static f f(j1 j1Var, f fVar) {
            return f.b.a.d(j1Var, fVar);
        }
    }

    /* compiled from: Job.kt */
    /* loaded from: classes3.dex */
    public static final class b implements f.c<j1> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f30249a = new b();

        private b() {
        }
    }

    void E(CancellationException cancellationException);

    s O(u uVar);

    boolean c();

    u0 i(l<? super Throwable, m> lVar);

    CancellationException o();

    boolean start();

    u0 x(boolean z10, boolean z11, l<? super Throwable, m> lVar);
}
