package io.reactivex.internal.observers;

import co.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.k;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* loaded from: classes2.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<b> implements r<T>, b {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final i<T> parent;
    final int prefetch;
    g<T> queue;

    public InnerQueuedObserver(i<T> iVar, int i10) {
        this.parent = iVar;
        this.prefetch = i10;
    }

    @Override // xn.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public int fusionMode() {
        return this.fusionMode;
    }

    @Override // xn.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // io.reactivex.r
    public void onComplete() {
        this.parent.c(this);
    }

    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        this.parent.b(this, th2);
    }

    @Override // io.reactivex.r
    public void onNext(T t10) {
        if (this.fusionMode == 0) {
            this.parent.d(this, t10);
        } else {
            this.parent.a();
        }
    }

    @Override // io.reactivex.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            if (bVar instanceof co.b) {
                co.b bVar2 = (co.b) bVar;
                int requestFusion = bVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.parent.c(this);
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    return;
                }
            }
            this.queue = k.b(-this.prefetch);
        }
    }

    public g<T> queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}
