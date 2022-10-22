package com.google.zxing.common;

import com.google.zxing.NotFoundException;
import o8.d;
/* compiled from: GridSampler.java */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f13415a = new c();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(b bVar, float[] fArr) throws NotFoundException {
        int k10 = bVar.k();
        int g10 = bVar.g();
        boolean z10 = true;
        for (int i10 = 0; i10 < fArr.length && z10; i10 += 2) {
            int i11 = (int) fArr[i10];
            int i12 = i10 + 1;
            int i13 = (int) fArr[i12];
            if (i11 < -1 || i11 > k10 || i13 < -1 || i13 > g10) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i11 == -1) {
                fArr[i10] = 0.0f;
            } else if (i11 == k10) {
                fArr[i10] = k10 - 1;
            } else {
                z10 = false;
                if (i13 != -1) {
                    fArr[i12] = 0.0f;
                } else if (i13 == g10) {
                    fArr[i12] = g10 - 1;
                }
                z10 = true;
            }
            z10 = true;
            if (i13 != -1) {
            }
            z10 = true;
        }
        boolean z11 = true;
        for (int length = fArr.length - 2; length >= 0 && z11; length -= 2) {
            int i14 = (int) fArr[length];
            int i15 = length + 1;
            int i16 = (int) fArr[i15];
            if (i14 < -1 || i14 > k10 || i16 < -1 || i16 > g10) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i14 == -1) {
                fArr[length] = 0.0f;
            } else if (i14 == k10) {
                fArr[length] = k10 - 1;
            } else {
                z11 = false;
                if (i16 != -1) {
                    fArr[i15] = 0.0f;
                } else if (i16 == g10) {
                    fArr[i15] = g10 - 1;
                }
                z11 = true;
            }
            z11 = true;
            if (i16 != -1) {
            }
            z11 = true;
        }
    }

    public static e b() {
        return f13415a;
    }

    public abstract b c(b bVar, int i10, int i11, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25) throws NotFoundException;

    public abstract b d(b bVar, int i10, int i11, d dVar) throws NotFoundException;
}
