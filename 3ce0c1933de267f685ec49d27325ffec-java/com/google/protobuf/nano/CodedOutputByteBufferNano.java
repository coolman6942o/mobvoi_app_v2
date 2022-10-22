package com.google.protobuf.nano;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
/* loaded from: classes.dex */
public final class CodedOutputByteBufferNano {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f13286a;

    /* loaded from: classes.dex */
    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException(int i10, int i11) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i10 + " limit " + i11 + ").");
        }
    }

    private CodedOutputByteBufferNano(byte[] bArr, int i10, int i11) {
        this(ByteBuffer.wrap(bArr, i10, i11));
    }

    private static void A(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            char charAt = charSequence.charAt(i10);
            if (charAt < 128) {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 2048) {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            } else if (charAt < 55296 || 57343 < charAt) {
                byteBuffer.put((byte) ((charAt >>> '\f') | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            } else {
                int i11 = i10 + 1;
                if (i11 != charSequence.length()) {
                    char charAt2 = charSequence.charAt(i11);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int codePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((codePoint & 63) | 128));
                        i10 = i11;
                    } else {
                        i10 = i11;
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unpaired surrogate at index ");
                sb2.append(i10 - 1);
                throw new IllegalArgumentException(sb2.toString());
            }
            i10++;
        }
    }

    public static long B(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    private static int C(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length && charSequence.charAt(i10) < 128) {
            i10++;
        }
        int i11 = length;
        while (true) {
            if (i10 < length) {
                char charAt = charSequence.charAt(i10);
                if (charAt >= 2048) {
                    i11 += D(charSequence, i10);
                    break;
                }
                i11 += (127 - charAt) >>> 31;
                i10++;
            } else {
                break;
            }
        }
        if (i11 >= length) {
            return i11;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i11 + 4294967296L));
    }

    private static int D(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        while (i10 < length) {
            char charAt = charSequence.charAt(i10);
            if (charAt < 2048) {
                i11 += (127 - charAt) >>> 31;
            } else {
                i11 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i10) >= 65536) {
                        i10++;
                    } else {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i10);
                    }
                }
            }
            i10++;
        }
        return i11;
    }

    public static CodedOutputByteBufferNano E(byte[] bArr, int i10, int i11) {
        return new CodedOutputByteBufferNano(bArr, i10, i11);
    }

    public static int b(int i10, boolean z10) {
        return t(i10) + c(z10);
    }

    public static int c(boolean z10) {
        return 1;
    }

    public static int d(int i10, byte[] bArr) {
        return t(i10) + e(bArr);
    }

    public static int e(byte[] bArr) {
        return n(bArr.length) + bArr.length;
    }

    public static int f(int i10, float f10) {
        return t(i10) + g(f10);
    }

    public static int g(float f10) {
        return 4;
    }

    public static int h(int i10, int i11) {
        return t(i10) + i(i11);
    }

    public static int i(int i10) {
        if (i10 >= 0) {
            return n(i10);
        }
        return 10;
    }

    public static int j(int i10, long j10) {
        return t(i10) + k(j10);
    }

    public static int k(long j10) {
        return o(j10);
    }

    public static int l(int i10, c cVar) {
        return t(i10) + m(cVar);
    }

    public static int m(c cVar) {
        int serializedSize = cVar.getSerializedSize();
        return n(serializedSize) + serializedSize;
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

    public static int o(long j10) {
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

    public static int p(int i10, long j10) {
        return t(i10) + q(j10);
    }

    public static int q(long j10) {
        return o(B(j10));
    }

    public static int r(int i10, String str) {
        return t(i10) + s(str);
    }

    public static int s(String str) {
        int C = C(str);
        return n(C) + C;
    }

    public static int t(int i10) {
        return n(e.d(i10, 0));
    }

    public static int u(int i10, int i11) {
        return t(i10) + v(i11);
    }

    public static int v(int i10) {
        return n(i10);
    }

    public static int w(int i10, long j10) {
        return t(i10) + x(j10);
    }

    public static int x(long j10) {
        return o(j10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r8 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int y(CharSequence charSequence, byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        char charAt;
        int length = charSequence.length();
        int i14 = i11 + i10;
        int i15 = 0;
        while (i15 < length && (i13 = i15 + i10) < i14 && (charAt = charSequence.charAt(i15)) < 128) {
            bArr[i13] = (byte) charAt;
            i15++;
        }
        int i16 = i10 + i15;
        while (i15 < length) {
            char charAt2 = charSequence.charAt(i15);
            if (charAt2 >= 128 || i16 >= i14) {
                if (charAt2 < 2048 && i16 <= i14 - 2) {
                    int i17 = i16 + 1;
                    bArr[i16] = (byte) ((charAt2 >>> 6) | 960);
                    i16 = i17 + 1;
                    bArr[i17] = (byte) ((charAt2 & '?') | 128);
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i16 <= i14 - 3) {
                    int i18 = i16 + 1;
                    bArr[i16] = (byte) ((charAt2 >>> '\f') | 480);
                    int i19 = i18 + 1;
                    bArr[i18] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i12 = i19 + 1;
                    bArr[i19] = (byte) ((charAt2 & '?') | 128);
                } else if (i16 <= i14 - 4) {
                    int i20 = i15 + 1;
                    if (i20 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i20);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i21 = i16 + 1;
                            bArr[i16] = (byte) ((codePoint >>> 18) | 240);
                            int i22 = i21 + 1;
                            bArr[i21] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i23 = i22 + 1;
                            bArr[i22] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i16 = i23 + 1;
                            bArr[i23] = (byte) ((codePoint & 63) | 128);
                            i15 = i20;
                        } else {
                            i15 = i20;
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unpaired surrogate at index ");
                    sb2.append(i15 - 1);
                    throw new IllegalArgumentException(sb2.toString());
                } else {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i16);
                }
                i15++;
            } else {
                i12 = i16 + 1;
                bArr[i16] = (byte) charAt2;
            }
            i16 = i12;
            i15++;
        }
        return i16;
    }

    private static void z(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(y(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (ArrayIndexOutOfBoundsException e10) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e10);
                throw bufferOverflowException;
            }
        } else {
            A(charSequence, byteBuffer);
        }
    }

    public int F() {
        return this.f13286a.remaining();
    }

    public void G(int i10, boolean z10) throws IOException {
        d0(i10, 0);
        H(z10);
    }

    public void H(boolean z10) throws IOException {
        T(z10 ? 1 : 0);
    }

    public void I(int i10, byte[] bArr) throws IOException {
        d0(i10, 2);
        J(bArr);
    }

    public void J(byte[] bArr) throws IOException {
        X(bArr.length);
        U(bArr);
    }

    public void K(int i10, float f10) throws IOException {
        d0(i10, 5);
        L(f10);
    }

    public void L(float f10) throws IOException {
        W(Float.floatToIntBits(f10));
    }

    public void M(int i10, int i11) throws IOException {
        d0(i10, 0);
        N(i11);
    }

    public void N(int i10) throws IOException {
        if (i10 >= 0) {
            X(i10);
        } else {
            Y(i10);
        }
    }

    public void O(int i10, long j10) throws IOException {
        d0(i10, 0);
        P(j10);
    }

    public void P(long j10) throws IOException {
        Y(j10);
    }

    public void Q(int i10, c cVar) throws IOException {
        d0(i10, 2);
        R(cVar);
    }

    public void R(c cVar) throws IOException {
        X(cVar.getCachedSize());
        cVar.writeTo(this);
    }

    public void S(byte b10) throws IOException {
        if (this.f13286a.hasRemaining()) {
            this.f13286a.put(b10);
            return;
        }
        throw new OutOfSpaceException(this.f13286a.position(), this.f13286a.limit());
    }

    public void T(int i10) throws IOException {
        S((byte) i10);
    }

    public void U(byte[] bArr) throws IOException {
        V(bArr, 0, bArr.length);
    }

    public void V(byte[] bArr, int i10, int i11) throws IOException {
        if (this.f13286a.remaining() >= i11) {
            this.f13286a.put(bArr, i10, i11);
            return;
        }
        throw new OutOfSpaceException(this.f13286a.position(), this.f13286a.limit());
    }

    public void W(int i10) throws IOException {
        if (this.f13286a.remaining() >= 4) {
            this.f13286a.putInt(i10);
            return;
        }
        throw new OutOfSpaceException(this.f13286a.position(), this.f13286a.limit());
    }

    public void X(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            T((i10 & 127) | 128);
            i10 >>>= 7;
        }
        T(i10);
    }

    public void Y(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            T((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        T((int) j10);
    }

    public void Z(int i10, long j10) throws IOException {
        d0(i10, 0);
        a0(j10);
    }

    public void a() {
        if (F() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void a0(long j10) throws IOException {
        Y(B(j10));
    }

    public void b0(int i10, String str) throws IOException {
        d0(i10, 2);
        c0(str);
    }

    public void c0(String str) throws IOException {
        try {
            int n10 = n(str.length());
            if (n10 == n(str.length() * 3)) {
                int position = this.f13286a.position();
                if (this.f13286a.remaining() >= n10) {
                    this.f13286a.position(position + n10);
                    z(str, this.f13286a);
                    int position2 = this.f13286a.position();
                    this.f13286a.position(position);
                    X((position2 - position) - n10);
                    this.f13286a.position(position2);
                    return;
                }
                throw new OutOfSpaceException(position + n10, this.f13286a.limit());
            }
            X(C(str));
            z(str, this.f13286a);
        } catch (BufferOverflowException e10) {
            OutOfSpaceException outOfSpaceException = new OutOfSpaceException(this.f13286a.position(), this.f13286a.limit());
            outOfSpaceException.initCause(e10);
            throw outOfSpaceException;
        }
    }

    public void d0(int i10, int i11) throws IOException {
        X(e.d(i10, i11));
    }

    public void e0(int i10, int i11) throws IOException {
        d0(i10, 0);
        f0(i11);
    }

    public void f0(int i10) throws IOException {
        X(i10);
    }

    public void g0(int i10, long j10) throws IOException {
        d0(i10, 0);
        h0(j10);
    }

    public void h0(long j10) throws IOException {
        Y(j10);
    }

    private CodedOutputByteBufferNano(ByteBuffer byteBuffer) {
        this.f13286a = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }
}
