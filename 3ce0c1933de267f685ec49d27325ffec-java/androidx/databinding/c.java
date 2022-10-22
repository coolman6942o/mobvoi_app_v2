package androidx.databinding;

import java.util.ArrayList;
import java.util.List;
/* compiled from: CallbackRegistry.java */
/* loaded from: classes.dex */
public class c<C, T, A> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private List<C> f2725a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private long f2726b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long[] f2727c;

    /* renamed from: d  reason: collision with root package name */
    private int f2728d;

    /* renamed from: e  reason: collision with root package name */
    private final a<C, T, A> f2729e;

    /* compiled from: CallbackRegistry.java */
    /* loaded from: classes.dex */
    public static abstract class a<C, T, A> {
        public abstract void a(C c10, T t10, int i10, A a10);
    }

    public c(a<C, T, A> aVar) {
        this.f2729e = aVar;
    }

    private boolean c(int i10) {
        int i11;
        if (i10 < 64) {
            return ((1 << i10) & this.f2726b) != 0;
        }
        long[] jArr = this.f2727c;
        if (jArr != null && (i11 = (i10 / 64) - 1) < jArr.length) {
            return ((1 << (i10 % 64)) & jArr[i11]) != 0;
        }
        return false;
    }

    private void e(T t10, int i10, A a10, int i11, int i12, long j10) {
        long j11 = 1;
        while (i11 < i12) {
            if ((j10 & j11) == 0) {
                this.f2729e.a(this.f2725a.get(i11), t10, i10, a10);
            }
            j11 <<= 1;
            i11++;
        }
    }

    private void f(T t10, int i10, A a10) {
        e(t10, i10, a10, 0, Math.min(64, this.f2725a.size()), this.f2726b);
    }

    private void g(T t10, int i10, A a10) {
        int size = this.f2725a.size();
        long[] jArr = this.f2727c;
        int length = jArr == null ? -1 : jArr.length - 1;
        i(t10, i10, a10, length);
        e(t10, i10, a10, (length + 2) * 64, size, 0L);
    }

    private void i(T t10, int i10, A a10, int i11) {
        if (i11 < 0) {
            f(t10, i10, a10);
            return;
        }
        long j10 = this.f2727c[i11];
        int i12 = (i11 + 1) * 64;
        int min = Math.min(this.f2725a.size(), i12 + 64);
        i(t10, i10, a10, i11 - 1);
        e(t10, i10, a10, i12, min, j10);
    }

    private void k(int i10, long j10) {
        long j11 = Long.MIN_VALUE;
        for (int i11 = (i10 + 64) - 1; i11 >= i10; i11--) {
            if ((j10 & j11) != 0) {
                this.f2725a.remove(i11);
            }
            j11 >>>= 1;
        }
    }

    private void l(int i10) {
        if (i10 < 64) {
            this.f2726b = (1 << i10) | this.f2726b;
            return;
        }
        int i11 = (i10 / 64) - 1;
        long[] jArr = this.f2727c;
        if (jArr == null) {
            this.f2727c = new long[this.f2725a.size() / 64];
        } else if (jArr.length <= i11) {
            long[] jArr2 = new long[this.f2725a.size() / 64];
            long[] jArr3 = this.f2727c;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.f2727c = jArr2;
        }
        long j10 = 1 << (i10 % 64);
        long[] jArr4 = this.f2727c;
        jArr4[i11] = j10 | jArr4[i11];
    }

    public synchronized void a(C c10) {
        if (c10 != null) {
            int lastIndexOf = this.f2725a.lastIndexOf(c10);
            if (lastIndexOf < 0 || c(lastIndexOf)) {
                this.f2725a.add(c10);
            }
        } else {
            throw new IllegalArgumentException("callback cannot be null");
        }
    }

    /* renamed from: b */
    public synchronized c<C, T, A> clone() {
        c<C, T, A> cVar;
        CloneNotSupportedException e10;
        try {
            cVar = (c) super.clone();
            try {
                cVar.f2726b = 0L;
                cVar.f2727c = null;
                cVar.f2728d = 0;
                cVar.f2725a = new ArrayList();
                int size = this.f2725a.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (!c(i10)) {
                        cVar.f2725a.add(this.f2725a.get(i10));
                    }
                }
            } catch (CloneNotSupportedException e11) {
                e10 = e11;
                e10.printStackTrace();
                return cVar;
            }
        } catch (CloneNotSupportedException e12) {
            e10 = e12;
            cVar = null;
        }
        return cVar;
    }

    public synchronized void d(T t10, int i10, A a10) {
        this.f2728d++;
        g(t10, i10, a10);
        int i11 = this.f2728d - 1;
        this.f2728d = i11;
        if (i11 == 0) {
            long[] jArr = this.f2727c;
            if (jArr != null) {
                for (int length = jArr.length - 1; length >= 0; length--) {
                    long j10 = this.f2727c[length];
                    if (j10 != 0) {
                        k((length + 1) * 64, j10);
                        this.f2727c[length] = 0;
                    }
                }
            }
            long j11 = this.f2726b;
            if (j11 != 0) {
                k(0, j11);
                this.f2726b = 0L;
            }
        }
    }

    public synchronized void j(C c10) {
        if (this.f2728d == 0) {
            this.f2725a.remove(c10);
        } else {
            int lastIndexOf = this.f2725a.lastIndexOf(c10);
            if (lastIndexOf >= 0) {
                l(lastIndexOf);
            }
        }
    }
}
