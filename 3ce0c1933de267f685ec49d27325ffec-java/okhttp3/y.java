package okhttp3;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.f;
import okhttp3.e;
import okhttp3.internal.connection.i;
import okhttp3.internal.platform.h;
import okhttp3.r;
import pp.c;
import pp.d;
/* compiled from: OkHttpClient.kt */
/* loaded from: classes3.dex */
public class y implements Cloneable, e.a {
    private final int A;
    private final int B;
    private final i C;

    /* renamed from: a  reason: collision with root package name */
    private final p f32319a;

    /* renamed from: b  reason: collision with root package name */
    private final k f32320b;

    /* renamed from: c  reason: collision with root package name */
    private final List<v> f32321c;

    /* renamed from: d  reason: collision with root package name */
    private final List<v> f32322d;

    /* renamed from: e  reason: collision with root package name */
    private final r.c f32323e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f32324f;

    /* renamed from: g  reason: collision with root package name */
    private final okhttp3.b f32325g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f32326h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f32327i;

    /* renamed from: j  reason: collision with root package name */
    private final n f32328j;

    /* renamed from: k  reason: collision with root package name */
    private final c f32329k;

    /* renamed from: l  reason: collision with root package name */
    private final q f32330l;

    /* renamed from: m  reason: collision with root package name */
    private final Proxy f32331m;

    /* renamed from: n  reason: collision with root package name */
    private final ProxySelector f32332n;

    /* renamed from: o  reason: collision with root package name */
    private final okhttp3.b f32333o;

    /* renamed from: p  reason: collision with root package name */
    private final SocketFactory f32334p;

    /* renamed from: q  reason: collision with root package name */
    private final SSLSocketFactory f32335q;

    /* renamed from: r  reason: collision with root package name */
    private final X509TrustManager f32336r;

    /* renamed from: s  reason: collision with root package name */
    private final List<l> f32337s;

    /* renamed from: t  reason: collision with root package name */
    private final List<Protocol> f32338t;

    /* renamed from: u  reason: collision with root package name */
    private final HostnameVerifier f32339u;

    /* renamed from: v  reason: collision with root package name */
    private final g f32340v;

    /* renamed from: w  reason: collision with root package name */
    private final c f32341w;

    /* renamed from: x  reason: collision with root package name */
    private final int f32342x;

    /* renamed from: y  reason: collision with root package name */
    private final int f32343y;

    /* renamed from: z  reason: collision with root package name */
    private final int f32344z;
    public static final b F = new b(null);
    private static final List<Protocol> D = gp.b.t(Protocol.HTTP_2, Protocol.HTTP_1_1);
    private static final List<l> E = gp.b.t(l.f32225g, l.f32226h);

    /* compiled from: OkHttpClient.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private int B;
        private i D;

        /* renamed from: g  reason: collision with root package name */
        private okhttp3.b f32351g;

        /* renamed from: k  reason: collision with root package name */
        private c f32355k;

        /* renamed from: m  reason: collision with root package name */
        private Proxy f32357m;

        /* renamed from: n  reason: collision with root package name */
        private ProxySelector f32358n;

        /* renamed from: o  reason: collision with root package name */
        private okhttp3.b f32359o;

        /* renamed from: p  reason: collision with root package name */
        private SocketFactory f32360p;

        /* renamed from: q  reason: collision with root package name */
        private SSLSocketFactory f32361q;

        /* renamed from: r  reason: collision with root package name */
        private X509TrustManager f32362r;

        /* renamed from: s  reason: collision with root package name */
        private List<l> f32363s;

        /* renamed from: t  reason: collision with root package name */
        private List<? extends Protocol> f32364t;

        /* renamed from: w  reason: collision with root package name */
        private c f32367w;

        /* renamed from: x  reason: collision with root package name */
        private int f32368x;

        /* renamed from: a  reason: collision with root package name */
        private p f32345a = new p();

        /* renamed from: b  reason: collision with root package name */
        private k f32346b = new k();

        /* renamed from: c  reason: collision with root package name */
        private final List<v> f32347c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private final List<v> f32348d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private r.c f32349e = gp.b.e(r.f32262a);

        /* renamed from: f  reason: collision with root package name */
        private boolean f32350f = true;

        /* renamed from: h  reason: collision with root package name */
        private boolean f32352h = true;

        /* renamed from: i  reason: collision with root package name */
        private boolean f32353i = true;

        /* renamed from: j  reason: collision with root package name */
        private n f32354j = n.f32253a;

        /* renamed from: l  reason: collision with root package name */
        private q f32356l = q.f32261a;

        /* renamed from: u  reason: collision with root package name */
        private HostnameVerifier f32365u = d.f32897a;

        /* renamed from: v  reason: collision with root package name */
        private g f32366v = g.f31843c;

        /* renamed from: y  reason: collision with root package name */
        private int f32369y = 10000;

        /* renamed from: z  reason: collision with root package name */
        private int f32370z = 10000;
        private int A = 10000;
        private long C = ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;

