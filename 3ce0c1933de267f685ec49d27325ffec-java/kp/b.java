package kp;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import jp.k;
import okhttp3.Headers;
import okhttp3.b0;
import okhttp3.n;
import okhttp3.y;
import okhttp3.z;
import okio.i;
import okio.r;
import okio.t;
import okio.u;
/* compiled from: Http1ExchangeCodec.kt */
/* loaded from: classes3.dex */
public final class b implements jp.d {

    /* renamed from: a  reason: collision with root package name */
    private int f30362a;

    /* renamed from: b  reason: collision with root package name */
    private final kp.a f30363b;

    /* renamed from: c  reason: collision with root package name */
    private Headers f30364c;

    /* renamed from: d  reason: collision with root package name */
    private final y f30365d;

    /* renamed from: e  reason: collision with root package name */
    private final okhttp3.internal.connection.f f30366e;

    /* renamed from: f  reason: collision with root package name */
    private final okio.e f30367f;

    /* renamed from: g  reason: collision with root package name */
    private final okio.d f30368g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1ExchangeCodec.kt */
    /* loaded from: classes3.dex */
    public abstract class a implements t {

        /* renamed from: a  reason: collision with root package name */
        private final i f30369a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f30370b;

        public a() {
            this.f30369a = new i(b.this.f30367f.timeout());
        }

        protected final boolean c() {
            return this.f30370b;
        }

        public final void d() {
            if (b.this.f30362a != 6) {
                if (b.this.f30362a == 5) {
                    b.this.r(this.f30369a);
                    b.this.f30362a = 6;
                    return;
                }
                throw new IllegalStateException("state: " + b.this.f30362a);
            }
        }

        protected final void h(boolean z10) {
            this.f30370b = z10;
        }

        @Override // okio.t
        public long read(okio.c sink, long j10) {
            kotlin.jvm.internal.i.f(sink, "sink");
            try {
                return b.this.f30367f.read(sink, j10);
            } catch (IOException e10) {
                b.this.e().z();
                d();
                throw e10;
            }
        }

        @Override // okio.t
        public u timeout() {
            return this.f30369a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1ExchangeCodec.kt */
    /* renamed from: kp.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public final class C0378b implements r {

        /* renamed from: a  reason: collision with root package name */
        private final i f30372a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f30373b;

        public C0378b() {
            this.f30372a = new i(b.this.f30368g.timeout());
        }

        @Override // okio.r
        public void Z(okio.c source, long j10) {
            kotlin.jvm.internal.i.f(source, "source");
            if (!(!this.f30373b)) {
                throw new IllegalStateException("closed".toString());
            } else if (j10 != 0) {
                b.this.f30368g.c0(j10);
                b.this.f30368g.R("\r\n");
                b.this.f30368g.Z(source, j10);
                b.this.f30368g.R("\r\n");
            }
        }

        @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (!this.f30373b) {
                this.f30373b = true;
                b.this.f30368g.R("0\r\n\r\n");
                b.this.r(this.f30372a);
                b.this.f30362a = 3;
            }
        }

        @Override // okio.r, java.io.Flushable
        public synchronized void flush() {
            if (!this.f30373b) {
                b.this.f30368g.flush();
            }
        }

        @Override // okio.r
        public u timeout() {
            return this.f30372a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1ExchangeCodec.kt */
    /* loaded from: classes3.dex */
    public final class c extends a {

        /* renamed from: d  reason: collision with root package name */
        private long f30375d = -1;

        /* renamed from: e  reason: collision with root package name */
        private boolean f30376e = true;

        /* renamed from: f  reason: collision with root package name */
        private final okhttp3.u f30377f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ b f30378g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, okhttp3.u url) {
            super();
            kotlin.jvm.internal.i.f(url, "url");
            this.f30378g = bVar;
            this.f30377f = url;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
            if (r1 != false) goto L16;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void i() {
            CharSequence E0;
            boolean D;
            if (this.f30375d != -1) {
                this.f30378g.f30367f.n0();
            }
            try {
                this.f30375d = this.f30378g.f30367f.E0();
                String n02 = this.f30378g.f30367f.n0();
                if (n02 != null) {
                    E0 = kotlin.text.u.E0(n02);
                    String obj = E0.toString();
                    if (this.f30375d >= 0) {
                        if (obj.length() > 0) {
                            D = kotlin.text.t.D(obj, ";", false, 2, null);
                        }
                        if (this.f30375d == 0) {
                            this.f30376e = false;
                            b bVar = this.f30378g;
                            bVar.f30364c = bVar.f30363b.a();
                            y yVar = this.f30378g.f30365d;
                            kotlin.jvm.internal.i.d(yVar);
                            n l10 = yVar.l();
                            okhttp3.u uVar = this.f30377f;
                            Headers headers = this.f30378g.f30364c;
                            kotlin.jvm.internal.i.d(headers);
                            jp.e.f(l10, uVar, headers);
                            d();
                            return;
                        }
                        return;
                    }
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f30375d + obj + '\"');
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            } catch (NumberFormatException e10) {
                throw new ProtocolException(e10.getMessage());
            }
        }

        @Override // okio.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!c()) {
                if (this.f30376e && !gp.b.p(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f30378g.e().z();
                    d();
                }
                h(true);
            }
        }

        @Override // kp.b.a, okio.t
        public long read(okio.c sink, long j10) {
            kotlin.jvm.internal.i.f(sink, "sink");
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
            } else if (!(!c())) {
                throw new IllegalStateException("closed".toString());
            } else if (!this.f30376e) {
                return -1L;
            } else {
                long j11 = this.f30375d;
                if (j11 == 0 || j11 == -1) {
                    i();
                    if (!this.f30376e) {
                        return -1L;
                    }
                }
                long read = super.read(sink, Math.min(j10, this.f30375d));
                if (read != -1) {
                    this.f30375d -= read;
                    return read;
                }
                this.f30378g.e().z();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                d();
                throw protocolException;
            }
        }
    }

