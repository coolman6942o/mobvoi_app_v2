package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f9307a;

    private h(ByteBuffer byteBuffer) {
        this.f9307a = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    private h(byte[] bArr, int i10, int i11) {
        this(ByteBuffer.wrap(bArr, i10, i11));
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        int i11 = 0;
        while (i11 < length && charSequence.charAt(i11) < 128) {
            i11++;
        }
        int i12 = length;
        while (true) {
            if (i11 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i11);
            if (charAt < 2048) {
                i12 += (127 - charAt) >>> 31;
                i11++;
            } else {
                int length2 = charSequence.length();
                while (i11 < length2) {
                    char charAt2 = charSequence.charAt(i11);
                    if (charAt2 < 2048) {
                        i10 += (127 - charAt2) >>> 31;
                    } else {
                        i10 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i11) >= 65536) {
                                i11++;
                            } else {
                                StringBuilder sb2 = new StringBuilder(39);
                                sb2.append("Unpaired surrogate at index ");
                                sb2.append(i11);
                                throw new IllegalArgumentException(sb2.toString());
                            }
                        }
                    }
                    i11++;
                }
                i12 += i10;
            }
        }
        if (i12 >= length) {
            return i12;
        }
        StringBuilder sb3 = new StringBuilder(54);
        sb3.append("UTF-8 length does not fit in int: ");
        sb3.append(i12 + 4294967296L);
        throw new IllegalArgumentException(sb3.toString());
    }

    private static void g(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i10;
        int i11;
        char charAt;
        int i12;
        if (!byteBuffer.isReadOnly()) {
            int i13 = 0;
            if (byteBuffer.hasArray()) {
                try {
                    byte[] array = byteBuffer.array();
                    int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    int remaining = byteBuffer.remaining();
                    int length = charSequence.length();
                    int i14 = remaining + arrayOffset;
                    while (i13 < length) {
                        int i15 = i13 + arrayOffset;
                        if (i15 >= i14 || (charAt = charSequence.charAt(i13)) >= 128) {
                            break;
                        }
                        array[i15] = (byte) charAt;
                        i13++;
                    }
                    if (i13 == length) {
                        i10 = arrayOffset + length;
                    } else {
                        i10 = arrayOffset + i13;
                        while (i13 < length) {
                            char charAt2 = charSequence.charAt(i13);
                            if (charAt2 >= 128 || i10 >= i14) {
                                if (charAt2 < 2048 && i10 <= i14 - 2) {
                                    int i16 = i10 + 1;
                                    array[i10] = (byte) ((charAt2 >>> 6) | 960);
                                    i10 = i16 + 1;
                                    array[i16] = (byte) ((charAt2 & '?') | 128);
                                } else if ((charAt2 < 55296 || 57343 < charAt2) && i10 <= i14 - 3) {
                                    int i17 = i10 + 1;
                                    array[i10] = (byte) ((charAt2 >>> '\f') | 480);
                                    int i18 = i17 + 1;
                                    array[i17] = (byte) (((charAt2 >>> 6) & 63) | 128);
                                    i11 = i18 + 1;
                                    array[i18] = (byte) ((charAt2 & '?') | 128);
                                } else if (i10 <= i14 - 4) {
                                    int i19 = i13 + 1;
                                    if (i19 != charSequence.length()) {
                                        char charAt3 = charSequence.charAt(i19);
                                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                                            int i20 = i10 + 1;
                                            array[i10] = (byte) ((codePoint >>> 18) | 240);
                                            int i21 = i20 + 1;
                                            array[i20] = (byte) (((codePoint >>> 12) & 63) | 128);
                                            int i22 = i21 + 1;
                                            array[i21] = (byte) (((codePoint >>> 6) & 63) | 128);
                                            i10 = i22 + 1;
                                            array[i22] = (byte) ((codePoint & 63) | 128);
                                            i13 = i19;
                                        } else {
                                            i13 = i19;
                                        }
                                    }
                                    StringBuilder sb2 = new StringBuilder(39);
                                    sb2.append("Unpaired surrogate at index ");
                                    sb2.append(i13 - 1);
                                    throw new IllegalArgumentException(sb2.toString());
                                } else {
                                    StringBuilder sb3 = new StringBuilder(37);
                                    sb3.append("Failed writing ");
                                    sb3.append(charAt2);
                                    sb3.append(" at index ");
                                    sb3.append(i10);
                                    throw new ArrayIndexOutOfBoundsException(sb3.toString());
                                }
                                i13++;
                            } else {
                                i11 = i10 + 1;
                                array[i10] = (byte) charAt2;
                            }
                            i10 = i11;
                            i13++;
                        }
                    }
                    byteBuffer.position(i10 - byteBuffer.arrayOffset());
                } catch (ArrayIndexOutOfBoundsException e10) {
                    BufferOverflowException bufferOverflowException = new BufferOverflowException();
                    bufferOverflowException.initCause(e10);
                    throw bufferOverflowException;
                }
            } else {
                int length2 = charSequence.length();
                while (i13 < length2) {
                    char charAt4 = charSequence.charAt(i13);
                    char c10 = charAt4;
                    if (charAt4 >= 128) {
                        if (charAt4 < 2048) {
                            i12 = (charAt4 >>> 6) | 960;
                        } else if (charAt4 < 55296 || 57343 < charAt4) {
                            byteBuffer.put((byte) ((charAt4 >>> '\f') | 480));
                            i12 = ((charAt4 >>> 6) & 63) | 128;
                        } else {
                            int i23 = i13 + 1;
                            if (i23 != charSequence.length()) {
                                char charAt5 = charSequence.charAt(i23);
                                if (Character.isSurrogatePair(charAt4, charAt5)) {
                                    int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                    byteBuffer.put((byte) ((codePoint2 >>> 18) | 240));
                                    byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | 128));
                                    byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | 128));
                                    byteBuffer.put((byte) ((codePoint2 & 63) | 128));
                                    i13 = i23;
                                    i13++;
                                } else {
                                    i13 = i23;
                                }
                            }
                            StringBuilder sb4 = new StringBuilder(39);
                            sb4.append("Unpaired surrogate at index ");
                            sb4.append(i13 - 1);
                            throw new IllegalArgumentException(sb4.toString());
                        }
                        byteBuffer.put((byte) i12);
                        c10 = (charAt4 & '?') | 128;
                    }
                    byteBuffer.put((byte) c10);
                    i13++;
                }
            }
        } else {
            throw new ReadOnlyBufferException();
        }
    }

    private final void h(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            k((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        k((int) j10);
    }

    public static int i(int i10) {
        if (i10 >= 0) {
            return n(i10);
        }
        return 10;
    }

    public static int j(long j10) {
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (((-16384) & j10) == 0) {
            return 2;
        }
        if (((-2097152) & j10) == 0) {
            return 3;
        }
        if (((-268435456) & j10) == 0) {
            return 4;
        }
        if (((-34359738368L) & j10) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j10) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j10) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j10) == 0) {
            return 8;
        }
        return (j10 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private final void k(int i10) throws IOException {
        byte b10 = (byte) i10;
        if (this.f9307a.hasRemaining()) {
            this.f9307a.put(b10);
            return;
        }
        throw new zzabx(this.f9307a.position(), this.f9307a.limit());
    }

    public static int l(int i10) {
        return n(i10 << 3);
    }

    public static int n(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int o(int i10, n nVar) {
        int l10 = l(i10);
        int f10 = nVar.f();
        return l10 + n(f10) + f10;
    }

    public static h p(byte[] bArr, int i10, int i11) {
        return new h(bArr, 0, i11);
    }

    public static int t(int i10, long j10) {
        return l(i10) + j(j10);
    }

    public static int u(int i10, String str) {
        return l(i10) + x(str);
    }

    public static int w(int i10, int i11) {
        return l(i10) + i(i11);
    }

    public static int x(String str) {
        int a10 = a(str);
        return n(a10) + a10;
    }

    public static h z(byte[] bArr) {
        return p(bArr, 0, bArr.length);
    }

    public final void A(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.f9307a.remaining() >= length) {
            this.f9307a.put(bArr, 0, length);
            return;
        }
        throw new zzabx(this.f9307a.position(), this.f9307a.limit());
    }

    public final void B() {
        if (this.f9307a.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.f9307a.remaining())));
        }
    }

    public final void b(int i10, double d10) throws IOException {
        y(i10, 1);
        long doubleToLongBits = Double.doubleToLongBits(d10);
        if (this.f9307a.remaining() >= 8) {
            this.f9307a.putLong(doubleToLongBits);
            return;
        }
        throw new zzabx(this.f9307a.position(), this.f9307a.limit());
    }

    public final void c(int i10, float f10) throws IOException {
        y(i10, 5);
        int floatToIntBits = Float.floatToIntBits(f10);
        if (this.f9307a.remaining() >= 4) {
            this.f9307a.putInt(floatToIntBits);
            return;
        }
        throw new zzabx(this.f9307a.position(), this.f9307a.limit());
    }

    public final void d(int i10, long j10) throws IOException {
        y(i10, 0);
        h(j10);
    }

    public final void e(int i10, n nVar) throws IOException {
        y(i10, 2);
        s(nVar);
    }

    public final void f(int i10, boolean z10) throws IOException {
        y(i10, 0);
        byte b10 = z10 ? (byte) 1 : (byte) 0;
        if (this.f9307a.hasRemaining()) {
            this.f9307a.put(b10);
            return;
        }
        throw new zzabx(this.f9307a.position(), this.f9307a.limit());
    }

    public final void m(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            k((i10 & 127) | 128);
            i10 >>>= 7;
        }
        k(i10);
    }

    public final void q(int i10, long j10) throws IOException {
        y(i10, 0);
        h(j10);
    }

    public final void r(int i10, String str) throws IOException {
        y(i10, 2);
        try {
            int n10 = n(str.length());
            if (n10 == n(str.length() * 3)) {
                int position = this.f9307a.position();
                if (this.f9307a.remaining() >= n10) {
                    this.f9307a.position(position + n10);
                    g(str, this.f9307a);
                    int position2 = this.f9307a.position();
                    this.f9307a.position(position);
                    m((position2 - position) - n10);
                    this.f9307a.position(position2);
                    return;
                }
                throw new zzabx(position + n10, this.f9307a.limit());
            }
            m(a(str));
            g(str, this.f9307a);
        } catch (BufferOverflowException e10) {
            zzabx zzabxVar = new zzabx(this.f9307a.position(), this.f9307a.limit());
            zzabxVar.initCause(e10);
            throw zzabxVar;
        }
    }

    public final void s(n nVar) throws IOException {
        m(nVar.e());
        nVar.b(this);
    }

    public final void v(int i10, int i11) throws IOException {
        y(i10, 0);
        if (i11 >= 0) {
            m(i11);
        } else {
            h(i11);
        }
    }

    public final void y(int i10, int i11) throws IOException {
        m((i10 << 3) | i11);
    }
}