        public a() {
            okhttp3.b bVar = okhttp3.b.f31751a;
            this.f32351g = bVar;
            this.f32359o = bVar;
            SocketFactory socketFactory = SocketFactory.getDefault();
            kotlin.jvm.internal.i.e(socketFactory, "SocketFactory.getDefault()");
            this.f32360p = socketFactory;
            b bVar2 = y.F;
            this.f32363s = bVar2.a();
            this.f32364t = bVar2.b();
        }

        public final List<Protocol> A() {
            return this.f32364t;
        }

        public final Proxy B() {
            return this.f32357m;
        }

        public final okhttp3.b C() {
            return this.f32359o;
        }

        public final ProxySelector D() {
            return this.f32358n;
        }

        public final int E() {
            return this.f32370z;
        }

        public final boolean F() {
            return this.f32350f;
        }

        public final i G() {
            return this.D;
        }

        public final SocketFactory H() {
            return this.f32360p;
        }

        public final SSLSocketFactory I() {
            return this.f32361q;
        }

        public final int J() {
            return this.A;
        }

        public final X509TrustManager K() {
            return this.f32362r;
        }

        public final List<v> L() {
            return this.f32347c;
        }

        public final a M(long j10, TimeUnit unit) {
            kotlin.jvm.internal.i.f(unit, "unit");
            this.f32370z = gp.b.h("timeout", j10, unit);
            return this;
        }

        public final a N(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager) {
            kotlin.jvm.internal.i.f(sslSocketFactory, "sslSocketFactory");
            kotlin.jvm.internal.i.f(trustManager, "trustManager");
            if ((!kotlin.jvm.internal.i.b(sslSocketFactory, this.f32361q)) || (!kotlin.jvm.internal.i.b(trustManager, this.f32362r))) {
                this.D = null;
            }
            this.f32361q = sslSocketFactory;
            this.f32367w = c.f32896a.a(trustManager);
            this.f32362r = trustManager;
            return this;
        }

        public final a O(long j10, TimeUnit unit) {
            kotlin.jvm.internal.i.f(unit, "unit");
            this.A = gp.b.h("timeout", j10, unit);
            return this;
        }

        public final a a(v interceptor) {
            kotlin.jvm.internal.i.f(interceptor, "interceptor");
            this.f32347c.add(interceptor);
            return this;
        }

        public final a b(v interceptor) {
            kotlin.jvm.internal.i.f(interceptor, "interceptor");
            this.f32348d.add(interceptor);
            return this;
        }

        public final y c() {
            return new y(this);
        }

        public final a d(c cVar) {
            this.f32355k = cVar;
            return this;
        }

        public final a e(long j10, TimeUnit unit) {
            kotlin.jvm.internal.i.f(unit, "unit");
            this.f32369y = gp.b.h("timeout", j10, unit);
            return this;
        }

        public final a f(List<l> connectionSpecs) {
            kotlin.jvm.internal.i.f(connectionSpecs, "connectionSpecs");
            if (!kotlin.jvm.internal.i.b(connectionSpecs, this.f32363s)) {
                this.D = null;
            }
            this.f32363s = gp.b.O(connectionSpecs);
            return this;
        }

        public final a g(boolean z10) {
            this.f32352h = z10;
            return this;
        }

        public final okhttp3.b h() {
            return this.f32351g;
        }

        public final c i() {
            return this.f32355k;
        }

        public final int j() {
            return this.f32368x;
        }

        public final c k() {
            return this.f32367w;
        }

        public final g l() {
            return this.f32366v;
        }

        public final int m() {
            return this.f32369y;
        }

        public final k n() {
            return this.f32346b;
        }

        public final List<l> o() {
            return this.f32363s;
        }

        public final n p() {
            return this.f32354j;
        }

        public final p q() {
            return this.f32345a;
        }

        public final q r() {
            return this.f32356l;
        }

        public final r.c s() {
            return this.f32349e;
        }

        public final boolean t() {
            return this.f32352h;
        }

        public final boolean u() {
            return this.f32353i;
        }

        public final HostnameVerifier v() {
            return this.f32365u;
        }

        public final List<v> w() {
            return this.f32347c;
        }

        public final long x() {
            return this.C;
        }

        public final List<v> y() {
            return this.f32348d;
        }

