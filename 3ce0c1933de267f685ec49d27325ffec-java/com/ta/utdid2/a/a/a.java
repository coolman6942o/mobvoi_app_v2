package com.ta.utdid2.a.a;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public class a {
    public static String a(String str) {
        byte[] bArr;
        try {
            bArr = a(a(), str.getBytes());
        } catch (Exception unused) {
            bArr = null;
        }
        if (bArr != null) {
            return a(bArr);
        }
        return null;
    }

    public static String b(String str) {
        try {
            return new String(b(a(), m21a(str)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] a() throws Exception {
        return f.a(new byte[]{33, 83, -50, -89, -84, -114, 80, 99, 10, 63, 22, -65, -11, 30, 101, -118});
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(b()));
        return cipher.doFinal(bArr2);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(b()));
        return cipher.doFinal(bArr2);
    }

    public static byte[] b() {
        try {
            byte[] decode = b.decode("IUQSvE6r1TfFPdPEjfklLw==".getBytes("UTF-8"), 2);
            if (decode != null) {
                return f.a(decode);
            }
        } catch (Exception unused) {
        }
        return new byte[16];
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m21a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = Integer.valueOf(str.substring(i11, i11 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b10 : bArr) {
            a(stringBuffer, b10);
        }
        return stringBuffer.toString();
    }

    public static void a(StringBuffer stringBuffer, byte b10) {
        stringBuffer.append("0123456789ABCDEF".charAt((b10 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b10 & 15));
    }
}
