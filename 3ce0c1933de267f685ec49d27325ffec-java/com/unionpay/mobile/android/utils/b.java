package com.unionpay.mobile.android.utils;
/* loaded from: classes2.dex */
public final class b {
    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            int i10 = b10 & 255;
            sb2.append("0123456789abcdef".charAt(i10 >> 4));
            sb2.append("0123456789abcdef".charAt(i10 & 15));
        }
        return sb2.toString();
    }

    public static byte[] a(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            int digit = Character.digit(charArray[i11 + 1], 16) | (Character.digit(charArray[i11], 16) << 4);
            if (digit > 127) {
                digit -= 256;
            }
            bArr[i10] = (byte) digit;
        }
        return bArr;
    }
}
