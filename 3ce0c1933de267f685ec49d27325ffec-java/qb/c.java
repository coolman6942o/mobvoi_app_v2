package qb;

import android.annotation.SuppressLint;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: SecurityHelper.java */
/* loaded from: classes2.dex */
public class c {
    @SuppressLint({"GetInstance"})
    public String a(String str, String str2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str2, 2), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 2);
        } catch (Exception unused) {
            return null;
        }
    }
}
