package n8;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.b;
import com.google.zxing.common.e;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.common.reedsolomon.c;
import com.google.zxing.i;
/* compiled from: Detector.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f31056g = {3808, 476, 2107, 1799};

    /* renamed from: a  reason: collision with root package name */
    private final b f31057a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f31058b;

    /* renamed from: c  reason: collision with root package name */
    private int f31059c;

    /* renamed from: d  reason: collision with root package name */
    private int f31060d;

    /* renamed from: e  reason: collision with root package name */
    private int f31061e;

    /* renamed from: f  reason: collision with root package name */
    private int f31062f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Detector.java */
    /* renamed from: n8.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0409a {

        /* renamed from: a  reason: collision with root package name */
        private final int f31063a;

        /* renamed from: b  reason: collision with root package name */
        private final int f31064b;

        C0409a(int i10, int i11) {
            this.f31063a = i10;
            this.f31064b = i11;
        }

        int a() {
            return this.f31063a;
        }

        int b() {
            return this.f31064b;
        }

        i c() {
            return new i(a(), b());
        }

        public String toString() {
            return "<" + this.f31063a + ' ' + this.f31064b + '>';
        }
    }

    public a(b bVar) {
        this.f31057a = bVar;
    }

    private static float b(i iVar, i iVar2) {
        return p8.a.a(iVar.c(), iVar.d(), iVar2.c(), iVar2.d());
    }

    private static float c(C0409a aVar, C0409a aVar2) {
        return p8.a.b(aVar.a(), aVar.b(), aVar2.a(), aVar2.b());
    }

    private static i[] d(i[] iVarArr, float f10, float f11) {
        float f12 = f11 / (f10 * 2.0f);
        float c10 = iVarArr[0].c() - iVarArr[2].c();
        float d10 = iVarArr[0].d() - iVarArr[2].d();
        float c11 = (iVarArr[0].c() + iVarArr[2].c()) / 2.0f;
        float d11 = (iVarArr[0].d() + iVarArr[2].d()) / 2.0f;
        float f13 = c10 * f12;
        float f14 = d10 * f12;
        i iVar = new i(c11 + f13, d11 + f14);
        i iVar2 = new i(c11 - f13, d11 - f14);
        float c12 = iVarArr[1].c() - iVarArr[3].c();
        float d12 = iVarArr[1].d() - iVarArr[3].d();
        float c13 = (iVarArr[1].c() + iVarArr[3].c()) / 2.0f;
        float d13 = (iVarArr[1].d() + iVarArr[3].d()) / 2.0f;
        float f15 = c12 * f12;
        float f16 = f12 * d12;
        return new i[]{iVar, new i(c13 + f15, d13 + f16), iVar2, new i(c13 - f15, d13 - f16)};
    }

    private void e(i[] iVarArr) throws NotFoundException {
        long j10;
        long j11;
        if (!o(iVarArr[0]) || !o(iVarArr[1]) || !o(iVarArr[2]) || !o(iVarArr[3])) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i10 = this.f31061e * 2;
        int[] iArr = {r(iVarArr[0], iVarArr[1], i10), r(iVarArr[1], iVarArr[2], i10), r(iVarArr[2], iVarArr[3], i10), r(iVarArr[3], iVarArr[0], i10)};
        this.f31062f = m(iArr, i10);
        long j12 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = iArr[(this.f31062f + i11) % 4];
            if (this.f31058b) {
                j11 = j12 << 7;
                j10 = (i12 >> 1) & 127;
            } else {
                j11 = j12 << 10;
                j10 = ((i12 >> 2) & 992) + ((i12 >> 1) & 31);
            }
            j12 = j11 + j10;
        }
        int h10 = h(j12, this.f31058b);
        if (this.f31058b) {
            this.f31059c = (h10 >> 6) + 1;
            this.f31060d = (h10 & 63) + 1;
            return;
        }
        this.f31059c = (h10 >> 11) + 1;
        this.f31060d = (h10 & 2047) + 1;
    }

    private i[] f(C0409a aVar) throws NotFoundException {
        this.f31061e = 1;
        C0409a aVar2 = aVar;
        C0409a aVar3 = aVar2;
        C0409a aVar4 = aVar3;
        boolean z10 = true;
        while (this.f31061e < 9) {
            C0409a j10 = j(aVar, z10, 1, -1);
            C0409a j11 = j(aVar2, z10, 1, 1);
            C0409a j12 = j(aVar3, z10, -1, 1);
            C0409a j13 = j(aVar4, z10, -1, -1);
            if (this.f31061e > 2) {
                double c10 = (c(j13, j10) * this.f31061e) / (c(aVar4, aVar) * (this.f31061e + 2));
                if (c10 < 0.75d || c10 > 1.25d || !p(j10, j11, j12, j13)) {
                    break;
                }
            }
            z10 = !z10;
            this.f31061e++;
            aVar4 = j13;
            aVar = j10;
            aVar2 = j11;
            aVar3 = j12;
        }
        int i10 = this.f31061e;
        if (i10 == 5 || i10 == 7) {
            this.f31058b = i10 == 5;
            i[] iVarArr = {new i(aVar.a() + 0.5f, aVar.b() - 0.5f), new i(aVar2.a() + 0.5f, aVar2.b() + 0.5f), new i(aVar3.a() - 0.5f, aVar3.b() + 0.5f), new i(aVar4.a() - 0.5f, aVar4.b() - 0.5f)};
            int i11 = this.f31061e;
            return d(iVarArr, (i11 * 2) - 3, i11 * 2);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int g(C0409a aVar, C0409a aVar2) {
        float c10 = c(aVar, aVar2);
        float a10 = (aVar2.a() - aVar.a()) / c10;
        float b10 = (aVar2.b() - aVar.b()) / c10;
        float a11 = aVar.a();
        float b11 = aVar.b();
        boolean d10 = this.f31057a.d(aVar.a(), aVar.b());
        int ceil = (int) Math.ceil(c10);
        boolean z10 = false;
        int i10 = 0;
        for (int i11 = 0; i11 < ceil; i11++) {
            a11 += a10;
            b11 += b10;
            if (this.f31057a.d(p8.a.c(a11), p8.a.c(b11)) != d10) {
                i10++;
            }
        }
        float f10 = i10 / c10;
        if (f10 > 0.1f && f10 < 0.9f) {
            return 0;
        }
        if (f10 <= 0.1f) {
            z10 = true;
        }
        return z10 == d10 ? 1 : -1;
    }

    private static int h(long j10, boolean z10) throws NotFoundException {
        int i10;
        int i11;
        if (z10) {
            i10 = 7;
            i11 = 2;
        } else {
            i10 = 10;
            i11 = 4;
        }
        int i12 = i10 - i11;
        int[] iArr = new int[i10];
        for (int i13 = i10 - 1; i13 >= 0; i13--) {
            iArr[i13] = ((int) j10) & 15;
            j10 >>= 4;
        }
        try {
            new c(com.google.zxing.common.reedsolomon.a.f13420k).a(iArr, i12);
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                i14 = (i14 << 4) + iArr[i15];
            }
            return i14;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private int i() {
        if (this.f31058b) {
            return (this.f31059c * 4) + 11;
        }
        int i10 = this.f31059c;
        return i10 <= 4 ? (i10 * 4) + 15 : (i10 * 4) + ((((i10 - 4) / 8) + 1) * 2) + 15;
    }

    private C0409a j(C0409a aVar, boolean z10, int i10, int i11) {
        int a10 = aVar.a() + i10;
        int b10 = aVar.b();
        while (true) {
            b10 += i11;
            if (!n(a10, b10) || this.f31057a.d(a10, b10) != z10) {
                break;
            }
            a10 += i10;
        }
        int i12 = a10 - i10;
        int i13 = b10 - i11;
        while (n(i12, i13) && this.f31057a.d(i12, i13) == z10) {
            i12 += i10;
        }
        int i14 = i12 - i10;
        while (n(i14, i13) && this.f31057a.d(i14, i13) == z10) {
            i13 += i11;
        }
        return new C0409a(i14, i13 - i11);
    }

    private C0409a k() {
        i iVar;
        i iVar2;
        i iVar3;
        i iVar4;
        i iVar5;
        i iVar6;
        i iVar7;
        i iVar8;
        try {
            i[] c10 = new p8.b(this.f31057a).c();
            iVar3 = c10[0];
            iVar2 = c10[1];
            iVar = c10[2];
            iVar4 = c10[3];
        } catch (NotFoundException unused) {
            int k10 = this.f31057a.k() / 2;
            int g10 = this.f31057a.g() / 2;
            int i10 = k10 + 7;
            int i11 = g10 - 7;
            iVar3 = j(new C0409a(i10, i11), false, 1, -1).c();
            int i12 = g10 + 7;
            iVar2 = j(new C0409a(i10, i12), false, 1, 1).c();
            int i13 = k10 - 7;
            iVar = j(new C0409a(i13, i12), false, -1, 1).c();
            iVar4 = j(new C0409a(i13, i11), false, -1, -1).c();
        }
        int c11 = p8.a.c((((iVar3.c() + iVar4.c()) + iVar2.c()) + iVar.c()) / 4.0f);
        int c12 = p8.a.c((((iVar3.d() + iVar4.d()) + iVar2.d()) + iVar.d()) / 4.0f);
        try {
            i[] c13 = new p8.b(this.f31057a, 15, c11, c12).c();
            iVar6 = c13[0];
            iVar5 = c13[1];
            iVar7 = c13[2];
            iVar8 = c13[3];
        } catch (NotFoundException unused2) {
            int i14 = c11 + 7;
            int i15 = c12 - 7;
            iVar6 = j(new C0409a(i14, i15), false, 1, -1).c();
            int i16 = c12 + 7;
            iVar5 = j(new C0409a(i14, i16), false, 1, 1).c();
            int i17 = c11 - 7;
            iVar7 = j(new C0409a(i17, i16), false, -1, 1).c();
            iVar8 = j(new C0409a(i17, i15), false, -1, -1).c();
        }
        return new C0409a(p8.a.c((((iVar6.c() + iVar8.c()) + iVar5.c()) + iVar7.c()) / 4.0f), p8.a.c((((iVar6.d() + iVar8.d()) + iVar5.d()) + iVar7.d()) / 4.0f));
    }

    private i[] l(i[] iVarArr) {
        return d(iVarArr, this.f31061e * 2, i());
    }

    private static int m(int[] iArr, int i10) throws NotFoundException {
        int i11 = 0;
        for (int i12 : iArr) {
            i11 = (i11 << 3) + ((i12 >> (i10 - 2)) << 1) + (i12 & 1);
        }
        int i13 = ((i11 & 1) << 11) + (i11 >> 1);
        for (int i14 = 0; i14 < 4; i14++) {
            if (Integer.bitCount(f31056g[i14] ^ i13) <= 2) {
                return i14;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private boolean n(int i10, int i11) {
        return i10 >= 0 && i10 < this.f31057a.k() && i11 > 0 && i11 < this.f31057a.g();
    }

    private boolean o(i iVar) {
        return n(p8.a.c(iVar.c()), p8.a.c(iVar.d()));
    }

    private boolean p(C0409a aVar, C0409a aVar2, C0409a aVar3, C0409a aVar4) {
        C0409a aVar5 = new C0409a(aVar.a() - 3, aVar.b() + 3);
        C0409a aVar6 = new C0409a(aVar2.a() - 3, aVar2.b() - 3);
        C0409a aVar7 = new C0409a(aVar3.a() + 3, aVar3.b() - 3);
        C0409a aVar8 = new C0409a(aVar4.a() + 3, aVar4.b() + 3);
        int g10 = g(aVar8, aVar5);
        return g10 != 0 && g(aVar5, aVar6) == g10 && g(aVar6, aVar7) == g10 && g(aVar7, aVar8) == g10;
    }

    private b q(b bVar, i iVar, i iVar2, i iVar3, i iVar4) throws NotFoundException {
        e b10 = e.b();
        int i10 = i();
        float f10 = i10 / 2.0f;
        int i11 = this.f31061e;
        float f11 = f10 - i11;
        float f12 = f10 + i11;
        return b10.c(bVar, i10, i10, f11, f11, f12, f11, f12, f12, f11, f12, iVar.c(), iVar.d(), iVar2.c(), iVar2.d(), iVar3.c(), iVar3.d(), iVar4.c(), iVar4.d());
    }

    private int r(i iVar, i iVar2, int i10) {
        float b10 = b(iVar, iVar2);
        float f10 = b10 / i10;
        float c10 = iVar.c();
        float d10 = iVar.d();
        float c11 = ((iVar2.c() - iVar.c()) * f10) / b10;
        float d11 = (f10 * (iVar2.d() - iVar.d())) / b10;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            float f11 = i12;
            if (this.f31057a.d(p8.a.c((f11 * c11) + c10), p8.a.c((f11 * d11) + d10))) {
                i11 |= 1 << ((i10 - i12) - 1);
            }
        }
        return i11;
    }

    public l8.a a(boolean z10) throws NotFoundException {
        i[] f10 = f(k());
        if (z10) {
            i iVar = f10[0];
            f10[0] = f10[2];
            f10[2] = iVar;
        }
        e(f10);
        b bVar = this.f31057a;
        int i10 = this.f31062f;
        return new l8.a(q(bVar, f10[i10 % 4], f10[(i10 + 1) % 4], f10[(i10 + 2) % 4], f10[(i10 + 3) % 4]), l(f10), this.f31058b, this.f31060d, this.f31059c);
    }
}
