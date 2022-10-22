package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class i2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzed f9359a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzdz f9360b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ f2 f9361c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i2(f2 f2Var, zzed zzedVar, zzdz zzdzVar) {
        this.f9361c = f2Var;
        this.f9359a = zzedVar;
        this.f9360b = zzdzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j5 j5Var;
        j5 j5Var2;
        j5Var = this.f9361c.f9262a;
        j5Var.b0();
        j5Var2 = this.f9361c.f9262a;
        j5Var2.r(this.f9359a, this.f9360b);
    }
}
