package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.n0;
/* compiled from: ThreadSafeHeap.kt */
/* loaded from: classes3.dex */
public class b0<T extends c0 & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;

    /* renamed from: a  reason: collision with root package name */
    private T[] f30203a;

    private final T[] f() {
        T[] tArr = this.f30203a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new c0[4];
            this.f30203a = tArr2;
            return tArr2;
        } else if (c() < tArr.length) {
            return tArr;
        } else {
            Object[] copyOf = Arrays.copyOf(tArr, c() * 2);
            i.e(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            T[] tArr3 = (T[]) ((c0[]) copyOf);
            this.f30203a = tArr3;
            return tArr3;
        }
    }

    private final void j(int i10) {
        this._size = i10;
    }

    private final void k(int i10) {
        while (true) {
            int i11 = (i10 * 2) + 1;
            if (i11 < c()) {
                T[] tArr = this.f30203a;
                i.d(tArr);
                int i12 = i11 + 1;
                if (i12 < c()) {
                    T t10 = tArr[i12];
                    i.d(t10);
                    T t11 = tArr[i11];
                    i.d(t11);
                    if (((Comparable) t10).compareTo(t11) < 0) {
                        i11 = i12;
                    }
                }
                T t12 = tArr[i10];
                i.d(t12);
                T t13 = tArr[i11];
                i.d(t13);
                if (((Comparable) t12).compareTo(t13) > 0) {
                    m(i10, i11);
                    i10 = i11;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final void l(int i10) {
        while (i10 > 0) {
            T[] tArr = this.f30203a;
            i.d(tArr);
            int i11 = (i10 - 1) / 2;
            T t10 = tArr[i11];
            i.d(t10);
            T t11 = tArr[i10];
            i.d(t11);
            if (((Comparable) t10).compareTo(t11) > 0) {
                m(i10, i11);
                i10 = i11;
            } else {
                return;
            }
        }
    }

    private final void m(int i10, int i11) {
        T[] tArr = this.f30203a;
        i.d(tArr);
        T t10 = tArr[i11];
        i.d(t10);
        T t11 = tArr[i10];
        i.d(t11);
        tArr[i10] = t10;
        tArr[i11] = t11;
        t10.d(i10);
        t11.d(i11);
    }

    public final void a(T t10) {
        if (n0.a()) {
            if (!(t10.c() == null)) {
                throw new AssertionError();
            }
        }
        t10.a(this);
        T[] f10 = f();
        int c10 = c();
        j(c10 + 1);
        f10[c10] = t10;
        t10.d(c10);
        l(c10);
    }

    public final T b() {
        T[] tArr = this.f30203a;
        if (tArr == null) {
            return null;
        }
        return tArr[0];
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        return c() == 0;
    }

    public final T e() {
        T b10;
        synchronized (this) {
            b10 = b();
        }
        return b10;
    }

    public final boolean g(T t10) {
        boolean z10;
        synchronized (this) {
            z10 = true;
            boolean z11 = false;
            if (t10.c() == null) {
                z10 = false;
            } else {
                int e10 = t10.e();
                if (n0.a()) {
                    if (e10 >= 0) {
                        z11 = true;
                    }
                    if (!z11) {
                        throw new AssertionError();
                    }
                }
                h(e10);
            }
        }
        return z10;
    }

    public final T h(int i10) {
        boolean z10 = false;
        if (n0.a()) {
            if (!(c() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.f30203a;
        i.d(tArr);
        j(c() - 1);
        if (i10 < c()) {
            m(i10, c());
            int i11 = (i10 - 1) / 2;
            if (i10 > 0) {
                T t10 = tArr[i10];
                i.d(t10);
                T t11 = tArr[i11];
                i.d(t11);
                if (((Comparable) t10).compareTo(t11) < 0) {
                    m(i10, i11);
                    l(i11);
                }
            }
            k(i10);
        }
        T t12 = tArr[c()];
        i.d(t12);
        if (n0.a()) {
            if (t12.c() == this) {
                z10 = true;
            }
            if (!z10) {
                throw new AssertionError();
            }
        }
        t12.a(null);
        t12.d(-1);
        tArr[c()] = null;
        return t12;
    }

    public final T i() {
        T h10;
        synchronized (this) {
            h10 = c() > 0 ? h(0) : null;
        }
        return h10;
    }
}
