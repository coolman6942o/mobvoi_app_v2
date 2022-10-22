package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.x0;
/* compiled from: EventLoop.kt */
/* loaded from: classes3.dex */
public abstract class y0 extends w0 {
    /* JADX INFO: Access modifiers changed from: protected */
    public final void A0(long j10, x0.a aVar) {
        if (n0.a()) {
            if (!(this != p0.f30264g)) {
                throw new AssertionError();
            }
        }
        p0.f30264g.Q0(j10, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void G0() {
        Thread z02 = z0();
        if (Thread.currentThread() != z02) {
            c.a();
            LockSupport.unpark(z02);
        }
    }

    protected abstract Thread z0();
}
