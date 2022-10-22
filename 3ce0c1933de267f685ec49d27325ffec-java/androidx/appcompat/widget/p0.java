package androidx.appcompat.widget;
/* compiled from: RtlSpacingHelper.java */
/* loaded from: classes.dex */
class p0 {

    /* renamed from: a  reason: collision with root package name */
    private int f1281a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f1282b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f1283c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f1284d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f1285e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1286f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1287g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1288h = false;

    public int a() {
        return this.f1287g ? this.f1281a : this.f1282b;
    }

    public int b() {
        return this.f1281a;
    }

    public int c() {
        return this.f1282b;
    }

    public int d() {
        return this.f1287g ? this.f1282b : this.f1281a;
    }

    public void e(int i10, int i11) {
        this.f1288h = false;
        if (i10 != Integer.MIN_VALUE) {
            this.f1285e = i10;
            this.f1281a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1286f = i11;
            this.f1282b = i11;
        }
    }

    public void f(boolean z10) {
        if (z10 != this.f1287g) {
            this.f1287g = z10;
            if (!this.f1288h) {
                this.f1281a = this.f1285e;
                this.f1282b = this.f1286f;
            } else if (z10) {
                int i10 = this.f1284d;
                if (i10 == Integer.MIN_VALUE) {
                    i10 = this.f1285e;
                }
                this.f1281a = i10;
                int i11 = this.f1283c;
                if (i11 == Integer.MIN_VALUE) {
                    i11 = this.f1286f;
                }
                this.f1282b = i11;
            } else {
                int i12 = this.f1283c;
                if (i12 == Integer.MIN_VALUE) {
                    i12 = this.f1285e;
                }
                this.f1281a = i12;
                int i13 = this.f1284d;
                if (i13 == Integer.MIN_VALUE) {
                    i13 = this.f1286f;
                }
                this.f1282b = i13;
            }
        }
    }

    public void g(int i10, int i11) {
        this.f1283c = i10;
        this.f1284d = i11;
        this.f1288h = true;
        if (this.f1287g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f1281a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f1282b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f1281a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1282b = i11;
        }
    }
}
