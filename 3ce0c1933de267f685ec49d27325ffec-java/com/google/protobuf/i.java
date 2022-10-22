package com.google.protobuf;

import com.google.protobuf.e0;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
/* compiled from: CodedInputStream.java */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    int f13249a;

    /* renamed from: b  reason: collision with root package name */
    int f13250b;

    /* renamed from: c  reason: collision with root package name */
    int f13251c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CodedInputStream.java */
    /* loaded from: classes.dex */
    public static final class b extends i {

        /* renamed from: d  reason: collision with root package name */
        private final byte[] f13252d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f13253e;

        /* renamed from: f  reason: collision with root package name */
        private int f13254f;

        /* renamed from: g  reason: collision with root package name */
        private int f13255g;

        /* renamed from: h  reason: collision with root package name */
        private int f13256h;

        /* renamed from: i  reason: collision with root package name */
        private int f13257i;

        /* renamed from: j  reason: collision with root package name */
        private int f13258j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f13259k;

        /* renamed from: l  reason: collision with root package name */
        private int f13260l;

        private void R() {
            int i10 = this.f13254f + this.f13255g;
            this.f13254f = i10;
            int i11 = i10 - this.f13257i;
            int i12 = this.f13260l;
            if (i11 > i12) {
                int i13 = i11 - i12;
                this.f13255g = i13;
                this.f13254f = i10 - i13;
                return;
            }
            this.f13255g = 0;
        }

        private void U() throws IOException {
            if (this.f13254f - this.f13256h >= 10) {
                V();
            } else {
                W();
            }
        }

        private void V() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                byte[] bArr = this.f13252d;
                int i11 = this.f13256h;
                this.f13256h = i11 + 1;
                if (bArr[i11] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        private void W() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                if (L() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.protobuf.i
        public long A() throws IOException {
            return O();
        }

        @Override // com.google.protobuf.i
        public int B() throws IOException {
            return i.b(x());
        }

        @Override // com.google.protobuf.i
        public long C() throws IOException {
            return i.c(P());
        }

        @Override // com.google.protobuf.i
        public String D() throws IOException {
            int x10 = x();
            if (x10 > 0) {
                int i10 = this.f13254f;
                int i11 = this.f13256h;
                if (x10 <= i10 - i11) {
                    String str = new String(this.f13252d, i11, x10, u.f13364a);
                    this.f13256h += x10;
                    return str;
                }
            }
            if (x10 == 0) {
                return "";
            }
            if (x10 < 0) {
                throw InvalidProtocolBufferException.h();
            }
            throw InvalidProtocolBufferException.k();
        }

        @Override // com.google.protobuf.i
        public String E() throws IOException {
            int x10 = x();
            if (x10 > 0) {
                int i10 = this.f13254f;
                int i11 = this.f13256h;
                if (x10 <= i10 - i11) {
                    if (d1.m(this.f13252d, i11, i11 + x10)) {
                        int i12 = this.f13256h;
                        this.f13256h = i12 + x10;
                        return new String(this.f13252d, i12, x10, u.f13364a);
                    }
                    throw InvalidProtocolBufferException.c();
                }
            }
            if (x10 == 0) {
                return "";
            }
            if (x10 <= 0) {
                throw InvalidProtocolBufferException.h();
            }
            throw InvalidProtocolBufferException.k();
        }

        @Override // com.google.protobuf.i
        public int F() throws IOException {
            if (K()) {
                this.f13258j = 0;
                return 0;
            }
            int x10 = x();
            this.f13258j = x10;
            if (WireFormat.a(x10) != 0) {
                return this.f13258j;
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // com.google.protobuf.i
        public int G() throws IOException {
            return x();
        }

        @Override // com.google.protobuf.i
        public long H() throws IOException {
            return P();
        }

        @Override // com.google.protobuf.i
        public boolean I(int i10) throws IOException {
            int b10 = WireFormat.b(i10);
            if (b10 == 0) {
                U();
                return true;
            } else if (b10 == 1) {
                T(8);
                return true;
            } else if (b10 == 2) {
                T(x());
                return true;
            } else if (b10 == 3) {
                S();
                a(WireFormat.c(WireFormat.a(i10), 4));
                return true;
            } else if (b10 == 4) {
                return false;
            } else {
                if (b10 == 5) {
                    T(4);
                    return true;
                }
                throw InvalidProtocolBufferException.d();
            }
        }

        public int J() {
            return this.f13256h - this.f13257i;
        }

        public boolean K() throws IOException {
            return this.f13256h == this.f13254f;
        }

        public byte L() throws IOException {
            int i10 = this.f13256h;
            if (i10 != this.f13254f) {
                byte[] bArr = this.f13252d;
                this.f13256h = i10 + 1;
                return bArr[i10];
            }
            throw InvalidProtocolBufferException.k();
        }

        public byte[] M(int i10) throws IOException {
            if (i10 > 0) {
                int i11 = this.f13254f;
                int i12 = this.f13256h;
                if (i10 <= i11 - i12) {
                    int i13 = i10 + i12;
                    this.f13256h = i13;
                    return Arrays.copyOfRange(this.f13252d, i12, i13);
                }
            }
            if (i10 > 0) {
                throw InvalidProtocolBufferException.k();
            } else if (i10 == 0) {
                return u.f13366c;
            } else {
                throw InvalidProtocolBufferException.h();
            }
        }

        public int N() throws IOException {
            int i10 = this.f13256h;
            if (this.f13254f - i10 >= 4) {
                byte[] bArr = this.f13252d;
                this.f13256h = i10 + 4;
                return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
            }
            throw InvalidProtocolBufferException.k();
        }

        public long O() throws IOException {
            int i10 = this.f13256h;
            if (this.f13254f - i10 >= 8) {
                byte[] bArr = this.f13252d;
                this.f13256h = i10 + 8;
                return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
            }
            throw InvalidProtocolBufferException.k();
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x00b4, code lost:
            if (r2[r0] < 0) goto L38;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long P() throws IOException {
            long j10;
            long j11;
            long j12;
            int i10;
            int i11 = this.f13256h;
            int i12 = this.f13254f;
            if (i12 != i11) {
                byte[] bArr = this.f13252d;
                int i13 = i11 + 1;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f13256h = i13;
                    return b10;
                } else if (i12 - i13 >= 9) {
                    int i14 = i13 + 1;
                    int i15 = b10 ^ (bArr[i13] << 7);
                    if (i15 < 0) {
                        i10 = i15 ^ (-128);
                    } else {
                        int i16 = i14 + 1;
                        int i17 = i15 ^ (bArr[i14] << 14);
                        if (i17 >= 0) {
                            j10 = i17 ^ 16256;
                            i14 = i16;
                        } else {
                            i14 = i16 + 1;
                            int i18 = i17 ^ (bArr[i16] << 21);
                            if (i18 < 0) {
                                i10 = i18 ^ (-2080896);
                            } else {
                                long j13 = i18;
                                int i19 = i14 + 1;
                                long j14 = j13 ^ (bArr[i14] << 28);
                                if (j14 >= 0) {
                                    j12 = 266354560;
                                } else {
                                    i14 = i19 + 1;
                                    long j15 = j14 ^ (bArr[i19] << 35);
                                    if (j15 < 0) {
                                        j11 = -34093383808L;
                                    } else {
                                        i19 = i14 + 1;
                                        j14 = j15 ^ (bArr[i14] << 42);
                                        if (j14 >= 0) {
                                            j12 = 4363953127296L;
                                        } else {
                                            i14 = i19 + 1;
                                            j15 = j14 ^ (bArr[i19] << 49);
                                            if (j15 < 0) {
                                                j11 = -558586000294016L;
                                            } else {
                                                int i20 = i14 + 1;
                                                long j16 = (j15 ^ (bArr[i14] << 56)) ^ 71499008037633920L;
                                                i14 = j16 < 0 ? i20 + 1 : i20;
                                                j10 = j16;
                                            }
                                        }
                                    }
                                    j10 = j15 ^ j11;
                                }
                                j10 = j14 ^ j12;
                                i14 = i19;
                            }
                        }
                        this.f13256h = i14;
                        return j10;
                    }
                    j10 = i10;
                    this.f13256h = i14;
                    return j10;
                }
            }
            return Q();
        }

        long Q() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                byte L = L();
                j10 |= (L & Byte.MAX_VALUE) << i10;
                if ((L & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        public void S() throws IOException {
            int F;
            do {
                F = F();
                if (F == 0) {
                    return;
                }
            } while (I(F));
        }

        public void T(int i10) throws IOException {
            if (i10 >= 0) {
                int i11 = this.f13254f;
                int i12 = this.f13256h;
                if (i10 <= i11 - i12) {
                    this.f13256h = i12 + i10;
                    return;
                }
            }
            if (i10 < 0) {
                throw InvalidProtocolBufferException.h();
            }
            throw InvalidProtocolBufferException.k();
        }

        @Override // com.google.protobuf.i
        public void a(int i10) throws InvalidProtocolBufferException {
            if (this.f13258j != i10) {
                throw InvalidProtocolBufferException.a();
            }
        }

        @Override // com.google.protobuf.i
        public int d() {
            int i10 = this.f13260l;
            if (i10 == Integer.MAX_VALUE) {
                return -1;
            }
            return i10 - J();
        }

        @Override // com.google.protobuf.i
        public void j(int i10) {
            this.f13260l = i10;
            R();
        }

        @Override // com.google.protobuf.i
        public int k(int i10) throws InvalidProtocolBufferException {
            if (i10 >= 0) {
                int J = i10 + J();
                int i11 = this.f13260l;
                if (J <= i11) {
                    this.f13260l = J;
                    R();
                    return i11;
                }
                throw InvalidProtocolBufferException.k();
            }
            throw InvalidProtocolBufferException.h();
        }

        @Override // com.google.protobuf.i
        public boolean l() throws IOException {
            return P() != 0;
        }

        @Override // com.google.protobuf.i
        public ByteString m() throws IOException {
            ByteString byteString;
            int x10 = x();
            if (x10 > 0) {
                int i10 = this.f13254f;
                int i11 = this.f13256h;
                if (x10 <= i10 - i11) {
                    if (!this.f13253e || !this.f13259k) {
                        byteString = ByteString.copyFrom(this.f13252d, i11, x10);
                    } else {
                        byteString = ByteString.p(this.f13252d, i11, x10);
                    }
                    this.f13256h += x10;
                    return byteString;
                }
            }
            if (x10 == 0) {
                return ByteString.EMPTY;
            }
            return ByteString.o(M(x10));
        }

        @Override // com.google.protobuf.i
        public double n() throws IOException {
            return Double.longBitsToDouble(O());
        }

        @Override // com.google.protobuf.i
        public int o() throws IOException {
            return x();
        }

        @Override // com.google.protobuf.i
        public int p() throws IOException {
            return N();
        }

        @Override // com.google.protobuf.i
        public long q() throws IOException {
            return O();
        }

        @Override // com.google.protobuf.i
        public float r() throws IOException {
            return Float.intBitsToFloat(N());
        }

        @Override // com.google.protobuf.i
        public void s(int i10, e0.a aVar, q qVar) throws IOException {
            int i11 = this.f13249a;
            if (i11 < this.f13250b) {
                this.f13249a = i11 + 1;
                aVar.mergeFrom(this, qVar);
                a(WireFormat.c(i10, 4));
                this.f13249a--;
                return;
            }
            throw InvalidProtocolBufferException.i();
        }

        @Override // com.google.protobuf.i
        public int t() throws IOException {
            return x();
        }

        @Override // com.google.protobuf.i
        public long u() throws IOException {
            return P();
        }

        @Override // com.google.protobuf.i
        public <T extends e0> T v(l0<T> l0Var, q qVar) throws IOException {
            int x10 = x();
            if (this.f13249a < this.f13250b) {
                int k10 = k(x10);
                this.f13249a++;
                T parsePartialFrom = l0Var.parsePartialFrom(this, qVar);
                a(0);
                this.f13249a--;
                j(k10);
                return parsePartialFrom;
            }
            throw InvalidProtocolBufferException.i();
        }

        @Override // com.google.protobuf.i
        public void w(e0.a aVar, q qVar) throws IOException {
            int x10 = x();
            if (this.f13249a < this.f13250b) {
                int k10 = k(x10);
                this.f13249a++;
                aVar.mergeFrom(this, qVar);
                a(0);
                this.f13249a--;
                j(k10);
                return;
            }
            throw InvalidProtocolBufferException.i();
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
            if (r2[r3] < 0) goto L32;
         */
        @Override // com.google.protobuf.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int x() throws IOException {
            int i10;
            int i11 = this.f13256h;
            int i12 = this.f13254f;
            if (i12 != i11) {
                byte[] bArr = this.f13252d;
                int i13 = i11 + 1;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f13256h = i13;
                    return b10;
                } else if (i12 - i13 >= 9) {
                    int i14 = i13 + 1;
                    int i15 = b10 ^ (bArr[i13] << 7);
                    if (i15 < 0) {
                        i10 = i15 ^ (-128);
                    } else {
                        int i16 = i14 + 1;
                        int i17 = i15 ^ (bArr[i14] << 14);
                        if (i17 >= 0) {
                            i10 = i17 ^ 16256;
                        } else {
                            i14 = i16 + 1;
                            int i18 = i17 ^ (bArr[i16] << 21);
                            if (i18 < 0) {
                                i10 = i18 ^ (-2080896);
                            } else {
                                i16 = i14 + 1;
                                byte b11 = bArr[i14];
                                i10 = (i18 ^ (b11 << 28)) ^ 266354560;
                                if (b11 < 0) {
                                    i14 = i16 + 1;
                                    if (bArr[i16] < 0) {
                                        i16 = i14 + 1;
                                        if (bArr[i14] < 0) {
                                            i14 = i16 + 1;
                                            if (bArr[i16] < 0) {
                                                i16 = i14 + 1;
                                                if (bArr[i14] < 0) {
                                                    i14 = i16 + 1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i14 = i16;
                    }
                    this.f13256h = i14;
                    return i10;
                }
            }
            return (int) Q();
        }

        @Override // com.google.protobuf.i
        public int z() throws IOException {
            return N();
        }

        private b(byte[] bArr, int i10, int i11, boolean z10) {
            super();
            this.f13260l = Integer.MAX_VALUE;
            this.f13252d = bArr;
            this.f13254f = i11 + i10;
            this.f13256h = i10;
            this.f13257i = i10;
            this.f13253e = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CodedInputStream.java */
    /* loaded from: classes.dex */
    public static final class c extends i {

        /* renamed from: d  reason: collision with root package name */
        private final InputStream f13261d;

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f13262e;

        /* renamed from: f  reason: collision with root package name */
        private int f13263f;

        /* renamed from: g  reason: collision with root package name */
        private int f13264g;

        /* renamed from: h  reason: collision with root package name */
        private int f13265h;

        /* renamed from: i  reason: collision with root package name */
        private int f13266i;

        /* renamed from: j  reason: collision with root package name */
        private int f13267j;

        /* renamed from: k  reason: collision with root package name */
        private int f13268k;

        /* renamed from: l  reason: collision with root package name */
        private a f13269l;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: CodedInputStream.java */
        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        private byte[] L(int i10) throws IOException {
            if (i10 == 0) {
                return u.f13366c;
            }
            if (i10 >= 0) {
                int i11 = this.f13267j;
                int i12 = this.f13265h;
                int i13 = i11 + i12 + i10;
                if (i13 <= this.f13251c) {
                    int i14 = this.f13268k;
                    if (i13 <= i14) {
                        int i15 = this.f13263f;
                        int i16 = i15 - i12;
                        this.f13267j = i11 + i15;
                        this.f13265h = 0;
                        this.f13263f = 0;
                        int i17 = i10 - i16;
                        if (i17 < 4096 || i17 <= this.f13261d.available()) {
                            byte[] bArr = new byte[i10];
                            System.arraycopy(this.f13262e, i12, bArr, 0, i16);
                            while (i16 < i10) {
                                int read = this.f13261d.read(bArr, i16, i10 - i16);
                                if (read != -1) {
                                    this.f13267j += read;
                                    i16 += read;
                                } else {
                                    throw InvalidProtocolBufferException.k();
                                }
                            }
                            return bArr;
                        }
                        ArrayList<byte[]> arrayList = new ArrayList();
                        while (i17 > 0) {
                            int min = Math.min(i17, 4096);
                            byte[] bArr2 = new byte[min];
                            int i18 = 0;
                            while (i18 < min) {
                                int read2 = this.f13261d.read(bArr2, i18, min - i18);
                                if (read2 != -1) {
                                    this.f13267j += read2;
                                    i18 += read2;
                                } else {
                                    throw InvalidProtocolBufferException.k();
                                }
                            }
                            i17 -= min;
                            arrayList.add(bArr2);
                        }
                        byte[] bArr3 = new byte[i10];
                        System.arraycopy(this.f13262e, i12, bArr3, 0, i16);
                        for (byte[] bArr4 : arrayList) {
                            System.arraycopy(bArr4, 0, bArr3, i16, bArr4.length);
                            i16 += bArr4.length;
                        }
                        return bArr3;
                    }
                    T((i14 - i11) - i12);
                    throw InvalidProtocolBufferException.k();
                }
                throw InvalidProtocolBufferException.j();
            }
            throw InvalidProtocolBufferException.h();
        }

        private void Q() {
            int i10 = this.f13263f + this.f13264g;
            this.f13263f = i10;
            int i11 = this.f13267j + i10;
            int i12 = this.f13268k;
            if (i11 > i12) {
                int i13 = i11 - i12;
                this.f13264g = i13;
                this.f13263f = i10 - i13;
                return;
            }
            this.f13264g = 0;
        }

        private void R(int i10) throws IOException {
            if (!Y(i10)) {
                throw InvalidProtocolBufferException.k();
            }
        }

        private void U(int i10) throws IOException {
            if (i10 >= 0) {
                int i11 = this.f13267j;
                int i12 = this.f13265h;
                int i13 = i11 + i12 + i10;
                int i14 = this.f13268k;
                if (i13 <= i14) {
                    int i15 = this.f13263f;
                    int i16 = i15 - i12;
                    this.f13265h = i15;
                    R(1);
                    while (true) {
                        int i17 = i10 - i16;
                        int i18 = this.f13263f;
                        if (i17 > i18) {
                            i16 += i18;
                            this.f13265h = i18;
                            R(1);
                        } else {
                            this.f13265h = i17;
                            return;
                        }
                    }
                } else {
                    T((i14 - i11) - i12);
                    throw InvalidProtocolBufferException.k();
                }
            } else {
                throw InvalidProtocolBufferException.h();
            }
        }

        private void V() throws IOException {
            if (this.f13263f - this.f13265h >= 10) {
                W();
            } else {
                X();
            }
        }

        private void W() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                byte[] bArr = this.f13262e;
                int i11 = this.f13265h;
                this.f13265h = i11 + 1;
                if (bArr[i11] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        private void X() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                if (K() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        private boolean Y(int i10) throws IOException {
            int i11 = this.f13265h;
            if (i11 + i10 <= this.f13263f) {
                throw new IllegalStateException("refillBuffer() called when " + i10 + " bytes were already available in buffer");
            } else if (this.f13267j + i11 + i10 > this.f13268k) {
                return false;
            } else {
                a aVar = this.f13269l;
                if (aVar != null) {
                    aVar.a();
                }
                int i12 = this.f13265h;
                if (i12 > 0) {
                    int i13 = this.f13263f;
                    if (i13 > i12) {
                        byte[] bArr = this.f13262e;
                        System.arraycopy(bArr, i12, bArr, 0, i13 - i12);
                    }
                    this.f13267j += i12;
                    this.f13263f -= i12;
                    this.f13265h = 0;
                }
                InputStream inputStream = this.f13261d;
                byte[] bArr2 = this.f13262e;
                int i14 = this.f13263f;
                int read = inputStream.read(bArr2, i14, bArr2.length - i14);
                if (read == 0 || read < -1 || read > this.f13262e.length) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.f13263f += read;
                    if ((this.f13267j + i10) - this.f13251c <= 0) {
                        Q();
                        if (this.f13263f >= i10) {
                            return true;
                        }
                        return Y(i10);
                    }
                    throw InvalidProtocolBufferException.j();
                }
            }
        }

        @Override // com.google.protobuf.i
        public long A() throws IOException {
            return N();
        }

        @Override // com.google.protobuf.i
        public int B() throws IOException {
            return i.b(x());
        }

        @Override // com.google.protobuf.i
        public long C() throws IOException {
            return i.c(O());
        }

        @Override // com.google.protobuf.i
        public String D() throws IOException {
            int x10 = x();
            if (x10 > 0) {
                int i10 = this.f13263f;
                int i11 = this.f13265h;
                if (x10 <= i10 - i11) {
                    String str = new String(this.f13262e, i11, x10, u.f13364a);
                    this.f13265h += x10;
                    return str;
                }
            }
            if (x10 == 0) {
                return "";
            }
            if (x10 > this.f13263f) {
                return new String(L(x10), u.f13364a);
            }
            R(x10);
            String str2 = new String(this.f13262e, this.f13265h, x10, u.f13364a);
            this.f13265h += x10;
            return str2;
        }

        @Override // com.google.protobuf.i
        public String E() throws IOException {
            byte[] bArr;
            int x10 = x();
            int i10 = this.f13265h;
            int i11 = this.f13263f;
            int i12 = i11 - i10;
            i10 = 0;
            if (x10 <= i12 && x10 > 0) {
                bArr = this.f13262e;
                this.f13265h = i10 + x10;
            } else if (x10 == 0) {
                return "";
            } else {
                if (x10 <= i11) {
                    R(x10);
                    bArr = this.f13262e;
                    this.f13265h = x10 + 0;
                } else {
                    bArr = L(x10);
                }
            }
            if (d1.m(bArr, i10, i10 + x10)) {
                return new String(bArr, i10, x10, u.f13364a);
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.i
        public int F() throws IOException {
            if (J()) {
                this.f13266i = 0;
                return 0;
            }
            int x10 = x();
            this.f13266i = x10;
            if (WireFormat.a(x10) != 0) {
                return this.f13266i;
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // com.google.protobuf.i
        public int G() throws IOException {
            return x();
        }

        @Override // com.google.protobuf.i
        public long H() throws IOException {
            return O();
        }

        @Override // com.google.protobuf.i
        public boolean I(int i10) throws IOException {
            int b10 = WireFormat.b(i10);
            if (b10 == 0) {
                V();
                return true;
            } else if (b10 == 1) {
                T(8);
                return true;
            } else if (b10 == 2) {
                T(x());
                return true;
            } else if (b10 == 3) {
                S();
                a(WireFormat.c(WireFormat.a(i10), 4));
                return true;
            } else if (b10 == 4) {
                return false;
            } else {
                if (b10 == 5) {
                    T(4);
                    return true;
                }
                throw InvalidProtocolBufferException.d();
            }
        }

        public boolean J() throws IOException {
            return this.f13265h == this.f13263f && !Y(1);
        }

        public byte K() throws IOException {
            if (this.f13265h == this.f13263f) {
                R(1);
            }
            byte[] bArr = this.f13262e;
            int i10 = this.f13265h;
            this.f13265h = i10 + 1;
            return bArr[i10];
        }

        public int M() throws IOException {
            int i10 = this.f13265h;
            if (this.f13263f - i10 < 4) {
                R(4);
                i10 = this.f13265h;
            }
            byte[] bArr = this.f13262e;
            this.f13265h = i10 + 4;
            return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
        }

        public long N() throws IOException {
            int i10 = this.f13265h;
            if (this.f13263f - i10 < 8) {
                R(8);
                i10 = this.f13265h;
            }
            byte[] bArr = this.f13262e;
            this.f13265h = i10 + 8;
            return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x00b4, code lost:
            if (r2[r0] < 0) goto L38;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long O() throws IOException {
            long j10;
            long j11;
            long j12;
            int i10;
            int i11 = this.f13265h;
            int i12 = this.f13263f;
            if (i12 != i11) {
                byte[] bArr = this.f13262e;
                int i13 = i11 + 1;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f13265h = i13;
                    return b10;
                } else if (i12 - i13 >= 9) {
                    int i14 = i13 + 1;
                    int i15 = b10 ^ (bArr[i13] << 7);
                    if (i15 < 0) {
                        i10 = i15 ^ (-128);
                    } else {
                        int i16 = i14 + 1;
                        int i17 = i15 ^ (bArr[i14] << 14);
                        if (i17 >= 0) {
                            j10 = i17 ^ 16256;
                            i14 = i16;
                        } else {
                            i14 = i16 + 1;
                            int i18 = i17 ^ (bArr[i16] << 21);
                            if (i18 < 0) {
                                i10 = i18 ^ (-2080896);
                            } else {
                                long j13 = i18;
                                int i19 = i14 + 1;
                                long j14 = j13 ^ (bArr[i14] << 28);
                                if (j14 >= 0) {
                                    j12 = 266354560;
                                } else {
                                    i14 = i19 + 1;
                                    long j15 = j14 ^ (bArr[i19] << 35);
                                    if (j15 < 0) {
                                        j11 = -34093383808L;
                                    } else {
                                        i19 = i14 + 1;
                                        j14 = j15 ^ (bArr[i14] << 42);
                                        if (j14 >= 0) {
                                            j12 = 4363953127296L;
                                        } else {
                                            i14 = i19 + 1;
                                            j15 = j14 ^ (bArr[i19] << 49);
                                            if (j15 < 0) {
                                                j11 = -558586000294016L;
                                            } else {
                                                int i20 = i14 + 1;
                                                long j16 = (j15 ^ (bArr[i14] << 56)) ^ 71499008037633920L;
                                                i14 = j16 < 0 ? i20 + 1 : i20;
                                                j10 = j16;
                                            }
                                        }
                                    }
                                    j10 = j15 ^ j11;
                                }
                                j10 = j14 ^ j12;
                                i14 = i19;
                            }
                        }
                        this.f13265h = i14;
                        return j10;
                    }
                    j10 = i10;
                    this.f13265h = i14;
                    return j10;
                }
            }
            return P();
        }

        long P() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                byte K = K();
                j10 |= (K & Byte.MAX_VALUE) << i10;
                if ((K & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        public void S() throws IOException {
            int F;
            do {
                F = F();
                if (F == 0) {
                    return;
                }
            } while (I(F));
        }

        public void T(int i10) throws IOException {
            int i11 = this.f13263f;
            int i12 = this.f13265h;
            if (i10 > i11 - i12 || i10 < 0) {
                U(i10);
            } else {
                this.f13265h = i12 + i10;
            }
        }

        @Override // com.google.protobuf.i
        public void a(int i10) throws InvalidProtocolBufferException {
            if (this.f13266i != i10) {
                throw InvalidProtocolBufferException.a();
            }
        }

        @Override // com.google.protobuf.i
        public int d() {
            int i10 = this.f13268k;
            if (i10 == Integer.MAX_VALUE) {
                return -1;
            }
            return i10 - (this.f13267j + this.f13265h);
        }

        @Override // com.google.protobuf.i
        public void j(int i10) {
            this.f13268k = i10;
            Q();
        }

        @Override // com.google.protobuf.i
        public int k(int i10) throws InvalidProtocolBufferException {
            if (i10 >= 0) {
                int i11 = i10 + this.f13267j + this.f13265h;
                int i12 = this.f13268k;
                if (i11 <= i12) {
                    this.f13268k = i11;
                    Q();
                    return i12;
                }
                throw InvalidProtocolBufferException.k();
            }
            throw InvalidProtocolBufferException.h();
        }

        @Override // com.google.protobuf.i
        public boolean l() throws IOException {
            return O() != 0;
        }

        @Override // com.google.protobuf.i
        public ByteString m() throws IOException {
            int x10 = x();
            int i10 = this.f13263f;
            int i11 = this.f13265h;
            if (x10 <= i10 - i11 && x10 > 0) {
                ByteString copyFrom = ByteString.copyFrom(this.f13262e, i11, x10);
                this.f13265h += x10;
                return copyFrom;
            } else if (x10 == 0) {
                return ByteString.EMPTY;
            } else {
                return ByteString.o(L(x10));
            }
        }

        @Override // com.google.protobuf.i
        public double n() throws IOException {
            return Double.longBitsToDouble(N());
        }

        @Override // com.google.protobuf.i
        public int o() throws IOException {
            return x();
        }

        @Override // com.google.protobuf.i
        public int p() throws IOException {
            return M();
        }

        @Override // com.google.protobuf.i
        public long q() throws IOException {
            return N();
        }

        @Override // com.google.protobuf.i
        public float r() throws IOException {
            return Float.intBitsToFloat(M());
        }

        @Override // com.google.protobuf.i
        public void s(int i10, e0.a aVar, q qVar) throws IOException {
            int i11 = this.f13249a;
            if (i11 < this.f13250b) {
                this.f13249a = i11 + 1;
                aVar.mergeFrom(this, qVar);
                a(WireFormat.c(i10, 4));
                this.f13249a--;
                return;
            }
            throw InvalidProtocolBufferException.i();
        }

        @Override // com.google.protobuf.i
        public int t() throws IOException {
            return x();
        }

        @Override // com.google.protobuf.i
        public long u() throws IOException {
            return O();
        }

        @Override // com.google.protobuf.i
        public <T extends e0> T v(l0<T> l0Var, q qVar) throws IOException {
            int x10 = x();
            if (this.f13249a < this.f13250b) {
                int k10 = k(x10);
                this.f13249a++;
                T parsePartialFrom = l0Var.parsePartialFrom(this, qVar);
                a(0);
                this.f13249a--;
                j(k10);
                return parsePartialFrom;
            }
            throw InvalidProtocolBufferException.i();
        }

        @Override // com.google.protobuf.i
        public void w(e0.a aVar, q qVar) throws IOException {
            int x10 = x();
            if (this.f13249a < this.f13250b) {
                int k10 = k(x10);
                this.f13249a++;
                aVar.mergeFrom(this, qVar);
                a(0);
                this.f13249a--;
                j(k10);
                return;
            }
            throw InvalidProtocolBufferException.i();
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
            if (r2[r3] < 0) goto L32;
         */
        @Override // com.google.protobuf.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int x() throws IOException {
            int i10;
            int i11 = this.f13265h;
            int i12 = this.f13263f;
            if (i12 != i11) {
                byte[] bArr = this.f13262e;
                int i13 = i11 + 1;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f13265h = i13;
                    return b10;
                } else if (i12 - i13 >= 9) {
                    int i14 = i13 + 1;
                    int i15 = b10 ^ (bArr[i13] << 7);
                    if (i15 < 0) {
                        i10 = i15 ^ (-128);
                    } else {
                        int i16 = i14 + 1;
                        int i17 = i15 ^ (bArr[i14] << 14);
                        if (i17 >= 0) {
                            i10 = i17 ^ 16256;
                        } else {
                            i14 = i16 + 1;
                            int i18 = i17 ^ (bArr[i16] << 21);
                            if (i18 < 0) {
                                i10 = i18 ^ (-2080896);
                            } else {
                                i16 = i14 + 1;
                                byte b11 = bArr[i14];
                                i10 = (i18 ^ (b11 << 28)) ^ 266354560;
                                if (b11 < 0) {
                                    i14 = i16 + 1;
                                    if (bArr[i16] < 0) {
                                        i16 = i14 + 1;
                                        if (bArr[i14] < 0) {
                                            i14 = i16 + 1;
                                            if (bArr[i16] < 0) {
                                                i16 = i14 + 1;
                                                if (bArr[i14] < 0) {
                                                    i14 = i16 + 1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i14 = i16;
                    }
                    this.f13265h = i14;
                    return i10;
                }
            }
            return (int) P();
        }

        @Override // com.google.protobuf.i
        public int z() throws IOException {
            return M();
        }

        private c(InputStream inputStream, int i10) {
            super();
            this.f13268k = Integer.MAX_VALUE;
            this.f13269l = null;
            u.a(inputStream, "input");
            this.f13261d = inputStream;
            this.f13262e = new byte[i10];
            this.f13263f = 0;
            this.f13265h = 0;
            this.f13267j = 0;
        }
    }

    public static int b(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public static long c(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static i e(InputStream inputStream) {
        return f(inputStream, 4096);
    }

    static i f(InputStream inputStream, int i10) {
        if (inputStream == null) {
            return g(u.f13366c);
        }
        return new c(inputStream, i10);
    }

    public static i g(byte[] bArr) {
        return h(bArr, 0, bArr.length);
    }

    public static i h(byte[] bArr, int i10, int i11) {
        return i(bArr, i10, i11, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i i(byte[] bArr, int i10, int i11, boolean z10) {
        b bVar = new b(bArr, i10, i11, z10);
        try {
            bVar.k(i11);
            return bVar;
        } catch (InvalidProtocolBufferException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static int y(int i10, InputStream inputStream) throws IOException {
        if ((i10 & 128) == 0) {
            return i10;
        }
        int i11 = i10 & 127;
        int i12 = 7;
        while (i12 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i11 |= (read & 127) << i12;
                if ((read & 128) == 0) {
                    return i11;
                }
                i12 += 7;
            } else {
                throw InvalidProtocolBufferException.k();
            }
        }
        while (i12 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.k();
            } else if ((read2 & 128) == 0) {
                return i11;
            } else {
                i12 += 7;
            }
        }
        throw InvalidProtocolBufferException.g();
    }

    public abstract long A() throws IOException;

    public abstract int B() throws IOException;

    public abstract long C() throws IOException;

    public abstract String D() throws IOException;

    public abstract String E() throws IOException;

    public abstract int F() throws IOException;

    public abstract int G() throws IOException;

    public abstract long H() throws IOException;

    public abstract boolean I(int i10) throws IOException;

    public abstract void a(int i10) throws InvalidProtocolBufferException;

    public abstract int d();

    public abstract void j(int i10);

    public abstract int k(int i10) throws InvalidProtocolBufferException;

    public abstract boolean l() throws IOException;

    public abstract ByteString m() throws IOException;

    public abstract double n() throws IOException;

    public abstract int o() throws IOException;

    public abstract int p() throws IOException;

    public abstract long q() throws IOException;

    public abstract float r() throws IOException;

    public abstract void s(int i10, e0.a aVar, q qVar) throws IOException;

    public abstract int t() throws IOException;

    public abstract long u() throws IOException;

    public abstract <T extends e0> T v(l0<T> l0Var, q qVar) throws IOException;

    public abstract void w(e0.a aVar, q qVar) throws IOException;

    public abstract int x() throws IOException;

    public abstract int z() throws IOException;

    private i() {
        this.f13250b = 100;
        this.f13251c = 67108864;
    }
}
