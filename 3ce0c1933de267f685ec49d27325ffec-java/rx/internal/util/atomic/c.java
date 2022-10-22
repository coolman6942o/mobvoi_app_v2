package rx.internal.util.atomic;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: SpscAtomicArrayQueue.java */
/* loaded from: classes3.dex */
public final class c<E> extends a<E> {

    /* renamed from: g  reason: collision with root package name */
    private static final Integer f34104g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: d  reason: collision with root package name */
    long f34106d;

    /* renamed from: f  reason: collision with root package name */
    final int f34108f;

    /* renamed from: c  reason: collision with root package name */
    final AtomicLong f34105c = new AtomicLong();

    /* renamed from: e  reason: collision with root package name */
    final AtomicLong f34107e = new AtomicLong();

    public c(int i10) {
        super(i10);
        this.f34108f = Math.min(i10 / 4, f34104g.intValue());
    }

    private long f() {
        return this.f34107e.get();
    }

    private long g() {
        return this.f34105c.get();
    }

    private void h(long j10) {
        this.f34107e.lazySet(j10);
    }

    private void i(long j10) {
        this.f34105c.lazySet(j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return g() == f();
    }

    @Override // java.util.Queue
    public boolean offer(E e10) {
        Objects.requireNonNull(e10, "Null is not a valid element");
        AtomicReferenceArray<E> atomicReferenceArray = this.f34100a;
        int i10 = this.f34101b;
        long j10 = this.f34105c.get();
        int b10 = b(j10, i10);
        if (j10 >= this.f34106d) {
            long j11 = this.f34108f + j10;
            if (d(atomicReferenceArray, b(j11, i10)) == null) {
                this.f34106d = j11;
            } else if (d(atomicReferenceArray, b10) != null) {
                return false;
            }
        }
        e(atomicReferenceArray, b10, e10);
        i(j10 + 1);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        return c(a(this.f34107e.get()));
    }

    @Override // java.util.Queue
    public E poll() {
        long j10 = this.f34107e.get();
        int a10 = a(j10);
        AtomicReferenceArray<E> atomicReferenceArray = this.f34100a;
        E d10 = d(atomicReferenceArray, a10);
        if (d10 == null) {
            return null;
        }
        e(atomicReferenceArray, a10, null);
        h(j10 + 1);
        return d10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long f10 = f();
        while (true) {
            long g10 = g();
            long f11 = f();
            if (f10 == f11) {
                return (int) (g10 - f11);
            }
            f10 = f11;
        }
    }
}
