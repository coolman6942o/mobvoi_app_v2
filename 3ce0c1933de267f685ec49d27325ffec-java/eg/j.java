package eg;
/* compiled from: Statistics.java */
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private double[] f26046a;

    /* renamed from: b  reason: collision with root package name */
    private int f26047b;

    public j(double[] dArr) {
        this.f26046a = dArr;
        this.f26047b = dArr.length;
    }

    public double a() {
        double d10 = 0.0d;
        for (double d11 : this.f26046a) {
            d10 += d11;
        }
        return d10 / this.f26047b;
    }

    public double b() {
        return Math.sqrt(c());
    }

    public double c() {
        double a10 = a();
        double d10 = 0.0d;
        for (double d11 : this.f26046a) {
            double d12 = d11 - a10;
            d10 += d12 * d12;
        }
        return d10 / (this.f26047b - 1);
    }
}
