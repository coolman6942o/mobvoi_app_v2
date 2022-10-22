package rx.internal.util;

import rx.internal.util.unsafe.i;
/* compiled from: OpenHashSet.java */
/* loaded from: classes3.dex */
public final class d<T> {

    /* renamed from: a  reason: collision with root package name */
    final float f34123a;

    /* renamed from: b  reason: collision with root package name */
    int f34124b;

    /* renamed from: c  reason: collision with root package name */
    int f34125c;

    /* renamed from: d  reason: collision with root package name */
    int f34126d;

    /* renamed from: e  reason: collision with root package name */
    T[] f34127e;

    public d() {
        this(16, 0.75f);
    }

    static int c(int i10) {
        int i11 = i10 * (-1640531527);
        return i11 ^ (i11 >>> 16);
    }

    public boolean a(T t10) {
        T t11;
        T[] tArr = this.f34127e;
        int i10 = this.f34124b;
        int c10 = c(t10.hashCode()) & i10;
        T t12 = tArr[c10];
        if (t12 != null) {
            if (t12.equals(t10)) {
                return false;
            }
            do {
                c10 = (c10 + 1) & i10;
                t11 = tArr[c10];
                if (t11 == null) {
                }
            } while (!t11.equals(t10));
            return false;
        }
        tArr[c10] = t10;
        int i11 = this.f34125c + 1;
        this.f34125c = i11;
        if (i11 >= this.f34126d) {
            d();
        }
        return true;
    }

    public boolean b() {
        return this.f34125c == 0;
    }

    void d() {
        T[] tArr = this.f34127e;
        int length = tArr.length;
        int i10 = length << 1;
        int i11 = i10 - 1;
        T[] tArr2 = (T[]) new Object[i10];
        int i12 = this.f34125c;
        while (true) {
            i12--;
            if (i12 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int c10 = c(tArr[length].hashCode()) & i11;
                if (tArr2[c10] != null) {
                    do {
                        c10 = (c10 + 1) & i11;
                    } while (tArr2[c10] != null);
                }
                tArr2[c10] = tArr[length];
            } else {
                this.f34124b = i11;
                this.f34126d = (int) (i10 * this.f34123a);
                this.f34127e = tArr2;
                return;
            }
        }
    }

    public boolean e(T t10) {
        T t11;
        T[] tArr = this.f34127e;
        int i10 = this.f34124b;
        int c10 = c(t10.hashCode()) & i10;
        T t12 = tArr[c10];
        if (t12 == null) {
            return false;
        }
        if (t12.equals(t10)) {
            return f(c10, tArr, i10);
        }
        do {
            c10 = (c10 + 1) & i10;
            t11 = tArr[c10];
            if (t11 == null) {
                return false;
            }
        } while (!t11.equals(t10));
        return f(c10, tArr, i10);
    }

    boolean f(int i10, T[] tArr, int i11) {
        int i12;
        T t10;
        this.f34125c--;
        while (true) {
            int i13 = i10 + 1;
            while (true) {
                i12 = i13 & i11;
                t10 = tArr[i12];
                if (t10 == null) {
                    tArr[i10] = null;
                    return true;
                }
                int c10 = c(t10.hashCode()) & i11;
                if (i10 > i12) {
                    if (i10 >= c10 && c10 > i12) {
                        break;
                    }
                    i13 = i12 + 1;
                } else if (i10 < c10 && c10 <= i12) {
                    i13 = i12 + 1;
                }
            }
            tArr[i10] = t10;
            i10 = i12;
        }
    }

    public void g() {
        this.f34125c = 0;
        this.f34127e = (T[]) new Object[0];
    }

    public T[] h() {
        return this.f34127e;
    }

    public d(int i10, float f10) {
        this.f34123a = f10;
        int b10 = i.b(i10);
        this.f34124b = b10 - 1;
        this.f34126d = (int) (f10 * b10);
        this.f34127e = (T[]) new Object[b10];
    }
}
