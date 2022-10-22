package io.reactivex.internal.queue;

import co.f;
import io.reactivex.internal.util.j;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes3.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements f<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final int lookAheadStep;
    long producerLookAhead;
    final int mask = length() - 1;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public SpscArrayQueue(int i10) {
        super(j.a(i10));
        this.lookAheadStep = Math.min(i10 / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    int a(long j10) {
        return ((int) j10) & this.mask;
    }

    int b(long j10, int i10) {
        return ((int) j10) & i10;
    }

    E c(int i10) {
        return get(i10);
    }

    @Override // co.g
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    void d(long j10) {
        this.consumerIndex.lazySet(j10);
    }

    void g(int i10, E e10) {
        lazySet(i10, e10);
    }

    void h(long j10) {
        this.producerIndex.lazySet(j10);
    }

    @Override // co.g
    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    @Override // co.g
    public boolean offer(E e10) {
        Objects.requireNonNull(e10, "Null is not a valid element");
        int i10 = this.mask;
        long j10 = this.producerIndex.get();
        int b10 = b(j10, i10);
        if (j10 >= this.producerLookAhead) {
            long j11 = this.lookAheadStep + j10;
            if (c(b(j11, i10)) == null) {
                this.producerLookAhead = j11;
            } else if (c(b10) != null) {
                return false;
            }
        }
        g(b10, e10);
        h(j10 + 1);
        return true;
    }

    @Override // co.f, co.g
    public E poll() {
        long j10 = this.consumerIndex.get();
        int a10 = a(j10);
        E c10 = c(a10);
        if (c10 == null) {
            return null;
        }
        d(j10 + 1);
        g(a10, null);
        return c10;
    }

    public boolean offer(E e10, E e11) {
        return offer(e10) && offer(e11);
    }
}
