package io.reactivex.internal.queue;

import co.f;
import io.reactivex.internal.util.j;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: SpscLinkedArrayQueue.java */
/* loaded from: classes3.dex */
public final class b<T> implements f<T> {

    /* renamed from: i  reason: collision with root package name */
    static final int f29171i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j  reason: collision with root package name */
    private static final Object f29172j = new Object();

    /* renamed from: b  reason: collision with root package name */
    int f29174b;

    /* renamed from: c  reason: collision with root package name */
    long f29175c;

    /* renamed from: d  reason: collision with root package name */
    final int f29176d;

    /* renamed from: e  reason: collision with root package name */
    AtomicReferenceArray<Object> f29177e;

    /* renamed from: f  reason: collision with root package name */
    final int f29178f;

    /* renamed from: g  reason: collision with root package name */
    AtomicReferenceArray<Object> f29179g;

    /* renamed from: a  reason: collision with root package name */
    final AtomicLong f29173a = new AtomicLong();

    /* renamed from: h  reason: collision with root package name */
    final AtomicLong f29180h = new AtomicLong();

    public b(int i10) {
        int a10 = j.a(Math.max(8, i10));
        int i11 = a10 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a10 + 1);
        this.f29177e = atomicReferenceArray;
        this.f29176d = i11;
        a(a10);
        this.f29179g = atomicReferenceArray;
        this.f29178f = i11;
        this.f29175c = i11 - 1;
        s(0L);
    }

    private void a(int i10) {
        this.f29174b = Math.min(i10 / 4, f29171i);
    }

    private static int b(int i10) {
        return i10;
    }

    private static int c(long j10, int i10) {
        return b(((int) j10) & i10);
    }

    private long d() {
        return this.f29180h.get();
    }

    private long e() {
        return this.f29173a.get();
    }

    private long f() {
        return this.f29180h.get();
    }

    private static <E> Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i10) {
        return atomicReferenceArray.get(i10);
    }

    private AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray, int i10) {
        int b10 = b(i10);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, b10);
        q(atomicReferenceArray, b10, null);
        return atomicReferenceArray2;
    }

    private long i() {
        return this.f29173a.get();
    }

    private T j(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10) {
        this.f29179g = atomicReferenceArray;
        return (T) g(atomicReferenceArray, c(j10, i10));
    }

    private T k(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10) {
        this.f29179g = atomicReferenceArray;
        int c10 = c(j10, i10);
        T t10 = (T) g(atomicReferenceArray, c10);
        if (t10 != null) {
            q(atomicReferenceArray, c10, null);
            p(j10 + 1);
        }
        return t10;
    }

    private void n(AtomicReferenceArray<Object> atomicReferenceArray, long j10, int i10, T t10, long j11) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f29177e = atomicReferenceArray2;
        this.f29175c = (j11 + j10) - 1;
        q(atomicReferenceArray2, i10, t10);
        r(atomicReferenceArray, atomicReferenceArray2);
        q(atomicReferenceArray, i10, f29172j);
        s(j10 + 1);
    }

    private void p(long j10) {
        this.f29180h.lazySet(j10);
    }

    private static void q(AtomicReferenceArray<Object> atomicReferenceArray, int i10, Object obj) {
        atomicReferenceArray.lazySet(i10, obj);
    }

    private void r(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        q(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void s(long j10) {
        this.f29173a.lazySet(j10);
    }

    private boolean t(AtomicReferenceArray<Object> atomicReferenceArray, T t10, long j10, int i10) {
        q(atomicReferenceArray, i10, t10);
        s(j10 + 1);
        return true;
    }

    @Override // co.g
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // co.g
    public boolean isEmpty() {
        return i() == f();
    }

    public boolean l(T t10, T t11) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f29177e;
        long i10 = i();
        int i11 = this.f29176d;
        long j10 = 2 + i10;
        if (g(atomicReferenceArray, c(j10, i11)) == null) {
            int c10 = c(i10, i11);
            q(atomicReferenceArray, c10 + 1, t11);
            q(atomicReferenceArray, c10, t10);
            s(j10);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f29177e = atomicReferenceArray2;
        int c11 = c(i10, i11);
        q(atomicReferenceArray2, c11 + 1, t11);
        q(atomicReferenceArray2, c11, t10);
        r(atomicReferenceArray, atomicReferenceArray2);
        q(atomicReferenceArray, c11, f29172j);
        s(j10);
        return true;
    }

    public T m() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f29179g;
        long d10 = d();
        int i10 = this.f29178f;
        T t10 = (T) g(atomicReferenceArray, c(d10, i10));
        return t10 == f29172j ? j(h(atomicReferenceArray, i10 + 1), d10, i10) : t10;
    }

    public int o() {
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

    @Override // co.g
    public boolean offer(T t10) {
        Objects.requireNonNull(t10, "Null is not a valid element");
        AtomicReferenceArray<Object> atomicReferenceArray = this.f29177e;
        long e10 = e();
        int i10 = this.f29176d;
        int c10 = c(e10, i10);
        if (e10 < this.f29175c) {
            return t(atomicReferenceArray, t10, e10, c10);
        }
        long j10 = this.f29174b + e10;
        if (g(atomicReferenceArray, c(j10, i10)) == null) {
            this.f29175c = j10 - 1;
            return t(atomicReferenceArray, t10, e10, c10);
        } else if (g(atomicReferenceArray, c(1 + e10, i10)) == null) {
            return t(atomicReferenceArray, t10, e10, c10);
        } else {
            n(atomicReferenceArray, e10, c10, t10, i10);
            return true;
        }
    }

    @Override // co.f, co.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f29179g;
        long d10 = d();
        int i10 = this.f29178f;
        int c10 = c(d10, i10);
        T t10 = (T) g(atomicReferenceArray, c10);
        boolean z10 = t10 == f29172j;
        if (t10 != null && !z10) {
            q(atomicReferenceArray, c10, null);
            p(d10 + 1);
            return t10;
        } else if (z10) {
            return k(h(atomicReferenceArray, i10 + 1), d10, i10);
        } else {
            return null;
        }
    }
}
