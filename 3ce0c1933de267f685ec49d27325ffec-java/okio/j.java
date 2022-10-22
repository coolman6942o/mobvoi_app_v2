package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.jvm.internal.i;
import rp.e;
import rp.g;
/* compiled from: GzipSink.kt */
/* loaded from: classes3.dex */
public final class j implements r {

    /* renamed from: a  reason: collision with root package name */
    private final e f32402a;

    /* renamed from: b  reason: collision with root package name */
    private final Deflater f32403b;

    /* renamed from: c  reason: collision with root package name */
    private final f f32404c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f32405d;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f32406e = new CRC32();

    public j(r sink) {
        i.f(sink, "sink");
        e eVar = new e(sink);
        this.f32402a = eVar;
        Deflater deflater = new Deflater(-1, true);
        this.f32403b = deflater;
        this.f32404c = new f(eVar, deflater);
        c cVar = eVar.f33656a;
        cVar.p(8075);
        cVar.C(8);
        cVar.C(0);
        cVar.t(0);
        cVar.C(0);
        cVar.C(0);
    }

    private final void c(c cVar, long j10) {
        g gVar = cVar.f32393a;
        i.d(gVar);
        while (j10 > 0) {
            int min = (int) Math.min(j10, gVar.f33665c - gVar.f33664b);
            this.f32406e.update(gVar.f33663a, gVar.f33664b, min);
            j10 -= min;
            gVar = gVar.f33668f;
            i.d(gVar);
        }
    }

    private final void d() {
        this.f32402a.c((int) this.f32406e.getValue());
        this.f32402a.c((int) this.f32403b.getBytesRead());
    }

    @Override // okio.r
    public void Z(c source, long j10) throws IOException {
        i.f(source, "source");
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (i10 != 0) {
            c(source, j10);
            this.f32404c.Z(source, j10);
        }
    }

    @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f32405d) {
            Throwable th2 = null;
            try {
                this.f32404c.d();
                d();
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.f32403b.end();
            } catch (Throwable th4) {
                th2 = th4;
                if (th2 == null) {
                }
            }
            try {
                this.f32402a.close();
            } catch (Throwable th5) {
                th2 = th5;
                if (th2 == null) {
                }
            }
            this.f32405d = true;
            if (th2 != null) {
                throw th2;
            }
        }
    }

    @Override // okio.r, java.io.Flushable
    public void flush() throws IOException {
        this.f32404c.flush();
    }

    @Override // okio.r
    public u timeout() {
        return this.f32402a.timeout();
    }
}
