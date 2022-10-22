package com.mobvoi.android.common.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: AesUtil.java */
/* loaded from: classes2.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AesUtil.java */
    /* renamed from: com.mobvoi.android.common.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0188a extends Provider {
        C0188a() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }

    public static String a(String str, String str2) {
        return c(str, str2, 2);
    }

    @TargetApi(28)
    private static SecretKeySpec b(String str) {
        return new SecretKeySpec(i.b(str.getBytes(StandardCharsets.US_ASCII), 32), "AES");
    }

    @SuppressLint({"GetInstance"})
    private static String c(String str, String str2, int i10) {
        SecretKeySpec secretKeySpec;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    secretKeySpec = b(str2);
                } else {
                    secretKeySpec = e(str2);
                }
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(i10, secretKeySpec);
                if (i10 == 1) {
                    return f(cipher.doFinal(str.getBytes("utf-8")));
                }
                return new String(cipher.doFinal(g(str)));
            } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
            }
        }
        return null;
    }

    public static String d(String str, String str2) {
        return c(str, str2, 1);
    }

    @SuppressLint({"DeletedProvider"})
    private static SecretKeySpec e(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        SecureRandom secureRandom;
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        if (Build.VERSION.SDK_INT >= 24) {
            secureRandom = SecureRandom.getInstance("SHA1PRNG", new C0188a());
        } else {
            secureRandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        }
        secureRandom.setSeed(str.getBytes());
        keyGenerator.init(128, secureRandom);
        return new SecretKeySpec(keyGenerator.generateKey().getEncoded(), "AES");
    }

    public static String f(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            sb2.append(hexString.toUpperCase());
        }
        return sb2.toString();
    }

    private static byte[] g(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i10 = 0; i10 < str.length() / 2; i10++) {
            int i11 = i10 * 2;
            int i12 = i11 + 1;
            bArr[i10] = (byte) ((Integer.parseInt(str.substring(i11, i12), 16) * 16) + Integer.parseInt(str.substring(i12, i11 + 2), 16));
        }
        return bArr;
    }
}