        public final int z() {
            return this.B;
        }
    }

    /* compiled from: OkHttpClient.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public final List<l> a() {
            return y.E;
        }

        public final List<Protocol> b() {
            return y.D;
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    public y(a builder) {
        ProxySelector proxySelector;
        kotlin.jvm.internal.i.f(builder, "builder");
        this.f32319a = builder.q();
        this.f32320b = builder.n();
        this.f32321c = gp.b.O(builder.w());
        this.f32322d = gp.b.O(builder.y());
        this.f32323e = builder.s();
        this.f32324f = builder.F();
        this.f32325g = builder.h();
        this.f32326h = builder.t();
        this.f32327i = builder.u();
        this.f32328j = builder.p();
        this.f32329k = builder.i();
        this.f32330l = builder.r();
        this.f32331m = builder.B();
        if (builder.B() != null) {
            proxySelector = op.a.f32432a;
        } else {
            proxySelector = builder.D();
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
            if (proxySelector == null) {
                proxySelector = op.a.f32432a;
            }
        }
        this.f32332n = proxySelector;
        this.f32333o = builder.C();
        this.f32334p = builder.H();
        List<l> o10 = builder.o();
        this.f32337s = o10;
        this.f32338t = builder.A();
        this.f32339u = builder.v();
        this.f32342x = builder.j();
        this.f32343y = builder.m();
        this.f32344z = builder.E();
        this.A = builder.J();
        this.B = builder.z();
        builder.x();
        i G = builder.G();
        this.C = G == null ? new i() : G;
        boolean z10 = true;
        if (!(o10 instanceof Collection) || !o10.isEmpty()) {
            Iterator<T> it = o10.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((l) it.next()).f()) {
                        z10 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z10) {
            this.f32335q = null;
            this.f32341w = null;
            this.f32336r = null;
            this.f32340v = g.f31843c;
        } else if (builder.I() != null) {
            this.f32335q = builder.I();
            c k10 = builder.k();
            kotlin.jvm.internal.i.d(k10);
            this.f32341w = k10;
            X509TrustManager K = builder.K();
            kotlin.jvm.internal.i.d(K);
            this.f32336r = K;
            g l10 = builder.l();
            kotlin.jvm.internal.i.d(k10);
            this.f32340v = l10.e(k10);
        } else {
            h.a aVar = h.f32213c;
            X509TrustManager p10 = aVar.g().p();
            this.f32336r = p10;
            h g10 = aVar.g();
            kotlin.jvm.internal.i.d(p10);
            this.f32335q = g10.o(p10);
            c.a aVar2 = c.f32896a;
            kotlin.jvm.internal.i.d(p10);
            c a10 = aVar2.a(p10);
            this.f32341w = a10;
            g l11 = builder.l();
            kotlin.jvm.internal.i.d(a10);
            this.f32340v = l11.e(a10);
        }
        E();
    }

    private final void E() {
        List<v> list;
        List<v> list2;
        boolean z10;
        Objects.requireNonNull(this.f32321c, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        boolean z11 = true;
        if (!list.contains(null)) {
            Objects.requireNonNull(this.f32322d, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
            if (!list2.contains(null)) {
                List<l> list3 = this.f32337s;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    for (l lVar : list3) {
                        if (lVar.f()) {
                            z10 = false;
                            break;
                        }
                    }
                }
                z10 = true;
                if (z10) {
                    if (!(this.f32335q == null)) {
                        throw new IllegalStateException("Check failed.".toString());
                    } else if (this.f32341w == null) {
                        if (this.f32336r != null) {
                            z11 = false;
                        }
                        if (!z11) {
                            throw new IllegalStateException("Check failed.".toString());
                        } else if (!kotlin.jvm.internal.i.b(this.f32340v, g.f31843c)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else if (this.f32335q == null) {
                    throw new IllegalStateException("sslSocketFactory == null".toString());
                } else if (this.f32341w == null) {
                    throw new IllegalStateException("certificateChainCleaner == null".toString());
                } else if (this.f32336r == null) {
                    throw new IllegalStateException("x509TrustManager == null".toString());
                }
            } else {
                throw new IllegalStateException(("Null network interceptor: " + this.f32322d).toString());
            }
        } else {
            throw new IllegalStateException(("Null interceptor: " + this.f32321c).toString());
        }
    }

    public final int A() {
        return this.f32344z;
    }

    public final boolean B() {
        return this.f32324f;
    }

    public final SocketFactory C() {
        return this.f32334p;
    }

    public final SSLSocketFactory D() {
        SSLSocketFactory sSLSocketFactory = this.f32335q;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    public final int F() {
        return this.A;
    }

    @Override // okhttp3.e.a
    public e a(z request) {
        kotlin.jvm.internal.i.f(request, "request");
        return new okhttp3.internal.connection.e(this, request, false);
    }

    public Object clone() {
        return super.clone();
    }

    public final okhttp3.b d() {
        return this.f32325g;
    }

    public final c e() {
        return this.f32329k;
    }

    public final int f() {
        return this.f32342x;
    }

    public final g g() {
        return this.f32340v;
    }

    public final int i() {
        return this.f32343y;
    }

    public final k j() {
        return this.f32320b;
    }

    public final List<l> k() {
        return this.f32337s;
    }

    public final n l() {
        return this.f32328j;
    }

    public final p m() {
        return this.f32319a;
    }

    public final q n() {
        return this.f32330l;
    }

    public final r.c o() {
        return this.f32323e;
    }

    public final boolean p() {
        return this.f32326h;
    }

    public final boolean q() {
        return this.f32327i;
    }

    public final i r() {
        return this.C;
    }

    public final HostnameVerifier s() {
        return this.f32339u;
    }

    public final List<v> t() {
        return this.f32321c;
    }

    public final List<v> u() {
        return this.f32322d;
    }

    public final int v() {
        return this.B;
    }

    public final List<Protocol> w() {
        return this.f32338t;
    }

    public final Proxy x() {
        return this.f32331m;
    }

    public final okhttp3.b y() {
        return this.f32333o;
    }

    public final ProxySelector z() {
        return this.f32332n;
    }

    public y() {
        this(new a());
    }
}
