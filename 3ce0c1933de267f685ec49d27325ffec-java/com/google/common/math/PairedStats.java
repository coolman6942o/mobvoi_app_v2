package com.google.common.math;

import com.google.common.base.l;
import com.google.common.base.m;
import com.google.common.base.p;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes.dex */
public final class PairedStats implements Serializable {
    private static final int BYTES = 88;
    private static final long serialVersionUID = 0;
    private final double sumOfProductsOfDeltas;
    private final Stats xStats;
    private final Stats yStats;

    PairedStats(Stats stats, Stats stats2, double d10) {
        this.xStats = stats;
        this.yStats = stats2;
        this.sumOfProductsOfDeltas = d10;
    }

    private static double a(double d10) {
        if (d10 >= 1.0d) {
            return 1.0d;
        }
        if (d10 <= -1.0d) {
            return -1.0d;
        }
        return d10;
    }

    private static double b(double d10) {
        if (d10 > 0.0d) {
            return d10;
        }
        return Double.MIN_VALUE;
    }

    public static PairedStats fromByteArray(byte[] bArr) {
        p.o(bArr);
        p.g(bArr.length == 88, "Expected PairedStats.BYTES = %s, got %s", 88, bArr.length);
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        return new PairedStats(Stats.g(order), Stats.g(order), order.getDouble());
    }

    public long count() {
        return this.xStats.count();
    }

    public boolean equals(Object obj) {
        if (obj == null || PairedStats.class != obj.getClass()) {
            return false;
        }
        PairedStats pairedStats = (PairedStats) obj;
        return this.xStats.equals(pairedStats.xStats) && this.yStats.equals(pairedStats.yStats) && Double.doubleToLongBits(this.sumOfProductsOfDeltas) == Double.doubleToLongBits(pairedStats.sumOfProductsOfDeltas);
    }

    public int hashCode() {
        return m.b(this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas));
    }

    public d leastSquaresFit() {
        boolean z10 = true;
        p.u(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return d.a();
        }
        double h10 = this.xStats.h();
        if (h10 <= 0.0d) {
            if (this.yStats.h() <= 0.0d) {
                z10 = false;
            }
            p.u(z10);
            return d.d(this.xStats.mean());
        } else if (this.yStats.h() > 0.0d) {
            return d.c(this.xStats.mean(), this.yStats.mean()).a(this.sumOfProductsOfDeltas / h10);
        } else {
            return d.b(this.yStats.mean());
        }
    }

    public double pearsonsCorrelationCoefficient() {
        boolean z10 = true;
        p.u(count() > 1);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return Double.NaN;
        }
        double h10 = xStats().h();
        double h11 = yStats().h();
        p.u(h10 > 0.0d);
        if (h11 <= 0.0d) {
            z10 = false;
        }
        p.u(z10);
        return a(this.sumOfProductsOfDeltas / Math.sqrt(b(h10 * h11)));
    }

    public double populationCovariance() {
        p.u(count() != 0);
        return this.sumOfProductsOfDeltas / count();
    }

    public double sampleCovariance() {
        p.u(count() > 1);
        return this.sumOfProductsOfDeltas / (count() - 1);
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.xStats.i(order);
        this.yStats.i(order);
        order.putDouble(this.sumOfProductsOfDeltas);
        return order.array();
    }

    public String toString() {
        if (count() > 0) {
            return l.b(this).d("xStats", this.xStats).d("yStats", this.yStats).a("populationCovariance", populationCovariance()).toString();
        }
        return l.b(this).d("xStats", this.xStats).d("yStats", this.yStats).toString();
    }

    public Stats xStats() {
        return this.xStats;
    }

    public Stats yStats() {
        return this.yStats;
    }
}
