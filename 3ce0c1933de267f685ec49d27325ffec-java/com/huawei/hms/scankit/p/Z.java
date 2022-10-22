package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
/* compiled from: ErrorCorrection.java */
/* loaded from: classes2.dex */
public final class Z {

    /* renamed from: a  reason: collision with root package name */
    private final C0564aa f14721a = C0564aa.f14734a;

    public int a(int[] iArr, int i10, int[] iArr2) throws C0550a {
        C0568ba baVar = new C0568ba(this.f14721a, iArr);
        int[] iArr3 = new int[i10];
        boolean z10 = false;
        for (int i11 = i10; i11 > 0; i11--) {
            int a10 = baVar.a(this.f14721a.a(i11));
            iArr3[i10 - i11] = a10;
            if (a10 != 0) {
                z10 = true;
            }
        }
        if (!z10) {
            return 0;
        }
        C0568ba a11 = this.f14721a.a();
        if (iArr2 != null) {
            for (int i12 : iArr2) {
                int a12 = this.f14721a.a((iArr.length - 1) - i12);
                C0564aa aaVar = this.f14721a;
                a11 = a11.b(new C0568ba(aaVar, new int[]{aaVar.d(0, a12), 1}));
            }
        }
        C0568ba[] a13 = a(this.f14721a.b(i10, 1), new C0568ba(this.f14721a, iArr3), i10);
        C0568ba baVar2 = a13[0];
        C0568ba baVar3 = a13[1];
        int[] a14 = a(baVar2);
        int[] a15 = a(baVar3, baVar2, a14);
        for (int i13 = 0; i13 < a14.length; i13++) {
            int length = (iArr.length - 1) - this.f14721a.c(a14[i13]);
            if (length >= 0) {
                iArr[length] = this.f14721a.d(iArr[length], a15[i13]);
            } else {
                throw C0550a.a();
            }
        }
        return a14.length;
    }

    private C0568ba[] a(C0568ba baVar, C0568ba baVar2, int i10) throws C0550a {
        if (baVar.a() >= baVar2.a()) {
            baVar2 = baVar;
            baVar = baVar2;
        }
        C0568ba c10 = this.f14721a.c();
        C0568ba a10 = this.f14721a.a();
        while (baVar.a() >= i10 / 2) {
            if (!baVar.b()) {
                C0568ba c11 = this.f14721a.c();
                int b10 = this.f14721a.b(baVar.b(baVar.a()));
                while (baVar2.a() >= baVar.a() && !baVar2.b()) {
                    int a11 = baVar2.a() - baVar.a();
                    int c12 = this.f14721a.c(baVar2.b(baVar2.a()), b10);
                    c11 = c11.a(this.f14721a.b(a11, c12));
                    baVar2 = baVar2.c(baVar.a(a11, c12));
                }
                a10 = c11.b(a10).c(c10).c();
                baVar = baVar2;
                baVar2 = baVar;
                c10 = a10;
            } else {
                throw C0550a.a();
            }
        }
        int b11 = a10.b(0);
        if (b11 != 0) {
            int b12 = this.f14721a.b(b11);
            return new C0568ba[]{a10.c(b12), baVar.c(b12)};
        }
        throw C0550a.a();
    }

    private int[] a(C0568ba baVar) throws C0550a {
        int a10 = baVar.a();
        int[] iArr = new int[a10];
        int i10 = 0;
        for (int i11 = 1; i11 < this.f14721a.b() && i10 < a10; i11++) {
            if (baVar.a(i11) == 0) {
                iArr[i10] = this.f14721a.b(i11);
                i10++;
            }
        }
        if (i10 == a10) {
            return iArr;
        }
        throw C0550a.a();
    }

    private int[] a(C0568ba baVar, C0568ba baVar2, int[] iArr) {
        int a10 = baVar2.a();
        int[] iArr2 = new int[a10];
        for (int i10 = 1; i10 <= a10; i10++) {
            iArr2[a10 - i10] = this.f14721a.c(i10, baVar2.b(i10));
        }
        C0568ba baVar3 = new C0568ba(this.f14721a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            int b10 = this.f14721a.b(iArr[i11]);
            iArr3[i11] = this.f14721a.c(this.f14721a.d(0, baVar.a(b10)), this.f14721a.b(baVar3.a(b10)));
        }
        return iArr3;
    }
}
