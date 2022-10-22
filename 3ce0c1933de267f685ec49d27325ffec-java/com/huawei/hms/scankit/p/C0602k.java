package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.m;
/* compiled from: GlobalHistogramBinarizer.java */
/* renamed from: com.huawei.hms.scankit.p.k  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0602k extends AbstractC0583f {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f14842b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private static int f14843c = -1;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f14844d = f14842b;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f14845e = new int[32];

    public C0602k(m mVar) {
        super(mVar);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0583f
    public C0591h a(int i10, C0591h hVar) throws C0550a {
        m c10 = c();
        int c11 = c10.c();
        if (hVar == null || hVar.d() < c11) {
            hVar = new C0591h(c11);
        } else {
            hVar.a();
        }
        a(c11);
        byte[] a10 = c10.a(i10, this.f14844d);
        int[] iArr = this.f14845e;
        for (int i11 = 0; i11 < c11; i11++) {
            int i12 = (a10[i11] & 255) >> 3;
            iArr[i12] = iArr[i12] + 1;
        }
        int a11 = a(iArr, false);
        if (c11 < 3) {
            for (int i13 = 0; i13 < c11; i13++) {
                if ((a10[i13] & 255) < a11) {
                    hVar.d(i13);
                }
            }
        } else {
            int i14 = a10[0] & 255;
            int i15 = a10[1] & 255;
            int i16 = 1;
            while (i16 < c11 - 1) {
                int i17 = i16 + 1;
                int i18 = a10[i17] & 255;
                if ((((i15 * 4) - i14) - i18) / 2 < a11) {
                    hVar.d(i16);
                }
                i14 = i15;
                i16 = i17;
                i15 = i18;
            }
        }
        return hVar;
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0583f
    public C0595i a() throws C0550a {
        m c10 = c();
        int c11 = c10.c();
        int a10 = c10.a();
        a(c11);
        int[] iArr = this.f14845e;
        for (int i10 = 1; i10 < 5; i10++) {
            byte[] a11 = c10.a((a10 * i10) / 5, this.f14844d);
            int i11 = (c11 * 4) / 5;
            for (int i12 = c11 / 5; i12 < i11; i12++) {
                int i13 = (a11[i12] & 255) >> 3;
                iArr[i13] = iArr[i13] + 1;
            }
        }
        int a12 = a(iArr, true);
        byte[] b10 = c10.b();
        int i14 = (c11 + 31) / 32;
        int[] iArr2 = new int[i14 * a10];
        for (int i15 = 0; i15 < a10; i15++) {
            int i16 = i15 * c11;
            for (int i17 = 0; i17 < c11; i17++) {
                if ((b10[i16 + i17] & 255) < a12) {
                    int i18 = (i15 * i14) + (i17 >> 5);
                    iArr2[i18] = iArr2[i18] | (1 << (i17 & 31));
                }
            }
        }
        return new C0595i(c11, a10, i14, iArr2);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0583f
    public AbstractC0583f a(m mVar) {
        return new C0602k(mVar);
    }

    private void a(int i10) {
        if (this.f14844d.length < i10) {
            this.f14844d = new byte[i10];
        }
        for (int i11 = 0; i11 < 32; i11++) {
            this.f14845e[i11] = 0;
        }
    }

    private static int a(int[] iArr, boolean z10) throws C0550a {
        int length = iArr.length;
        boolean z11 = false;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            if (iArr[i13] > i10) {
                i10 = iArr[i13];
                i12 = i13;
            }
            if (iArr[i13] > i11) {
                i11 = iArr[i13];
            }
        }
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            int i17 = i16 - i12;
            int i18 = iArr[i16] * i17 * i17;
            if (i18 > i15) {
                i14 = i16;
                i15 = i18;
            }
        }
        if (i12 <= i14) {
            i14 = i12;
            i12 = i14;
        }
        int i19 = i12 - i14;
        if (i19 > length / 16) {
            int i20 = i12 - 1;
            int i21 = -1;
            int i22 = i20;
            while (i20 > i14) {
                int i23 = i20 - i14;
                int i24 = i23 * i23 * (i12 - i20) * (i11 - iArr[i20]);
                if (i24 > i21) {
                    i22 = i20;
                    i21 = i24;
                }
                i20--;
            }
            if (z10) {
                if (i22 < 10 && i21 < 100000 && i19 < 10) {
                    z11 = true;
                }
                Ka.f14577o = z11;
            }
            return i22 << 3;
        }
        throw C0550a.a();
    }
}
