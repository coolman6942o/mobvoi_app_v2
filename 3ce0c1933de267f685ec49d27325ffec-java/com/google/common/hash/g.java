package com.google.common.hash;

import com.google.common.base.p;
import com.google.common.hash.BloomFilter;
import com.google.common.math.e;
import com.google.common.primitives.d;
import com.google.common.primitives.f;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* compiled from: BloomFilterStrategies.java */
/* loaded from: classes.dex */
abstract class g extends Enum<g> implements BloomFilter.a {
    public static final g MURMUR128_MITZ_32 = new a("MURMUR128_MITZ_32", 0);
    public static final g MURMUR128_MITZ_64 = new g("MURMUR128_MITZ_64", 1) { // from class: com.google.common.hash.g.b
        private long b(byte[] bArr) {
            return f.d(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long c(byte[] bArr) {
            return f.d(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.a
        public <T> boolean e(T t10, Funnel<? super T> funnel, int i10, c cVar) {
            long b10 = cVar.b();
            byte[] i11 = k.a().b(t10, funnel).i();
            long b11 = b(i11);
            long c10 = c(i11);
            for (int i12 = 0; i12 < i10; i12++) {
                if (!cVar.d((Long.MAX_VALUE & b11) % b10)) {
                    return false;
                }
                b11 += c10;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.a
        public <T> boolean f(T t10, Funnel<? super T> funnel, int i10, c cVar) {
            long b10 = cVar.b();
            byte[] i11 = k.a().b(t10, funnel).i();
            long b11 = b(i11);
            long c10 = c(i11);
            boolean z10 = false;
            for (int i12 = 0; i12 < i10; i12++) {
                z10 |= cVar.f((Long.MAX_VALUE & b11) % b10);
                b11 += c10;
            }
            return z10;
        }
    };
    private static final /* synthetic */ g[] $VALUES = a();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: BloomFilterStrategies.java */
    /* loaded from: classes.dex */
    final class a extends g {
        a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // com.google.common.hash.BloomFilter.a
        public <T> boolean e(T t10, Funnel<? super T> funnel, int i10, c cVar) {
            long b10 = cVar.b();
            long c10 = k.a().b(t10, funnel).c();
            int i11 = (int) c10;
            int i12 = (int) (c10 >>> 32);
            for (int i13 = 1; i13 <= i10; i13++) {
                int i14 = (i13 * i12) + i11;
                if (i14 < 0) {
                    i14 = ~i14;
                }
                if (!cVar.d(i14 % b10)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.a
        public <T> boolean f(T t10, Funnel<? super T> funnel, int i10, c cVar) {
            long b10 = cVar.b();
            long c10 = k.a().b(t10, funnel).c();
            int i11 = (int) c10;
            int i12 = (int) (c10 >>> 32);
            boolean z10 = false;
            for (int i13 = 1; i13 <= i10; i13++) {
                int i14 = (i13 * i12) + i11;
                if (i14 < 0) {
                    i14 = ~i14;
                }
                z10 |= cVar.f(i14 % b10);
            }
            return z10;
        }
    }

    private g(String str, int i10) {
    }

    private static /* synthetic */ g[] a() {
        return new g[]{MURMUR128_MITZ_32, MURMUR128_MITZ_64};
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) $VALUES.clone();
    }

    /* synthetic */ g(String str, int i10, a aVar) {
        this(str, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BloomFilterStrategies.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final AtomicLongArray f12315a;

        /* renamed from: b  reason: collision with root package name */
        private final m f12316b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(long j10) {
            p.e(j10 > 0, "data length is zero!");
            this.f12315a = new AtomicLongArray(d.c(e.a(j10, 64L, RoundingMode.CEILING)));
            this.f12316b = n.a();
        }

        public static long[] g(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i10 = 0; i10 < length; i10++) {
                jArr[i10] = atomicLongArray.get(i10);
            }
            return jArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long a() {
            return this.f12316b.b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long b() {
            return this.f12315a.length() * 64;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c c() {
            return new c(g(this.f12315a));
        }

        boolean d(long j10) {
            return ((1 << ((int) j10)) & this.f12315a.get((int) (j10 >>> 6))) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void e(c cVar) {
            long j10;
            long j11;
            boolean z10;
            p.g(this.f12315a.length() == cVar.f12315a.length(), "BitArrays must be of equal length (%s != %s)", this.f12315a.length(), cVar.f12315a.length());
            for (int i10 = 0; i10 < this.f12315a.length(); i10++) {
                long j12 = cVar.f12315a.get(i10);
                while (true) {
                    j10 = this.f12315a.get(i10);
                    j11 = j10 | j12;
                    if (j10 != j11) {
                        if (this.f12315a.compareAndSet(i10, j10, j11)) {
                            z10 = true;
                            break;
                        }
                    } else {
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    this.f12316b.c(Long.bitCount(j11) - Long.bitCount(j10));
                }
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return Arrays.equals(g(this.f12315a), g(((c) obj).f12315a));
            }
            return false;
        }

        boolean f(long j10) {
            long j11;
            long j12;
            if (d(j10)) {
                return false;
            }
            int i10 = (int) (j10 >>> 6);
            long j13 = 1 << ((int) j10);
            do {
                j11 = this.f12315a.get(i10);
                j12 = j11 | j13;
                if (j11 == j12) {
                    return false;
                }
            } while (!this.f12315a.compareAndSet(i10, j11, j12));
            this.f12316b.a();
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(g(this.f12315a));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(long[] jArr) {
            p.e(jArr.length > 0, "data length is zero!");
            this.f12315a = new AtomicLongArray(jArr);
            this.f12316b = n.a();
            long j10 = 0;
            for (long j11 : jArr) {
                j10 += Long.bitCount(j11);
            }
            this.f12316b.c(j10);
        }
    }
}
