package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.h;
import com.huawei.hms.scankit.aiscan.common.v;
import java.util.Locale;
/* compiled from: Encoder.java */
/* loaded from: classes2.dex */
public final class Db {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14492a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int a(int i10, boolean z10) {
        return ((z10 ? 88 : 112) + (i10 * 16)) * i10;
    }

    public static Bb a(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        boolean z10;
        C0591h hVar;
        int i15;
        int i16;
        C0591h a10 = new Eb(bArr).a();
        int d10 = ((a10.d() * i10) / 100) + 11;
        int d11 = a10.d() + d10;
        int i17 = 32;
        int i18 = 4;
        boolean z11 = 0;
        if (i11 != 0) {
            z10 = i11 < 0;
            i13 = Math.abs(i11);
            if (z10) {
                i17 = 4;
            }
            if (i13 <= i17) {
                i14 = a(i13, z10);
                i12 = f14492a[i13];
                int i19 = i14 - (i14 % i12);
                hVar = a(a10, i12);
                if (hVar.d() + d10 > i19) {
                    try {
                        throw new IllegalArgumentException("Data to large for user specified layer");
                    } catch (Exception e10) {
                        throw e10;
                    }
                } else if (z10 && hVar.d() > i12 * 64) {
                    try {
                        throw new IllegalArgumentException("Data to large for user specified layer");
                    } catch (Exception e11) {
                        throw e11;
                    }
                }
            } else {
                try {
                    throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Illegal value %s for layers", Integer.valueOf(i11)));
                } catch (Exception e12) {
                    throw e12;
                }
            }
        } else {
            C0591h hVar2 = null;
            int i20 = 0;
            int i21 = 0;
            while (i20 <= 32) {
                boolean z12 = i20 <= 3 ? true : z11;
                int i22 = z12 ? i20 + 1 : i20;
                int a11 = a(i22, z12);
                if (d11 <= a11) {
                    if (hVar2 == null || i21 != f14492a[i22]) {
                        int i23 = f14492a[i22];
                        i21 = i23;
                        hVar2 = a(a10, i23);
                    }
                    int i24 = a11 - (a11 % i21);
                    if ((!z12 || hVar2.d() <= i21 * 64) && hVar2.d() + d10 <= i24) {
                        hVar = hVar2;
                        i12 = i21;
                        z10 = z12;
                        i13 = i22;
                        i14 = a11;
                    }
                }
                i20++;
                i18 = 4;
                z11 = 0;
            }
            try {
                throw new IllegalArgumentException("Data too large for an Aztec code");
            } catch (Exception e13) {
                throw e13;
            }
        }
        C0591h b10 = b(hVar, i14, i12);
        int d12 = hVar.d() / i12;
        C0591h a12 = a(z10, i13, d12);
        int i25 = (z10 ? 11 : 14) + (i13 * 4);
        int[] iArr = new int[i25];
        int i26 = 2;
        if (z10) {
            for (int i27 = z11; i27 < i25; i27++) {
                iArr[i27] = i27;
            }
            i15 = i25;
        } else {
            int i28 = i25 / 2;
            i15 = i25 + 1 + (((i28 - 1) / 15) * 2);
            int i29 = i15 / 2;
            for (int i30 = z11; i30 < i28; i30++) {
                iArr[(i28 - i30) - 1] = (i29 - i16) - 1;
                iArr[i28 + i30] = (i30 / 15) + i30 + i29 + 1;
            }
        }
        C0595i iVar = new C0595i(i15);
        int i31 = z11;
        int i32 = i31;
        while (i31 < i13) {
            int i33 = ((i13 - i31) * i18) + (z10 ? 9 : 12);
            int i34 = z11;
            while (i34 < i33) {
                int i35 = i34 * 2;
                while (z11 < i26) {
                    if (b10.a(i32 + i35 + z11)) {
                        int i36 = i31 * 2;
                        iVar.c(iArr[i36 + z11], iArr[i36 + i34]);
                    }
                    if (b10.a((i33 * 2) + i32 + i35 + z11)) {
                        int i37 = i31 * 2;
                        iVar.c(iArr[i37 + i34], iArr[((i25 - 1) - i37) - z11]);
                    }
                    if (b10.a((i33 * 4) + i32 + i35 + z11)) {
                        int i38 = (i25 - 1) - (i31 * 2);
                        iVar.c(iArr[i38 - z11], iArr[i38 - i34]);
                    }
                    if (b10.a((i33 * 6) + i32 + i35 + z11)) {
                        int i39 = i31 * 2;
                        iVar.c(iArr[((i25 - 1) - i39) - i34], iArr[i39 + z11]);
                    }
                    z11++;
                    i26 = 2;
                }
                i34++;
                z11 = 0;
                i26 = 2;
            }
            i32 += i33 * 8;
            i31++;
            i18 = 4;
            z11 = 0;
            i26 = 2;
        }
        a(iVar, z10, i15, a12);
        if (z10) {
            a(iVar, i15 / 2, 5);
        } else {
            int i40 = i15 / 2;
            a(iVar, i40, 7);
            int i41 = 0;
            int i42 = 0;
            while (i41 < (i25 / 2) - 1) {
                for (int i43 = i40 & 1; i43 < i15; i43 += 2) {
                    int i44 = i40 - i42;
                    iVar.c(i44, i43);
                    int i45 = i40 + i42;
                    iVar.c(i45, i43);
                    iVar.c(i43, i44);
                    iVar.c(i43, i45);
                }
                i41 += 15;
                i42 += 16;
            }
        }
        Bb bb2 = new Bb();
        bb2.a(z10);
        bb2.c(i15);
        bb2.b(i13);
        bb2.a(d12);
        bb2.a(iVar);
        return bb2;
    }

