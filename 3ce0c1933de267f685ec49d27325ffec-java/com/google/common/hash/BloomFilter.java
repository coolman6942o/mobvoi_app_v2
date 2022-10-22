package com.google.common.hash;

import com.google.common.base.m;
import com.google.common.base.p;
import com.google.common.base.q;
import com.google.common.base.r;
import com.google.common.hash.g;
import com.google.common.primitives.h;
import com.google.common.primitives.i;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.function.Supplier;
import java.util.stream.Collector;
/* loaded from: classes.dex */
public final class BloomFilter<T> implements r<T>, Serializable {
    private final g.c bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final a strategy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a extends Serializable {
        <T> boolean e(T t10, Funnel<? super T> funnel, int i10, g.c cVar);

        <T> boolean f(T t10, Funnel<? super T> funnel, int i10, g.c cVar);

        int ordinal();
    }

    private BloomFilter(g.c cVar, int i10, Funnel<? super T> funnel, a aVar) {
        boolean z10 = true;
        p.f(i10 > 0, "numHashFunctions (%s) must be > 0", i10);
        p.f(i10 > 255 ? false : z10, "numHashFunctions (%s) must be <= 255", i10);
        this.bits = (g.c) p.o(cVar);
        this.numHashFunctions = i10;
        this.funnel = (Funnel) p.o(funnel);
        this.strategy = (a) p.o(aVar);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i10, double d10) {
        return create(funnel, i10, d10);
    }

    static <T> BloomFilter<T> d(Funnel<? super T> funnel, long j10, double d10, a aVar) {
        p.o(funnel);
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        boolean z10 = true;
        p.h(i10 >= 0, "Expected insertions (%s) must be >= 0", j10);
        p.j(d10 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d10));
        if (d10 >= 1.0d) {
            z10 = false;
        }
        p.j(z10, "False positive probability (%s) must be < 1.0", Double.valueOf(d10));
        p.o(aVar);
        if (i10 == 0) {
            j10 = 1;
        }
        long i11 = i(j10, d10);
        try {
            return new BloomFilter<>(new g.c(i11), j(j10, i11), funnel, aVar);
        } catch (IllegalArgumentException e10) {
            StringBuilder sb2 = new StringBuilder(57);
            sb2.append("Could not create BloomFilter of ");
            sb2.append(i11);
            sb2.append(" bits");
            throw new IllegalArgumentException(sb2.toString(), e10);
        }
    }

    static long i(long j10, double d10) {
        if (d10 == 0.0d) {
            d10 = Double.MIN_VALUE;
        }
        return (long) (((-j10) * Math.log(d10)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    static int j(long j10, long j11) {
        return Math.max(1, (int) Math.round((j11 / j10) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) throws IOException {
        RuntimeException e10;
        int i10;
        int i11;
        p.p(inputStream, "InputStream");
        p.p(funnel, "Funnel");
        int i12 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte readByte = dataInputStream.readByte();
            try {
                i11 = i.b(dataInputStream.readByte());
            } catch (RuntimeException e11) {
                e10 = e11;
                i11 = -1;
                i12 = readByte;
                i10 = -1;
            }
            try {
                i12 = dataInputStream.readInt();
                g gVar = g.values()[readByte];
                long[] jArr = new long[i12];
                for (int i13 = 0; i13 < i12; i13++) {
                    jArr[i13] = dataInputStream.readLong();
                }
                return new BloomFilter<>(new g.c(jArr), i11, funnel, gVar);
            } catch (RuntimeException e12) {
                e10 = e12;
                i10 = i12;
                i12 = readByte;
                StringBuilder sb2 = new StringBuilder(134);
                sb2.append("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
                sb2.append(i12);
                sb2.append(" numHashFunctions: ");
                sb2.append(i11);
                sb2.append(" dataLength: ");
                sb2.append(i10);
                throw new IOException(sb2.toString(), e10);
            }
        } catch (RuntimeException e13) {
            e10 = e13;
            i10 = -1;
            i11 = -1;
        }
    }

    public static <T> Collector<T, ?, BloomFilter<T>> toBloomFilter(Funnel<? super T> funnel, long j10) {
        return toBloomFilter(funnel, j10, 0.03d);
    }

    @Override // com.google.common.base.r
    @Deprecated
    public boolean apply(T t10) {
        return mightContain(t10);
    }

    public long approximateElementCount() {
        double b10 = this.bits.b();
        return com.google.common.math.a.c(((-Math.log1p(-(this.bits.a() / b10))) * b10) / this.numHashFunctions, RoundingMode.HALF_UP);
    }

    long c() {
        return this.bits.b();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // com.google.common.base.r
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
    }

    public double expectedFpp() {
        return Math.pow(this.bits.a() / c(), this.numHashFunctions);
    }

    public int hashCode() {
        return m.b(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        p.o(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && c() == bloomFilter.c() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public boolean mightContain(T t10) {
        return this.strategy.e(t10, this.funnel, this.numHashFunctions, this.bits);
    }

    public boolean put(T t10) {
        return this.strategy.f(t10, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        p.o(bloomFilter);
        p.e(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        int i10 = this.numHashFunctions;
        int i11 = bloomFilter.numHashFunctions;
        p.g(i10 == i11, "BloomFilters must have the same number of hash functions (%s != %s)", i10, i11);
        p.i(c() == bloomFilter.c(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", c(), bloomFilter.c());
        p.k(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        p.k(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.e(bloomFilter.bits);
    }

    @Override // com.google.common.base.r, java.util.function.Predicate
    public /* bridge */ /* synthetic */ boolean test(T t10) {
        return q.a(this, t10);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(h.a(this.strategy.ordinal()));
        dataOutputStream.writeByte(i.a(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.f12315a.length());
        for (int i10 = 0; i10 < this.bits.f12315a.length(); i10++) {
            dataOutputStream.writeLong(this.bits.f12315a.get(i10));
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j10, double d10) {
        return d(funnel, j10, d10, g.MURMUR128_MITZ_64);
    }

    public static <T> Collector<T, ?, BloomFilter<T>> toBloomFilter(final Funnel<? super T> funnel, final long j10, final double d10) {
        p.o(funnel);
        p.h(j10 >= 0, "Expected insertions (%s) must be >= 0", j10);
        p.j(d10 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d10));
        p.j(d10 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d10));
        return Collector.of(new Supplier() { // from class: com.google.common.hash.f
            @Override // java.util.function.Supplier
            public final Object get() {
                BloomFilter create;
                create = BloomFilter.create(Funnel.this, j10, d10);
                return create;
            }
        }, d.f12310a, e.f12311a, Collector.Characteristics.UNORDERED, Collector.Characteristics.CONCURRENT);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i10) {
        return create(funnel, i10);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j10) {
        return create(funnel, j10, 0.03d);
    }
}
