package androidx.collection;
/* compiled from: LongSparseArray.java */
/* loaded from: classes.dex */
public class d<E> implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f1455e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private boolean f1456a;

    /* renamed from: b  reason: collision with root package name */
    private long[] f1457b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f1458c;

    /* renamed from: d  reason: collision with root package name */
    private int f1459d;

    public d() {
        this(10);
    }

    private void e() {
        int i10 = this.f1459d;
        long[] jArr = this.f1457b;
        Object[] objArr = this.f1458c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f1455e) {
                if (i12 != i11) {
                    jArr[i11] = jArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f1456a = false;
        this.f1459d = i11;
    }

    public void a(long j10, E e10) {
        int i10 = this.f1459d;
        if (i10 == 0 || j10 > this.f1457b[i10 - 1]) {
            if (this.f1456a && i10 >= this.f1457b.length) {
                e();
            }
            int i11 = this.f1459d;
            if (i11 >= this.f1457b.length) {
                int f10 = c.f(i11 + 1);
                long[] jArr = new long[f10];
                Object[] objArr = new Object[f10];
                long[] jArr2 = this.f1457b;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f1458c;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f1457b = jArr;
                this.f1458c = objArr;
            }
            this.f1457b[i11] = j10;
            this.f1458c[i11] = e10;
            this.f1459d = i11 + 1;
            return;
        }
        k(j10, e10);
    }

    public void b() {
        int i10 = this.f1459d;
        Object[] objArr = this.f1458c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f1459d = 0;
        this.f1456a = false;
    }

    /* renamed from: c */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f1457b = (long[]) this.f1457b.clone();
            dVar.f1458c = (Object[]) this.f1458c.clone();
            return dVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean d(long j10) {
        return i(j10) >= 0;
    }

    public E f(long j10) {
        return g(j10, null);
    }

    public E g(long j10, E e10) {
        int b10 = c.b(this.f1457b, this.f1459d, j10);
        if (b10 >= 0) {
            Object[] objArr = this.f1458c;
            if (objArr[b10] != f1455e) {
                return (E) objArr[b10];
            }
        }
        return e10;
    }

    public int i(long j10) {
        if (this.f1456a) {
            e();
        }
        return c.b(this.f1457b, this.f1459d, j10);
    }

    public long j(int i10) {
        if (this.f1456a) {
            e();
        }
        return this.f1457b[i10];
    }

    public void k(long j10, E e10) {
        int b10 = c.b(this.f1457b, this.f1459d, j10);
        if (b10 >= 0) {
            this.f1458c[b10] = e10;
            return;
        }
        int i10 = ~b10;
        int i11 = this.f1459d;
        if (i10 < i11) {
            Object[] objArr = this.f1458c;
            if (objArr[i10] == f1455e) {
                this.f1457b[i10] = j10;
                objArr[i10] = e10;
                return;
            }
        }
        if (this.f1456a && i11 >= this.f1457b.length) {
            e();
            i10 = ~c.b(this.f1457b, this.f1459d, j10);
        }
        int i12 = this.f1459d;
        if (i12 >= this.f1457b.length) {
            int f10 = c.f(i12 + 1);
            long[] jArr = new long[f10];
            Object[] objArr2 = new Object[f10];
            long[] jArr2 = this.f1457b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1458c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1457b = jArr;
            this.f1458c = objArr2;
        }
        int i13 = this.f1459d;
        if (i13 - i10 != 0) {
            long[] jArr3 = this.f1457b;
            int i14 = i10 + 1;
            System.arraycopy(jArr3, i10, jArr3, i14, i13 - i10);
            Object[] objArr4 = this.f1458c;
            System.arraycopy(objArr4, i10, objArr4, i14, this.f1459d - i10);
        }
        this.f1457b[i10] = j10;
        this.f1458c[i10] = e10;
        this.f1459d++;
    }

    public void l(long j10) {
        int b10 = c.b(this.f1457b, this.f1459d, j10);
        if (b10 >= 0) {
            Object[] objArr = this.f1458c;
            Object obj = objArr[b10];
            Object obj2 = f1455e;
            if (obj != obj2) {
                objArr[b10] = obj2;
                this.f1456a = true;
            }
        }
    }

    public void m(int i10) {
        Object[] objArr = this.f1458c;
        Object obj = objArr[i10];
        Object obj2 = f1455e;
        if (obj != obj2) {
            objArr[i10] = obj2;
            this.f1456a = true;
        }
    }

    public int n() {
        if (this.f1456a) {
            e();
        }
        return this.f1459d;
    }

    public E o(int i10) {
        if (this.f1456a) {
            e();
        }
        return (E) this.f1458c[i10];
    }

    public String toString() {
        if (n() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f1459d * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f1459d; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(j(i10));
            sb2.append('=');
            E o10 = o(i10);
            if (o10 != this) {
                sb2.append(o10);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public d(int i10) {
        this.f1456a = false;
        if (i10 == 0) {
            this.f1457b = c.f1453b;
            this.f1458c = c.f1454c;
            return;
        }
        int f10 = c.f(i10);
        this.f1457b = new long[f10];
        this.f1458c = new Object[f10];
    }
}
