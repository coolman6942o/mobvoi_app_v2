package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import jp.h;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.b0;
import okhttp3.c;
import okhttp3.c0;
import okhttp3.internal.cache.c;
import okhttp3.v;
import okhttp3.z;
import okio.d;
import okio.e;
import okio.n;
import okio.r;
import okio.u;
/* compiled from: CacheInterceptor.kt */
/* loaded from: classes3.dex */
public final class a implements v {

    /* renamed from: b  reason: collision with root package name */
    public static final C0428a f31873b = new C0428a(null);

    /* renamed from: a  reason: collision with root package name */
    private final c f31874a;

    /* compiled from: CacheInterceptor.kt */
    /* renamed from: okhttp3.internal.cache.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0428a {
        private C0428a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Headers c(Headers headers, Headers headers2) {
            boolean p10;
            boolean D;
            Headers.a aVar = new Headers.a();
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                String name = headers.name(i10);
                String value = headers.value(i10);
                p10 = t.p("Warning", name, true);
                if (p10) {
                    D = t.D(value, "1", false, 2, null);
                    if (D) {
                    }
                }
                if (d(name) || !e(name) || headers2.get(name) == null) {
                    aVar.d(name, value);
                }
            }
            int size2 = headers2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                String name2 = headers2.name(i11);
                if (!d(name2) && e(name2)) {
                    aVar.d(name2, headers2.value(i11));
                }
            }
            return aVar.f();
        }

        private final boolean d(String str) {
            boolean p10;
            boolean p11;
            boolean p12;
            p10 = t.p("Content-Length", str, true);
            if (p10) {
                return true;
            }
            p11 = t.p("Content-Encoding", str, true);
            if (p11) {
                return true;
            }
            p12 = t.p("Content-Type", str, true);
            return p12;
        }

        private final boolean e(String str) {
            boolean p10;
            boolean p11;
            boolean p12;
            boolean p13;
            boolean p14;
            boolean p15;
            boolean p16;
            boolean p17;
            p10 = t.p("Connection", str, true);
            if (!p10) {
                p11 = t.p("Keep-Alive", str, true);
                if (!p11) {
                    p12 = t.p("Proxy-Authenticate", str, true);
                    if (!p12) {
                        p13 = t.p("Proxy-Authorization", str, true);
                        if (!p13) {
                            p14 = t.p("TE", str, true);
                            if (!p14) {
                                p15 = t.p("Trailers", str, true);
                                if (!p15) {
                                    p16 = t.p("Transfer-Encoding", str, true);
                                    if (!p16) {
                                        p17 = t.p("Upgrade", str, true);
                                        if (!p17) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final b0 f(b0 b0Var) {
            return (b0Var != null ? b0Var.c() : null) != null ? b0Var.Q().b(null).c() : b0Var;
        }

        public /* synthetic */ C0428a(f fVar) {
            this();
        }
    }

    /* compiled from: CacheInterceptor.kt */
    /* loaded from: classes3.dex */
    public static final class b implements okio.t {

        /* renamed from: a  reason: collision with root package name */
        private boolean f31875a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f31876b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ okhttp3.internal.cache.b f31877c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d f31878d;

        b(e eVar, okhttp3.internal.cache.b bVar, d dVar) {
            this.f31876b = eVar;
            this.f31877c = bVar;
            this.f31878d = dVar;
        }

        @Override // okio.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f31875a && !gp.b.p(this, 100, TimeUnit.MILLISECONDS)) {
                this.f31875a = true;
                this.f31877c.a();
            }
            this.f31876b.close();
        }

        @Override // okio.t
        public long read(okio.c sink, long j10) throws IOException {
            i.f(sink, "sink");
            try {
                long read = this.f31876b.read(sink, j10);
                if (read == -1) {
                    if (!this.f31875a) {
                        this.f31875a = true;
                        this.f31878d.close();
                    }
                    return -1L;
                }
                sink.o(this.f31878d.b(), sink.i0() - read, read);
                this.f31878d.G();
                return read;
            } catch (IOException e10) {
                if (!this.f31875a) {
                    this.f31875a = true;
                    this.f31877c.a();
                }
                throw e10;
            }
        }

        @Override // okio.t
        public u timeout() {
            return this.f31876b.timeout();
        }
    }

    public a(c cVar) {
        this.f31874a = cVar;
    }

    private final b0 a(okhttp3.internal.cache.b bVar, b0 b0Var) throws IOException {
        if (bVar == null) {
            return b0Var;
        }
        r b10 = bVar.b();
        c0 c10 = b0Var.c();
        i.d(c10);
        b bVar2 = new b(c10.source(), bVar, n.c(b10));
        return b0Var.Q().b(new h(b0.w(b0Var, "Content-Type", null, 2, null), b0Var.c().contentLength(), n.d(bVar2))).c();
    }

    @Override // okhttp3.v
    public b0 intercept(v.a chain) throws IOException {
        okhttp3.r rVar;
        c0 c10;
        c0 c11;
        i.f(chain, "chain");
        okhttp3.e call = chain.call();
        c cVar = this.f31874a;
        okhttp3.internal.connection.e eVar = null;
        b0 d10 = cVar != null ? cVar.d(chain.request()) : null;
        c b10 = new c.b(System.currentTimeMillis(), chain.request(), d10).b();
        z b11 = b10.b();
        b0 a10 = b10.a();
        okhttp3.c cVar2 = this.f31874a;
        if (cVar2 != null) {
            cVar2.w(b10);
        }
        if (call instanceof okhttp3.internal.connection.e) {
            eVar = call;
        }
        okhttp3.internal.connection.e eVar2 = eVar;
        if (eVar2 == null || (rVar = eVar2.m()) == null) {
            rVar = okhttp3.r.f32262a;
        }
        if (!(d10 == null || a10 != null || (c11 = d10.c()) == null)) {
            gp.b.j(c11);
        }
        if (b11 == null && a10 == null) {
            b0 c12 = new b0.a().s(chain.request()).p(Protocol.HTTP_1_1).g(504).m("Unsatisfiable Request (only-if-cached)").b(gp.b.f27627c).t(-1L).q(System.currentTimeMillis()).c();
            rVar.A(call, c12);
            return c12;
        } else if (b11 == null) {
            i.d(a10);
            b0 c13 = a10.Q().d(f31873b.f(a10)).c();
            rVar.b(call, c13);
            return c13;
        } else {
            if (a10 != null) {
                rVar.a(call, a10);
            } else if (this.f31874a != null) {
                rVar.c(call);
            }
            try {
                b0 a11 = chain.a(b11);
                if (!(a11 != null || d10 == null || c10 == null)) {
                }
                if (a10 != null) {
                    if (a11 == null || a11.n() != 304) {
                        c0 c14 = a10.c();
                        if (c14 != null) {
                            gp.b.j(c14);
                        }
                    } else {
                        b0.a Q = a10.Q();
                        C0428a aVar = f31873b;
                        b0 c15 = Q.k(aVar.c(a10.x(), a11.x())).t(a11.h0()).q(a11.W()).d(aVar.f(a10)).n(aVar.f(a11)).c();
                        c0 c16 = a11.c();
                        i.d(c16);
                        c16.close();
                        okhttp3.c cVar3 = this.f31874a;
                        i.d(cVar3);
                        cVar3.v();
                        this.f31874a.x(a10, c15);
                        rVar.b(call, c15);
                        return c15;
                    }
                }
                i.d(a11);
                b0.a Q2 = a11.Q();
                C0428a aVar2 = f31873b;
                b0 c17 = Q2.d(aVar2.f(a10)).n(aVar2.f(a11)).c();
                if (this.f31874a != null) {
                    if (jp.e.b(c17) && c.f31879c.a(c17, b11)) {
                        b0 a12 = a(this.f31874a.n(c17), c17);
                        if (a10 != null) {
                            rVar.c(call);
                        }
                        return a12;
                    } else if (jp.f.f29661a.a(b11.h())) {
                        try {
                            this.f31874a.o(b11);
                        } catch (IOException unused) {
                        }
                    }
                }
                return c17;
            } finally {
                if (!(d10 == null || (c10 = d10.c()) == null)) {
                    gp.b.j(c10);
                }
            }
        }
    }
}
