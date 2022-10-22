package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
/* compiled from: AztecWriter.java */
/* loaded from: classes2.dex */
public final class Ab implements AbstractC0648zb {
    @Override // com.huawei.hms.scankit.p.AbstractC0648zb
    public C0595i a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<tc, ?> map) {
        Charset charset = StandardCharsets.ISO_8859_1;
        int i12 = 33;
        int i13 = 0;
        int i14 = 4;
        if (map != null) {
            tc tcVar = tc.CHARACTER_SET;
            if (map.containsKey(tcVar)) {
                charset = Charset.forName(map.get(tcVar).toString());
            }
            tc tcVar2 = tc.ERROR_CORRECTION;
            if (map.containsKey(tcVar2)) {
                try {
                    i12 = Integer.parseInt(map.get(tcVar2).toString());
                } catch (Exception e10) {
                    throw e10;
                }
            }
            tc tcVar3 = tc.AZTEC_LAYERS;
            if (map.containsKey(tcVar3)) {
                try {
                    i13 = Integer.parseInt(map.get(tcVar3).toString());
                } catch (Exception e11) {
                    throw e11;
                }
            }
            tc tcVar4 = tc.MARGIN;
            if (map.containsKey(tcVar4)) {
                try {
                    i14 = Integer.parseInt(map.get(tcVar4).toString());
                } catch (Exception e12) {
                    throw e12;
                }
            }
        }
        return a(str, barcodeFormat, i10, i11, charset, i12, i13, i14);
    }

    private static C0595i a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Charset charset, int i12, int i13, int i14) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return a(Db.a(str.getBytes(charset), i12, i13), i10, i11, i14);
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can only encode AZTEC, but got ");
            sb2.append(barcodeFormat);
            throw new IllegalArgumentException(sb2.toString());
        } catch (Exception e10) {
            throw e10;
        }
    }

    private static C0595i a(Bb bb2, int i10, int i11, int i12) {
        C0595i a10 = bb2.a();
        if (a10 != null) {
            int d10 = a10.d();
            int b10 = a10.b();
            int i13 = i12 * 2;
            int i14 = d10 + i13;
            int i15 = i13 + b10;
            int max = Math.max(i10, i14);
            int max2 = Math.max(i11, i15);
            int min = Math.min(max / i14, max2 / i15);
            int i16 = (max - (d10 * min)) / 2;
            int i17 = (max2 - (b10 * min)) / 2;
            C0595i iVar = new C0595i(max, max2);
            int i18 = 0;
            while (i18 < b10) {
                int i19 = 0;
                int i20 = i16;
                while (i19 < d10) {
                    if (a10.b(i19, i18)) {
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
        throw new IllegalStateException();
    }
}
