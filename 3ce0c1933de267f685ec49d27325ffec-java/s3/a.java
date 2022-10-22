package s3;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f34293a = new byte[128];

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f34294b = new char[64];

    static {
        int i10;
        int i11;
        int i12 = 0;
        for (int i13 = 0; i13 < 128; i13++) {
            f34293a[i13] = -1;
        }
        for (int i14 = 90; i14 >= 65; i14--) {
            f34293a[i14] = (byte) (i14 - 65);
        }
        int i15 = 122;
        while (true) {
            i10 = 26;
            if (i15 < 97) {
                break;
            }
            f34293a[i15] = (byte) ((i15 - 97) + 26);
            i15--;
        }
        int i16 = 57;
        while (true) {
            i11 = 52;
            if (i16 < 48) {
                break;
            }
            f34293a[i16] = (byte) ((i16 - 48) + 52);
            i16--;
        }
        byte[] bArr = f34293a;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i17 = 0; i17 <= 25; i17++) {
            f34294b[i17] = (char) (i17 + 65);
        }
        int i18 = 0;
        while (i10 <= 51) {
            f34294b[i10] = (char) (i18 + 97);
            i10++;
            i18++;
        }
        while (i11 <= 61) {
            f34294b[i11] = (char) (i12 + 48);
            i11++;
            i12++;
        }
        char[] cArr = f34294b;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    public static int a(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (!f(cArr[i11])) {
                i10++;
                cArr[i10] = cArr[i11];
            }
        }
        return i10;
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i10 = length % 24;
        int i11 = length / 24;
        char[] cArr = new char[(i10 != 0 ? i11 + 1 : i11) * 4];
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = i12 + 1;
            byte b10 = bArr[i12];
            int i16 = i15 + 1;
            byte b11 = bArr[i15];
            i12 = i16 + 1;
            byte b12 = bArr[i16];
            byte b13 = (byte) (b11 & 15);
            byte b14 = (byte) (b10 & 3);
            int i17 = b10 & Byte.MIN_VALUE;
            int i18 = b10 >> 2;
            if (i17 != 0) {
                i18 ^= 192;
            }
            byte b15 = (byte) i18;
            int i19 = b11 & Byte.MIN_VALUE;
            int i20 = b11 >> 4;
            if (i19 != 0) {
                i20 ^= 240;
            }
            byte b16 = (byte) i20;
            int i21 = (b12 & Byte.MIN_VALUE) == 0 ? b12 >> 6 : (b12 >> 6) ^ 252;
            int i22 = i13 + 1;
            char[] cArr2 = f34294b;
            cArr[i13] = cArr2[b15];
            int i23 = i22 + 1;
            cArr[i22] = cArr2[(b14 << 4) | b16];
            int i24 = i23 + 1;
            cArr[i23] = cArr2[(b13 << 2) | ((byte) i21)];
            i13 = i24 + 1;
            cArr[i24] = cArr2[b12 & 63];
        }
        if (i10 == 8) {
            byte b17 = bArr[i12];
            byte b18 = (byte) (b17 & 3);
            int i25 = b17 & Byte.MIN_VALUE;
            int i26 = b17 >> 2;
            if (i25 != 0) {
                i26 ^= 192;
            }
            int i27 = i13 + 1;
            char[] cArr3 = f34294b;
            cArr[i13] = cArr3[(byte) i26];
            int i28 = i27 + 1;
            cArr[i27] = cArr3[b18 << 4];
            cArr[i28] = '=';
            cArr[i28 + 1] = '=';
        } else if (i10 == 16) {
            byte b19 = bArr[i12];
            byte b20 = bArr[i12 + 1];
            byte b21 = (byte) (b20 & 15);
            byte b22 = (byte) (b19 & 3);
            int i29 = b19 & Byte.MIN_VALUE;
            int i30 = b19 >> 2;
            if (i29 != 0) {
                i30 ^= 192;
            }
            byte b23 = (byte) i30;
            int i31 = b20 & Byte.MIN_VALUE;
            int i32 = b20 >> 4;
            if (i31 != 0) {
                i32 ^= 240;
            }
            int i33 = i13 + 1;
            char[] cArr4 = f34294b;
            cArr[i13] = cArr4[b23];
            int i34 = i33 + 1;
            cArr[i33] = cArr4[((byte) i32) | (b22 << 4)];
            cArr[i34] = cArr4[b21 << 2];
            cArr[i34 + 1] = '=';
        }
        return new String(cArr);
    }

    public static boolean c(char c10) {
        return c10 < 128 && f34293a[c10] != -1;
    }

    public static byte[] d(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int a10 = a(charArray);
        if (a10 % 4 != 0) {
            return null;
        }
        int i10 = a10 / 4;
        if (i10 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i10 * 3];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < i10 - 1) {
            int i14 = i12 + 1;
            char c10 = charArray[i12];
            if (c(c10)) {
                int i15 = i14 + 1;
                char c11 = charArray[i14];
                if (c(c11)) {
                    int i16 = i15 + 1;
                    char c12 = charArray[i15];
                    if (c(c12)) {
                        i12 = i16 + 1;
                        char c13 = charArray[i16];
                        if (c(c13)) {
                            byte[] bArr2 = f34293a;
                            byte b10 = bArr2[c10];
                            byte b11 = bArr2[c11];
                            byte b12 = bArr2[c12];
                            byte b13 = bArr2[c13];
                            int i17 = i13 + 1;
                            bArr[i13] = (byte) ((b10 << 2) | (b11 >> 4));
                            int i18 = i17 + 1;
                            bArr[i17] = (byte) (((b11 & 15) << 4) | ((b12 >> 2) & 15));
                            i13 = i18 + 1;
                            bArr[i18] = (byte) ((b12 << 6) | b13);
                            i11++;
                        }
                    }
                }
            }
            return null;
        }
        int i19 = i12 + 1;
        char c14 = charArray[i12];
        if (!c(c14)) {
            return null;
        }
        int i20 = i19 + 1;
        char c15 = charArray[i19];
        if (!c(c15)) {
            return null;
        }
        byte[] bArr3 = f34293a;
        byte b14 = bArr3[c14];
        byte b15 = bArr3[c15];
        int i21 = i20 + 1;
        char c16 = charArray[i20];
        char c17 = charArray[i21];
        if (c(c16) && c(c17)) {
            byte b16 = bArr3[c16];
            byte b17 = bArr3[c17];
            int i22 = i13 + 1;
            bArr[i13] = (byte) ((b14 << 2) | (b15 >> 4));
            bArr[i22] = (byte) (((b15 & 15) << 4) | ((b16 >> 2) & 15));
            bArr[i22 + 1] = (byte) (b17 | (b16 << 6));
            return bArr;
        } else if (!e(c16) || !e(c17)) {
            if (e(c16) || !e(c17)) {
                return null;
            }
            byte b18 = bArr3[c16];
            if ((b18 & 3) != 0) {
                return null;
            }
            int i23 = i11 * 3;
            byte[] bArr4 = new byte[i23 + 2];
            System.arraycopy(bArr, 0, bArr4, 0, i23);
            bArr4[i13] = (byte) ((b14 << 2) | (b15 >> 4));
            bArr4[i13 + 1] = (byte) (((b18 >> 2) & 15) | ((b15 & 15) << 4));
            return bArr4;
        } else if ((b15 & 15) != 0) {
            return null;
        } else {
            int i24 = i11 * 3;
            byte[] bArr5 = new byte[i24 + 1];
            System.arraycopy(bArr, 0, bArr5, 0, i24);
            bArr5[i13] = (byte) ((b14 << 2) | (b15 >> 4));
            return bArr5;
        }
    }

    public static boolean e(char c10) {
        return c10 == '=';
    }

    public static boolean f(char c10) {
        return c10 == ' ' || c10 == '\r' || c10 == '\n' || c10 == '\t';
    }
}
