package com.google.android.gms.internal.measurement;

import android.os.Looper;
import b6.i;
import java.lang.Thread;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final class z1 extends z2 {

    /* renamed from: m  reason: collision with root package name */
    private static final AtomicLong f9837m = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f9838c;

    /* renamed from: d  reason: collision with root package name */
    private c2 f9839d;

    /* renamed from: e  reason: collision with root package name */
    private c2 f9840e;

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f9847l;

    /* renamed from: j  reason: collision with root package name */
    private final Object f9845j = new Object();

    /* renamed from: k  reason: collision with root package name */
    private final Semaphore f9846k = new Semaphore(2);

    /* renamed from: f  reason: collision with root package name */
    private final PriorityBlockingQueue<b2<?>> f9841f = new PriorityBlockingQueue<>();

    /* renamed from: g  reason: collision with root package name */
    private final BlockingQueue<b2<?>> f9842g = new LinkedBlockingQueue();

    /* renamed from: h  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f9843h = new a2(this, "Thread death: Uncaught exception on worker thread");

    /* renamed from: i  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f9844i = new a2(this, "Thread death: Uncaught exception on network thread");

    /* JADX INFO: Access modifiers changed from: package-private */
    public z1(d2 d2Var) {
        super(d2Var);
    }

    private final void D(b2<?> b2Var) {
        synchronized (this.f9845j) {
            this.f9841f.add(b2Var);
            c2 c2Var = this.f9839d;
            if (c2Var == null) {
                c2 c2Var2 = new c2(this, "Measurement Worker", this.f9841f);
                this.f9839d = c2Var2;
                c2Var2.setUncaughtExceptionHandler(this.f9843h);
                this.f9839d.start();
            } else {
                c2Var.b();
            }
        }
    }

    public static boolean z() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> T B(AtomicReference<T> atomicReference, long j10, String str, Runnable runnable) {
        synchronized (atomicReference) {
            d().J(runnable);
            try {
                atomicReference.wait(15000L);
            } catch (InterruptedException unused) {
                b1 N = c().N();
                String valueOf = String.valueOf(str);
                N.a(valueOf.length() != 0 ? "Interrupted waiting for ".concat(valueOf) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t10 = atomicReference.get();
        if (t10 == null) {
            b1 N2 = c().N();
            String valueOf2 = String.valueOf(str);
            N2.a(valueOf2.length() != 0 ? "Timed out waiting for ".concat(valueOf2) : new String("Timed out waiting for "));
        }
        return t10;
    }

    public final <V> Future<V> F(Callable<V> callable) throws IllegalStateException {
        u();
        i.k(callable);
        b2<?> b2Var = new b2<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f9839d) {
            if (!this.f9841f.isEmpty()) {
                c().N().a("Callable skipped the worker queue.");
            }
            b2Var.run();
        } else {
            D(b2Var);
        }
        return b2Var;
    }

    public final <V> Future<V> I(Callable<V> callable) throws IllegalStateException {
        u();
        i.k(callable);
        b2<?> b2Var = new b2<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f9839d) {
            b2Var.run();
        } else {
            D(b2Var);
        }
        return b2Var;
    }

    public final void J(Runnable runnable) throws IllegalStateException {
        u();
        i.k(runnable);
        D(new b2<>(this, runnable, false, "Task exception on worker thread"));
    }

    public final void L(Runnable runnable) throws IllegalStateException {
        u();
        i.k(runnable);
        b2<?> b2Var = new b2<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.f9845j) {
            this.f9842g.add(b2Var);
            c2 c2Var = this.f9840e;
            if (c2Var == null) {
                c2 c2Var2 = new c2(this, "Measurement Network", this.f9842g);
                this.f9840e = c2Var2;
                c2Var2.setUncaughtExceptionHandler(this.f9844i);
                this.f9840e.start();
            } else {
                c2Var.b();
            }
        }
    }

    public final boolean N() {
        return Thread.currentThread() == this.f9839d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ExecutorService O() {
        ExecutorService executorService;
        synchronized (this.f9845j) {
            if (this.f9838c == null) {
                this.f9838c = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.f9838c;
        }
        return executorService;
    }

    @Override // com.google.android.gms.internal.measurement.y2
    public final void e() {
        if (Thread.currentThread() != this.f9839d) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.internal.measurement.y2
    public final void g() {
        if (Thread.currentThread() != this.f9840e) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.internal.measurement.z2
    protected final boolean v() {
        return false;
    }
}
