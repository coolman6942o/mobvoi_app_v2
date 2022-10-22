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
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;
/* compiled from: BouncyCastlePlatform.kt */
/* loaded from: classes3.dex */
public final class c extends h {

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f32190e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f32191f;

    /* renamed from: d  reason: collision with root package name */
    private final Provider f32192d;

    /* compiled from: BouncyCastlePlatform.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final c a() {
            if (b()) {
                return new c(null);
            }
            return null;
        }

        public final boolean b() {
            return c.f32190e;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        f32191f = aVar;
        boolean z10 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, aVar.getClass().getClassLoader());
            z10 = true;
        } catch (ClassNotFoundException unused) {
        }
        f32190e = z10;
    }

    private c() {
        this.f32192d = new BouncyCastleJsseProvider();
    }

    @Override // okhttp3.internal.platform.h
    public void e(SSLSocket sslSocket, String str, List<Protocol> protocols) {
        i.f(sslSocket, "sslSocket");
        i.f(protocols, "protocols");
        if (sslSocket instanceof BCSSLSocket) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sslSocket;
            BCSSLParameters sslParameters = bCSSLSocket.getParameters();
            List<String> b10 = h.f32213c.b(protocols);
            i.e(sslParameters, "sslParameters");
            Object[] array = b10.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            sslParameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(sslParameters);
            return;
        }
        super.e(sslSocket, str, protocols);
    }

    @Override // okhttp3.internal.platform.h
    public String h(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
        if (!(sslSocket instanceof BCSSLSocket)) {
            return super.h(sslSocket);
        }
        String applicationProtocol = ((BCSSLSocket) sslSocket).getApplicationProtocol();
        if (applicationProtocol != null && (applicationProtocol.hashCode() != 0 || !applicationProtocol.equals(""))) {
            return applicationProtocol;
        }
        return null;
    }

    @Override // okhttp3.internal.platform.h
    public SSLContext n() {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f32192d);
        i.e(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // okhttp3.internal.platform.h
    public X509TrustManager p() {
        TrustManagerFactory factory = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
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

    public /* synthetic */ c(f fVar) {
        this();
    }
}
