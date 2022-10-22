package com.huawei.hianalytics.mn.no.mn;

import com.huawei.hianalytics.mn.no.qr.mn;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
/* loaded from: classes.dex */
public class op {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String mn(String str) {
        String str2;
        try {
            return pq.mn(MessageDigest.getInstance("SHA-256").digest(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            str2 = "sha256Digest(): UnsupportedEncodingException: Exception when writing the log file.";
            mn.op("EncryptUtil", str2);
            return "";
        } catch (NoSuchAlgorithmException unused2) {
            str2 = "sha256Digest(): NoSuch Algorithm Exception";
            mn.op("EncryptUtil", str2);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String mn(char[] cArr, byte[] bArr) {
        String str;
        try {
            return pq.mn(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(cArr, bArr, 10000, 128)).getEncoded());
        } catch (NoSuchAlgorithmException unused) {
            str = "getAuthToken() encryptPBKDF2 No such algorithm!";
            mn.pq("EncryptUtil", str);
            return null;
        } catch (InvalidKeySpecException unused2) {
            str = "getAuthToken() encryptPBKDF2 Invalid key specification !";
            mn.pq("EncryptUtil", str);
            return null;
        }
    }
}
