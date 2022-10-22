package androidx.navigation;
/* compiled from: NavOptions.java */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3531a;

    /* renamed from: b  reason: collision with root package name */
    private int f3532b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3533c;

    /* renamed from: d  reason: collision with root package name */
    private int f3534d;

    /* renamed from: e  reason: collision with root package name */
    private int f3535e;

    /* renamed from: f  reason: collision with root package name */
    private int f3536f;

    /* renamed from: g  reason: collision with root package name */
    private int f3537g;

    /* compiled from: NavOptions.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f3538a;

        /* renamed from: c  reason: collision with root package name */
        boolean f3540c;

        /* renamed from: b  reason: collision with root package name */
        int f3539b = -1;

        /* renamed from: d  reason: collision with root package name */
        int f3541d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f3542e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f3543f = -1;

        /* renamed from: g  reason: collision with root package name */
        int f3544g = -1;

        public q a() {
            return new q(this.f3538a, this.f3539b, this.f3540c, this.f3541d, this.f3542e, this.f3543f, this.f3544g);
        }

        public a b(int i10) {
            this.f3541d = i10;
            return this;
        }

        public a c(int i10) {
            this.f3542e = i10;
            return this;
        }

        public a d(boolean z10) {
            this.f3538a = z10;
            return this;
        }

        public a e(int i10) {
            this.f3543f = i10;
            return this;
        }

        public a f(int i10) {
            this.f3544g = i10;
            return this;
        }

        public a g(int i10, boolean z10) {
            this.f3539b = i10;
            this.f3540c = z10;
            return this;
        }
    }

    q(boolean z10, int i10, boolean z11, int i11, int i12, int i13, int i14) {
        this.f3531a = z10;
        this.f3532b = i10;
        this.f3533c = z11;
        this.f3534d = i11;
        this.f3535e = i12;
        this.f3536f = i13;
        this.f3537g = i14;
    }

    public int a() {
        return this.f3534d;
    }

    public int b() {
        return this.f3535e;
    }

    public int c() {
        return this.f3536f;
    }

    public int d() {
        return this.f3537g;
    }

    public int e() {
        return this.f3532b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        return this.f3531a == qVar.f3531a && this.f3532b == qVar.f3532b && this.f3533c == qVar.f3533c && this.f3534d == qVar.f3534d && this.f3535e == qVar.f3535e && this.f3536f == qVar.f3536f && this.f3537g == qVar.f3537g;
    }

    public boolean f() {
        return this.f3533c;
    }

    public boolean g() {
        return this.f3531a;
    }

    public int hashCode() {
        return ((((((((((((g() ? 1 : 0) * 31) + e()) * 31) + (f() ? 1 : 0)) * 31) + a()) * 31) + b()) * 31) + c()) * 31) + d();
    }
}
