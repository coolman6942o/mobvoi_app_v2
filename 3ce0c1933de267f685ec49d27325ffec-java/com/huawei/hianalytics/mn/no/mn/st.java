package com.huawei.hianalytics.mn.no.mn;

import com.huawei.hianalytics.mn.no.qr.mn;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes.dex */
public class st implements rs {
    private PublicKey mn(byte[] bArr) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
    }

    private byte[] mn(byte[] bArr, PublicKey publicKey) {
        String str;
        try {
            if (publicKey != null) {
                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
                cipher.init(1, publicKey);
                return cipher.doFinal(bArr);
            }
            throw new UnsupportedEncodingException("The loaded public key is null");
        } catch (UnsupportedEncodingException unused) {
            str = "rsaEncrypt(): getBytes - Unsupported coding format!";
            mn.op("Rsa", str);
            return new byte[0];
        } catch (InvalidKeyException unused2) {
            str = "rsaEncrypt(): init - Invalid key!";
            mn.op("Rsa", str);
            return new byte[0];
        } catch (NoSuchAlgorithmException unused3) {
            str = "rsaEncrypt(): getInstance - No such algorithm,transformation";
            mn.op("Rsa", str);
            return new byte[0];
        } catch (BadPaddingException unused4) {
            str = "rsaEncrypt():False filling parameters!";
            mn.op("Rsa", str);
            return new byte[0];
        } catch (IllegalBlockSizeException unused5) {
            str = "rsaEncrypt(): doFinal - The provided block is not filled with";
            mn.op("Rsa", str);
            return new byte[0];
        } catch (NoSuchPaddingException unused6) {
            str = "rsaEncrypt():  No such filling parameters ";
            mn.op("Rsa", str);
            return new byte[0];
        }
    }

    @Override // com.huawei.hianalytics.mn.no.mn.rs
    public String mn(String str, String str2) {
        mn.no("Rsa", "No RSA decryption method");
        return "";
    }

    @Override // com.huawei.hianalytics.mn.no.mn.rs
    public String mn(String str, byte[] bArr) {
        String str2;
        if (bArr == null || bArr.length == 0) {
            mn.op("Rsa", "encrypt: content is empty or null");
            return "";
        }
        try {
            return pq.mn(mn(bArr, mn(pq.mn(str))));
        } catch (NoSuchAlgorithmException unused) {
            str2 = "encrypt(): getInstance - No such algorithm,transformation";
            mn.op("Rsa", str2);
            return "";
        } catch (InvalidKeySpecException unused2) {
            str2 = "encrypt(): Invalid key specification";
            mn.op("Rsa", str2);
            return "";
        }
    }

    @Override // com.huawei.hianalytics.mn.no.mn.rs
    public String no(String str, String str2) {
        try {
            return mn(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            mn.no("Rsa", "Unsupported encoding exception,utf-8");
            return "";
        }
    }
}
