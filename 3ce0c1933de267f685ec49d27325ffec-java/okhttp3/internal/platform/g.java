package okhttp3.internal.platform;

import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.Protocol;
import org.openjsse.javax.net.ssl.SSLParameters;
import org.openjsse.net.ssl.OpenJSSE;
/* compiled from: OpenJSSEPlatform.kt */
/* loaded from: classes3.dex */
public final class g extends h {

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f32208e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f32209f;

    /* renamed from: d  reason: collision with root package name */
    private final Provider f32210d;

    /* compiled from: OpenJSSEPlatform.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final g a() {
            if (b()) {
                return new g(null);
            }
            return null;
        }

        public final boolean b() {
            return g.f32208e;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        f32209f = aVar;
        boolean z10 = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, aVar.getClass().getClassLoader());
            z10 = true;
        } catch (ClassNotFoundException unused) {
        }
        f32208e = z10;
    }

    private g() {
        this.f32210d = new OpenJSSE();
    }

    @Override // okhttp3.internal.platform.h
    public void e(SSLSocket sslSocket, String str, List<Protocol> protocols) {
        i.f(sslSocket, "sslSocket");
        i.f(protocols, "protocols");
        if (sslSocket instanceof org.openjsse.javax.net.ssl.SSLSocket) {
            org.openjsse.javax.net.ssl.SSLSocket sSLSocket = (org.openjsse.javax.net.ssl.SSLSocket) sslSocket;
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            if (sSLParameters instanceof SSLParameters) {
                Object[] array = h.f32213c.b(protocols).toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                sSLParameters.setApplicationProtocols((String[]) array);
                sSLSocket.setSSLParameters(sSLParameters);
                return;
            }
            return;
        }
        super.e(sslSocket, str, protocols);
    }

    @Override // okhttp3.internal.platform.h
    public String h(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
        if (!(sslSocket instanceof org.openjsse.javax.net.ssl.SSLSocket)) {
            return super.h(sslSocket);
        }
        String applicationProtocol = ((org.openjsse.javax.net.ssl.SSLSocket) sslSocket).getApplicationProtocol();
        if (applicationProtocol != null && (applicationProtocol.hashCode() != 0 || !applicationProtocol.equals(""))) {
            return applicationProtocol;
        }
        return null;
    }

    @Override // okhttp3.internal.platform.h
    public SSLContext n() {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.f32210d);
        i.e(sSLContext, "SSLContext.getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    @Override // okhttp3.internal.platform.h
    public X509TrustManager p() {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.f32210d);
        factory.init((KeyStore) null);
        i.e(factory, "factory");
        TrustManager[] trustManagers = factory.getTrustManagers();
        i.d(trustManagers);
        boolean z10 = true;
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            z10 = false;
        }
        if (z10) {
            TrustManager trustManager = trustManagers[0];
            Objects.requireNonNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            return (X509TrustManager) trustManager;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unexpected default trust managers: ");
        String arrays = Arrays.toString(trustManagers);
        i.e(arrays, "java.util.Arrays.toString(this)");
        sb2.append(arrays);
        throw new IllegalStateException(sb2.toString().toString());
    }

    public /* synthetic */ g(f fVar) {
        this();
    }
}
