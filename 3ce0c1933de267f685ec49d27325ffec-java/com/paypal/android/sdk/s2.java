package com.paypal.android.sdk;

import android.util.Base64;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
/* loaded from: classes2.dex */
public final class s2 implements y0 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f21936b = "s2";

    /* renamed from: a  reason: collision with root package name */
    private final String f21937a;

    public s2(String str) {
        this.f21937a = str;
    }

    private static String a(Exception exc) {
        Log.e(f21936b, exc.getMessage());
        return null;
    }

    @Override // com.paypal.android.sdk.y0
    public final String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f21937a.getBytes("UTF8")));
            byte[] bytes = str.getBytes("UTF8");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(1, generateSecret);
            return Base64.encodeToString(cipher.doFinal(bytes), 0);
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e10) {
            return a(e10);
        }
    }

    @Override // com.paypal.android.sdk.y0
    public final String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f21937a.getBytes("UTF8")));
            byte[] decode = Base64.decode(str, 0);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(2, generateSecret);
            return new String(cipher.doFinal(decode));
        } catch (UnsupportedEncodingException | IllegalArgumentException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e10) {
            return a(e10);
        }
    }
}
