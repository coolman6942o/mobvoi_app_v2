package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: Code128Writer.java */
/* loaded from: classes2.dex */
public final class Yb extends AbstractC0578dc {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Code128Writer.java */
    /* loaded from: classes2.dex */
    public enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0578dc, com.huawei.hms.scankit.p.AbstractC0648zb
    public C0595i a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<tc, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0578dc
    public boolean[] a(String str) {
        int length = str.length();
        if (length < 1 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    case 241:
                    case 242:
                    case 243:
                    case 244:
                        break;
                    default:
                        throw new IllegalArgumentException("Bad character in input: " + charAt);
                }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList();
        int i12 = 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < length) {
            int a10 = a(str, i13, i15);
            if (a10 == i15) {
                switch (str.charAt(i13)) {
                    case 241:
                        a10 = 102;
                        break;
                    case 242:
                        a10 = 97;
                        break;
                    case 243:
                        a10 = 96;
                        break;
                    case 244:
                        a10 = 100;
                        break;
                    default:
                        if (i15 == 100) {
                            a10 = str.charAt(i13) - ' ';
                            break;
                        } else {
                            try {
                                a10 = Integer.parseInt(str.substring(i13, i13 + 2));
                                i13++;
                                break;
                            } catch (NumberFormatException unused) {
                                throw new IllegalArgumentException("contents substring can not format integer");
                            }
                        }
                }
                i13++;
            } else if (i15 == 0) {
                a10 = a10 == 100 ? 104 : 105;
                i15 = a10;
            } else {
                i15 = a10;
            }
            arrayList.add(C0646z.f15021a[a10]);
            i14 += a10 * i12;
            if (i13 != 0) {
                i12++;
            }
        }
        int[][] iArr = C0646z.f15021a;
        arrayList.add(iArr[i14 % 103]);
        arrayList.add(iArr[106]);
        int i16 = 0;
        for (int[] iArr2 : arrayList) {
            for (int i17 : iArr2) {
                i16 += i17;
            }
        }
        boolean[] zArr = new boolean[i16];
        for (int[] iArr3 : arrayList) {
            i10 += AbstractC0578dc.a(zArr, i10, iArr3, true);
        }
        return zArr;
    }

    private static a a(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        if (i10 >= length) {
            return a.UNCODABLE;
        }
        char charAt = charSequence.charAt(i10);
        if (charAt == 241) {
            return a.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return a.UNCODABLE;
        }
        int i11 = i10 + 1;
        if (i11 >= length) {
            return a.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i11);
        if (charAt2 < '0' || charAt2 > '9') {
            return a.ONE_DIGIT;
        }
        return a.TWO_DIGITS;
    }

    private static int a(CharSequence charSequence, int i10, int i11) {
        a aVar;
        a a10;
        a a11;
        a a12 = a(charSequence, i10);
        a aVar2 = a.UNCODABLE;
        if (!(a12 == aVar2 || a12 == (aVar = a.ONE_DIGIT))) {
            if (i11 == 99) {
                return 99;
            }
            if (i11 == 100) {
                a aVar3 = a.FNC_1;
                if (a12 == aVar3 || (a10 = a(charSequence, i10 + 2)) == aVar2 || a10 == aVar) {
                    return 100;
                }
                if (a10 == aVar3) {
                    return a(charSequence, i10 + 3) == a.TWO_DIGITS ? 99 : 100;
                }
                int i12 = i10 + 4;
                while (true) {
                    a11 = a(charSequence, i12);
                    if (a11 != a.TWO_DIGITS) {
                        break;
                    }
                    i12 += 2;
                }
                return a11 == a.ONE_DIGIT ? 100 : 99;
            }
            if (a12 == a.FNC_1) {
                a12 = a(charSequence, i10 + 1);
            }
            if (a12 == a.TWO_DIGITS) {
                return 99;
            }
        }
        return 100;
    }
}
