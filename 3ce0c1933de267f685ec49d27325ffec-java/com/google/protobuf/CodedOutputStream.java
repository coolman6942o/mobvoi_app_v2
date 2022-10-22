package com.google.protobuf;

import com.google.protobuf.d1;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public abstract class CodedOutputStream extends h {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f12710b = Logger.getLogger(CodedOutputStream.class.getName());

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f12711c = c1.h();

    /* renamed from: d  reason: collision with root package name */
    private static final long f12712d = c1.d();

    /* renamed from: a  reason: collision with root package name */
    private boolean f12713a;

    /* loaded from: classes.dex */
    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super(MESSAGE);
        }

        OutOfSpaceException(Throwable th2) {
            super(MESSAGE, th2);
        }

        OutOfSpaceException(String str, Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class b extends CodedOutputStream {

        /* renamed from: e  reason: collision with root package name */
        final byte[] f12714e;

        /* renamed from: f  reason: collision with root package name */
        final int f12715f;

        /* renamed from: g  reason: collision with root package name */
        int f12716g;

        /* renamed from: h  reason: collision with root package name */
        int f12717h;

        b(int i10) {
            super();
            if (i10 >= 0) {
                byte[] bArr = new byte[Math.max(i10, 20)];
                this.f12714e = bArr;
                this.f12715f = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        final void Q0(byte b10) {
            byte[] bArr = this.f12714e;
            int i10 = this.f12716g;
            this.f12716g = i10 + 1;
            bArr[i10] = b10;
            this.f12717h++;
        }

        final void R0(int i10) {
            byte[] bArr = this.f12714e;
            int i11 = this.f12716g;
            int i12 = i11 + 1;
            this.f12716g = i12;
            bArr[i11] = (byte) (i10 & 255);
            int i13 = i12 + 1;
            this.f12716g = i13;
            bArr[i12] = (byte) ((i10 >> 8) & 255);
            int i14 = i13 + 1;
            this.f12716g = i14;
            bArr[i13] = (byte) ((i10 >> 16) & 255);
            this.f12716g = i14 + 1;
            bArr[i14] = (byte) ((i10 >> 24) & 255);
            this.f12717h += 4;
        }

        final void S0(long j10) {
            byte[] bArr = this.f12714e;
            int i10 = this.f12716g;
            int i11 = i10 + 1;
            this.f12716g = i11;
            bArr[i10] = (byte) (j10 & 255);
            int i12 = i11 + 1;
            this.f12716g = i12;
            bArr[i11] = (byte) ((j10 >> 8) & 255);
            int i13 = i12 + 1;
            this.f12716g = i13;
            bArr[i12] = (byte) ((j10 >> 16) & 255);
            int i14 = i13 + 1;
            this.f12716g = i14;
            bArr[i13] = (byte) (255 & (j10 >> 24));
            int i15 = i14 + 1;
            this.f12716g = i15;
            bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
            int i16 = i15 + 1;
            this.f12716g = i16;
            bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
            int i17 = i16 + 1;
            this.f12716g = i17;
            bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
            this.f12716g = i17 + 1;
            bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
            this.f12717h += 8;
        }

        final void T0(int i10) {
            if (i10 >= 0) {
                V0(i10);
            } else {
                W0(i10);
            }
        }

        final void U0(int i10, int i11) {
            V0(WireFormat.c(i10, i11));
        }

        final void V0(int i10) {
            if (CodedOutputStream.f12711c) {
                long j10 = CodedOutputStream.f12712d + this.f12716g;
                long j11 = j10;
                while ((i10 & (-128)) != 0) {
                    j11 = 1 + j11;
                    c1.j(this.f12714e, j11, (byte) ((i10 & 127) | 128));
                    i10 >>>= 7;
                }
                c1.j(this.f12714e, j11, (byte) i10);
                int i11 = (int) ((1 + j11) - j10);
                this.f12716g += i11;
                this.f12717h += i11;
                return;
            }
            while ((i10 & (-128)) != 0) {
                byte[] bArr = this.f12714e;
                int i12 = this.f12716g;
                this.f12716g = i12 + 1;
                bArr[i12] = (byte) ((i10 & 127) | 128);
                this.f12717h++;
                i10 >>>= 7;
            }
            byte[] bArr2 = this.f12714e;
            int i13 = this.f12716g;
            this.f12716g = i13 + 1;
            bArr2[i13] = (byte) i10;
            this.f12717h++;
        }

        final void W0(long j10) {
            if (CodedOutputStream.f12711c) {
                long j11 = CodedOutputStream.f12712d + this.f12716g;
                long j12 = j11;
                while ((j10 & (-128)) != 0) {
                    j12 = 1 + j12;
                    c1.j(this.f12714e, j12, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
                c1.j(this.f12714e, j12, (byte) j10);
                int i10 = (int) ((1 + j12) - j11);
                this.f12716g += i10;
                this.f12717h += i10;
                return;
            }
            while ((j10 & (-128)) != 0) {
                byte[] bArr = this.f12714e;
                int i11 = this.f12716g;
                this.f12716g = i11 + 1;
                bArr[i11] = (byte) ((((int) j10) & 127) | 128);
                this.f12717h++;
                j10 >>>= 7;
            }
            byte[] bArr2 = this.f12714e;
            int i12 = this.f12716g;
            this.f12716g = i12 + 1;
            bArr2[i12] = (byte) j10;
            this.f12717h++;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int c0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends CodedOutputStream {

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f12718e;

        /* renamed from: f  reason: collision with root package name */
        private final int f12719f;

        /* renamed from: g  reason: collision with root package name */
        private int f12720g;

        c(byte[] bArr, int i10, int i11) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            int i12 = i10 + i11;
            if ((i10 | i11 | (bArr.length - i12)) >= 0) {
                this.f12718e = bArr;
                this.f12720g = i10;
                this.f12719f = i12;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void A0(int i10, e0 e0Var) throws IOException {
            L0(i10, 2);
            B0(e0Var);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void B0(e0 e0Var) throws IOException {
            N0(e0Var.getSerializedSize());
            e0Var.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void C0(int i10, e0 e0Var) throws IOException {
            L0(1, 3);
            M0(2, i10);
            A0(3, e0Var);
            L0(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void D0(int i10, ByteString byteString) throws IOException {
            L0(1, 3);
            M0(2, i10);
            i0(3, byteString);
            L0(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void J0(int i10, String str) throws IOException {
            L0(i10, 2);
            K0(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void K0(String str) throws IOException {
            int i10 = this.f12720g;
            try {
                int R = CodedOutputStream.R(str.length() * 3);
                int R2 = CodedOutputStream.R(str.length());
                if (R2 == R) {
                    int i11 = i10 + R2;
                    this.f12720g = i11;
                    int e10 = d1.e(str, this.f12718e, i11, c0());
                    this.f12720g = i10;
                    N0((e10 - i10) - R2);
                    this.f12720g = e10;
                } else {
                    N0(d1.f(str));
                    this.f12720g = d1.e(str, this.f12718e, this.f12720g, c0());
                }
            } catch (d1.c e11) {
                this.f12720g = i10;
                X(str, e11);
            } catch (IndexOutOfBoundsException e12) {
                throw new OutOfSpaceException(e12);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void L0(int i10, int i11) throws IOException {
            N0(WireFormat.c(i10, i11));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void M0(int i10, int i11) throws IOException {
            L0(i10, 0);
            N0(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void N0(int i10) throws IOException {
            if (!CodedOutputStream.f12711c || c0() < 10) {
                while ((i10 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f12718e;
                        int i11 = this.f12720g;
                        this.f12720g = i11 + 1;
                        bArr[i11] = (byte) ((i10 & 127) | 128);
                        i10 >>>= 7;
                    } catch (IndexOutOfBoundsException e10) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12720g), Integer.valueOf(this.f12719f), 1), e10);
                    }
                }
                byte[] bArr2 = this.f12718e;
                int i12 = this.f12720g;
                this.f12720g = i12 + 1;
                bArr2[i12] = (byte) i10;
                return;
            }
            long j10 = CodedOutputStream.f12712d + this.f12720g;
            while ((i10 & (-128)) != 0) {
                j10 = 1 + j10;
                c1.j(this.f12718e, j10, (byte) ((i10 & 127) | 128));
                this.f12720g++;
                i10 >>>= 7;
            }
            c1.j(this.f12718e, j10, (byte) i10);
            this.f12720g++;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void O0(int i10, long j10) throws IOException {
            L0(i10, 0);
            P0(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void P0(long j10) throws IOException {
            if (!CodedOutputStream.f12711c || c0() < 10) {
                while ((j10 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f12718e;
                        int i10 = this.f12720g;
                        this.f12720g = i10 + 1;
                        bArr[i10] = (byte) ((((int) j10) & 127) | 128);
                        j10 >>>= 7;
                    } catch (IndexOutOfBoundsException e10) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12720g), Integer.valueOf(this.f12719f), 1), e10);
                    }
                }
                byte[] bArr2 = this.f12718e;
                int i11 = this.f12720g;
                this.f12720g = i11 + 1;
                bArr2[i11] = (byte) j10;
                return;
            }
            long j11 = CodedOutputStream.f12712d + this.f12720g;
            while ((j10 & (-128)) != 0) {
                j11 = 1 + j11;
                c1.j(this.f12718e, j11, (byte) ((((int) j10) & 127) | 128));
                this.f12720g++;
                j10 >>>= 7;
            }
            c1.j(this.f12718e, j11, (byte) j10);
            this.f12720g++;
        }

        public final void Q0(byte[] bArr, int i10, int i11) throws IOException {
            try {
                System.arraycopy(bArr, i10, this.f12718e, this.f12720g, i11);
                this.f12720g += i11;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12720g), Integer.valueOf(this.f12719f), Integer.valueOf(i11)), e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void W() {
        }

        @Override // com.google.protobuf.h
        public final void a(byte[] bArr, int i10, int i11) throws IOException {
            Q0(bArr, i10, i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int c0() {
            return this.f12719f - this.f12720g;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void d0(byte b10) throws IOException {
            try {
                byte[] bArr = this.f12718e;
                int i10 = this.f12720g;
                this.f12720g = i10 + 1;
                bArr[i10] = b10;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12720g), Integer.valueOf(this.f12719f), 1), e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void e0(int i10, boolean z10) throws IOException {
            L0(i10, 0);
            d0(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void h0(byte[] bArr, int i10, int i11) throws IOException {
            N0(i11);
            Q0(bArr, i10, i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void i0(int i10, ByteString byteString) throws IOException {
            L0(i10, 2);
            j0(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void j0(ByteString byteString) throws IOException {
            N0(byteString.size());
            byteString.q(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void o0(int i10, int i11) throws IOException {
            L0(i10, 5);
            p0(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void p0(int i10) throws IOException {
            try {
                byte[] bArr = this.f12718e;
                int i11 = this.f12720g;
                int i12 = i11 + 1;
                this.f12720g = i12;
                bArr[i11] = (byte) (i10 & 255);
                int i13 = i12 + 1;
                this.f12720g = i13;
                bArr[i12] = (byte) ((i10 >> 8) & 255);
                int i14 = i13 + 1;
                this.f12720g = i14;
                bArr[i13] = (byte) ((i10 >> 16) & 255);
                this.f12720g = i14 + 1;
                bArr[i14] = (byte) ((i10 >> 24) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12720g), Integer.valueOf(this.f12719f), 1), e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void q0(int i10, long j10) throws IOException {
            L0(i10, 1);
            r0(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void r0(long j10) throws IOException {
            try {
                byte[] bArr = this.f12718e;
                int i10 = this.f12720g;
                int i11 = i10 + 1;
                this.f12720g = i11;
                bArr[i10] = (byte) (((int) j10) & 255);
                int i12 = i11 + 1;
                this.f12720g = i12;
                bArr[i11] = (byte) (((int) (j10 >> 8)) & 255);
                int i13 = i12 + 1;
                this.f12720g = i13;
                bArr[i12] = (byte) (((int) (j10 >> 16)) & 255);
                int i14 = i13 + 1;
                this.f12720g = i14;
                bArr[i13] = (byte) (((int) (j10 >> 24)) & 255);
                int i15 = i14 + 1;
                this.f12720g = i15;
                bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
                int i16 = i15 + 1;
                this.f12720g = i16;
                bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
                int i17 = i16 + 1;
                this.f12720g = i17;
                bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
                this.f12720g = i17 + 1;
                bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f12720g), Integer.valueOf(this.f12719f), 1), e10);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void w0(int i10, int i11) throws IOException {
            L0(i10, 0);
            x0(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void x0(int i10) throws IOException {
            if (i10 >= 0) {
                N0(i10);
            } else {
                P0(i10);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class d extends b {

        /* renamed from: i  reason: collision with root package name */
        private final OutputStream f12721i;

        d(OutputStream outputStream, int i10) {
            super(i10);
            Objects.requireNonNull(outputStream, "out");
            this.f12721i = outputStream;
        }

        private void X0() throws IOException {
            this.f12721i.write(this.f12714e, 0, this.f12716g);
            this.f12716g = 0;
        }

        private void Y0(int i10) throws IOException {
            if (this.f12715f - this.f12716g < i10) {
                X0();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void A0(int i10, e0 e0Var) throws IOException {
            L0(i10, 2);
            B0(e0Var);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void B0(e0 e0Var) throws IOException {
            N0(e0Var.getSerializedSize());
            e0Var.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void C0(int i10, e0 e0Var) throws IOException {
            L0(1, 3);
            M0(2, i10);
            A0(3, e0Var);
            L0(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void D0(int i10, ByteString byteString) throws IOException {
            L0(1, 3);
            M0(2, i10);
            i0(3, byteString);
            L0(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void J0(int i10, String str) throws IOException {
            L0(i10, 2);
            K0(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void K0(String str) throws IOException {
            int i10;
            try {
                int length = str.length() * 3;
                int R = CodedOutputStream.R(length);
                int i11 = R + length;
                int i12 = this.f12715f;
                if (i11 > i12) {
                    byte[] bArr = new byte[length];
                    int e10 = d1.e(str, bArr, 0, length);
                    N0(e10);
                    a(bArr, 0, e10);
                    return;
                }
                if (i11 > i12 - this.f12716g) {
                    X0();
                }
                int R2 = CodedOutputStream.R(str.length());
                int i13 = this.f12716g;
                try {
                    if (R2 == R) {
                        int i14 = i13 + R2;
                        this.f12716g = i14;
                        int e11 = d1.e(str, this.f12714e, i14, this.f12715f - i14);
                        this.f12716g = i13;
                        i10 = (e11 - i13) - R2;
                        V0(i10);
                        this.f12716g = e11;
                    } else {
                        i10 = d1.f(str);
                        V0(i10);
                        this.f12716g = d1.e(str, this.f12714e, this.f12716g, i10);
                    }
                    this.f12717h += i10;
                } catch (d1.c e12) {
                    this.f12717h -= this.f12716g - i13;
                    this.f12716g = i13;
                    throw e12;
                } catch (ArrayIndexOutOfBoundsException e13) {
                    throw new OutOfSpaceException(e13);
                }
            } catch (d1.c e14) {
                X(str, e14);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void L0(int i10, int i11) throws IOException {
            N0(WireFormat.c(i10, i11));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void M0(int i10, int i11) throws IOException {
            Y0(20);
            U0(i10, 0);
            V0(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void N0(int i10) throws IOException {
            Y0(10);
            V0(i10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void O0(int i10, long j10) throws IOException {
            Y0(20);
            U0(i10, 0);
            W0(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void P0(long j10) throws IOException {
            Y0(10);
            W0(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void W() throws IOException {
            if (this.f12716g > 0) {
                X0();
            }
        }

        public void Z0(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = this.f12715f;
            int i13 = this.f12716g;
            if (i12 - i13 >= i11) {
                System.arraycopy(bArr, i10, this.f12714e, i13, i11);
                this.f12716g += i11;
                this.f12717h += i11;
                return;
            }
            int i14 = i12 - i13;
            System.arraycopy(bArr, i10, this.f12714e, i13, i14);
            int i15 = i10 + i14;
            int i16 = i11 - i14;
            this.f12716g = this.f12715f;
            this.f12717h += i14;
            X0();
            if (i16 <= this.f12715f) {
                System.arraycopy(bArr, i15, this.f12714e, 0, i16);
                this.f12716g = i16;
            } else {
                this.f12721i.write(bArr, i15, i16);
            }
            this.f12717h += i16;
        }

        @Override // com.google.protobuf.h
        public void a(byte[] bArr, int i10, int i11) throws IOException {
            Z0(bArr, i10, i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void d0(byte b10) throws IOException {
            if (this.f12716g == this.f12715f) {
                X0();
            }
            Q0(b10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void e0(int i10, boolean z10) throws IOException {
            Y0(11);
            U0(i10, 0);
            Q0(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void h0(byte[] bArr, int i10, int i11) throws IOException {
            N0(i11);
            Z0(bArr, i10, i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void i0(int i10, ByteString byteString) throws IOException {
            L0(i10, 2);
            j0(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void j0(ByteString byteString) throws IOException {
            N0(byteString.size());
            byteString.q(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void o0(int i10, int i11) throws IOException {
            Y0(14);
            U0(i10, 5);
            R0(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void p0(int i10) throws IOException {
            Y0(4);
            R0(i10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void q0(int i10, long j10) throws IOException {
            Y0(18);
            U0(i10, 1);
            S0(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void r0(long j10) throws IOException {
            Y0(8);
            S0(j10);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void w0(int i10, int i11) throws IOException {
            Y0(20);
            U0(i10, 0);
            T0(i11);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void x0(int i10) throws IOException {
            if (i10 >= 0) {
                N0(i10);
            } else {
                P0(i10);
            }
        }
    }

    public static int A(int i10, w wVar) {
        return P(i10) + B(wVar);
    }

    public static int B(w wVar) {
        return C(wVar.c());
    }

    static int C(int i10) {
        return R(i10) + i10;
    }

    public static int D(int i10, e0 e0Var) {
        return (P(1) * 2) + Q(2, i10) + E(3, e0Var);
    }

    public static int E(int i10, e0 e0Var) {
        return P(i10) + F(e0Var);
    }

    public static int F(e0 e0Var) {
        return C(e0Var.getSerializedSize());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int G(int i10) {
        if (i10 > 4096) {
            return 4096;
        }
        return i10;
    }

    public static int H(int i10, ByteString byteString) {
        return (P(1) * 2) + Q(2, i10) + h(3, byteString);
    }

    @Deprecated
    public static int I(int i10) {
        return R(i10);
    }

    public static int J(int i10) {
        return 4;
    }

    public static int K(long j10) {
        return 8;
    }

    public static int L(int i10) {
        return R(U(i10));
    }

    public static int M(long j10) {
        return T(V(j10));
    }

    public static int N(int i10, String str) {
        return P(i10) + O(str);
    }

    public static int O(String str) {
        int i10;
        try {
            i10 = d1.f(str);
        } catch (d1.c unused) {
            i10 = str.getBytes(u.f13364a).length;
        }
        return C(i10);
    }

    public static int P(int i10) {
        return R(WireFormat.c(i10, 0));
    }

    public static int Q(int i10, int i11) {
        return P(i10) + R(i11);
    }

    public static int R(int i10) {
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

    public static int S(int i10, long j10) {
        return P(i10) + T(j10);
    }

    public static int T(long j10) {
        int i10;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            i10 = 6;
            j10 >>>= 28;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        return (j10 & (-16384)) != 0 ? i10 + 1 : i10;
    }

    public static int U(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public static long V(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static CodedOutputStream Z(OutputStream outputStream, int i10) {
        return new d(outputStream, i10);
    }

    public static CodedOutputStream a0(byte[] bArr) {
        return b0(bArr, 0, bArr.length);
    }

    public static CodedOutputStream b0(byte[] bArr, int i10, int i11) {
        return new c(bArr, i10, i11);
    }

    public static int e(int i10, boolean z10) {
        return P(i10) + f(z10);
    }

    public static int f(boolean z10) {
        return 1;
    }

    public static int g(byte[] bArr) {
        return C(bArr.length);
    }

    public static int h(int i10, ByteString byteString) {
        return P(i10) + i(byteString);
    }

    public static int i(ByteString byteString) {
        return C(byteString.size());
    }

    public static int j(int i10, double d10) {
        return P(i10) + k(d10);
    }

    public static int k(double d10) {
        return 8;
    }

    public static int l(int i10, int i11) {
        return P(i10) + m(i11);
    }

    public static int m(int i10) {
        return w(i10);
    }

    public static int n(int i10, int i11) {
        return P(i10) + o(i11);
    }

    public static int o(int i10) {
        return 4;
    }

    public static int p(int i10, long j10) {
        return P(i10) + q(j10);
    }

    public static int q(long j10) {
        return 8;
    }

    public static int r(int i10, float f10) {
        return P(i10) + s(f10);
    }

    public static int s(float f10) {
        return 4;
    }

    @Deprecated
    public static int t(int i10, e0 e0Var) {
        return (P(i10) * 2) + u(e0Var);
    }

    @Deprecated
    public static int u(e0 e0Var) {
        return e0Var.getSerializedSize();
    }

    public static int v(int i10, int i11) {
        return P(i10) + w(i11);
    }

    public static int w(int i10) {
        if (i10 >= 0) {
            return R(i10);
        }
        return 10;
    }

    public static int x(int i10, long j10) {
        return P(i10) + y(j10);
    }

    public static int y(long j10) {
        return T(j10);
    }

    public static int z(int i10, w wVar) {
        return (P(1) * 2) + Q(2, i10) + A(3, wVar);
    }

    public abstract void A0(int i10, e0 e0Var) throws IOException;

    public abstract void B0(e0 e0Var) throws IOException;

    public abstract void C0(int i10, e0 e0Var) throws IOException;

    public abstract void D0(int i10, ByteString byteString) throws IOException;

    @Deprecated
    public final void E0(int i10) throws IOException {
        N0(i10);
    }

    public final void F0(int i10) throws IOException {
        p0(i10);
    }

    public final void G0(long j10) throws IOException {
        r0(j10);
    }

    public final void H0(int i10) throws IOException {
        N0(U(i10));
    }

    public final void I0(long j10) throws IOException {
        P0(V(j10));
    }

    public abstract void J0(int i10, String str) throws IOException;

    public abstract void K0(String str) throws IOException;

    public abstract void L0(int i10, int i11) throws IOException;

    public abstract void M0(int i10, int i11) throws IOException;

    public abstract void N0(int i10) throws IOException;

    public abstract void O0(int i10, long j10) throws IOException;

    public abstract void P0(long j10) throws IOException;

    public abstract void W() throws IOException;

    final void X(String str, d1.c cVar) throws IOException {
        f12710b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) cVar);
        byte[] bytes = str.getBytes(u.f13364a);
        try {
            N0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (OutOfSpaceException e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new OutOfSpaceException(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Y() {
        return this.f12713a;
    }

    public abstract int c0();

    public final void d() {
        if (c0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void d0(byte b10) throws IOException;

    public abstract void e0(int i10, boolean z10) throws IOException;

    public final void f0(boolean z10) throws IOException {
        d0(z10 ? (byte) 1 : (byte) 0);
    }

    public final void g0(byte[] bArr) throws IOException {
        h0(bArr, 0, bArr.length);
    }

    abstract void h0(byte[] bArr, int i10, int i11) throws IOException;

    public abstract void i0(int i10, ByteString byteString) throws IOException;

    public abstract void j0(ByteString byteString) throws IOException;

    public final void k0(int i10, double d10) throws IOException {
        q0(i10, Double.doubleToRawLongBits(d10));
    }

    public final void l0(double d10) throws IOException {
        r0(Double.doubleToRawLongBits(d10));
    }

    public final void m0(int i10, int i11) throws IOException {
        w0(i10, i11);
    }

    public final void n0(int i10) throws IOException {
        x0(i10);
    }

    public abstract void o0(int i10, int i11) throws IOException;

    public abstract void p0(int i10) throws IOException;

    public abstract void q0(int i10, long j10) throws IOException;

    public abstract void r0(long j10) throws IOException;

    public final void s0(int i10, float f10) throws IOException {
        o0(i10, Float.floatToRawIntBits(f10));
    }

    public final void t0(float f10) throws IOException {
        p0(Float.floatToRawIntBits(f10));
    }

    @Deprecated
    public final void u0(int i10, e0 e0Var) throws IOException {
        L0(i10, 3);
        v0(e0Var);
        L0(i10, 4);
    }

    @Deprecated
    public final void v0(e0 e0Var) throws IOException {
        e0Var.writeTo(this);
    }

    public abstract void w0(int i10, int i11) throws IOException;

    public abstract void x0(int i10) throws IOException;

    public final void y0(int i10, long j10) throws IOException {
        O0(i10, j10);
    }

    public final void z0(long j10) throws IOException {
        P0(j10);
    }

    private CodedOutputStream() {
    }
}
