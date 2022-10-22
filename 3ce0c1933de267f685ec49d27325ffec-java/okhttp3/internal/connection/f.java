package okhttp3.internal.connection;

import com.mobvoi.wear.common.base.Constants;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.collections.n;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import kotlin.text.m;
import okhttp3.Protocol;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.g;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.http2.b;
import okhttp3.internal.platform.h;
import okhttp3.j;
import okhttp3.l;
import okhttp3.r;
import okhttp3.t;
import okhttp3.u;
import okhttp3.y;
import okhttp3.z;
import okio.d;
import okio.e;
/* compiled from: RealConnection.kt */
/* loaded from: classes3.dex */
public final class f extends b.d implements j {

    /* renamed from: b  reason: collision with root package name */
    private Socket f31999b;

    /* renamed from: c  reason: collision with root package name */
    private Socket f32000c;

    /* renamed from: d  reason: collision with root package name */
    private t f32001d;

    /* renamed from: e  reason: collision with root package name */
    private Protocol f32002e;

    /* renamed from: f  reason: collision with root package name */
    private okhttp3.internal.http2.b f32003f;

    /* renamed from: g  reason: collision with root package name */
    private e f32004g;

    /* renamed from: h  reason: collision with root package name */
    private d f32005h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f32006i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f32007j;

    /* renamed from: k  reason: collision with root package name */
    private int f32008k;

    /* renamed from: l  reason: collision with root package name */
    private int f32009l;

    /* renamed from: m  reason: collision with root package name */
    private int f32010m;

    /* renamed from: n  reason: collision with root package name */
    private int f32011n = 1;

    /* renamed from: o  reason: collision with root package name */
    private final List<Reference<e>> f32012o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private long f32013p = Long.MAX_VALUE;

    /* renamed from: q  reason: collision with root package name */
    private final d0 f32014q;

    /* compiled from: RealConnection.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RealConnection.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements qo.a<List<? extends Certificate>> {
        final /* synthetic */ okhttp3.a $address;
        final /* synthetic */ g $certificatePinner;
        final /* synthetic */ t $unverifiedHandshake;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(g gVar, t tVar, okhttp3.a aVar) {
            super(0);
            this.$certificatePinner = gVar;
            this.$unverifiedHandshake = tVar;
            this.$address = aVar;
        }

