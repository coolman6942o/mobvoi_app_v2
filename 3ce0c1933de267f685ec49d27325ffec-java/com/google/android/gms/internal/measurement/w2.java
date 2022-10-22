package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class w2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzdz f9770a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ f2 f9771b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w2(f2 f2Var, zzdz zzdzVar) {
        this.f9771b = f2Var;
        this.f9770a = zzdzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j5 j5Var;
        j5 j5Var2;
        j5Var = this.f9771b.f9262a;
        j5Var.b0();
        j5Var2 = this.f9771b.f9262a;
        j5Var2.F(this.f9770a);
    }
}
