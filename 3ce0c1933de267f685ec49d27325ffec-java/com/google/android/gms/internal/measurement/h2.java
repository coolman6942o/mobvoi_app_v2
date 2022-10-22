package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class h2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzed f9318a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzdz f9319b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ f2 f9320c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h2(f2 f2Var, zzed zzedVar, zzdz zzdzVar) {
        this.f9320c = f2Var;
        this.f9318a = zzedVar;
        this.f9319b = zzdzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j5 j5Var;
        j5 j5Var2;
        j5Var = this.f9320c.f9262a;
        j5Var.b0();
        j5Var2 = this.f9320c.f9262a;
        j5Var2.x(this.f9318a, this.f9319b);
    }
}
