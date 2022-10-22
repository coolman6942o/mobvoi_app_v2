package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import jp.d;
import kotlin.jvm.internal.i;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.r;
import okhttp3.z;
import okio.g;
import okio.h;
import okio.n;
import okio.t;
/* compiled from: Exchange.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f31949a;

    /* renamed from: b  reason: collision with root package name */
    private final f f31950b;

    /* renamed from: c  reason: collision with root package name */
    private final e f31951c;

    /* renamed from: d  reason: collision with root package name */
    private final r f31952d;

    /* renamed from: e  reason: collision with root package name */
    private final d f31953e;

    /* renamed from: f  reason: collision with root package name */
    private final d f31954f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Exchange.kt */
    /* loaded from: classes3.dex */
    public final class a extends g {

        /* renamed from: b  reason: collision with root package name */
        private boolean f31955b;

        /* renamed from: c  reason: collision with root package name */
        private long f31956c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f31957d;

        /* renamed from: e  reason: collision with root package name */
        private final long f31958e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ c f31959f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, okio.r delegate, long j10) {
            super(delegate);
            i.f(delegate, "delegate");
            this.f31959f = cVar;
            this.f31958e = j10;
        }

        private final <E extends IOException> E c(E e10) {
            if (this.f31955b) {
                return e10;
            }
            this.f31955b = true;
            return (E) this.f31959f.a(this.f31956c, false, true, e10);
        }

        @Override // okio.g, okio.r
        public void Z(okio.c source, long j10) throws IOException {
            i.f(source, "source");
            if (!this.f31957d) {
                long j11 = this.f31958e;
                if (j11 == -1 || this.f31956c + j10 <= j11) {
                    try {
                        super.Z(source, j10);
                        this.f31956c += j10;
                    } catch (IOException e10) {
                        throw c(e10);
                    }
                } else {
                    throw new ProtocolException("expected " + this.f31958e + " bytes but received " + (this.f31956c + j10));
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }

        @Override // okio.g, okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f31957d) {
                this.f31957d = true;
                long j10 = this.f31958e;
                if (j10 == -1 || this.f31956c == j10) {
                    try {
                        super.close();
                        c(null);
                    } catch (IOException e10) {
                        throw c(e10);
                    }
                } else {
                    throw new ProtocolException("unexpected end of stream");
                }
            }
        }

        @Override // okio.g, okio.r, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e10) {
                throw c(e10);
            }
        }
    }

    /* compiled from: Exchange.kt */
    /* loaded from: classes3.dex */
    public final class b extends h {

        /* renamed from: a  reason: collision with root package name */
        private long f31960a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f31961b = true;

        /* renamed from: c  reason: collision with root package name */
        private boolean f31962c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f31963d;

        /* renamed from: e  reason: collision with root package name */
        private final long f31964e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ c f31965f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, t delegate, long j10) {
            super(delegate);
            i.f(delegate, "delegate");
            this.f31965f = cVar;
            this.f31964e = j10;
            if (j10 == 0) {
                c(null);
            }
        }

        public final <E extends IOException> E c(E e10) {
            if (this.f31962c) {
                return e10;
            }
            this.f31962c = true;
            if (e10 == null && this.f31961b) {
                this.f31961b = false;
                this.f31965f.i().w(this.f31965f.g());
            }
            return (E) this.f31965f.a(this.f31960a, true, false, e10);
        }

        @Override // okio.h, okio.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f31963d) {
                this.f31963d = true;
                try {
                    super.close();
                    c(null);
                } catch (IOException e10) {
                    throw c(e10);
                }
            }
        }

        @Override // okio.h, okio.t
        public long read(okio.c sink, long j10) throws IOException {
            i.f(sink, "sink");
            if (!this.f31963d) {
                try {
                    long read = delegate().read(sink, j10);
                    if (this.f31961b) {
                        this.f31961b = false;
                        this.f31965f.i().w(this.f31965f.g());
                    }
                    if (read == -1) {
                        c(null);
                        return -1L;
                    }
                    long j11 = this.f31960a + read;
                    long j12 = this.f31964e;
                    if (j12 != -1 && j11 > j12) {
                        throw new ProtocolException("expected " + this.f31964e + " bytes but received " + j11);
                    }
                    this.f31960a = j11;
                    if (j11 == j12) {
                        c(null);
                    }
                    return read;
                } catch (IOException e10) {
                    throw c(e10);
                }
            } else {
                throw new IllegalStateException("closed".toString());
            }
        }
    }

    public c(e call, r eventListener, d finder, d codec) {
        i.f(call, "call");
        i.f(eventListener, "eventListener");
        i.f(finder, "finder");
        i.f(codec, "codec");
        this.f31951c = call;
        this.f31952d = eventListener;
        this.f31953e = finder;
        this.f31954f = codec;
        this.f31950b = codec.e();
    }

    private final void s(IOException iOException) {
        this.f31953e.h(iOException);
        this.f31954f.e().H(this.f31951c, iOException);
    }

    public final <E extends IOException> E a(long j10, boolean z10, boolean z11, E e10) {
        if (e10 != null) {
            s(e10);
        }
        if (z11) {
            if (e10 != null) {
                this.f31952d.s(this.f31951c, e10);
            } else {
                this.f31952d.q(this.f31951c, j10);
            }
        }
        if (z10) {
            if (e10 != null) {
                this.f31952d.x(this.f31951c, e10);
            } else {
                this.f31952d.v(this.f31951c, j10);
            }
        }
        return (E) this.f31951c.s(this, z11, z10, e10);
    }

    public final void b() {
        this.f31954f.cancel();
    }

    public final okio.r c(z request, boolean z10) throws IOException {
        i.f(request, "request");
        this.f31949a = z10;
        a0 a10 = request.a();
        i.d(a10);
        long contentLength = a10.contentLength();
        this.f31952d.r(this.f31951c);
        return new a(this, this.f31954f.h(request, contentLength), contentLength);
    }

    public final void d() {
        this.f31954f.cancel();
        this.f31951c.s(this, true, true, null);
    }

    public final void e() throws IOException {
        try {
            this.f31954f.a();
        } catch (IOException e10) {
            this.f31952d.s(this.f31951c, e10);
            s(e10);
            throw e10;
        }
    }

    public final void f() throws IOException {
        try {
            this.f31954f.f();
        } catch (IOException e10) {
            this.f31952d.s(this.f31951c, e10);
            s(e10);
            throw e10;
        }
    }

    public final e g() {
        return this.f31951c;
    }

    public final f h() {
        return this.f31950b;
    }

    public final r i() {
        return this.f31952d;
    }

    public final d j() {
        return this.f31953e;
    }

    public final boolean k() {
        return !i.b(this.f31953e.d().l().h(), this.f31950b.A().a().l().h());
    }

    public final boolean l() {
        return this.f31949a;
    }

    public final void m() {
        this.f31954f.e().z();
    }

    public final void n() {
        this.f31951c.s(this, true, false, null);
    }

    public final c0 o(b0 response) throws IOException {
        i.f(response, "response");
        try {
            String w10 = b0.w(response, "Content-Type", null, 2, null);
            long g10 = this.f31954f.g(response);
            return new jp.h(w10, g10, n.d(new b(this, this.f31954f.c(response), g10)));
        } catch (IOException e10) {
            this.f31952d.x(this.f31951c, e10);
            s(e10);
            throw e10;
        }
    }

    public final b0.a p(boolean z10) throws IOException {
        try {
            b0.a d10 = this.f31954f.d(z10);
            if (d10 != null) {
                d10.l(this);
            }
            return d10;
        } catch (IOException e10) {
            this.f31952d.x(this.f31951c, e10);
            s(e10);
            throw e10;
        }
    }

    public final void q(b0 response) {
        i.f(response, "response");
        this.f31952d.y(this.f31951c, response);
    }

    public final void r() {
        this.f31952d.z(this.f31951c);
    }

    public final void t(z request) throws IOException {
        i.f(request, "request");
        try {
            this.f31952d.u(this.f31951c);
            this.f31954f.b(request);
            this.f31952d.t(this.f31951c, request);
        } catch (IOException e10) {
            this.f31952d.s(this.f31951c, e10);
            s(e10);
            throw e10;
        }
    }
}
