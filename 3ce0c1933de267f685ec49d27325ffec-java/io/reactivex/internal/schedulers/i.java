package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.s;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: SingleScheduler.java */
/* loaded from: classes3.dex */
public final class i extends s {

    /* renamed from: c  reason: collision with root package name */
    static final RxThreadFactory f29230c = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);

    /* renamed from: d  reason: collision with root package name */
    static final ScheduledExecutorService f29231d;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f29232b;

    /* compiled from: SingleScheduler.java */
    /* loaded from: classes3.dex */
    static final class a extends s.c {

        /* renamed from: a  reason: collision with root package name */
        final ScheduledExecutorService f29233a;

        /* renamed from: b  reason: collision with root package name */
        final xn.a f29234b = new xn.a();

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f29235c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f29233a = scheduledExecutorService;
        }

        @Override // io.reactivex.s.c
        public b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            Future<?> future;
            if (this.f29235c) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(fo.a.u(runnable), this.f29234b);
            this.f29234b.b(scheduledRunnable);
            try {
                if (j10 <= 0) {
                    future = this.f29233a.submit((Callable) scheduledRunnable);
                } else {
                    future = this.f29233a.schedule((Callable) scheduledRunnable, j10, timeUnit);
                }
                scheduledRunnable.setFuture(future);
                return scheduledRunnable;
            } catch (RejectedExecutionException e10) {
                dispose();
                fo.a.s(e10);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // xn.b
        public void dispose() {
            if (!this.f29235c) {
                this.f29235c = true;
                this.f29234b.dispose();
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29235c;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f29231d = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public i() {
        this(f29230c);
    }

    static ScheduledExecutorService f(ThreadFactory threadFactory) {
        return h.a(threadFactory);
    }

    @Override // io.reactivex.s
    public s.c a() {
        return new a(this.f29232b.get());
    }

    @Override // io.reactivex.s
    public b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        Future<?> future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(fo.a.u(runnable));
        try {
            if (j10 <= 0) {
                future = this.f29232b.get().submit(scheduledDirectTask);
            } else {
                future = this.f29232b.get().schedule(scheduledDirectTask, j10, timeUnit);
            }
            scheduledDirectTask.setFuture(future);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e10) {
            fo.a.s(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.s
    public b e(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Future<?> future;
        Runnable u10 = fo.a.u(runnable);
        if (j11 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f29232b.get();
            c cVar = new c(u10, scheduledExecutorService);
            try {
                if (j10 <= 0) {
                    future = scheduledExecutorService.submit(cVar);
                } else {
                    future = scheduledExecutorService.schedule(cVar, j10, timeUnit);
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
                scheduledDirectPeriodicTask.setFuture(this.f29232b.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j10, j11, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e11) {
                fo.a.s(e11);
                return EmptyDisposable.INSTANCE;
            }
        }
    }

    public i(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f29232b = atomicReference;
        atomicReference.lazySet(f(threadFactory));
    }
}
