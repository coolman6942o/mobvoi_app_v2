package com.amap.api.mapcore2d;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: Encrypt.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f6967a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f6968b = new byte[128];

    static {
        for (int i10 = 0; i10 < 128; i10++) {
            f6968b[i10] = -1;
        }
        for (int i11 = 65; i11 <= 90; i11++) {
            f6968b[i11] = (byte) (i11 - 65);
        }
        for (int i12 = 97; i12 <= 122; i12++) {
            f6968b[i12] = (byte) ((i12 - 97) + 26);
        }
        for (int i13 = 48; i13 <= 57; i13++) {
            f6968b[i13] = (byte) ((i13 - 48) + 52);
        }
        byte[] bArr = f6968b;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static String a(String str) {
        return g.d(f(str));
    }

    public static String b(byte[] bArr) {
        try {
            return h(bArr);
        } catch (Throwable th2) {
            k4.d.b(th2, "Encrypt", "encodeBase64");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] c(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            return g(bArr, bArr2);
        } catch (Throwable th2) {
            k4.d.b(th2, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    public static String e(byte[] bArr) {
        try {
            return h(bArr);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
        if (r5 != (-1)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
        r2.write(((r4 & 15) << 4) | ((r5 & 60) >>> 2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
        r4 = r0 + 1;
        r0 = r8[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
        if (r0 != 61) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0073, code lost:
        return r2.toByteArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
        r0 = com.amap.api.mapcore2d.d.f6968b[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0078, code lost:
        if (r4 >= r1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007a, code lost:
        if (r0 == (-1)) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007d, code lost:
        r0 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007f, code lost:
        if (r0 != (-1)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0082, code lost:
        r2.write(r0 | ((r5 & 3) << 6));
        r0 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] f(String str) {
        int i10;
        byte b10;
        int i11;
        byte b11;
        int i12 = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] f10 = g.f(str);
        int length = f10.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i12 < length) {
            while (true) {
                i10 = i12 + 1;
                b10 = f6968b[f10[i12]];
                if (i10 >= length || b10 != -1) {
                    break;
                }
                i12 = i10;
            }
            if (b10 == -1) {
                break;
            }
            while (true) {
                i11 = i10 + 1;
                b11 = f6968b[f10[i10]];
                if (i11 >= length || b11 != -1) {
                    break;
                }
                i10 = i11;
            }
            if (b11 == -1) {
                break;
            }
            byteArrayOutputStream.write((b10 << 2) | ((b11 & 48) >>> 4));
            while (true) {
                int i13 = i11 + 1;
                byte b12 = f10[i11];
                if (b12 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                byte b13 = f6968b[b12];
                if (i13 >= length || b13 != -1) {
                    break;
                }
                i11 = i13;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] g(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(g.h());
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        try {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e10) {
            e10.printStackTrace();
        }
        return cipher.doFinal(bArr2);
    }

    private static String h(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            int i11 = i10 + 1;
            int i12 = bArr[i10] & 255;
            if (i11 == length) {
                char[] cArr = f6967a;
                stringBuffer.append(cArr[i12 >>> 2]);
                stringBuffer.append(cArr[(i12 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i13 = i11 + 1;
            int i14 = bArr[i11] & 255;
            if (i13 == length) {
                char[] cArr2 = f6967a;
                stringBuffer.append(cArr2[i12 >>> 2]);
                stringBuffer.append(cArr2[((i12 & 3) << 4) | ((i14 & 240) >>> 4)]);
                stringBuffer.append(cArr2[(i14 & 15) << 2]);
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                break;
            }
            i10 = i13 + 1;
            int i15 = bArr[i13] & 255;
            char[] cArr3 = f6967a;
            stringBuffer.append(cArr3[i12 >>> 2]);
            stringBuffer.append(cArr3[((i12 & 3) << 4) | ((i14 & 240) >>> 4)]);
            stringBuffer.append(cArr3[((i14 & 15) << 2) | ((i15 & 192) >>> 6)]);
            stringBuffer.append(cArr3[i15 & 63]);
        }
        return stringBuffer.toString();
    }
}
