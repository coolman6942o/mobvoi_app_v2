package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.a;
import rx.i;
import rx.internal.util.atomic.d;
import rx.internal.util.unsafe.f0;
import rx.internal.util.unsafe.y;
/* loaded from: classes3.dex */
public final class QueuedValueProducer<T> extends AtomicLong implements e {
    static final Object NULL_SENTINEL = new Object();
    private static final long serialVersionUID = 7277121710709137047L;
    final i<? super T> child;
    final Queue<Object> queue;
    final AtomicInteger wip;

    public QueuedValueProducer(i<? super T> iVar) {
        this(iVar, f0.b() ? new y() : new d());
    }

    private void a() {
        Object poll;
        if (this.wip.getAndIncrement() == 0) {
            i<? super T> iVar = this.child;
            Queue<Object> queue = this.queue;
            while (!iVar.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j10 = get();
                long j11 = 0;
                while (j10 != 0 && (poll = queue.poll()) != null) {
                    try {
                        if (poll == NULL_SENTINEL) {
                            iVar.onNext(null);
                        } else {
                            iVar.onNext(poll);
                        }
                        if (!iVar.isUnsubscribed()) {
                            j10--;
                            j11++;
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        a.g(th2, iVar, poll);
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
        a();
        return true;
    }

    @Override // rx.e
    public void request(long j10) {
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (i10 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (i10 > 0) {
            rx.internal.operators.a.b(this, j10);
            a();
        }
    }

    public QueuedValueProducer(i<? super T> iVar, Queue<Object> queue) {
        this.child = iVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }
}
