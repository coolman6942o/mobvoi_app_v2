package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.nio.charset.Charset;
import java.util.Map;
/* compiled from: PDF417Writer.java */
/* renamed from: com.huawei.hms.scankit.p.hc  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0594hc implements AbstractC0648zb {
    @Override // com.huawei.hms.scankit.p.AbstractC0648zb
    public C0595i a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<tc, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.PDF_417) {
            mc mcVar = new mc();
            int i12 = 30;
            int i13 = 2;
            if (map != null) {
                tc tcVar = tc.PDF417_COMPACT;
                if (map.containsKey(tcVar)) {
                    mcVar.a(Boolean.valueOf(map.get(tcVar).toString()).booleanValue());
                }
                tc tcVar2 = tc.PDF417_COMPACTION;
                if (map.containsKey(tcVar2)) {
                    mcVar.a(kc.valueOf(map.get(tcVar2).toString()));
                }
                tc tcVar3 = tc.PDF417_DIMENSIONS;
                if (map.containsKey(tcVar3)) {
                    lc lcVar = (lc) map.get(tcVar3);
                    mcVar.a(lcVar.a(), lcVar.c(), lcVar.b(), lcVar.d());
                }
                tc tcVar4 = tc.MARGIN;
                if (map.containsKey(tcVar4)) {
                    try {
                        i12 = Integer.parseInt(map.get(tcVar4).toString());
                    } catch (Exception e10) {
                        throw e10;
                    }
                }
                tc tcVar5 = tc.ERROR_CORRECTION;
                if (map.containsKey(tcVar5)) {
                    try {
                        i13 = Integer.parseInt(map.get(tcVar5).toString());
                    } catch (Exception e11) {
                        throw e11;
                    }
                }
                tc tcVar6 = tc.CHARACTER_SET;
                if (map.containsKey(tcVar6)) {
                    mcVar.a(Charset.forName(map.get(tcVar6).toString()));
                }
            }
            return a(mcVar, str, i13, i10, i11, i12);
        }
        throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
    }

    private static C0595i a(mc mcVar, String str, int i10, int i11, int i12, int i13) throws WriterException {
        mcVar.a(str, i10);
        byte[][] a10 = mcVar.a().a(1, 4);
        int length = i11 / a10[0].length;
        int length2 = i12 / a10.length;
        if (length >= length2) {
            length = length2;
        }
        if (length > 1) {
            return a(mcVar.a().a(length, length * 4), i13);
        }
        return a(a10, i13);
    }

    private static C0595i a(byte[][] bArr, int i10) {
        int i11 = i10 * 2;
        C0595i iVar = new C0595i(bArr[0].length + i11, bArr.length + i11);
        iVar.a();
        int b10 = (iVar.b() - i10) - 1;
        int i12 = 0;
        while (i12 < bArr.length) {
            byte[] bArr2 = bArr[i12];
            for (int i13 = 0; i13 < bArr[0].length; i13++) {
                if (bArr2[i13] == 1) {
                    iVar.c(i13 + i10, b10);
                }
            }
            i12++;
            b10--;
        }
        return iVar;
    }
}
