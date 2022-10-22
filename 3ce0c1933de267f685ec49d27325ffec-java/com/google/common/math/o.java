package com.google.common.math;

import com.google.common.base.p;
import com.google.common.primitives.b;
import java.util.Iterator;
/* compiled from: StatsAccumulator.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private long f12342a = 0;

    /* renamed from: b  reason: collision with root package name */
    private double f12343b = 0.0d;

    /* renamed from: c  reason: collision with root package name */
    private double f12344c = 0.0d;

    /* renamed from: d  reason: collision with root package name */
    private double f12345d = Double.NaN;

    /* renamed from: e  reason: collision with root package name */
    private double f12346e = Double.NaN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double h(double d10, double d11) {
        if (b.f(d10)) {
            return d11;
        }
        if (b.f(d11) || d10 == d11) {
            return d10;
        }
        return Double.NaN;
    }

    private void l(long j10, double d10, double d11, double d12, double d13) {
        long j11 = this.f12342a;
        if (j11 == 0) {
            this.f12342a = j10;
            this.f12343b = d10;
            this.f12344c = d11;
            this.f12345d = d12;
            this.f12346e = d13;
            return;
        }
        this.f12342a = j11 + j10;
        if (!b.f(this.f12343b) || !b.f(d10)) {
            this.f12343b = h(this.f12343b, d10);
            this.f12344c = Double.NaN;
        } else {
            double d14 = this.f12343b;
            double d15 = d10 - d14;
            double d16 = j10;
            double d17 = d14 + ((d15 * d16) / this.f12342a);
            this.f12343b = d17;
            this.f12344c += d11 + (d15 * (d10 - d17) * d16);
        }
        this.f12345d = Math.min(this.f12345d, d12);
        this.f12346e = Math.max(this.f12346e, d13);
    }

    public void a(double d10) {
        long j10 = this.f12342a;
        if (j10 == 0) {
            this.f12342a = 1L;
            this.f12343b = d10;
            this.f12345d = d10;
            this.f12346e = d10;
            if (!b.f(d10)) {
                this.f12344c = Double.NaN;
                return;
            }
            return;
        }
        this.f12342a = j10 + 1;
        if (!b.f(d10) || !b.f(this.f12343b)) {
            this.f12343b = h(this.f12343b, d10);
            this.f12344c = Double.NaN;
        } else {
            double d11 = this.f12343b;
            double d12 = d10 - d11;
            double d13 = d11 + (d12 / this.f12342a);
            this.f12343b = d13;
            this.f12344c += d12 * (d10 - d13);
        }
        this.f12345d = Math.min(this.f12345d, d10);
        this.f12346e = Math.max(this.f12346e, d10);
    }

    public void b(o oVar) {
        if (oVar.i() != 0) {
            l(oVar.i(), oVar.k(), oVar.o(), oVar.m(), oVar.j());
        }
    }

    public void c(Iterable<? extends Number> iterable) {
        for (Number number : iterable) {
            a(number.doubleValue());
        }
    }

    public void d(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void e(double... dArr) {
        for (double d10 : dArr) {
            a(d10);
        }
    }

    public void f(int... iArr) {
        for (int i10 : iArr) {
            a(i10);
        }
    }

    public void g(long... jArr) {
        for (long j10 : jArr) {
            a(j10);
        }
    }

    public long i() {
        return this.f12342a;
    }

    public double j() {
        p.u(this.f12342a != 0);
        return this.f12346e;
    }

    public double k() {
        p.u(this.f12342a != 0);
        return this.f12343b;
    }

    public double m() {
        p.u(this.f12342a != 0);
        return this.f12345d;
    }

    public Stats n() {
        return new Stats(this.f12342a, this.f12343b, this.f12344c, this.f12345d, this.f12346e);
    }

    double o() {
        return this.f12344c;
    }
}
