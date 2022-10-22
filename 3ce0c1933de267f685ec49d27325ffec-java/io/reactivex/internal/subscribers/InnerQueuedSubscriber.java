package io.reactivex.internal.subscribers;

import co.d;
import co.g;
import io.reactivex.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.k;
import java.util.concurrent.atomic.AtomicReference;
import vp.c;
/* loaded from: classes3.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<c> implements f<T>, c {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final a<T> parent;
    final int prefetch;
    long produced;
    volatile g<T> queue;

    public InnerQueuedSubscriber(a<T> aVar, int i10) {
        this.parent = aVar;
        this.prefetch = i10;
        this.limit = i10 - (i10 >> 2);
    }

    @Override // vp.c
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // vp.b
    public void onComplete() {
        this.parent.b(this);
    }

    @Override // vp.b
    public void onError(Throwable th2) {
        this.parent.d(this, th2);
    }

    @Override // vp.b
    public void onNext(T t10) {
        if (this.fusionMode == 0) {
            this.parent.c(this, t10);
        } else {
            this.parent.a();
        }
    }

    @Override // vp.b
    public void onSubscribe(c cVar) {
        if (SubscriptionHelper.setOnce(this, cVar)) {
            if (cVar instanceof d) {
                d dVar = (d) cVar;
                int requestFusion = dVar.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = dVar;
                    this.done = true;
                    this.parent.b(this);
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = dVar;
                    k.d(cVar, this.prefetch);
                    return;
                }
            }
            this.queue = k.b(this.prefetch);
            k.d(cVar, this.prefetch);
        }
    }

    public g<T> queue() {
        return this.queue;
    }

    @Override // vp.c
    public void request(long j10) {
        if (this.fusionMode != 1) {
            long j11 = this.produced + j10;
            if (j11 >= this.limit) {
                this.produced = 0L;
                get().request(j11);
                return;
            }
            this.produced = j11;
        }
    }

    public void requestOne() {
        if (this.fusionMode != 1) {
            long j10 = this.produced + 1;
            if (j10 == this.limit) {
                this.produced = 0L;
                get().request(j10);
                return;
            }
            this.produced = j10;
        }
    }

    public void setDone() {
        this.done = true;
    }
}
