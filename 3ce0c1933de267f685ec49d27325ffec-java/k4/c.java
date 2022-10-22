package k4;
/* compiled from: HashCodeBuilder.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f29744a = 37;

    /* renamed from: b  reason: collision with root package name */
    private int f29745b;

    public c() {
        this.f29745b = 0;
        this.f29745b = 17;
    }

    public int a() {
        return this.f29745b;
    }

    public c b(byte b10) {
        this.f29745b = (this.f29745b * this.f29744a) + b10;
        return this;
    }

    public c c(char c10) {
        this.f29745b = (this.f29745b * this.f29744a) + c10;
        return this;
    }

    public c d(double d10) {
        return g(Double.doubleToLongBits(d10));
    }

    public c e(float f10) {
        this.f29745b = (this.f29745b * this.f29744a) + Float.floatToIntBits(f10);
        return this;
    }

    public c f(int i10) {
        this.f29745b = (this.f29745b * this.f29744a) + i10;
        return this;
    }

    public c g(long j10) {
        this.f29745b = (this.f29745b * this.f29744a) + ((int) (j10 ^ (j10 >> 32)));
        return this;
    }

    public c h(Object obj) {
        if (obj == null) {
            this.f29745b *= this.f29744a;
        } else if (!obj.getClass().isArray()) {
            this.f29745b = (this.f29745b * this.f29744a) + obj.hashCode();
        } else if (obj instanceof long[]) {
            p((long[]) obj);
        } else if (obj instanceof int[]) {
            o((int[]) obj);
        } else if (obj instanceof short[]) {
            r((short[]) obj);
        } else if (obj instanceof char[]) {
            l((char[]) obj);
        } else if (obj instanceof byte[]) {
            k((byte[]) obj);
        } else if (obj instanceof double[]) {
            m((double[]) obj);
        } else if (obj instanceof float[]) {
            n((float[]) obj);
        } else if (obj instanceof boolean[]) {
            s((boolean[]) obj);
        } else {
            q((Object[]) obj);
        }
        return this;
    }

    public int hashCode() {
        return a();
    }

    public c i(short s10) {
        this.f29745b = (this.f29745b * this.f29744a) + s10;
        return this;
    }

    public c j(boolean z10) {
        this.f29745b = (this.f29745b * this.f29744a) + (!z10 ? 1 : 0);
        return this;
    }

    public c k(byte[] bArr) {
        if (bArr == null) {
            this.f29745b *= this.f29744a;
        } else {
            for (byte b10 : bArr) {
                b(b10);
            }
        }
        return this;
    }

    public c l(char[] cArr) {
        if (cArr == null) {
            this.f29745b *= this.f29744a;
        } else {
            for (char c10 : cArr) {
                c(c10);
            }
        }
        return this;
    }

    public c m(double[] dArr) {
        if (dArr == null) {
            this.f29745b *= this.f29744a;
        } else {
            for (double d10 : dArr) {
                d(d10);
            }
        }
        return this;
    }

    public c n(float[] fArr) {
        if (fArr == null) {
            this.f29745b *= this.f29744a;
        } else {
            for (float f10 : fArr) {
                e(f10);
            }
        }
        return this;
    }

    public c o(int[] iArr) {
        if (iArr == null) {
            this.f29745b *= this.f29744a;
        } else {
            for (int i10 : iArr) {
                f(i10);
            }
        }
        return this;
    }

    public c p(long[] jArr) {
        if (jArr == null) {
            this.f29745b *= this.f29744a;
        } else {
            for (long j10 : jArr) {
                g(j10);
            }
        }
        return this;
    }

    public c q(Object[] objArr) {
        if (objArr == null) {
            this.f29745b *= this.f29744a;
        } else {
            for (Object obj : objArr) {
                h(obj);
            }
        }
        return this;
    }

    public c r(short[] sArr) {
        if (sArr == null) {
            this.f29745b *= this.f29744a;
        } else {
            for (short s10 : sArr) {
                i(s10);
            }
        }
        return this;
    }

    public c s(boolean[] zArr) {
        if (zArr == null) {
            this.f29745b *= this.f29744a;
        } else {
            for (boolean z10 : zArr) {
                j(z10);
            }
        }
        return this;
    }
}
