package rp;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.internal.i;
import kotlin.text.b;
import okio.ByteString;
import okio.c;
import okio.e;
import okio.r;
import okio.t;
import okio.u;
/* compiled from: RealBufferedSource.kt */
/* loaded from: classes3.dex */
public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    public final c f33659a = new c();

    /* renamed from: b  reason: collision with root package name */
    public boolean f33660b;

    /* renamed from: c  reason: collision with root package name */
    public final t f33661c;

    public f(t source) {
        i.f(source, "source");
        this.f33661c = source;
    }

    @Override // okio.e
    public long A(ByteString bytes) {
        i.f(bytes, "bytes");
        return h(bytes, 0L);
    }

    @Override // okio.e
    public boolean B() {
        if (!this.f33660b) {
            return this.f33659a.B() && this.f33661c.read(this.f33659a, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.e
    public void B0(long j10) {
        if (!request(j10)) {
            throw new EOFException();
        }
    }

    @Override // okio.e
    public long E0() {
        byte u10;
        int a10;
        int a11;
        B0(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!request(i11)) {
                break;
            }
            u10 = this.f33659a.u(i10);
            if ((u10 < ((byte) 48) || u10 > ((byte) 57)) && ((u10 < ((byte) 97) || u10 > ((byte) 102)) && (u10 < ((byte) 65) || u10 > ((byte) 70)))) {
                break;
            }
            i10 = i11;
        }
        if (i10 == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Expected leading [0-9a-fA-F] character but was 0x");
            a10 = b.a(16);
            a11 = b.a(a10);
            String num = Integer.toString(u10, a11);
            i.e(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb2.append(num);
            throw new NumberFormatException(sb2.toString());
        }
        return this.f33659a.E0();
    }

    @Override // okio.e
    public long F(ByteString targetBytes) {
        i.f(targetBytes, "targetBytes");
        return i(targetBytes, 0L);
    }

    @Override // okio.e
    public InputStream F0() {
        return new a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r4 == 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append("Expected leading [0-9] or '-' character but was 0x");
        r2 = kotlin.text.b.a(16);
        r2 = kotlin.text.b.a(r2);
        r2 = java.lang.Integer.toString(r8, r2);
        kotlin.jvm.internal.i.e(r2, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        r1.append(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0058, code lost:
        throw new java.lang.NumberFormatException(r1.toString());
     */
    @Override // okio.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long H() {
        B0(1L);
        long j10 = 0;
        while (true) {
            long j11 = j10 + 1;
            if (!request(j11)) {
                break;
            }
            byte u10 = this.f33659a.u(j10);
            if ((u10 < ((byte) 48) || u10 > ((byte) 57)) && !(j10 == 0 && u10 == ((byte) 45))) {
                break;
            }
            j10 = j11;
        }
        return this.f33659a.H();
    }

    @Override // okio.e
    public String J(long j10) {
        if (j10 >= 0) {
            long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
            byte b10 = (byte) 10;
            long d10 = d(b10, 0L, j11);
            if (d10 != -1) {
                return sp.a.c(this.f33659a, d10);
            }
            if (j11 < Long.MAX_VALUE && request(j11) && this.f33659a.u(j11 - 1) == ((byte) 13) && request(1 + j11) && this.f33659a.u(j11) == b10) {
                return sp.a.c(this.f33659a, j11);
            }
            c cVar = new c();
            c cVar2 = this.f33659a;
            cVar2.o(cVar, 0L, Math.min(32, cVar2.i0()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f33659a.i0(), j10) + " content=" + cVar.d0().hex() + "…");
        }
        throw new IllegalArgumentException(("limit < 0: " + j10).toString());
    }

    @Override // okio.e
    public String X(Charset charset) {
        i.f(charset, "charset");
        this.f33659a.b0(this.f33661c);
        return this.f33659a.X(charset);
    }

    @Override // okio.e, okio.d
    public c b() {
        return this.f33659a;
    }

    public long c(byte b10) {
        return d(b10, 0L, Long.MAX_VALUE);
    }

    @Override // okio.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f33660b) {
            this.f33660b = true;
            this.f33661c.close();
            this.f33659a.c();
        }
    }

    public long d(byte b10, long j10, long j11) {
        boolean z10 = true;
        if (!this.f33660b) {
            if (0 > j10 || j11 < j10) {
                z10 = false;
            }
            if (z10) {
                while (j10 < j11) {
                    long v10 = this.f33659a.v(b10, j10, j11);
                    if (v10 != -1) {
                        return v10;
                    }
                    long i02 = this.f33659a.i0();
                    if (i02 >= j11 || this.f33661c.read(this.f33659a, 8192) == -1) {
                        return -1L;
                    }
                    j10 = Math.max(j10, i02);
                }
                return -1L;
            }
            throw new IllegalArgumentException(("fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.e
    public ByteString d0() {
        this.f33659a.b0(this.f33661c);
        return this.f33659a.d0();
    }

    @Override // okio.e
    public int e0(d options) {
        i.f(options, "options");
        if (!this.f33660b) {
            while (true) {
                int d10 = sp.a.d(this.f33659a, options, true);
                if (d10 == -2) {
                    if (this.f33661c.read(this.f33659a, 8192) == -1) {
                        break;
                    }
                } else if (d10 != -1) {
                    this.f33659a.f(options.e()[d10].size());
                    return d10;
                }
            }
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.e
    public void f(long j10) {
        if (!this.f33660b) {
            while (j10 > 0) {
                if (this.f33659a.i0() == 0 && this.f33661c.read(this.f33659a, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j10, this.f33659a.i0());
                this.f33659a.f(min);
                j10 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public long h(ByteString bytes, long j10) {
        i.f(bytes, "bytes");
        if (!this.f33660b) {
            while (true) {
                long w10 = this.f33659a.w(bytes, j10);
                if (w10 != -1) {
                    return w10;
                }
                long i02 = this.f33659a.i0();
                if (this.f33661c.read(this.f33659a, 8192) == -1) {
                    return -1L;
                }
                j10 = Math.max(j10, (i02 - bytes.size()) + 1);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public long i(ByteString targetBytes, long j10) {
        i.f(targetBytes, "targetBytes");
        if (!this.f33660b) {
            while (true) {
                long x10 = this.f33659a.x(targetBytes, j10);
                if (x10 != -1) {
                    return x10;
                }
                long i02 = this.f33659a.i0();
                if (this.f33661c.read(this.f33659a, 8192) == -1) {
                    return -1L;
                }
                j10 = Math.max(j10, i02);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f33660b;
    }

    @Override // okio.e
    public ByteString k(long j10) {
        B0(j10);
        return this.f33659a.k(j10);
    }

    public int n() {
        B0(4L);
        return this.f33659a.O();
    }

    @Override // okio.e
    public String n0() {
        return J(Long.MAX_VALUE);
    }

    public short o() {
        B0(2L);
        return this.f33659a.Q();
    }

    @Override // okio.e
    public byte[] p0(long j10) {
        B0(j10);
        return this.f33659a.p0(j10);
    }

    @Override // okio.t
    public long read(c sink, long j10) {
        i.f(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (!(!this.f33660b)) {
            throw new IllegalStateException("closed".toString());
        } else if (this.f33659a.i0() == 0 && this.f33661c.read(this.f33659a, 8192) == -1) {
            return -1L;
        } else {
            return this.f33659a.read(sink, Math.min(j10, this.f33659a.i0()));
        }
    }

    @Override // okio.e
    public byte readByte() {
        B0(1L);
        return this.f33659a.readByte();
    }

    @Override // okio.e
    public int readInt() {
        B0(4L);
        return this.f33659a.readInt();
    }

    @Override // okio.e
    public short readShort() {
        B0(2L);
        return this.f33659a.readShort();
    }

    @Override // okio.e
    public boolean request(long j10) {
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (!this.f33660b) {
            while (this.f33659a.i0() < j10) {
                if (this.f33661c.read(this.f33659a, 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    @Override // okio.t
    public u timeout() {
        return this.f33661c.timeout();
    }

    public String toString() {
        return "buffer(" + this.f33661c + ')';
    }

    @Override // okio.e
    public long y0(r sink) {
        i.f(sink, "sink");
        long j10 = 0;
        while (this.f33661c.read(this.f33659a, 8192) != -1) {
            long i10 = this.f33659a.i();
            if (i10 > 0) {
                j10 += i10;
                sink.Z(this.f33659a, i10);
            }
        }
        if (this.f33659a.i0() <= 0) {
            return j10;
        }
        long i02 = j10 + this.f33659a.i0();
        c cVar = this.f33659a;
        sink.Z(cVar, cVar.i0());
        return i02;
    }

    @Override // okio.e
    public byte[] z() {
        this.f33659a.b0(this.f33661c);
        return this.f33659a.z();
    }

    /* compiled from: RealBufferedSource.kt */
    /* loaded from: classes3.dex */
    public static final class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() {
            f fVar = f.this;
            if (!fVar.f33660b) {
                return (int) Math.min(fVar.f33659a.i0(), Integer.MAX_VALUE);
            }
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            f.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            f fVar = f.this;
            if (!fVar.f33660b) {
                if (fVar.f33659a.i0() == 0) {
                    f fVar2 = f.this;
                    if (fVar2.f33661c.read(fVar2.f33659a, 8192) == -1) {
                        return -1;
                    }
                }
                return f.this.f33659a.readByte() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return f.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] data, int i10, int i11) {
            i.f(data, "data");
            if (!f.this.f33660b) {
                c.b(data.length, i10, i11);
                if (f.this.f33659a.i0() == 0) {
                    f fVar = f.this;
                    if (fVar.f33661c.read(fVar.f33659a, 8192) == -1) {
                        return -1;
                    }
                }
                return f.this.f33659a.read(data, i10, i11);
            }
            throw new IOException("closed");
        }
    }

    @Override // okio.e
    public int read(byte[] sink, int i10, int i11) {
        i.f(sink, "sink");
        long j10 = i11;
        c.b(sink.length, i10, j10);
        if (this.f33659a.i0() == 0 && this.f33661c.read(this.f33659a, 8192) == -1) {
            return -1;
        }
        return this.f33659a.read(sink, i10, (int) Math.min(j10, this.f33659a.i0()));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        i.f(sink, "sink");
        if (this.f33659a.i0() == 0 && this.f33661c.read(this.f33659a, 8192) == -1) {
            return -1;
        }
        return this.f33659a.read(sink);
    }
}
