package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.m;
import java.lang.reflect.Array;
/* compiled from: HybridBinarizer.java */
/* renamed from: com.huawei.hms.scankit.p.l  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0605l extends C0602k {

    /* renamed from: f  reason: collision with root package name */
    private static int f14857f = 3;

    /* renamed from: g  reason: collision with root package name */
    private static int f14858g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static int f14859h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static int f14860i = 0;

    /* renamed from: j  reason: collision with root package name */
    private static int f14861j = 24;

    /* renamed from: k  reason: collision with root package name */
    private C0595i f14862k;

    static {
        int i10 = 1 << f14857f;
        f14858g = i10;
        f14859h = i10 - 1;
        f14860i = i10 * 5;
    }

    public C0605l(m mVar) {
        super(mVar);
        a(Ka.f14571i);
    }

    private static int a(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    private void a(boolean z10) {
        if (z10) {
            f14857f = 2;
            int i10 = 1 << 2;
            f14858g = i10;
            f14859h = i10 - 1;
            f14860i = i10 * 5;
            return;
        }
        f14857f = 3;
        int i11 = 1 << 3;
        f14858g = i11;
        f14859h = i11 - 1;
        f14860i = i11 * 5;
    }

    @Override // com.huawei.hms.scankit.p.C0602k, com.huawei.hms.scankit.p.AbstractC0583f
    public C0595i a() throws C0550a {
        C0595i iVar = this.f14862k;
        if (iVar != null) {
            return iVar;
        }
        m c10 = c();
        int c11 = c10.c();
        int a10 = c10.a();
        int i10 = f14860i;
        if (c11 < i10 || a10 < i10) {
            this.f14862k = super.a();
        } else {
            byte[] b10 = c10.b();
            int i11 = f14857f;
            int i12 = c11 >> i11;
            int i13 = f14859h;
            if ((c11 & i13) != 0) {
                i12++;
            }
            int i14 = a10 >> i11;
            if ((i13 & a10) != 0) {
                i14++;
            }
            int i15 = i14;
            this.f14862k = a(b10, i12, i15, c11, a10, a(b10, i12, i15, c11, a10));
        }
        return this.f14862k;
    }

    @Override // com.huawei.hms.scankit.p.C0602k, com.huawei.hms.scankit.p.AbstractC0583f
    public AbstractC0583f a(m mVar) {
        return new C0605l(mVar);
    }

    private static C0595i a(byte[] bArr, int i10, int i11, int i12, int i13, int[][] iArr) {
        int i14;
        int i15;
        int i16;
        int[] iArr2 = new int[i10 * i11];
        for (int i17 = 0; i17 < i11; i17++) {
            int a10 = a(i17, 2, i11 - 3);
            for (int i18 = 0; i18 < i10; i18++) {
                int a11 = a(i18, 2, i10 - 3);
                int i19 = a10 + 2;
                int i20 = a11 + 2;
                int i21 = iArr[i19][i20];
                if (a10 == 2 && a11 == 2) {
                    i16 = 0;
                    i15 = 0;
                } else {
                    if (a10 == 2) {
                        i15 = iArr[i19][a11 - 3];
                        i14 = 0;
                        i16 = 0;
                    } else if (a11 == 2) {
                        i16 = iArr[a10 - 3][i20];
                        i15 = 0;
                    } else {
                        int i22 = a10 - 3;
                        int i23 = a11 - 3;
                        i14 = iArr[i22][i23];
                        i16 = iArr[i22][i20];
                        i15 = iArr[i19][i23];
                    }
                    iArr2[(i17 * i10) + i18] = (((i21 + i14) - i16) - i15) / 25;
                }
                i14 = i15;
                iArr2[(i17 * i10) + i18] = (((i21 + i14) - i16) - i15) / 25;
            }
        }
        return new C0595i(i12, i13, (i12 + 31) / 32, a(bArr, iArr2, i10, i11, i12, i13));
    }

    private static int[] a(byte[] bArr, int[] iArr, int i10, int i11, int i12, int i13) {
        int i14;
        int i15 = (i12 + 31) / 32;
        int i16 = i15 * i13;
        int[] iArr2 = new int[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            iArr2[i17] = 0;
        }
        int i18 = f14858g;
        for (int i19 = 0; i19 < i13; i19++) {
            int i20 = i19 / i18;
            for (int i21 = 0; i21 < i12; i21++) {
                if ((bArr[(i19 * i12) + i21] & 255) <= iArr[(i20 * i10) + (i21 / i18)] && (i14 = (i19 * i15) + (i21 / 32)) < i16) {
                    iArr2[i14] = iArr2[i14] | (1 << (i21 & 31));
                }
            }
        }
        return iArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
        if (r9 < r14) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int[][] a(byte[] bArr, int i10, int i11, int i12, int i13) {
        int i14;
        int i15 = f14858g;
        int i16 = i13 - i15;
        int i17 = i12 - i15;
        char c10 = 1;
        int i18 = 0;
        int[][] iArr = (int[][]) Array.newInstance(int.class, i11, i10);
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, i11, i10);
        int i19 = 0;
        while (i19 < i11) {
            int i20 = i19 << f14857f;
            if (i20 > i16) {
                i20 = i16;
            }
            int i21 = i18;
            int i22 = i21;
            while (i21 < i10) {
                int i23 = i21 << f14857f;
                if (i23 > i17) {
                    i23 = i17;
                }
                int[] a10 = a(i23, i20, i12, bArr);
                int i24 = a10[i18];
                int i25 = a10[c10];
                int i26 = a10[2];
                int i27 = i24 >> (f14857f * 2);
                if (i26 - i25 <= f14861j) {
                    i27 = i25 / 2;
                    if (i19 > 0 && i21 > 0) {
                        int i28 = i19 - 1;
                        int i29 = i21 - 1;
                        i14 = ((iArr2[i28][i21] + (iArr2[i19][i29] * 2)) + iArr2[i28][i29]) / 4;
                    }
                }
                i14 = i27;
                i22 += i14;
                iArr2[i19][i21] = i14;
                if (i19 == 0 && i21 == 0) {
                    iArr[i19][i21] = i14;
                } else if (i19 == 0) {
                    iArr[i19][i21] = i22;
                } else {
                    iArr[i19][i21] = iArr[i19 - 1][i21] + i22;
                }
                i21++;
                c10 = 1;
                i18 = 0;
            }
            i19++;
            c10 = 1;
            i18 = 0;
        }
        return iArr;
    }

    private static int[] a(int i10, int i11, int i12, byte[] bArr) {
        int i13 = (i11 * i12) + i10;
        int i14 = 255;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i15 < f14858g) {
            for (int i18 = 0; i18 < f14858g; i18++) {
                int i19 = bArr[i13 + i18] & 255;
                i16 += i19;
                if (i19 < i14) {
                    i14 = i19;
                }
                if (i19 > i17) {
                    i17 = i19;
                }
            }
            if (i17 - i14 <= f14861j) {
                i15++;
                i13 += i12;
            }
            while (true) {
                i15++;
                i13 += i12;
                if (i15 < f14858g) {
                    for (int i20 = 0; i20 < f14858g; i20++) {
                        i16 += bArr[i13 + i20] & 255;
                    }
                }
            }
            i15++;
            i13 += i12;
        }
        return new int[]{i16, i14, i17};
    }
}
