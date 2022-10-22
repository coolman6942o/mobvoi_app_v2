package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f9515a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzjx f9516b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ zzdz f9517c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ a4 f9518d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m4(a4 a4Var, boolean z10, zzjx zzjxVar, zzdz zzdzVar) {
        this.f9518d = a4Var;
        this.f9515a = z10;
        this.f9516b = zzjxVar;
        this.f9517c = zzdzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0 r0Var;
        r0Var = this.f9518d.f9160d;
        if (r0Var == null) {
            this.f9518d.c().K().a("Discarding data. Failed to set user attribute");
            return;
        }
        this.f9518d.G(r0Var, this.f9515a ? null : this.f9516b, this.f9517c);
        this.f9518d.R();
    }
}
