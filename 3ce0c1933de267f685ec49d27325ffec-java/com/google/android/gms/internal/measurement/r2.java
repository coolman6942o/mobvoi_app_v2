package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class r2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzeu f9635a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9636b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ f2 f9637c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r2(f2 f2Var, zzeu zzeuVar, String str) {
        this.f9637c = f2Var;
        this.f9635a = zzeuVar;
        this.f9636b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j5 j5Var;
        j5 j5Var2;
        j5Var = this.f9637c.f9262a;
        j5Var.b0();
        j5Var2 = this.f9637c.f9262a;
        j5Var2.z(this.f9635a, this.f9636b);
    }
}
