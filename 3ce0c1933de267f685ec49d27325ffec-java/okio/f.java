package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.jvm.internal.i;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import rp.c;
import rp.g;
import rp.h;
/* compiled from: DeflaterSink.kt */
/* loaded from: classes3.dex */
public final class f implements r {

    /* renamed from: a  reason: collision with root package name */
    private boolean f32397a;

    /* renamed from: b  reason: collision with root package name */
    private final d f32398b;

    /* renamed from: c  reason: collision with root package name */
    private final Deflater f32399c;

    public f(d sink, Deflater deflater) {
        i.f(sink, "sink");
        i.f(deflater, "deflater");
        this.f32398b = sink;
        this.f32399c = deflater;
    }

    @IgnoreJRERequirement
    private final void c(boolean z10) {
        g m02;
        int i10;
        c b10 = this.f32398b.b();
        while (true) {
            m02 = b10.m0(1);
            if (z10) {
                Deflater deflater = this.f32399c;
                byte[] bArr = m02.f33663a;
                int i11 = m02.f33665c;
                i10 = deflater.deflate(bArr, i11, 8192 - i11, 2);
            } else {
                Deflater deflater2 = this.f32399c;
                byte[] bArr2 = m02.f33663a;
                int i12 = m02.f33665c;
                i10 = deflater2.deflate(bArr2, i12, 8192 - i12);
            }
            if (i10 > 0) {
                m02.f33665c += i10;
                b10.h0(b10.i0() + i10);
                this.f32398b.G();
            } else if (this.f32399c.needsInput()) {
                break;
            }
        }
        if (m02.f33664b == m02.f33665c) {
            b10.f32393a = m02.b();
            h.b(m02);
        }
    }

    @Override // okio.r
    public void Z(c source, long j10) throws IOException {
        i.f(source, "source");
        c.b(source.i0(), 0L, j10);
        while (j10 > 0) {
            g gVar = source.f32393a;
            i.d(gVar);
            int min = (int) Math.min(j10, gVar.f33665c - gVar.f33664b);
            this.f32399c.setInput(gVar.f33663a, gVar.f33664b, min);
            c(false);
            long j11 = min;
            source.h0(source.i0() - j11);
            int i10 = gVar.f33664b + min;
            gVar.f33664b = i10;
            if (i10 == gVar.f33665c) {
                source.f32393a = gVar.b();
                h.b(gVar);
            }
            j10 -= j11;
        }
    }

    @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f32397a) {
            Throwable th2 = null;
            try {
                d();
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.f32399c.end();
            } catch (Throwable th4) {
                th2 = th4;
                if (th2 == null) {
                }
            }
            try {
                this.f32398b.close();
            } catch (Throwable th5) {
                th2 = th5;
                if (th2 == null) {
                }
            }
            this.f32397a = true;
            if (th2 != null) {
                throw th2;
            }
        }
    }

    public final void d() {
        this.f32399c.finish();
        c(false);
    }

    @Override // okio.r, java.io.Flushable
    public void flush() throws IOException {
        c(true);
        this.f32398b.flush();
    }

    @Override // okio.r
    public u timeout() {
        return this.f32398b.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f32398b + ')';
    }
}
