package okhttp3;

import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import jp.k;
import kotlin.collections.i0;
import kotlin.collections.m;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.u;
import okhttp3.Headers;
import okhttp3.b0;
import okhttp3.internal.cache.d;
import okhttp3.internal.platform.h;
import okhttp3.z;
import okio.ByteString;
import okio.e;
import okio.g;
import okio.h;
import okio.n;
import okio.r;
import okio.t;
/* compiled from: Cache.kt */
/* loaded from: classes3.dex */
public final class c implements Closeable, Flushable {

    /* renamed from: g  reason: collision with root package name */
    public static final b f31779g = new b(null);

    /* renamed from: a  reason: collision with root package name */
    private final okhttp3.internal.cache.d f31780a;

    /* renamed from: b  reason: collision with root package name */
    private int f31781b;

    /* renamed from: c  reason: collision with root package name */
    private int f31782c;

    /* renamed from: d  reason: collision with root package name */
    private int f31783d;

    /* renamed from: e  reason: collision with root package name */
    private int f31784e;

    /* renamed from: f  reason: collision with root package name */
    private int f31785f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cache.kt */
    /* loaded from: classes3.dex */
    public static final class a extends c0 {

        /* renamed from: a  reason: collision with root package name */
        private final e f31786a;

        /* renamed from: b  reason: collision with root package name */
        private final d.C0429d f31787b;

        /* renamed from: c  reason: collision with root package name */
        private final String f31788c;

        /* renamed from: d  reason: collision with root package name */
        private final String f31789d;

        /* compiled from: Cache.kt */
        /* renamed from: okhttp3.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0426a extends h {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ t f31791b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0426a(t tVar, t tVar2) {
                super(tVar2);
                this.f31791b = tVar;
            }

            @Override // okio.h, okio.t, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                a.this.c().close();
                super.close();
            }
        }

        public a(d.C0429d snapshot, String str, String str2) {
            i.f(snapshot, "snapshot");
            this.f31787b = snapshot;
            this.f31788c = str;
            this.f31789d = str2;
            t d10 = snapshot.d(1);
            this.f31786a = n.d(new C0426a(d10, d10));
        }

        public final d.C0429d c() {
            return this.f31787b;
        }

        @Override // okhttp3.c0
        public long contentLength() {
            String str = this.f31789d;
            if (str != null) {
                return gp.b.Q(str, -1L);
            }
            return -1L;
        }

        @Override // okhttp3.c0
        public w contentType() {
            String str = this.f31788c;
            if (str != null) {
                return w.f32297g.b(str);
            }
            return null;
        }

        @Override // okhttp3.c0
        public e source() {
            return this.f31786a;
        }
    }

    /* compiled from: Cache.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        private final Set<String> d(Headers headers) {
            Set<String> b10;
            boolean p10;
            List<String> n02;
            CharSequence E0;
            Comparator<String> r10;
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i10 = 0; i10 < size; i10++) {
                p10 = kotlin.text.t.p("Vary", headers.name(i10), true);
                if (p10) {
                    String value = headers.value(i10);
                    if (treeSet == null) {
                        r10 = kotlin.text.t.r(kotlin.jvm.internal.n.f30086a);
                        treeSet = new TreeSet(r10);
                    }
                    n02 = u.n0(value, new char[]{','}, false, 0, 6, null);
                    for (String str : n02) {
                        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                        E0 = u.E0(str);
                        treeSet.add(E0.toString());
                    }
                }
            }
            if (treeSet != null) {
                return treeSet;
            }
            b10 = i0.b();
            return b10;
        }

        private final Headers e(Headers headers, Headers headers2) {
            Set<String> d10 = d(headers2);
            if (d10.isEmpty()) {
                return gp.b.f27626b;
            }
            Headers.a aVar = new Headers.a();
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                String name = headers.name(i10);
                if (d10.contains(name)) {
                    aVar.b(name, headers.value(i10));
                }
            }
            return aVar.f();
        }

        public final boolean a(b0 hasVaryAll) {
            i.f(hasVaryAll, "$this$hasVaryAll");
            return d(hasVaryAll.x()).contains(MessageProxyConstants.NODE_ID_ANY);
        }

        public final String b(u url) {
            i.f(url, "url");
            return ByteString.Companion.d(url.toString()).md5().hex();
        }

        public final int c(e source) throws IOException {
            i.f(source, "source");
            try {
                long H = source.H();
                String n02 = source.n0();
                if (H >= 0 && H <= Integer.MAX_VALUE) {
                    if (!(n02.length() > 0)) {
                        return (int) H;
                    }
                }
                throw new IOException("expected an int but was \"" + H + n02 + '\"');
            } catch (NumberFormatException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        public final Headers f(b0 varyHeaders) {
            i.f(varyHeaders, "$this$varyHeaders");
            b0 O = varyHeaders.O();
            i.d(O);
            return e(O.g0().f(), varyHeaders.x());
        }

        public final boolean g(b0 cachedResponse, Headers cachedRequest, z newRequest) {
            i.f(cachedResponse, "cachedResponse");
            i.f(cachedRequest, "cachedRequest");
            i.f(newRequest, "newRequest");
            Set<String> d10 = d(cachedResponse.x());
            if ((d10 instanceof Collection) && d10.isEmpty()) {
                return true;
            }
            for (String str : d10) {
                if (!i.b(cachedRequest.values(str), newRequest.e(str))) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    /* compiled from: Cache.kt */
    /* loaded from: classes3.dex */
    private final class d implements okhttp3.internal.cache.b {

