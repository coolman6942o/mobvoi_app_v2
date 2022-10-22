package kotlinx.coroutines;

import kotlinx.coroutines.internal.a;
/* compiled from: EventLoop.common.kt */
/* loaded from: classes3.dex */
public abstract class w0 extends g0 {

    /* renamed from: b  reason: collision with root package name */
    private long f30342b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f30343c;

    /* renamed from: d  reason: collision with root package name */
    private a<r0<?>> f30344d;

    public static /* synthetic */ void g0(w0 w0Var, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            w0Var.W(z10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long h0(boolean z10) {
        return z10 ? 4294967296L : 1L;
    }

    public static /* synthetic */ void m0(w0 w0Var, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            w0Var.k0(z10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void W(boolean z10) {
        long h02 = this.f30342b - h0(z10);
        this.f30342b = h02;
        if (h02 <= 0) {
            if (n0.a()) {
                if (!(this.f30342b == 0)) {
                    throw new AssertionError();
                }
            }
            if (this.f30343c) {
                shutdown();
            }
        }
    }

    public final void i0(r0<?> r0Var) {
        a<r0<?>> aVar = this.f30344d;
        if (aVar == null) {
            aVar = new a<>();
            this.f30344d = aVar;
        }
        aVar.a(r0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long j0() {
        a<r0<?>> aVar = this.f30344d;
        return (aVar != null && !aVar.c()) ? 0L : Long.MAX_VALUE;
    }

    public final void k0(boolean z10) {
        this.f30342b += h0(z10);
        if (!z10) {
            this.f30343c = true;
        }
    }

    public final boolean o0() {
        return this.f30342b >= h0(true);
    }

    public final boolean r0() {
        a<r0<?>> aVar = this.f30344d;
        if (aVar == null) {
            return true;
        }
        return aVar.c();
    }

    protected void shutdown() {
    }

    public long t0() {
        return !u0() ? Long.MAX_VALUE : 0L;
    }

    public final boolean u0() {
        r0<?> d10;
        a<r0<?>> aVar = this.f30344d;
        if (aVar == null || (d10 = aVar.d()) == null) {
            return false;
        }
        d10.run();
        return true;
    }

    public boolean w0() {
        return false;
    }
}
