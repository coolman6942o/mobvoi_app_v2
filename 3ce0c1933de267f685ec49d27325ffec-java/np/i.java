package np;

import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.f;
import np.j;
import okhttp3.Protocol;
import okhttp3.internal.platform.d;
import okhttp3.internal.platform.h;
import org.conscrypt.Conscrypt;
/* compiled from: ConscryptSocketAdapter.kt */
/* loaded from: classes3.dex */
public final class i implements k {

    /* renamed from: b  reason: collision with root package name */
    public static final b f31337b = new b(null);

    /* renamed from: a  reason: collision with root package name */
    private static final j.a f31336a = new a();

    /* compiled from: ConscryptSocketAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a implements j.a {
        a() {
        }

        @Override // np.j.a
        public boolean a(SSLSocket sslSocket) {
            kotlin.jvm.internal.i.f(sslSocket, "sslSocket");
            return d.f32194f.c() && Conscrypt.isConscrypt(sslSocket);
        }

        @Override // np.j.a
        public k b(SSLSocket sslSocket) {
            kotlin.jvm.internal.i.f(sslSocket, "sslSocket");
            return new i();
        }
    }

    /* compiled from: ConscryptSocketAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public final j.a a() {
            return i.f31336a;
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    @Override // np.k
    public boolean a(SSLSocket sslSocket) {
        kotlin.jvm.internal.i.f(sslSocket, "sslSocket");
        return Conscrypt.isConscrypt(sslSocket);
    }

    @Override // np.k
    public boolean b() {
        return d.f32194f.c();
    }

    @Override // np.k
    public String c(SSLSocket sslSocket) {
        kotlin.jvm.internal.i.f(sslSocket, "sslSocket");
        if (a(sslSocket)) {
            return Conscrypt.getApplicationProtocol(sslSocket);
        }
        return null;
    }

    @Override // np.k
    public void d(SSLSocket sslSocket, String str, List<? extends Protocol> protocols) {
        kotlin.jvm.internal.i.f(sslSocket, "sslSocket");
        kotlin.jvm.internal.i.f(protocols, "protocols");
        if (a(sslSocket)) {
            Conscrypt.setUseSessionTickets(sslSocket, true);
            Object[] array = h.f32213c.b(protocols).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Conscrypt.setApplicationProtocols(sslSocket, (String[]) array);
        }
    }
}
