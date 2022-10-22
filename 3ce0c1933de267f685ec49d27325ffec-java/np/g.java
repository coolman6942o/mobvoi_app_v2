package np;

import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import np.j;
import okhttp3.Protocol;
import okhttp3.internal.platform.c;
import okhttp3.internal.platform.h;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
/* compiled from: BouncyCastleSocketAdapter.kt */
/* loaded from: classes3.dex */
public final class g implements k {

    /* renamed from: b  reason: collision with root package name */
    public static final b f31331b = new b(null);

    /* renamed from: a  reason: collision with root package name */
    private static final j.a f31330a = new a();

    /* compiled from: BouncyCastleSocketAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a implements j.a {
        a() {
        }

        @Override // np.j.a
        public boolean a(SSLSocket sslSocket) {
            i.f(sslSocket, "sslSocket");
            return c.f32191f.b() && (sslSocket instanceof BCSSLSocket);
        }

        @Override // np.j.a
        public k b(SSLSocket sslSocket) {
            i.f(sslSocket, "sslSocket");
            return new g();
        }
    }

    /* compiled from: BouncyCastleSocketAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public final j.a a() {
            return g.f31330a;
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    @Override // np.k
    public boolean a(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
        return sslSocket instanceof BCSSLSocket;
    }

    @Override // np.k
    public boolean b() {
        return c.f32191f.b();
    }

    @Override // np.k
    public String c(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sslSocket).getApplicationProtocol();
        if (applicationProtocol != null && (applicationProtocol.hashCode() != 0 || !applicationProtocol.equals(""))) {
            return applicationProtocol;
        }
        return null;
    }

    @Override // np.k
    public void d(SSLSocket sslSocket, String str, List<? extends Protocol> protocols) {
        i.f(sslSocket, "sslSocket");
        i.f(protocols, "protocols");
        if (a(sslSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sslSocket;
            BCSSLParameters sslParameters = bCSSLSocket.getParameters();
            i.e(sslParameters, "sslParameters");
            Object[] array = h.f32213c.b(protocols).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            sslParameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(sslParameters);
        }
    }
}
