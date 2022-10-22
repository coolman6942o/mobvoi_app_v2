package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;
/* compiled from: QRCodeWriter.java */
/* loaded from: classes2.dex */
public final class qc implements AbstractC0648zb {
    @Override // com.huawei.hms.scankit.p.AbstractC0648zb
    public C0595i a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<tc, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        } else if (i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i10 + 'x' + i11);
        } else {
            EnumC0647za zaVar = EnumC0647za.L;
            int i12 = 4;
            Boolean bool = Boolean.FALSE;
            if (map != null) {
                tc tcVar = tc.ERROR_CORRECTION;
                if (map.containsKey(tcVar)) {
                    zaVar = EnumC0647za.valueOf(map.get(tcVar).toString());
                }
                tc tcVar2 = tc.MARGIN;
                if (map.containsKey(tcVar2)) {
                    try {
                        i12 = Integer.parseInt(map.get(tcVar2).toString());
                    } catch (Exception e10) {
                        throw e10;
                    }
                }
                tc tcVar3 = tc.LOGO;
                if (map.containsKey(tcVar3)) {
                    try {
                        bool = (Boolean) map.get(tcVar3);
                    } catch (Exception e11) {
                        throw e11;
                    }
                }
            }
            return a(vc.a(str, zaVar, map), i10, i11, i12, bool.booleanValue());
        }
    }

    private static C0595i a(yc ycVar, int i10, int i11, int i12, boolean z10) {
        int i13;
        int i14;
        int i15;
        sc a10 = ycVar.a();
        if (a10 != null) {
            int c10 = a10.c();
            int b10 = a10.b();
            if (z10) {
                i15 = Math.max(i10, c10);
                i14 = Math.max(i11, b10);
                int i16 = i12 * 2;
                i13 = Math.min((i15 - i16) / c10, (i14 - i16) / b10);
            } else {
                int i17 = i12 * 2;
                int i18 = c10 + i17;
                int i19 = i17 + b10;
                i15 = Math.max(i10, i18);
                i14 = Math.max(i11, i19);
                i13 = Math.min(i15 / i18, i14 / i19);
            }
            int i20 = (i15 - (c10 * i13)) / 2;
            int i21 = (i14 - (b10 * i13)) / 2;
            C0595i iVar = new C0595i(i15, i14);
            int i22 = 0;
            while (i22 < b10) {
                int i23 = 0;
                int i24 = i20;
                while (i23 < c10) {
                    if (a10.a(i23, i22) == 1) {
                        iVar.a(i24, i21, i13, i13);
                    }
                    i23++;
                    i24 += i13;
                }
                i22++;
                i21 += i13;
            }
            return iVar;
        }
        throw new IllegalStateException();
    }
}
