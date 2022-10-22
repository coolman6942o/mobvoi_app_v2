package okhttp3;

import gp.b;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.i;
import okhttp3.u;
/* compiled from: Address.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final u f31732a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Protocol> f31733b;

    /* renamed from: c  reason: collision with root package name */
    private final List<l> f31734c;

    /* renamed from: d  reason: collision with root package name */
    private final q f31735d;

    /* renamed from: e  reason: collision with root package name */
    private final SocketFactory f31736e;

    /* renamed from: f  reason: collision with root package name */
    private final SSLSocketFactory f31737f;

    /* renamed from: g  reason: collision with root package name */
    private final HostnameVerifier f31738g;

    /* renamed from: h  reason: collision with root package name */
    private final g f31739h;

    /* renamed from: i  reason: collision with root package name */
    private final b f31740i;

    /* renamed from: j  reason: collision with root package name */
    private final Proxy f31741j;

    /* renamed from: k  reason: collision with root package name */
    private final ProxySelector f31742k;

    public a(String uriHost, int i10, q dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b proxyAuthenticator, Proxy proxy, List<? extends Protocol> protocols, List<l> connectionSpecs, ProxySelector proxySelector) {
        i.f(uriHost, "uriHost");
        i.f(dns, "dns");
        i.f(socketFactory, "socketFactory");
        i.f(proxyAuthenticator, "proxyAuthenticator");
        i.f(protocols, "protocols");
        i.f(connectionSpecs, "connectionSpecs");
        i.f(proxySelector, "proxySelector");
        this.f31735d = dns;
        this.f31736e = socketFactory;
        this.f31737f = sSLSocketFactory;
        this.f31738g = hostnameVerifier;
        this.f31739h = gVar;
        this.f31740i = proxyAuthenticator;
        this.f31741j = proxy;
        this.f31742k = proxySelector;
        this.f31732a = new u.a().s(sSLSocketFactory != null ? "https" : "http").i(uriHost).o(i10).e();
        this.f31733b = b.O(protocols);
        this.f31734c = b.O(connectionSpecs);
    }

    public final g a() {
        return this.f31739h;
    }

    public final List<l> b() {
        return this.f31734c;
    }

    public final q c() {
        return this.f31735d;
    }

    public final boolean d(a that) {
        i.f(that, "that");
        return i.b(this.f31735d, that.f31735d) && i.b(this.f31740i, that.f31740i) && i.b(this.f31733b, that.f31733b) && i.b(this.f31734c, that.f31734c) && i.b(this.f31742k, that.f31742k) && i.b(this.f31741j, that.f31741j) && i.b(this.f31737f, that.f31737f) && i.b(this.f31738g, that.f31738g) && i.b(this.f31739h, that.f31739h) && this.f31732a.n() == that.f31732a.n();
    }

    public final HostnameVerifier e() {
        return this.f31738g;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (i.b(this.f31732a, aVar.f31732a) && d(aVar)) {
                return true;
            }
        }
        return false;
    }

    public final List<Protocol> f() {
        return this.f31733b;
    }

    public final Proxy g() {
        return this.f31741j;
    }

    public final b h() {
        return this.f31740i;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f31732a.hashCode()) * 31) + this.f31735d.hashCode()) * 31) + this.f31740i.hashCode()) * 31) + this.f31733b.hashCode()) * 31) + this.f31734c.hashCode()) * 31) + this.f31742k.hashCode()) * 31) + Objects.hashCode(this.f31741j)) * 31) + Objects.hashCode(this.f31737f)) * 31) + Objects.hashCode(this.f31738g)) * 31) + Objects.hashCode(this.f31739h);
    }

    public final ProxySelector i() {
        return this.f31742k;
    }

    public final SocketFactory j() {
        return this.f31736e;
    }

    public final SSLSocketFactory k() {
        return this.f31737f;
    }

    public final u l() {
        return this.f31732a;
    }

    public String toString() {
        Object obj;
        StringBuilder sb2;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Address{");
        sb3.append(this.f31732a.h());
        sb3.append(':');
        sb3.append(this.f31732a.n());
        sb3.append(", ");
        if (this.f31741j != null) {
            sb2 = new StringBuilder();
            sb2.append("proxy=");
            obj = this.f31741j;
        } else {
            sb2 = new StringBuilder();
            sb2.append("proxySelector=");
            obj = this.f31742k;
        }
        sb2.append(obj);
        sb3.append(sb2.toString());
        sb3.append("}");
        return sb3.toString();
    }
}
