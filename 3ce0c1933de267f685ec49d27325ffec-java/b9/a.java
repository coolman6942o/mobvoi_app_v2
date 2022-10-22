package b9;

import com.google.zxing.ChecksumException;
/* compiled from: ErrorCorrection.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f5104a = b.f5105f;

    private int[] b(c cVar) throws ChecksumException {
        int d10 = cVar.d();
        int[] iArr = new int[d10];
        int i10 = 0;
        for (int i11 = 1; i11 < this.f5104a.e() && i10 < d10; i11++) {
            if (cVar.b(i11) == 0) {
                iArr[i10] = this.f5104a.g(i11);
                i10++;
            }
        }
        if (i10 == d10) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] c(c cVar, c cVar2, int[] iArr) {
        int d10 = cVar2.d();
        int[] iArr2 = new int[d10];
        for (int i10 = 1; i10 <= d10; i10++) {
            iArr2[d10 - i10] = this.f5104a.i(i10, cVar2.c(i10));
        }
        c cVar3 = new c(this.f5104a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            int g10 = this.f5104a.g(iArr[i11]);
            iArr3[i11] = this.f5104a.i(this.f5104a.j(0, cVar.b(g10)), this.f5104a.g(cVar3.b(g10)));
        }
        return iArr3;
    }

    private c[] d(c cVar, c cVar2, int i10) throws ChecksumException {
        if (cVar.d() < cVar2.d()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c f10 = this.f5104a.f();
        c d10 = this.f5104a.d();
        while (true) {
            cVar = cVar2;
            cVar2 = cVar;
            f10 = d10;
            c cVar3 = f10;
            if (cVar.d() < i10 / 2) {
                int c10 = f10.c(0);
                if (c10 != 0) {
                    int g10 = this.f5104a.g(c10);
                    return new c[]{f10.f(g10), cVar.f(g10)};
                }
                throw ChecksumException.getChecksumInstance();
            } else if (!cVar.e()) {
                c f11 = this.f5104a.f();
                int g11 = this.f5104a.g(cVar.c(cVar.d()));
                while (cVar2.d() >= cVar.d() && !cVar2.e()) {
                    int d11 = cVar2.d() - cVar.d();
                    int i11 = this.f5104a.i(cVar2.c(cVar2.d()), g11);
                    f11 = f11.a(this.f5104a.b(d11, i11));
                    cVar2 = cVar2.j(cVar.h(d11, i11));
                }
                d10 = f11.g(f10).j(cVar3).i();
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    public int a(int[] iArr, int i10, int[] iArr2) throws ChecksumException {
        c cVar = new c(this.f5104a, iArr);
        int[] iArr3 = new int[i10];
        boolean z10 = false;
        for (int i11 = i10; i11 > 0; i11--) {
            int b10 = cVar.b(this.f5104a.c(i11));
            iArr3[i10 - i11] = b10;
            if (b10 != 0) {
                z10 = true;
            }
        }
        if (!z10) {
            return 0;
        }
        c d10 = this.f5104a.d();
        if (iArr2 != null) {
            for (int i12 : iArr2) {
                int c10 = this.f5104a.c((iArr.length - 1) - i12);
                b bVar = this.f5104a;
                d10 = d10.g(new c(bVar, new int[]{bVar.j(0, c10), 1}));
            }
        }
        c[] d11 = d(this.f5104a.b(i10, 1), new c(this.f5104a, iArr3), i10);
        c cVar2 = d11[0];
        c cVar3 = d11[1];
        int[] b11 = b(cVar2);
        int[] c11 = c(cVar3, cVar2, b11);
        for (int i13 = 0; i13 < b11.length; i13++) {
            int length = (iArr.length - 1) - this.f5104a.h(b11[i13]);
            if (length >= 0) {
                iArr[length] = this.f5104a.j(iArr[length], c11[i13]);
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
        return b11.length;
    }
}
