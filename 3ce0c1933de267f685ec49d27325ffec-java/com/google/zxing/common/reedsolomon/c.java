package com.google.zxing.common.reedsolomon;
/* compiled from: ReedSolomonDecoder.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f13434a;

    public c(a aVar) {
        this.f13434a = aVar;
    }

    private int[] b(b bVar) throws ReedSolomonException {
        int d10 = bVar.d();
        int i10 = 0;
        if (d10 == 1) {
            return new int[]{bVar.c(1)};
        }
        int[] iArr = new int[d10];
        for (int i11 = 1; i11 < this.f13434a.f() && i10 < d10; i11++) {
            if (bVar.b(i11) == 0) {
                iArr[i10] = this.f13434a.h(i11);
                i10++;
            }
        }
        if (i10 == d10) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    private int[] c(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            int h10 = this.f13434a.h(iArr[i10]);
            int i11 = 1;
            for (int i12 = 0; i12 < length; i12++) {
                if (i10 != i12) {
                    int j10 = this.f13434a.j(iArr[i12], h10);
                    i11 = this.f13434a.j(i11, (j10 & 1) == 0 ? j10 | 1 : j10 & (-2));
                }
            }
            iArr2[i10] = this.f13434a.j(bVar.b(h10), this.f13434a.h(i11));
            if (this.f13434a.d() != 0) {
                iArr2[i10] = this.f13434a.j(iArr2[i10], h10);
            }
        }
        return iArr2;
    }

    private b[] d(b bVar, b bVar2, int i10) throws ReedSolomonException {
        if (bVar.d() < bVar2.d()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b g10 = this.f13434a.g();
        b e10 = this.f13434a.e();
        do {
            bVar = bVar2;
            bVar2 = bVar;
            g10 = e10;
            b bVar3 = g10;
            if (bVar.d() < i10 / 2) {
                int c10 = g10.c(0);
                if (c10 != 0) {
                    int h10 = this.f13434a.h(c10);
                    return new b[]{g10.f(h10), bVar.f(h10)};
                }
                throw new ReedSolomonException("sigmaTilde(0) was zero");
            } else if (!bVar.e()) {
                b g11 = this.f13434a.g();
                int h11 = this.f13434a.h(bVar.c(bVar.d()));
                while (bVar2.d() >= bVar.d() && !bVar2.e()) {
                    int d10 = bVar2.d() - bVar.d();
                    int j10 = this.f13434a.j(bVar2.c(bVar2.d()), h11);
                    g11 = g11.a(this.f13434a.b(d10, j10));
                    bVar2 = bVar2.a(bVar.h(d10, j10));
                }
                e10 = g11.g(g10).a(bVar3);
            } else {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
        } while (bVar2.d() < bVar.d());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    public void a(int[] iArr, int i10) throws ReedSolomonException {
        b bVar = new b(this.f13434a, iArr);
        int[] iArr2 = new int[i10];
        boolean z10 = true;
        for (int i11 = 0; i11 < i10; i11++) {
            a aVar = this.f13434a;
            int b10 = bVar.b(aVar.c(aVar.d() + i11));
            iArr2[(i10 - 1) - i11] = b10;
            if (b10 != 0) {
                z10 = false;
            }
        }
        if (!z10) {
            b[] d10 = d(this.f13434a.b(i10, 1), new b(this.f13434a, iArr2), i10);
            b bVar2 = d10[0];
            b bVar3 = d10[1];
            int[] b11 = b(bVar2);
            int[] c10 = c(bVar3, b11);
            for (int i12 = 0; i12 < b11.length; i12++) {
                int length = (iArr.length - 1) - this.f13434a.i(b11[i12]);
                if (length >= 0) {
                    iArr[length] = a.a(iArr[length], c10[i12]);
                } else {
                    throw new ReedSolomonException("Bad error location");
                }
            }
        }
    }
}
