package n4;
/* compiled from: HashCodeBuilder.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f31011a = 37;

    /* renamed from: b  reason: collision with root package name */
    private int f31012b;

    public b() {
        this.f31012b = 0;
        this.f31012b = 17;
    }

    public int a() {
        return this.f31012b;
    }

    public b b(byte b10) {
        this.f31012b = (this.f31012b * this.f31011a) + b10;
        return this;
    }

    public b c(char c10) {
        this.f31012b = (this.f31012b * this.f31011a) + c10;
        return this;
    }

    public b d(double d10) {
        return g(Double.doubleToLongBits(d10));
    }

    public b e(float f10) {
        this.f31012b = (this.f31012b * this.f31011a) + Float.floatToIntBits(f10);
        return this;
    }

    public b f(int i10) {
        this.f31012b = (this.f31012b * this.f31011a) + i10;
        return this;
    }

    public b g(long j10) {
        this.f31012b = (this.f31012b * this.f31011a) + ((int) (j10 ^ (j10 >> 32)));
        return this;
    }

    public b h(Object obj) {
        if (obj == null) {
            this.f31012b *= this.f31011a;
        } else if (!obj.getClass().isArray()) {
            this.f31012b = (this.f31012b * this.f31011a) + obj.hashCode();
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

    public b i(short s10) {
        this.f31012b = (this.f31012b * this.f31011a) + s10;
        return this;
    }

    public b j(boolean z10) {
        this.f31012b = (this.f31012b * this.f31011a) + (!z10 ? 1 : 0);
        return this;
    }

    public b k(byte[] bArr) {
        if (bArr == null) {
            this.f31012b *= this.f31011a;
        } else {
            for (byte b10 : bArr) {
                b(b10);
            }
        }
        return this;
    }

    public b l(char[] cArr) {
        if (cArr == null) {
            this.f31012b *= this.f31011a;
        } else {
            for (char c10 : cArr) {
                c(c10);
            }
        }
        return this;
    }

    public b m(double[] dArr) {
        if (dArr == null) {
            this.f31012b *= this.f31011a;
        } else {
            for (double d10 : dArr) {
                d(d10);
            }
        }
        return this;
    }

    public b n(float[] fArr) {
        if (fArr == null) {
            this.f31012b *= this.f31011a;
        } else {
            for (float f10 : fArr) {
                e(f10);
            }
        }
        return this;
    }

    public b o(int[] iArr) {
        if (iArr == null) {
            this.f31012b *= this.f31011a;
        } else {
            for (int i10 : iArr) {
                f(i10);
            }
        }
        return this;
    }

    public b p(long[] jArr) {
        if (jArr == null) {
            this.f31012b *= this.f31011a;
        } else {
            for (long j10 : jArr) {
                g(j10);
            }
        }
        return this;
    }

    public b q(Object[] objArr) {
        if (objArr == null) {
            this.f31012b *= this.f31011a;
        } else {
            for (Object obj : objArr) {
                h(obj);
            }
        }
        return this;
    }

    public b r(short[] sArr) {
        if (sArr == null) {
            this.f31012b *= this.f31011a;
        } else {
            for (short s10 : sArr) {
                i(s10);
            }
        }
        return this;
    }

    public b s(boolean[] zArr) {
        if (zArr == null) {
            this.f31012b *= this.f31011a;
        } else {
            for (boolean z10 : zArr) {
                j(z10);
            }
        }
        return this;
    }
}
