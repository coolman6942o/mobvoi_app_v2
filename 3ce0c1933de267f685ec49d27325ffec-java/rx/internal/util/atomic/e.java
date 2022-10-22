package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.i;
/* compiled from: SpscUnboundedAtomicArrayQueue.java */
/* loaded from: classes3.dex */
public final class e<T> implements Queue<T> {

    /* renamed from: i  reason: collision with root package name */
    static final int f34109i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j  reason: collision with root package name */
    private static final Object f34110j = new Object();

    /* renamed from: b  reason: collision with root package name */
    int f34112b;

    /* renamed from: c  reason: collision with root package name */
    long f34113c;

    /* renamed from: d  reason: collision with root package name */
    int f34114d;

    /* renamed from: e  reason: collision with root package name */
    AtomicReferenceArray<Object> f34115e;

    /* renamed from: f  reason: collision with root package name */
    int f34116f;

    /* renamed from: g  reason: collision with root package name */
    AtomicReferenceArray<Object> f34117g;

    /* renamed from: a  reason: collision with root package name */
    final AtomicLong f34111a = new AtomicLong();

    /* renamed from: h  reason: collision with root package name */
    final AtomicLong f34118h = new AtomicLong();

    public e(int i10) {
        int b10 = i.b(Math.max(8, i10));
        int i11 = b10 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(b10 + 1);
        this.f34115e = atomicReferenceArray;
        this.f34114d = i11;
        a(b10);
        this.f34117g = atomicReferenceArray;
        this.f34116f = i11;
        this.f34113c = i11 - 1;
        p(0L);
    }

    private void a(int i10) {
        this.f34112b = Math.min(i10 / 4, f34109i);
    }

    private static int b(int i10) {
        return i10;
    }

    private static int c(long j10, int i10) {
        return b(((int) j10) & i10);
    }

    private long d() {
        return this.f34118h.get();
    }

    private long e() {
        return this.f34111a.get();
    }

    private long f() {
        return this.f34118h.get();
    }

    private static <E> Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i10) {
        return atomicReferenceArray.get(i10);
    }

    private AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) g(atomicReferenceArray, b(atomicReferenceArray.length() - 1));
    }

    private long i() {
        return this.f34111a.get();
    }

    private T j(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10) {
        this.f34117g = atomicReferenceArray;
        return (T) g(atomicReferenceArray, c(j10, i10));
    }

    private T k(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10) {
        this.f34117g = atomicReferenceArray;
        int c10 = c(j10, i10);
        T t10 = (T) g(atomicReferenceArray, c10);
        if (t10 == null) {
            return null;
        }
        m(j10 + 1);
        n(atomicReferenceArray, c10, null);
        return t10;
    }

    private void l(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10, T t10, long j11) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f34115e = atomicReferenceArray2;
        this.f34113c = (j11 + j10) - 1;
        p(j10 + 1);
        n(atomicReferenceArray2, i10, t10);
        o(atomicReferenceArray, atomicReferenceArray2);
        n(atomicReferenceArray, i10, f34110j);
    }

    private void m(long j10) {
        this.f34118h.lazySet(j10);
    }

    private static void n(AtomicReferenceArray<Object> atomicReferenceArray, int i10, Object obj) {
        atomicReferenceArray.lazySet(i10, obj);
    }

    private void o(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        n(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void p(long j10) {
        this.f34111a.lazySet(j10);
    }

    private boolean q(AtomicReferenceArray<Object> atomicReferenceArray, T t10, long j10, int i10) {
        p(j10 + 1);
        n(atomicReferenceArray, i10, t10);
        return true;
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return i() == f();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public boolean offer(T t10) {
        Objects.requireNonNull(t10);
        AtomicReferenceArray<Object> atomicReferenceArray = this.f34115e;
        long e10 = e();
        int i10 = this.f34114d;
        int c10 = c(e10, i10);
        if (e10 < this.f34113c) {
            return q(atomicReferenceArray, t10, e10, c10);
        }
        long j10 = this.f34112b + e10;
        if (g(atomicReferenceArray, c(j10, i10)) == null) {
            this.f34113c = j10 - 1;
            return q(atomicReferenceArray, t10, e10, c10);
        } else if (g(atomicReferenceArray, c(1 + e10, i10)) != null) {
            return q(atomicReferenceArray, t10, e10, c10);
        } else {
            l(atomicReferenceArray, e10, c10, t10, i10);
            return true;
        }
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f34117g;
        long d10 = d();
        int i10 = this.f34116f;
        T t10 = (T) g(atomicReferenceArray, c(d10, i10));
        return t10 == f34110j ? j(h(atomicReferenceArray), d10, i10) : t10;
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f34117g;
        long d10 = d();
        int i10 = this.f34116f;
        int c10 = c(d10, i10);
        T t10 = (T) g(atomicReferenceArray, c10);
        boolean z10 = t10 == f34110j;
        if (t10 != null && !z10) {
            m(d10 + 1);
            n(atomicReferenceArray, c10, null);
            return t10;
        } else if (z10) {
            return k(h(atomicReferenceArray), d10, i10);
        } else {
            return null;
        }
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public int size() {
        long f10 = f();
        while (true) {
            long i10 = i();
            long f11 = f();
            if (f10 == f11) {
                return (int) (i10 - f11);
            }
            f10 = f11;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }
}
