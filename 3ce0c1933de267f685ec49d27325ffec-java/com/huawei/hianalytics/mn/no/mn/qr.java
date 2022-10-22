package com.huawei.hianalytics.mn.no.mn;

import android.text.TextUtils;
import com.huawei.hianalytics.mn.no.qr.mn;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class qr implements rs {
    @Override // com.huawei.hianalytics.mn.no.mn.rs
    public String mn(String str, String str2) {
        mn.no("HmacSHA256Crypt", "No HMAC_SHA256 decryption method");
        return "";
    }

    @Override // com.huawei.hianalytics.mn.no.mn.rs
    public String mn(String str, byte[] bArr) {
        String str2;
        if (bArr == null || bArr.length == 0) {
            mn.op("HmacSHA256Crypt", "encrypt: content is empty or null");
            return "";
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(Charset.forName("UTF-8")), "HmacSHA256");
        try {
            Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
            mac.init(secretKeySpec);
            return pq.mn(mac.doFinal(bArr));
        } catch (InvalidKeyException unused) {
            str2 = "Exception has happened when digest2byte,From Invalid key!";
            mn.op("HmacSHA256Crypt", str2);
            return "";
        } catch (NoSuchAlgorithmException unused2) {
            str2 = "When digest2byte executed Exception has happened!From Algorithm error !";
            mn.op("HmacSHA256Crypt", str2);
            return "";
        }
    }

    @Override // com.huawei.hianalytics.mn.no.mn.rs
    public String no(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            mn.op("HmacSHA256Crypt", "key or content is empty");
            return "";
        }
        try {
            return mn(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            mn.no("HmacSHA256Crypt", "Unsupported encoding exception,utf-8");
            return "";
        }
    }
}
