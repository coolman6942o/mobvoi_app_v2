package hp;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import java.util.Objects;
import kotlin.collections.k;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import okhttp3.a;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.h;
import okhttp3.o;
import okhttp3.q;
import okhttp3.u;
import okhttp3.z;
/* compiled from: JavaNetAuthenticator.kt */
/* loaded from: classes3.dex */
public final class b implements okhttp3.b {

    /* renamed from: b  reason: collision with root package name */
    private final q f27904b;

    public b(q defaultDns) {
        i.f(defaultDns, "defaultDns");
        this.f27904b = defaultDns;
    }

    private final InetAddress b(Proxy proxy, u uVar, q qVar) throws IOException {
        Proxy.Type type = proxy.type();
        if (type != null && a.f27903a[type.ordinal()] == 1) {
            return (InetAddress) k.F(qVar.a(uVar.h()));
        }
        SocketAddress address = proxy.address();
        Objects.requireNonNull(address, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress address2 = ((InetSocketAddress) address).getAddress();
        i.e(address2, "(address() as InetSocketAddress).address");
        return address2;
    }

    @Override // okhttp3.b
    public z a(d0 d0Var, b0 response) throws IOException {
        Proxy proxy;
        boolean p10;
        q qVar;
        PasswordAuthentication passwordAuthentication;
        a a10;
        i.f(response, "response");
        List<h> i10 = response.i();
        z g02 = response.g0();
        u l10 = g02.l();
        boolean z10 = response.n() == 407;
        if (d0Var == null || (proxy = d0Var.b()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (h hVar : i10) {
            p10 = t.p("Basic", hVar.c(), true);
            if (p10) {
                if (d0Var == null || (a10 = d0Var.a()) == null || (qVar = a10.c()) == null) {
                    qVar = this.f27904b;
                }
                if (z10) {
                    SocketAddress address = proxy.address();
                    Objects.requireNonNull(address, "null cannot be cast to non-null type java.net.InetSocketAddress");
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                    String hostName = inetSocketAddress.getHostName();
                    i.e(proxy, "proxy");
                    passwordAuthentication = Authenticator.requestPasswordAuthentication(hostName, b(proxy, l10, qVar), inetSocketAddress.getPort(), l10.t(), hVar.b(), hVar.c(), l10.v(), Authenticator.RequestorType.PROXY);
                } else {
                    String h10 = l10.h();
                    i.e(proxy, "proxy");
                    passwordAuthentication = Authenticator.requestPasswordAuthentication(h10, b(proxy, l10, qVar), l10.n(), l10.t(), hVar.b(), hVar.c(), l10.v(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthentication != null) {
                    String str = z10 ? "Proxy-Authorization" : "Authorization";
                    String userName = passwordAuthentication.getUserName();
                    i.e(userName, "auth.userName");
                    char[] password = passwordAuthentication.getPassword();
                    i.e(password, "auth.password");
                    return g02.i().h(str, o.a(userName, new String(password), hVar.a())).b();
                }
            }
        }
        return null;
    }

    public /* synthetic */ b(q qVar, int i10, f fVar) {
        this((i10 & 1) != 0 ? q.f32261a : qVar);
    }
}
