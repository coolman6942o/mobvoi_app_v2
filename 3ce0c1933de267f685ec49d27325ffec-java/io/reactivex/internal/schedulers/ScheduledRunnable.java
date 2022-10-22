package io.reactivex.internal.schedulers;

import ao.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
import xn.b;
/* loaded from: classes3.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, b {
    static final int FUTURE_INDEX = 1;
    static final int PARENT_INDEX = 0;
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;
    static final Object PARENT_DISPOSED = new Object();
    static final Object SYNC_DISPOSED = new Object();
    static final Object ASYNC_DISPOSED = new Object();
    static final Object DONE = new Object();

    public ScheduledRunnable(Runnable runnable, a aVar) {
        super(3);
        this.actual = runnable;
        lazySet(0, aVar);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // xn.b
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == DONE || obj5 == (obj3 = SYNC_DISPOSED) || obj5 == (obj4 = ASYNC_DISPOSED)) {
                break;
            }
            boolean z10 = get(2) != Thread.currentThread();
            if (z10) {
                obj3 = obj4;
            }
            if (compareAndSet(1, obj5, obj3)) {
                if (obj5 != null) {
                    ((Future) obj5).cancel(z10);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == DONE || obj == (obj2 = PARENT_DISPOSED) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((a) obj).a(this);
    }

    @Override // xn.b
    public boolean isDisposed() {
        Object obj = get(0);
        return obj == PARENT_DISPOSED || obj == DONE;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        boolean compareAndSet;
        lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
        } finally {
            try {
                lazySet(2, null);
                obj = get(0);
                if (obj == PARENT_DISPOSED) {
                    ((a) obj).a(this);
                }
                do {
                    obj2 = get(1);
                    if (obj2 == SYNC_DISPOSED) {
                        return;
                    }
                    return;
                } while (!compareAndSet(1, obj2, DONE));
            } catch (Throwable th2) {
                do {
                    if (obj3 != obj4) {
                        if (obj3 == obj5) {
                            break;
                        }
                    } else {
                        break;
                    }
                } while (!compareAndSet);
            }
        }
        lazySet(2, null);
        obj = get(0);
        if (!(obj == PARENT_DISPOSED || !compareAndSet(0, obj, DONE) || obj == null)) {
            ((a) obj).a(this);
        }
        do {
            obj2 = get(1);
            if (obj2 == SYNC_DISPOSED || obj2 == ASYNC_DISPOSED) {
                return;
            }
        } while (!compareAndSet(1, obj2, DONE));
    }

    public void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != DONE) {
                if (obj == SYNC_DISPOSED) {
                    future.cancel(false);
                    return;
                } else if (obj == ASYNC_DISPOSED) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }
}
