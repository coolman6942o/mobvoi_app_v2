package okhttp3.internal.platform;

import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;
/* compiled from: ConscryptPlatform.kt */
/* loaded from: classes3.dex */
public final class d extends h {

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f32193e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f32194f;

    /* renamed from: d  reason: collision with root package name */
    private final Provider f32195d;

    /* compiled from: ConscryptPlatform.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final boolean a(int i10, int i11, int i12) {
            Conscrypt.Version version = Conscrypt.version();
            return version.major() != i10 ? version.major() > i10 : version.minor() != i11 ? version.minor() > i11 : version.patch() >= i12;
        }

        public final d b() {
            if (c()) {
                return new d(null);
            }
            return null;
        }

        public final boolean c() {
            return d.f32193e;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: ConscryptPlatform.kt */
    /* loaded from: classes3.dex */
    public static final class b implements ConscryptHostnameVerifier {

        /* renamed from: a  reason: collision with root package name */
        public static final b f32196a = new b();

        private b() {
        }
    }

    static {
        a aVar = new a(null);
        f32194f = aVar;
        boolean z10 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, aVar.getClass().getClassLoader());
            if (Conscrypt.isAvailable()) {
                if (aVar.a(2, 1, 0)) {
                    z10 = true;
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f32193e = z10;
    }

    private d() {
        Provider newProvider = Conscrypt.newProvider();
        i.e(newProvider, "Conscrypt.newProvider()");
        this.f32195d = newProvider;
    }

    @Override // okhttp3.internal.platform.h
    public void e(SSLSocket sslSocket, String str, List<Protocol> protocols) {
        i.f(sslSocket, "sslSocket");
        i.f(protocols, "protocols");
        if (Conscrypt.isConscrypt(sslSocket)) {
            Conscrypt.setUseSessionTickets(sslSocket, true);
            Object[] array = h.f32213c.b(protocols).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Conscrypt.setApplicationProtocols(sslSocket, (String[]) array);
            return;
        }
        super.e(sslSocket, str, protocols);
    }

    @Override // okhttp3.internal.platform.h
    public String h(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
        if (Conscrypt.isConscrypt(sslSocket)) {
            return Conscrypt.getApplicationProtocol(sslSocket);
        }
        return super.h(sslSocket);
    }

    @Override // okhttp3.internal.platform.h
    public SSLContext n() {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f32195d);
        i.e(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // okhttp3.internal.platform.h
    public SSLSocketFactory o(X509TrustManager trustManager) {
        i.f(trustManager, "trustManager");
        SSLContext n10 = n();
        n10.init(null, new TrustManager[]{trustManager}, null);
        SSLSocketFactory socketFactory = n10.getSocketFactory();
        i.e(socketFactory, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return socketFactory;
    }

    @Override // okhttp3.internal.platform.h
    public X509TrustManager p() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        i.e(trustManagerFactory, "TrustManagerFactory.getI…(null as KeyStore?)\n    }");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        i.d(trustManagers);
        boolean z10 = true;
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            z10 = false;
        }
        if (z10) {
            TrustManager trustManager = trustManagers[0];
            Objects.requireNonNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
            Conscrypt.setHostnameVerifier(x509TrustManager, b.f32196a);
            return x509TrustManager;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unexpected default trust managers: ");
        String arrays = Arrays.toString(trustManagers);
        i.e(arrays, "java.util.Arrays.toString(this)");
        sb2.append(arrays);
        throw new IllegalStateException(sb2.toString().toString());
    }

    public /* synthetic */ d(f fVar) {
        this();
    }
}
