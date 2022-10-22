package rx.internal.util.unsafe;

import java.util.Iterator;
import java.util.Objects;
import sun.misc.Unsafe;
/* compiled from: SpscUnboundedArrayQueue.java */
/* loaded from: classes3.dex */
public class z<E> extends b0<E> {

    /* renamed from: h  reason: collision with root package name */
    private static final long f34178h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f34179i;

    /* renamed from: j  reason: collision with root package name */
    private static final long f34180j;

    /* renamed from: k  reason: collision with root package name */
    private static final int f34181k;

    /* renamed from: g  reason: collision with root package name */
    static final int f34177g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: l  reason: collision with root package name */
    private static final Object f34182l = new Object();

    static {
        Unsafe unsafe = f0.f34169a;
        int arrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            f34181k = 2;
        } else if (8 == arrayIndexScale) {
            f34181k = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f34180j = unsafe.arrayBaseOffset(Object[].class);
        try {
            f34178h = unsafe.objectFieldOffset(e0.class.getDeclaredField("producerIndex"));
            try {
                f34179i = unsafe.objectFieldOffset(b0.class.getDeclaredField("consumerIndex"));
            } catch (NoSuchFieldException e10) {
                InternalError internalError = new InternalError();
                internalError.initCause(e10);
                throw internalError;
            }
        } catch (NoSuchFieldException e11) {
            InternalError internalError2 = new InternalError();
            internalError2.initCause(e11);
            throw internalError2;
        }
    }

    public z(int i10) {
        int b10 = i.b(i10);
        long j10 = b10 - 1;
        E[] eArr = (E[]) new Object[b10 + 1];
        this.f34162d = eArr;
        this.f34161c = j10;
        a(b10);
        this.f34157f = eArr;
        this.f34156e = j10;
        this.f34160b = j10 - 1;
        n(0L);
    }

    private void a(int i10) {
        this.f34159a = Math.min(i10 / 4, f34177g);
    }

    private static long b(long j10) {
        return f34180j + (j10 << f34181k);
    }

    private static long c(long j10, long j11) {
        return b(j10 & j11);
    }

    private long d() {
        return f0.f34169a.getLongVolatile(this, f34179i);
    }

    private static <E> Object e(E[] eArr, long j10) {
        return f0.f34169a.getObjectVolatile(eArr, j10);
    }

    private E[] f(E[] eArr) {
        return (E[]) ((Object[]) e(eArr, b(eArr.length - 1)));
    }

    private long g() {
        return f0.f34169a.getLongVolatile(this, f34178h);
    }

    private E h(E[] eArr, long j10, long j11) {
        this.f34157f = eArr;
        return (E) e(eArr, c(j10, j11));
    }

    private E i(E[] eArr, long j10, long j11) {
        this.f34157f = eArr;
        long c10 = c(j10, j11);
        E e10 = (E) e(eArr, c10);
        if (e10 == null) {
            return null;
        }
        l(eArr, c10, null);
        k(j10 + 1);
        return e10;
    }

    private void j(E[] eArr, long j10, long j11, E e10, long j12) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.f34162d = eArr2;
        this.f34160b = (j12 + j10) - 1;
        l(eArr2, j11, e10);
        m(eArr, eArr2);
        l(eArr, j11, f34182l);
        n(j10 + 1);
    }

    private void k(long j10) {
        f0.f34169a.putOrderedLong(this, f34179i, j10);
    }

    private static void l(Object[] objArr, long j10, Object obj) {
        f0.f34169a.putOrderedObject(objArr, j10, obj);
    }

    private void m(E[] eArr, E[] eArr2) {
        l(eArr, b(eArr.length - 1), eArr2);
    }

    private void n(long j10) {
        f0.f34169a.putOrderedLong(this, f34178h, j10);
    }

    private boolean o(E[] eArr, E e10, long j10, long j11) {
        l(eArr, j11, e10);
        n(j10 + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public final boolean offer(E e10) {
        Objects.requireNonNull(e10, "Null is not a valid element");
        E[] eArr = this.f34162d;
        long j10 = this.producerIndex;
        long j11 = this.f34161c;
        long c10 = c(j10, j11);
        if (j10 < this.f34160b) {
            return o(eArr, e10, j10, c10);
        }
        long j12 = this.f34159a + j10;
        if (e(eArr, c(j12, j11)) == null) {
            this.f34160b = j12 - 1;
            return o(eArr, e10, j10, c10);
        } else if (e(eArr, c(1 + j10, j11)) != null) {
            return o(eArr, e10, j10, c10);
        } else {
            j(eArr, j10, c10, e10, j11);
            return true;
        }
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.f34157f;
        long j10 = this.consumerIndex;
        long j11 = this.f34156e;
        E e10 = (E) e(eArr, c(j10, j11));
        return e10 == f34182l ? h(f(eArr), j10, j11) : e10;
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.f34157f;
        long j10 = this.consumerIndex;
        long j11 = this.f34156e;
        long c10 = c(j10, j11);
        E e10 = (E) e(eArr, c10);
        boolean z10 = e10 == f34182l;
        if (e10 != null && !z10) {
            l(eArr, c10, null);
            k(j10 + 1);
            return e10;
        } else if (z10) {
            return i(f(eArr), j10, j11);
        } else {
            return null;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long d10 = d();
        while (true) {
            long g10 = g();
            long d11 = d();
            if (d10 == d11) {
                return (int) (g10 - d11);
            }
            d10 = d11;
        }
    }
}
