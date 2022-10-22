package rp;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.i;
import okio.ByteString;
import okio.c;
import okio.d;
import okio.r;
import okio.t;
import okio.u;
/* compiled from: RealBufferedSink.kt */
/* loaded from: classes3.dex */
public final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public final c f33656a = new c();

    /* renamed from: b  reason: collision with root package name */
    public boolean f33657b;

    /* renamed from: c  reason: collision with root package name */
    public final r f33658c;

    public e(r sink) {
        i.f(sink, "sink");
        this.f33658c = sink;
    }

    @Override // okio.d
    public d C(int i10) {
        if (!this.f33657b) {
            this.f33656a.C(i10);
            return G();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.d
    public d C0(long j10) {
        if (!this.f33657b) {
            this.f33656a.C0(j10);
            return G();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.d
    public d G() {
        if (!this.f33657b) {
            long i10 = this.f33656a.i();
            if (i10 > 0) {
                this.f33658c.Z(this.f33656a, i10);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.d
    public d R(String string) {
        i.f(string, "string");
        if (!this.f33657b) {
            this.f33656a.R(string);
            return G();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.r
    public void Z(c source, long j10) {
        i.f(source, "source");
        if (!this.f33657b) {
            this.f33656a.Z(source, j10);
            G();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.d
    public d a0(String string, int i10, int i11) {
        i.f(string, "string");
        if (!this.f33657b) {
            this.f33656a.a0(string, i10, i11);
            return G();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.d
    public c b() {
        return this.f33656a;
    }

    @Override // okio.d
    public long b0(t source) {
        i.f(source, "source");
        long j10 = 0;
        while (true) {
            long read = source.read(this.f33656a, 8192);
            if (read == -1) {
                return j10;
            }
            j10 += read;
            G();
        }
    }

    public d c(int i10) {
        if (!this.f33657b) {
            this.f33656a.G0(i10);
            return G();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.d
    public d c0(long j10) {
        if (!this.f33657b) {
            this.f33656a.c0(j10);
            return G();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f33657b) {
            Throwable th2 = null;
            try {
                if (this.f33656a.i0() > 0) {
                    r rVar = this.f33658c;
                    c cVar = this.f33656a;
                    rVar.Z(cVar, cVar.i0());
                }
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.f33658c.close();
            } catch (Throwable th4) {
                th2 = th4;
                if (th2 == null) {
                }
            }
            this.f33657b = true;
            if (th2 != null) {
                throw th2;
            }
        }
    }

    @Override // okio.d
    public d e(byte[] source, int i10, int i11) {
        i.f(source, "source");
        if (!this.f33657b) {
            this.f33656a.e(source, i10, i11);
            return G();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.d, okio.r, java.io.Flushable
    public void flush() {
        if (!this.f33657b) {
            if (this.f33656a.i0() > 0) {
                r rVar = this.f33658c;
                c cVar = this.f33656a;
                rVar.Z(cVar, cVar.i0());
            }
            this.f33658c.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f33657b;
    }

    @Override // okio.d
    public d p(int i10) {
        if (!this.f33657b) {
            this.f33656a.p(i10);
            return G();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.d
    public d s0(byte[] source) {
        i.f(source, "source");
        if (!this.f33657b) {
            this.f33656a.s0(source);
            return G();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.d
    public d t(int i10) {
        if (!this.f33657b) {
            this.f33656a.t(i10);
            return G();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.r
    public u timeout() {
        return this.f33658c.timeout();
    }

    public String toString() {
        return "buffer(" + this.f33658c + ')';
    }

    @Override // okio.d
    public d v0(ByteString byteString) {
        i.f(byteString, "byteString");
        if (!this.f33657b) {
            this.f33656a.v0(byteString);
            return G();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        i.f(source, "source");
        if (!this.f33657b) {
            int write = this.f33656a.write(source);
            G();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }
}
