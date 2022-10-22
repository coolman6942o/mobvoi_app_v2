package h9;
/* compiled from: DataConvertUtil.java */
/* loaded from: classes2.dex */
public final class a {
    static {
        "0123456789ABCDEF".toCharArray();
    }

    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    private static byte b(char c10) {
        return (byte) "0123456789ABCDEF".indexOf(c10);
    }

    public static byte[] c(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (b(charArray[i11 + 1]) | (b(charArray[i11]) << 4));
        }
        return bArr;
    }
}
