package wk;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f36293a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36294b;

    /* renamed from: c  reason: collision with root package name */
    public String f36295c;

    /* renamed from: d  reason: collision with root package name */
    public int f36296d;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public a f36297a = new a();

        public a a() {
            return this.f36297a;
        }

        public b b(boolean z10) {
            this.f36297a.e(z10);
            return this;
        }

        public b c(String str) {
            this.f36297a.f(str);
            return this;
        }

        public b d(boolean z10) {
            this.f36297a.g(z10);
            return this;
        }
    }

    public a() {
        this.f36293a = true;
        this.f36294b = true;
        this.f36295c = "Realtek";
        this.f36296d = 1;
    }

    public int a() {
        return this.f36296d;
    }

    public String b() {
        return this.f36295c;
    }

    public boolean c() {
        return this.f36293a;
    }

    public boolean d() {
        return this.f36294b;
    }

    public void e(boolean z10) {
        this.f36293a = z10;
    }

    public void f(String str) {
        this.f36295c = str;
    }

    public void g(boolean z10) {
        this.f36294b = z10;
    }

    public String toString() {
        return "RtkConfigure{" + String.format("\n\tdebugEnabled=%b, printLog=%b, logTag=%s, globalLogLevel=0x%02X", Boolean.valueOf(this.f36293a), Boolean.valueOf(this.f36294b), this.f36295c, Integer.valueOf(this.f36296d)) + "\n}";
    }
}
