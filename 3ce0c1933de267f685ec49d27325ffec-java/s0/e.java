package s0;

import s0.b;
/* compiled from: SpringForce.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    double f34267a;

    /* renamed from: b  reason: collision with root package name */
    double f34268b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f34269c;

    /* renamed from: d  reason: collision with root package name */
    private double f34270d;

    /* renamed from: e  reason: collision with root package name */
    private double f34271e;

    /* renamed from: f  reason: collision with root package name */
    private double f34272f;

    /* renamed from: g  reason: collision with root package name */
    private double f34273g;

    /* renamed from: h  reason: collision with root package name */
    private double f34274h;

    /* renamed from: i  reason: collision with root package name */
    private double f34275i;

    /* renamed from: j  reason: collision with root package name */
    private final b.o f34276j;

    public e() {
        this.f34267a = Math.sqrt(1500.0d);
        this.f34268b = 0.5d;
        this.f34269c = false;
        this.f34275i = Double.MAX_VALUE;
        this.f34276j = new b.o();
    }

    private void b() {
        if (!this.f34269c) {
            if (this.f34275i != Double.MAX_VALUE) {
                double d10 = this.f34268b;
                if (d10 > 1.0d) {
                    double d11 = this.f34267a;
                    this.f34272f = ((-d10) * d11) + (d11 * Math.sqrt((d10 * d10) - 1.0d));
                    double d12 = this.f34268b;
                    double d13 = this.f34267a;
                    this.f34273g = ((-d12) * d13) - (d13 * Math.sqrt((d12 * d12) - 1.0d));
                } else if (d10 >= 0.0d && d10 < 1.0d) {
                    this.f34274h = this.f34267a * Math.sqrt(1.0d - (d10 * d10));
                }
                this.f34269c = true;
                return;
            }
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
    }

    public float a() {
        return (float) this.f34275i;
    }

    public boolean c(float f10, float f11) {
        return ((double) Math.abs(f11)) < this.f34271e && ((double) Math.abs(f10 - a())) < this.f34270d;
    }

    public e d(float f10) {
        if (f10 >= 0.0f) {
            this.f34268b = f10;
            this.f34269c = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public e e(float f10) {
        this.f34275i = f10;
        return this;
    }

    public e f(float f10) {
        if (f10 > 0.0f) {
            this.f34267a = Math.sqrt(f10);
            this.f34269c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(double d10) {
        double abs = Math.abs(d10);
        this.f34270d = abs;
        this.f34271e = abs * 62.5d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b.o h(double d10, double d11, long j10) {
        double d12;
        double d13;
        b();
        double d14 = j10 / 1000.0d;
        double d15 = d10 - this.f34275i;
        double d16 = this.f34268b;
        if (d16 > 1.0d) {
            double d17 = this.f34273g;
            double d18 = this.f34272f;
            double d19 = d15 - (((d17 * d15) - d11) / (d17 - d18));
            double d20 = ((d15 * d17) - d11) / (d17 - d18);
            d13 = (Math.pow(2.718281828459045d, d17 * d14) * d19) + (Math.pow(2.718281828459045d, this.f34272f * d14) * d20);
            double d21 = this.f34273g;
            double pow = d19 * d21 * Math.pow(2.718281828459045d, d21 * d14);
            double d22 = this.f34272f;
            d12 = pow + (d20 * d22 * Math.pow(2.718281828459045d, d22 * d14));
        } else if (d16 == 1.0d) {
            double d23 = this.f34267a;
            double d24 = d11 + (d23 * d15);
            double d25 = d15 + (d24 * d14);
            d13 = Math.pow(2.718281828459045d, (-d23) * d14) * d25;
            double pow2 = d25 * Math.pow(2.718281828459045d, (-this.f34267a) * d14);
            double d26 = this.f34267a;
            d12 = (d24 * Math.pow(2.718281828459045d, (-d26) * d14)) + (pow2 * (-d26));
        } else {
            double d27 = 1.0d / this.f34274h;
            double d28 = this.f34267a;
            double d29 = d27 * ((d16 * d28 * d15) + d11);
            double pow3 = Math.pow(2.718281828459045d, (-d16) * d28 * d14) * ((Math.cos(this.f34274h * d14) * d15) + (Math.sin(this.f34274h * d14) * d29));
            double d30 = this.f34267a;
            double d31 = this.f34268b;
            double pow4 = Math.pow(2.718281828459045d, (-d31) * d30 * d14);
            double d32 = this.f34274h;
            double sin = (-d32) * d15 * Math.sin(d32 * d14);
            double d33 = this.f34274h;
            d12 = ((-d30) * pow3 * d31) + (pow4 * (sin + (d29 * d33 * Math.cos(d33 * d14))));
            d13 = pow3;
        }
        b.o oVar = this.f34276j;
        oVar.f34262a = (float) (d13 + this.f34275i);
        oVar.f34263b = (float) d12;
        return oVar;
    }

    public e(float f10) {
        this.f34267a = Math.sqrt(1500.0d);
        this.f34268b = 0.5d;
        this.f34269c = false;
        this.f34275i = Double.MAX_VALUE;
        this.f34276j = new b.o();
        this.f34275i = f10;
    }
}
