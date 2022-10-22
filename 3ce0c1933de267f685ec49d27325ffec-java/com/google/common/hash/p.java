package com.google.common.hash;

import com.google.common.primitives.i;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Murmur3_128HashFunction.java */
/* loaded from: classes.dex */
public final class p extends com.google.common.hash.a implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;
    static final i MURMUR3_128 = new p(0);
    static final i GOOD_FAST_HASH_128 = new p(k.f12317a);

    /* compiled from: Murmur3_128HashFunction.java */
    /* loaded from: classes.dex */
    private static final class a extends c {

        /* renamed from: c  reason: collision with root package name */
        private long f12319c;

        /* renamed from: d  reason: collision with root package name */
        private long f12320d;

        /* renamed from: e  reason: collision with root package name */
        private int f12321e = 0;

        a(int i10) {
            super(16);
            long j10 = i10;
            this.f12319c = j10;
            this.f12320d = j10;
        }

        private void g(long j10, long j11) {
            long i10 = i(j10) ^ this.f12319c;
            this.f12319c = i10;
            long rotateLeft = Long.rotateLeft(i10, 27);
            this.f12319c = rotateLeft;
            long j12 = this.f12320d;
            long j13 = rotateLeft + j12;
            this.f12319c = j13;
            this.f12319c = (j13 * 5) + 1390208809;
            long j14 = j(j11) ^ j12;
            this.f12320d = j14;
            long rotateLeft2 = Long.rotateLeft(j14, 31);
            this.f12320d = rotateLeft2;
            long j15 = rotateLeft2 + this.f12319c;
            this.f12320d = j15;
            this.f12320d = (j15 * 5) + 944331445;
        }

        private static long h(long j10) {
            long j11 = (j10 ^ (j10 >>> 33)) * (-49064778989728563L);
            long j12 = (j11 ^ (j11 >>> 33)) * (-4265267296055464877L);
            return j12 ^ (j12 >>> 33);
        }

        private static long i(long j10) {
            return Long.rotateLeft(j10 * (-8663945395140668459L), 31) * 5545529020109919103L;
        }

        private static long j(long j10) {
            return Long.rotateLeft(j10 * 5545529020109919103L, 33) * (-8663945395140668459L);
        }

        @Override // com.google.common.hash.c
        protected h c() {
            long j10 = this.f12319c;
            int i10 = this.f12321e;
            long j11 = j10 ^ i10;
            this.f12319c = j11;
            long j12 = this.f12320d ^ i10;
            this.f12320d = j12;
            long j13 = j11 + j12;
            this.f12319c = j13;
            this.f12320d = j12 + j13;
            this.f12319c = h(j13);
            long h10 = h(this.f12320d);
            this.f12320d = h10;
            long j14 = this.f12319c + h10;
            this.f12319c = j14;
            this.f12320d = h10 + j14;
            return h.h(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f12319c).putLong(this.f12320d).array());
        }

        @Override // com.google.common.hash.c
        protected void e(ByteBuffer byteBuffer) {
            g(byteBuffer.getLong(), byteBuffer.getLong());
            this.f12321e += 16;
        }

        @Override // com.google.common.hash.c
        protected void f(ByteBuffer byteBuffer) {
            long j10;
            long j11;
            long j12;
            long j13;
            long j14;
            long j15;
            long j16;
            long j17;
            long j18;
            long j19;
            long j20;
            long j21;
            long j22;
            long j23;
            this.f12321e += byteBuffer.remaining();
            long j24 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j11 = 0;
                    j10 = i.b(byteBuffer.get(0)) ^ j11;
                    this.f12319c ^= i(j10);
                    this.f12320d ^= j(j24);
                    return;
                case 2:
                    j12 = 0;
                    j11 = j12 ^ (i.b(byteBuffer.get(1)) << 8);
                    j10 = i.b(byteBuffer.get(0)) ^ j11;
                    this.f12319c ^= i(j10);
                    this.f12320d ^= j(j24);
                    return;
                case 3:
                    j13 = 0;
                    j12 = j13 ^ (i.b(byteBuffer.get(2)) << 16);
                    j11 = j12 ^ (i.b(byteBuffer.get(1)) << 8);
                    j10 = i.b(byteBuffer.get(0)) ^ j11;
                    this.f12319c ^= i(j10);
                    this.f12320d ^= j(j24);
                    return;
                case 4:
                    j14 = 0;
                    j13 = j14 ^ (i.b(byteBuffer.get(3)) << 24);
                    j12 = j13 ^ (i.b(byteBuffer.get(2)) << 16);
                    j11 = j12 ^ (i.b(byteBuffer.get(1)) << 8);
                    j10 = i.b(byteBuffer.get(0)) ^ j11;
                    this.f12319c ^= i(j10);
                    this.f12320d ^= j(j24);
                    return;
                case 5:
                    j15 = 0;
                    j14 = j15 ^ (i.b(byteBuffer.get(4)) << 32);
                    j13 = j14 ^ (i.b(byteBuffer.get(3)) << 24);
                    j12 = j13 ^ (i.b(byteBuffer.get(2)) << 16);
                    j11 = j12 ^ (i.b(byteBuffer.get(1)) << 8);
                    j10 = i.b(byteBuffer.get(0)) ^ j11;
                    this.f12319c ^= i(j10);
                    this.f12320d ^= j(j24);
                    return;
                case 6:
                    j16 = 0;
                    j15 = j16 ^ (i.b(byteBuffer.get(5)) << 40);
                    j14 = j15 ^ (i.b(byteBuffer.get(4)) << 32);
                    j13 = j14 ^ (i.b(byteBuffer.get(3)) << 24);
                    j12 = j13 ^ (i.b(byteBuffer.get(2)) << 16);
                    j11 = j12 ^ (i.b(byteBuffer.get(1)) << 8);
                    j10 = i.b(byteBuffer.get(0)) ^ j11;
                    this.f12319c ^= i(j10);
                    this.f12320d ^= j(j24);
                    return;
                case 7:
                    j16 = (i.b(byteBuffer.get(6)) << 48) ^ 0;
                    j15 = j16 ^ (i.b(byteBuffer.get(5)) << 40);
                    j14 = j15 ^ (i.b(byteBuffer.get(4)) << 32);
                    j13 = j14 ^ (i.b(byteBuffer.get(3)) << 24);
                    j12 = j13 ^ (i.b(byteBuffer.get(2)) << 16);
                    j11 = j12 ^ (i.b(byteBuffer.get(1)) << 8);
                    j10 = i.b(byteBuffer.get(0)) ^ j11;
                    this.f12319c ^= i(j10);
                    this.f12320d ^= j(j24);
                    return;
                case 8:
                    j17 = 0;
                    j10 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f12319c ^= i(j10);
                    this.f12320d ^= j(j24);
                    return;
                case 9:
                    j18 = 0;
                    j17 = j18 ^ i.b(byteBuffer.get(8));
                    j10 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f12319c ^= i(j10);
                    this.f12320d ^= j(j24);
                    return;
                case 10:
                    j19 = 0;
                    j18 = j19 ^ (i.b(byteBuffer.get(9)) << 8);
                    j17 = j18 ^ i.b(byteBuffer.get(8));
                    j10 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f12319c ^= i(j10);
                    this.f12320d ^= j(j24);
                    return;
                case 11:
                    j20 = 0;
                    j19 = j20 ^ (i.b(byteBuffer.get(10)) << 16);
                    j18 = j19 ^ (i.b(byteBuffer.get(9)) << 8);
                    j17 = j18 ^ i.b(byteBuffer.get(8));
                    j10 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f12319c ^= i(j10);
                    this.f12320d ^= j(j24);
                    return;
                case 12:
                    j21 = 0;
                    j20 = j21 ^ (i.b(byteBuffer.get(11)) << 24);
                    j19 = j20 ^ (i.b(byteBuffer.get(10)) << 16);
                    j18 = j19 ^ (i.b(byteBuffer.get(9)) << 8);
                    j17 = j18 ^ i.b(byteBuffer.get(8));
                    j10 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f12319c ^= i(j10);
                    this.f12320d ^= j(j24);
                    return;
                case 13:
                    j22 = 0;
                    j21 = j22 ^ (i.b(byteBuffer.get(12)) << 32);
                    j20 = j21 ^ (i.b(byteBuffer.get(11)) << 24);
                    j19 = j20 ^ (i.b(byteBuffer.get(10)) << 16);
                    j18 = j19 ^ (i.b(byteBuffer.get(9)) << 8);
                    j17 = j18 ^ i.b(byteBuffer.get(8));
                    j10 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f12319c ^= i(j10);
                    this.f12320d ^= j(j24);
                    return;
                case 14:
                    j23 = 0;
                    j22 = j23 ^ (i.b(byteBuffer.get(13)) << 40);
                    j21 = j22 ^ (i.b(byteBuffer.get(12)) << 32);
                    j20 = j21 ^ (i.b(byteBuffer.get(11)) << 24);
                    j19 = j20 ^ (i.b(byteBuffer.get(10)) << 16);
                    j18 = j19 ^ (i.b(byteBuffer.get(9)) << 8);
                    j17 = j18 ^ i.b(byteBuffer.get(8));
                    j10 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f12319c ^= i(j10);
                    this.f12320d ^= j(j24);
                    return;
                case 15:
                    j23 = (i.b(byteBuffer.get(14)) << 48) ^ 0;
                    j22 = j23 ^ (i.b(byteBuffer.get(13)) << 40);
                    j21 = j22 ^ (i.b(byteBuffer.get(12)) << 32);
                    j20 = j21 ^ (i.b(byteBuffer.get(11)) << 24);
                    j19 = j20 ^ (i.b(byteBuffer.get(10)) << 16);
                    j18 = j19 ^ (i.b(byteBuffer.get(9)) << 8);
                    j17 = j18 ^ i.b(byteBuffer.get(8));
                    j10 = byteBuffer.getLong() ^ 0;
                    j24 = j17;
                    this.f12319c ^= i(j10);
                    this.f12320d ^= j(j24);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }
    }

    p(int i10) {
        this.seed = i10;
    }

    @Override // com.google.common.hash.i
    public j a() {
        return new a(this.seed);
    }

    public boolean equals(Object obj) {
        return (obj instanceof p) && this.seed == ((p) obj).seed;
    }

    public int hashCode() {
        return p.class.hashCode() ^ this.seed;
    }

    public String toString() {
        int i10 = this.seed;
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("Hashing.murmur3_128(");
        sb2.append(i10);
        sb2.append(")");
        return sb2.toString();
    }
}
