package okhttp3;

import java.io.Closeable;
import java.util.List;
import jp.e;
import kotlin.collections.k;
import kotlin.jvm.internal.i;
import okhttp3.Headers;
import okhttp3.internal.connection.c;
/* compiled from: Response.kt */
/* loaded from: classes3.dex */
public final class b0 implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private d f31752a;

    /* renamed from: b  reason: collision with root package name */
    private final z f31753b;

    /* renamed from: c  reason: collision with root package name */
    private final Protocol f31754c;

    /* renamed from: d  reason: collision with root package name */
    private final String f31755d;

    /* renamed from: e  reason: collision with root package name */
    private final int f31756e;

    /* renamed from: f  reason: collision with root package name */
    private final t f31757f;

    /* renamed from: g  reason: collision with root package name */
    private final Headers f31758g;

    /* renamed from: h  reason: collision with root package name */
    private final c0 f31759h;

    /* renamed from: i  reason: collision with root package name */
    private final b0 f31760i;

    /* renamed from: j  reason: collision with root package name */
    private final b0 f31761j;

    /* renamed from: k  reason: collision with root package name */
    private final b0 f31762k;

    /* renamed from: l  reason: collision with root package name */
    private final long f31763l;

    /* renamed from: m  reason: collision with root package name */
    private final long f31764m;

    /* renamed from: n  reason: collision with root package name */
    private final c f31765n;

    public b0(z request, Protocol protocol, String message, int i10, t tVar, Headers headers, c0 c0Var, b0 b0Var, b0 b0Var2, b0 b0Var3, long j10, long j11, c cVar) {
        i.f(request, "request");
        i.f(protocol, "protocol");
        i.f(message, "message");
        i.f(headers, "headers");
        this.f31753b = request;
        this.f31754c = protocol;
        this.f31755d = message;
        this.f31756e = i10;
        this.f31757f = tVar;
        this.f31758g = headers;
        this.f31759h = c0Var;
        this.f31760i = b0Var;
        this.f31761j = b0Var2;
        this.f31762k = b0Var3;
        this.f31763l = j10;
        this.f31764m = j11;
        this.f31765n = cVar;
    }

    public static /* synthetic */ String w(b0 b0Var, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return b0Var.v(str, str2);
    }

    public final boolean E() {
        int i10 = this.f31756e;
        return 200 <= i10 && 299 >= i10;
    }

    public final String I() {
        return this.f31755d;
    }

    public final b0 O() {
        return this.f31760i;
    }

    public final a Q() {
        return new a(this);
    }

    public final b0 T() {
        return this.f31762k;
    }

    public final Protocol V() {
        return this.f31754c;
    }

    public final long W() {
        return this.f31764m;
    }

    public final c0 c() {
        return this.f31759h;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c0 c0Var = this.f31759h;
        if (c0Var != null) {
            c0Var.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
    }

    public final d d() {
        d dVar = this.f31752a;
        if (dVar != null) {
            return dVar;
        }
        d b10 = d.f31818o.b(this.f31758g);
        this.f31752a = b10;
        return b10;
    }

    public final z g0() {
        return this.f31753b;
    }

    public final b0 h() {
        return this.f31761j;
    }

    public final long h0() {
        return this.f31763l;
    }

    public final List<h> i() {
        String str;
        Headers headers = this.f31758g;
        int i10 = this.f31756e;
        if (i10 == 401) {
            str = "WWW-Authenticate";
        } else if (i10 != 407) {
            return k.g();
        } else {
            str = "Proxy-Authenticate";
        }
        return e.a(headers, str);
    }

    public final int n() {
        return this.f31756e;
    }

    public final c o() {
        return this.f31765n;
    }

    public final t q() {
        return this.f31757f;
    }

    public String toString() {
        return "Response{protocol=" + this.f31754c + ", code=" + this.f31756e + ", message=" + this.f31755d + ", url=" + this.f31753b.l() + '}';
    }

    public final String u(String str) {
        return w(this, str, null, 2, null);
    }

    public final String v(String name, String str) {
        i.f(name, "name");
        String str2 = this.f31758g.get(name);
        return str2 != null ? str2 : str;
    }

    public final Headers x() {
        return this.f31758g;
    }

    /* compiled from: Response.kt */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private z f31766a;

        /* renamed from: b  reason: collision with root package name */
        private Protocol f31767b;

        /* renamed from: c  reason: collision with root package name */
        private int f31768c;

        /* renamed from: d  reason: collision with root package name */
        private String f31769d;

        /* renamed from: e  reason: collision with root package name */
        private t f31770e;

        /* renamed from: f  reason: collision with root package name */
        private Headers.a f31771f;

        /* renamed from: g  reason: collision with root package name */
        private c0 f31772g;

        /* renamed from: h  reason: collision with root package name */
        private b0 f31773h;

        /* renamed from: i  reason: collision with root package name */
        private b0 f31774i;

        /* renamed from: j  reason: collision with root package name */
        private b0 f31775j;

        /* renamed from: k  reason: collision with root package name */
        private long f31776k;

        /* renamed from: l  reason: collision with root package name */
        private long f31777l;

        /* renamed from: m  reason: collision with root package name */
        private c f31778m;

        public a() {
            this.f31768c = -1;
            this.f31771f = new Headers.a();
        }

        private final void e(b0 b0Var) {
            if (b0Var != null) {
                if (!(b0Var.c() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
        }

        private final void f(String str, b0 b0Var) {
            if (b0Var != null) {
                boolean z10 = true;
                if (b0Var.c() == null) {
                    if (b0Var.O() == null) {
                        if (b0Var.h() == null) {
                            if (b0Var.T() != null) {
                                z10 = false;
                            }
                            if (!z10) {
                                throw new IllegalArgumentException((str + ".priorResponse != null").toString());
                            }
                            return;
                        }
                        throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                    }
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                throw new IllegalArgumentException((str + ".body != null").toString());
            }
        }

        public a a(String name, String value) {
            i.f(name, "name");
            i.f(value, "value");
            this.f31771f.b(name, value);
            return this;
        }

        public a b(c0 c0Var) {
            this.f31772g = c0Var;
            return this;
        }

        public b0 c() {
            int i10 = this.f31768c;
            if (i10 >= 0) {
                z zVar = this.f31766a;
                if (zVar != null) {
                    Protocol protocol = this.f31767b;
                    if (protocol != null) {
                        String str = this.f31769d;
                        if (str != null) {
                            return new b0(zVar, protocol, str, i10, this.f31770e, this.f31771f.f(), this.f31772g, this.f31773h, this.f31774i, this.f31775j, this.f31776k, this.f31777l, this.f31778m);
                        }
                        throw new IllegalStateException("message == null".toString());
                    }
                    throw new IllegalStateException("protocol == null".toString());
                }
                throw new IllegalStateException("request == null".toString());
            }
            throw new IllegalStateException(("code < 0: " + this.f31768c).toString());
        }

        public a d(b0 b0Var) {
            f("cacheResponse", b0Var);
            this.f31774i = b0Var;
            return this;
        }

        public a g(int i10) {
            this.f31768c = i10;
            return this;
        }

        public final int h() {
            return this.f31768c;
        }

        public a i(t tVar) {
            this.f31770e = tVar;
            return this;
        }

        public a j(String name, String value) {
            i.f(name, "name");
            i.f(value, "value");
            this.f31771f.j(name, value);
            return this;
        }

        public a k(Headers headers) {
            i.f(headers, "headers");
            this.f31771f = headers.newBuilder();
            return this;
        }

        public final void l(c deferredTrailers) {
            i.f(deferredTrailers, "deferredTrailers");
            this.f31778m = deferredTrailers;
        }

        public a m(String message) {
            i.f(message, "message");
            this.f31769d = message;
            return this;
        }

        public a n(b0 b0Var) {
            f("networkResponse", b0Var);
            this.f31773h = b0Var;
            return this;
        }

        public a o(b0 b0Var) {
            e(b0Var);
            this.f31775j = b0Var;
            return this;
        }

        public a p(Protocol protocol) {
            i.f(protocol, "protocol");
            this.f31767b = protocol;
            return this;
        }

        public a q(long j10) {
            this.f31777l = j10;
            return this;
        }

        public a r(String name) {
            i.f(name, "name");
            this.f31771f.i(name);
            return this;
        }

        public a s(z request) {
            i.f(request, "request");
            this.f31766a = request;
            return this;
        }

        public a t(long j10) {
            this.f31776k = j10;
            return this;
        }

        public a(b0 response) {
            i.f(response, "response");
            this.f31768c = -1;
            this.f31766a = response.g0();
            this.f31767b = response.V();
            this.f31768c = response.n();
            this.f31769d = response.I();
            this.f31770e = response.q();
            this.f31771f = response.x().newBuilder();
            this.f31772g = response.c();
            this.f31773h = response.O();
            this.f31774i = response.h();
            this.f31775j = response.T();
            this.f31776k = response.h0();
            this.f31777l = response.W();
            this.f31778m = response.o();
        }
    }
}
