package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class v1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ d2 f9740a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ z0 f9741b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v1(u1 u1Var, d2 d2Var, z0 z0Var) {
        this.f9740a = d2Var;
        this.f9741b = z0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f9740a.w0() == null) {
            this.f9741b.K().a("Install Referrer Reporter is null");
        } else {
            this.f9740a.w0().c();
        }
    }
}
