package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
public final class b1 {

    /* renamed from: a  reason: collision with root package name */
    private final int f9173a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9174b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9175c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ z0 f9176d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b1(z0 z0Var, int i10, boolean z10, boolean z11) {
        this.f9176d = z0Var;
        this.f9173a = i10;
        this.f9174b = z10;
        this.f9175c = z11;
    }

    public final void a(String str) {
        this.f9176d.G(this.f9173a, this.f9174b, this.f9175c, str, null, null, null);
    }

    public final void b(String str, Object obj, Object obj2, Object obj3) {
        this.f9176d.G(this.f9173a, this.f9174b, this.f9175c, str, obj, obj2, obj3);
    }

    public final void c(String str, Object obj, Object obj2) {
        this.f9176d.G(this.f9173a, this.f9174b, this.f9175c, str, obj, obj2, null);
    }

    public final void d(String str, Object obj) {
        this.f9176d.G(this.f9173a, this.f9174b, this.f9175c, str, obj, null, null);
    }
}
