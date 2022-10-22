package com.google.zxing.common;

import java.util.Arrays;
/* compiled from: BitMatrix.java */
/* loaded from: classes.dex */
public final class b implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private final int f13408a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13409b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13410c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f13411d;

    public b(int i10) {
        this(i10, i10);
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(this.f13409b * (this.f13408a + 1));
        for (int i10 = 0; i10 < this.f13409b; i10++) {
            for (int i11 = 0; i11 < this.f13408a; i11++) {
                sb2.append(d(i11, i10) ? str : str2);
            }
            sb2.append(str3);
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public b clone() {
        return new b(this.f13408a, this.f13409b, this.f13410c, (int[]) this.f13411d.clone());
    }

    public void c(int i10, int i11) {
        int i12 = (i11 * this.f13410c) + (i10 / 32);
        int[] iArr = this.f13411d;
        iArr[i12] = (1 << (i10 & 31)) ^ iArr[i12];
    }

    public boolean d(int i10, int i11) {
        return ((this.f13411d[(i11 * this.f13410c) + (i10 / 32)] >>> (i10 & 31)) & 1) != 0;
    }

    public int[] e() {
        int length = this.f13411d.length - 1;
        while (length >= 0 && this.f13411d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i10 = this.f13410c;
        int i11 = length / i10;
        int i12 = (length % i10) << 5;
        int i13 = 31;
        while ((this.f13411d[length] >>> i13) == 0) {
            i13--;
        }
        return new int[]{i12 + i13, i11};
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f13408a == bVar.f13408a && this.f13409b == bVar.f13409b && this.f13410c == bVar.f13410c && Arrays.equals(this.f13411d, bVar.f13411d);
    }

    public int[] f() {
        int i10 = this.f13408a;
        int i11 = this.f13409b;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < this.f13409b; i14++) {
            int i15 = 0;
            while (true) {
                int i16 = this.f13410c;
                if (i15 < i16) {
                    int i17 = this.f13411d[(i16 * i14) + i15];
                    if (i17 != 0) {
                        if (i14 < i11) {
                            i11 = i14;
                        }
                        if (i14 > i13) {
                            i13 = i14;
                        }
                        int i18 = i15 << 5;
                        if (i18 < i10) {
                            int i19 = 0;
                            while ((i17 << (31 - i19)) == 0) {
                                i19++;
                            }
                            int i20 = i19 + i18;
                            if (i20 < i10) {
                                i10 = i20;
                            }
                        }
                        if (i18 + 31 > i12) {
                            int i21 = 31;
                            while ((i17 >>> i21) == 0) {
                                i21--;
                            }
                            int i22 = i18 + i21;
                            if (i22 > i12) {
                                i12 = i22;
                            }
                        }
                    }
                    i15++;
                }
            }
        }
        if (i12 < i10 || i13 < i11) {
            return null;
        }
        return new int[]{i10, i11, (i12 - i10) + 1, (i13 - i11) + 1};
    }

    public int g() {
        return this.f13409b;
    }

    public int hashCode() {
        int i10 = this.f13408a;
        return (((((((i10 * 31) + i10) * 31) + this.f13409b) * 31) + this.f13410c) * 31) + Arrays.hashCode(this.f13411d);
    }

    public a i(int i10, a aVar) {
        if (aVar == null || aVar.g() < this.f13408a) {
            aVar = new a(this.f13408a);
        } else {
            aVar.a();
        }
        int i11 = i10 * this.f13410c;
        for (int i12 = 0; i12 < this.f13410c; i12++) {
            aVar.m(i12 << 5, this.f13411d[i11 + i12]);
        }
        return aVar;
    }

    public int[] j() {
        int[] iArr;
        int i10 = 0;
        while (true) {
            iArr = this.f13411d;
            if (i10 >= iArr.length || iArr[i10] != 0) {
                break;
            }
            i10++;
        }
        if (i10 == iArr.length) {
            return null;
        }
        int i11 = this.f13410c;
        int i12 = i10 / i11;
        int i13 = (i10 % i11) << 5;
        int i14 = iArr[i10];
        int i15 = 0;
        while ((i14 << (31 - i15)) == 0) {
            i15++;
        }
        return new int[]{i13 + i15, i12};
    }

    public int k() {
        return this.f13408a;
    }

    public void l() {
        int k10 = k();
        int g10 = g();
        a aVar = new a(k10);
        a aVar2 = new a(k10);
        for (int i10 = 0; i10 < (g10 + 1) / 2; i10++) {
            aVar = i(i10, aVar);
            int i11 = (g10 - 1) - i10;
            aVar2 = i(i11, aVar2);
            aVar.k();
            aVar2.k();
            o(i10, aVar2);
            o(i11, aVar);
        }
    }

    public void m(int i10, int i11) {
        int i12 = (i11 * this.f13410c) + (i10 / 32);
        int[] iArr = this.f13411d;
        iArr[i12] = (1 << (i10 & 31)) | iArr[i12];
    }

    public void n(int i10, int i11, int i12, int i13) {
        if (i11 < 0 || i10 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i13 <= 0 || i12 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i14 = i12 + i10;
            int i15 = i13 + i11;
            if (i15 > this.f13409b || i14 > this.f13408a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i11 < i15) {
                int i16 = this.f13410c * i11;
                for (int i17 = i10; i17 < i14; i17++) {
                    int[] iArr = this.f13411d;
                    int i18 = (i17 / 32) + i16;
                    iArr[i18] = iArr[i18] | (1 << (i17 & 31));
                }
                i11++;
            }
        }
    }

    public void o(int i10, a aVar) {
        int[] d10 = aVar.d();
        int[] iArr = this.f13411d;
        int i11 = this.f13410c;
        System.arraycopy(d10, 0, iArr, i10 * i11, i11);
    }

    public String p(String str, String str2) {
        return a(str, str2, "\n");
    }

    public String toString() {
        return p("X ", "  ");
    }

    public b(int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f13408a = i10;
        this.f13409b = i11;
        int i12 = (i10 + 31) / 32;
        this.f13410c = i12;
        this.f13411d = new int[i12 * i11];
    }

    private b(int i10, int i11, int i12, int[] iArr) {
        this.f13408a = i10;
        this.f13409b = i11;
        this.f13410c = i12;
        this.f13411d = iArr;
    }
}
