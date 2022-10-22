package com.tendcloud.tenddata;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
/* compiled from: td */
/* loaded from: classes2.dex */
class cs {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: td */
    /* loaded from: classes2.dex */
    public static class a {
        a() {
        }

        public static String encode(byte[] bArr) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuilder sb2 = new StringBuilder(bArr.length * 2);
            for (int i10 = 0; i10 < bArr.length; i10++) {
                sb2.append(cArr[(bArr[i10] & 240) >> 4]);
                sb2.append(cArr[bArr[i10] & 15]);
            }
            return sb2.toString();
        }
    }

    cs() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(Context context) {
        String packageName = context.getPackageName();
        String a10 = a(context, packageName);
        return a10 + packageName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(Context context, String str) {
        String str2;
        try {
            str2 = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray())));
        } catch (PackageManager.NameNotFoundException | CertificateException unused) {
            str2 = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < str2.length(); i10++) {
            stringBuffer.append(str2.charAt(i10));
            if (i10 > 0 && i10 % 2 == 1 && i10 < str2.length() - 1) {
                stringBuffer.append(":");
            }
        }
        return stringBuffer.toString();
    }

    static String a(X509Certificate x509Certificate) {
        try {
            return a.encode(a(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException unused) {
            return null;
        }
    }

    static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        try {
            return MessageDigest.getInstance("SHA1").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return bArr2;
        }
    }
}
