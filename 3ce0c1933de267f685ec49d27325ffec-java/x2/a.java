package x2;
/* loaded from: classes.dex */
public class a {
    public static byte a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length >= 1) {
                if (bArr.length == 1) {
                    return bArr[0];
                }
                byte b10 = bArr[0];
                for (int i10 = 1; i10 < bArr.length; i10++) {
                    b10 = (byte) (b10 ^ bArr[i10]);
                }
                return b10;
            }
        }
        return (byte) 0;
    }

    public static String b(String str, int i10, int i11) {
        int i12 = i10 - 16;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i13 = 0;
        while (i13 != length) {
            i12 += i11;
            i13++;
            charArray[i13] = (char) (charArray[i13] ^ (i12 & 95));
        }
        return String.valueOf(charArray, 0, length).intern();
    }
}
