package com.huawei.agconnect.config.a;

import android.content.Context;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f13497a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Object f13498b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private SecretKey f13499c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Context context, String str) {
        super(context, str);
        try {
            String a10 = a("/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138");
            String a11 = a("/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C");
            String a12 = a("/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B");
            String a13 = a("/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD");
            if (a10 != null && a11 != null && a12 != null && a13 != null) {
                this.f13499c = e.a(c.a(a10), c.a(a11), c.a(a12), c.a(a13));
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException unused) {
            Log.e("SecurityResourcesReader", "Exception when reading the 'K&I' for 'Config'.");
            this.f13499c = null;
        }
    }

    private String a(String str) {
        return super.a(str, (String) null);
    }

    private static byte[] a(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException {
        if (secretKey == null || bArr == null) {
            throw new NullPointerException("key or cipherText must not be null.");
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 1, 17);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKey, new IvParameterSpec(copyOfRange));
        return cipher.doFinal(bArr, copyOfRange.length + 1, (bArr.length - copyOfRange.length) - 1);
    }

    @Override // com.huawei.agconnect.config.a.f, com.huawei.agconnect.config.a.b
    public String a(String str, String str2) {
        if (this.f13499c == null) {
            Log.e("SecurityResourcesReader", "KEY is null return def directly");
            return str2;
        }
        synchronized (this.f13498b) {
            String str3 = this.f13497a.get(str);
            if (str3 != null) {
                return str3;
            }
            String a10 = a(str);
            if (a10 == null) {
                return str2;
            }
            try {
                String str4 = new String(a(this.f13499c, c.a(a10)), "UTF-8");
                this.f13497a.put(str, str4);
                return str4;
            } catch (UnsupportedEncodingException | GeneralSecurityException unused) {
                Log.e("SecurityResourcesReader", "Exception when reading the 'V' for 'Config'.");
                return str2;
            }
        }
    }
}
