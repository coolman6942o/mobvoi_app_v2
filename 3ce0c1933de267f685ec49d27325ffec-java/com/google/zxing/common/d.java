package com.google.zxing.common;

import com.google.zxing.NotFoundException;
import com.google.zxing.a;
import com.google.zxing.c;
/* compiled from: GlobalHistogramBinarizer.java */
/* loaded from: classes.dex */
public class d extends a {

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f13412d = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private byte[] f13413b = f13412d;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f13414c = new int[32];

    public d(c cVar) {
        super(cVar);
    }

    private static int g(int[] iArr) throws NotFoundException {
        int length = iArr.length;
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
        if (i12 - i14 > length / 16) {
            int i19 = i12 - 1;
            int i20 = -1;
            int i21 = i19;
            while (i19 > i14) {
                int i22 = i19 - i14;
                int i23 = i22 * i22 * (i12 - i19) * (i11 - iArr[i19]);
                if (i23 > i20) {
                    i21 = i19;
                    i20 = i23;
                }
                i19--;
            }
            return i21 << 3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void h(int i10) {
        if (this.f13413b.length < i10) {
            this.f13413b = new byte[i10];
        }
        for (int i11 = 0; i11 < 32; i11++) {
            this.f13414c[i11] = 0;
        }
    }

    @Override // com.google.zxing.a
    public b b() throws NotFoundException {
        c e10 = e();
        int d10 = e10.d();
        int a10 = e10.a();
        b bVar = new b(d10, a10);
        h(d10);
        int[] iArr = this.f13414c;
        for (int i10 = 1; i10 < 5; i10++) {
            byte[] c10 = e10.c((a10 * i10) / 5, this.f13413b);
            int i11 = (d10 << 2) / 5;
            for (int i12 = d10 / 5; i12 < i11; i12++) {
                int i13 = (c10[i12] & 255) >> 3;
                iArr[i13] = iArr[i13] + 1;
            }
        }
        int g10 = g(iArr);
        byte[] b10 = e10.b();
        for (int i14 = 0; i14 < a10; i14++) {
            int i15 = i14 * d10;
            for (int i16 = 0; i16 < d10; i16++) {
                if ((b10[i15 + i16] & 255) < g10) {
                    bVar.m(i16, i14);
                }
            }
        }
        return bVar;
    }

    @Override // com.google.zxing.a
    public a c(int i10, a aVar) throws NotFoundException {
        c e10 = e();
        int d10 = e10.d();
        if (aVar == null || aVar.g() < d10) {
            aVar = new a(d10);
        } else {
            aVar.a();
        }
        h(d10);
        byte[] c10 = e10.c(i10, this.f13413b);
        int[] iArr = this.f13414c;
        for (int i11 = 0; i11 < d10; i11++) {
            int i12 = (c10[i11] & 255) >> 3;
            iArr[i12] = iArr[i12] + 1;
        }
        int g10 = g(iArr);
        if (d10 < 3) {
            for (int i13 = 0; i13 < d10; i13++) {
                if ((c10[i13] & 255) < g10) {
                    aVar.l(i13);
                }
            }
        } else {
            int i14 = c10[0] & 255;
            int i15 = c10[1] & 255;
            int i16 = 1;
            while (i16 < d10 - 1) {
                int i17 = i16 + 1;
                int i18 = c10[i17] & 255;
                if ((((i15 << 2) - i14) - i18) / 2 < g10) {
                    aVar.l(i16);
                }
                i14 = i15;
                i16 = i17;
                i15 = i18;
            }
        }
        return aVar;
    }
}
