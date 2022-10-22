package lp;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import jp.d;
import jp.e;
import jp.g;
import jp.k;
import kotlin.jvm.internal.i;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.b0;
import okhttp3.internal.connection.f;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.b;
import okhttp3.y;
import okhttp3.z;
import okio.r;
import okio.t;
/* compiled from: Http2ExchangeCodec.kt */
/* loaded from: classes3.dex */
public final class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private volatile okhttp3.internal.http2.d f30582a;

    /* renamed from: b  reason: collision with root package name */
    private final Protocol f30583b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f30584c;

    /* renamed from: d  reason: collision with root package name */
    private final f f30585d;

    /* renamed from: e  reason: collision with root package name */
    private final g f30586e;

    /* renamed from: f  reason: collision with root package name */
    private final b f30587f;

    /* renamed from: i  reason: collision with root package name */
    public static final a f30581i = new a(null);

    /* renamed from: g  reason: collision with root package name */
    private static final List<String> f30579g = gp.b.t("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: h  reason: collision with root package name */
    private static final List<String> f30580h = gp.b.t("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* compiled from: Http2ExchangeCodec.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final List<lp.a> a(z request) {
            i.f(request, "request");
            Headers f10 = request.f();
            ArrayList arrayList = new ArrayList(f10.size() + 4);
            arrayList.add(new lp.a(lp.a.f30567f, request.h()));
            arrayList.add(new lp.a(lp.a.f30568g, jp.i.f29674a.c(request.l())));
            String d10 = request.d("Host");
            if (d10 != null) {
                arrayList.add(new lp.a(lp.a.f30570i, d10));
            }
            arrayList.add(new lp.a(lp.a.f30569h, request.l().t()));
            int size = f10.size();
            for (int i10 = 0; i10 < size; i10++) {
                String name = f10.name(i10);
                Locale locale = Locale.US;
                i.e(locale, "Locale.US");
                Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = name.toLowerCase(locale);
                i.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!c.f30579g.contains(lowerCase) || (i.b(lowerCase, "te") && i.b(f10.value(i10), "trailers"))) {
                    arrayList.add(new lp.a(lowerCase, f10.value(i10)));
                }
            }
            return arrayList;
        }

        public final b0.a b(Headers headerBlock, Protocol protocol) {
            i.f(headerBlock, "headerBlock");
            i.f(protocol, "protocol");
            Headers.a aVar = new Headers.a();
            int size = headerBlock.size();
            k kVar = null;
            for (int i10 = 0; i10 < size; i10++) {
                String name = headerBlock.name(i10);
                String value = headerBlock.value(i10);
                if (i.b(name, ":status")) {
                    k.a aVar2 = k.f29676d;
                    kVar = aVar2.a("HTTP/1.1 " + value);
                } else if (!c.f30580h.contains(name)) {
                    aVar.d(name, value);
                }
            }
            if (kVar != null) {
                return new b0.a().p(protocol).g(kVar.f29678b).m(kVar.f29679c).k(aVar.f());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public c(y client, f connection, g chain, b http2Connection) {
        i.f(client, "client");
        i.f(connection, "connection");
        i.f(chain, "chain");
        i.f(http2Connection, "http2Connection");
        this.f30585d = connection;
        this.f30586e = chain;
        this.f30587f = http2Connection;
        List<Protocol> w10 = client.w();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.f30583b = !w10.contains(protocol) ? Protocol.HTTP_2 : protocol;
    }

    @Override // jp.d
    public void a() {
        okhttp3.internal.http2.d dVar = this.f30582a;
        i.d(dVar);
        dVar.n().close();
    }

    @Override // jp.d
    public void b(z request) {
        i.f(request, "request");
        if (this.f30582a == null) {
            this.f30582a = this.f30587f.I0(f30581i.a(request), request.a() != null);
            if (!this.f30584c) {
                okhttp3.internal.http2.d dVar = this.f30582a;
                i.d(dVar);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                dVar.v().g(this.f30586e.h(), timeUnit);
                okhttp3.internal.http2.d dVar2 = this.f30582a;
                i.d(dVar2);
                dVar2.E().g(this.f30586e.j(), timeUnit);
                return;
            }
            okhttp3.internal.http2.d dVar3 = this.f30582a;
            i.d(dVar3);
            dVar3.f(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
    }

    @Override // jp.d
    public t c(b0 response) {
        i.f(response, "response");
        okhttp3.internal.http2.d dVar = this.f30582a;
        i.d(dVar);
        return dVar.p();
    }

    @Override // jp.d
    public void cancel() {
        this.f30584c = true;
        okhttp3.internal.http2.d dVar = this.f30582a;
        if (dVar != null) {
            dVar.f(ErrorCode.CANCEL);
        }
    }

    @Override // jp.d
    public b0.a d(boolean z10) {
        okhttp3.internal.http2.d dVar = this.f30582a;
        i.d(dVar);
        b0.a b10 = f30581i.b(dVar.C(), this.f30583b);
        if (!z10 || b10.h() != 100) {
            return b10;
        }
        return null;
    }

    @Override // jp.d
    public f e() {
        return this.f30585d;
    }

    @Override // jp.d
    public void f() {
        this.f30587f.flush();
    }

    @Override // jp.d
    public long g(b0 response) {
        i.f(response, "response");
        if (!e.b(response)) {
            return 0L;
        }
        return gp.b.s(response);
    }

    @Override // jp.d
    public r h(z request, long j10) {
        i.f(request, "request");
        okhttp3.internal.http2.d dVar = this.f30582a;
        i.d(dVar);
        return dVar.n();
    }
}
