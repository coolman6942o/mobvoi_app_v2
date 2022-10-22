package np;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.Protocol;
import okhttp3.internal.platform.h;
/* compiled from: Android10SocketAdapter.kt */
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public final class a implements k {

    /* renamed from: a  reason: collision with root package name */
    public static final C0414a f31314a = new C0414a(null);

    /* compiled from: Android10SocketAdapter.kt */
    /* renamed from: np.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0414a {
        private C0414a() {
        }

        public final k a() {
            if (b()) {
                return new a();
            }
            return null;
        }

        public final boolean b() {
            return h.f32213c.h() && Build.VERSION.SDK_INT >= 29;
        }

        public /* synthetic */ C0414a(f fVar) {
            this();
        }
    }

    @Override // np.k
    public boolean a(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sslSocket);
    }

    @Override // np.k
    public boolean b() {
        return f31314a.b();
    }

    @Override // np.k
    @SuppressLint({"NewApi"})
    public String c(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
        String applicationProtocol = sslSocket.getApplicationProtocol();
        if (applicationProtocol != null && (applicationProtocol.hashCode() != 0 || !applicationProtocol.equals(""))) {
            return applicationProtocol;
        }
        return null;
    }

    @Override // np.k
    @SuppressLint({"NewApi"})
    public void d(SSLSocket sslSocket, String str, List<? extends Protocol> protocols) {
        i.f(sslSocket, "sslSocket");
        i.f(protocols, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sslSocket, true);
            SSLParameters sslParameters = sslSocket.getSSLParameters();
            i.e(sslParameters, "sslParameters");
            Object[] array = h.f32213c.b(protocols).toArray(new String[0]);
            if (array != null) {
                sslParameters.setApplicationProtocols((String[]) array);
                sslSocket.setSSLParameters(sslParameters);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IllegalArgumentException e10) {
            throw new IOException("Android internal error", e10);
        }
    }
}
