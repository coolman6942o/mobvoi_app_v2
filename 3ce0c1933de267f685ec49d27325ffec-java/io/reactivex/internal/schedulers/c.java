package io.reactivex.internal.schedulers;

import bo.a;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InstantPeriodicTask.java */
/* loaded from: classes3.dex */
public final class c implements Callable<Void>, b {

    /* renamed from: f  reason: collision with root package name */
    static final FutureTask<Void> f29195f = new FutureTask<>(a.f5358b, null);

    /* renamed from: a  reason: collision with root package name */
    final Runnable f29196a;

    /* renamed from: d  reason: collision with root package name */
    final ExecutorService f29199d;

    /* renamed from: e  reason: collision with root package name */
    Thread f29200e;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<Future<?>> f29198c = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<Future<?>> f29197b = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.f29196a = runnable;
        this.f29199d = executorService;
    }

    /* renamed from: a */
    public Void call() throws Exception {
        this.f29200e = Thread.currentThread();
        try {
            this.f29196a.run();
            c(this.f29199d.submit(this));
            this.f29200e = null;
        } catch (Throwable th2) {
            this.f29200e = null;
            fo.a.s(th2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f29198c.get();
            if (future2 == f29195f) {
                future.cancel(this.f29200e != Thread.currentThread());
                return;
            }
        } while (!this.f29198c.compareAndSet(future2, future));
    }

    void c(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f29197b.get();
            if (future2 == f29195f) {
                future.cancel(this.f29200e != Thread.currentThread());
                return;
            }
        } while (!this.f29197b.compareAndSet(future2, future));
    }

    @Override // xn.b
    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.f29198c;
        FutureTask<Void> futureTask = f29195f;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        boolean z10 = true;
        if (!(andSet == null || andSet == futureTask)) {
            andSet.cancel(this.f29200e != Thread.currentThread());
        }
        Future<?> andSet2 = this.f29197b.getAndSet(futureTask);
        if (andSet2 != null && andSet2 != futureTask) {
            if (this.f29200e == Thread.currentThread()) {
                z10 = false;
            }
            andSet2.cancel(z10);
        }
    }

    @Override // xn.b
    public boolean isDisposed() {
        return this.f29198c.get() == f29195f;
    }
}
