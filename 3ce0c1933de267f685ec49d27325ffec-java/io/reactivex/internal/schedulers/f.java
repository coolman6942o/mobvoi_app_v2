package io.reactivex.internal.schedulers;

import ao.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.s;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import xn.b;
/* compiled from: NewThreadWorker.java */
/* loaded from: classes3.dex */
public class f extends s.c {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f29222a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f29223b;

    public f(ThreadFactory threadFactory) {
        this.f29222a = h.a(threadFactory);
    }

    @Override // io.reactivex.s.c
    public b b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // io.reactivex.s.c
    public b c(Runnable runnable, long j10, TimeUnit timeUnit) {
        if (this.f29223b) {
            return EmptyDisposable.INSTANCE;
        }
        return e(runnable, j10, timeUnit, null);
    }

    @Override // xn.b
    public void dispose() {
        if (!this.f29223b) {
            this.f29223b = true;
            this.f29222a.shutdownNow();
        }
    }

    public ScheduledRunnable e(Runnable runnable, long j10, TimeUnit timeUnit, a aVar) {
        Future<?> future;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(fo.a.u(runnable), aVar);
        if (aVar != null && !aVar.b(scheduledRunnable)) {
            return scheduledRunnable;
        }
        try {
            if (j10 <= 0) {
                future = this.f29222a.submit((Callable) scheduledRunnable);
            } else {
                future = this.f29222a.schedule((Callable) scheduledRunnable, j10, timeUnit);
            }
            scheduledRunnable.setFuture(future);
        } catch (RejectedExecutionException e10) {
            if (aVar != null) {
                aVar.c(scheduledRunnable);
            }
            fo.a.s(e10);
        }
        return scheduledRunnable;
    }

    public b f(Runnable runnable, long j10, TimeUnit timeUnit) {
        Future<?> future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(fo.a.u(runnable));
        try {
            if (j10 <= 0) {
                future = this.f29222a.submit(scheduledDirectTask);
            } else {
                future = this.f29222a.schedule(scheduledDirectTask, j10, timeUnit);
            }
            scheduledDirectTask.setFuture(future);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e10) {
            fo.a.s(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    public b g(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Future<?> future;
        Runnable u10 = fo.a.u(runnable);
        if (j11 <= 0) {
            c cVar = new c(u10, this.f29222a);
            try {
                if (j10 <= 0) {
                    future = this.f29222a.submit(cVar);
                } else {
                    future = this.f29222a.schedule(cVar, j10, timeUnit);
                }
                cVar.b(future);
                return cVar;
            } catch (RejectedExecutionException e10) {
                fo.a.s(e10);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(u10);
            try {
                scheduledDirectPeriodicTask.setFuture(this.f29222a.scheduleAtFixedRate(scheduledDirectPeriodicTask, j10, j11, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e11) {
                fo.a.s(e11);
                return EmptyDisposable.INSTANCE;
            }
        }
    }

    public void h() {
        if (!this.f29223b) {
            this.f29223b = true;
            this.f29222a.shutdown();
        }
    }

    @Override // xn.b
    public boolean isDisposed() {
        return this.f29223b;
    }
}
