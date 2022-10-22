package jl;

import android.os.Build;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class a {
    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder("");
        if (bArr != null) {
            for (byte b10 : bArr) {
                String hexString = Integer.toHexString(b10 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb2.append(hexString);
            }
        }
        return sb2.toString().toUpperCase().trim();
    }

    public static String b(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder("");
        if (bArr != null) {
            for (byte b10 : bArr) {
                String hexString = Integer.toHexString(b10 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb2.append(hexString);
                sb2.append(" ");
            }
        }
        return sb2.toString().toUpperCase().trim();
    }

    public static boolean c(Object obj, Object obj2) {
        return Build.VERSION.SDK_INT >= 19 ? Objects.equals(obj, obj2) : obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static byte[] d(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i10 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            bArr2[i10] = bArr[length];
            i10++;
        }
        return bArr2;
    }
}
