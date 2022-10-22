package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;
/* compiled from: OneDimensionalCodeWriter.java */
/* renamed from: com.huawei.hms.scankit.p.dc  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0578dc implements AbstractC0648zb {
    public int a() {
        return 10;
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0648zb
    public C0595i a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<tc, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i10 + 'x' + i11);
        } else {
            int a10 = a();
            if (map != null) {
                tc tcVar = tc.MARGIN;
                if (map.containsKey(tcVar)) {
                    try {
                        a10 = Integer.parseInt(map.get(tcVar).toString());
                    } catch (NumberFormatException unused) {
                        throw new IllegalArgumentException("EncodeHintType MARGIN can not format integer");
                    }
                }
            }
            return a(a(str), i10, i11, a10);
        }
    }

    public abstract boolean[] a(String str);

    private static C0595i a(boolean[] zArr, int i10, int i11, int i12) {
        int length = zArr.length;
        int i13 = i12 + length;
        int max = Math.max(i10, i13);
        int max2 = Math.max(1, i11);
        int i14 = max / i13;
        int i15 = (max - (length * i14)) / 2;
        C0595i iVar = new C0595i(max, max2);
        int i16 = 0;
        while (i16 < length) {
            if (zArr[i16]) {
                iVar.a(i15, 0, i14, max2);
            }
            i16++;
            i15 += i14;
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(boolean[] zArr, int i10, int[] iArr, boolean z10) {
        int i11 = 0;
        for (int i12 : iArr) {
            for (int i13 = 0; i13 < i12; i13++) {
                i10++;
                zArr[i10] = z10;
            }
            i11 += i12;
            z10 = !z10;
        }
        return i11;
    }
}
