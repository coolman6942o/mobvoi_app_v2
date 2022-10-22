package np;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.i;
import okhttp3.Protocol;
/* compiled from: DeferredSocketAdapter.kt */
/* loaded from: classes3.dex */
public final class j implements k {

    /* renamed from: a  reason: collision with root package name */
    private k f31338a;

    /* renamed from: b  reason: collision with root package name */
    private final a f31339b;

    /* compiled from: DeferredSocketAdapter.kt */
    /* loaded from: classes3.dex */
    public interface a {
        boolean a(SSLSocket sSLSocket);

        k b(SSLSocket sSLSocket);
    }

    public j(a socketAdapterFactory) {
        i.f(socketAdapterFactory, "socketAdapterFactory");
        this.f31339b = socketAdapterFactory;
    }

    private final synchronized k e(SSLSocket sSLSocket) {
        if (this.f31338a == null && this.f31339b.a(sSLSocket)) {
            this.f31338a = this.f31339b.b(sSLSocket);
        }
        return this.f31338a;
    }

    @Override // np.k
    public boolean a(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
        return this.f31339b.a(sslSocket);
    }

    @Override // np.k
    public boolean b() {
        return true;
    }

    @Override // np.k
    public String c(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
        k e10 = e(sslSocket);
        if (e10 != null) {
            return e10.c(sslSocket);
        }
        return null;
    }

    @Override // np.k
    public void d(SSLSocket sslSocket, String str, List<? extends Protocol> protocols) {
        i.f(sslSocket, "sslSocket");
        i.f(protocols, "protocols");
        k e10 = e(sslSocket);
        if (e10 != null) {
            e10.d(sslSocket, str, protocols);
        }
    }
}
