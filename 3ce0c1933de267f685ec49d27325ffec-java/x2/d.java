package x2;

import z2.a;
import z2.b;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static /* synthetic */ a f36355a = b.a().b();

    /* renamed from: b  reason: collision with root package name */
    private static /* synthetic */ String f36356b = d.class.getName();

    public static int a(byte[] bArr) {
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b10 = (byte) ((bArr[i10] & 240) >>> 4);
            if (b10 > 9) {
                break;
            }
            int i12 = b10 * 10;
            byte b11 = (byte) (bArr[i10] & 15);
            if (b11 > 9) {
                break;
            }
            i10++;
            i11 += (i12 + b11) * e(100, length - i10);
        }
        return i11;
    }

    public static String b(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length << 1);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            sb2.append((int) ((byte) ((bArr[i10] & 240) >>> 4)));
            sb2.append((int) ((byte) (bArr[i10] & 15)));
        }
        String sb3 = sb2.toString();
        while (sb3.charAt(0) == '0' && sb3.length() != 1) {
            sb3 = sb3.substring(1);
        }
        return sb3;
    }

    public static String c(String str, int i10) {
        int i11 = i10 - 13;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i12 = 0;
        while (i12 != length) {
            i11 -= 15;
            i12++;
            charArray[i12] = (char) (charArray[i12] ^ (i11 & 95));
        }
        return String.valueOf(charArray, 0, length).intern();
    }

    public static byte[] d(int i10, int i11) {
        if (i11 < 1) {
            a aVar = f36355a;
            if (aVar == null) {
                return null;
            }
            aVar.b(f36356b, e.a(4, "匘辇剩kk|垀敺敡轸戇X^D砂孑芋敼绋旤９挟宁孉苃攴纃锵廫霎欰"));
            return null;
        }
        byte[] bArr = new byte[i11];
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            int i13 = i10 % 100;
            bArr[i12] = (byte) (((byte) ((i13 / 10) << 4)) + ((byte) ((i13 % 10) & 15)));
            i10 /= 100;
        }
        return bArr;
    }

    protected static int e(int i10, int i11) {
        int i12 = 1;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 *= i10;
        }
        return i12;
    }

    public static byte[] f(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            str = "0" + str;
            length = str.length();
        }
        if (length >= 2) {
            length /= 2;
        }
        byte[] bArr = new byte[length];
        byte[] bytes = str.getBytes();
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            int i12 = (bytes[i11] < 48 || bytes[i11] > 57) ? ((bytes[i11] < 97 || bytes[i11] > 122) ? bytes[i11] - 65 : bytes[i11] - 97) + 10 : bytes[i11] - 48;
            int i13 = i11 + 1;
            bArr[i10] = (byte) ((i12 << 4) + ((bytes[i13] < 48 || bytes[i13] > 57) ? ((bytes[i13] < 97 || bytes[i13] > 122) ? bytes[i13] - 65 : bytes[i13] - 97) + 10 : bytes[i13] - 48));
        }
        return bArr;
    }
}
