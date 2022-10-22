package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.d0;
import okhttp3.e;
import okhttp3.r;
import okhttp3.u;
/* compiled from: RouteSelector.kt */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: i  reason: collision with root package name */
    public static final a f32023i = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private List<? extends Proxy> f32024a;

    /* renamed from: b  reason: collision with root package name */
    private int f32025b;

    /* renamed from: c  reason: collision with root package name */
    private List<? extends InetSocketAddress> f32026c;

    /* renamed from: d  reason: collision with root package name */
    private final List<d0> f32027d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final okhttp3.a f32028e;

    /* renamed from: f  reason: collision with root package name */
    private final i f32029f;

    /* renamed from: g  reason: collision with root package name */
    private final e f32030g;

    /* renamed from: h  reason: collision with root package name */
    private final r f32031h;

    /* compiled from: RouteSelector.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final String a(InetSocketAddress socketHost) {
            i.f(socketHost, "$this$socketHost");
            InetAddress address = socketHost.getAddress();
            if (address != null) {
                String hostAddress = address.getHostAddress();
                i.e(hostAddress, "address.hostAddress");
                return hostAddress;
            }
            String hostName = socketHost.getHostName();
            i.e(hostName, "hostName");
            return hostName;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: RouteSelector.kt */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private int f32032a;

        /* renamed from: b  reason: collision with root package name */
        private final List<d0> f32033b;

        public b(List<d0> routes) {
            i.f(routes, "routes");
            this.f32033b = routes;
        }

        public final List<d0> a() {
            return this.f32033b;
        }

        public final boolean b() {
            return this.f32032a < this.f32033b.size();
        }

        public final d0 c() {
            if (b()) {
                List<d0> list = this.f32033b;
                int i10 = this.f32032a;
                this.f32032a = i10 + 1;
                return list.get(i10);
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RouteSelector.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements qo.a<List<? extends Proxy>> {
        final /* synthetic */ Proxy $proxy;
        final /* synthetic */ u $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Proxy proxy, u uVar) {
            super(0);
            this.$proxy = proxy;
            this.$url = uVar;
        }

        /* renamed from: a */
        public final List<Proxy> invoke() {
            List<Proxy> b10;
            Proxy proxy = this.$proxy;
            if (proxy != null) {
                b10 = l.b(proxy);
                return b10;
            }
            URI u10 = this.$url.u();
            if (u10.getHost() == null) {
                return gp.b.t(Proxy.NO_PROXY);
            }
            List<Proxy> select = j.this.f32028e.i().select(u10);
            return select == null || select.isEmpty() ? gp.b.t(Proxy.NO_PROXY) : gp.b.O(select);
        }
    }

    public j(okhttp3.a address, i routeDatabase, e call, r eventListener) {
        List<? extends Proxy> g10;
        List<? extends InetSocketAddress> g11;
        i.f(address, "address");
        i.f(routeDatabase, "routeDatabase");
        i.f(call, "call");
        i.f(eventListener, "eventListener");
        this.f32028e = address;
        this.f32029f = routeDatabase;
        this.f32030g = call;
        this.f32031h = eventListener;
        g10 = m.g();
        this.f32024a = g10;
        g11 = m.g();
        this.f32026c = g11;
        g(address.l(), address.g());
    }

    private final boolean c() {
        return this.f32025b < this.f32024a.size();
    }

    private final Proxy e() throws IOException {
        if (c()) {
            List<? extends Proxy> list = this.f32024a;
            int i10 = this.f32025b;
            this.f32025b = i10 + 1;
            Proxy proxy = list.get(i10);
            f(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f32028e.l().h() + "; exhausted proxy configurations: " + this.f32024a);
    }

    private final void f(Proxy proxy) throws IOException {
        String str;
        int i10;
        ArrayList arrayList = new ArrayList();
        this.f32026c = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f32028e.l().h();
            i10 = this.f32028e.l().n();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = f32023i.a(inetSocketAddress);
                i10 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + address.getClass()).toString());
            }
        }
        if (1 > i10 || 65535 < i10) {
            throw new SocketException("No route to " + str + ':' + i10 + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(str, i10));
        } else {
            this.f32031h.n(this.f32030g, str);
            List<InetAddress> a10 = this.f32028e.c().a(str);
            if (!a10.isEmpty()) {
                this.f32031h.m(this.f32030g, str, a10);
                for (InetAddress inetAddress : a10) {
                    arrayList.add(new InetSocketAddress(inetAddress, i10));
                }
                return;
            }
            throw new UnknownHostException(this.f32028e.c() + " returned no addresses for " + str);
        }
    }

    private final void g(u uVar, Proxy proxy) {
        c cVar = new c(proxy, uVar);
        this.f32031h.p(this.f32030g, uVar);
        List<Proxy> a10 = cVar.invoke();
        this.f32024a = a10;
        this.f32025b = 0;
        this.f32031h.o(this.f32030g, uVar, a10);
    }

    public final boolean b() {
        return c() || (this.f32027d.isEmpty() ^ true);
    }

    public final b d() throws IOException {
        if (b()) {
            ArrayList arrayList = new ArrayList();
            while (c()) {
                Proxy e10 = e();
                for (InetSocketAddress inetSocketAddress : this.f32026c) {
                    d0 d0Var = new d0(this.f32028e, e10, inetSocketAddress);
                    if (this.f32029f.c(d0Var)) {
                        this.f32027d.add(d0Var);
                    } else {
                        arrayList.add(d0Var);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                kotlin.collections.r.s(arrayList, this.f32027d);
                this.f32027d.clear();
            }
            return new b(arrayList);
        }
        throw new NoSuchElementException();
    }
}
