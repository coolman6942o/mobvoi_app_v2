package rx.internal.util.unsafe;

import java.util.Iterator;
import sun.misc.Unsafe;
/* compiled from: ConcurrentCircularArrayQueue.java */
/* loaded from: classes3.dex */
public abstract class f<E> extends g<E> {

    /* renamed from: c  reason: collision with root package name */
    protected static final int f34164c;

    /* renamed from: d  reason: collision with root package name */
    private static final long f34165d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f34166e;

    /* renamed from: a  reason: collision with root package name */
    protected final long f34167a;

    /* renamed from: b  reason: collision with root package name */
    protected final E[] f34168b;

    static {
        int intValue = Integer.getInteger("sparse.shift", 0).intValue();
        f34164c = intValue;
        Unsafe unsafe = f0.f34169a;
        int arrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            f34166e = intValue + 2;
        } else if (8 == arrayIndexScale) {
            f34166e = intValue + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f34165d = unsafe.arrayBaseOffset(Object[].class) + (32 << (f34166e - intValue));
    }

    public f(int i10) {
        int b10 = i.b(i10);
        this.f34167a = b10 - 1;
        this.f34168b = (E[]) new Object[(b10 << f34164c) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long a(long j10) {
        return b(j10, this.f34167a);
    }

    protected final long b(long j10, long j11) {
        return f34165d + ((j10 & j11) << f34166e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E c(E[] eArr, long j10) {
        return (E) f0.f34169a.getObject(eArr, j10);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E d(long j10) {
        return e(this.f34168b, j10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E e(E[] eArr, long j10) {
        return (E) f0.f34169a.getObjectVolatile(eArr, j10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f(E[] eArr, long j10, E e10) {
        f0.f34169a.putOrderedObject(eArr, j10, e10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(E[] eArr, long j10, E e10) {
        f0.f34169a.putObject(eArr, j10, e10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