    /* compiled from: Http1ExchangeCodec.kt */
    /* loaded from: classes3.dex */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1ExchangeCodec.kt */
    /* loaded from: classes3.dex */
    public final class e extends a {

        /* renamed from: d  reason: collision with root package name */
        private long f30379d;

        public e(long j10) {
            super();
            this.f30379d = j10;
            if (j10 == 0) {
                d();
            }
        }

        @Override // okio.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!c()) {
                if (this.f30379d != 0 && !gp.b.p(this, 100, TimeUnit.MILLISECONDS)) {
                    b.this.e().z();
                    d();
                }
                h(true);
            }
        }

        @Override // kp.b.a, okio.t
        public long read(okio.c sink, long j10) {
            kotlin.jvm.internal.i.f(sink, "sink");
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
            } else if (!c()) {
                long j11 = this.f30379d;
                if (j11 == 0) {
                    return -1L;
                }
                long read = super.read(sink, Math.min(j11, j10));
                if (read != -1) {
                    long j12 = this.f30379d - read;
                    this.f30379d = j12;
                    if (j12 == 0) {
                        d();
                    }
                    return read;
                }
                b.this.e().z();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                d();
                throw protocolException;
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1ExchangeCodec.kt */
    /* loaded from: classes3.dex */
    public final class f implements r {

        /* renamed from: a  reason: collision with root package name */
        private final i f30381a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f30382b;

        public f() {
            this.f30381a = new i(b.this.f30368g.timeout());
        }

        @Override // okio.r
        public void Z(okio.c source, long j10) {
            kotlin.jvm.internal.i.f(source, "source");
            if (!this.f30382b) {
                gp.b.i(source.i0(), 0L, j10);
                b.this.f30368g.Z(source, j10);
                return;
            }
            throw new IllegalStateException("closed".toString());
        }

        @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f30382b) {
                this.f30382b = true;
                b.this.r(this.f30381a);
                b.this.f30362a = 3;
            }
        }

        @Override // okio.r, java.io.Flushable
        public void flush() {
            if (!this.f30382b) {
                b.this.f30368g.flush();
            }
        }

        @Override // okio.r
        public u timeout() {
            return this.f30381a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Http1ExchangeCodec.kt */
    /* loaded from: classes3.dex */
    public final class g extends a {

        /* renamed from: d  reason: collision with root package name */
        private boolean f30384d;

        public g(b bVar) {
            super();
        }

        @Override // okio.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!c()) {
                if (!this.f30384d) {
                    d();
                }
                h(true);
            }
        }

        @Override // kp.b.a, okio.t
        public long read(okio.c sink, long j10) {
            kotlin.jvm.internal.i.f(sink, "sink");
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
            } else if (!(!c())) {
                throw new IllegalStateException("closed".toString());
            } else if (this.f30384d) {
                return -1L;
            } else {
                long read = super.read(sink, j10);
                if (read != -1) {
                    return read;
                }
                this.f30384d = true;
                d();
                return -1L;
            }
        }
    }

    static {
        new d(null);
    }

    public b(y yVar, okhttp3.internal.connection.f connection, okio.e source, okio.d sink) {
        kotlin.jvm.internal.i.f(connection, "connection");
        kotlin.jvm.internal.i.f(source, "source");
        kotlin.jvm.internal.i.f(sink, "sink");
        this.f30365d = yVar;
        this.f30366e = connection;
        this.f30367f = source;
        this.f30368g = sink;
        this.f30363b = new kp.a(source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(i iVar) {
        u i10 = iVar.i();
        iVar.j(u.f32422d);
        i10.a();
        i10.b();
    }

    private final boolean s(z zVar) {
        boolean p10;
        p10 = kotlin.text.t.p("chunked", zVar.d("Transfer-Encoding"), true);
        return p10;
    }

    private final boolean t(b0 b0Var) {
        boolean p10;
        p10 = kotlin.text.t.p("chunked", b0.w(b0Var, "Transfer-Encoding", null, 2, null), true);
        return p10;
    }

    private final r u() {
        boolean z10 = true;
        if (this.f30362a != 1) {
            z10 = false;
        }
        if (z10) {
            this.f30362a = 2;
            return new C0378b();
        }
        throw new IllegalStateException(("state: " + this.f30362a).toString());
    }

    private final t v(okhttp3.u uVar) {
        if (this.f30362a == 4) {
            this.f30362a = 5;
            return new c(this, uVar);
        }
        throw new IllegalStateException(("state: " + this.f30362a).toString());
    }

    private final t w(long j10) {
        if (this.f30362a == 4) {
            this.f30362a = 5;
            return new e(j10);
        }
        throw new IllegalStateException(("state: " + this.f30362a).toString());
    }

    private final r x() {
        boolean z10 = true;
        if (this.f30362a != 1) {
            z10 = false;
        }
        if (z10) {
            this.f30362a = 2;
            return new f();
        }
        throw new IllegalStateException(("state: " + this.f30362a).toString());
    }

    private final t y() {
        if (this.f30362a == 4) {
            this.f30362a = 5;
            e().z();
            return new g(this);
        }
        throw new IllegalStateException(("state: " + this.f30362a).toString());
    }

    public final void A(Headers headers, String requestLine) {
        kotlin.jvm.internal.i.f(headers, "headers");
        kotlin.jvm.internal.i.f(requestLine, "requestLine");
        if (this.f30362a == 0) {
            this.f30368g.R(requestLine).R("\r\n");
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f30368g.R(headers.name(i10)).R(": ").R(headers.value(i10)).R("\r\n");
            }
            this.f30368g.R("\r\n");
            this.f30362a = 1;
            return;
        }
        throw new IllegalStateException(("state: " + this.f30362a).toString());
    }

    @Override // jp.d
    public void a() {
        this.f30368g.flush();
    }

    @Override // jp.d
    public void b(z request) {
        kotlin.jvm.internal.i.f(request, "request");
        jp.i iVar = jp.i.f29674a;
        Proxy.Type type = e().A().b().type();
        kotlin.jvm.internal.i.e(type, "connection.route().proxy.type()");
        A(request.f(), iVar.a(request, type));
    }

    @Override // jp.d
    public t c(b0 response) {
        kotlin.jvm.internal.i.f(response, "response");
        if (!jp.e.b(response)) {
            return w(0L);
        }
        if (t(response)) {
            return v(response.g0().l());
        }
        long s10 = gp.b.s(response);
        if (s10 != -1) {
            return w(s10);
        }
        return y();
    }

    @Override // jp.d
    public void cancel() {
        e().e();
    }

    @Override // jp.d
    public b0.a d(boolean z10) {
        int i10 = this.f30362a;
        boolean z11 = true;
        if (!(i10 == 1 || i10 == 3)) {
            z11 = false;
        }
        if (z11) {
            try {
                k a10 = k.f29676d.a(this.f30363b.b());
                b0.a k10 = new b0.a().p(a10.f29677a).g(a10.f29678b).m(a10.f29679c).k(this.f30363b.a());
                if (z10 && a10.f29678b == 100) {
                    return null;
                }
                if (a10.f29678b == 100) {
                    this.f30362a = 3;
                    return k10;
                }
                this.f30362a = 4;
                return k10;
            } catch (EOFException e10) {
                String r10 = e().A().a().l().r();
                throw new IOException("unexpected end of stream on " + r10, e10);
            }
        } else {
            throw new IllegalStateException(("state: " + this.f30362a).toString());
        }
    }

    @Override // jp.d
    public okhttp3.internal.connection.f e() {
        return this.f30366e;
    }

    @Override // jp.d
    public void f() {
        this.f30368g.flush();
    }

    @Override // jp.d
    public long g(b0 response) {
        kotlin.jvm.internal.i.f(response, "response");
        if (!jp.e.b(response)) {
            return 0L;
        }
        if (t(response)) {
            return -1L;
        }
        return gp.b.s(response);
    }

    @Override // jp.d
    public r h(z request, long j10) {
        kotlin.jvm.internal.i.f(request, "request");
        if (request.a() != null && request.a().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        } else if (s(request)) {
            return u();
        } else {
            if (j10 != -1) {
                return x();
            }
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    public final void z(b0 response) {
        kotlin.jvm.internal.i.f(response, "response");
        long s10 = gp.b.s(response);
        if (s10 != -1) {
            t w10 = w(s10);
            gp.b.I(w10, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            w10.close();
        }
    }
}
