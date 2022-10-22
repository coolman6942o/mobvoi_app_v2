package s2;

import x2.c;
/* loaded from: classes.dex */
public class b {
    public static String a(byte[] bArr) {
        int i10;
        int i11;
        if (bArr == null) {
            return null;
        }
        if (bArr.length < 1) {
            return null;
        }
        byte[] s10 = c.s(new byte[1], bArr);
        String str = new String("");
        int[] iArr = new int[20];
        int i12 = 0;
        for (long g10 = c.g(s10); g10 > 0; g10 /= 10) {
            i12++;
            iArr[i12] = (int) (g10 % 10);
        }
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            if ((i14 & 1) == 0) {
                int i15 = iArr[i14] + iArr[i14];
                i13 += i15 % 10;
                i11 = i15 / 10;
            } else {
                i11 = iArr[i14];
            }
            i13 += i11;
        }
        String str2 = str + ((10 - (i13 % 10)) % 10);
        long g11 = c.g(s10);
        for (int i16 = 1; i16 < 11; i16 += 2) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(String.valueOf(str2) + (i10 / 10)));
            sb2.append(((int) (g11 % 100)) % 10);
            str2 = sb2.toString();
            g11 /= 100;
        }
        return str2;
    }
}
