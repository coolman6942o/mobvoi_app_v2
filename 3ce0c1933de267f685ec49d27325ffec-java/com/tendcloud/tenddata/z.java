package com.tendcloud.tenddata;

import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import java.io.ByteArrayInputStream;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public static volatile HashMap<Long, String> f23035a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f23036b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /* renamed from: c  reason: collision with root package name */
    private static final int f23037c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f23038d = 7;

    /* compiled from: td */
    /* loaded from: classes2.dex */
    static class a implements X509TrustManager {
        X509Certificate cert;

        a(X509Certificate x509Certificate) {
            this.cert = x509Certificate;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            String[] split;
            int indexOf;
            int length = x509CertificateArr.length;
            x509CertificateArr[0].getIssuerDN().equals(this.cert.getSubjectDN());
            try {
                String name = x509CertificateArr[0].getSubjectDN().getName();
                int indexOf2 = name.indexOf("CN=");
                if (indexOf2 >= 0 && (indexOf = (name = name.substring(indexOf2 + 3)).indexOf(",")) >= 0) {
                    name = name.substring(0, indexOf);
                }
                if (name.split("\\.").length >= 2) {
                    name = split[split.length - 2] + "." + split[split.length - 1];
                }
                if (!z.f23035a.containsKey(Long.valueOf(Thread.currentThread().getId()))) {
                    throw new CertificateException("No valid host provided!");
                } else if (z.f23035a.get(Long.valueOf(Thread.currentThread().getId())).endsWith(name)) {
                    x509CertificateArr[0].verify(this.cert.getPublicKey());
                    x509CertificateArr[0].checkValidity();
                } else {
                    throw new CertificateException("Server certificate has incorrect host name!");
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
                boolean z10 = th2 instanceof CertificateException;
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    private static void a(HttpsURLConnection httpsURLConnection) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, SSLSession sSLSession) {
        try {
            return a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean c(String str, X509Certificate x509Certificate) {
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> a10 = a(x509Certificate, 2);
        int size = a10.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (a(lowerCase, a10.get(i10))) {
                return true;
            }
        }
        return false;
    }

    public static void setHostNameVerifyAllowAll(URLConnection uRLConnection) {
        final HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
        httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.tendcloud.tenddata.z.1
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                try {
                    if (z.b(str, sSLSession)) {
                        return true;
                    }
                    return str.equals(httpsURLConnection.getURL().getHost());
                } catch (Throwable unused) {
                    return false;
                }
            }
        });
    }

    public static SSLSocketFactory a(X509Certificate x509Certificate) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            if (x509Certificate != null) {
                sSLContext.init(null, new TrustManager[]{new a(x509Certificate)}, null);
            } else {
                sSLContext.init(null, null, null);
            }
            return sSLContext.getSocketFactory();
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return null;
        }
    }

    private static boolean b(String str) {
        return f23036b.matcher(str).matches();
    }

    private static boolean b(String str, X509Certificate x509Certificate) {
        List<String> a10 = a(x509Certificate, 7);
        int size = a10.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equalsIgnoreCase(a10.get(i10))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(URLConnection uRLConnection, String str) {
        SSLContext sSLContext;
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
            if (u.a(16)) {
                sSLContext = SSLContext.getInstance("TLSv1.2");
            } else {
                sSLContext = SSLContext.getInstance("TLSv1");
            }
            sSLContext.init(null, new TrustManager[]{new a(a(str))}, null);
            httpsURLConnection.getHostnameVerifier();
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            a(httpsURLConnection);
        } catch (Throwable unused) {
        }
    }

    private static boolean a(String str, X509Certificate x509Certificate) {
        return b(str) ? b(str, x509Certificate) : c(str, x509Certificate);
    }

    private static boolean a(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains(MessageProxyConstants.NODE_ID_ANY)) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }

    private static List<String> a(X509Certificate x509Certificate, int i10) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (!(list == null || list.size() < 2 || (num = (Integer) list.get(0)) == null || num.intValue() != i10 || (str = (String) list.get(1)) == null)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return Collections.emptyList();
        }
    }

    public static X509Certificate a(String str) {
        if (u.b(str)) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
        } catch (Throwable th2) {
            try {
                bf.postSDKError(th2);
                try {
                    byteArrayInputStream.close();
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            } finally {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
