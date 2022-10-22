package x2;
/* loaded from: classes.dex */
public class g {
    public static String a(int i10, int i11, String str) {
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
