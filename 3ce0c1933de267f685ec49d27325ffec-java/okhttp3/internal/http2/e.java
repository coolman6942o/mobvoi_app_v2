package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import lp.b;
import okhttp3.internal.http2.a;
import okio.c;
import okio.d;
/* compiled from: Http2Writer.kt */
/* loaded from: classes3.dex */
public final class e implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    private static final Logger f32166g = Logger.getLogger(b.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final c f32167a;

    /* renamed from: b  reason: collision with root package name */
    private int f32168b = 16384;

    /* renamed from: c  reason: collision with root package name */
    private boolean f32169c;

    /* renamed from: d  reason: collision with root package name */
    private final a.b f32170d;

    /* renamed from: e  reason: collision with root package name */
    private final d f32171e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f32172f;

    /* compiled from: Http2Writer.kt */
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
    }

    public e(d sink, boolean z10) {
        i.f(sink, "sink");
        this.f32171e = sink;
        this.f32172f = z10;
        c cVar = new c();
        this.f32167a = cVar;
        this.f32170d = new a.b(0, false, cVar, 3, null);
    }

    private final void O(int i10, long j10) throws IOException {
        while (j10 > 0) {
            long min = Math.min(this.f32168b, j10);
            j10 -= min;
            n(i10, (int) min, 9, j10 == 0 ? 4 : 0);
            this.f32171e.Z(this.f32167a, min);
        }
    }

    public final synchronized void E(lp.d settings) throws IOException {
        i.f(settings, "settings");
        if (!this.f32169c) {
            int i10 = 0;
            n(0, settings.i() * 6, 4, 0);
            while (i10 < 10) {
                if (settings.f(i10)) {
                    this.f32171e.p(i10 != 4 ? i10 != 7 ? i10 : 4 : 3);
                    this.f32171e.t(settings.a(i10));
                }
                i10++;
            }
            this.f32171e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void I(int i10, long j10) throws IOException {
        if (!this.f32169c) {
            if (j10 != 0 && j10 <= 2147483647L) {
                n(i10, 4, 8, 0);
                this.f32171e.t((int) j10);
                this.f32171e.flush();
            } else {
                throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j10).toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void c(lp.d peerSettings) throws IOException {
        i.f(peerSettings, "peerSettings");
        if (!this.f32169c) {
            this.f32168b = peerSettings.e(this.f32168b);
            if (peerSettings.b() != -1) {
                this.f32170d.e(peerSettings.b());
            }
            n(0, 0, 4, 1);
            this.f32171e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f32169c = true;
        this.f32171e.close();
    }

    public final synchronized void d() throws IOException {
        if (this.f32169c) {
            throw new IOException("closed");
        } else if (this.f32172f) {
            Logger logger = f32166g;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(gp.b.q(">> CONNECTION " + b.f30574a.hex(), new Object[0]));
            }
            this.f32171e.v0(b.f30574a);
            this.f32171e.flush();
        }
    }

    public final synchronized void flush() throws IOException {
        if (!this.f32169c) {
            this.f32171e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void h(boolean z10, int i10, c cVar, int i11) throws IOException {
        if (!this.f32169c) {
            i(i10, z10 ? 1 : 0, cVar, i11);
        } else {
            throw new IOException("closed");
        }
    }

    public final void i(int i10, int i11, c cVar, int i12) throws IOException {
        n(i10, i12, 0, i11);
        if (i12 > 0) {
            d dVar = this.f32171e;
            i.d(cVar);
            dVar.Z(cVar, i12);
        }
    }

    public final void n(int i10, int i11, int i12, int i13) throws IOException {
        Logger logger = f32166g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(b.f30578e.c(false, i10, i11, i12, i13));
        }
        boolean z10 = true;
        if (i11 <= this.f32168b) {
            if ((((int) 2147483648L) & i10) != 0) {
                z10 = false;
            }
            if (z10) {
                gp.b.V(this.f32171e, i11);
                this.f32171e.C(i12 & 255);
                this.f32171e.C(i13 & 255);
                this.f32171e.t(i10 & Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException(("reserved bit set: " + i10).toString());
        }
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f32168b + ": " + i11).toString());
    }

    public final synchronized void o(int i10, ErrorCode errorCode, byte[] debugData) throws IOException {
        i.f(errorCode, "errorCode");
        i.f(debugData, "debugData");
        if (!this.f32169c) {
            boolean z10 = false;
            if (errorCode.getHttpCode() != -1) {
                n(0, debugData.length + 8, 7, 0);
                this.f32171e.t(i10);
                this.f32171e.t(errorCode.getHttpCode());
                if (debugData.length == 0) {
                    z10 = true;
                }
                if (!z10) {
                    this.f32171e.s0(debugData);
                }
                this.f32171e.flush();
            } else {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void q(boolean z10, int i10, List<lp.a> headerBlock) throws IOException {
        i.f(headerBlock, "headerBlock");
        if (!this.f32169c) {
            this.f32170d.g(headerBlock);
            long i02 = this.f32167a.i0();
            long min = Math.min(this.f32168b, i02);
            int i11 = (i02 > min ? 1 : (i02 == min ? 0 : -1));
            int i12 = i11 == 0 ? 4 : 0;
            if (z10) {
                i12 |= 1;
            }
            n(i10, (int) min, 1, i12);
            this.f32171e.Z(this.f32167a, min);
            if (i11 > 0) {
                O(i10, i02 - min);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final int u() {
        return this.f32168b;
    }

    public final synchronized void v(boolean z10, int i10, int i11) throws IOException {
        if (!this.f32169c) {
            n(0, 8, 6, z10 ? 1 : 0);
            this.f32171e.t(i10);
            this.f32171e.t(i11);
            this.f32171e.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void w(int i10, int i11, List<lp.a> requestHeaders) throws IOException {
        i.f(requestHeaders, "requestHeaders");
        if (!this.f32169c) {
            this.f32170d.g(requestHeaders);
            long i02 = this.f32167a.i0();
            int min = (int) Math.min(this.f32168b - 4, i02);
            int i12 = min + 4;
            long j10 = min;
            int i13 = (i02 > j10 ? 1 : (i02 == j10 ? 0 : -1));
            n(i10, i12, 5, i13 == 0 ? 4 : 0);
            this.f32171e.t(i11 & Integer.MAX_VALUE);
            this.f32171e.Z(this.f32167a, j10);
            if (i13 > 0) {
                O(i10, i02 - j10);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void x(int i10, ErrorCode errorCode) throws IOException {
        i.f(errorCode, "errorCode");
        if (!this.f32169c) {
            if (errorCode.getHttpCode() != -1) {
                n(i10, 4, 3, 0);
                this.f32171e.t(errorCode.getHttpCode());
                this.f32171e.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }
}
