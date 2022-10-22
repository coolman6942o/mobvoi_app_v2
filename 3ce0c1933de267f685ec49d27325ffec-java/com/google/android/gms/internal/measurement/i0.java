package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ a3 f9354a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ h0 f9355b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(h0 h0Var, a3 a3Var) {
        this.f9355b = h0Var;
        this.f9354a = a3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9354a.d();
        if (z1.z()) {
            this.f9354a.d().J(this);
            return;
        }
        boolean e10 = this.f9355b.e();
        this.f9355b.f9311c = 0L;
        if (e10) {
            this.f9355b.c();
        }
    }
}
