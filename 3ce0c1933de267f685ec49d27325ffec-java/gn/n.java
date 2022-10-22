package gn;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.unionpay.tsmservice.data.Constant;
/* loaded from: classes2.dex */
public class n {

    /* renamed from: b  reason: collision with root package name */
    private static n f27580b;

    /* renamed from: a  reason: collision with root package name */
    private Context f27581a;

    public n(Context context) {
        this.f27581a = context;
    }

    private static byte a(char c10) {
        return (byte) "0123456789ABCDEF".indexOf(c10);
    }

    private boolean b(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (Character.isLetter(str.charAt(i10))) {
                return true;
            }
        }
        return false;
    }

    public static n d(Context context) {
        if (f27580b == null) {
            f27580b = new n(context);
        }
        return f27580b;
    }

    public String c(byte[] bArr) {
        String str = "";
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            str = str + hexString.toLowerCase();
        }
        return str;
    }

    public int e(String str) {
        int length;
        String upperCase = str.toUpperCase();
        int i10 = 0;
        for (int length2 = upperCase.length(); length2 > 0; length2--) {
            char charAt = upperCase.charAt(length2 - 1);
            i10 = (int) (i10 + (Math.pow(16.0d, length - length2) * ((charAt < '0' || charAt > '9') ? charAt - '7' : charAt - '0')));
        }
        return i10;
    }

    public byte[] f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (a(charArray[i11 + 1]) | (a(charArray[i11]) << 4));
        }
        return bArr;
    }

    public byte[] g(String str, int i10) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length + 2];
        bArr[0] = -63;
        if (i10 == 1) {
            bArr[1] = 1;
        } else if (i10 == 2) {
            bArr[1] = 2;
        } else if (i10 == 3) {
            bArr[1] = 3;
        }
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * 2;
            bArr[i11 + 2] = (byte) (a(charArray[i12 + 1]) | (a(charArray[i12]) << 4));
        }
        return bArr;
    }

    public byte[] h(String str, int i10) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        if (p.c(this.f27581a, 4) || q.f27596o || p.g(this.f27581a, 1024) || p.g(this.f27581a, 2048) || p.g(this.f27581a, 512) || q.f27595n || p.h(this.f27581a, WXMediaMessage.THUMB_LENGTH_LIMIT)) {
            if (length > 160) {
                length = 160;
            }
        } else if (length > 40) {
            length = 40;
        }
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length + 2];
        bArr[0] = (byte) (i10 & 255);
        bArr[1] = (byte) (length & 255);
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * 2;
            bArr[i11 + 2] = (byte) (a(charArray[i12 + 1]) | (a(charArray[i12]) << 4));
        }
        return bArr;
    }

    public byte[] i(String str, int i10) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        if (length > 30) {
            length = 30;
        }
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length + 2];
        bArr[0] = (byte) (i10 & 255);
        bArr[1] = (byte) (length & 255);
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * 2;
            bArr[i11 + 2] = (byte) (a(charArray[i12 + 1]) | (a(charArray[i12]) << 4));
        }
        return bArr;
    }

    public byte[] j(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (a(charArray[i11 + 1]) | (a(charArray[i11]) << 4));
        }
        return bArr;
    }

    public byte[] k(String str, int i10, int i11) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length + 3];
        bArr[0] = (byte) (i10 & 255);
        bArr[1] = (byte) (i11 & 255);
        bArr[2] = (byte) (length & 255);
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = i12 * 2;
            bArr[i12 + 3] = (byte) (a(charArray[i13 + 1]) | (a(charArray[i13]) << 4));
        }
        return bArr;
    }

    public byte[] l(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (a(charArray[i11 + 1]) | (a(charArray[i11]) << 4));
        }
        return bArr;
    }

    public String m(String str) {
        String c10 = m.d().c(str);
        String str2 = "";
        for (int i10 = 0; i10 < c10.length(); i10++) {
            int intValue = Integer.valueOf(c10.charAt(i10)).intValue();
            if (intValue >= 32 && intValue != 8197 && ((intValue < 127 || intValue > 159) && intValue != 9924 && intValue != 9748 && (i10 != c10.length() - 1 || intValue > 32))) {
                str2 = str2 + Integer.toHexString(intValue).toUpperCase();
            }
        }
        return str2;
    }

    public String n(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (!b(str)) {
            return str;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (!Character.isLetter(charAt)) {
                str2 = str2 + charAt;
            }
        }
        return str2;
    }

    public String o(String str) {
        StringBuilder sb2;
        String str2;
        String str3 = "";
        for (int i10 = 0; i10 < str.length(); i10++) {
            int codePointAt = str.codePointAt(i10);
            if (codePointAt >= 32 && codePointAt != 8197 && ((codePointAt < 127 || codePointAt > 159) && codePointAt != 9924 && codePointAt != 9748 && (i10 != str.length() - 1 || codePointAt > 32))) {
                String upperCase = Integer.toHexString(codePointAt).toUpperCase();
                if (upperCase.length() == 2) {
                    sb2 = new StringBuilder();
                    str2 = "00";
                } else if (upperCase.length() == 3) {
                    sb2 = new StringBuilder();
                    str2 = "0";
                } else {
                    if (upperCase.length() == 1) {
                        sb2 = new StringBuilder();
                        str2 = Constant.DEFAULT_CVN2;
                    }
                    str3 = str3 + upperCase;
                }
                sb2.append(str2);
                sb2.append(upperCase);
                upperCase = sb2.toString();
                str3 = str3 + upperCase;
            }
        }
        u.a("test", "推送的内容 = " + str + ",unicode =" + str3);
        return str3;
    }
}
