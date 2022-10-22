package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: EventListener.kt */
/* loaded from: classes3.dex */
public abstract class r {

    /* renamed from: a  reason: collision with root package name */
    public static final r f32262a = new a();

    /* compiled from: EventListener.kt */
    /* loaded from: classes3.dex */
    public static final class a extends r {
        a() {
        }
    }

    /* compiled from: EventListener.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    /* compiled from: EventListener.kt */
    /* loaded from: classes3.dex */
    public interface c {
        r a(e eVar);
    }

    static {
        new b(null);
    }

    public void A(e call, b0 response) {
        i.f(call, "call");
        i.f(response, "response");
    }

    public void B(e call, t tVar) {
        i.f(call, "call");
    }

    public void C(e call) {
        i.f(call, "call");
    }

    public void a(e call, b0 cachedResponse) {
        i.f(call, "call");
        i.f(cachedResponse, "cachedResponse");
    }

    public void b(e call, b0 response) {
        i.f(call, "call");
        i.f(response, "response");
    }

    public void c(e call) {
        i.f(call, "call");
    }

    public void d(e call) {
        i.f(call, "call");
    }

    public void e(e call, IOException ioe) {
        i.f(call, "call");
        i.f(ioe, "ioe");
    }

    public void f(e call) {
        i.f(call, "call");
    }

    public void g(e call) {
        i.f(call, "call");
    }

    public void h(e call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        i.f(call, "call");
        i.f(inetSocketAddress, "inetSocketAddress");
        i.f(proxy, "proxy");
    }

    public void i(e call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        i.f(call, "call");
        i.f(inetSocketAddress, "inetSocketAddress");
        i.f(proxy, "proxy");
        i.f(ioe, "ioe");
    }

    public void j(e call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        i.f(call, "call");
        i.f(inetSocketAddress, "inetSocketAddress");
        i.f(proxy, "proxy");
    }

    public void k(e call, j connection) {
        i.f(call, "call");
        i.f(connection, "connection");
    }

    public void l(e call, j connection) {
        i.f(call, "call");
        i.f(connection, "connection");
    }

    public void m(e call, String domainName, List<InetAddress> inetAddressList) {
        i.f(call, "call");
        i.f(domainName, "domainName");
        i.f(inetAddressList, "inetAddressList");
    }

    public void n(e call, String domainName) {
        i.f(call, "call");
        i.f(domainName, "domainName");
    }

    public void o(e call, u url, List<Proxy> proxies) {
        i.f(call, "call");
        i.f(url, "url");
        i.f(proxies, "proxies");
    }

    public void p(e call, u url) {
        i.f(call, "call");
        i.f(url, "url");
    }

    public void q(e call, long j10) {
        i.f(call, "call");
    }

    public void r(e call) {
        i.f(call, "call");
    }

    public void s(e call, IOException ioe) {
        i.f(call, "call");
        i.f(ioe, "ioe");
    }

    public void t(e call, z request) {
        i.f(call, "call");
        i.f(request, "request");
    }

    public void u(e call) {
        i.f(call, "call");
    }

    public void v(e call, long j10) {
        i.f(call, "call");
    }

    public void w(e call) {
        i.f(call, "call");
    }

    public void x(e call, IOException ioe) {
        i.f(call, "call");
        i.f(ioe, "ioe");
    }

    public void y(e call, b0 response) {
        i.f(call, "call");
        i.f(response, "response");
    }

    public void z(e call) {
        i.f(call, "call");
    }
}
