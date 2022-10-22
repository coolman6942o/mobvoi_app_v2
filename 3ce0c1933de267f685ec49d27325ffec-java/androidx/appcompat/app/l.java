package androidx.appcompat.app;
/* compiled from: TwilightCalculator.java */
/* loaded from: classes.dex */
class l {

    /* renamed from: d  reason: collision with root package name */
    private static l f560d;

    /* renamed from: a  reason: collision with root package name */
    public long f561a;

    /* renamed from: b  reason: collision with root package name */
    public long f562b;

    /* renamed from: c  reason: collision with root package name */
    public int f563c;

    l() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l b() {
        if (f560d == null) {
            f560d = new l();
        }
        return f560d;
    }

    public void a(long j10, double d10, double d11) {
        float f10;
        float f11;
        double d12;
        double d13 = (0.01720197f * (((float) (j10 - 946728000000L)) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(d13) * 0.03341960161924362d) + d13 + (Math.sin(2.0f * f11) * 3.4906598739326E-4d) + (Math.sin(f11 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double round = ((float) Math.round((f10 - 9.0E-4f) - d12)) + 9.0E-4f + ((-d11) / 360.0d) + (Math.sin(d13) * 0.0053d) + (Math.sin(2.0d * sin) * (-0.0069d));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d14 = 0.01745329238474369d * d10;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d14) * Math.sin(asin))) / (Math.cos(d14) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.f563c = 1;
            this.f561a = -1L;
            this.f562b = -1L;
        } else if (sin2 <= -1.0d) {
            this.f563c = 0;
            this.f561a = -1L;
            this.f562b = -1L;
        } else {
            double acos = (float) (Math.acos(sin2) / 6.283185307179586d);
            this.f561a = Math.round((round + acos) * 8.64E7d) + 946728000000L;
            long round2 = Math.round((round - acos) * 8.64E7d) + 946728000000L;
            this.f562b = round2;
            if (round2 >= j10 || this.f561a <= j10) {
                this.f563c = 1;
            } else {
                this.f563c = 0;
            }
        }
    }
}
