package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class q2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzeu f9606a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzdz f9607b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ f2 f9608c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q2(f2 f2Var, zzeu zzeuVar, zzdz zzdzVar) {
        this.f9608c = f2Var;
        this.f9606a = zzeuVar;
        this.f9607b = zzdzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j5 j5Var;
        j5 j5Var2;
        j5Var = this.f9608c.f9262a;
        j5Var.b0();
        j5Var2 = this.f9608c.f9262a;
        j5Var2.s(this.f9606a, this.f9607b);
    }
}
