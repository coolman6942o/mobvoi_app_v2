package np;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import pp.c;
/* compiled from: AndroidCertificateChainCleaner.kt */
/* loaded from: classes3.dex */
public final class b extends c {

    /* renamed from: d  reason: collision with root package name */
    public static final a f31315d = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final X509TrustManager f31316b;

    /* renamed from: c  reason: collision with root package name */
    private final X509TrustManagerExtensions f31317c;

    /* compiled from: AndroidCertificateChainCleaner.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final b a(X509TrustManager trustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            i.f(trustManager, "trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(trustManager);
            } catch (IllegalArgumentException unused) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions != null) {
                return new b(trustManager, x509TrustManagerExtensions);
            }
            return null;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public b(X509TrustManager trustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        i.f(trustManager, "trustManager");
        i.f(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.f31316b = trustManager;
        this.f31317c = x509TrustManagerExtensions;
    }

    @Override // pp.c
    public List<Certificate> a(List<? extends Certificate> chain, String hostname) throws SSLPeerUnverifiedException {
        i.f(chain, "chain");
        i.f(hostname, "hostname");
        Object[] array = chain.toArray(new X509Certificate[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        try {
            List<X509Certificate> checkServerTrusted = this.f31317c.checkServerTrusted((X509Certificate[]) array, "RSA", hostname);
            i.e(checkServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return checkServerTrusted;
        } catch (CertificateException e10) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e10.getMessage());
            sSLPeerUnverifiedException.initCause(e10);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).f31316b == this.f31316b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f31316b);
    }
}
