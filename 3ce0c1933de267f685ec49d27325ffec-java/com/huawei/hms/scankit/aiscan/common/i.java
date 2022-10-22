package com.huawei.hms.scankit.aiscan.common;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GenericGFPoly.java */
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final h f14235a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f14236b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, int[] iArr) {
        if (iArr.length != 0) {
            this.f14235a = hVar;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f14236b = iArr;
                return;
            }
            int i10 = 1;
            while (i10 < length && iArr[i10] == 0) {
                i10++;
            }
            if (i10 == length) {
                this.f14236b = new int[]{0};
                return;
            }
            int[] iArr2 = new int[length - i10];
            this.f14236b = iArr2;
            System.arraycopy(iArr, i10, iArr2, 0, iArr2.length);
            return;
        }
        try {
            throw new IllegalArgumentException();
        } catch (Exception e10) {
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a() {
        return this.f14236b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f14236b.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f14236b[0] == 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(b() * 8);
        for (int b10 = b(); b10 >= 0; b10--) {
            int b11 = b(b10);
            if (b11 != 0) {
                if (b11 < 0) {
                    sb2.append(" - ");
                    b11 = -b11;
                } else if (sb2.length() > 0) {
                    sb2.append(" + ");
                }
                if (b10 == 0 || b11 != 1) {
                    int c10 = this.f14235a.c(b11);
                    if (c10 == 0) {
                        sb2.append('1');
                    } else if (c10 == 1) {
                        sb2.append('a');
                    } else {
                        sb2.append("a^");
                        sb2.append(c10);
                    }
                }
                if (b10 != 0) {
                    if (b10 == 1) {
                        sb2.append('x');
                    } else {
                        sb2.append("x^");
                        sb2.append(b10);
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
            for (int i12 : this.f14236b) {
                i11 = h.a(i11, i12);
            }
            return i11;
        }
        int[] iArr = this.f14236b;
        int i13 = iArr[0];
        int length = iArr.length;
        for (int i14 = 1; i14 < length; i14++) {
            i13 = h.a(this.f14235a.c(i10, i13), this.f14236b[i14]);
        }
        return i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i10) {
        int[] iArr = this.f14236b;
        return iArr[(iArr.length - 1) - i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i c(i iVar) {
        if (!this.f14235a.equals(iVar.f14235a)) {
            try {
                throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            } catch (Exception e10) {
                throw e10;
            }
        } else if (c() || iVar.c()) {
            return this.f14235a.d();
        } else {
            int[] iArr = this.f14236b;
            int length = iArr.length;
            int[] iArr2 = iVar.f14236b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[(length + length2) - 1];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = iArr[i10];
                for (int i12 = 0; i12 < length2; i12++) {
                    int i13 = i10 + i12;
                    iArr3[i13] = h.a(iArr3[i13], this.f14235a.c(i11, iArr2[i12]));
                }
            }
            return new i(this.f14235a, iArr3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i[] b(i iVar) {
        if (!this.f14235a.equals(iVar.f14235a)) {
            try {
                throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            } catch (Exception e10) {
                throw e10;
            }
        } else if (!iVar.c()) {
            i d10 = this.f14235a.d();
            int b10 = this.f14235a.b(iVar.b(iVar.b()));
            i iVar2 = this;
            while (iVar2.b() >= iVar.b() && !iVar2.c()) {
                int b11 = iVar2.b() - iVar.b();
                int c10 = this.f14235a.c(iVar2.b(iVar2.b()), b10);
                i a10 = iVar.a(b11, c10);
                d10 = d10.a(this.f14235a.b(b11, c10));
                iVar2 = iVar2.a(a10);
            }
            return new i[]{d10, iVar2};
        } else {
            try {
                throw new IllegalArgumentException("Divide by 0");
            } catch (Exception e11) {
                throw e11;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i a(i iVar) {
        if (!this.f14235a.equals(iVar.f14235a)) {
            try {
                throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            } catch (Exception e10) {
                throw e10;
            }
        } else if (c()) {
            return iVar;
        } else {
            if (iVar.c()) {
                return this;
            }
            int[] iArr = this.f14236b;
            int[] iArr2 = iVar.f14236b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i10 = length; i10 < iArr.length; i10++) {
                iArr3[i10] = h.a(iArr2[i10 - length], iArr[i10]);
            }
            return new i(this.f14235a, iArr3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i c(int i10) {
        if (i10 == 0) {
            return this.f14235a.d();
        }
        if (i10 == 1) {
            return this;
        }
        int length = this.f14236b.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = this.f14235a.c(this.f14236b[i11], i10);
        }
        return new i(this.f14235a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i a(int i10, int i11) {
        if (i10 < 0) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e10) {
                throw e10;
            }
        } else if (i11 == 0) {
            return this.f14235a.d();
        } else {
            int length = this.f14236b.length;
            int[] iArr = new int[i10 + length];
            for (int i12 = 0; i12 < length; i12++) {
                iArr[i12] = this.f14235a.c(this.f14236b[i12], i11);
            }
            return new i(this.f14235a, iArr);
        }
    }
}
