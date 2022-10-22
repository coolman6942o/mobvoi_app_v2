package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;
/* compiled from: Code93Writer.java */
/* loaded from: classes2.dex */
public class _b extends AbstractC0578dc {
    @Override // com.huawei.hms.scankit.p.AbstractC0578dc, com.huawei.hms.scankit.p.AbstractC0648zb
    public C0595i a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<tc, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0578dc
    public boolean[] a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            a(B.f14444b[47], iArr);
            boolean[] zArr = new boolean[((str.length() + 2 + 2) * 9) + 1];
            int a10 = a(zArr, 0, iArr);
            for (int i10 = 0; i10 < length; i10++) {
                int indexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i10));
                if (indexOf >= 0) {
                    a(B.f14444b[indexOf], iArr);
                    a10 += a(zArr, a10, iArr);
                } else {
                    throw new IllegalArgumentException("Bad contents: please check contents");
                }
            }
            int a11 = a(str, 20);
            int[] iArr2 = B.f14444b;
            a(iArr2[a11], iArr);
            int a12 = a10 + a(zArr, a10, iArr);
            a(iArr2[a(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(a11), 15)], iArr);
            int a13 = a12 + a(zArr, a12, iArr);
            a(iArr2[47], iArr);
            zArr[a13 + a(zArr, a13, iArr)] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }

    private static void a(int i10, int[] iArr) {
        for (int i11 = 0; i11 < 9; i11++) {
            int i12 = 1;
            if (((1 << (8 - i11)) & i10) == 0) {
                i12 = 0;
            }
            iArr[i11] = i12;
        }
    }

    private static int a(boolean[] zArr, int i10, int[] iArr) {
        for (int i11 : iArr) {
            i10++;
            zArr[i10] = i11 != 0;
        }
        return 9;
    }

    private static int a(String str, int i10) {
        int i11 = 0;
        int i12 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i11 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i12;
            i12++;
            if (i12 > i10) {
                i12 = 1;
            }
        }
        return i11 % 47;
    }
}
