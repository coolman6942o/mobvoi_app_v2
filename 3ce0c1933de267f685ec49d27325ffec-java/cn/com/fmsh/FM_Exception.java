package cn.com.fmsh;
/* loaded from: classes.dex */
public class FM_Exception extends Exception {
    private static final /* synthetic */ long serialVersionUID = -4590066155361981024L;

    public FM_Exception(String str) {
        super(str);
    }

    public static String insert(int i10, int i11, String str) {
        int i12 = i10 + 4;
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
