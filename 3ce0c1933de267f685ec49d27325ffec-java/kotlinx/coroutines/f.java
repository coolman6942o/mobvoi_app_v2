package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.kt */
/* loaded from: classes3.dex */
public final class f<T> extends a<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Thread f30169c;

    /* renamed from: d  reason: collision with root package name */
    private final w0 f30170d;

    public f(kotlin.coroutines.f fVar, Thread thread, w0 w0Var) {
        super(fVar, true, true);
        this.f30169c = thread;
        this.f30170d = w0Var;
    }

    @Override // kotlinx.coroutines.p1
    protected boolean T() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.p1
    public void n(Object obj) {
        if (!i.b(Thread.currentThread(), this.f30169c)) {
            Thread thread = this.f30169c;
            c.a();
            LockSupport.unpark(thread);
        }
    }

    /* JADX WARN: Finally extract failed */
    public final T w0() {
        c.a();
        try {
            w0 w0Var = this.f30170d;
            a0 a0Var = null;
            if (w0Var != null) {
                w0.m0(w0Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                w0 w0Var2 = this.f30170d;
                long t02 = w0Var2 == null ? Long.MAX_VALUE : w0Var2.t0();
                if (S()) {
                    w0 w0Var3 = this.f30170d;
                    if (w0Var3 != null) {
                        w0.g0(w0Var3, false, 1, null);
                    }
                    c.a();
                    T t10 = (T) q1.h(N());
                    if (t10 instanceof a0) {
                        a0Var = (a0) t10;
                    }
                    if (a0Var == null) {
                        return t10;
                    }
                    throw a0Var.f30116a;
                }
                c.a();
                LockSupport.parkNanos(this, t02);
            }
            InterruptedException interruptedException = new InterruptedException();
            p(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            c.a();
            throw th2;
        }
    }
}
