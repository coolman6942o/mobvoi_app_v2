package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;
/* compiled from: Code39Writer.java */
/* loaded from: classes2.dex */
public final class Zb extends AbstractC0578dc {
    @Override // com.huawei.hms.scankit.p.AbstractC0578dc, com.huawei.hms.scankit.p.AbstractC0648zb
    public C0595i a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<tc, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0578dc
    public boolean[] a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int i10 = length + 25;
            for (int i11 = 0; i11 < length; i11++) {
                int indexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i11));
                if (indexOf >= 0) {
                    a(A.f14427a[indexOf], iArr);
                    for (int i12 = 0; i12 < 9; i12++) {
                        i10 += iArr[i12];
                    }
                } else {
                    throw new IllegalArgumentException("Bad contents: error contents");
                }
            }
            boolean[] zArr = new boolean[i10];
            a(148, iArr);
            int a10 = AbstractC0578dc.a(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int a11 = a10 + AbstractC0578dc.a(zArr, a10, iArr2, false);
            for (int i13 = 0; i13 < length; i13++) {
                a(A.f14427a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i13))], iArr);
                int a12 = a11 + AbstractC0578dc.a(zArr, a11, iArr, true);
                a11 = a12 + AbstractC0578dc.a(zArr, a12, iArr2, false);
            }
            a(148, iArr);
            AbstractC0578dc.a(zArr, a11, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }

    private static void a(int i10, int[] iArr) {
        for (int i11 = 0; i11 < 9; i11++) {
            int i12 = 1;
            if (((1 << (8 - i11)) & i10) != 0) {
                i12 = 2;
            }
            iArr[i11] = i12;
        }
    }
}
