package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import b6.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v {
    private long A;
    private long B;

    /* renamed from: a  reason: collision with root package name */
    private final d2 f9712a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9713b;

    /* renamed from: c  reason: collision with root package name */
    private String f9714c;

    /* renamed from: d  reason: collision with root package name */
    private String f9715d;

    /* renamed from: e  reason: collision with root package name */
    private String f9716e;

    /* renamed from: f  reason: collision with root package name */
    private String f9717f;

    /* renamed from: g  reason: collision with root package name */
    private long f9718g;

    /* renamed from: h  reason: collision with root package name */
    private long f9719h;

    /* renamed from: i  reason: collision with root package name */
    private long f9720i;

    /* renamed from: j  reason: collision with root package name */
    private String f9721j;

    /* renamed from: k  reason: collision with root package name */
    private long f9722k;

    /* renamed from: l  reason: collision with root package name */
    private String f9723l;

    /* renamed from: m  reason: collision with root package name */
    private long f9724m;

    /* renamed from: n  reason: collision with root package name */
    private long f9725n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f9726o;

    /* renamed from: p  reason: collision with root package name */
    private long f9727p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f9728q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f9729r;

    /* renamed from: s  reason: collision with root package name */
    private long f9730s;

    /* renamed from: t  reason: collision with root package name */
    private long f9731t;

    /* renamed from: u  reason: collision with root package name */
    private long f9732u;

    /* renamed from: v  reason: collision with root package name */
    private long f9733v;

    /* renamed from: w  reason: collision with root package name */
    private long f9734w;

    /* renamed from: x  reason: collision with root package name */
    private long f9735x;

    /* renamed from: y  reason: collision with root package name */
    private String f9736y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f9737z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(d2 d2Var, String str) {
        i.k(d2Var);
        i.g(str);
        this.f9712a = d2Var;
        this.f9713b = str;
        d2Var.p();
    }

    public final long A() {
        this.f9712a.p();
        return this.A;
    }

    public final long B() {
        this.f9712a.p();
        return this.B;
    }

    public final void C() {
        this.f9712a.p();
        long j10 = this.f9718g + 1;
        if (j10 > 2147483647L) {
            this.f9712a.c().N().d("Bundle index overflow. appId", z0.I(this.f9713b));
            j10 = 0;
        }
        this.f9737z = true;
        this.f9718g = j10;
    }

    public final long D() {
        this.f9712a.p();
        return this.f9730s;
    }

    public final long E() {
        this.f9712a.p();
        return this.f9731t;
    }

    public final long F() {
        this.f9712a.p();
        return this.f9732u;
    }

    public final long G() {
        this.f9712a.p();
        return this.f9733v;
    }

    public final long H() {
        this.f9712a.p();
        return this.f9735x;
    }

    public final long I() {
        this.f9712a.p();
        return this.f9734w;
    }

    public final String J() {
        this.f9712a.p();
        return this.f9736y;
    }

    public final String K() {
        this.f9712a.p();
        String str = this.f9736y;
        n(null);
        return str;
    }

    public final long L() {
        this.f9712a.p();
        return this.f9727p;
    }

    public final boolean M() {
        this.f9712a.p();
        return this.f9728q;
    }

    public final boolean N() {
        this.f9712a.p();
        return this.f9729r;
    }

    public final void O(long j10) {
        this.f9712a.p();
        this.f9737z |= this.f9719h != j10;
        this.f9719h = j10;
    }

    public final void P(long j10) {
        this.f9712a.p();
        this.f9737z |= this.f9720i != j10;
        this.f9720i = j10;
    }

    public final void Q(long j10) {
        this.f9712a.p();
        this.f9737z |= this.f9722k != j10;
        this.f9722k = j10;
    }

    public final void R(long j10) {
        this.f9712a.p();
        this.f9737z |= this.f9724m != j10;
        this.f9724m = j10;
    }

    public final void S(long j10) {
        this.f9712a.p();
        this.f9737z |= this.f9725n != j10;
        this.f9725n = j10;
    }

    public final void T(long j10) {
        boolean z10 = true;
        i.a(j10 >= 0);
        this.f9712a.p();
        boolean z11 = this.f9737z;
        if (this.f9718g == j10) {
            z10 = false;
        }
        this.f9737z = z11 | z10;
        this.f9718g = j10;
    }

    public final void U(long j10) {
        this.f9712a.p();
        this.f9737z |= this.A != j10;
        this.A = j10;
    }

    public final void V(long j10) {
        this.f9712a.p();
        this.f9737z |= this.B != j10;
        this.B = j10;
    }

    public final void W(long j10) {
        this.f9712a.p();
        this.f9737z |= this.f9730s != j10;
        this.f9730s = j10;
    }

    public final void X(long j10) {
        this.f9712a.p();
        this.f9737z |= this.f9731t != j10;
        this.f9731t = j10;
    }

    public final void Y(long j10) {
        this.f9712a.p();
        this.f9737z |= this.f9732u != j10;
        this.f9732u = j10;
    }

    public final void Z(long j10) {
        this.f9712a.p();
        this.f9737z |= this.f9733v != j10;
        this.f9733v = j10;
    }

    public final String a() {
        this.f9712a.p();
        return this.f9714c;
    }

    public final void a0(long j10) {
        this.f9712a.p();
        this.f9737z |= this.f9735x != j10;
        this.f9735x = j10;
    }

    public final String b() {
        this.f9712a.p();
        return this.f9715d;
    }

    public final void b0(long j10) {
        this.f9712a.p();
        this.f9737z |= this.f9734w != j10;
        this.f9734w = j10;
    }

    public final boolean c() {
        this.f9712a.p();
        return this.f9726o;
    }

    public final void d(String str) {
        this.f9712a.p();
        this.f9737z |= !r5.C0(this.f9721j, str);
        this.f9721j = str;
    }

    public final void e(boolean z10) {
        this.f9712a.p();
        this.f9737z |= this.f9726o != z10;
        this.f9726o = z10;
    }

    public final void f(long j10) {
        this.f9712a.p();
        this.f9737z |= this.f9727p != j10;
        this.f9727p = j10;
    }

    public final String g() {
        this.f9712a.p();
        return this.f9721j;
    }

    public final String h() {
        this.f9712a.p();
        return this.f9713b;
    }

    public final void i(String str) {
        this.f9712a.p();
        this.f9737z |= !r5.C0(this.f9714c, str);
        this.f9714c = str;
    }

    public final void j(String str) {
        this.f9712a.p();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f9737z |= !r5.C0(this.f9715d, str);
        this.f9715d = str;
    }

    public final void k(String str) {
        this.f9712a.p();
        this.f9737z |= !r5.C0(this.f9716e, str);
        this.f9716e = str;
    }

    public final void l(String str) {
        this.f9712a.p();
        this.f9737z |= !r5.C0(this.f9717f, str);
        this.f9717f = str;
    }

    public final void m(String str) {
        this.f9712a.p();
        this.f9737z |= !r5.C0(this.f9723l, str);
        this.f9723l = str;
    }

    public final void n(String str) {
        this.f9712a.p();
        this.f9737z |= !r5.C0(this.f9736y, str);
        this.f9736y = str;
    }

    public final void o(boolean z10) {
        this.f9712a.p();
        this.f9737z = this.f9728q != z10;
        this.f9728q = z10;
    }

    public final void p(boolean z10) {
        this.f9712a.p();
        this.f9737z = this.f9729r != z10;
        this.f9729r = z10;
    }

    public final void q() {
        this.f9712a.p();
        this.f9737z = false;
    }

    public final String r() {
        this.f9712a.p();
        return this.f9716e;
    }

    public final String s() {
        this.f9712a.p();
        return this.f9717f;
    }

    public final long t() {
        this.f9712a.p();
        return this.f9719h;
    }

    public final long u() {
        this.f9712a.p();
        return this.f9720i;
    }

    public final long v() {
        this.f9712a.p();
        return this.f9722k;
    }

    public final String w() {
        this.f9712a.p();
        return this.f9723l;
    }

    public final long x() {
        this.f9712a.p();
        return this.f9724m;
    }

    public final long y() {
        this.f9712a.p();
        return this.f9725n;
    }

    public final long z() {
        this.f9712a.p();
        return this.f9718g;
    }
}