        /* renamed from: a  reason: collision with root package name */
        private final r f31804a;

        /* renamed from: b  reason: collision with root package name */
        private final r f31805b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f31806c;

        /* renamed from: d  reason: collision with root package name */
        private final d.b f31807d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f31808e;

        /* compiled from: Cache.kt */
        /* loaded from: classes3.dex */
        public static final class a extends g {
            a(r rVar) {
                super(rVar);
            }

            @Override // okio.g, okio.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                synchronized (d.this.f31808e) {
                    if (!d.this.d()) {
                        d.this.e(true);
                        c cVar = d.this.f31808e;
                        cVar.u(cVar.i() + 1);
                        super.close();
                        d.this.f31807d.b();
                    }
                }
            }
        }

        public d(c cVar, d.b editor) {
            i.f(editor, "editor");
            this.f31808e = cVar;
            this.f31807d = editor;
            r f10 = editor.f(1);
            this.f31804a = f10;
            this.f31805b = new a(f10);
        }

        @Override // okhttp3.internal.cache.b
        public void a() {
            synchronized (this.f31808e) {
                if (!this.f31806c) {
                    this.f31806c = true;
                    c cVar = this.f31808e;
                    cVar.q(cVar.h() + 1);
                    gp.b.j(this.f31804a);
                    try {
                        this.f31807d.a();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        @Override // okhttp3.internal.cache.b
        public r b() {
            return this.f31805b;
        }

        public final boolean d() {
            return this.f31806c;
        }

        public final void e(boolean z10) {
            this.f31806c = z10;
        }
    }

    public c(File directory, long j10, mp.a fileSystem) {
        i.f(directory, "directory");
        i.f(fileSystem, "fileSystem");
        this.f31780a = new okhttp3.internal.cache.d(fileSystem, directory, 201105, 2, j10, ip.e.f29318h);
    }

    private final void c(d.b bVar) {
        if (bVar != null) {
            try {
                bVar.a();
            } catch (IOException unused) {
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f31780a.close();
    }

    public final b0 d(z request) {
        i.f(request, "request");
        try {
            d.C0429d O = this.f31780a.O(f31779g.b(request.l()));
            if (O != null) {
                try {
                    C0427c cVar = new C0427c(O.d(0));
                    b0 d10 = cVar.d(O);
                    if (cVar.b(request, d10)) {
                        return d10;
                    }
                    c0 c10 = d10.c();
                    if (c10 != null) {
                        gp.b.j(c10);
                    }
                    return null;
                } catch (IOException unused) {
                    gp.b.j(O);
                }
            }
        } catch (IOException unused2) {
        }
        return null;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f31780a.flush();
    }

    public final int h() {
        return this.f31782c;
    }

    public final int i() {
        return this.f31781b;
    }

    public final okhttp3.internal.cache.b n(b0 response) {
        d.b bVar;
        i.f(response, "response");
        String h10 = response.g0().h();
        if (jp.f.f29661a.a(response.g0().h())) {
            try {
                o(response.g0());
            } catch (IOException unused) {
            }
            return null;
        } else if (!i.b(h10, "GET")) {
            return null;
        } else {
            b bVar2 = f31779g;
            if (bVar2.a(response)) {
                return null;
            }
            C0427c cVar = new C0427c(response);
            try {
                bVar = okhttp3.internal.cache.d.I(this.f31780a, bVar2.b(response.g0().l()), 0L, 2, null);
                if (bVar == null) {
                    return null;
                }
                try {
                    cVar.f(bVar);
                    return new d(this, bVar);
                } catch (IOException unused2) {
                    c(bVar);
                    return null;
                }
            } catch (IOException unused3) {
                bVar = null;
            }
        }
    }

    public final void o(z request) throws IOException {
        i.f(request, "request");
        this.f31780a.r0(f31779g.b(request.l()));
    }

    public final void q(int i10) {
        this.f31782c = i10;
    }

    public final void u(int i10) {
        this.f31781b = i10;
    }

    public final synchronized void v() {
        this.f31784e++;
    }

    public final synchronized void w(okhttp3.internal.cache.c cacheStrategy) {
        i.f(cacheStrategy, "cacheStrategy");
        this.f31785f++;
        if (cacheStrategy.b() != null) {
            this.f31783d++;
        } else if (cacheStrategy.a() != null) {
            this.f31784e++;
        }
    }

    public final void x(b0 cached, b0 network) {
        i.f(cached, "cached");
        i.f(network, "network");
        C0427c cVar = new C0427c(network);
        c0 c10 = cached.c();
        Objects.requireNonNull(c10, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        d.b bVar = null;
        try {
            bVar = ((a) c10).c().c();
            if (bVar != null) {
                cVar.f(bVar);
                bVar.b();
            }
        } catch (IOException unused) {
            c(bVar);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(File directory, long j10) {
        this(directory, j10, mp.a.f30844a);
        i.f(directory, "directory");
    }

    /* compiled from: Cache.kt */
    /* renamed from: okhttp3.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C0427c {

        /* renamed from: k  reason: collision with root package name */
        private static final String f31792k;

        /* renamed from: l  reason: collision with root package name */
        private static final String f31793l;

        /* renamed from: a  reason: collision with root package name */
        private final String f31794a;

        /* renamed from: b  reason: collision with root package name */
        private final Headers f31795b;

        /* renamed from: c  reason: collision with root package name */
        private final String f31796c;

        /* renamed from: d  reason: collision with root package name */
        private final Protocol f31797d;

        /* renamed from: e  reason: collision with root package name */
        private final int f31798e;

        /* renamed from: f  reason: collision with root package name */
        private final String f31799f;

        /* renamed from: g  reason: collision with root package name */
        private final Headers f31800g;

        /* renamed from: h  reason: collision with root package name */
        private final t f31801h;

        /* renamed from: i  reason: collision with root package name */
        private final long f31802i;

        /* renamed from: j  reason: collision with root package name */
        private final long f31803j;

        /* compiled from: Cache.kt */
        /* renamed from: okhttp3.c$c$a */
        /* loaded from: classes3.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        static {
            new a(null);
            StringBuilder sb2 = new StringBuilder();
            h.a aVar = okhttp3.internal.platform.h.f32213c;
            sb2.append(aVar.g().g());
            sb2.append("-Sent-Millis");
            f31792k = sb2.toString();
            f31793l = aVar.g().g() + "-Received-Millis";
        }

        public C0427c(t rawSource) throws IOException {
            TlsVersion tlsVersion;
            i.f(rawSource, "rawSource");
            try {
                e d10 = n.d(rawSource);
                this.f31794a = d10.n0();
                this.f31796c = d10.n0();
                Headers.a aVar = new Headers.a();
                int c10 = c.f31779g.c(d10);
                boolean z10 = false;
                for (int i10 = 0; i10 < c10; i10++) {
                    aVar.c(d10.n0());
                }
                this.f31795b = aVar.f();
                k a10 = k.f29676d.a(d10.n0());
                this.f31797d = a10.f29677a;
                this.f31798e = a10.f29678b;
                this.f31799f = a10.f29679c;
                Headers.a aVar2 = new Headers.a();
                int c11 = c.f31779g.c(d10);
                for (int i11 = 0; i11 < c11; i11++) {
                    aVar2.c(d10.n0());
                }
                String str = f31792k;
                String g10 = aVar2.g(str);
                String str2 = f31793l;
                String g11 = aVar2.g(str2);
                aVar2.i(str);
                aVar2.i(str2);
                long j10 = 0;
                this.f31802i = g10 != null ? Long.parseLong(g10) : 0L;
                this.f31803j = g11 != null ? Long.parseLong(g11) : j10;
                this.f31800g = aVar2.f();
                if (a()) {
                    String n02 = d10.n0();
                    if (!(n02.length() > 0 ? true : z10)) {
                        i b10 = i.f31871t.b(d10.n0());
                        List<Certificate> c12 = c(d10);
                        List<Certificate> c13 = c(d10);
                        if (!d10.B()) {
                            tlsVersion = TlsVersion.Companion.a(d10.n0());
                        } else {
                            tlsVersion = TlsVersion.SSL_3_0;
                        }
                        this.f31801h = t.f32269e.b(tlsVersion, b10, c12, c13);
                    } else {
                        throw new IOException("expected \"\" but was \"" + n02 + '\"');
                    }
                } else {
                    this.f31801h = null;
                }
            } finally {
                rawSource.close();
            }
        }

        private final boolean a() {
            boolean D;
            D = kotlin.text.t.D(this.f31794a, "https://", false, 2, null);
            return D;
        }

        private final List<Certificate> c(e eVar) throws IOException {
            List<Certificate> g10;
            int c10 = c.f31779g.c(eVar);
            if (c10 == -1) {
                g10 = m.g();
                return g10;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(c10);
                for (int i10 = 0; i10 < c10; i10++) {
                    String n02 = eVar.n0();
                    okio.c cVar = new okio.c();
                    ByteString a10 = ByteString.Companion.a(n02);
                    i.d(a10);
                    cVar.v0(a10);
                    arrayList.add(certificateFactory.generateCertificate(cVar.F0()));
                }
                return arrayList;
            } catch (CertificateException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        private final void e(okio.d dVar, List<? extends Certificate> list) throws IOException {
            try {
                dVar.C0(list.size()).C(10);
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    byte[] bytes = list.get(i10).getEncoded();
                    ByteString.a aVar = ByteString.Companion;
                    i.e(bytes, "bytes");
                    dVar.R(ByteString.a.h(aVar, bytes, 0, 0, 3, null).base64()).C(10);
                }
            } catch (CertificateEncodingException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        public final boolean b(z request, b0 response) {
            i.f(request, "request");
            i.f(response, "response");
            return i.b(this.f31794a, request.l().toString()) && i.b(this.f31796c, request.h()) && c.f31779g.g(response, this.f31795b, request);
        }

        public final b0 d(d.C0429d snapshot) {
            i.f(snapshot, "snapshot");
            String str = this.f31800g.get("Content-Type");
            String str2 = this.f31800g.get("Content-Length");
            return new b0.a().s(new z.a().p(this.f31794a).j(this.f31796c, null).i(this.f31795b).b()).p(this.f31797d).g(this.f31798e).m(this.f31799f).k(this.f31800g).b(new a(snapshot, str, str2)).i(this.f31801h).t(this.f31802i).q(this.f31803j).c();
        }

        public final void f(d.b editor) throws IOException {
            i.f(editor, "editor");
            okio.d c10 = n.c(editor.f(0));
            try {
                c10.R(this.f31794a).C(10);
                c10.R(this.f31796c).C(10);
                c10.C0(this.f31795b.size()).C(10);
                int size = this.f31795b.size();
                for (int i10 = 0; i10 < size; i10++) {
                    c10.R(this.f31795b.name(i10)).R(": ").R(this.f31795b.value(i10)).C(10);
                }
                c10.R(new k(this.f31797d, this.f31798e, this.f31799f).toString()).C(10);
                c10.C0(this.f31800g.size() + 2).C(10);
                int size2 = this.f31800g.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    c10.R(this.f31800g.name(i11)).R(": ").R(this.f31800g.value(i11)).C(10);
                }
                c10.R(f31792k).R(": ").C0(this.f31802i).C(10);
                c10.R(f31793l).R(": ").C0(this.f31803j).C(10);
                if (a()) {
                    c10.C(10);
                    t tVar = this.f31801h;
                    i.d(tVar);
                    c10.R(tVar.a().c()).C(10);
                    e(c10, this.f31801h.d());
                    e(c10, this.f31801h.c());
                    c10.R(this.f31801h.e().javaName()).C(10);
                }
                io.m mVar = io.m.f28349a;
                th = null;
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        }

        public C0427c(b0 response) {
            i.f(response, "response");
            this.f31794a = response.g0().l().toString();
            this.f31795b = c.f31779g.f(response);
            this.f31796c = response.g0().h();
            this.f31797d = response.V();
            this.f31798e = response.n();
            this.f31799f = response.I();
            this.f31800g = response.x();
            this.f31801h = response.q();
            this.f31802i = response.h0();
            this.f31803j = response.W();
        }
    }
}
