package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import lp.d;
import okhttp3.internal.http2.a;
import okio.ByteString;
import okio.e;
import okio.t;
import okio.u;
/* compiled from: Http2Reader.kt */
/* loaded from: classes3.dex */
public final class c implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f32128e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f32129f = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final b f32130a;

    /* renamed from: b  reason: collision with root package name */
    private final a.C0430a f32131b;

    /* renamed from: c  reason: collision with root package name */
    private final e f32132c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f32133d;

    /* compiled from: Http2Reader.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final Logger a() {
            return c.f32128e;
        }

        public final int b(int i10, int i11, int i12) throws IOException {
            if ((i11 & 8) != 0) {
                i10--;
            }
            if (i12 <= i10) {
                return i10 - i12;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i12 + " > remaining length " + i10);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: Http2Reader.kt */
    /* loaded from: classes3.dex */
    public static final class b implements t {

        /* renamed from: a  reason: collision with root package name */
        private int f32134a;

        /* renamed from: b  reason: collision with root package name */
        private int f32135b;

        /* renamed from: c  reason: collision with root package name */
        private int f32136c;

        /* renamed from: d  reason: collision with root package name */
        private int f32137d;

        /* renamed from: e  reason: collision with root package name */
        private int f32138e;

        /* renamed from: f  reason: collision with root package name */
        private final e f32139f;

        public b(e source) {
            i.f(source, "source");
            this.f32139f = source;
        }

        private final void d() throws IOException {
            int i10 = this.f32136c;
            int G = gp.b.G(this.f32139f);
            this.f32137d = G;
            this.f32134a = G;
            int b10 = gp.b.b(this.f32139f.readByte(), 255);
            this.f32135b = gp.b.b(this.f32139f.readByte(), 255);
            a aVar = c.f32129f;
            if (aVar.a().isLoggable(Level.FINE)) {
                aVar.a().fine(lp.b.f30578e.c(true, this.f32136c, this.f32134a, b10, this.f32135b));
            }
            int readInt = this.f32139f.readInt() & Integer.MAX_VALUE;
            this.f32136c = readInt;
            if (b10 != 9) {
                throw new IOException(b10 + " != TYPE_CONTINUATION");
            } else if (readInt != i10) {
                throw new IOException("TYPE_CONTINUATION streamId changed");
            }
        }

        public final int c() {
            return this.f32137d;
        }

        @Override // okio.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public final void h(int i10) {
            this.f32135b = i10;
        }

        public final void i(int i10) {
            this.f32137d = i10;
        }

        public final void n(int i10) {
            this.f32134a = i10;
        }

        public final void o(int i10) {
            this.f32138e = i10;
        }

        public final void q(int i10) {
            this.f32136c = i10;
        }

        @Override // okio.t
        public long read(okio.c sink, long j10) throws IOException {
            i.f(sink, "sink");
            while (true) {
                int i10 = this.f32137d;
                if (i10 == 0) {
                    this.f32139f.f(this.f32138e);
                    this.f32138e = 0;
                    if ((this.f32135b & 4) != 0) {
                        return -1L;
                    }
                    d();
                } else {
                    long read = this.f32139f.read(sink, Math.min(j10, i10));
                    if (read == -1) {
                        return -1L;
                    }
                    this.f32137d -= (int) read;
                    return read;
                }
            }
        }

        @Override // okio.t
        public u timeout() {
            return this.f32139f.timeout();
        }
    }

    /* compiled from: Http2Reader.kt */
    /* renamed from: okhttp3.internal.http2.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface AbstractC0434c {
        void a();

        void b(boolean z10, int i10, int i11, List<lp.a> list);

        void c(int i10, long j10);

        void d(boolean z10, d dVar);

        void e(boolean z10, int i10, e eVar, int i11) throws IOException;

        void f(boolean z10, int i10, int i11);

        void g(int i10, int i11, int i12, boolean z10);

        void h(int i10, ErrorCode errorCode);

        void i(int i10, int i11, List<lp.a> list) throws IOException;

        void j(int i10, ErrorCode errorCode, ByteString byteString);
    }

    static {
        Logger logger = Logger.getLogger(lp.b.class.getName());
        i.e(logger, "Logger.getLogger(Http2::class.java.name)");
        f32128e = logger;
    }

    public c(e source, boolean z10) {
        i.f(source, "source");
        this.f32132c = source;
        this.f32133d = z10;
        b bVar = new b(source);
        this.f32130a = bVar;
        this.f32131b = new a.C0430a(bVar, 4096, 0, 4, null);
    }

    private final void E(AbstractC0434c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i10 + " != 4");
        } else if (i12 != 0) {
            int readInt = this.f32132c.readInt();
            ErrorCode a10 = ErrorCode.Companion.a(readInt);
            if (a10 != null) {
                cVar.h(i12, a10);
                return;
            }
            throw new IOException("TYPE_RST_STREAM unexpected error code: " + readInt);
        } else {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
        throw new java.io.IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void I(AbstractC0434c cVar, int i10, int i11, int i12) throws IOException {
        vo.c k10;
        vo.a j10;
        if (i12 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        } else if ((i11 & 1) != 0) {
            if (i10 == 0) {
                cVar.a();
                return;
            }
            throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
        } else if (i10 % 6 == 0) {
            d dVar = new d();
            k10 = vo.f.k(0, i10);
            j10 = vo.f.j(k10, 6);
            int a10 = j10.a();
            int b10 = j10.b();
            int d10 = j10.d();
            if (d10 < 0 ? a10 >= b10 : a10 <= b10) {
                while (true) {
                    int c10 = gp.b.c(this.f32132c.readShort(), 65535);
                    int readInt = this.f32132c.readInt();
                    if (c10 != 2) {
                        if (c10 == 3) {
                            c10 = 4;
                        } else if (c10 != 4) {
                            if (c10 == 5 && (readInt < 16384 || readInt > 16777215)) {
                                break;
                            }
                        } else {
                            c10 = 7;
                            if (readInt < 0) {
                                throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                            }
                        }
                    } else if (!(readInt == 0 || readInt == 1)) {
                        throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                    }
                    dVar.h(c10, readInt);
                    if (a10 == b10) {
                        break;
                    }
                    a10 += d10;
                }
            }
            cVar.d(false, dVar);
        } else {
            throw new IOException("TYPE_SETTINGS length % 6 != 0: " + i10);
        }
    }

    private final void O(AbstractC0434c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 == 4) {
            long d10 = gp.b.d(this.f32132c.readInt(), 2147483647L);
            if (d10 != 0) {
                cVar.c(i12, d10);
                return;
            }
            throw new IOException("windowSizeIncrement was 0");
        }
        throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i10);
    }

    private final void i(AbstractC0434c cVar, int i10, int i11, int i12) throws IOException {
        if (i12 != 0) {
            int i13 = 0;
            boolean z10 = true;
            boolean z11 = (i11 & 1) != 0;
            if ((i11 & 32) == 0) {
                z10 = false;
            }
            if (!z10) {
                if ((i11 & 8) != 0) {
                    i13 = gp.b.b(this.f32132c.readByte(), 255);
                }
                cVar.e(z11, i12, this.f32132c, f32129f.b(i10, i11, i13));
                this.f32132c.f(i13);
                return;
            }
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
    }

    private final void n(AbstractC0434c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + i10);
        } else if (i12 == 0) {
            int readInt = this.f32132c.readInt();
            int readInt2 = this.f32132c.readInt();
            int i13 = i10 - 8;
            ErrorCode a10 = ErrorCode.Companion.a(readInt2);
            if (a10 != null) {
                ByteString byteString = ByteString.EMPTY;
                if (i13 > 0) {
                    byteString = this.f32132c.k(i13);
                }
                cVar.j(readInt, a10, byteString);
                return;
            }
            throw new IOException("TYPE_GOAWAY unexpected error code: " + readInt2);
        } else {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
    }

    private final List<lp.a> o(int i10, int i11, int i12, int i13) throws IOException {
        this.f32130a.i(i10);
        b bVar = this.f32130a;
        bVar.n(bVar.c());
        this.f32130a.o(i11);
        this.f32130a.h(i12);
        this.f32130a.q(i13);
        this.f32131b.k();
        return this.f32131b.e();
    }

    private final void q(AbstractC0434c cVar, int i10, int i11, int i12) throws IOException {
        if (i12 != 0) {
            int i13 = 0;
            boolean z10 = (i11 & 1) != 0;
            if ((i11 & 8) != 0) {
                i13 = gp.b.b(this.f32132c.readByte(), 255);
            }
            if ((i11 & 32) != 0) {
                v(cVar, i12);
                i10 -= 5;
            }
            cVar.b(z10, i12, -1, o(f32129f.b(i10, i11, i13), i13, i11, i12));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
    }

    private final void u(AbstractC0434c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 != 8) {
            throw new IOException("TYPE_PING length != 8: " + i10);
        } else if (i12 == 0) {
            int readInt = this.f32132c.readInt();
            int readInt2 = this.f32132c.readInt();
            boolean z10 = true;
            if ((i11 & 1) == 0) {
                z10 = false;
            }
            cVar.f(z10, readInt, readInt2);
        } else {
            throw new IOException("TYPE_PING streamId != 0");
        }
    }

    private final void v(AbstractC0434c cVar, int i10) throws IOException {
        int readInt = this.f32132c.readInt();
        cVar.g(i10, readInt & Integer.MAX_VALUE, gp.b.b(this.f32132c.readByte(), 255) + 1, (((int) 2147483648L) & readInt) != 0);
    }

    private final void w(AbstractC0434c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 != 5) {
            throw new IOException("TYPE_PRIORITY length: " + i10 + " != 5");
        } else if (i12 != 0) {
            v(cVar, i12);
        } else {
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
    }

    private final void x(AbstractC0434c cVar, int i10, int i11, int i12) throws IOException {
        if (i12 != 0) {
            int b10 = (i11 & 8) != 0 ? gp.b.b(this.f32132c.readByte(), 255) : 0;
            cVar.i(i12, this.f32132c.readInt() & Integer.MAX_VALUE, o(f32129f.b(i10 - 4, i11, b10), b10, i11, i12));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f32132c.close();
    }

    public final boolean d(boolean z10, AbstractC0434c handler) throws IOException {
        i.f(handler, "handler");
        try {
            this.f32132c.B0(9L);
            int G = gp.b.G(this.f32132c);
            if (G <= 16384) {
                int b10 = gp.b.b(this.f32132c.readByte(), 255);
                int b11 = gp.b.b(this.f32132c.readByte(), 255);
                int readInt = this.f32132c.readInt() & Integer.MAX_VALUE;
                Logger logger = f32128e;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(lp.b.f30578e.c(true, readInt, G, b10, b11));
                }
                if (!z10 || b10 == 4) {
                    switch (b10) {
                        case 0:
                            i(handler, G, b11, readInt);
                            return true;
                        case 1:
                            q(handler, G, b11, readInt);
                            return true;
                        case 2:
                            w(handler, G, b11, readInt);
                            return true;
                        case 3:
                            E(handler, G, b11, readInt);
                            return true;
                        case 4:
                            I(handler, G, b11, readInt);
                            return true;
                        case 5:
                            x(handler, G, b11, readInt);
                            return true;
                        case 6:
                            u(handler, G, b11, readInt);
                            return true;
                        case 7:
                            n(handler, G, b11, readInt);
                            return true;
                        case 8:
                            O(handler, G, b11, readInt);
                            return true;
                        default:
                            this.f32132c.f(G);
                            return true;
                    }
                } else {
                    throw new IOException("Expected a SETTINGS frame but was " + lp.b.f30578e.b(b10));
                }
            } else {
                throw new IOException("FRAME_SIZE_ERROR: " + G);
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void h(AbstractC0434c handler) throws IOException {
        i.f(handler, "handler");
        if (!this.f32133d) {
            e eVar = this.f32132c;
            ByteString byteString = lp.b.f30574a;
            ByteString k10 = eVar.k(byteString.size());
            Logger logger = f32128e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(gp.b.q("<< CONNECTION " + k10.hex(), new Object[0]));
            }
            if (!i.b(byteString, k10)) {
                throw new IOException("Expected a connection header but was " + k10.utf8());
            }
        } else if (!d(true, handler)) {
            throw new IOException("Required SETTINGS preface not received");
        }
    }
}
