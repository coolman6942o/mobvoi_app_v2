package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class t2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzjx f9674a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzdz f9675b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ f2 f9676c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t2(f2 f2Var, zzjx zzjxVar, zzdz zzdzVar) {
        this.f9676c = f2Var;
        this.f9674a = zzjxVar;
        this.f9675b = zzdzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j5 j5Var;
        j5 j5Var2;
        j5Var = this.f9676c.f9262a;
        j5Var.b0();
        j5Var2 = this.f9676c.f9262a;
        j5Var2.A(this.f9674a, this.f9675b);
    }
}
