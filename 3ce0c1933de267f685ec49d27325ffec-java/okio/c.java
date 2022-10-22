package okio;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Objects;
import kotlin.collections.e;
import kotlin.jvm.internal.i;
import kotlin.text.d;
import rp.g;
import rp.h;
/* compiled from: Buffer.kt */
/* loaded from: classes3.dex */
public final class c implements e, d, Cloneable, ByteChannel {

    /* renamed from: a  reason: collision with root package name */
    public g f32393a;

    /* renamed from: b  reason: collision with root package name */
    private long f32394b;

    /* compiled from: Buffer.kt */
    /* loaded from: classes3.dex */
    public static final class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return c.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            c.this.C(i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] data, int i10, int i11) {
            i.f(data, "data");
            c.this.e(data, i10, i11);
        }
    }

    @Override // okio.e
    public long A(ByteString bytes) throws IOException {
        i.f(bytes, "bytes");
        return w(bytes, 0L);
    }

    /* renamed from: A0 */
    public c t(int i10) {
        g m02 = m0(4);
        byte[] bArr = m02.f33663a;
        int i11 = m02.f33665c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >>> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >>> 8) & 255);
        bArr[i14] = (byte) (i10 & 255);
        m02.f33665c = i14 + 1;
        h0(i0() + 4);
        return this;
    }

    @Override // okio.e
    public boolean B() {
        return this.f32394b == 0;
    }

    @Override // okio.e
    public void B0(long j10) throws EOFException {
        if (this.f32394b < j10) {
            throw new EOFException();
        }
    }

    public OutputStream E() {
        return new b();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ae A[EDGE_INSN: B:41:0x00ae->B:36:0x00ae ?: BREAK  , SYNTHETIC] */
    @Override // okio.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long E0() throws EOFException {
        int i10;
        if (i0() != 0) {
            int i11 = 0;
            boolean z10 = false;
            long j10 = 0;
            do {
                g gVar = this.f32393a;
                i.d(gVar);
                byte[] bArr = gVar.f33663a;
                int i12 = gVar.f33664b;
                int i13 = gVar.f33665c;
                while (i12 < i13) {
                    byte b10 = bArr[i12];
                    byte b11 = (byte) 48;
                    if (b10 < b11 || b10 > ((byte) 57)) {
                        byte b12 = (byte) 97;
                        if ((b10 >= b12 && b10 <= ((byte) 102)) || (b10 >= (b12 = (byte) 65) && b10 <= ((byte) 70))) {
                            i10 = (b10 - b12) + 10;
                        } else if (i11 != 0) {
                            z10 = true;
                            if (i12 != i13) {
                                this.f32393a = gVar.b();
                                h.b(gVar);
                            } else {
                                gVar.f33664b = i12;
                            }
                            if (!z10) {
                                break;
                            }
                        } else {
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + rp.c.e(b10));
                        }
                    } else {
                        i10 = b10 - b11;
                    }
                    if (((-1152921504606846976L) & j10) == 0) {
                        j10 = (j10 << 4) | i10;
                        i12++;
                        i11++;
                    } else {
                        c u02 = new c().c0(j10).C(b10);
                        throw new NumberFormatException("Number too large: " + u02.V());
                    }
                }
                if (i12 != i13) {
                }
                if (!z10) {
                }
            } while (this.f32393a != null);
            h0(i0() - i11);
            return j10;
        }
        throw new EOFException();
    }

    @Override // okio.e
    public long F(ByteString targetBytes) {
        i.f(targetBytes, "targetBytes");
        return x(targetBytes, 0L);
    }

    @Override // okio.e
    public InputStream F0() {
        return new a();
    }

    public c G0(int i10) {
        return t(rp.c.c(i10));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1 A[EDGE_INSN: B:48:0x00c1->B:40:0x00c1 ?: BREAK  , SYNTHETIC] */
    @Override // okio.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long H() throws EOFException {
        g gVar;
        boolean z10;
        long j10 = 0;
        if (i0() != 0) {
            long j11 = -7;
            int i10 = 0;
            boolean z11 = false;
            boolean z12 = false;
            do {
                g gVar2 = this.f32393a;
                i.d(gVar2);
                byte[] bArr = gVar2.f33663a;
                int i11 = gVar2.f33664b;
                int i12 = gVar2.f33665c;
                while (i11 < i12) {
                    byte b10 = bArr[i11];
                    byte b11 = (byte) 48;
                    if (b10 < b11 || b10 > ((byte) 57)) {
                        z10 = z12;
                        gVar = gVar2;
                        if (b10 == ((byte) 45) && i10 == 0) {
                            j11--;
                            z11 = true;
                        } else if (i10 != 0) {
                            z12 = true;
                            if (i11 != i12) {
                                this.f32393a = gVar.b();
                                h.b(gVar);
                            } else {
                                gVar.f33664b = i11;
                            }
                            if (!z12) {
                                break;
                            }
                        } else {
                            throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + rp.c.e(b10));
                        }
                    } else {
                        int i13 = b11 - b10;
                        int i14 = (j10 > (-922337203685477580L) ? 1 : (j10 == (-922337203685477580L) ? 0 : -1));
                        if (i14 >= 0) {
                            z10 = z12;
                            gVar = gVar2;
                            if (i14 != 0 || i13 >= j11) {
                                j10 = (j10 * 10) + i13;
                            }
                        }
                        c u02 = new c().C0(j10).C(b10);
                        if (!z11) {
                            u02.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + u02.V());
                    }
                    i11++;
                    i10++;
                    z12 = z10;
                    gVar2 = gVar;
                }
                gVar = gVar2;
                if (i11 != i12) {
                }
                if (!z12) {
                }
            } while (this.f32393a != null);
            h0(i0() - i10);
            return z11 ? j10 : -j10;
        }
        throw new EOFException();
    }

    /* renamed from: H0 */
    public c p(int i10) {
        g m02 = m0(2);
        byte[] bArr = m02.f33663a;
        int i11 = m02.f33665c;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i12] = (byte) (i10 & 255);
        m02.f33665c = i12 + 1;
        h0(i0() + 2);
        return this;
    }

    public void I(byte[] sink) throws EOFException {
        i.f(sink, "sink");
        int i10 = 0;
        while (i10 < sink.length) {
            int read = read(sink, i10, sink.length - i10);
            if (read != -1) {
                i10 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public c I0(String string, int i10, int i11, Charset charset) {
        i.f(string, "string");
        i.f(charset, "charset");
        boolean z10 = true;
        if (i10 >= 0) {
            if (i11 >= i10) {
                if (i11 > string.length()) {
                    z10 = false;
                }
                if (!z10) {
                    throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + string.length()).toString());
                } else if (i.b(charset, d.f30092a)) {
                    return a0(string, i10, i11);
                } else {
                    String substring = string.substring(i10, i11);
                    i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
                    byte[] bytes = substring.getBytes(charset);
                    i.e(bytes, "(this as java.lang.String).getBytes(charset)");
                    return e(bytes, 0, bytes.length);
                }
            } else {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
        }
    }

    @Override // okio.e
    public String J(long j10) throws EOFException {
        if (j10 >= 0) {
            long j11 = Long.MAX_VALUE;
            if (j10 != Long.MAX_VALUE) {
                j11 = j10 + 1;
            }
            byte b10 = (byte) 10;
            long v10 = v(b10, 0L, j11);
            if (v10 != -1) {
                return sp.a.c(this, v10);
            }
            if (j11 < i0() && u(j11 - 1) == ((byte) 13) && u(j11) == b10) {
                return sp.a.c(this, j11);
            }
            c cVar = new c();
            o(cVar, 0L, Math.min(32, i0()));
            throw new EOFException("\\n not found: limit=" + Math.min(i0(), j10) + " content=" + cVar.d0().hex() + (char) 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j10).toString());
    }

    public c J0(String string, Charset charset) {
        i.f(string, "string");
        i.f(charset, "charset");
        return I0(string, 0, string.length(), charset);
    }

    /* renamed from: K0 */
    public c R(String string) {
        i.f(string, "string");
        return a0(string, 0, string.length());
    }

    /* renamed from: L0 */
    public c a0(String string, int i10, int i11) {
        i.f(string, "string");
        if (i10 >= 0) {
            if (i11 >= i10) {
                if (i11 <= string.length()) {
                    while (i10 < i11) {
                        char charAt = string.charAt(i10);
                        if (charAt < 128) {
                            g m02 = m0(1);
                            byte[] bArr = m02.f33663a;
                            int i12 = m02.f33665c - i10;
                            int min = Math.min(i11, 8192 - i12);
                            int i13 = i10 + 1;
                            bArr[i10 + i12] = (byte) charAt;
                            while (i13 < min) {
                                char charAt2 = string.charAt(i13);
                                if (charAt2 >= 128) {
                                    break;
                                }
                                i13++;
                                bArr[i13 + i12] = (byte) charAt2;
                            }
                            int i14 = m02.f33665c;
                            int i15 = (i12 + i13) - i14;
                            m02.f33665c = i14 + i15;
                            h0(i0() + i15);
                            i10 = i13;
                        } else {
                            if (charAt < 2048) {
                                g m03 = m0(2);
                                byte[] bArr2 = m03.f33663a;
                                int i16 = m03.f33665c;
                                bArr2[i16] = (byte) ((charAt >> 6) | 192);
                                bArr2[i16 + 1] = (byte) ((charAt & '?') | 128);
                                m03.f33665c = i16 + 2;
                                h0(i0() + 2);
                            } else if (charAt < 55296 || charAt > 57343) {
                                g m04 = m0(3);
                                byte[] bArr3 = m04.f33663a;
                                int i17 = m04.f33665c;
                                bArr3[i17] = (byte) ((charAt >> '\f') | 224);
                                bArr3[i17 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                                bArr3[i17 + 2] = (byte) ((charAt & '?') | 128);
                                m04.f33665c = i17 + 3;
                                h0(i0() + 3);
                            } else {
                                int i18 = i10 + 1;
                                char charAt3 = i18 < i11 ? string.charAt(i18) : (char) 0;
                                if (charAt > 56319 || 56320 > charAt3 || 57343 < charAt3) {
                                    C(63);
                                    i10 = i18;
                                } else {
                                    int i19 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + WXMediaMessage.THUMB_LENGTH_LIMIT;
                                    g m05 = m0(4);
                                    byte[] bArr4 = m05.f33663a;
                                    int i20 = m05.f33665c;
                                    bArr4[i20] = (byte) ((i19 >> 18) | 240);
                                    bArr4[i20 + 1] = (byte) (((i19 >> 12) & 63) | 128);
                                    bArr4[i20 + 2] = (byte) (((i19 >> 6) & 63) | 128);
                                    bArr4[i20 + 3] = (byte) ((i19 & 63) | 128);
                                    m05.f33665c = i20 + 4;
                                    h0(i0() + 4);
                                    i10 += 2;
                                }
                            }
                            i10++;
                        }
                    }
                    return this;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + string.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
    }

    public c M0(int i10) {
        if (i10 < 128) {
            C(i10);
        } else if (i10 < 2048) {
            g m02 = m0(2);
            byte[] bArr = m02.f33663a;
            int i11 = m02.f33665c;
            bArr[i11] = (byte) ((i10 >> 6) | 192);
            bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
            m02.f33665c = i11 + 2;
            h0(i0() + 2);
        } else if (55296 <= i10 && 57343 >= i10) {
            C(63);
        } else if (i10 < 65536) {
            g m03 = m0(3);
            byte[] bArr2 = m03.f33663a;
            int i12 = m03.f33665c;
            bArr2[i12] = (byte) ((i10 >> 12) | 224);
            bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | 128);
            bArr2[i12 + 2] = (byte) ((i10 & 63) | 128);
            m03.f33665c = i12 + 3;
            h0(i0() + 3);
        } else if (i10 <= 1114111) {
            g m04 = m0(4);
            byte[] bArr3 = m04.f33663a;
            int i13 = m04.f33665c;
            bArr3[i13] = (byte) ((i10 >> 18) | 240);
            bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | 128);
            bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | 128);
            bArr3[i13 + 3] = (byte) ((i10 & 63) | 128);
            m04.f33665c = i13 + 4;
            h0(i0() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + rp.c.f(i10));
        }
        return this;
    }

    public int O() throws EOFException {
        return rp.c.c(readInt());
    }

    public short Q() throws EOFException {
        return rp.c.d(readShort());
    }

    public String T(long j10, Charset charset) throws EOFException {
        i.f(charset, "charset");
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (!(i10 >= 0 && j10 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        } else if (this.f32394b < j10) {
            throw new EOFException();
        } else if (i10 == 0) {
            return "";
        } else {
            g gVar = this.f32393a;
            i.d(gVar);
            int i11 = gVar.f33664b;
            if (i11 + j10 > gVar.f33665c) {
                return new String(p0(j10), charset);
            }
            int i12 = (int) j10;
            String str = new String(gVar.f33663a, i11, i12, charset);
            int i13 = gVar.f33664b + i12;
            gVar.f33664b = i13;
            this.f32394b -= j10;
            if (i13 == gVar.f33665c) {
                this.f32393a = gVar.b();
                h.b(gVar);
            }
            return str;
        }
    }

    public String V() {
        return T(this.f32394b, d.f30092a);
    }

    public String W(long j10) throws EOFException {
        return T(j10, d.f30092a);
    }

    @Override // okio.e
    public String X(Charset charset) {
        i.f(charset, "charset");
        return T(this.f32394b, charset);
    }

    @Override // okio.r
    public void Z(c source, long j10) {
        g gVar;
        g gVar2;
        i.f(source, "source");
        if (source != this) {
            rp.c.b(source.i0(), 0L, j10);
            while (j10 > 0) {
                g gVar3 = source.f32393a;
                i.d(gVar3);
                int i10 = gVar3.f33665c;
                i.d(source.f32393a);
                if (j10 < i10 - gVar.f33664b) {
                    g gVar4 = this.f32393a;
                    if (gVar4 != null) {
                        i.d(gVar4);
                        gVar2 = gVar4.f33669g;
                    } else {
                        gVar2 = null;
                    }
                    if (gVar2 != null && gVar2.f33667e) {
                        if ((gVar2.f33665c + j10) - (gVar2.f33666d ? 0 : gVar2.f33664b) <= 8192) {
                            g gVar5 = source.f32393a;
                            i.d(gVar5);
                            gVar5.f(gVar2, (int) j10);
                            source.h0(source.i0() - j10);
                            h0(i0() + j10);
                            return;
                        }
                    }
                    g gVar6 = source.f32393a;
                    i.d(gVar6);
                    source.f32393a = gVar6.e((int) j10);
                }
                g gVar7 = source.f32393a;
                i.d(gVar7);
                long j11 = gVar7.f33665c - gVar7.f33664b;
                source.f32393a = gVar7.b();
                g gVar8 = this.f32393a;
                if (gVar8 == null) {
                    this.f32393a = gVar7;
                    gVar7.f33669g = gVar7;
                    gVar7.f33668f = gVar7;
                } else {
                    i.d(gVar8);
                    g gVar9 = gVar8.f33669g;
                    i.d(gVar9);
                    gVar9.c(gVar7).a();
                }
                source.h0(source.i0() - j11);
                h0(i0() + j11);
                j10 -= j11;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    @Override // okio.e, okio.d
    public c b() {
        return this;
    }

    @Override // okio.d
    public long b0(t source) throws IOException {
        i.f(source, "source");
        long j10 = 0;
        while (true) {
            long read = source.read(this, 8192);
            if (read == -1) {
                return j10;
            }
            j10 += read;
        }
    }

    public final void c() {
        f(i0());
    }

    @Override // okio.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* renamed from: d */
    public c clone() {
        return n();
    }

    @Override // okio.e
    public ByteString d0() {
        return k(i0());
    }

    @Override // okio.e
    public int e0(rp.d options) {
        i.f(options, "options");
        int e10 = sp.a.e(this, options, false, 2, null);
        if (e10 == -1) {
            return -1;
        }
        f(options.e()[e10].size());
        return e10;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (i0() != cVar.i0()) {
                return false;
            }
            if (i0() != 0) {
                g gVar = this.f32393a;
                i.d(gVar);
                g gVar2 = cVar.f32393a;
                i.d(gVar2);
                int i10 = gVar.f33664b;
                int i11 = gVar2.f33664b;
                long j10 = 0;
                while (j10 < i0()) {
                    long min = Math.min(gVar.f33665c - i10, gVar2.f33665c - i11);
                    for (long j11 = 0; j11 < min; j11++) {
                        i10++;
                        i11++;
                        if (gVar.f33663a[i10] != gVar2.f33663a[i11]) {
                            return false;
                        }
                    }
                    if (i10 == gVar.f33665c) {
                        gVar = gVar.f33668f;
                        i.d(gVar);
                        i10 = gVar.f33664b;
                    }
                    if (i11 == gVar2.f33665c) {
                        gVar2 = gVar2.f33668f;
                        i.d(gVar2);
                        i11 = gVar2.f33664b;
                    }
                    j10 += min;
                }
            }
        }
        return true;
    }

    @Override // okio.e
    public void f(long j10) throws EOFException {
        while (j10 > 0) {
            g gVar = this.f32393a;
            if (gVar != null) {
                int min = (int) Math.min(j10, gVar.f33665c - gVar.f33664b);
                long j11 = min;
                h0(i0() - j11);
                j10 -= j11;
                int i10 = gVar.f33664b + min;
                gVar.f33664b = i10;
                if (i10 == gVar.f33665c) {
                    this.f32393a = gVar.b();
                    h.b(gVar);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // okio.d, okio.r, java.io.Flushable
    public void flush() {
    }

    public int g0() throws EOFException {
        int i10;
        int i11;
        int i12;
        if (i0() != 0) {
            byte u10 = u(0L);
            if ((u10 & 128) == 0) {
                i12 = u10 & Byte.MAX_VALUE;
                i10 = 0;
                i11 = 1;
            } else if ((u10 & 224) == 192) {
                i12 = u10 & 31;
                i11 = 2;
                i10 = 128;
            } else if ((u10 & 240) == 224) {
                i12 = u10 & 15;
                i11 = 3;
                i10 = 2048;
            } else if ((u10 & 248) == 240) {
                i12 = u10 & 7;
                i11 = 4;
                i10 = WXMediaMessage.THUMB_LENGTH_LIMIT;
            } else {
                f(1L);
                return 65533;
            }
            long j10 = i11;
            if (i0() >= j10) {
                for (int i13 = 1; i13 < i11; i13++) {
                    long j11 = i13;
                    byte u11 = u(j11);
                    if ((u11 & 192) == 128) {
                        i12 = (i12 << 6) | (u11 & 63);
                    } else {
                        f(j11);
                        return 65533;
                    }
                }
                f(j10);
                if (i12 > 1114111) {
                    return 65533;
                }
                if ((55296 <= i12 && 57343 >= i12) || i12 < i10) {
                    return 65533;
                }
                return i12;
            }
            throw new EOFException("size < " + i11 + ": " + i0() + " (to read code point prefixed 0x" + rp.c.e(u10) + ')');
        }
        throw new EOFException();
    }

    public final void h0(long j10) {
        this.f32394b = j10;
    }

    public int hashCode() {
        g gVar = this.f32393a;
        if (gVar == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = gVar.f33665c;
            for (int i12 = gVar.f33664b; i12 < i11; i12++) {
                i10 = (i10 * 31) + gVar.f33663a[i12];
            }
            gVar = gVar.f33668f;
            i.d(gVar);
        } while (gVar != this.f32393a);
        return i10;
    }

    public final long i() {
        long i02 = i0();
        if (i02 == 0) {
            return 0L;
        }
        g gVar = this.f32393a;
        i.d(gVar);
        g gVar2 = gVar.f33669g;
        i.d(gVar2);
        int i10 = gVar2.f33665c;
        if (i10 < 8192 && gVar2.f33667e) {
            i02 -= i10 - gVar2.f33664b;
        }
        return i02;
    }

    public final long i0() {
        return this.f32394b;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final ByteString j0() {
        if (i0() <= ((long) Integer.MAX_VALUE)) {
            return k0((int) i0());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + i0()).toString());
    }

    @Override // okio.e
    public ByteString k(long j10) throws EOFException {
        if (!(j10 >= 0 && j10 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        } else if (i0() < j10) {
            throw new EOFException();
        } else if (j10 < 4096) {
            return new ByteString(p0(j10));
        } else {
            ByteString k02 = k0((int) j10);
            f(j10);
            return k02;
        }
    }

    public final ByteString k0(int i10) {
        if (i10 == 0) {
            return ByteString.EMPTY;
        }
        rp.c.b(i0(), 0L, i10);
        g gVar = this.f32393a;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            i.d(gVar);
            int i14 = gVar.f33665c;
            int i15 = gVar.f33664b;
            if (i14 != i15) {
                i12 += i14 - i15;
                i13++;
                gVar = gVar.f33668f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i13];
        int[] iArr = new int[i13 * 2];
        g gVar2 = this.f32393a;
        int i16 = 0;
        while (i11 < i10) {
            i.d(gVar2);
            bArr[i16] = gVar2.f33663a;
            i11 += gVar2.f33665c - gVar2.f33664b;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = gVar2.f33664b;
            gVar2.f33666d = true;
            i16++;
            gVar2 = gVar2.f33668f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    public final g m0(int i10) {
        boolean z10 = true;
        if (i10 < 1 || i10 > 8192) {
            z10 = false;
        }
        if (z10) {
            g gVar = this.f32393a;
            if (gVar == null) {
                g c10 = h.c();
                this.f32393a = c10;
                c10.f33669g = c10;
                c10.f33668f = c10;
                return c10;
            }
            i.d(gVar);
            g gVar2 = gVar.f33669g;
            i.d(gVar2);
            return (gVar2.f33665c + i10 > 8192 || !gVar2.f33667e) ? gVar2.c(h.c()) : gVar2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    public final c n() {
        c cVar = new c();
        if (i0() != 0) {
            g gVar = this.f32393a;
            i.d(gVar);
            g d10 = gVar.d();
            cVar.f32393a = d10;
            d10.f33669g = d10;
            d10.f33668f = d10;
            for (g gVar2 = gVar.f33668f; gVar2 != gVar; gVar2 = gVar2.f33668f) {
                g gVar3 = d10.f33669g;
                i.d(gVar3);
                i.d(gVar2);
                gVar3.c(gVar2.d());
            }
            cVar.h0(i0());
        }
        return cVar;
    }

    @Override // okio.e
    public String n0() throws EOFException {
        return J(Long.MAX_VALUE);
    }

    public final c o(c out, long j10, long j11) {
        i.f(out, "out");
        rp.c.b(i0(), j10, j11);
        if (j11 != 0) {
            out.h0(out.i0() + j11);
            g gVar = this.f32393a;
            while (true) {
                i.d(gVar);
                int i10 = gVar.f33665c;
                int i11 = gVar.f33664b;
                if (j10 >= i10 - i11) {
                    j10 -= i10 - i11;
                    gVar = gVar.f33668f;
                }
            }
            while (j11 > 0) {
                i.d(gVar);
                g d10 = gVar.d();
                int i12 = d10.f33664b + ((int) j10);
                d10.f33664b = i12;
                d10.f33665c = Math.min(i12 + ((int) j11), d10.f33665c);
                g gVar2 = out.f32393a;
                if (gVar2 == null) {
                    d10.f33669g = d10;
                    d10.f33668f = d10;
                    out.f32393a = d10;
                } else {
                    i.d(gVar2);
                    g gVar3 = gVar2.f33669g;
                    i.d(gVar3);
                    gVar3.c(d10);
                }
                j11 -= d10.f33665c - d10.f33664b;
                gVar = gVar.f33668f;
                j10 = 0;
            }
        }
        return this;
    }

    /* renamed from: o0 */
    public c v0(ByteString byteString) {
        i.f(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @Override // okio.e
    public byte[] p0(long j10) throws EOFException {
        if (!(j10 >= 0 && j10 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        } else if (i0() >= j10) {
            byte[] bArr = new byte[(int) j10];
            I(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    /* renamed from: q */
    public c G() {
        return this;
    }

    /* renamed from: r0 */
    public c s0(byte[] source) {
        i.f(source, "source");
        return e(source, 0, source.length);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) throws IOException {
        i.f(sink, "sink");
        g gVar = this.f32393a;
        if (gVar == null) {
            return -1;
        }
        int min = Math.min(sink.remaining(), gVar.f33665c - gVar.f33664b);
        sink.put(gVar.f33663a, gVar.f33664b, min);
        int i10 = gVar.f33664b + min;
        gVar.f33664b = i10;
        this.f32394b -= min;
        if (i10 == gVar.f33665c) {
            this.f32393a = gVar.b();
            h.b(gVar);
        }
        return min;
    }

    @Override // okio.e
    public byte readByte() throws EOFException {
        if (i0() != 0) {
            g gVar = this.f32393a;
            i.d(gVar);
            int i10 = gVar.f33664b;
            int i11 = gVar.f33665c;
            int i12 = i10 + 1;
            byte b10 = gVar.f33663a[i10];
            h0(i0() - 1);
            if (i12 == i11) {
                this.f32393a = gVar.b();
                h.b(gVar);
            } else {
                gVar.f33664b = i12;
            }
            return b10;
        }
        throw new EOFException();
    }

    @Override // okio.e
    public int readInt() throws EOFException {
        if (i0() >= 4) {
            g gVar = this.f32393a;
            i.d(gVar);
            int i10 = gVar.f33664b;
            int i11 = gVar.f33665c;
            if (i11 - i10 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = gVar.f33663a;
            int i12 = i10 + 1;
            int i13 = i12 + 1;
            int i14 = ((bArr[i10] & 255) << 24) | ((bArr[i12] & 255) << 16);
            int i15 = i13 + 1;
            int i16 = i14 | ((bArr[i13] & 255) << 8);
            int i17 = i15 + 1;
            int i18 = i16 | (bArr[i15] & 255);
            h0(i0() - 4);
            if (i17 == i11) {
                this.f32393a = gVar.b();
                h.b(gVar);
            } else {
                gVar.f33664b = i17;
            }
            return i18;
        }
        throw new EOFException();
    }

    @Override // okio.e
    public short readShort() throws EOFException {
        if (i0() >= 2) {
            g gVar = this.f32393a;
            i.d(gVar);
            int i10 = gVar.f33664b;
            int i11 = gVar.f33665c;
            if (i11 - i10 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = gVar.f33663a;
            int i12 = i10 + 1;
            int i13 = i12 + 1;
            int i14 = ((bArr[i10] & 255) << 8) | (bArr[i12] & 255);
            h0(i0() - 2);
            if (i13 == i11) {
                this.f32393a = gVar.b();
                h.b(gVar);
            } else {
                gVar.f33664b = i13;
            }
            return (short) i14;
        }
        throw new EOFException();
    }

    @Override // okio.e
    public boolean request(long j10) {
        return this.f32394b >= j10;
    }

    /* renamed from: t0 */
    public c e(byte[] source, int i10, int i11) {
        i.f(source, "source");
        long j10 = i11;
        rp.c.b(source.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            g m02 = m0(1);
            int min = Math.min(i12 - i10, 8192 - m02.f33665c);
            int i13 = i10 + min;
            e.c(source, m02.f33663a, m02.f33665c, i10, i13);
            m02.f33665c += min;
            i10 = i13;
        }
        h0(i0() + j10);
        return this;
    }

    @Override // okio.t
    public u timeout() {
        return u.f32422d;
    }

    public String toString() {
        return j0().toString();
    }

    public final byte u(long j10) {
        rp.c.b(i0(), j10, 1L);
        g gVar = this.f32393a;
        if (gVar == null) {
            i.d(null);
            throw null;
        } else if (i0() - j10 < j10) {
            long i02 = i0();
            while (i02 > j10) {
                gVar = gVar.f33669g;
                i.d(gVar);
                i02 -= gVar.f33665c - gVar.f33664b;
            }
            i.d(gVar);
            return gVar.f33663a[(int) ((gVar.f33664b + j10) - i02)];
        } else {
            long j11 = 0;
            while (true) {
                long j12 = (gVar.f33665c - gVar.f33664b) + j11;
                if (j12 > j10) {
                    i.d(gVar);
                    return gVar.f33663a[(int) ((gVar.f33664b + j10) - j11)];
                }
                gVar = gVar.f33668f;
                i.d(gVar);
                j11 = j12;
            }
        }
    }

    /* renamed from: u0 */
    public c C(int i10) {
        g m02 = m0(1);
        byte[] bArr = m02.f33663a;
        int i11 = m02.f33665c;
        m02.f33665c = i11 + 1;
        bArr[i11] = (byte) i10;
        h0(i0() + 1);
        return this;
    }

    public long v(byte b10, long j10, long j11) {
        g gVar;
        int i10;
        long j12 = 0;
        if (0 <= j10 && j11 >= j10) {
            if (j11 > i0()) {
                j11 = i0();
            }
            if (j10 == j11 || (gVar = this.f32393a) == null) {
                return -1L;
            }
            if (i0() - j10 < j10) {
                j12 = i0();
                while (j12 > j10) {
                    gVar = gVar.f33669g;
                    i.d(gVar);
                    j12 -= gVar.f33665c - gVar.f33664b;
                }
                while (j12 < j11) {
                    byte[] bArr = gVar.f33663a;
                    int min = (int) Math.min(gVar.f33665c, (gVar.f33664b + j11) - j12);
                    i10 = (int) ((gVar.f33664b + j10) - j12);
                    while (i10 < min) {
                        if (bArr[i10] != b10) {
                            i10++;
                        }
                    }
                    j12 += gVar.f33665c - gVar.f33664b;
                    gVar = gVar.f33668f;
                    i.d(gVar);
                    j10 = j12;
                }
                return -1L;
            }
            while (true) {
                long j13 = (gVar.f33665c - gVar.f33664b) + j12;
                if (j13 > j10) {
                    break;
                }
                gVar = gVar.f33668f;
                i.d(gVar);
                j12 = j13;
            }
            while (j12 < j11) {
                byte[] bArr2 = gVar.f33663a;
                int min2 = (int) Math.min(gVar.f33665c, (gVar.f33664b + j11) - j12);
                i10 = (int) ((gVar.f33664b + j10) - j12);
                while (i10 < min2) {
                    if (bArr2[i10] != b10) {
                        i10++;
                    }
                }
                j12 += gVar.f33665c - gVar.f33664b;
                gVar = gVar.f33668f;
                i.d(gVar);
                j10 = j12;
            }
            return -1L;
            return (i10 - gVar.f33664b) + j12;
        }
        throw new IllegalArgumentException(("size=" + i0() + " fromIndex=" + j10 + " toIndex=" + j11).toString());
    }

    public long w(ByteString bytes, long j10) throws IOException {
        long j11 = j10;
        i.f(bytes, "bytes");
        if (bytes.size() > 0) {
            long j12 = 0;
            if (j11 >= 0) {
                g gVar = this.f32393a;
                if (gVar != null) {
                    if (i0() - j11 < j11) {
                        long i02 = i0();
                        while (i02 > j11) {
                            gVar = gVar.f33669g;
                            i.d(gVar);
                            i02 -= gVar.f33665c - gVar.f33664b;
                        }
                        byte[] internalArray$okio = bytes.internalArray$okio();
                        byte b10 = internalArray$okio[0];
                        int size = bytes.size();
                        long i03 = (i0() - size) + 1;
                        while (i02 < i03) {
                            byte[] bArr = gVar.f33663a;
                            long j13 = i02;
                            int min = (int) Math.min(gVar.f33665c, (gVar.f33664b + i03) - i02);
                            for (int i10 = (int) ((gVar.f33664b + j11) - j13); i10 < min; i10++) {
                                if (bArr[i10] == b10 && sp.a.b(gVar, i10 + 1, internalArray$okio, 1, size)) {
                                    return (i10 - gVar.f33664b) + j13;
                                }
                            }
                            i02 = j13 + (gVar.f33665c - gVar.f33664b);
                            gVar = gVar.f33668f;
                            i.d(gVar);
                            j11 = i02;
                        }
                    } else {
                        while (true) {
                            long j14 = (gVar.f33665c - gVar.f33664b) + j12;
                            if (j14 > j11) {
                                break;
                            }
                            gVar = gVar.f33668f;
                            i.d(gVar);
                            j12 = j14;
                        }
                        byte[] internalArray$okio2 = bytes.internalArray$okio();
                        byte b11 = internalArray$okio2[0];
                        int size2 = bytes.size();
                        long i04 = (i0() - size2) + 1;
                        while (j12 < i04) {
                            byte[] bArr2 = gVar.f33663a;
                            i04 = i04;
                            int min2 = (int) Math.min(gVar.f33665c, (gVar.f33664b + i04) - j12);
                            for (int i11 = (int) ((gVar.f33664b + j11) - j12); i11 < min2; i11++) {
                                if (bArr2[i11] == b11 && sp.a.b(gVar, i11 + 1, internalArray$okio2, 1, size2)) {
                                    return (i11 - gVar.f33664b) + j12;
                                }
                            }
                            j12 += gVar.f33665c - gVar.f33664b;
                            gVar = gVar.f33668f;
                            i.d(gVar);
                            j11 = j12;
                        }
                    }
                }
                return -1L;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j11).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f2 A[LOOP:0: B:69:0x00ee->B:71:0x00f2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0104  */
    /* renamed from: w0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c C0(long j10) {
        int i10;
        int i11 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (i11 == 0) {
            return C(48);
        }
        boolean z10 = false;
        int i12 = 1;
        if (i11 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return R("-9223372036854775808");
            }
            z10 = true;
        }
        if (j10 < 100000000) {
            if (j10 >= 10000) {
                i10 = j10 < 1000000 ? j10 < 100000 ? 5 : 6 : j10 < 10000000 ? 7 : 8;
            } else if (j10 < 100) {
                if (j10 >= 10) {
                    i12 = 2;
                }
                if (z10) {
                    i12++;
                }
                g m02 = m0(i12);
                byte[] bArr = m02.f33663a;
                int i13 = m02.f33665c + i12;
                while (j10 != 0) {
                    long j11 = 10;
                    i13--;
                    bArr[i13] = sp.a.a()[(int) (j10 % j11)];
                    j10 /= j11;
                }
                if (z10) {
                    bArr[i13 - 1] = (byte) 45;
                }
                m02.f33665c += i12;
                h0(i0() + i12);
                return this;
            } else {
                i10 = j10 < 1000 ? 3 : 4;
            }
            i12 = i10;
            if (z10) {
            }
            g m022 = m0(i12);
            byte[] bArr2 = m022.f33663a;
            int i132 = m022.f33665c + i12;
            while (j10 != 0) {
            }
            if (z10) {
            }
            m022.f33665c += i12;
            h0(i0() + i12);
            return this;
        } else if (j10 >= 1000000000000L) {
            if (j10 >= 1000000000000000L) {
                i12 = j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
            } else if (j10 < 10000000000000L) {
                i12 = 13;
            } else {
                i10 = j10 < 100000000000000L ? 14 : 15;
                i12 = i10;
            }
            if (z10) {
            }
            g m0222 = m0(i12);
            byte[] bArr22 = m0222.f33663a;
            int i1322 = m0222.f33665c + i12;
            while (j10 != 0) {
            }
            if (z10) {
            }
            m0222.f33665c += i12;
            h0(i0() + i12);
            return this;
        } else if (j10 < 10000000000L) {
            i12 = j10 < 1000000000 ? 9 : 10;
            if (z10) {
            }
            g m02222 = m0(i12);
            byte[] bArr222 = m02222.f33663a;
            int i13222 = m02222.f33665c + i12;
            while (j10 != 0) {
            }
            if (z10) {
            }
            m02222.f33665c += i12;
            h0(i0() + i12);
            return this;
        } else {
            i10 = j10 < 100000000000L ? 11 : 12;
            i12 = i10;
            if (z10) {
            }
            g m022222 = m0(i12);
            byte[] bArr2222 = m022222.f33663a;
            int i132222 = m022222.f33665c + i12;
            while (j10 != 0) {
            }
            if (z10) {
            }
            m022222.f33665c += i12;
            h0(i0() + i12);
            return this;
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) throws IOException {
        i.f(source, "source");
        int remaining = source.remaining();
        int i10 = remaining;
        while (i10 > 0) {
            g m02 = m0(1);
            int min = Math.min(i10, 8192 - m02.f33665c);
            source.get(m02.f33663a, m02.f33665c, min);
            i10 -= min;
            m02.f33665c += min;
        }
        this.f32394b += remaining;
        return remaining;
    }

    public long x(ByteString targetBytes, long j10) {
        int i10;
        int i11;
        i.f(targetBytes, "targetBytes");
        long j11 = 0;
        if (j10 >= 0) {
            g gVar = this.f32393a;
            if (gVar == null) {
                return -1L;
            }
            if (i0() - j10 < j10) {
                j11 = i0();
                while (j11 > j10) {
                    gVar = gVar.f33669g;
                    i.d(gVar);
                    j11 -= gVar.f33665c - gVar.f33664b;
                }
                if (targetBytes.size() == 2) {
                    byte b10 = targetBytes.getByte(0);
                    byte b11 = targetBytes.getByte(1);
                    while (j11 < i0()) {
                        byte[] bArr = gVar.f33663a;
                        i10 = (int) ((gVar.f33664b + j10) - j11);
                        int i12 = gVar.f33665c;
                        while (i10 < i12) {
                            byte b12 = bArr[i10];
                            if (!(b12 == b10 || b12 == b11)) {
                                i10++;
                            }
                            i11 = gVar.f33664b;
                        }
                        j11 += gVar.f33665c - gVar.f33664b;
                        gVar = gVar.f33668f;
                        i.d(gVar);
                        j10 = j11;
                    }
                    return -1L;
                }
                byte[] internalArray$okio = targetBytes.internalArray$okio();
                while (j11 < i0()) {
                    byte[] bArr2 = gVar.f33663a;
                    i10 = (int) ((gVar.f33664b + j10) - j11);
                    int i13 = gVar.f33665c;
                    while (i10 < i13) {
                        byte b13 = bArr2[i10];
                        for (byte b14 : internalArray$okio) {
                            if (b13 == b14) {
                                i11 = gVar.f33664b;
                            }
                        }
                        i10++;
                    }
                    j11 += gVar.f33665c - gVar.f33664b;
                    gVar = gVar.f33668f;
                    i.d(gVar);
                    j10 = j11;
                }
                return -1L;
            }
            while (true) {
                long j12 = (gVar.f33665c - gVar.f33664b) + j11;
                if (j12 > j10) {
                    break;
                }
                gVar = gVar.f33668f;
                i.d(gVar);
                j11 = j12;
            }
            if (targetBytes.size() == 2) {
                byte b15 = targetBytes.getByte(0);
                byte b16 = targetBytes.getByte(1);
                while (j11 < i0()) {
                    byte[] bArr3 = gVar.f33663a;
                    i10 = (int) ((gVar.f33664b + j10) - j11);
                    int i14 = gVar.f33665c;
                    while (i10 < i14) {
                        byte b17 = bArr3[i10];
                        if (!(b17 == b15 || b17 == b16)) {
                            i10++;
                        }
                        i11 = gVar.f33664b;
                    }
                    j11 += gVar.f33665c - gVar.f33664b;
                    gVar = gVar.f33668f;
                    i.d(gVar);
                    j10 = j11;
                }
                return -1L;
            }
            byte[] internalArray$okio2 = targetBytes.internalArray$okio();
            while (j11 < i0()) {
                byte[] bArr4 = gVar.f33663a;
                i10 = (int) ((gVar.f33664b + j10) - j11);
                int i15 = gVar.f33665c;
                while (i10 < i15) {
                    byte b18 = bArr4[i10];
                    for (byte b19 : internalArray$okio2) {
                        if (b18 == b19) {
                            i11 = gVar.f33664b;
                        }
                    }
                    i10++;
                }
                j11 += gVar.f33665c - gVar.f33664b;
                gVar = gVar.f33668f;
                i.d(gVar);
                j10 = j11;
            }
            return -1L;
            return (i10 - i11) + j11;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j10).toString());
    }

    @Override // okio.e
    public long y0(r sink) throws IOException {
        i.f(sink, "sink");
        long i02 = i0();
        if (i02 > 0) {
            sink.Z(this, i02);
        }
        return i02;
    }

    @Override // okio.e
    public byte[] z() {
        return p0(i0());
    }

    /* renamed from: z0 */
    public c c0(long j10) {
        if (j10 == 0) {
            return C(48);
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & 6148914691236517205L);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + 3) / 4);
        g m02 = m0(i10);
        byte[] bArr = m02.f33663a;
        int i11 = m02.f33665c;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = sp.a.a()[(int) (15 & j10)];
            j10 >>>= 4;
        }
        m02.f33665c += i10;
        h0(i0() + i10);
        return this;
    }

    /* compiled from: Buffer.kt */
    /* loaded from: classes3.dex */
    public static final class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(c.this.i0(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (c.this.i0() > 0) {
                return c.this.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return c.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] sink, int i10, int i11) {
            i.f(sink, "sink");
            return c.this.read(sink, i10, i11);
        }
    }

    @Override // okio.e
    public int read(byte[] sink, int i10, int i11) {
        i.f(sink, "sink");
        rp.c.b(sink.length, i10, i11);
        g gVar = this.f32393a;
        if (gVar == null) {
            return -1;
        }
        int min = Math.min(i11, gVar.f33665c - gVar.f33664b);
        byte[] bArr = gVar.f33663a;
        int i12 = gVar.f33664b;
        e.c(bArr, sink, i10, i12, i12 + min);
        gVar.f33664b += min;
        h0(i0() - min);
        if (gVar.f33664b != gVar.f33665c) {
            return min;
        }
        this.f32393a = gVar.b();
        h.b(gVar);
        return min;
    }

    @Override // okio.t
    public long read(c sink, long j10) {
        i.f(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (i0() == 0) {
            return -1L;
        } else {
            if (j10 > i0()) {
                j10 = i0();
            }
            sink.Z(this, j10);
            return j10;
        }
    }
}
