package com.google.common.math;

import com.google.common.base.l;
import com.google.common.base.m;
import com.google.common.base.p;
import com.google.common.primitives.b;
import com.mobvoi.wear.contacts.ContactConstant;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
/* loaded from: classes.dex */
public final class Stats implements Serializable {
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Stats(long j10, double d10, double d11, double d12, double d13) {
        this.count = j10;
        this.mean = d10;
        this.sumOfSquaresOfDeltas = d11;
        this.min = d12;
        this.max = d13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(o oVar, Number number) {
        oVar.a(number.doubleValue());
    }

    public static Stats fromByteArray(byte[] bArr) {
        p.o(bArr);
        p.g(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return g(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Stats g(ByteBuffer byteBuffer) {
        p.o(byteBuffer);
        p.g(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public static double meanOf(Iterable<? extends Number> iterable) {
        return meanOf(iterable.iterator());
    }

    public static Stats of(Iterable<? extends Number> iterable) {
        o oVar = new o();
        oVar.c(iterable);
        return oVar.n();
    }

    public static Collector<Number, o, Stats> toStats() {
        return Collector.of(n.f12341a, h.f12335a, i.f12336a, j.f12337a, Collector.Characteristics.UNORDERED);
    }

    public long count() {
        return this.count;
    }

    public boolean equals(Object obj) {
        if (obj == null || Stats.class != obj.getClass()) {
            return false;
        }
        Stats stats = (Stats) obj;
        return this.count == stats.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(stats.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(stats.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(stats.max);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double h() {
        return this.sumOfSquaresOfDeltas;
    }

    public int hashCode() {
        return m.b(Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ByteBuffer byteBuffer) {
        p.o(byteBuffer);
        p.g(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
    }

    public double max() {
        p.u(this.count != 0);
        return this.max;
    }

    public double mean() {
        p.u(this.count != 0);
        return this.mean;
    }

    public double min() {
        p.u(this.count != 0);
        return this.min;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        p.u(this.count > 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return b.a(this.sumOfSquaresOfDeltas) / count();
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        p.u(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return b.a(this.sumOfSquaresOfDeltas) / (this.count - 1);
    }

    public double sum() {
        return this.mean * this.count;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        i(order);
        return order.array();
    }

    public String toString() {
        if (count() > 0) {
            return l.b(this).c(ContactConstant.CallsRecordKeys.COUNT, this.count).a("mean", this.mean).a("populationStandardDeviation", populationStandardDeviation()).a("min", this.min).a("max", this.max).toString();
        }
        return l.b(this).c(ContactConstant.CallsRecordKeys.COUNT, this.count).toString();
    }

    public static double meanOf(Iterator<? extends Number> it) {
        p.d(it.hasNext());
        double doubleValue = it.next().doubleValue();
        long j10 = 1;
        while (it.hasNext()) {
            double doubleValue2 = it.next().doubleValue();
            j10++;
            doubleValue = (!b.f(doubleValue2) || !b.f(doubleValue)) ? o.h(doubleValue, doubleValue2) : doubleValue + ((doubleValue2 - doubleValue) / j10);
        }
        return doubleValue;
    }

    public static Stats of(Iterator<? extends Number> it) {
        o oVar = new o();
        oVar.d(it);
        return oVar.n();
    }

    public static Stats of(double... dArr) {
        o oVar = new o();
        oVar.e(dArr);
        return oVar.n();
    }

    public static double meanOf(double... dArr) {
        p.d(dArr.length > 0);
        double d10 = dArr[0];
        for (int i10 = 1; i10 < dArr.length; i10++) {
            double d11 = dArr[i10];
            d10 = (!b.f(d11) || !b.f(d10)) ? o.h(d10, d11) : d10 + ((d11 - d10) / (i10 + 1));
        }
        return d10;
    }

    public static Stats of(int... iArr) {
        o oVar = new o();
        oVar.f(iArr);
        return oVar.n();
    }

    public static Stats of(long... jArr) {
        o oVar = new o();
        oVar.g(jArr);
        return oVar.n();
    }

    public static double meanOf(int... iArr) {
        p.d(iArr.length > 0);
        double d10 = iArr[0];
        for (int i10 = 1; i10 < iArr.length; i10++) {
            double d11 = iArr[i10];
            d10 = (!b.f(d11) || !b.f(d10)) ? o.h(d10, d11) : d10 + ((d11 - d10) / (i10 + 1));
        }
        return d10;
    }

    public static Stats of(DoubleStream doubleStream) {
        return ((o) doubleStream.collect(n.f12341a, k.f12338a, g.f12334a)).n();
    }

    public static Stats of(IntStream intStream) {
        return ((o) intStream.collect(n.f12341a, l.f12339a, g.f12334a)).n();
    }

    public static double meanOf(long... jArr) {
        p.d(jArr.length > 0);
        double d10 = jArr[0];
        for (int i10 = 1; i10 < jArr.length; i10++) {
            double d11 = jArr[i10];
            d10 = (!b.f(d11) || !b.f(d10)) ? o.h(d10, d11) : d10 + ((d11 - d10) / (i10 + 1));
        }
        return d10;
    }

    public static Stats of(LongStream longStream) {
        return ((o) longStream.collect(n.f12341a, m.f12340a, g.f12334a)).n();
    }
}
