package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import vo.f;
/* compiled from: DefaultExecutor.kt */
/* loaded from: classes3.dex */
public final class p0 extends x0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: g  reason: collision with root package name */
    public static final p0 f30264g;

    /* renamed from: h  reason: collision with root package name */
    private static final long f30265h;

    static {
        Long l10;
        p0 p0Var = new p0();
        f30264g = p0Var;
        w0.m0(p0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f30265h = timeUnit.toNanos(l10.longValue());
    }

    private p0() {
    }

    private final synchronized void U0() {
        if (W0()) {
            debugStatus = 3;
            P0();
            notifyAll();
        }
    }

    private final synchronized Thread V0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean W0() {
        int i10 = debugStatus;
        return i10 == 2 || i10 == 3;
    }

    private final synchronized boolean X0() {
        if (W0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        a2.f30119a.d(this);
        c.a();
        try {
            if (X0()) {
                long j10 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long t02 = t0();
                    if (t02 == Long.MAX_VALUE) {
                        c.a();
                        long nanoTime = System.nanoTime();
                        if (j10 == Long.MAX_VALUE) {
                            j10 = f30265h + nanoTime;
                        }
                        long j11 = j10 - nanoTime;
                        if (j11 <= 0) {
                            _thread = null;
                            U0();
                            c.a();
                            if (!N0()) {
                                z0();
                                return;
                            }
                            return;
                        }
                        t02 = f.g(t02, j11);
                    } else {
                        j10 = Long.MAX_VALUE;
                    }
                    if (t02 > 0) {
                        if (W0()) {
                            _thread = null;
                            U0();
                            c.a();
                            if (!N0()) {
                                z0();
                                return;
                            }
                            return;
                        }
                        c.a();
                        LockSupport.parkNanos(this, t02);
                    }
                }
            }
        } finally {
            _thread = null;
            U0();
            c.a();
            if (!N0()) {
                z0();
            }
        }
    }

    @Override // kotlinx.coroutines.y0
    protected Thread z0() {
        Thread thread = _thread;
        return thread == null ? V0() : thread;
    }
}
