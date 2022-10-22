package com.paypal.android.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.l;
import okhttp3.y;
/* loaded from: classes2.dex */
public class z0 {
    public static y.a a(int i10, boolean z10, boolean z11, String str, String str2) {
        y.a f10 = new y.a().f(Arrays.asList(l.f32225g));
        long longValue = Integer.valueOf(i10).longValue();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f10.e(longValue, timeUnit);
        f10.M(Integer.valueOf(i10).longValue(), timeUnit);
        f10.L().add(new c1(str));
        if (!z10) {
            try {
                if (z11) {
                    b(f10);
                } else {
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    trustManagerFactory.init((KeyStore) null);
                    c(f10, trustManagerFactory.getTrustManagers());
                }
            } catch (IOException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | CertificateException e10) {
                throw new RuntimeException(e10);
            }
        }
        return f10;
    }

    private static void b(y.a aVar) {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        InputStream a10 = a1.a();
        try {
            for (Certificate certificate : certificateFactory.generateCertificates(a1.a())) {
                if (certificate instanceof X509Certificate) {
                    keyStore.setCertificateEntry(((X509Certificate) certificate).getSubjectDN().getName(), certificate);
                }
            }
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            c(aVar, trustManagerFactory.getTrustManagers());
        } finally {
            try {
                a10.close();
            } catch (IOException | NullPointerException unused) {
            }
        }
    }

    private static void c(y.a aVar, TrustManager[] trustManagerArr) {
        if (trustManagerArr.length != 1 || !(trustManagerArr[0] instanceof X509TrustManager)) {
            throw new IllegalStateException("Unexpected number of trust managers:" + Arrays.toString(trustManagerArr));
        }
        X509TrustManager x509TrustManager = (X509TrustManager) trustManagerArr[0];
        aVar.N(new b1(x509TrustManager), x509TrustManager);
    }
}
