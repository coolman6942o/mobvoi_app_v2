package x2;
/* loaded from: classes.dex */
public class f {
    public static String a(String str, int i10) {
        int i11 = i10 + 8;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i12 = 0;
        while (i12 != length) {
            i11 -= 3;
            i12++;
            charArray[i12] = (char) (charArray[i12] ^ (i11 & 95));
        }
        return String.valueOf(charArray, 0, length).intern();
    }
}
