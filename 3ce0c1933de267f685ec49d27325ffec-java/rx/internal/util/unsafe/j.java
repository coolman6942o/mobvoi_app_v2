package rx.internal.util.unsafe;

import java.util.Objects;
/* compiled from: SpmcArrayQueue.java */
/* loaded from: classes3.dex */
public final class j<E> extends n<E> {
    public j(int i10) {
        super(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return k() == h();
    }

    @Override // java.util.Queue
    public boolean offer(E e10) {
        Objects.requireNonNull(e10, "Null is not a valid element");
        E[] eArr = this.f34168b;
        long j10 = this.f34167a;
        long h10 = h();
        long a10 = a(h10);
        if (e(eArr, a10) == null) {
            g(eArr, a10, e10);
            i(h10 + 1);
            return true;
        } else if (h10 - k() > j10) {
            return false;
        } else {
            do {
            } while (e(eArr, a10) != null);
            g(eArr, a10, e10);
            i(h10 + 1);
            return true;
        }
    }

    @Override // java.util.Queue
    public E peek() {
        E d10;
        long l10 = l();
        do {
            long k10 = k();
            if (k10 >= l10) {
                long h10 = h();
                if (k10 >= h10) {
                    return null;
                }
                m(h10);
            }
            d10 = d(a(k10));
        } while (d10 == null);
        return d10;
    }

    @Override // java.util.Queue, rx.internal.util.unsafe.h
    public E poll() {
        long k10;
        long l10 = l();
        do {
            k10 = k();
            if (k10 >= l10) {
                long h10 = h();
                if (k10 >= h10) {
                    return null;
                }
                m(h10);
            }
        } while (!j(k10, 1 + k10));
        long a10 = a(k10);
        E[] eArr = this.f34168b;
        E c10 = c(eArr, a10);
        f(eArr, a10, null);
        return c10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long k10 = k();
        while (true) {
            long h10 = h();
            long k11 = k();
            if (k10 == k11) {
                return (int) (h10 - k11);
            }
            k10 = k11;
        }
    }
}
