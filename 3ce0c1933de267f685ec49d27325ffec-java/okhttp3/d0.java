package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.jvm.internal.i;
/* compiled from: Route.kt */
/* loaded from: classes3.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    private final a f31840a;

    /* renamed from: b  reason: collision with root package name */
    private final Proxy f31841b;

    /* renamed from: c  reason: collision with root package name */
    private final InetSocketAddress f31842c;

    public d0(a address, Proxy proxy, InetSocketAddress socketAddress) {
        i.f(address, "address");
        i.f(proxy, "proxy");
        i.f(socketAddress, "socketAddress");
        this.f31840a = address;
        this.f31841b = proxy;
        this.f31842c = socketAddress;
    }

    public final a a() {
        return this.f31840a;
    }

    public final Proxy b() {
        return this.f31841b;
    }

    public final boolean c() {
        return this.f31840a.k() != null && this.f31841b.type() == Proxy.Type.HTTP;
    }

    public final InetSocketAddress d() {
        return this.f31842c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d0) {
            d0 d0Var = (d0) obj;
            if (i.b(d0Var.f31840a, this.f31840a) && i.b(d0Var.f31841b, this.f31841b) && i.b(d0Var.f31842c, this.f31842c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f31840a.hashCode()) * 31) + this.f31841b.hashCode()) * 31) + this.f31842c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f31842c + '}';
    }
}
