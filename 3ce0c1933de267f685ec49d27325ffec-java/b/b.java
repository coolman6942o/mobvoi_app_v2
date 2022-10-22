package b;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f4921a;

    /* renamed from: b  reason: collision with root package name */
    public short f4922b;

    /* renamed from: c  reason: collision with root package name */
    public short f4923c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f4924d;

    /* renamed from: e  reason: collision with root package name */
    public int f4925e;

    /* renamed from: b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0061b {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f4926a;

        /* renamed from: b  reason: collision with root package name */
        public short f4927b = 0;

        /* renamed from: c  reason: collision with root package name */
        public short f4928c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f4929d = 2;

        /* renamed from: e  reason: collision with root package name */
        public int f4930e = 2;

        public C0061b a(int i10) {
            this.f4929d = i10;
            return this;
        }

        public C0061b b(short s10) {
            this.f4927b = s10;
            return this;
        }

        public C0061b c(short s10, byte[] bArr) {
            this.f4927b = s10;
            this.f4926a = e.d(s10, bArr);
            return this;
        }

        public C0061b d(byte[] bArr) {
            this.f4926a = bArr;
            return this;
        }

        public b e() {
            return new b(this.f4929d, this.f4927b, this.f4928c, this.f4926a, this.f4930e);
        }
    }

    public b(int i10, short s10, short s11, byte[] bArr, int i11) {
        this.f4925e = 2;
        this.f4921a = i10;
        this.f4922b = s10;
        this.f4923c = s11;
        this.f4924d = bArr;
        this.f4925e = i11;
    }

    public short a() {
        return this.f4922b;
    }

    public byte[] b(int i10) {
        return e.c(i10, this.f4924d);
    }

    public short c() {
        return this.f4923c;
    }

    public byte[] d() {
        return this.f4924d;
    }

    public int e() {
        return this.f4925e;
    }

    public int f() {
        return this.f4921a;
    }

    public boolean g() {
        return this.f4922b != 0;
    }
}
