package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;
/* compiled from: DataMatrixWriter.java */
/* loaded from: classes2.dex */
public final class Ib implements AbstractC0648zb {
    @Override // com.huawei.hms.scankit.p.AbstractC0648zb
    public C0595i a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<tc, ?> map) {
        C0639wb wbVar;
        if (str.isEmpty()) {
            try {
                throw new IllegalArgumentException("Found empty contents");
            } catch (Exception e10) {
                throw e10;
            }
        } else if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Can only encode DATA_MATRIX, but got ");
                sb2.append(barcodeFormat);
                throw new IllegalArgumentException(sb2.toString());
            } catch (Exception e11) {
                throw e11;
            }
        } else if (i10 < 0 || i11 < 0) {
            try {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Requested dimensions can't be negative: ");
                sb3.append(i10);
                sb3.append('x');
                sb3.append(i11);
                throw new IllegalArgumentException(sb3.toString());
            } catch (Exception e12) {
                throw e12;
            }
        } else {
            Ub ub2 = Ub.FORCE_SQUARE;
            int i12 = 4;
            C0639wb wbVar2 = null;
            if (map != null) {
                Ub ub3 = (Ub) map.get(tc.DATA_MATRIX_SHAPE);
                if (ub3 != null) {
                    ub2 = ub3;
                }
                C0639wb wbVar3 = (C0639wb) map.get(tc.MIN_SIZE);
                if (wbVar3 == null) {
                    wbVar3 = null;
                }
                C0639wb wbVar4 = (C0639wb) map.get(tc.MAX_SIZE);
                if (wbVar4 != null) {
                    wbVar2 = wbVar4;
                }
                tc tcVar = tc.MARGIN;
                if (map.containsKey(tcVar)) {
                    try {
                        i12 = Integer.parseInt(map.get(tcVar).toString());
                    } catch (Exception e13) {
                        throw e13;
                    }
                }
                wbVar = wbVar2;
                wbVar2 = wbVar3;
            } else {
                wbVar = null;
            }
            String a10 = Sb.a(str, ub2, wbVar2, wbVar);
            Tb a11 = Tb.a(a10.length(), ub2, wbVar2, wbVar, true);
            Nb nb2 = new Nb(Rb.a(a10, a11), a11.e(), a11.d());
            nb2.a();
            return a(nb2, a11, i10, i11, i12);
        }
    }

    private static C0595i a(Nb nb2, Tb tb2, int i10, int i11, int i12) {
        int e10 = tb2.e();
        int d10 = tb2.d();
        sc scVar = new sc(tb2.g(), tb2.f());
        int i13 = 0;
        for (int i14 = 0; i14 < d10; i14++) {
            if (i14 % tb2.f14678g == 0) {
                int i15 = 0;
                for (int i16 = 0; i16 < tb2.g(); i16++) {
                    scVar.a(i15, i13, i16 % 2 == 0);
                    i15++;
                }
                i13++;
            }
            int i17 = 0;
            for (int i18 = 0; i18 < e10; i18++) {
                if (i18 % tb2.f14677f == 0) {
                    scVar.a(i17, i13, true);
                    i17++;
                }
                scVar.a(i17, i13, nb2.a(i18, i14));
                i17++;
                int i19 = tb2.f14677f;
                if (i18 % i19 == i19 - 1) {
                    scVar.a(i17, i13, i14 % 2 == 0);
                    i17++;
                }
            }
            i13++;
            int i20 = tb2.f14678g;
            if (i14 % i20 == i20 - 1) {
                int i21 = 0;
                for (int i22 = 0; i22 < tb2.g(); i22++) {
                    scVar.a(i21, i13, true);
                    i21++;
                }
                i13++;
            }
        }
        return a(scVar, i10, i11, i12);
    }

    private static C0595i a(sc scVar, int i10, int i11, int i12) {
        C0595i iVar;
        int c10 = scVar.c();
        int b10 = scVar.b();
        int i13 = i12 * 2;
        int i14 = c10 + i13;
        int i15 = i13 + b10;
        int max = Math.max(i10, i14);
        int max2 = Math.max(i11, i15);
        int min = Math.min(max / i14, max2 / i15);
        int i16 = (max - (c10 * min)) / 2;
        int i17 = (max2 - (b10 * min)) / 2;
        if (i11 < b10 || i10 < c10) {
            iVar = new C0595i(c10, b10);
            i16 = 0;
            i17 = 0;
        } else {
            iVar = new C0595i(i10, i11);
        }
        iVar.a();
        int i18 = 0;
        while (i18 < b10) {
            int i19 = 0;
            int i20 = i16;
            while (i19 < c10) {
                if (scVar.a(i19, i18) == 1) {
                    iVar.a(i20, i17, min, min);
                }
                i19++;
                i20 += min;
            }
            i18++;
            i17 += min;
        }
        return iVar;
    }
}
