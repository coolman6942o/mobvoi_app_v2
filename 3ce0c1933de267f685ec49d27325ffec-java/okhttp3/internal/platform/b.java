package okhttp3.internal.platform;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.m;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import np.g;
import np.h;
import np.j;
import np.k;
import np.l;
import okhttp3.Protocol;
import pp.c;
import pp.e;
/* compiled from: AndroidPlatform.kt */
/* loaded from: classes3.dex */
public final class b extends h {

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f32184f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f32185g = new a(null);

    /* renamed from: d  reason: collision with root package name */
    private final List<k> f32186d;

    /* renamed from: e  reason: collision with root package name */
    private final h f32187e;

    /* compiled from: AndroidPlatform.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final h a() {
            if (b()) {
                return new b();
            }
            return null;
        }

        public final boolean b() {
            return b.f32184f;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: AndroidPlatform.kt */
    /* renamed from: okhttp3.internal.platform.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0438b implements e {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f32188a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f32189b;

        public C0438b(X509TrustManager trustManager, Method findByIssuerAndSignatureMethod) {
            i.f(trustManager, "trustManager");
            i.f(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            this.f32188a = trustManager;
            this.f32189b = findByIssuerAndSignatureMethod;
        }

        @Override // pp.e
        public X509Certificate a(X509Certificate cert) {
            i.f(cert, "cert");
            try {
                Object invoke = this.f32189b.invoke(this.f32188a, cert);
                if (invoke != null) {
                    return ((TrustAnchor) invoke).getTrustedCert();
                }
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e10) {
                throw new AssertionError("unable to get issues and signature", e10);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0438b)) {
                return false;
            }
            C0438b bVar = (C0438b) obj;
            return i.b(this.f32188a, bVar.f32188a) && i.b(this.f32189b, bVar.f32189b);
        }

        public int hashCode() {
            X509TrustManager x509TrustManager = this.f32188a;
            int i10 = 0;
            int hashCode = (x509TrustManager != null ? x509TrustManager.hashCode() : 0) * 31;
            Method method = this.f32189b;
            if (method != null) {
                i10 = method.hashCode();
            }
            return hashCode + i10;
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.f32188a + ", findByIssuerAndSignatureMethod=" + this.f32189b + ")";
        }
    }

    static {
        int i10;
        boolean z10 = true;
        boolean z11 = false;
        if (h.f32213c.h() && (i10 = Build.VERSION.SDK_INT) < 30) {
            if (i10 >= 21) {
                z11 = true;
            }
            if (!z11) {
                throw new IllegalStateException(("Expected Android API level 21+ but was " + i10).toString());
            }
        } else {
            z10 = false;
        }
        f32184f = z10;
    }

    public b() {
        List k10;
        k10 = m.k(l.a.b(l.f31340h, null, 1, null), new j(np.f.f31323g.d()), new j(np.i.f31337b.a()), new j(g.f31331b.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : k10) {
            if (((k) obj).b()) {
                arrayList.add(obj);
            }
        }
        this.f32186d = arrayList;
        this.f32187e = h.f31332d.a();
    }

    @Override // okhttp3.internal.platform.h
    public c c(X509TrustManager trustManager) {
        i.f(trustManager, "trustManager");
        np.b a10 = np.b.f31315d.a(trustManager);
        return a10 != null ? a10 : super.c(trustManager);
    }

    @Override // okhttp3.internal.platform.h
    public e d(X509TrustManager trustManager) {
        i.f(trustManager, "trustManager");
        try {
            Method method = trustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            i.e(method, "method");
            method.setAccessible(true);
            return new C0438b(trustManager, method);
        } catch (NoSuchMethodException unused) {
            return super.d(trustManager);
        }
    }

    @Override // okhttp3.internal.platform.h
    public void e(SSLSocket sslSocket, String str, List<Protocol> protocols) {
        Object obj;
        i.f(sslSocket, "sslSocket");
        i.f(protocols, "protocols");
        Iterator<T> it = this.f32186d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((k) obj).a(sslSocket)) {
                break;
            }
        }
        k kVar = (k) obj;
        if (kVar != null) {
            kVar.d(sslSocket, str, protocols);
        }
    }

    @Override // okhttp3.internal.platform.h
    public void f(Socket socket, InetSocketAddress address, int i10) throws IOException {
        i.f(socket, "socket");
        i.f(address, "address");
        try {
            socket.connect(address, i10);
        } catch (ClassCastException e10) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", e10);
            }
            throw e10;
        }
    }

    @Override // okhttp3.internal.platform.h
    public String h(SSLSocket sslSocket) {
        Object obj;
        i.f(sslSocket, "sslSocket");
        Iterator<T> it = this.f32186d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((k) obj).a(sslSocket)) {
                break;
            }
        }
        k kVar = (k) obj;
        if (kVar != null) {
            return kVar.c(sslSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.h
    public Object i(String closer) {
        i.f(closer, "closer");
        return this.f32187e.a(closer);
    }

    @Override // okhttp3.internal.platform.h
    public boolean j(String hostname) {
        i.f(hostname, "hostname");
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
        }
        if (i10 < 23) {
            return true;
        }
        NetworkSecurityPolicy networkSecurityPolicy = NetworkSecurityPolicy.getInstance();
        i.e(networkSecurityPolicy, "NetworkSecurityPolicy.getInstance()");
        return networkSecurityPolicy.isCleartextTrafficPermitted();
    }

    @Override // okhttp3.internal.platform.h
    public void m(String message, Object obj) {
        i.f(message, "message");
        if (!this.f32187e.b(obj)) {
            h.l(this, message, 5, null, 4, null);
        }
    }
}
