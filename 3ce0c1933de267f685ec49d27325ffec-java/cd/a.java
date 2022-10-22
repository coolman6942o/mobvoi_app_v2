package cd;
/* compiled from: GPSUtil.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static double f5714a = 3.141592653589793d;

    /* renamed from: b  reason: collision with root package name */
    public static double f5715b = 6378245.0d;

    /* renamed from: c  reason: collision with root package name */
    public static double f5716c = 0.006693421622965943d;

    public static double[] a(double d10, double d11) {
        if (b(d10, d11)) {
            return new double[]{d10, d11};
        }
        double d12 = d11 - 105.0d;
        double d13 = d10 - 35.0d;
        double c10 = c(d12, d13);
        double d14 = d(d12, d13);
        double d15 = (d10 / 180.0d) * f5714a;
        double sin = Math.sin(d15);
        double d16 = 1.0d - ((f5716c * sin) * sin);
        double sqrt = Math.sqrt(d16);
        double d17 = f5715b;
        return new double[]{d10 + ((c10 * 180.0d) / ((((1.0d - f5716c) * d17) / (d16 * sqrt)) * f5714a)), d11 + ((d14 * 180.0d) / (((d17 / sqrt) * Math.cos(d15)) * f5714a))};
    }

    public static boolean b(double d10, double d11) {
        return d11 < 72.004d || d11 > 137.8347d || d10 < 0.8293d || d10 > 55.8271d;
    }

    public static double c(double d10, double d11) {
        double d12 = d10 * 2.0d;
        return (-100.0d) + d12 + (d11 * 3.0d) + (d11 * 0.2d * d11) + (0.1d * d10 * d11) + (Math.sqrt(Math.abs(d10)) * 0.2d) + ((((Math.sin((d10 * 6.0d) * f5714a) * 20.0d) + (Math.sin(d12 * f5714a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f5714a * d11) * 20.0d) + (Math.sin((d11 / 3.0d) * f5714a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d11 / 12.0d) * f5714a) * 160.0d) + (Math.sin((d11 * f5714a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    public static double d(double d10, double d11) {
        double d12 = d10 * 0.1d;
        return d10 + 300.0d + (d11 * 2.0d) + (d12 * d10) + (d12 * d11) + (Math.sqrt(Math.abs(d10)) * 0.1d) + ((((Math.sin((6.0d * d10) * f5714a) * 20.0d) + (Math.sin((d10 * 2.0d) * f5714a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f5714a * d10) * 20.0d) + (Math.sin((d10 / 3.0d) * f5714a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d10 / 12.0d) * f5714a) * 150.0d) + (Math.sin((d10 / 30.0d) * f5714a) * 300.0d)) * 2.0d) / 3.0d);
    }
}
