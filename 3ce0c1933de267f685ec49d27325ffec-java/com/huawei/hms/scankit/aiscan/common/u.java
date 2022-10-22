package com.huawei.hms.scankit.aiscan.common;
/* compiled from: ReedSolomonDecoder.java */
/* loaded from: classes2.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    private final h f14290a;

    public u(h hVar) {
        this.f14290a = hVar;
    }

    public void a(int[] iArr, int i10) throws C0550a {
        i iVar = new i(this.f14290a, iArr);
        int[] iArr2 = new int[i10];
        boolean z10 = true;
        for (int i11 = 0; i11 < i10; i11++) {
            h hVar = this.f14290a;
            int a10 = iVar.a(hVar.a(hVar.a() + i11));
            iArr2[(i10 - 1) - i11] = a10;
            if (a10 != 0) {
                z10 = false;
            }
        }
        if (!z10) {
            i[] a11 = a(this.f14290a.b(i10, 1), new i(this.f14290a, iArr2), i10);
            i iVar2 = a11[0];
            i iVar3 = a11[1];
            int[] a12 = a(iVar2);
            int[] a13 = a(iVar3, a12);
            for (int i12 = 0; i12 < a12.length; i12++) {
                int length = (iArr.length - 1) - this.f14290a.c(a12[i12]);
                if (length >= 0) {
                    iArr[length] = h.a(iArr[length], a13[i12]);
                } else {
                    throw C0550a.a("Bad error location");
                }
            }
        }
    }

    private i[] a(i iVar, i iVar2, int i10) throws C0550a {
        if (iVar.b() >= iVar2.b()) {
            iVar2 = iVar;
            iVar = iVar2;
        }
        i d10 = this.f14290a.d();
        i b10 = this.f14290a.b();
        while (iVar.b() >= i10 / 2) {
            if (!iVar.c()) {
                i d11 = this.f14290a.d();
                int b11 = this.f14290a.b(iVar.b(iVar.b()));
                while (iVar2.b() >= iVar.b() && !iVar2.c()) {
                    int b12 = iVar2.b() - iVar.b();
                    int c10 = this.f14290a.c(iVar2.b(iVar2.b()), b11);
                    d11 = d11.a(this.f14290a.b(b12, c10));
                    iVar2 = iVar2.a(iVar.a(b12, c10));
                }
                b10 = d11.c(b10).a(d10);
                if (iVar2.b() < iVar.b()) {
                    iVar = iVar2;
                    iVar2 = iVar;
                    d10 = b10;
                } else {
                    throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
                }
            } else {
                throw C0550a.a("r_{i-1} was zero");
            }
        }
        int b13 = b10.b(0);
        if (b13 != 0) {
            int b14 = this.f14290a.b(b13);
            return new i[]{b10.c(b14), iVar.c(b14)};
        }
        throw C0550a.a("sigmaTilde(0) was zero");
    }

    private int[] a(i iVar) throws C0550a {
        int b10 = iVar.b();
        int i10 = 0;
        if (b10 == 1) {
            return new int[]{iVar.b(1)};
        }
        int[] iArr = new int[b10];
        for (int i11 = 1; i11 < this.f14290a.c() && i10 < b10; i11++) {
            if (iVar.a(i11) == 0) {
                iArr[i10] = this.f14290a.b(i11);
                i10++;
            }
        }
        if (i10 == b10) {
            return iArr;
        }
        throw C0550a.a("Error locator degree does not match number of roots");
    }

    private int[] a(i iVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            int b10 = this.f14290a.b(iArr[i10]);
            int i11 = 1;
            for (int i12 = 0; i12 < length; i12++) {
                if (i10 != i12) {
                    int c10 = this.f14290a.c(iArr[i12], b10);
                    i11 = this.f14290a.c(i11, (c10 & 1) == 0 ? c10 | 1 : c10 & (-2));
                }
            }
            iArr2[i10] = this.f14290a.c(iVar.a(b10), this.f14290a.b(i11));
            if (this.f14290a.a() != 0) {
                iArr2[i10] = this.f14290a.c(iArr2[i10], b10);
            }
        }
        return iArr2;
    }
}
