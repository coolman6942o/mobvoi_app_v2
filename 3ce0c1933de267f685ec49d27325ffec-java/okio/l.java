package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.i;
import rp.g;
import rp.h;
/* compiled from: InflaterSource.kt */
/* loaded from: classes3.dex */
public final class l implements t {

    /* renamed from: a  reason: collision with root package name */
    private int f32412a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f32413b;

    /* renamed from: c  reason: collision with root package name */
    private final e f32414c;

    /* renamed from: d  reason: collision with root package name */
    private final Inflater f32415d;

    public l(e source, Inflater inflater) {
        i.f(source, "source");
        i.f(inflater, "inflater");
        this.f32414c = source;
        this.f32415d = inflater;
    }

    private final void h() {
        int i10 = this.f32412a;
        if (i10 != 0) {
            int remaining = i10 - this.f32415d.getRemaining();
            this.f32412a -= remaining;
            this.f32414c.f(remaining);
        }
    }

    public final long c(c sink, long j10) throws IOException {
        i.f(sink, "sink");
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (!(!this.f32413b)) {
            throw new IllegalStateException("closed".toString());
        } else if (i10 == 0) {
            return 0L;
        } else {
            try {
                g m02 = sink.m0(1);
                d();
                int inflate = this.f32415d.inflate(m02.f33663a, m02.f33665c, (int) Math.min(j10, 8192 - m02.f33665c));
                h();
                if (inflate > 0) {
                    m02.f33665c += inflate;
                    long j11 = inflate;
                    sink.h0(sink.i0() + j11);
                    return j11;
                }
                if (m02.f33664b == m02.f33665c) {
                    sink.f32393a = m02.b();
                    h.b(m02);
                }
                return 0L;
            } catch (DataFormatException e10) {
                throw new IOException(e10);
            }
        }
    }

    @Override // okio.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f32413b) {
            this.f32415d.end();
            this.f32413b = true;
            this.f32414c.close();
        }
    }

    public final boolean d() throws IOException {
        if (!this.f32415d.needsInput()) {
            return false;
        }
        if (this.f32414c.B()) {
            return true;
        }
        g gVar = this.f32414c.b().f32393a;
        i.d(gVar);
        int i10 = gVar.f33665c;
        int i11 = gVar.f33664b;
        int i12 = i10 - i11;
        this.f32412a = i12;
        this.f32415d.setInput(gVar.f33663a, i11, i12);
        return false;
    }

    @Override // okio.t
    public long read(c sink, long j10) throws IOException {
        i.f(sink, "sink");
        do {
            long c10 = c(sink, j10);
            if (c10 > 0) {
                return c10;
            }
            if (this.f32415d.finished() || this.f32415d.needsDictionary()) {
                return -1L;
            }
        } while (!this.f32414c.B());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // okio.t
    public u timeout() {
        return this.f32414c.timeout();
    }
}
