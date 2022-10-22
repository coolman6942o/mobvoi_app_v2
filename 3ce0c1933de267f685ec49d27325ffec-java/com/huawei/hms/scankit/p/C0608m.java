package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
/* compiled from: BitMatrixParser.java */
/* renamed from: com.huawei.hms.scankit.p.m  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0608m {

    /* renamed from: a  reason: collision with root package name */
    private final C0595i f14869a;

    /* renamed from: b  reason: collision with root package name */
    private final C0595i f14870b;

    /* renamed from: c  reason: collision with root package name */
    private final C0631u f14871c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0608m(C0595i iVar) throws C0550a {
        int b10 = iVar.b();
        if (b10 < 8 || b10 > 144 || (b10 & 1) != 0) {
            throw C0550a.a();
        }
        this.f14871c = b(iVar);
        C0595i a10 = a(iVar);
        this.f14869a = a10;
        this.f14870b = new C0595i(a10.d(), a10.b());
    }

    private static C0631u b(C0595i iVar) throws C0550a {
        return C0631u.a(iVar.b(), iVar.d());
    }

    private int c(int i10, int i11) {
        int i12 = i10 - 1;
        int i13 = (a(i12, 0, i10, i11) ? 1 : 0) << 1;
        int i14 = i11 - 1;
        if (a(i12, i14, i10, i11)) {
            i13 |= 1;
        }
        int i15 = i13 << 1;
        int i16 = i11 - 3;
        if (a(0, i16, i10, i11)) {
            i15 |= 1;
        }
        int i17 = i15 << 1;
        int i18 = i11 - 2;
        if (a(0, i18, i10, i11)) {
            i17 |= 1;
        }
        int i19 = i17 << 1;
        if (a(0, i14, i10, i11)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        if (a(1, i16, i10, i11)) {
            i20 |= 1;
        }
        int i21 = i20 << 1;
        if (a(1, i18, i10, i11)) {
            i21 |= 1;
        }
        int i22 = i21 << 1;
        return a(1, i14, i10, i11) ? i22 | 1 : i22;
    }

    private int d(int i10, int i11) {
        int i12 = (a(i10 + (-3), 0, i10, i11) ? 1 : 0) << 1;
        if (a(i10 - 2, 0, i10, i11)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i10 - 1, 0, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(0, i11 - 2, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        int i16 = i11 - 1;
        if (a(0, i16, i10, i11)) {
            i15 |= 1;
        }
        int i17 = i15 << 1;
        if (a(1, i16, i10, i11)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        if (a(2, i16, i10, i11)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        return a(3, i16, i10, i11) ? i19 | 1 : i19;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0631u a() {
        return this.f14871c;
    }

    private int[] a(int i10, int i11, int i12, int i13, byte[] bArr, int i14) {
        do {
            if (i10 < i11 && i12 >= 0 && !this.f14870b.b(i12, i10)) {
                i14++;
                bArr[i14] = (byte) b(i10, i12, i11, i13);
            }
            i10 -= 2;
            i12 += 2;
            if (i10 < 0) {
                break;
            }
        } while (i12 < i13);
        int i15 = i10 + 1;
        int i16 = i12 + 3;
        do {
            if (i15 >= 0 && i16 < i13 && !this.f14870b.b(i16, i15)) {
                i14++;
                bArr[i14] = (byte) b(i15, i16, i11, i13);
            }
            i15 += 2;
            i16 -= 2;
            if (i15 >= i11) {
                break;
            }
        } while (i16 >= 0);
        return new int[]{i15 + 3, i16 + 1, i14};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b() throws C0550a {
        byte[] bArr = new byte[this.f14871c.f()];
        int b10 = this.f14869a.b();
        int d10 = this.f14869a.d();
        int i10 = 4;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        while (true) {
            if (i10 == b10 && i11 == 0 && !z10) {
                i12++;
                bArr[i12] = (byte) a(b10, d10);
                i10 -= 2;
                i11 += 2;
                z10 = true;
            } else {
                int i13 = b10 - 2;
                if (i10 == i13 && i11 == 0 && (d10 & 3) != 0 && !z11) {
                    i12++;
                    bArr[i12] = (byte) b(b10, d10);
                    i10 -= 2;
                    i11 += 2;
                    z11 = true;
                } else if (i10 == b10 + 4 && i11 == 2 && (d10 & 7) == 0 && !z12) {
                    i12++;
                    bArr[i12] = (byte) c(b10, d10);
                    i10 -= 2;
                    i11 += 2;
                    z12 = true;
                } else if (i10 == i13 && i11 == 0 && (d10 & 7) == 4 && !z13) {
                    i12++;
                    bArr[i12] = (byte) d(b10, d10);
                    i10 -= 2;
                    i11 += 2;
                    z13 = true;
                } else {
                    int[] a10 = a(i10, b10, i11, d10, bArr, i12);
                    i10 = a10[0];
                    int i14 = a10[1];
                    i12 = a10[2];
                    i11 = i14;
                }
            }
            if (i10 >= b10 && i11 >= d10) {
                break;
            }
        }
        if (i12 == this.f14871c.f()) {
            return bArr;
        }
        throw C0550a.a();
    }

    private boolean a(int i10, int i11, int i12, int i13) {
        if (i10 < 0) {
            i10 += i12;
            i11 += 4 - ((i12 + 4) & 7);
        }
        if (i11 < 0) {
            i11 += i13;
            i10 += 4 - ((i13 + 4) & 7);
        }
        this.f14870b.c(i11, i10);
        return this.f14869a.b(i11, i10);
    }

    private int a(int i10, int i11) {
        int i12 = i10 - 1;
        int i13 = (a(i12, 0, i10, i11) ? 1 : 0) << 1;
        if (a(i12, 1, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(i12, 2, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (a(0, i11 - 2, i10, i11)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        int i17 = i11 - 1;
        if (a(0, i17, i10, i11)) {
            i16 |= 1;
        }
        int i18 = i16 << 1;
        if (a(1, i17, i10, i11)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        if (a(2, i17, i10, i11)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        return a(3, i17, i10, i11) ? i20 | 1 : i20;
    }

    private C0595i a(C0595i iVar) {
        int e10 = this.f14871c.e();
        int d10 = this.f14871c.d();
        if (iVar.b() == e10) {
            int b10 = this.f14871c.b();
            int a10 = this.f14871c.a();
            int i10 = e10 / b10;
            int i11 = d10 / a10;
            C0595i iVar2 = new C0595i(i11 * a10, i10 * b10);
            for (int i12 = 0; i12 < i10; i12++) {
                int i13 = i12 * b10;
                for (int i14 = 0; i14 < i11; i14++) {
                    int i15 = i14 * a10;
                    for (int i16 = 0; i16 < b10; i16++) {
                        int i17 = ((b10 + 2) * i12) + 1 + i16;
                        int i18 = i13 + i16;
                        for (int i19 = 0; i19 < a10; i19++) {
                            if (iVar.b(((a10 + 2) * i14) + 1 + i19, i17)) {
                                iVar2.c(i15 + i19, i18);
                            }
                        }
                    }
                }
            }
            return iVar2;
        }
        throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
    }

    private int b(int i10, int i11, int i12, int i13) {
        int i14 = i10 - 2;
        int i15 = i11 - 2;
        int i16 = (a(i14, i15, i12, i13) ? 1 : 0) << 1;
        int i17 = i11 - 1;
        if (a(i14, i17, i12, i13)) {
            i16 |= 1;
        }
        int i18 = i16 << 1;
        int i19 = i10 - 1;
        if (a(i19, i15, i12, i13)) {
            i18 |= 1;
        }
        int i20 = i18 << 1;
        if (a(i19, i17, i12, i13)) {
            i20 |= 1;
        }
        int i21 = i20 << 1;
        if (a(i19, i11, i12, i13)) {
            i21 |= 1;
        }
        int i22 = i21 << 1;
        if (a(i10, i15, i12, i13)) {
            i22 |= 1;
        }
        int i23 = i22 << 1;
        if (a(i10, i17, i12, i13)) {
            i23 |= 1;
        }
        int i24 = i23 << 1;
        return a(i10, i11, i12, i13) ? i24 | 1 : i24;
    }

    private int b(int i10, int i11) {
        int i12 = (a(i10 + (-3), 0, i10, i11) ? 1 : 0) << 1;
        if (a(i10 - 2, 0, i10, i11)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i10 - 1, 0, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(0, i11 - 4, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (a(0, i11 - 3, i10, i11)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        if (a(0, i11 - 2, i10, i11)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        int i18 = i11 - 1;
        if (a(0, i18, i10, i11)) {
            i17 |= 1;
        }
        int i19 = i17 << 1;
        return a(1, i18, i10, i11) ? i19 | 1 : i19;
    }
}
