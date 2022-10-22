package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f9362a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c3 f9363b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i3(c3 c3Var, long j10) {
        this.f9363b = c3Var;
        this.f9362a = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c3 c3Var = this.f9363b;
        long j10 = this.f9362a;
        c3Var.e();
        c3Var.u();
        c3Var.c().Q().a("Resetting analytics data (FE)");
        c3Var.q().F();
        if (c3Var.s().F(c3Var.j().A())) {
            c3Var.r().f9437j.b(j10);
        }
        boolean g02 = c3Var.f9815a.g0();
        if (!c3Var.s().J()) {
            c3Var.r().H(!g02);
        }
        c3Var.l().C();
        c3Var.f9199h = !g02;
    }
}
