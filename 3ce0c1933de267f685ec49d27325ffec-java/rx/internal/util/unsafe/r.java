package rx.internal.util.unsafe;

import java.util.Objects;
/* compiled from: SpscArrayQueue.java */
/* loaded from: classes3.dex */
public final class r<E> extends w<E> {
    public r(int i10) {
        super(i10);
    }

    private long h() {
        return f0.f34169a.getLongVolatile(this, t.f34175h);
    }

    private long i() {
        return f0.f34169a.getLongVolatile(this, x.f34176g);
    }

    private void j(long j10) {
        f0.f34169a.putOrderedLong(this, t.f34175h, j10);
    }

    private void k(long j10) {
        f0.f34169a.putOrderedLong(this, x.f34176g, j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return i() == h();
    }

    @Override // java.util.Queue
    public boolean offer(E e10) {
        Objects.requireNonNull(e10, "null elements not allowed");
        E[] eArr = this.f34168b;
        long j10 = this.producerIndex;
        long a10 = a(j10);
        if (e(eArr, a10) != null) {
            return false;
        }
        f(eArr, a10, e10);
        k(j10 + 1);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        return d(a(this.consumerIndex));
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.h
    public E poll() {
        long j10 = this.consumerIndex;
        long a10 = a(j10);
        E[] eArr = this.f34168b;
        E e10 = e(eArr, a10);
        if (e10 == null) {
            return null;
        }
        f(eArr, a10, null);
        j(j10 + 1);
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long h10 = h();
        while (true) {
            long i10 = i();
            long h11 = h();
            if (h10 == h11) {
                return (int) (i10 - h11);
            }
            h10 = h11;
        }
    }
}
