package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class k2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzed f9452a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ f2 f9453b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k2(f2 f2Var, zzed zzedVar) {
        this.f9453b = f2Var;
        this.f9452a = zzedVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j5 j5Var;
        j5 j5Var2;
        j5Var = this.f9453b.f9262a;
        j5Var.b0();
        j5Var2 = this.f9453b.f9262a;
        zzed zzedVar = this.f9452a;
        zzdz B = j5Var2.B(zzedVar.f9876a);
        if (B != null) {
            j5Var2.r(zzedVar, B);
        }
    }
}
