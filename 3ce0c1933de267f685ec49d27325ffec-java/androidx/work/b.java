package androidx.work;

import android.os.Build;
/* compiled from: Constraints.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: i  reason: collision with root package name */
    public static final b f4719i = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private NetworkType f4720a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4721b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4722c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4723d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4724e;

    /* renamed from: f  reason: collision with root package name */
    private long f4725f;

    /* renamed from: g  reason: collision with root package name */
    private long f4726g;

    /* renamed from: h  reason: collision with root package name */
    private c f4727h;

    /* compiled from: Constraints.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f4728a = false;

        /* renamed from: b  reason: collision with root package name */
        boolean f4729b = false;

        /* renamed from: c  reason: collision with root package name */
        NetworkType f4730c = NetworkType.NOT_REQUIRED;

        /* renamed from: d  reason: collision with root package name */
        boolean f4731d = false;

        /* renamed from: e  reason: collision with root package name */
        boolean f4732e = false;

        /* renamed from: f  reason: collision with root package name */
        long f4733f = -1;

        /* renamed from: g  reason: collision with root package name */
        long f4734g = -1;

        /* renamed from: h  reason: collision with root package name */
        c f4735h = new c();

        public b a() {
            return new b(this);
        }
    }

    public b() {
        this.f4720a = NetworkType.NOT_REQUIRED;
        this.f4725f = -1L;
        this.f4726g = -1L;
        this.f4727h = new c();
    }

    public c a() {
        return this.f4727h;
    }

    public NetworkType b() {
        return this.f4720a;
    }

    public long c() {
        return this.f4725f;
    }

    public long d() {
        return this.f4726g;
    }

    public boolean e() {
        return this.f4727h.c() > 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f4721b == bVar.f4721b && this.f4722c == bVar.f4722c && this.f4723d == bVar.f4723d && this.f4724e == bVar.f4724e && this.f4725f == bVar.f4725f && this.f4726g == bVar.f4726g && this.f4720a == bVar.f4720a) {
            return this.f4727h.equals(bVar.f4727h);
        }
        return false;
    }

    public boolean f() {
        return this.f4723d;
    }

    public boolean g() {
        return this.f4721b;
    }

    public boolean h() {
        return this.f4722c;
    }

    public int hashCode() {
        long j10 = this.f4725f;
        long j11 = this.f4726g;
        return (((((((((((((this.f4720a.hashCode() * 31) + (this.f4721b ? 1 : 0)) * 31) + (this.f4722c ? 1 : 0)) * 31) + (this.f4723d ? 1 : 0)) * 31) + (this.f4724e ? 1 : 0)) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.f4727h.hashCode();
    }

    public boolean i() {
        return this.f4724e;
    }

    public void j(c cVar) {
        this.f4727h = cVar;
    }

    public void k(NetworkType networkType) {
        this.f4720a = networkType;
    }

    public void l(boolean z10) {
        this.f4723d = z10;
    }

    public void m(boolean z10) {
        this.f4721b = z10;
    }

    public void n(boolean z10) {
        this.f4722c = z10;
    }

    public void o(boolean z10) {
        this.f4724e = z10;
    }

    public void p(long j10) {
        this.f4725f = j10;
    }

    public void q(long j10) {
        this.f4726g = j10;
    }

    b(a aVar) {
        this.f4720a = NetworkType.NOT_REQUIRED;
        this.f4725f = -1L;
        this.f4726g = -1L;
        this.f4727h = new c();
        this.f4721b = aVar.f4728a;
        int i10 = Build.VERSION.SDK_INT;
        this.f4722c = i10 >= 23 && aVar.f4729b;
        this.f4720a = aVar.f4730c;
        this.f4723d = aVar.f4731d;
        this.f4724e = aVar.f4732e;
        if (i10 >= 24) {
            this.f4727h = aVar.f4735h;
            this.f4725f = aVar.f4733f;
            this.f4726g = aVar.f4734g;
        }
    }

    public b(b bVar) {
        this.f4720a = NetworkType.NOT_REQUIRED;
        this.f4725f = -1L;
        this.f4726g = -1L;
        this.f4727h = new c();
        this.f4721b = bVar.f4721b;
        this.f4722c = bVar.f4722c;
        this.f4720a = bVar.f4720a;
        this.f4723d = bVar.f4723d;
        this.f4724e = bVar.f4724e;
        this.f4727h = bVar.f4727h;
    }
}
