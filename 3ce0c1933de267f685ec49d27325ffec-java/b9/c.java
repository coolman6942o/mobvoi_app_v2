package b9;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModulusPoly.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final b f5111a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f5112b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, int[] iArr) {
        if (iArr.length != 0) {
            this.f5111a = bVar;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f5112b = iArr;
                return;
            }
            int i10 = 1;
            while (i10 < length && iArr[i10] == 0) {
                i10++;
            }
            if (i10 == length) {
                this.f5112b = new int[]{0};
                return;
            }
            int[] iArr2 = new int[length - i10];
            this.f5112b = iArr2;
            System.arraycopy(iArr, i10, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(c cVar) {
        if (!this.f5111a.equals(cVar.f5111a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (e()) {
            return cVar;
        } else {
            if (cVar.e()) {
                return this;
            }
            int[] iArr = this.f5112b;
            int[] iArr2 = cVar.f5112b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i10 = length; i10 < iArr.length; i10++) {
                iArr3[i10] = this.f5111a.a(iArr2[i10 - length], iArr[i10]);
            }
            return new c(this.f5111a, iArr3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i10) {
        if (i10 == 0) {
            return c(0);
        }
        if (i10 == 1) {
            int i11 = 0;
            for (int i12 : this.f5112b) {
                i11 = this.f5111a.a(i11, i12);
            }
            return i11;
        }
        int[] iArr = this.f5112b;
        int i13 = iArr[0];
        int length = iArr.length;
        for (int i14 = 1; i14 < length; i14++) {
            b bVar = this.f5111a;
            i13 = bVar.a(bVar.i(i10, i13), this.f5112b[i14]);
        }
        return i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i10) {
        int[] iArr = this.f5112b;
        return iArr[(iArr.length - 1) - i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f5112b.length - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f5112b[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c f(int i10) {
        if (i10 == 0) {
            return this.f5111a.f();
        }
        if (i10 == 1) {
            return this;
        }
        int length = this.f5112b.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = this.f5111a.i(this.f5112b[i11], i10);
        }
        return new c(this.f5111a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c g(c cVar) {
        if (!this.f5111a.equals(cVar.f5111a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (e() || cVar.e()) {
            return this.f5111a.f();
        } else {
            int[] iArr = this.f5112b;
            int length = iArr.length;
            int[] iArr2 = cVar.f5112b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[(length + length2) - 1];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = iArr[i10];
                for (int i12 = 0; i12 < length2; i12++) {
                    int i13 = i10 + i12;
                    b bVar = this.f5111a;
                    iArr3[i13] = bVar.a(iArr3[i13], bVar.i(i11, iArr2[i12]));
                }
            }
            return new c(this.f5111a, iArr3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c h(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        } else if (i11 == 0) {
            return this.f5111a.f();
        } else {
            int length = this.f5112b.length;
            int[] iArr = new int[i10 + length];
            for (int i12 = 0; i12 < length; i12++) {
                iArr[i12] = this.f5111a.i(this.f5112b[i12], i11);
            }
            return new c(this.f5111a, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c i() {
        int length = this.f5112b.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = this.f5111a.j(0, this.f5112b[i10]);
        }
        return new c(this.f5111a, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c j(c cVar) {
        if (this.f5111a.equals(cVar.f5111a)) {
            return cVar.e() ? this : a(cVar.i());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(d() * 8);
        for (int d10 = d(); d10 >= 0; d10--) {
            int c10 = c(d10);
            if (c10 != 0) {
                if (c10 < 0) {
                    sb2.append(" - ");
                    c10 = -c10;
                } else if (sb2.length() > 0) {
                    sb2.append(" + ");
                }
                if (d10 == 0 || c10 != 1) {
                    sb2.append(c10);
                }
                if (d10 != 0) {
                    if (d10 == 1) {
                        sb2.append('x');
                    } else {
                        sb2.append("x^");
                        sb2.append(d10);
                    }
                }
            }
        }
        return sb2.toString();
    }
}
