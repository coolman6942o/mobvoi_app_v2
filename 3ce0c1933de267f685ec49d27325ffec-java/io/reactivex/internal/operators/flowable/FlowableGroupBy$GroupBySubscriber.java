package io.reactivex.internal.operators.flowable;

import io.reactivex.f;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import vp.b;
import vp.c;
import yn.a;
import zn.o;
/* loaded from: classes2.dex */
public final class FlowableGroupBy$GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<a<K, V>> implements f<T> {
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final boolean delayError;
    boolean done;
    final b<? super a<K, V>> downstream;
    Throwable error;
    final Queue<c<K, V>> evictedGroups;
    volatile boolean finished;
    final Map<Object, c<K, V>> groups;
    final o<? super T, ? extends K> keySelector;
    boolean outputFused;
    final io.reactivex.internal.queue.b<a<K, V>> queue;
    c upstream;
    final o<? super T, ? extends V> valueSelector;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final AtomicLong requested = new AtomicLong();
    final AtomicInteger groupCount = new AtomicInteger(1);

    public FlowableGroupBy$GroupBySubscriber(b<? super a<K, V>> bVar, o<? super T, ? extends K> oVar, o<? super T, ? extends V> oVar2, int i10, boolean z10, Map<Object, c<K, V>> map, Queue<c<K, V>> queue) {
        this.downstream = bVar;
        this.keySelector = oVar;
        this.valueSelector = oVar2;
        this.bufferSize = i10;
        this.delayError = z10;
        this.groups = map;
        this.evictedGroups = queue;
        this.queue = new io.reactivex.internal.queue.b<>(i10);
    }

    private void c() {
        if (this.evictedGroups != null) {
            int i10 = 0;
            while (true) {
                c<K, V> poll = this.evictedGroups.poll();
                if (poll == null) {
                    break;
                }
                poll.j();
                i10++;
            }
            if (i10 != 0) {
                this.groupCount.addAndGet(-i10);
            }
        }
    }

    boolean b(boolean z10, boolean z11, b<?> bVar, io.reactivex.internal.queue.b<?> bVar2) {
        if (this.cancelled.get()) {
            bVar2.clear();
            return true;
        } else if (this.delayError) {
            if (!z10 || !z11) {
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                bVar.onError(th2);
            } else {
                bVar.onComplete();
            }
            return true;
        } else if (!z10) {
            return false;
        } else {
            Throwable th3 = this.error;
            if (th3 != null) {
                bVar2.clear();
                bVar.onError(th3);
                return true;
            } else if (!z11) {
                return false;
            } else {
                bVar.onComplete();
                return true;
            }
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vp.c
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true)) {
            c();
            if (this.groupCount.decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, co.g
    public void clear() {
        this.queue.clear();
    }

    void d() {
        if (getAndIncrement() == 0) {
            if (this.outputFused) {
                g();
            } else {
                h();
            }
        }
    }

    void g() {
        Throwable th2;
        io.reactivex.internal.queue.b<a<K, V>> bVar = this.queue;
        b<? super a<K, V>> bVar2 = this.downstream;
        int i10 = 1;
        while (!this.cancelled.get()) {
            boolean z10 = this.finished;
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
                } else {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                }
            } else {
                bVar.clear();
                bVar2.onError(th2);
                return;
            }
        }
        bVar.clear();
    }

    void h() {
        int i10;
        io.reactivex.internal.queue.b<a<K, V>> bVar = this.queue;
        b<? super a<K, V>> bVar2 = this.downstream;
        int i11 = 1;
        do {
            long j10 = this.requested.get();
            long j11 = 0;
            while (true) {
                i10 = (j11 > j10 ? 1 : (j11 == j10 ? 0 : -1));
                if (i10 == 0) {
                    break;
                }
                boolean z10 = this.finished;
                a<K, V> poll = bVar.poll();
                boolean z11 = poll == null;
                if (!b(z10, z11, bVar2, bVar)) {
                    if (z11) {
                        break;
                    }
                    bVar2.onNext(poll);
                    j11++;
                } else {
                    return;
                }
            }
            if (i10 != 0 || !b(this.finished, bVar.isEmpty(), bVar2, bVar)) {
                if (j11 != 0) {
                    if (j10 != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j11);
                    }
                    this.upstream.request(j11);
                }
                i11 = addAndGet(-i11);
            } else {
                return;
            }
        } while (i11 != 0);
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, co.g
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // vp.b
    public void onComplete() {
        if (!this.done) {
            for (c<K, V> cVar : this.groups.values()) {
                cVar.j();
            }
            this.groups.clear();
            Queue<c<K, V>> queue = this.evictedGroups;
            if (queue != null) {
                queue.clear();
            }
            this.done = true;
            this.finished = true;
            d();
        }
    }

    @Override // vp.b
    public void onError(Throwable th2) {
        if (this.done) {
            fo.a.s(th2);
            return;
        }
        this.done = true;
        for (c<K, V> cVar : this.groups.values()) {
            cVar.k(th2);
        }
        this.groups.clear();
        Queue<c<K, V>> queue = this.evictedGroups;
        if (queue != null) {
            queue.clear();
        }
        this.error = th2;
        this.finished = true;
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vp.b
    public void onNext(T t10) {
        if (!this.done) {
            io.reactivex.internal.queue.b<a<K, V>> bVar = this.queue;
            try {
                K apply = this.keySelector.apply(t10);
                boolean z10 = false;
                Object obj = apply != null ? apply : NULL_KEY;
                c<K, V> cVar = this.groups.get(obj);
                if (cVar == null) {
                    if (!this.cancelled.get()) {
                        cVar = c.i(apply, this.bufferSize, this, this.delayError);
                        this.groups.put(obj, cVar);
                        this.groupCount.getAndIncrement();
                        z10 = true;
                    } else {
                        return;
                    }
                }
                try {
                    cVar.l(bo.b.e(this.valueSelector.apply(t10), "The valueSelector returned null"));
                    c();
                    if (z10) {
                        bVar.offer(cVar);
                        d();
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.upstream.cancel();
                    onError(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.upstream.cancel();
                onError(th3);
            }
        }
    }

    @Override // vp.b
    public void onSubscribe(c cVar) {
        if (SubscriptionHelper.validate(this.upstream, cVar)) {
            this.upstream = cVar;
            this.downstream.onSubscribe(this);
            cVar.request(this.bufferSize);
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vp.c
    public void request(long j10) {
        if (SubscriptionHelper.validate(j10)) {
            io.reactivex.internal.util.b.a(this.requested, j10);
            d();
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

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, co.g
    public a<K, V> poll() {
        return this.queue.poll();
    }

    public void cancel(K k10) {
        if (k10 == null) {
            k10 = (K) NULL_KEY;
        }
        this.groups.remove(k10);
        if (this.groupCount.decrementAndGet() == 0) {
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }
}