    private static C0591h b(C0591h hVar, int i10, int i11) {
        v vVar = new v(a(i11));
        int i12 = i10 / i11;
        int[] a10 = a(hVar, i11, i12);
        vVar.a(a10, i12 - (hVar.d() / i11));
        C0591h hVar2 = new C0591h();
        hVar2.a(0, i10 % i11);
        for (int i13 : a10) {
            hVar2.a(i13, i11);
        }
        return hVar2;
    }

    private static void a(C0595i iVar, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12 += 2) {
            int i13 = i10 - i12;
            int i14 = i13;
            while (true) {
                int i15 = i10 + i12;
                if (i14 <= i15) {
                    iVar.c(i14, i13);
                    iVar.c(i14, i15);
                    iVar.c(i13, i14);
                    iVar.c(i15, i14);
                    i14++;
                }
            }
        }
        int i16 = i10 - i11;
        iVar.c(i16, i16);
        int i17 = i16 + 1;
        iVar.c(i17, i16);
        iVar.c(i16, i17);
        int i18 = i10 + i11;
        iVar.c(i18, i16);
        iVar.c(i18, i17);
        iVar.c(i18, i18 - 1);
    }

    static C0591h a(boolean z10, int i10, int i11) {
        C0591h hVar = new C0591h();
        if (z10) {
            hVar.a(i10 - 1, 2);
            hVar.a(i11 - 1, 6);
            return b(hVar, 28, 4);
        }
        hVar.a(i10 - 1, 5);
        hVar.a(i11 - 1, 11);
        return b(hVar, 40, 4);
    }

    private static void a(C0595i iVar, boolean z10, int i10, C0591h hVar) {
        int i11 = i10 / 2;
        int i12 = 0;
        if (z10) {
            while (i12 < 7) {
                int i13 = (i11 - 3) + i12;
                if (hVar.a(i12)) {
                    iVar.c(i13, i11 - 5);
                }
                if (hVar.a(i12 + 7)) {
                    iVar.c(i11 + 5, i13);
                }
                if (hVar.a(20 - i12)) {
                    iVar.c(i13, i11 + 5);
                }
                if (hVar.a(27 - i12)) {
                    iVar.c(i11 - 5, i13);
                }
                i12++;
            }
            return;
        }
        while (i12 < 10) {
            int i14 = (i11 - 5) + i12 + (i12 / 5);
            if (hVar.a(i12)) {
                iVar.c(i14, i11 - 7);
            }
            if (hVar.a(i12 + 10)) {
                iVar.c(i11 + 7, i14);
            }
            if (hVar.a(29 - i12)) {
                iVar.c(i14, i11 + 7);
            }
            if (hVar.a(39 - i12)) {
                iVar.c(i11 - 7, i14);
            }
            i12++;
        }
    }

    private static int[] a(C0591h hVar, int i10, int i11) {
        int[] iArr = new int[i11];
        int d10 = hVar.d() / i10;
        for (int i12 = 0; i12 < d10; i12++) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                i13 |= hVar.a((i12 * i10) + i14) ? 1 << ((i10 - i14) - 1) : 0;
            }
            iArr[i12] = i13;
        }
        return iArr;
    }

    private static h a(int i10) {
        if (i10 == 4) {
            return h.f14223d;
        }
        if (i10 == 6) {
            return h.f14222c;
        }
        if (i10 == 8) {
            return h.f14226g;
        }
        if (i10 == 10) {
            return h.f14221b;
        }
        if (i10 == 12) {
            return h.f14220a;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unsupported word size ");
            sb2.append(i10);
            throw new IllegalArgumentException(sb2.toString());
        } catch (Exception e10) {
            throw e10;
        }
    }

    static C0591h a(C0591h hVar, int i10) {
        C0591h hVar2 = new C0591h();
        int d10 = hVar.d();
        int i11 = (1 << i10) - 2;
        int i12 = 0;
        while (i12 < d10) {
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int i15 = i12 + i14;
                if (i15 >= d10 || hVar.a(i15)) {
                    i13 |= 1 << ((i10 - 1) - i14);
                }
            }
            int i16 = i13 & i11;
            if (i16 == i11) {
                hVar2.a(i16, i10);
            } else if (i16 == 0) {
                hVar2.a(i13 | 1, i10);
            } else {
                hVar2.a(i13, i10);
                i12 += i10;
            }
            i12--;
            i12 += i10;
        }
        return hVar2;
    }
}
