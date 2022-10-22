package x2;
/* loaded from: classes.dex */
public class b {
    public static byte[] a(byte[] bArr) {
        short s10 = 0;
        for (byte b10 : bArr) {
            short s11 = (short) (b10 << 8);
            for (int i10 = 0; i10 < 8; i10++) {
                short s12 = (short) (s10 ^ s11);
                s10 = (short) (s10 << 1);
                if (s12 <= 0) {
                    s10 = (short) (s10 ^ 4129);
                }
                s11 = (short) (s11 << 1);
            }
        }
        return c.n(s10, 2);
    }

    public static String b(int i10, String str) {
        int i11 = i10 + 13;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i12 = 0;
        while (i12 != length) {
            i11 += 11;
            i12++;
            charArray[i12] = (char) (charArray[i12] ^ (i11 & 95));
        }
        return String.valueOf(charArray, 0, length).intern();
    }
}
