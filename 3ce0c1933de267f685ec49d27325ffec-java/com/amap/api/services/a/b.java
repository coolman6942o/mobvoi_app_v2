package com.amap.api.services.a;

import android.content.Context;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
/* compiled from: ClientInfo.java */
/* loaded from: classes.dex */
public class b {
    public static byte[] a(Context context, byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        if (keyGenerator == null) {
            return null;
        }
        keyGenerator.init(256);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        PublicKey g10 = f.g(context);
        if (g10 == null) {
            return null;
        }
        byte[] c10 = c.c(encoded, g10);
        byte[] d10 = c.d(encoded, bArr);
        byte[] bArr2 = new byte[c10.length + d10.length];
        System.arraycopy(c10, 0, bArr2, 0, c10.length);
        System.arraycopy(d10, 0, bArr2, c10.length, d10.length);
        return bArr2;
    }

    static String b(Context context, byte[] bArr) throws InvalidKeyException, IOException, InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, CertificateException {
        byte[] i10 = f.i(a(context, bArr));
        return i10 != null ? c.b(i10) : "";
    }

    public static String c(Context context, byte[] bArr) {
        try {
            return b(context, bArr);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }
}
