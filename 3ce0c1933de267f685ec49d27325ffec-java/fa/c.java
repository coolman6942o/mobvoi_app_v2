package fa;

import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Objects;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.i;
import kotlin.text.d;
import kotlin.text.t;
/* compiled from: ApolloNetUtil.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f26373a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final b[] f26374b = {new b()};

    /* renamed from: c  reason: collision with root package name */
    private static final HostnameVerifier f26375c = fa.b.f26372a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ApolloNetUtil.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Exception {
        private final int code;

        public a(int i10, String str) {
            super(str);
            this.code = i10;
        }

        public final int a() {
            return this.code;
        }
    }

    /* compiled from: ApolloNetUtil.kt */
    /* loaded from: classes2.dex */
    public static final class b implements X509TrustManager {
        b() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            if (x509CertificateArr != null) {
                try {
                    X509Certificate x509Certificate = x509CertificateArr[0];
                    if (x509Certificate != null) {
                        x509Certificate.checkValidity();
                    }
                } catch (Exception unused) {
                    throw new CertificateException("Certificate not valid or trusted.");
                }
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(String str, SSLSession sSLSession) {
        return true;
    }

    private final String f(la.b bVar) {
        boolean p10;
        boolean D;
        k.a("NetUtil", "url = " + ((Object) bVar.d()) + ", method = " + ((Object) bVar.a()) + ", params = " + ((Object) bVar.b()));
        URLConnection openConnection = new URL(bVar.d()).openConnection();
        Objects.requireNonNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        String d10 = bVar.d();
        boolean z10 = false;
        if (d10 != null) {
            D = t.D(d10, "https", false, 2, null);
            if (D) {
                z10 = true;
            }
        }
        if (z10) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            g(httpsURLConnection);
            httpsURLConnection.setHostnameVerifier(f26375c);
        }
        p10 = t.p("get", bVar.a(), true);
        if (p10) {
            httpURLConnection.setRequestMethod("GET");
        } else {
            httpURLConnection.setRequestMethod("POST");
        }
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.connect();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        String b10 = bVar.b();
        if (b10 != null) {
            byte[] bytes = b10.getBytes(d.f30092a);
            i.e(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
        }
        outputStream.flush();
        int responseCode = httpURLConnection.getResponseCode();
        k.a("NetUtil", i.n("response code ", Integer.valueOf(responseCode)));
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer("");
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuffer.append(readLine);
                } else {
                    bufferedReader.close();
                    String stringBuffer2 = stringBuffer.toString();
                    i.e(stringBuffer2, "sb.toString()");
                    return stringBuffer2;
                }
            }
        } else {
            outputStream.close();
            throw new a(responseCode, httpURLConnection.getResponseMessage());
        }
    }

    private final void g(HttpsURLConnection httpsURLConnection) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, f26374b, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final String c(int i10, String str, String str2) {
        return "{\"code\": " + i10 + ", \"content\": \"" + ((Object) str) + "\", \"source\": \"" + ((Object) str2) + "\"}";
    }

    public final String d(la.b request) {
        i.f(request, "request");
        if (TextUtils.isEmpty(request.c())) {
            return c(101, "Must have source.", request.c());
        }
        if (TextUtils.isEmpty(request.d())) {
            return c(101, "Must have url.", request.c());
        }
        try {
            return c(200, f(request), request.c());
        } catch (a e10) {
            return c(e10.a(), e10.getMessage(), request.c());
        } catch (Exception e11) {
            k.a("NetUtil", i.n("error do http request ", e11.getMessage()));
            return c(100, e11.getMessage(), request.c());
        }
    }

    public final String e(la.b request) {
        i.f(request, "request");
        if (TextUtils.isEmpty(request.d())) {
            return "{\"code\": 101, \"msg\": \"Must have url.\"}";
        }
        try {
            return f(request);
        } catch (a e10) {
            return "{\"code\": " + e10.a() + '}';
        } catch (Exception e11) {
            k.a("NetUtil", i.n("error do http request ", e11.getMessage()));
            return "{\"code\": 100, \"msg\": \"" + ((Object) e11.getMessage()) + "\"}";
        }
    }
}