        /* renamed from: a */
        public final List<Certificate> invoke() {
            pp.c d10 = this.$certificatePinner.d();
            i.d(d10);
            return d10.a(this.$unverifiedHandshake.d(), this.$address.l().h());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RealConnection.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements qo.a<List<? extends X509Certificate>> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final List<X509Certificate> invoke() {
            int p10;
            t tVar = f.this.f32001d;
            i.d(tVar);
            List<Certificate> d10 = tVar.d();
            p10 = n.p(d10, 10);
            ArrayList arrayList = new ArrayList(p10);
            for (Certificate certificate : d10) {
                Objects.requireNonNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    static {
        new a(null);
    }

    public f(h connectionPool, d0 route) {
        i.f(connectionPool, "connectionPool");
        i.f(route, "route");
        this.f32014q = route;
    }

    private final boolean B(List<d0> list) {
        boolean z10;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (d0 d0Var : list) {
                if (d0Var.b().type() == Proxy.Type.DIRECT && this.f32014q.b().type() == Proxy.Type.DIRECT && i.b(this.f32014q.d(), d0Var.d())) {
                    z10 = true;
                    continue;
                } else {
                    z10 = false;
                    continue;
                }
                if (z10) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void F(int i10) throws IOException {
        Socket socket = this.f32000c;
        i.d(socket);
        e eVar = this.f32004g;
        i.d(eVar);
        d dVar = this.f32005h;
        i.d(dVar);
        socket.setSoTimeout(0);
        okhttp3.internal.http2.b a10 = new b.C0431b(true, ip.e.f29318h).m(socket, this.f32014q.a().l().h(), eVar, dVar).k(this).l(i10).a();
        this.f32003f = a10;
        this.f32011n = okhttp3.internal.http2.b.D.a().d();
        okhttp3.internal.http2.b.U0(a10, false, null, 3, null);
    }

    private final boolean G(u uVar) {
        t tVar;
        if (!gp.b.f27632h || Thread.holdsLock(this)) {
            u l10 = this.f32014q.a().l();
            if (uVar.n() != l10.n()) {
                return false;
            }
            if (i.b(uVar.h(), l10.h())) {
                return true;
            }
            if (this.f32007j || (tVar = this.f32001d) == null) {
                return false;
            }
            i.d(tVar);
            return f(uVar, tVar);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        i.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    private final boolean f(u uVar, t tVar) {
        List<Certificate> d10 = tVar.d();
        if (!d10.isEmpty()) {
            pp.d dVar = pp.d.f32897a;
            String h10 = uVar.h();
            Certificate certificate = d10.get(0);
            Objects.requireNonNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            if (dVar.c(h10, (X509Certificate) certificate)) {
                return true;
            }
        }
        return false;
    }

    private final void i(int i10, int i11, okhttp3.e eVar, r rVar) throws IOException {
        Socket socket;
        int i12;
        Proxy b10 = this.f32014q.b();
        okhttp3.a a10 = this.f32014q.a();
        Proxy.Type type = b10.type();
        if (type != null && ((i12 = g.f32015a[type.ordinal()]) == 1 || i12 == 2)) {
            socket = a10.j().createSocket();
            i.d(socket);
        } else {
            socket = new Socket(b10);
        }
        this.f31999b = socket;
        rVar.j(eVar, this.f32014q.d(), b10);
        socket.setSoTimeout(i11);
        try {
            h.f32213c.g().f(socket, this.f32014q.d(), i10);
            try {
                this.f32004g = okio.n.d(okio.n.m(socket));
                this.f32005h = okio.n.c(okio.n.i(socket));
            } catch (NullPointerException e10) {
                if (i.b(e10.getMessage(), "throw with null exception")) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f32014q.d());
            connectException.initCause(e11);
            throw connectException;
        }
    }

    private final void j(okhttp3.internal.connection.b bVar) throws IOException {
        Throwable th2;
        String h10;
        okhttp3.a a10 = this.f32014q.a();
        SSLSocketFactory k10 = a10.k();
        SSLSocket sSLSocket = null;
        String str = null;
        try {
            i.d(k10);
            Socket createSocket = k10.createSocket(this.f31999b, a10.l().h(), a10.l().n(), true);
            if (createSocket != null) {
                SSLSocket sSLSocket2 = (SSLSocket) createSocket;
                try {
                    l a11 = bVar.a(sSLSocket2);
                    if (a11.h()) {
                        h.f32213c.g().e(sSLSocket2, a10.l().h(), a10.f());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession sslSocketSession = sSLSocket2.getSession();
                    t.a aVar = t.f32269e;
                    i.e(sslSocketSession, "sslSocketSession");
                    t a12 = aVar.a(sslSocketSession);
                    HostnameVerifier e10 = a10.e();
                    i.d(e10);
                    if (!e10.verify(a10.l().h(), sslSocketSession)) {
                        List<Certificate> d10 = a12.d();
                        if (!d10.isEmpty()) {
                            Certificate certificate = d10.get(0);
                            if (certificate == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                            }
                            X509Certificate x509Certificate = (X509Certificate) certificate;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("\n              |Hostname ");
                            sb2.append(a10.l().h());
                            sb2.append(" not verified:\n              |    certificate: ");
                            sb2.append(g.f31844d.a(x509Certificate));
                            sb2.append("\n              |    DN: ");
                            Principal subjectDN = x509Certificate.getSubjectDN();
                            i.e(subjectDN, "cert.subjectDN");
                            sb2.append(subjectDN.getName());
                            sb2.append("\n              |    subjectAltNames: ");
                            sb2.append(pp.d.f32897a.a(x509Certificate));
                            sb2.append("\n              ");
                            h10 = m.h(sb2.toString(), null, 1, null);
                            throw new SSLPeerUnverifiedException(h10);
                        }
                        throw new SSLPeerUnverifiedException("Hostname " + a10.l().h() + " not verified (no certificates)");
                    }
                    g a13 = a10.a();
                    i.d(a13);
                    this.f32001d = new t(a12.e(), a12.a(), a12.c(), new b(a13, a12, a10));
                    a13.b(a10.l().h(), new c());
                    if (a11.h()) {
                        str = h.f32213c.g().h(sSLSocket2);
                    }
                    this.f32000c = sSLSocket2;
                    this.f32004g = okio.n.d(okio.n.m(sSLSocket2));
                    this.f32005h = okio.n.c(okio.n.i(sSLSocket2));
                    this.f32002e = str != null ? Protocol.Companion.a(str) : Protocol.HTTP_1_1;
                    h.f32213c.g().b(sSLSocket2);
                } catch (Throwable th3) {
                    th2 = th3;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        h.f32213c.g().b(sSLSocket);
                    }
                    if (sSLSocket != null) {
                        gp.b.k(sSLSocket);
                    }
                    throw th2;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
        } catch (Throwable th4) {
            th2 = th4;
        }
    }

    private final void k(int i10, int i11, int i12, okhttp3.e eVar, r rVar) throws IOException {
        z m10 = m();
        u l10 = m10.l();
        for (int i13 = 0; i13 < 21; i13++) {
            i(i10, i11, eVar, rVar);
            m10 = l(i11, i12, m10, l10);
            if (m10 != null) {
                Socket socket = this.f31999b;
                if (socket != null) {
                    gp.b.k(socket);
                }
                this.f31999b = null;
                this.f32005h = null;
                this.f32004g = null;
                rVar.h(eVar, this.f32014q.d(), this.f32014q.b(), null);
            } else {
                return;
            }
        }
    }

    private final z l(int i10, int i11, z zVar, u uVar) throws IOException {
        boolean p10;
        String str = "CONNECT " + gp.b.M(uVar, true) + " HTTP/1.1";
        while (true) {
            e eVar = this.f32004g;
            i.d(eVar);
            d dVar = this.f32005h;
            i.d(dVar);
            kp.b bVar = new kp.b(null, this, eVar, dVar);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            eVar.timeout().g(i10, timeUnit);
            dVar.timeout().g(i11, timeUnit);
            bVar.A(zVar.f(), str);
            bVar.a();
            b0.a d10 = bVar.d(false);
            i.d(d10);
            b0 c10 = d10.s(zVar).c();
            bVar.z(c10);
            int n10 = c10.n();
            if (n10 != 200) {
                if (n10 == 407) {
                    z a10 = this.f32014q.a().h().a(this.f32014q, c10);
                    if (a10 != null) {
                        p10 = kotlin.text.t.p("close", b0.w(c10, "Connection", null, 2, null), true);
                        if (p10) {
                            return a10;
                        }
                        zVar = a10;
                    } else {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + c10.n());
                }
            } else if (eVar.b().B() && dVar.b().B()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private final z m() throws IOException {
        z b10 = new z.a().q(this.f32014q.a().l()).j("CONNECT", null).h("Host", gp.b.M(this.f32014q.a().l(), true)).h("Proxy-Connection", "Keep-Alive").h("User-Agent", "okhttp/4.9.1").b();
        z a10 = this.f32014q.a().h().a(this.f32014q, new b0.a().s(b10).p(Protocol.HTTP_1_1).g(407).m("Preemptive Authenticate").b(gp.b.f27627c).t(-1L).q(-1L).j("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return a10 != null ? a10 : b10;
    }

    private final void n(okhttp3.internal.connection.b bVar, int i10, okhttp3.e eVar, r rVar) throws IOException {
        if (this.f32014q.a().k() == null) {
            List<Protocol> f10 = this.f32014q.a().f();
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (f10.contains(protocol)) {
                this.f32000c = this.f31999b;
                this.f32002e = protocol;
                F(i10);
                return;
            }
            this.f32000c = this.f31999b;
            this.f32002e = Protocol.HTTP_1_1;
            return;
        }
        rVar.C(eVar);
        j(bVar);
        rVar.B(eVar, this.f32001d);
        if (this.f32002e == Protocol.HTTP_2) {
            F(i10);
        }
    }

    public d0 A() {
        return this.f32014q;
    }

    public final void C(long j10) {
        this.f32013p = j10;
    }

    public final void D(boolean z10) {
        this.f32006i = z10;
    }

    public Socket E() {
        Socket socket = this.f32000c;
        i.d(socket);
        return socket;
    }

    public final synchronized void H(e call, IOException iOException) {
        i.f(call, "call");
        if (iOException instanceof StreamResetException) {
            if (((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
                int i10 = this.f32010m + 1;
                this.f32010m = i10;
                if (i10 > 1) {
                    this.f32006i = true;
                    this.f32008k++;
                }
            } else if (((StreamResetException) iOException).errorCode != ErrorCode.CANCEL || !call.isCanceled()) {
                this.f32006i = true;
                this.f32008k++;
            }
        } else if (!w() || (iOException instanceof ConnectionShutdownException)) {
            this.f32006i = true;
            if (this.f32009l == 0) {
                if (iOException != null) {
                    h(call.k(), this.f32014q, iOException);
                }
                this.f32008k++;
            }
        }
    }

    @Override // okhttp3.j
    public Protocol a() {
        Protocol protocol = this.f32002e;
        i.d(protocol);
        return protocol;
    }

    @Override // okhttp3.internal.http2.b.d
    public synchronized void b(okhttp3.internal.http2.b connection, lp.d settings) {
        i.f(connection, "connection");
        i.f(settings, "settings");
        this.f32011n = settings.d();
    }

    @Override // okhttp3.internal.http2.b.d
    public void c(okhttp3.internal.http2.d stream) throws IOException {
        i.f(stream, "stream");
        stream.d(ErrorCode.REFUSED_STREAM, null);
    }

    public final void e() {
        Socket socket = this.f31999b;
        if (socket != null) {
            gp.b.k(socket);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2 A[Catch: IOException -> 0x00fd, TRY_LEAVE, TryCatch #1 {IOException -> 0x00fd, blocks: (B:20:0x009a, B:22:0x00a2), top: B:62:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014c A[EDGE_INSN: B:66:0x014c->B:55:0x014c ?: BREAK  ] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(int i10, int i11, int i12, int i13, boolean z10, okhttp3.e call, r eventListener) {
        IOException e10;
        Socket socket;
        Socket socket2;
        i.f(call, "call");
        i.f(eventListener, "eventListener");
        if (this.f32002e == null) {
            List<l> b10 = this.f32014q.a().b();
            okhttp3.internal.connection.b bVar = new okhttp3.internal.connection.b(b10);
            if (this.f32014q.a().k() == null) {
                if (b10.contains(l.f32226h)) {
                    String h10 = this.f32014q.a().l().h();
                    if (!h.f32213c.g().j(h10)) {
                        throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + h10 + " not permitted by network security policy"));
                    }
                } else {
                    throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                }
            } else if (this.f32014q.a().f().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
            }
            RouteException routeException = null;
            do {
                try {
                    try {
                        if (this.f32014q.c()) {
                            k(i10, i11, i12, call, eventListener);
                            if (this.f31999b == null) {
                                if (this.f32014q.c() || this.f31999b != null) {
                                    this.f32013p = System.nanoTime();
                                    return;
                                }
                                throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                            }
                        } else {
                            try {
                                i(i10, i11, call, eventListener);
                            } catch (IOException e11) {
                                e10 = e11;
                                socket = this.f32000c;
                                if (socket != null) {
                                }
                                socket2 = this.f31999b;
                                if (socket2 != null) {
                                }
                                this.f32000c = null;
                                this.f31999b = null;
                                this.f32004g = null;
                                this.f32005h = null;
                                this.f32001d = null;
                                this.f32002e = null;
                                this.f32003f = null;
                                this.f32011n = 1;
                                eventListener.i(call, this.f32014q.d(), this.f32014q.b(), null, e10);
                                if (routeException != null) {
                                }
                                if (!z10 || bVar.b(e10)) {
                                }
                                do {
                                    if (this.f32014q.c()) {
                                    }
                                    n(bVar, i13, call, eventListener);
                                    eventListener.h(call, this.f32014q.d(), this.f32014q.b(), this.f32002e);
                                    if (this.f32014q.c()) {
                                    }
                                    this.f32013p = System.nanoTime();
                                    return;
                                } while (bVar.b(e10));
                                throw routeException;
                            }
                        }
                        n(bVar, i13, call, eventListener);
                        eventListener.h(call, this.f32014q.d(), this.f32014q.b(), this.f32002e);
                        if (this.f32014q.c()) {
                        }
                        this.f32013p = System.nanoTime();
                        return;
                    } catch (IOException e12) {
                        e10 = e12;
                        socket = this.f32000c;
                        if (socket != null) {
                            gp.b.k(socket);
                        }
                        socket2 = this.f31999b;
                        if (socket2 != null) {
                            gp.b.k(socket2);
                        }
                        this.f32000c = null;
                        this.f31999b = null;
                        this.f32004g = null;
                        this.f32005h = null;
                        this.f32001d = null;
                        this.f32002e = null;
                        this.f32003f = null;
                        this.f32011n = 1;
                        eventListener.i(call, this.f32014q.d(), this.f32014q.b(), null, e10);
                        if (routeException != null) {
                            routeException = new RouteException(e10);
                        } else {
                            routeException.addConnectException(e10);
                        }
                        if (!z10 || bVar.b(e10)) {
                            throw routeException;
                        }
                        do {
                            if (this.f32014q.c()) {
                            }
                            n(bVar, i13, call, eventListener);
                            eventListener.h(call, this.f32014q.d(), this.f32014q.b(), this.f32002e);
                            if (this.f32014q.c()) {
                            }
                            this.f32013p = System.nanoTime();
                            return;
                        } while (bVar.b(e10));
                        throw routeException;
                    }
                } catch (IOException e13) {
                    e10 = e13;
                }
            } while (bVar.b(e10));
            throw routeException;
        }
        throw new IllegalStateException("already connected".toString());
    }

    public final void h(y client, d0 failedRoute, IOException failure) {
        i.f(client, "client");
        i.f(failedRoute, "failedRoute");
        i.f(failure, "failure");
        if (failedRoute.b().type() != Proxy.Type.DIRECT) {
            okhttp3.a a10 = failedRoute.a();
            a10.i().connectFailed(a10.l().u(), failedRoute.b().address(), failure);
        }
        client.r().b(failedRoute);
    }

    public final List<Reference<e>> o() {
        return this.f32012o;
    }

    public final long p() {
        return this.f32013p;
    }

    public final boolean q() {
        return this.f32006i;
    }

    public final int r() {
        return this.f32008k;
    }

    public t s() {
        return this.f32001d;
    }

    public final synchronized void t() {
        this.f32009l++;
    }

    public String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.f32014q.a().l().h());
        sb2.append(':');
        sb2.append(this.f32014q.a().l().n());
        sb2.append(',');
        sb2.append(" proxy=");
        sb2.append(this.f32014q.b());
        sb2.append(" hostAddress=");
        sb2.append(this.f32014q.d());
        sb2.append(" cipherSuite=");
        t tVar = this.f32001d;
        if (tVar == null || (obj = tVar.a()) == null) {
            obj = Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_NONE;
        }
        sb2.append(obj);
        sb2.append(" protocol=");
        sb2.append(this.f32002e);
        sb2.append('}');
        return sb2.toString();
    }

    public final boolean u(okhttp3.a address, List<d0> list) {
        i.f(address, "address");
        if (gp.b.f27632h && !Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            i.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        } else if (this.f32012o.size() >= this.f32011n || this.f32006i || !this.f32014q.a().d(address)) {
            return false;
        } else {
            if (i.b(address.l().h(), A().a().l().h())) {
                return true;
            }
            if (this.f32003f == null || list == null || !B(list) || address.e() != pp.d.f32897a || !G(address.l())) {
                return false;
            }
            try {
                g a10 = address.a();
                i.d(a10);
                String h10 = address.l().h();
                t s10 = s();
                i.d(s10);
                a10.a(h10, s10.d());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
    }

    public final boolean v(boolean z10) {
        long j10;
        if (!gp.b.f27632h || !Thread.holdsLock(this)) {
            long nanoTime = System.nanoTime();
            Socket socket = this.f31999b;
            i.d(socket);
            Socket socket2 = this.f32000c;
            i.d(socket2);
            e eVar = this.f32004g;
            i.d(eVar);
            if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
                return false;
            }
            okhttp3.internal.http2.b bVar = this.f32003f;
            if (bVar != null) {
                return bVar.G0(nanoTime);
            }
            synchronized (this) {
                j10 = nanoTime - this.f32013p;
            }
            if (j10 < 10000000000L || !z10) {
                return true;
            }
            return gp.b.D(socket2, eVar);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        i.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST NOT hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    public final boolean w() {
        return this.f32003f != null;
    }

    public final jp.d x(y client, jp.g chain) throws SocketException {
        i.f(client, "client");
        i.f(chain, "chain");
        Socket socket = this.f32000c;
        i.d(socket);
        e eVar = this.f32004g;
        i.d(eVar);
        d dVar = this.f32005h;
        i.d(dVar);
        okhttp3.internal.http2.b bVar = this.f32003f;
        if (bVar != null) {
            return new lp.c(client, this, chain, bVar);
        }
        socket.setSoTimeout(chain.k());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        eVar.timeout().g(chain.h(), timeUnit);
        dVar.timeout().g(chain.j(), timeUnit);
        return new kp.b(client, this, eVar, dVar);
    }

    public final synchronized void y() {
        this.f32007j = true;
    }

    public final synchronized void z() {
        this.f32006i = true;
    }
}
