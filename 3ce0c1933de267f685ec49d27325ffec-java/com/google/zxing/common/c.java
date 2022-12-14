package com.google.zxing.common;

import com.google.zxing.NotFoundException;
import o8.d;
/* compiled from: DefaultGridSampler.java */
/* loaded from: classes.dex */
public final class c extends e {
    @Override // com.google.zxing.common.e
    public b c(b bVar, int i10, int i11, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25) throws NotFoundException {
        return d(bVar, i10, i11, d.b(f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f25));
    }

    @Override // com.google.zxing.common.e
    public b d(b bVar, int i10, int i11, d dVar) throws NotFoundException {
        if (i10 <= 0 || i11 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        b bVar2 = new b(i10, i11);
        int i12 = i10 * 2;
        float[] fArr = new float[i12];
        for (int i13 = 0; i13 < i11; i13++) {
            float f10 = i13 + 0.5f;
            for (int i14 = 0; i14 < i12; i14 += 2) {
                fArr[i14] = (i14 / 2) + 0.5f;
                fArr[i14 + 1] = f10;
            }
            dVar.f(fArr);
            e.a(bVar, fArr);
            for (int i15 = 0; i15 < i12; i15 += 2) {
                try {
                    if (bVar.d((int) fArr[i15], (int) fArr[i15 + 1])) {
                        bVar2.m(i15 / 2, i13);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
        return bVar2;
    }
}
