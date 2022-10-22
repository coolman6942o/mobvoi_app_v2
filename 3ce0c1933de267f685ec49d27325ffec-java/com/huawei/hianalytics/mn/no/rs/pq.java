package com.huawei.hianalytics.mn.no.rs;

import android.content.Context;
import com.huawei.hianalytics.mn.no.qr.mn;
import java.io.Closeable;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes.dex */
public class pq implements X509TrustManager {

    /* renamed from: mn  reason: collision with root package name */
    protected List<X509TrustManager> f13616mn = new ArrayList();

    public pq(Context context) {
        if (context != null) {
            InputStream inputStream = null;
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                KeyStore keyStore = KeyStore.getInstance("bks");
                inputStream = context.getAssets().open("updatesdkcas.bks");
                inputStream.reset();
                keyStore.load(inputStream, "".toCharArray());
                trustManagerFactory.init(keyStore);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                for (int i10 = 0; i10 < trustManagers.length; i10++) {
                    if (trustManagers[i10] instanceof X509TrustManager) {
                        this.f13616mn.add((X509TrustManager) trustManagers[i10]);
                    }
                }
                if (this.f13616mn.isEmpty()) {
                    throw new CertificateException("X509TrustManager is empty");
                }
            } finally {
                com.huawei.hianalytics.mn.no.b.pq.mn((Closeable) inputStream);
            }
        } else {
            throw new IllegalArgumentException("context is null,can not read CA");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (!this.f13616mn.isEmpty()) {
            this.f13616mn.get(0).checkClientTrusted(x509CertificateArr, str);
            return;
        }
        throw new CertificateException("checkClientTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (!this.f13616mn.isEmpty()) {
            this.f13616mn.get(0).checkServerTrusted(x509CertificateArr, str);
            return;
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            for (X509TrustManager x509TrustManager : this.f13616mn) {
                arrayList.addAll(Arrays.asList(x509TrustManager.getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e10) {
            mn.pq("SecureX509TrustManager", "getAcceptedIssuers exception : " + e10.getMessage());
            return new X509Certificate[0];
        }
    }
}
