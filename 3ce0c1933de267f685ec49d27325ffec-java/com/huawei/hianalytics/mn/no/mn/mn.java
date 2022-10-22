package com.huawei.hianalytics.mn.no.mn;

import android.text.TextUtils;
import android.util.Pair;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class mn implements rs {

    /* renamed from: mn  reason: collision with root package name */
    private static final Charset f13537mn = Charset.forName("UTF-8");

    private Pair<byte[], byte[]> mn(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 32) {
            return new Pair<>(new byte[0], new byte[0]);
        }
        return new Pair<>(pq.mn(str.substring(0, 32)), pq.mn(str.substring(32)));
    }

    private String mn(String str, byte[] bArr, byte[] bArr2) {
        return (bArr2 == null || str == null || bArr == null || bArr.length == 0) ? "" : mn(bArr, pq.mn(no(str, bArr, bArr2)));
    }

    private String mn(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            return str;
        }
        if (str == null) {
            str = "";
        }
        return pq.mn(bArr).concat(str);
    }

    private String mn(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        String str;
        if (bArr.length == 0 || bArr2.length == 0 || bArr3.length == 0) {
            com.huawei.hianalytics.mn.no.qr.mn.op("Aes", "decrypt: parameter exception");
            return "";
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
            return new String(cipher.doFinal(bArr3), f13537mn);
        } catch (InvalidAlgorithmParameterException unused) {
            str = "aesDecrypt(): init - Invalid algorithm parameters !";
            com.huawei.hianalytics.mn.no.qr.mn.op("Aes", str);
            return "";
        } catch (InvalidKeyException unused2) {
            str = "aesDecrypt(): init - Invalid key!";
            com.huawei.hianalytics.mn.no.qr.mn.op("Aes", str);
            return "";
        } catch (NoSuchAlgorithmException unused3) {
            str = "aesDecrypt(): getInstance - No such algorithm,transformation";
            com.huawei.hianalytics.mn.no.qr.mn.op("Aes", str);
            return "";
        } catch (BadPaddingException unused4) {
            str = "aesDecrypt(): False filling parameters!";
            com.huawei.hianalytics.mn.no.qr.mn.op("Aes", str);
            return "";
        } catch (IllegalBlockSizeException unused5) {
            str = "aesDecrypt(): doFinal - The provided block is not filled with";
            com.huawei.hianalytics.mn.no.qr.mn.op("Aes", str);
            return "";
        } catch (NoSuchPaddingException unused6) {
            str = "aesDecrypt():  No such filling parameters ";
            com.huawei.hianalytics.mn.no.qr.mn.op("Aes", str);
            return "";
        }
    }

    private byte[] no(String str, byte[] bArr, byte[] bArr2) {
        String str2;
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, new SecretKeySpec(pq.mn(str), "AES"), new IvParameterSpec(bArr));
            return cipher.doFinal(bArr2);
        } catch (InvalidAlgorithmParameterException unused) {
            str2 = "aesEncrypt(): init - Invalid algorithm parameters !";
            com.huawei.hianalytics.mn.no.qr.mn.op("Aes", str2);
            return new byte[0];
        } catch (InvalidKeyException unused2) {
            str2 = "aesEncrypt(): init - Invalid key!";
            com.huawei.hianalytics.mn.no.qr.mn.op("Aes", str2);
            return new byte[0];
        } catch (NoSuchAlgorithmException unused3) {
            str2 = "aesEncrypt(): getInstance - No such algorithm,transformation";
            com.huawei.hianalytics.mn.no.qr.mn.op("Aes", str2);
            return new byte[0];
        } catch (BadPaddingException unused4) {
            str2 = "aesEncrypt(): False filling parameters!";
            com.huawei.hianalytics.mn.no.qr.mn.op("Aes", str2);
            return new byte[0];
        } catch (IllegalBlockSizeException unused5) {
            str2 = "aesEncrypt(): doFinal - The provided block is not filled with";
            com.huawei.hianalytics.mn.no.qr.mn.op("Aes", str2);
            return new byte[0];
        } catch (NoSuchPaddingException unused6) {
            str2 = "aesEncrypt(): No such filling parameters ";
            com.huawei.hianalytics.mn.no.qr.mn.op("Aes", str2);
            return new byte[0];
        }
    }

    @Override // com.huawei.hianalytics.mn.no.mn.rs
    public String mn(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("Aes", "decrypt: content or key is empty");
            return "";
        }
        byte[] mn2 = pq.mn(str);
        Pair<byte[], byte[]> mn3 = mn(str2);
        return mn(mn2, (byte[]) mn3.first, (byte[]) mn3.second);
    }

    @Override // com.huawei.hianalytics.mn.no.mn.rs
    public String mn(String str, byte[] bArr) {
        return mn(str, pq.mn(), bArr);
    }

    @Override // com.huawei.hianalytics.mn.no.mn.rs
    public String no(String str, String str2) {
        try {
            return mn(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            com.huawei.hianalytics.mn.no.qr.mn.no("Aes", "Unsupported Encoding Exception : utf-8");
            return "";
        }
    }
}
