package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class p4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ r0 f9593a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ o4 f9594b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p4(o4 o4Var, r0 r0Var) {
        this.f9594b = o4Var;
        this.f9593a = r0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f9594b) {
            this.f9594b.f9552a = false;
            if (!this.f9594b.f9554c.A()) {
                this.f9594b.f9554c.c().R().a("Connected to service");
                this.f9594b.f9554c.F(this.f9593a);
            }
        }
    }
}
