package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.jvm.internal.i;
import rp.f;
import rp.g;
/* compiled from: GzipSource.kt */
/* loaded from: classes3.dex */
public final class k implements t {

    /* renamed from: a  reason: collision with root package name */
    private byte f32407a;

    /* renamed from: b  reason: collision with root package name */
    private final f f32408b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f32409c;

    /* renamed from: d  reason: collision with root package name */
    private final l f32410d;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f32411e = new CRC32();

    public k(t source) {
        i.f(source, "source");
        f fVar = new f(source);
        this.f32408b = fVar;
        Inflater inflater = new Inflater(true);
        this.f32409c = inflater;
        this.f32410d = new l(fVar, inflater);
    }

    private final void c(String str, int i10, int i11) {
        if (i11 != i10) {
            String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i11), Integer.valueOf(i10)}, 3));
            i.e(format, "java.lang.String.format(this, *args)");
            throw new IOException(format);
        }
    }

    private final void d() throws IOException {
        this.f32408b.B0(10L);
        byte u10 = this.f32408b.f33659a.u(3L);
        boolean z10 = true;
        boolean z11 = ((u10 >> 1) & 1) == 1;
        if (z11) {
            i(this.f32408b.f33659a, 0L, 10L);
        }
        c("ID1ID2", 8075, this.f32408b.readShort());
        this.f32408b.f(8L);
        if (((u10 >> 2) & 1) == 1) {
            this.f32408b.B0(2L);
            if (z11) {
                i(this.f32408b.f33659a, 0L, 2L);
            }
            long Q = this.f32408b.f33659a.Q();
            this.f32408b.B0(Q);
            if (z11) {
                i(this.f32408b.f33659a, 0L, Q);
            }
            this.f32408b.f(Q);
        }
        if (((u10 >> 3) & 1) == 1) {
            long c10 = this.f32408b.c((byte) 0);
            if (c10 != -1) {
                if (z11) {
                    i(this.f32408b.f33659a, 0L, c10 + 1);
                }
                this.f32408b.f(c10 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((u10 >> 4) & 1) != 1) {
            z10 = false;
        }
        if (z10) {
            long c11 = this.f32408b.c((byte) 0);
            if (c11 != -1) {
                if (z11) {
                    i(this.f32408b.f33659a, 0L, c11 + 1);
                }
                this.f32408b.f(c11 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z11) {
            c("FHCRC", this.f32408b.o(), (short) this.f32411e.getValue());
            this.f32411e.reset();
        }
    }

    private final void h() throws IOException {
        c("CRC", this.f32408b.n(), (int) this.f32411e.getValue());
        c("ISIZE", this.f32408b.n(), (int) this.f32409c.getBytesWritten());
    }

    private final void i(c cVar, long j10, long j11) {
        int i10;
        g gVar = cVar.f32393a;
        i.d(gVar);
        while (true) {
            int i11 = gVar.f33665c;
            int i12 = gVar.f33664b;
            if (j10 >= i11 - i12) {
                j10 -= i11 - i12;
                gVar = gVar.f33668f;
                i.d(gVar);
            }
        }
        while (j11 > 0) {
            int min = (int) Math.min(gVar.f33665c - i10, j11);
            this.f32411e.update(gVar.f33663a, (int) (gVar.f33664b + j10), min);
            j11 -= min;
            gVar = gVar.f33668f;
            i.d(gVar);
            j10 = 0;
        }
    }

    @Override // okio.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f32410d.close();
    }

    @Override // okio.t
    public long read(c sink, long j10) throws IOException {
        i.f(sink, "sink");
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (i10 == 0) {
            return 0L;
        } else {
            if (this.f32407a == 0) {
                d();
                this.f32407a = (byte) 1;
            }
            if (this.f32407a == 1) {
                long i02 = sink.i0();
                long read = this.f32410d.read(sink, j10);
                if (read != -1) {
                    i(sink, i02, read);
                    return read;
                }
                this.f32407a = (byte) 2;
            }
            if (this.f32407a == 2) {
                h();
                this.f32407a = (byte) 3;
                if (!this.f32408b.B()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // okio.t
    public u timeout() {
        return this.f32408b.timeout();
    }
}
