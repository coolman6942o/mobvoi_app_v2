package a0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CamColor.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final float f23a;

    /* renamed from: b  reason: collision with root package name */
    private final float f24b;

    /* renamed from: c  reason: collision with root package name */
    private final float f25c;

    /* renamed from: d  reason: collision with root package name */
    private final float f26d;

    /* renamed from: e  reason: collision with root package name */
    private final float f27e;

    /* renamed from: f  reason: collision with root package name */
    private final float f28f;

    a(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.f23a = f10;
        this.f24b = f11;
        this.f25c = f12;
        this.f26d = f16;
        this.f27e = f17;
        this.f28f = f18;
    }

    private static a b(float f10, float f11, float f12) {
        float f13 = 1000.0f;
        float f14 = 100.0f;
        a aVar = null;
        float f15 = 0.0f;
        float f16 = 1000.0f;
        while (Math.abs(f15 - f14) > 0.01f) {
            float f17 = ((f14 - f15) / 2.0f) + f15;
            int p10 = e(f17, f11, f10).p();
            float b10 = b.b(p10);
            float abs = Math.abs(f12 - b10);
            if (abs < 0.2f) {
                a c10 = c(p10);
                float a10 = c10.a(e(c10.k(), c10.i(), f10));
                if (a10 <= 1.0f) {
                    aVar = c10;
                    f13 = abs;
                    f16 = a10;
                }
            }
            if (f13 == 0.0f && f16 == 0.0f) {
                break;
            } else if (b10 < f12) {
                f15 = f17;
            } else {
                f14 = f17;
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c(int i10) {
        return d(i10, j.f64k);
    }

    static a d(int i10, j jVar) {
        float pow;
        float[] f10 = b.f(i10);
        float[][] fArr = b.f29a;
        float f11 = (f10[0] * fArr[0][0]) + (f10[1] * fArr[0][1]) + (f10[2] * fArr[0][2]);
        float f12 = (f10[0] * fArr[1][0]) + (f10[1] * fArr[1][1]) + (f10[2] * fArr[1][2]);
        float f13 = (f10[0] * fArr[2][0]) + (f10[1] * fArr[2][1]) + (f10[2] * fArr[2][2]);
        float f14 = jVar.i()[0] * f11;
        float f15 = jVar.i()[1] * f12;
        float f16 = jVar.i()[2] * f13;
        float pow2 = (float) Math.pow((jVar.c() * Math.abs(f14)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((jVar.c() * Math.abs(f15)) / 100.0d, 0.42d);
        float pow4 = (float) Math.pow((jVar.c() * Math.abs(f16)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f14) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum2 = ((Math.signum(f15) * 400.0f) * pow3) / (pow3 + 27.13f);
        float signum3 = ((Math.signum(f16) * 400.0f) * pow4) / (pow4 + 27.13f);
        double d10 = signum3;
        float f17 = ((float) (((signum * 11.0d) + (signum2 * (-12.0d))) + d10)) / 11.0f;
        float f18 = ((float) ((signum + signum2) - (d10 * 2.0d))) / 9.0f;
        float f19 = signum2 * 20.0f;
        float f20 = (((signum * 20.0f) + f19) + (21.0f * signum3)) / 20.0f;
        float f21 = (((signum * 40.0f) + f19) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f18, f17)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f22 = atan2;
        float f23 = (3.1415927f * f22) / 180.0f;
        float pow5 = ((float) Math.pow((f21 * jVar.f()) / jVar.a(), jVar.b() * jVar.j())) * 100.0f;
        float d11 = jVar.d() * (4.0f / jVar.b()) * ((float) Math.sqrt(pow5 / 100.0f)) * (jVar.a() + 4.0f);
        float pow6 = ((float) Math.pow(1.64d - Math.pow(0.29d, jVar.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) f22) < 20.14d ? 360.0f + f22 : f22) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * jVar.g()) * jVar.h()) * ((float) Math.sqrt((f17 * f17) + (f18 * f18)))) / (f20 + 0.305f), 0.9d)) * ((float) Math.sqrt(pow5 / 100.0d));
        float d12 = pow6 * jVar.d();
        float sqrt = ((float) Math.sqrt((pow * jVar.b()) / (jVar.a() + 4.0f))) * 50.0f;
        float f24 = (1.7f * pow5) / ((0.007f * pow5) + 1.0f);
        float log = ((float) Math.log((0.0228f * d12) + 1.0f)) * 43.85965f;
        double d13 = f23;
        return new a(f22, pow6, pow5, d11, d12, sqrt, f24, log * ((float) Math.cos(d13)), log * ((float) Math.sin(d13)));
    }

    private static a e(float f10, float f11, float f12) {
        return f(f10, f11, f12, j.f64k);
    }

    private static a f(float f10, float f11, float f12, j jVar) {
        double d10;
        float b10 = (4.0f / jVar.b()) * ((float) Math.sqrt(f10 / 100.0d)) * (jVar.a() + 4.0f) * jVar.d();
        float d11 = f11 * jVar.d();
        float sqrt = ((float) Math.sqrt(((f11 / ((float) Math.sqrt(d10))) * jVar.b()) / (jVar.a() + 4.0f))) * 50.0f;
        float f13 = (1.7f * f10) / ((0.007f * f10) + 1.0f);
        float log = ((float) Math.log((d11 * 0.0228d) + 1.0d)) * 43.85965f;
        double d12 = (3.1415927f * f12) / 180.0f;
        return new a(f12, f11, f10, b10, d11, sqrt, f13, log * ((float) Math.cos(d12)), log * ((float) Math.sin(d12)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(float f10, float f11, float f12) {
        return n(f10, f11, f12, j.f64k);
    }

    static int n(float f10, float f11, float f12, j jVar) {
        if (f11 < 1.0d || Math.round(f12) <= 0.0d || Math.round(f12) >= 100.0d) {
            return b.a(f12);
        }
        float min = f10 < 0.0f ? 0.0f : Math.min(360.0f, f10);
        boolean z10 = true;
        a aVar = null;
        float f13 = 0.0f;
        float f14 = f11;
        while (Math.abs(f13 - f11) >= 0.4f) {
            a b10 = b(min, f14, f12);
            if (z10) {
                if (b10 != null) {
                    return b10.o(jVar);
                }
                z10 = false;
            } else if (b10 == null) {
                f11 = f14;
            } else {
                f13 = f14;
                aVar = b10;
            }
            f14 = ((f11 - f13) / 2.0f) + f13;
        }
        if (aVar == null) {
            return b.a(f12);
        }
        return aVar.o(jVar);
    }

    float a(a aVar) {
        float l10 = l() - aVar.l();
        float g10 = g() - aVar.g();
        float h10 = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((l10 * l10) + (g10 * g10) + (h10 * h10)), 0.63d) * 1.41d);
    }

    float g() {
        return this.f27e;
    }

    float h() {
        return this.f28f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f24b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f23a;
    }

    float k() {
        return this.f25c;
    }

    float l() {
        return this.f26d;
    }

    int o(j jVar) {
        float f10;
        float pow = (float) Math.pow(((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? 0.0f : i() / ((float) Math.sqrt(k() / 100.0d))) / Math.pow(1.64d - Math.pow(0.29d, jVar.e()), 0.73d), 1.1111111111111112d);
        double j10 = (j() * 3.1415927f) / 180.0f;
        float a10 = jVar.a() * ((float) Math.pow(k() / 100.0d, (1.0d / jVar.b()) / jVar.j()));
        float cos = ((float) (Math.cos(2.0d + j10) + 3.8d)) * 0.25f * 3846.1538f * jVar.g() * jVar.h();
        float f11 = a10 / jVar.f();
        float sin = (float) Math.sin(j10);
        float cos2 = (float) Math.cos(j10);
        float f12 = (((0.305f + f11) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f13 = cos2 * f12;
        float f14 = f12 * sin;
        float f15 = f11 * 460.0f;
        float f16 = (((451.0f * f13) + f15) + (288.0f * f14)) / 1403.0f;
        float f17 = ((f15 - (891.0f * f13)) - (261.0f * f14)) / 1403.0f;
        float signum = Math.signum(f16) * (100.0f / jVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f16) * 27.13d) / (400.0d - Math.abs(f16))), 2.380952380952381d));
        float signum2 = Math.signum(f17) * (100.0f / jVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f17) * 27.13d) / (400.0d - Math.abs(f17))), 2.380952380952381d));
        float signum3 = Math.signum(((f15 - (f13 * 220.0f)) - (f14 * 6300.0f)) / 1403.0f) * (100.0f / jVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f10) * 27.13d) / (400.0d - Math.abs(f10))), 2.380952380952381d));
        float f18 = signum / jVar.i()[0];
        float f19 = signum2 / jVar.i()[1];
        float f20 = signum3 / jVar.i()[2];
        float[][] fArr = b.f30b;
        return b0.a.b((fArr[0][0] * f18) + (fArr[0][1] * f19) + (fArr[0][2] * f20), (fArr[1][0] * f18) + (fArr[1][1] * f19) + (fArr[1][2] * f20), (f18 * fArr[2][0]) + (f19 * fArr[2][1]) + (f20 * fArr[2][2]));
    }

    int p() {
        return o(j.f64k);
    }
}
