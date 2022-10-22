package com.unionpay.mobile.android.net;

import android.content.Context;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.text.TextUtils;
import com.unionpay.mobile.android.utils.c;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes2.dex */
public final class b implements X509TrustManager {

    /* renamed from: a  reason: collision with root package name */
    private X509TrustManager f23554a;

    /* renamed from: b  reason: collision with root package name */
    private X509TrustManagerExtensions f23555b;

    /* renamed from: c  reason: collision with root package name */
    private Context f23556c;

    public b(Context context) throws NoSuchAlgorithmException, KeyStoreException {
        this.f23554a = null;
        this.f23555b = null;
        this.f23556c = context;
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length != 0) {
            this.f23554a = (X509TrustManager) trustManagers[0];
            if (Build.VERSION.SDK_INT > 23) {
                this.f23555b = new X509TrustManagerExtensions(this.f23554a);
                return;
            }
            return;
        }
        throw new NoSuchAlgorithmException("no trust manager found");
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.f23554a.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        boolean z10;
        X509TrustManagerExtensions x509TrustManagerExtensions;
        if (Build.VERSION.SDK_INT <= 23 || (x509TrustManagerExtensions = this.f23555b) == null) {
            this.f23554a.checkServerTrusted(x509CertificateArr, str);
        } else {
            x509TrustManagerExtensions.checkServerTrusted(x509CertificateArr, str, "");
        }
        boolean z11 = false;
        try {
            X500Principal issuerX500Principal = x509CertificateArr[0].getIssuerX500Principal();
            ArrayList arrayList = new ArrayList(0);
            arrayList.add(".*(GeoTrust|VeriSign|Symantec|GlobalSign|Entrust|Thawte|DigiCert).*");
            String a10 = c.a(this.f23556c);
            if (!TextUtils.isEmpty(a10)) {
                arrayList.add(a10);
            }
            int i10 = 0;
            while (true) {
                if (i10 >= arrayList.size()) {
                    z10 = false;
                    break;
                } else if (Pattern.compile((String) arrayList.get(i10), 2).matcher(issuerX500Principal.getName()).matches()) {
                    z10 = true;
                    break;
                } else {
                    i10++;
                }
            }
            if (z10) {
                X500Principal subjectX500Principal = x509CertificateArr[0].getSubjectX500Principal();
                ArrayList arrayList2 = new ArrayList(0);
                arrayList2.add(".*CN=.*(\\.95516\\.com|\\.chinaunionpay\\.com|\\.unionpay\\.com|\\.unionpaysecure\\.com|\\.95516\\.net)(,.*|$)");
                int i11 = 0;
                while (true) {
                    if (i11 >= arrayList2.size()) {
                        break;
                    } else if (Pattern.compile((String) arrayList2.get(i11), 2).matcher(subjectX500Principal.getName()).matches()) {
                        z11 = true;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (!z11) {
                    throw new CertificateException();
                }
                return;
            }
            throw new CertificateException();
        } catch (Exception unused) {
            throw new CertificateException();
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public final X509Certificate[] getAcceptedIssuers() {
        return this.f23554a.getAcceptedIssuers();
    }
}
