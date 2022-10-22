package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class j2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzed f9380a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ f2 f9381b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j2(f2 f2Var, zzed zzedVar) {
        this.f9381b = f2Var;
        this.f9380a = zzedVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j5 j5Var;
        j5 j5Var2;
        j5Var = this.f9381b.f9262a;
        j5Var.b0();
        j5Var2 = this.f9381b.f9262a;
        zzed zzedVar = this.f9380a;
        zzdz B = j5Var2.B(zzedVar.f9876a);
        if (B != null) {
            j5Var2.x(zzedVar, B);
        }
    }
}
