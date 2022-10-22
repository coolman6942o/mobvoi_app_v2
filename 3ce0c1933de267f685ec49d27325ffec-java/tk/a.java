package tk;
/* compiled from: GeoUtil.java */
/* loaded from: classes2.dex */
public class a {
    public static double a(double d10, double d11, double d12, double d13) {
        double b10 = b(d11);
        double b11 = b(d13);
        return Math.asin(Math.sqrt(Math.pow(Math.sin((b10 - b11) / 2.0d), 2.0d) + (Math.cos(b10) * Math.cos(b11) * Math.pow(Math.sin((b(d12) - b(d10)) / 2.0d), 2.0d)))) * 2.0d * 6378.137d * 1000.0d;
    }

    private static double b(double d10) {
        return (d10 * 3.141592653589793d) / 180.0d;
    }
}
