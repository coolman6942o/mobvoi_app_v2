package io.reactivex.internal.observers;

import fo.a;
import io.reactivex.r;
/* loaded from: classes2.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    static final int DISPOSED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int TERMINATED = 2;
    private static final long serialVersionUID = -5502432239815349361L;
    protected final r<? super T> downstream;
    protected T value;

    public DeferredScalarDisposable(r<? super T> rVar) {
        this.downstream = rVar;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T t10) {
        int i10 = get();
        if ((i10 & 54) == 0) {
            r<? super T> rVar = this.downstream;
            if (i10 == 8) {
                this.value = t10;
                lazySet(16);
                rVar.onNext(null);
            } else {
                lazySet(2);
                rVar.onNext(t10);
            }
            if (get() != 4) {
                rVar.onComplete();
            }
        }
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, xn.b
    public void dispose() {
        set(4);
        this.value = null;
    }

    public final void error(Throwable th2) {
        if ((get() & 54) != 0) {
            a.s(th2);
            return;
        }
        lazySet(2);
        this.downstream.onError(th2);
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, xn.b
    public final boolean isDisposed() {
        return get() == 4;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t10 = this.value;
        this.value = null;
        lazySet(32);
        return t10;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.c
    public final int requestFusion(int i10) {
        if ((i10 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final boolean tryDispose() {
        return getAndSet(4) != 4;
    }

    public final void complete() {
        if ((get() & 54) == 0) {
            lazySet(2);
            this.downstream.onComplete();
        }
    }
}
