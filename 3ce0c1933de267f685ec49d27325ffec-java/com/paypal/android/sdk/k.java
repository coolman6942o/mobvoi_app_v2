package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
/* loaded from: classes2.dex */
public class k {
    private static boolean b(PackageManager packageManager, String str, String str2, String str3, int i10) {
        Signature[] signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        int length = signatureArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            try {
                X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signatureArr[i11].toByteArray()));
                String name = x509Certificate.getSubjectX500Principal().getName();
                String name2 = x509Certificate.getIssuerX500Principal().getName();
                int hashCode = x509Certificate.getPublicKey().hashCode();
                if (str2.equals(name)) {
                    return str3.equals(name2) && i10 == hashCode;
                }
                return false;
            } catch (CertificateException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(Context context, boolean z10, String str, String str2, String str3, int i10) {
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getApplicationInfo(str, 4224);
            if (z10) {
                if (!b(packageManager, str, str2, str3, 34172764)) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
