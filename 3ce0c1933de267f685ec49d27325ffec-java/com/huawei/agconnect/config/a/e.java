package com.huawei.agconnect.config.a;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Objects;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class e {
    public static SecretKey a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (bArr.length == 16 && bArr2.length == 16 && bArr3.length == 16) {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(c.a(a(bArr, bArr2, bArr3)).toCharArray(), bArr4, 5000, 128)).getEncoded(), "AES");
        }
        throw new IllegalArgumentException("invalid data for generating the key.");
    }

    private static byte[] a(byte[] bArr, int i10) {
        Objects.requireNonNull(bArr, "bytes must not be null.");
        for (int i11 = 0; i11 < bArr.length; i11++) {
            if (i10 < 0) {
                bArr[i11] = (byte) (bArr[i11] << (-i10));
            } else {
                bArr[i11] = (byte) (bArr[i11] >> i10);
            }
        }
        return bArr;
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            throw new NullPointerException("left or right must not be null.");
        } else if (bArr.length == bArr2.length) {
            byte[] bArr3 = new byte[bArr.length];
            for (int i10 = 0; i10 < bArr.length; i10++) {
                bArr3[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
            }
            return bArr3;
        } else {
            throw new IllegalArgumentException("left and right must be the same length.");
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(a(a(a(bArr, -4), bArr2), 6), bArr3);
    }
}
