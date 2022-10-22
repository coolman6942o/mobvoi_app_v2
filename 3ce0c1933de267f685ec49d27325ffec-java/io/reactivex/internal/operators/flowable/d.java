package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.b;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import vp.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlowableGroupBy.java */
/* loaded from: classes2.dex */
public final class d<T, K> extends BasicIntQueueSubscription<T> implements a<T> {
    private static final long serialVersionUID = -3852313036005250360L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    boolean outputFused;
    final FlowableGroupBy$GroupBySubscriber<?, K, T> parent;
    int produced;
    final b<T> queue;
    final AtomicLong requested = new AtomicLong();
    final AtomicBoolean cancelled = new AtomicBoolean();
    final AtomicReference<vp.b<? super T>> actual = new AtomicReference<>();
    final AtomicBoolean once = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i10, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, K k10, boolean z10) {
        this.queue = new b<>(i10);
        this.parent = flowableGroupBy$GroupBySubscriber;
        this.key = k10;
        this.delayError = z10;
    }

    @Override // vp.a
    public void a(vp.b<? super T> bVar) {
        if (this.once.compareAndSet(false, true)) {
            bVar.onSubscribe(this);
            this.actual.lazySet(bVar);
            c();
            return;
        }
        EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), bVar);
    }

    boolean b(boolean z10, boolean z11, vp.b<? super T> bVar, boolean z12) {
        if (this.cancelled.get()) {
            this.queue.clear();
            return true;
        } else if (!z10) {
            return false;
        } else {
            if (!z12) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    bVar.onError(th2);
                    return true;
                } else if (!z11) {
                    return false;
                } else {
                    bVar.onComplete();
                    return true;
                }
            } else if (!z11) {
                return false;
            } else {
                Throwable th3 = this.error;
                if (th3 != null) {
                    bVar.onError(th3);
                } else {
                    bVar.onComplete();
                }
                return true;
            }
        }
    }

    void c() {
        if (getAndIncrement() == 0) {
            if (this.outputFused) {
                d();
            } else {
                g();
            }
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vp.c
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true)) {
            this.parent.cancel(this.key);
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, co.g
    public void clear() {
        this.queue.clear();
    }

    void d() {
        Throwable th2;
        b<T> bVar = this.queue;
        vp.b<? super T> bVar2 = this.actual.get();
        int i10 = 1;
        while (true) {
            if (bVar2 != null) {
                if (this.cancelled.get()) {
                    bVar.clear();
                    return;
                }
                boolean z10 = this.done;
                if (!z10 || this.delayError || (th2 = this.error) == null) {
                    bVar2.onNext(null);
                    if (z10) {
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            bVar2.onError(th3);
                            return;
                        } else {
                            bVar2.onComplete();
                            return;
                        }
                    }
                } else {
                    bVar.clear();
                    bVar2.onError(th2);
                    return;
                }
            }
            i10 = addAndGet(-i10);
            if (i10 != 0) {
                if (bVar2 == null) {
                    bVar2 = this.actual.get();
                }
            } else {
                return;
            }
        }
    }

    void g() {
        int i10;
        b<T> bVar = this.queue;
        boolean z10 = this.delayError;
        vp.b<? super T> bVar2 = this.actual.get();
        int i11 = 1;
        while (true) {
            if (bVar2 != null) {
                long j10 = this.requested.get();
                long j11 = 0;
                while (true) {
                    i10 = (j11 > j10 ? 1 : (j11 == j10 ? 0 : -1));
                    if (i10 == 0) {
                        break;
                    }
                    boolean z11 = this.done;
                    Object obj = (T) bVar.poll();
                    boolean z12 = obj == null;
                    if (!b(z11, z12, bVar2, z10)) {
                        if (z12) {
                            break;
                        }
                        bVar2.onNext(obj);
                        j11++;
                    } else {
                        return;
                    }
                }
                if (i10 == 0 && b(this.done, bVar.isEmpty(), bVar2, z10)) {
                    return;
                }
                if (j11 != 0) {
                    if (j10 != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j11);
                    }
                    this.parent.upstream.request(j11);
                }
            }
            i11 = addAndGet(-i11);
            if (i11 != 0) {
                if (bVar2 == null) {
                    bVar2 = this.actual.get();
                }
            } else {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, co.g
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        this.done = true;
        c();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        c();
    }

    public void onNext(T t10) {
        this.queue.offer(t10);
        c();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, co.g
    public T poll() {
        T poll = this.queue.poll();
        if (poll != null) {
            this.produced++;
            return poll;
        }
        int i10 = this.produced;
        if (i10 == 0) {
            return null;
        }
        this.produced = 0;
        this.parent.upstream.request(i10);
        return null;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vp.c
    public void request(long j10) {
        if (SubscriptionHelper.validate(j10)) {
            io.reactivex.internal.util.b.a(this.requested, j10);
            c();
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, co.c
    public int requestFusion(int i10) {
        if ((i10 & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }
}
