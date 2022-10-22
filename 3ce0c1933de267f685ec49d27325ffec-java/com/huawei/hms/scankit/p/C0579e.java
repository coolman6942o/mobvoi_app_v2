package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.F;
import com.huawei.hms.scankit.aiscan.common.h;
import com.huawei.hms.scankit.aiscan.common.j;
import com.huawei.hms.scankit.aiscan.common.n;
import com.huawei.hms.scankit.aiscan.common.u;
import com.huawei.hms.scankit.aiscan.common.z;
/* compiled from: Detector.java */
/* renamed from: com.huawei.hms.scankit.p.e  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0579e {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14775a = {3808, 476, 2107, 1799};

    /* renamed from: b  reason: collision with root package name */
    private final C0595i f14776b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14777c;

    /* renamed from: d  reason: collision with root package name */
    private int f14778d;

    /* renamed from: e  reason: collision with root package name */
    private int f14779e;

    /* renamed from: f  reason: collision with root package name */
    private int f14780f;

    /* renamed from: g  reason: collision with root package name */
    private int f14781g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Detector.java */
    /* renamed from: com.huawei.hms.scankit.p.e$a */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f14782a;

        /* renamed from: b  reason: collision with root package name */
        private final int f14783b;

        a(int i10, int i11) {
            this.f14782a = i10;
            this.f14783b = i11;
        }

        z c() {
            return new z(this.f14782a, this.f14783b);
        }

        public String toString() {
            return "<" + this.f14782a + ' ' + this.f14783b + '>';
        }

        int a() {
            return this.f14782a;
        }

        int b() {
            return this.f14783b;
        }
    }

    public C0579e(C0595i iVar) {
        this.f14776b = iVar;
    }

    private a b() {
        z zVar;
        z zVar2;
        z zVar3;
        z zVar4;
        z zVar5;
        z zVar6;
        z zVar7;
        z zVar8;
        try {
            z[] a10 = new F(this.f14776b).a();
            zVar3 = a10[0];
            zVar2 = a10[1];
            zVar = a10[2];
            zVar4 = a10[3];
        } catch (C0550a unused) {
            int d10 = this.f14776b.d() / 2;
            int b10 = this.f14776b.b() / 2;
            int i10 = d10 + 7;
            int i11 = b10 - 7;
            zVar3 = a(new a(i10, i11), false, 1, -1).c();
            int i12 = b10 + 7;
            zVar2 = a(new a(i10, i12), false, 1, 1).c();
            int i13 = d10 - 7;
            zVar = a(new a(i13, i12), false, -1, 1).c();
            zVar4 = a(new a(i13, i11), false, -1, -1).c();
        }
        int a11 = n.a((((zVar3.b() + zVar4.b()) + zVar2.b()) + zVar.b()) / 4.0f);
        int a12 = n.a((((zVar3.c() + zVar4.c()) + zVar2.c()) + zVar.c()) / 4.0f);
        try {
            z[] a13 = new F(this.f14776b, 15, a11, a12).a();
            zVar6 = a13[0];
            zVar5 = a13[1];
            zVar7 = a13[2];
            zVar8 = a13[3];
        } catch (C0550a unused2) {
            int i14 = a11 + 7;
            int i15 = a12 - 7;
            zVar6 = a(new a(i14, i15), false, 1, -1).c();
            int i16 = a12 + 7;
            zVar5 = a(new a(i14, i16), false, 1, 1).c();
            int i17 = a11 - 7;
            zVar7 = a(new a(i17, i16), false, -1, 1).c();
            zVar8 = a(new a(i17, i15), false, -1, -1).c();
        }
        return new a(n.a((((zVar6.b() + zVar8.b()) + zVar5.b()) + zVar7.b()) / 4.0f), n.a((((zVar6.c() + zVar8.c()) + zVar5.c()) + zVar7.c()) / 4.0f));
    }

    public C0563a a(boolean z10) throws C0550a {
        z[] a10 = a(b());
        if (z10) {
            z zVar = a10[0];
            a10[0] = a10[2];
            a10[2] = zVar;
        }
        a(a10);
        C0595i iVar = this.f14776b;
        int i10 = this.f14781g;
        return new C0563a(a(iVar, a10[i10 % 4], a10[(i10 + 1) % 4], a10[(i10 + 2) % 4], a10[(i10 + 3) % 4]), b(a10), this.f14777c, this.f14779e, this.f14778d);
    }

    private void a(z[] zVarArr) throws C0550a {
        long j10;
        long j11;
        if (!a(zVarArr[0]) || !a(zVarArr[1]) || !a(zVarArr[2]) || !a(zVarArr[3])) {
            throw C0550a.a();
        }
        int i10 = this.f14780f * 2;
        int[] iArr = {a(zVarArr[0], zVarArr[1], i10), a(zVarArr[1], zVarArr[2], i10), a(zVarArr[2], zVarArr[3], i10), a(zVarArr[3], zVarArr[0], i10)};
        this.f14781g = a(iArr, i10);
        long j12 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = iArr[(this.f14781g + i11) % 4];
            if (this.f14777c) {
                j11 = j12 << 7;
                j10 = (i12 >> 1) & 127;
            } else {
                j11 = j12 << 10;
                j10 = ((i12 >> 2) & 992) + ((i12 >> 1) & 31);
            }
            j12 = j11 + j10;
        }
        int a10 = a(j12, this.f14777c);
        if (this.f14777c) {
            this.f14778d = (a10 >> 6) + 1;
            this.f14779e = (a10 & 63) + 1;
            return;
        }
        this.f14778d = (a10 >> 11) + 1;
        this.f14779e = (a10 & 2047) + 1;
    }

    private z[] b(z[] zVarArr) {
        return a(zVarArr, this.f14780f * 2, a());
    }

    private boolean b(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a(aVar.a() - 3, aVar.b() + 3);
        a aVar6 = new a(aVar2.a() - 3, aVar2.b() - 3);
        a aVar7 = new a(aVar3.a() + 3, aVar3.b() - 3);
        a aVar8 = new a(aVar4.a() + 3, aVar4.b() + 3);
        int b10 = b(aVar8, aVar5);
        return b10 != 0 && b(aVar5, aVar6) == b10 && b(aVar6, aVar7) == b10 && b(aVar7, aVar8) == b10;
    }

    private static int a(int[] iArr, int i10) throws C0550a {
        int i11 = 0;
        for (int i12 : iArr) {
            i11 = (i11 << 3) + ((i12 >> (i10 - 2)) << 1) + (i12 & 1);
        }
        int i13 = ((i11 & 1) << 11) + (i11 >> 1);
        for (int i14 = 0; i14 < 4; i14++) {
            if (Integer.bitCount(f14775a[i14] ^ i13) <= 2) {
                return i14;
            }
        }
        throw C0550a.a();
    }

    private static int a(long j10, boolean z10) throws C0550a {
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
            new u(h.f14223d).a(iArr, i12);
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                i14 = (i14 << 4) + iArr[i15];
            }
            return i14;
        } catch (C0550a unused) {
            throw C0550a.a();
        }
    }

    private int b(a aVar, a aVar2) {
        float a10 = a(aVar, aVar2);
        float a11 = (aVar2.a() - aVar.a()) / a10;
        float b10 = (aVar2.b() - aVar.b()) / a10;
        float a12 = aVar.a();
        float b11 = aVar.b();
        boolean b12 = this.f14776b.b(aVar.a(), aVar.b());
        int ceil = (int) Math.ceil(a10);
        boolean z10 = false;
        int i10 = 0;
        for (int i11 = 0; i11 < ceil; i11++) {
            a12 += a11;
            b11 += b10;
            if (this.f14776b.b(n.a(a12), n.a(b11)) != b12) {
                i10++;
            }
        }
        float f10 = i10 / a10;
        if (f10 > 0.1f && f10 < 0.9f) {
            return 0;
        }
        if (f10 <= 0.1f) {
            z10 = true;
        }
        return z10 == b12 ? 1 : -1;
    }

    private z[] a(a aVar) throws C0550a {
        int i10 = 1;
        this.f14780f = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        a aVar5 = aVar4;
        boolean z10 = true;
        while (this.f14780f < 9) {
            a a10 = a(aVar5, z10, i10, -1);
            a a11 = a(aVar4, z10, i10, i10);
            a a12 = a(aVar3, z10, -1, i10);
            a a13 = a(aVar2, z10, -1, -1);
            if (this.f14780f > 2) {
                double a14 = (a(a13, a10) * this.f14780f) / (a(aVar2, aVar5) * (this.f14780f + 2));
                if (a14 < 0.75d) {
                    break;
                } else if (a14 > 1.25d) {
                    break;
                } else if (!a(a10, a11, a12, a13)) {
                    break;
                } else if (!b(a10, a11, a12, a13)) {
                    int i11 = this.f14780f;
                    if (i11 == 5 || i11 == 7) {
                        break;
                    }
                } else {
                    continue;
                }
            }
            z10 = !z10;
            this.f14780f++;
            aVar2 = a13;
            aVar5 = a10;
            aVar4 = a11;
            aVar3 = a12;
            i10 = 1;
        }
        int i12 = this.f14780f;
        if (i12 == 5 || i12 == 7) {
            this.f14777c = i12 == 5;
            z[] zVarArr = {new z(aVar5.a() + 0.5f, aVar5.b() - 0.5f), new z(aVar4.a() + 0.5f, aVar4.b() + 0.5f), new z(aVar3.a() - 0.5f, aVar3.b() + 0.5f), new z(aVar2.a() - 0.5f, aVar2.b() - 0.5f)};
            int i13 = this.f14780f * 2;
            return a(zVarArr, i13 - 3, i13);
        }
        throw C0550a.a();
    }

    private C0595i a(C0595i iVar, z zVar, z zVar2, z zVar3, z zVar4) throws C0550a {
        j a10 = j.a();
        int a11 = a();
        float f10 = a11 / 2.0f;
        float f11 = this.f14780f;
        float f12 = f10 - f11;
        float f13 = f10 + f11;
        return a10.a(iVar, a11, a11, f12, f12, f13, f12, f13, f13, f12, f13, zVar.b(), zVar.c(), zVar2.b(), zVar2.c(), zVar3.b(), zVar3.c(), zVar4.b(), zVar4.c());
    }

    private int a(z zVar, z zVar2, int i10) {
        float a10 = a(zVar, zVar2);
        float f10 = a10 / i10;
        float b10 = zVar.b();
        float c10 = zVar.c();
        float b11 = ((zVar2.b() - zVar.b()) * f10) / a10;
        float c11 = (f10 * (zVar2.c() - zVar.c())) / a10;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            float f11 = i12;
            if (this.f14776b.b(n.a((f11 * b11) + b10), n.a((f11 * c11) + c10))) {
                i11 |= 1 << ((i10 - i12) - 1);
            }
        }
        return i11;
    }

    private boolean a(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a((int) Math.ceil((((aVar.f14782a + aVar2.f14782a) + aVar3.f14782a) + aVar4.f14782a) / 4.0f), (int) Math.ceil((((aVar.f14783b + aVar2.f14783b) + aVar3.f14783b) + aVar4.f14783b) / 4.0f));
        float a10 = a(aVar5, aVar);
        float a11 = a(aVar5, aVar2);
        float a12 = a(aVar5, aVar3);
        float a13 = a(aVar5, aVar4);
        double d10 = a10 / a11;
        if (d10 <= 0.75d || d10 >= 1.25d) {
            return false;
        }
        double d11 = a10 / a12;
        if (d11 <= 0.75d || d11 >= 1.25d) {
            return false;
        }
        double d12 = a10 / a13;
        return d12 > 0.75d && d12 < 1.25d;
    }

    private a a(a aVar, boolean z10, int i10, int i11) {
        int a10 = aVar.a() + i10;
        int b10 = aVar.b();
        while (true) {
            b10 += i11;
            if (!a(a10, b10) || this.f14776b.b(a10, b10) != z10) {
                break;
            }
            a10 += i10;
        }
        int i12 = a10 - i10;
        int i13 = b10 - i11;
        while (a(i12, i13) && this.f14776b.b(i12, i13) == z10) {
            i12 += i10;
        }
        int i14 = i12 - i10;
        while (a(i14, i13) && this.f14776b.b(i14, i13) == z10) {
            i13 += i11;
        }
        return new a(i14, i13 - i11);
    }

    private static z[] a(z[] zVarArr, int i10, int i11) {
        float f10 = i11 / (i10 * 2.0f);
        float b10 = zVarArr[0].b() - zVarArr[2].b();
        float c10 = zVarArr[0].c() - zVarArr[2].c();
        float b11 = (zVarArr[0].b() + zVarArr[2].b()) / 2.0f;
        float c11 = (zVarArr[0].c() + zVarArr[2].c()) / 2.0f;
        float f11 = b10 * f10;
        float f12 = c10 * f10;
        z zVar = new z(b11 + f11, c11 + f12);
        z zVar2 = new z(b11 - f11, c11 - f12);
        float b12 = zVarArr[1].b() - zVarArr[3].b();
        float c12 = zVarArr[1].c() - zVarArr[3].c();
        float b13 = (zVarArr[1].b() + zVarArr[3].b()) / 2.0f;
        float c13 = (zVarArr[1].c() + zVarArr[3].c()) / 2.0f;
        float f13 = b12 * f10;
        float f14 = f10 * c12;
        return new z[]{zVar, new z(b13 + f13, c13 + f14), zVar2, new z(b13 - f13, c13 - f14)};
    }

    private boolean a(int i10, int i11) {
        return i10 >= 0 && i10 < this.f14776b.d() && i11 > 0 && i11 < this.f14776b.b();
    }

    private boolean a(z zVar) {
        return a(n.a(zVar.b()), n.a(zVar.c()));
    }

    private static float a(a aVar, a aVar2) {
        return n.a(aVar.a(), aVar.b(), aVar2.a(), aVar2.b());
    }

    private static float a(z zVar, z zVar2) {
        return n.a(zVar.b(), zVar.c(), zVar2.b(), zVar2.c());
    }

    private int a() {
        if (this.f14777c) {
            return (this.f14778d * 4) + 11;
        }
        int i10 = this.f14778d;
        return i10 <= 4 ? (i10 * 4) + 15 : (i10 * 4) + ((((i10 - 4) / 8) + 1) * 2) + 15;
    }
}
