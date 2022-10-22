package io.reactivex.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: AbstractDirectTask.java */
/* loaded from: classes3.dex */
abstract class a extends AtomicReference<Future<?>> implements b {
    protected static final FutureTask<Void> DISPOSED;
    protected static final FutureTask<Void> FINISHED;
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;

    static {
        Runnable runnable = bo.a.f5358b;
        FINISHED = new FutureTask<>(runnable, null);
        DISPOSED = new FutureTask<>(runnable, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override // xn.b
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future != FINISHED && future != (futureTask = DISPOSED) && compareAndSet(future, futureTask) && future != null) {
            future.cancel(this.runner != Thread.currentThread());
        }
    }

    public Runnable getWrappedRunnable() {
        return this.runnable;
    }

    @Override // xn.b
    public final boolean isDisposed() {
        Future<?> future = get();
        return future == FINISHED || future == DISPOSED;
    }

    public final void setFuture(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 != FINISHED) {
                if (future2 == DISPOSED) {
                    future.cancel(this.runner != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
