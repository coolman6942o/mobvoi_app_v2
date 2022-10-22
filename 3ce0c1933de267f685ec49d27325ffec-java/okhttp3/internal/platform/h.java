package okhttp3.internal.platform;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.n;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import np.c;
import okhttp3.Protocol;
import okhttp3.y;
import pp.b;
import pp.e;
/* compiled from: Platform.kt */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static volatile h f32211a;

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f32212b = Logger.getLogger(y.class.getName());

    /* renamed from: c  reason: collision with root package name */
    public static final a f32213c;

    /* compiled from: Platform.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        private final h d() {
            c.f31320c.b();
            h a10 = okhttp3.internal.platform.a.f32182f.a();
            if (a10 != null) {
                return a10;
            }
            h a11 = b.f32185g.a();
            i.d(a11);
            return a11;
        }

        private final h e() {
            g a10;
            c a11;
            d b10;
            if (j() && (b10 = d.f32194f.b()) != null) {
                return b10;
            }
            if (i() && (a11 = c.f32191f.a()) != null) {
                return a11;
            }
            if (k() && (a10 = g.f32209f.a()) != null) {
                return a10;
            }
            f a12 = f.f32207e.a();
            if (a12 != null) {
                return a12;
            }
            h a13 = e.f32197i.a();
            return a13 != null ? a13 : new h();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final h f() {
            if (h()) {
                return d();
            }
            return e();
        }

        private final boolean i() {
            Provider provider = Security.getProviders()[0];
            i.e(provider, "Security.getProviders()[0]");
            return i.b("BC", provider.getName());
        }

        private final boolean j() {
            Provider provider = Security.getProviders()[0];
            i.e(provider, "Security.getProviders()[0]");
            return i.b("Conscrypt", provider.getName());
        }

        private final boolean k() {
            Provider provider = Security.getProviders()[0];
            i.e(provider, "Security.getProviders()[0]");
            return i.b("OpenJSSE", provider.getName());
        }

        public final List<String> b(List<? extends Protocol> protocols) {
            int p10;
            i.f(protocols, "protocols");
            ArrayList<Protocol> arrayList = new ArrayList();
            for (Object obj : protocols) {
                if (((Protocol) obj) != Protocol.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            p10 = n.p(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(p10);
            for (Protocol protocol : arrayList) {
                arrayList2.add(protocol.toString());
            }
            return arrayList2;
        }

        public final byte[] c(List<? extends Protocol> protocols) {
            i.f(protocols, "protocols");
            okio.c cVar = new okio.c();
            for (String str : b(protocols)) {
                cVar.C(str.length());
                cVar.R(str);
            }
            return cVar.z();
        }

        public final h g() {
            return h.f32211a;
        }

        public final boolean h() {
            return i.b("Dalvik", System.getProperty("java.vm.name"));
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        f32213c = aVar;
        f32211a = aVar.f();
    }

    public static /* synthetic */ void l(h hVar, String str, int i10, Throwable th2, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                i10 = 4;
            }
            if ((i11 & 4) != 0) {
                th2 = null;
            }
            hVar.k(str, i10, th2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }

    public void b(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
    }

    public pp.c c(X509TrustManager trustManager) {
        i.f(trustManager, "trustManager");
        return new pp.a(d(trustManager));
    }

    public e d(X509TrustManager trustManager) {
        i.f(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        i.e(acceptedIssuers, "trustManager.acceptedIssuers");
        return new b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void e(SSLSocket sslSocket, String str, List<Protocol> protocols) {
        i.f(sslSocket, "sslSocket");
        i.f(protocols, "protocols");
    }

    public void f(Socket socket, InetSocketAddress address, int i10) throws IOException {
        i.f(socket, "socket");
        i.f(address, "address");
        socket.connect(address, i10);
    }

    public final String g() {
        return "OkHttp";
    }

    public String h(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
        return null;
    }

    public Object i(String closer) {
        i.f(closer, "closer");
        if (f32212b.isLoggable(Level.FINE)) {
            return new Throwable(closer);
        }
        return null;
    }

    public boolean j(String hostname) {
        i.f(hostname, "hostname");
        return true;
    }

    public void k(String message, int i10, Throwable th2) {
        i.f(message, "message");
        f32212b.log(i10 == 5 ? Level.WARNING : Level.INFO, message, th2);
    }

    public void m(String message, Object obj) {
        i.f(message, "message");
        if (obj == null) {
            message = message + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        k(message, 5, (Throwable) obj);
    }

    public SSLContext n() {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        i.e(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory o(X509TrustManager trustManager) {
        i.f(trustManager, "trustManager");
        try {
            SSLContext n10 = n();
            n10.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = n10.getSocketFactory();
            i.e(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e10) {
            throw new AssertionError("No System TLS: " + e10, e10);
        }
    }

    public X509TrustManager p() {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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

    public String toString() {
        String simpleName = getClass().getSimpleName();
        i.e(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
