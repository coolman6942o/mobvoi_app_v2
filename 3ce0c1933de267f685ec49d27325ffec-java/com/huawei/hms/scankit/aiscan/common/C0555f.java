package com.huawei.hms.scankit.aiscan.common;

import com.huawei.hms.scankit.p.C0595i;
import com.huawei.hms.scankit.p.Ka;
/* compiled from: DefaultGridSampler.java */
/* renamed from: com.huawei.hms.scankit.aiscan.common.f  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0555f extends j {
    @Override // com.huawei.hms.scankit.aiscan.common.j
    public C0595i a(C0595i iVar, int i10, int i11, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25) throws C0550a {
        return a(iVar, i10, i11, q.a(f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f25), false);
    }

    public C0595i b(C0595i iVar, int i10, int i11, q qVar) throws C0550a {
        if (i10 <= 0 || i11 <= 0) {
            throw C0550a.a();
        }
        C0595i iVar2 = new C0595i(i10, i11);
        int i12 = i10 * 2;
        float[] fArr = new float[i12];
        for (int i13 = 0; i13 < i11; i13++) {
            float f10 = i13 + 0.5f;
            for (int i14 = 0; i14 < i12; i14 += 2) {
                fArr[i14] = (i14 / 2) + 0.5f;
                fArr[i14 + 1] = f10;
            }
            if (!Ka.f14573k || !Ka.f14570h) {
                qVar.a(fArr);
            } else {
                qVar.b(fArr);
            }
            int d10 = iVar.d();
            int b10 = iVar.b();
            for (int i15 = 0; i15 < i12; i15 += 2) {
                try {
                    int i16 = (int) fArr[i15];
                    int i17 = (int) fArr[i15 + 1];
                    if (i16 >= -1 && i16 <= d10 && i17 >= -1 && i17 <= b10) {
                        if (iVar.b(i16, i17)) {
                            iVar2.c(i15 / 2, i13);
                        }
                    }
                    iVar2.c(i15 / 2, i13);
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw C0550a.a();
                }
            }
        }
        return iVar2;
    }

    @Override // com.huawei.hms.scankit.aiscan.common.j
    public C0595i a(C0595i iVar, int i10, int i11, q qVar, boolean z10) throws C0550a {
        boolean z11 = Ka.f14571i;
        if ((z11 && z10) || (!z11 && !z10) || Ka.f14578p) {
            return b(iVar, i10, i11, qVar);
        }
        return a(iVar, i10, i11, qVar);
    }

    public C0595i a(C0595i iVar, int i10, int i11, q qVar) throws C0550a {
        if (i10 <= 0 || i11 <= 0) {
            throw C0550a.a();
        }
        C0595i iVar2 = new C0595i(i10, i11);
        float[] fArr = new float[10];
        float f10 = 0.5f;
        int i12 = 0;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = i12;
            while (i14 < i10) {
                float f11 = i14;
                fArr[i12] = (f11 - 0.2f) + f10;
                float f12 = i13;
                float f13 = f12 + f10;
                fArr[1] = f13;
                fArr[2] = f11 + 0.2f + f10;
                fArr[3] = f13;
                float f14 = f11 + f10;
                fArr[4] = f14;
                fArr[5] = (f12 - 0.2f) + f10;
                fArr[6] = f14;
                fArr[7] = f12 + 0.2f + f10;
                fArr[8] = f14;
                fArr[9] = f13;
                if (!Ka.f14573k || !Ka.f14570h) {
                    qVar.a(fArr);
                } else {
                    qVar.b(fArr);
                }
                int d10 = iVar.d();
                int b10 = iVar.b();
                int i15 = i12;
                int i16 = i15;
                while (i15 < 5) {
                    int i17 = i15 * 2;
                    try {
                        int i18 = (int) fArr[i17];
                        int i19 = (int) fArr[i17 + 1];
                        if (i18 >= -1 && i18 <= d10 && i19 >= -1 && i19 <= b10) {
                            if (iVar.b(i18, i19)) {
                                i16++;
                            }
                            i15++;
                        }
                        i15++;
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw C0550a.a();
                    }
                }
                if (i16 >= 3) {
                    iVar2.c(i14, i13);
                }
                i14++;
                f10 = 0.5f;
                i12 = 0;
            }
            i13++;
            f10 = 0.5f;
            i12 = 0;
        }
        return iVar2;
    }
}
