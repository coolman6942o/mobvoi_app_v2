package com.google.zxing.common;

import com.google.zxing.NotFoundException;
import com.google.zxing.a;
import com.google.zxing.c;
import java.lang.reflect.Array;
/* compiled from: HybridBinarizer.java */
/* loaded from: classes.dex */
public final class f extends d {

    /* renamed from: e  reason: collision with root package name */
    private b f13416e;

    public f(c cVar) {
        super(cVar);
    }

    private static int[][] i(byte[] bArr, int i10, int i11, int i12, int i13) {
        char c10;
        char c11 = 2;
        boolean z10 = true;
        int i14 = 0;
        int[][] iArr = (int[][]) Array.newInstance(int.class, i11, i10);
        int i15 = 0;
        while (i15 < i11) {
            int i16 = i15 << 3;
            int i17 = i13 - 8;
            if (i16 > i17) {
                i16 = i17;
            }
            int i18 = i14;
            while (i18 < i10) {
                int i19 = i18 << 3;
                int i20 = i12 - 8;
                if (i19 > i20) {
                    i19 = i20;
                }
                int i21 = (i16 * i12) + i19;
                int i22 = i14;
                int i23 = i22;
                int i24 = i23;
                int i25 = 255;
                while (i22 < 8) {
                    for (int i26 = 0; i26 < 8; i26++) {
                        int i27 = bArr[i21 + i26] & 255;
                        i23 += i27;
                        if (i27 < i25) {
                            i25 = i27;
                        }
                        if (i27 > i24) {
                            i24 = i27;
                        }
                    }
                    if (i24 - i25 <= 24) {
                        i22++;
                        i21 += i12;
                        z10 = true;
                    }
                    while (true) {
                        i22++;
                        i21 += i12;
                        if (i22 < 8) {
                            for (int i28 = 0; i28 < 8; i28++) {
                                i23 += bArr[i21 + i28] & 255;
                            }
                        }
                    }
                    i22++;
                    i21 += i12;
                    z10 = true;
                }
                z10 = z10;
                int i29 = i23 >> 6;
                if (i24 - i25 <= 24) {
                    i29 = i25 / 2;
                    if (i15 > 0 && i18 > 0) {
                        int i30 = i15 - 1;
                        int i31 = i18 - 1;
                        c10 = 2;
                        int i32 = ((iArr[i30][i18] + (iArr[i15][i31] * 2)) + iArr[i30][i31]) / 4;
                        if (i25 < i32) {
                            i29 = i32;
                        }
                        iArr[i15][i18] = i29;
                        i18++;
                        c11 = c10;
                        i14 = 0;
                    }
                }
                c10 = 2;
                iArr[i15][i18] = i29;
                i18++;
                c11 = c10;
                i14 = 0;
            }
            c11 = c11;
            i15++;
            i14 = 0;
        }
        return iArr;
    }

    private static void j(byte[] bArr, int i10, int i11, int i12, int i13, int[][] iArr, b bVar) {
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = i14 << 3;
            int i16 = i13 - 8;
            if (i15 > i16) {
                i15 = i16;
            }
            for (int i17 = 0; i17 < i10; i17++) {
                int i18 = i17 << 3;
                int i19 = i12 - 8;
                if (i18 <= i19) {
                    i19 = i18;
                }
                int k10 = k(i17, 2, i10 - 3);
                int k11 = k(i14, 2, i11 - 3);
                int i20 = 0;
                for (int i21 = -2; i21 <= 2; i21++) {
                    int[] iArr2 = iArr[k11 + i21];
                    i20 += iArr2[k10 - 2] + iArr2[k10 - 1] + iArr2[k10] + iArr2[k10 + 1] + iArr2[k10 + 2];
                }
                l(bArr, i19, i15, i20 / 25, i12, bVar);
            }
        }
    }

    private static int k(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    private static void l(byte[] bArr, int i10, int i11, int i12, int i13, b bVar) {
        int i14 = (i11 * i13) + i10;
        int i15 = 0;
        while (i15 < 8) {
            for (int i16 = 0; i16 < 8; i16++) {
                if ((bArr[i14 + i16] & 255) <= i12) {
                    bVar.m(i10 + i16, i11 + i15);
                }
            }
            i15++;
            i14 += i13;
        }
    }

    @Override // com.google.zxing.a
    public a a(c cVar) {
        return new f(cVar);
    }

    @Override // com.google.zxing.common.d, com.google.zxing.a
    public b b() throws NotFoundException {
        b bVar = this.f13416e;
        if (bVar != null) {
            return bVar;
        }
        c e10 = e();
        int d10 = e10.d();
        int a10 = e10.a();
        if (d10 < 40 || a10 < 40) {
            this.f13416e = super.b();
        } else {
            byte[] b10 = e10.b();
            int i10 = d10 >> 3;
            if ((d10 & 7) != 0) {
                i10++;
            }
            int i11 = i10;
            int i12 = a10 >> 3;
            if ((a10 & 7) != 0) {
                i12++;
            }
            int i13 = i12;
            int[][] i14 = i(b10, i11, i13, d10, a10);
            b bVar2 = new b(d10, a10);
            j(b10, i11, i13, d10, a10, i14, bVar2);
            this.f13416e = bVar2;
        }
        return this.f13416e;
    }
}
