package com.unionpay.mobile.android.hce;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
/* loaded from: classes2.dex */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0061 A[Catch: Exception -> 0x0069, TRY_LEAVE, TryCatch #0 {Exception -> 0x0069, blocks: (B:3:0x0005, B:6:0x000e, B:9:0x0015, B:11:0x0027, B:13:0x0043, B:15:0x0061), top: B:21:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2) {
        byte[] bArr;
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            if (str != null && !str.equals("")) {
                String upperCase = str.toUpperCase();
                int length = upperCase.length() / 2;
                char[] charArray = upperCase.toCharArray();
                bArr = new byte[length];
                for (int i10 = 0; i10 < length; i10++) {
                    int i11 = i10 * 2;
                    bArr[i10] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i11 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i11])) << 4));
                }
                SecretKey generateSecret = SecretKeyFactory.getInstance("desede").generateSecret(new DESedeKeySpec(bytes));
                Cipher cipher = Cipher.getInstance("DESEDE/ECB/PKCS5Padding");
                cipher.init(2, generateSecret);
                byte[] doFinal = cipher.doFinal(bArr);
                return doFinal == null ? new String(doFinal, "UTF-8") : "";
            }
            bArr = null;
            SecretKey generateSecret2 = SecretKeyFactory.getInstance("desede").generateSecret(new DESedeKeySpec(bytes));
            Cipher cipher2 = Cipher.getInstance("DESEDE/ECB/PKCS5Padding");
            cipher2.init(2, generateSecret2);
            byte[] doFinal2 = cipher2.doFinal(bArr);
            if (doFinal2 == null) {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] bArr) {
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

    public static String b(String str, String str2) {
        byte[] bArr;
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            byte[] bytes2 = str.getBytes();
            SecretKey generateSecret = SecretKeyFactory.getInstance("desede").generateSecret(new DESedeKeySpec(bytes));
            Cipher cipher = Cipher.getInstance("desede/ECB/PKCS5Padding");
            cipher.init(1, generateSecret);
            bArr = cipher.doFinal(bytes2);
        } catch (Exception e10) {
            e10.printStackTrace();
            bArr = null;
        }
        return a(bArr);
    }
}
