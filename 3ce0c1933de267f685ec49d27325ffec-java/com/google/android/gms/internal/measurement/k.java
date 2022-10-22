package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
public final class k implements Cloneable {

    /* renamed from: d  reason: collision with root package name */
    private static final l f9419d = new l();

    /* renamed from: a  reason: collision with root package name */
    private int[] f9420a;

    /* renamed from: b  reason: collision with root package name */
    private l[] f9421b;

    /* renamed from: c  reason: collision with root package name */
    private int f9422c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k() {
        this(10);
    }

    private k(int i10) {
        int a10 = a(i10);
        this.f9420a = new int[a10];
        this.f9421b = new l[a10];
        this.f9422c = 0;
    }

    private static int a(int i10) {
        int i11 = i10 << 2;
        int i12 = 4;
        while (true) {
            if (i12 >= 32) {
                break;
            }
            int i13 = (1 << i12) - 12;
            if (i11 <= i13) {
                i11 = i13;
                break;
            }
            i12++;
        }
        return i11 / 4;
    }

    private final int g(int i10) {
        int i11 = this.f9422c - 1;
        int i12 = 0;
        while (i12 <= i11) {
            int i13 = (i12 + i11) >>> 1;
            int i14 = this.f9420a[i13];
            if (i14 < i10) {
                i12 = i13 + 1;
            } else if (i14 <= i10) {
                return i13;
            } else {
                i11 = i13 - 1;
            }
        }
        return ~i12;
    }

    public final boolean b() {
        return this.f9422c == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int c() {
        return this.f9422c;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i10 = this.f9422c;
        k kVar = new k(i10);
        System.arraycopy(this.f9420a, 0, kVar.f9420a, 0, i10);
        for (int i11 = 0; i11 < i10; i11++) {
            l[] lVarArr = this.f9421b;
            if (lVarArr[i11] != null) {
                kVar.f9421b[i11] = (l) lVarArr[i11].clone();
            }
        }
        kVar.f9422c = i10;
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(int i10, l lVar) {
        int g10 = g(i10);
        if (g10 >= 0) {
            this.f9421b[g10] = lVar;
            return;
        }
        int i11 = ~g10;
        int i12 = this.f9422c;
        if (i11 < i12) {
            l[] lVarArr = this.f9421b;
            if (lVarArr[i11] == f9419d) {
                this.f9420a[i11] = i10;
                lVarArr[i11] = lVar;
                return;
            }
        }
        if (i12 >= this.f9420a.length) {
            int a10 = a(i12 + 1);
            int[] iArr = new int[a10];
            l[] lVarArr2 = new l[a10];
            int[] iArr2 = this.f9420a;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            l[] lVarArr3 = this.f9421b;
            System.arraycopy(lVarArr3, 0, lVarArr2, 0, lVarArr3.length);
            this.f9420a = iArr;
            this.f9421b = lVarArr2;
        }
        int i13 = this.f9422c;
        if (i13 - i11 != 0) {
            int[] iArr3 = this.f9420a;
            int i14 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i14, i13 - i11);
            l[] lVarArr4 = this.f9421b;
            System.arraycopy(lVarArr4, i11, lVarArr4, i14, this.f9422c - i11);
        }
        this.f9420a[i11] = i10;
        this.f9421b[i11] = lVar;
        this.f9422c++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final l e(int i10) {
        int g10 = g(i10);
        if (g10 < 0) {
            return null;
        }
        l[] lVarArr = this.f9421b;
        if (lVarArr[g10] == f9419d) {
            return null;
        }
        return lVarArr[g10];
    }

    public final boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        int i10 = this.f9422c;
        if (i10 != kVar.f9422c) {
            return false;
        }
        int[] iArr = this.f9420a;
        int[] iArr2 = kVar.f9420a;
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                z10 = true;
                break;
            } else if (iArr[i11] != iArr2[i11]) {
                z10 = false;
                break;
            } else {
                i11++;
            }
        }
        if (z10) {
            l[] lVarArr = this.f9421b;
            l[] lVarArr2 = kVar.f9421b;
            int i12 = this.f9422c;
            int i13 = 0;
            while (true) {
                if (i13 >= i12) {
                    z11 = true;
                    break;
                } else if (!lVarArr[i13].equals(lVarArr2[i13])) {
                    z11 = false;
                    break;
                } else {
                    i13++;
                }
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final l f(int i10) {
        return this.f9421b[i10];
    }

    public final int hashCode() {
        int i10 = 17;
        for (int i11 = 0; i11 < this.f9422c; i11++) {
            i10 = (((i10 * 31) + this.f9420a[i11]) * 31) + this.f9421b[i11].hashCode();
        }
        return i10;
    }
}
