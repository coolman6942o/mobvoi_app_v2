package com.huawei.hms.scankit.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModulusPoly.java */
/* renamed from: com.huawei.hms.scankit.p.ba  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0568ba {

    /* renamed from: a  reason: collision with root package name */
    private final C0564aa f14741a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f14742b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0568ba(C0564aa aaVar, int[] iArr) {
        if (iArr.length != 0) {
            this.f14741a = aaVar;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f14742b = iArr;
                return;
            }
            int i10 = 1;
            while (i10 < length && iArr[i10] == 0) {
                i10++;
            }
            if (i10 == length) {
                this.f14742b = new int[]{0};
                return;
            }
            int[] iArr2 = new int[length - i10];
            this.f14742b = iArr2;
            System.arraycopy(iArr, i10, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f14742b.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f14742b[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0568ba c(C0568ba baVar) {
        if (this.f14741a.equals(baVar.f14741a)) {
            return baVar.b() ? this : a(baVar.c());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(a() * 8);
        for (int a10 = a(); a10 >= 0; a10--) {
            int b10 = b(a10);
            if (b10 != 0) {
                if (b10 < 0) {
                    sb2.append(" - ");
                    b10 = -b10;
                } else if (sb2.length() > 0) {
                    sb2.append(" + ");
                }
                if (a10 == 0 || b10 != 1) {
                    sb2.append(b10);
                }
                if (a10 != 0) {
                    if (a10 == 1) {
                        sb2.append('x');
                    } else {
                        sb2.append("x^");
                        sb2.append(a10);
                    }
                }
            }
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i10) {
        if (i10 == 0) {
            return b(0);
        }
        if (i10 == 1) {
            int i11 = 0;
            for (int i12 : this.f14742b) {
                i11 = this.f14741a.a(i11, i12);
            }
            return i11;
        }
        int[] iArr = this.f14742b;
        int i13 = iArr[0];
        int length = iArr.length;
        for (int i14 = 1; i14 < length; i14++) {
            C0564aa aaVar = this.f14741a;
            i13 = aaVar.a(aaVar.c(i10, i13), this.f14742b[i14]);
        }
        return i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i10) {
        int[] iArr = this.f14742b;
        return iArr[(iArr.length - 1) - i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0568ba b(C0568ba baVar) {
        if (!this.f14741a.equals(baVar.f14741a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (b() || baVar.b()) {
            return this.f14741a.c();
        } else {
            int[] iArr = this.f14742b;
            int length = iArr.length;
            int[] iArr2 = baVar.f14742b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[(length + length2) - 1];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = iArr[i10];
                for (int i12 = 0; i12 < length2; i12++) {
                    int i13 = i10 + i12;
                    C0564aa aaVar = this.f14741a;
                    iArr3[i13] = aaVar.a(iArr3[i13], aaVar.c(i11, iArr2[i12]));
                }
            }
            return new C0568ba(this.f14741a, iArr3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0568ba c() {
        int length = this.f14742b.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = this.f14741a.d(0, this.f14742b[i10]);
        }
        return new C0568ba(this.f14741a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0568ba a(C0568ba baVar) {
        if (!this.f14741a.equals(baVar.f14741a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (b()) {
            return baVar;
        } else {
            if (baVar.b()) {
                return this;
            }
            int[] iArr = this.f14742b;
            int[] iArr2 = baVar.f14742b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i10 = length; i10 < iArr.length; i10++) {
                iArr3[i10] = this.f14741a.a(iArr2[i10 - length], iArr[i10]);
            }
            return new C0568ba(this.f14741a, iArr3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0568ba c(int i10) {
        if (i10 == 0) {
            return this.f14741a.c();
        }
        if (i10 == 1) {
            return this;
        }
        int length = this.f14742b.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = this.f14741a.c(this.f14742b[i11], i10);
        }
        return new C0568ba(this.f14741a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0568ba a(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        } else if (i11 == 0) {
            return this.f14741a.c();
        } else {
            int length = this.f14742b.length;
            int[] iArr = new int[i10 + length];
            for (int i12 = 0; i12 < length; i12++) {
                iArr[i12] = this.f14741a.c(this.f14742b[i12], i11);
            }
            return new C0568ba(this.f14741a, iArr);
        }
    }
}
