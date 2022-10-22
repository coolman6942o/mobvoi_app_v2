package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.d;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.a;
import rx.i;
import rx.internal.util.unsafe.f0;
import rx.internal.util.unsafe.y;
/* loaded from: classes3.dex */
public final class QueuedProducer<T> extends AtomicLong implements e, d<T> {
    static final Object NULL_SENTINEL = new Object();
    private static final long serialVersionUID = 7277121710709137047L;
    final i<? super T> child;
    volatile boolean done;
    Throwable error;
    final Queue<Object> queue;
    final AtomicInteger wip;

    public QueuedProducer(i<? super T> iVar) {
        this(iVar, f0.b() ? new y() : new rx.internal.util.atomic.d());
    }

    private boolean b(boolean z10, boolean z11) {
        if (this.child.isUnsubscribed()) {
            return true;
        }
        if (!z10) {
            return false;
        }
        Throwable th2 = this.error;
        if (th2 != null) {
            this.queue.clear();
            this.child.onError(th2);
            return true;
        } else if (!z11) {
            return false;
        } else {
            this.child.onCompleted();
            return true;
        }
    }

    private void c() {
        if (this.wip.getAndIncrement() == 0) {
            i<? super T> iVar = this.child;
            Queue<Object> queue = this.queue;
            while (!b(this.done, queue.isEmpty())) {
                this.wip.lazySet(1);
                long j10 = get();
                long j11 = 0;
                while (j10 != 0) {
                    boolean z10 = this.done;
                    Object poll = queue.poll();
                    if (!b(z10, poll == null)) {
                        if (poll == null) {
                            break;
                        }
                        try {
                            if (poll == NULL_SENTINEL) {
                                iVar.onNext(null);
                            } else {
                                iVar.onNext(poll);
                            }
                            j10--;
                            j11++;
                        } catch (Throwable th2) {
                            if (poll == NULL_SENTINEL) {
                                poll = null;
                            }
                            a.g(th2, iVar, poll);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (!(j11 == 0 || get() == Long.MAX_VALUE)) {
                    addAndGet(-j11);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public boolean offer(T t10) {
        if (t10 == null) {
            if (!this.queue.offer(NULL_SENTINEL)) {
                return false;
            }
        } else if (!this.queue.offer(t10)) {
            return false;
        }
        c();
        return true;
    }

    @Override // rx.d
    public void onCompleted() {
        this.done = true;
        c();
    }

    @Override // rx.d
    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        c();
    }

    @Override // rx.d
    public void onNext(T t10) {
        if (!offer(t10)) {
            onError(new MissingBackpressureException());
        }
    }

    @Override // rx.e
    public void request(long j10) {
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (i10 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (i10 > 0) {
            rx.internal.operators.a.b(this, j10);
            c();
        }
    }

    public QueuedProducer(i<? super T> iVar, Queue<Object> queue) {
        this.child = iVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }
}
