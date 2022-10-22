package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class u2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzjx f9695a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzdz f9696b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ f2 f9697c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u2(f2 f2Var, zzjx zzjxVar, zzdz zzdzVar) {
        this.f9697c = f2Var;
        this.f9695a = zzjxVar;
        this.f9696b = zzdzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j5 j5Var;
        j5 j5Var2;
        j5Var = this.f9697c.f9262a;
        j5Var.b0();
        j5Var2 = this.f9697c.f9262a;
        j5Var2.u(this.f9695a, this.f9696b);
    }
}
