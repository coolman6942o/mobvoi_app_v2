package okhttp3.internal.http2;

import io.m;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.Headers;
import okio.e;
import okio.r;
import okio.t;
import okio.u;
/* compiled from: Http2Stream.kt */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private long f32140a;

    /* renamed from: b  reason: collision with root package name */
    private long f32141b;

    /* renamed from: c  reason: collision with root package name */
    private long f32142c;

    /* renamed from: d  reason: collision with root package name */
    private long f32143d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayDeque<Headers> f32144e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f32145f;

    /* renamed from: g  reason: collision with root package name */
    private final c f32146g;

    /* renamed from: h  reason: collision with root package name */
    private final b f32147h;

    /* renamed from: i  reason: collision with root package name */
    private final C0435d f32148i = new C0435d();

    /* renamed from: j  reason: collision with root package name */
    private final C0435d f32149j = new C0435d();

    /* renamed from: k  reason: collision with root package name */
    private ErrorCode f32150k;

    /* renamed from: l  reason: collision with root package name */
    private IOException f32151l;

    /* renamed from: m  reason: collision with root package name */
    private final int f32152m;

    /* renamed from: n  reason: collision with root package name */
    private final okhttp3.internal.http2.b f32153n;

    /* compiled from: Http2Stream.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: Http2Stream.kt */
    /* loaded from: classes3.dex */
    public final class b implements r {

        /* renamed from: a  reason: collision with root package name */
        private final okio.c f32154a = new okio.c();

        /* renamed from: b  reason: collision with root package name */
        private Headers f32155b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f32156c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f32157d;

        public b(boolean z10) {
            this.f32157d = z10;
        }

        private final void c(boolean z10) throws IOException {
            long min;
            boolean z11;
            synchronized (d.this) {
                d.this.s().r();
                while (d.this.r() >= d.this.q() && !this.f32157d && !this.f32156c && d.this.h() == null) {
                    d.this.D();
                }
                d.this.s().y();
                d.this.c();
                min = Math.min(d.this.q() - d.this.r(), this.f32154a.i0());
                d dVar = d.this;
                dVar.B(dVar.r() + min);
                z11 = z10 && min == this.f32154a.i0() && d.this.h() == null;
                m mVar = m.f28349a;
            }
            d.this.s().r();
            try {
                d.this.g().W0(d.this.j(), z11, this.f32154a, min);
            } finally {
                d.this.s().y();
            }
        }

        @Override // okio.r
        public void Z(okio.c source, long j10) throws IOException {
            i.f(source, "source");
            d dVar = d.this;
            if (!gp.b.f27632h || !Thread.holdsLock(dVar)) {
                this.f32154a.Z(source, j10);
                while (this.f32154a.i0() >= 16384) {
                    c(false);
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            i.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(dVar);
            throw new AssertionError(sb2.toString());
        }

        @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            d dVar = d.this;
            if (!gp.b.f27632h || !Thread.holdsLock(dVar)) {
                synchronized (d.this) {
                    if (!this.f32156c) {
                        boolean z10 = d.this.h() == null;
                        m mVar = m.f28349a;
                        if (!d.this.o().f32157d) {
                            boolean z11 = this.f32154a.i0() > 0;
                            if (this.f32155b != null) {
                                while (this.f32154a.i0() > 0) {
                                    c(false);
                                }
                                okhttp3.internal.http2.b g10 = d.this.g();
                                int j10 = d.this.j();
                                Headers headers = this.f32155b;
                                i.d(headers);
                                g10.X0(j10, z10, gp.b.K(headers));
                            } else if (z11) {
                                while (this.f32154a.i0() > 0) {
                                    c(true);
                                }
                            } else if (z10) {
                                d.this.g().W0(d.this.j(), true, null, 0L);
                            }
                        }
                        synchronized (d.this) {
                            this.f32156c = true;
                            m mVar2 = m.f28349a;
                        }
                        d.this.g().flush();
                        d.this.b();
                        return;
                    }
                    return;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            i.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(dVar);
            throw new AssertionError(sb2.toString());
        }

        public final boolean d() {
            return this.f32156c;
        }

        @Override // okio.r, java.io.Flushable
        public void flush() throws IOException {
            d dVar = d.this;
            if (!gp.b.f27632h || !Thread.holdsLock(dVar)) {
                synchronized (d.this) {
                    d.this.c();
                    m mVar = m.f28349a;
                }
                while (this.f32154a.i0() > 0) {
                    c(false);
                    d.this.g().flush();
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            i.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(dVar);
            throw new AssertionError(sb2.toString());
        }

        public final boolean h() {
            return this.f32157d;
        }

        @Override // okio.r
        public u timeout() {
            return d.this.s();
        }
    }

    /* compiled from: Http2Stream.kt */
    /* loaded from: classes3.dex */
    public final class c implements t {

        /* renamed from: a  reason: collision with root package name */
        private final okio.c f32159a = new okio.c();

        /* renamed from: b  reason: collision with root package name */
        private final okio.c f32160b = new okio.c();

        /* renamed from: c  reason: collision with root package name */
        private boolean f32161c;

        /* renamed from: d  reason: collision with root package name */
        private final long f32162d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f32163e;

        public c(long j10, boolean z10) {
            this.f32162d = j10;
            this.f32163e = z10;
        }

        private final void o(long j10) {
            d dVar = d.this;
            if (!gp.b.f27632h || !Thread.holdsLock(dVar)) {
                d.this.g().V0(j10);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            i.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(dVar);
            throw new AssertionError(sb2.toString());
        }

        public final boolean c() {
            return this.f32161c;
        }

        @Override // okio.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long i02;
            synchronized (d.this) {
                this.f32161c = true;
                i02 = this.f32160b.i0();
                this.f32160b.c();
                d dVar = d.this;
                if (dVar != null) {
                    dVar.notifyAll();
                    m mVar = m.f28349a;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
            }
            if (i02 > 0) {
                o(i02);
            }
            d.this.b();
        }

        public final boolean d() {
            return this.f32163e;
        }

        public final void h(e source, long j10) throws IOException {
            boolean z10;
            boolean z11;
            boolean z12;
            long j11;
            i.f(source, "source");
            d dVar = d.this;
            if (!gp.b.f27632h || !Thread.holdsLock(dVar)) {
                while (j10 > 0) {
                    synchronized (d.this) {
                        z10 = this.f32163e;
                        z11 = true;
                        z12 = this.f32160b.i0() + j10 > this.f32162d;
                        m mVar = m.f28349a;
                    }
                    if (z12) {
                        source.f(j10);
                        d.this.f(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z10) {
                        source.f(j10);
                        return;
                    } else {
                        long read = source.read(this.f32159a, j10);
                        if (read != -1) {
                            j10 -= read;
                            synchronized (d.this) {
                                if (this.f32161c) {
                                    j11 = this.f32159a.i0();
                                    this.f32159a.c();
                                } else {
                                    if (this.f32160b.i0() != 0) {
                                        z11 = false;
                                    }
                                    this.f32160b.b0(this.f32159a);
                                    if (z11) {
                                        d dVar2 = d.this;
                                        if (dVar2 != null) {
                                            dVar2.notifyAll();
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                                        }
                                    }
                                    j11 = 0;
                                }
                            }
                            if (j11 > 0) {
                                o(j11);
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            i.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(dVar);
            throw new AssertionError(sb2.toString());
        }

        public final void i(boolean z10) {
            this.f32163e = z10;
        }

        public final void n(Headers headers) {
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x00e0, code lost:
            throw new java.io.IOException("stream closed");
         */
        @Override // okio.t
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long read(okio.c sink, long j10) throws IOException {
            long j11;
            boolean z10;
            i.f(sink, "sink");
            long j12 = 0;
            if (j10 >= 0) {
                while (true) {
                    IOException iOException = null;
                    synchronized (d.this) {
                        d.this.m().r();
                        if (d.this.h() != null && (iOException = d.this.i()) == null) {
                            ErrorCode h10 = d.this.h();
                            i.d(h10);
                            iOException = new StreamResetException(h10);
                        }
                        if (this.f32161c) {
                            break;
                        }
                        if (this.f32160b.i0() > j12) {
                            okio.c cVar = this.f32160b;
                            j11 = cVar.read(sink, Math.min(j10, cVar.i0()));
                            d dVar = d.this;
                            dVar.A(dVar.l() + j11);
                            long l10 = d.this.l() - d.this.k();
                            if (iOException == null && l10 >= d.this.g().r0().c() / 2) {
                                d.this.g().b1(d.this.j(), l10);
                                d dVar2 = d.this;
                                dVar2.z(dVar2.l());
                            }
                        } else if (this.f32163e || iOException != null) {
                            j11 = -1;
                        } else {
                            d.this.D();
                            j11 = -1;
                            z10 = true;
                            d.this.m().y();
                            m mVar = m.f28349a;
                        }
                        z10 = false;
                        d.this.m().y();
                        m mVar2 = m.f28349a;
                    }
                    if (z10) {
                        j12 = 0;
                    } else if (j11 != -1) {
                        o(j11);
                        return j11;
                    } else if (iOException == null) {
                        return -1L;
                    } else {
                        i.d(iOException);
                        throw iOException;
                    }
                }
            } else {
                throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
            }
        }

        @Override // okio.t
        public u timeout() {
            return d.this.m();
        }
    }

    /* compiled from: Http2Stream.kt */
    /* renamed from: okhttp3.internal.http2.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public final class C0435d extends okio.a {
        public C0435d() {
        }

        @Override // okio.a
        protected IOException t(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.a
        protected void x() {
            d.this.f(ErrorCode.CANCEL);
            d.this.g().P0();
        }

        public final void y() throws IOException {
            if (s()) {
                throw t(null);
            }
        }
    }

    static {
        new a(null);
    }

    public d(int i10, okhttp3.internal.http2.b connection, boolean z10, boolean z11, Headers headers) {
        i.f(connection, "connection");
        this.f32152m = i10;
        this.f32153n = connection;
        this.f32143d = connection.t0().c();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.f32144e = arrayDeque;
        this.f32146g = new c(connection.r0().c(), z11);
        this.f32147h = new b(z10);
        if (headers != null) {
            if (!t()) {
                arrayDeque.add(headers);
                return;
            }
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
        } else if (!t()) {
            throw new IllegalStateException("remotely-initiated streams should have headers".toString());
        }
    }

    private final boolean e(ErrorCode errorCode, IOException iOException) {
        if (!gp.b.f27632h || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f32150k != null) {
                    return false;
                }
                if (this.f32146g.d() && this.f32147h.h()) {
                    return false;
                }
                this.f32150k = errorCode;
                this.f32151l = iOException;
                notifyAll();
                m mVar = m.f28349a;
                this.f32153n.O0(this.f32152m);
                return true;
            }
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

    public final void A(long j10) {
        this.f32140a = j10;
    }

    public final void B(long j10) {
        this.f32142c = j10;
    }

    public final synchronized Headers C() throws IOException {
        Headers removeFirst;
        this.f32148i.r();
        while (this.f32144e.isEmpty() && this.f32150k == null) {
            D();
        }
        this.f32148i.y();
        if (!this.f32144e.isEmpty()) {
            removeFirst = this.f32144e.removeFirst();
            i.e(removeFirst, "headersQueue.removeFirst()");
        } else {
            IOException iOException = this.f32151l;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.f32150k;
            i.d(errorCode);
            throw new StreamResetException(errorCode);
        }
        return removeFirst;
    }

    public final void D() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final u E() {
        return this.f32149j;
    }

    public final void a(long j10) {
        this.f32143d += j10;
        if (j10 > 0) {
            notifyAll();
        }
    }

    public final void b() throws IOException {
        boolean z10;
        boolean u10;
        if (!gp.b.f27632h || !Thread.holdsLock(this)) {
            synchronized (this) {
                z10 = !this.f32146g.d() && this.f32146g.c() && (this.f32147h.h() || this.f32147h.d());
                u10 = u();
                m mVar = m.f28349a;
            }
            if (z10) {
                d(ErrorCode.CANCEL, null);
            } else if (!u10) {
                this.f32153n.O0(this.f32152m);
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            i.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
    }

    public final void c() throws IOException {
        if (this.f32147h.d()) {
            throw new IOException("stream closed");
        } else if (this.f32147h.h()) {
            throw new IOException("stream finished");
        } else if (this.f32150k != null) {
            IOException iOException = this.f32151l;
            if (iOException == null) {
                ErrorCode errorCode = this.f32150k;
                i.d(errorCode);
                throw new StreamResetException(errorCode);
            }
        }
    }

    public final void d(ErrorCode rstStatusCode, IOException iOException) throws IOException {
        i.f(rstStatusCode, "rstStatusCode");
        if (e(rstStatusCode, iOException)) {
            this.f32153n.Z0(this.f32152m, rstStatusCode);
        }
    }

    public final void f(ErrorCode errorCode) {
        i.f(errorCode, "errorCode");
        if (e(errorCode, null)) {
            this.f32153n.a1(this.f32152m, errorCode);
        }
    }

    public final okhttp3.internal.http2.b g() {
        return this.f32153n;
    }

    public final synchronized ErrorCode h() {
        return this.f32150k;
    }

    public final IOException i() {
        return this.f32151l;
    }

    public final int j() {
        return this.f32152m;
    }

    public final long k() {
        return this.f32141b;
    }

    public final long l() {
        return this.f32140a;
    }

    public final C0435d m() {
        return this.f32148i;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0011 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:11:0x0011, B:15:0x0017, B:16:0x0022), top: B:19:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0017 A[Catch: all -> 0x0023, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:11:0x0011, B:15:0x0017, B:16:0x0022), top: B:19:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final r n() {
        boolean z10;
        synchronized (this) {
            if (!this.f32145f && !t()) {
                z10 = false;
                if (!z10) {
                    m mVar = m.f28349a;
                } else {
                    throw new IllegalStateException("reply before requesting the sink".toString());
                }
            }
            z10 = true;
            if (!z10) {
            }
        }
        return this.f32147h;
    }

    public final b o() {
        return this.f32147h;
    }

    public final c p() {
        return this.f32146g;
    }

    public final long q() {
        return this.f32143d;
    }

    public final long r() {
        return this.f32142c;
    }

    public final C0435d s() {
        return this.f32149j;
    }

    public final boolean t() {
        return this.f32153n.i0() == ((this.f32152m & 1) == 1);
    }

    public final synchronized boolean u() {
        if (this.f32150k != null) {
            return false;
        }
        if ((this.f32146g.d() || this.f32146g.c()) && (this.f32147h.h() || this.f32147h.d())) {
            if (this.f32145f) {
                return false;
            }
        }
        return true;
    }

    public final u v() {
        return this.f32148i;
    }

    public final void w(e source, int i10) throws IOException {
        i.f(source, "source");
        if (!gp.b.f27632h || !Thread.holdsLock(this)) {
            this.f32146g.h(source, i10);
            return;
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x0054 A[Catch: all -> 0x006d, TryCatch #0 {, blocks: (B:9:0x003d, B:13:0x0045, B:14:0x004b, B:16:0x0054, B:17:0x0059), top: B:24:0x003d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x(Headers headers, boolean z10) {
        boolean u10;
        i.f(headers, "headers");
        if (!gp.b.f27632h || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f32145f && z10) {
                    this.f32146g.n(headers);
                    if (z10) {
                        this.f32146g.i(true);
                    }
                    u10 = u();
                    notifyAll();
                    m mVar = m.f28349a;
                }
                this.f32145f = true;
                this.f32144e.add(headers);
                if (z10) {
                }
                u10 = u();
                notifyAll();
                m mVar2 = m.f28349a;
            }
            if (!u10) {
                this.f32153n.O0(this.f32152m);
                return;
            }
            return;
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

    public final synchronized void y(ErrorCode errorCode) {
        i.f(errorCode, "errorCode");
        if (this.f32150k == null) {
            this.f32150k = errorCode;
            notifyAll();
        }
    }

    public final void z(long j10) {
        this.f32141b = j10;
    }
}
