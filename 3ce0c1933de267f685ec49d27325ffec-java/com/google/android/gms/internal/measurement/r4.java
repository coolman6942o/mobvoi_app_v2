package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class r4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ r0 f9640a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ o4 f9641b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r4(o4 o4Var, r0 r0Var) {
        this.f9641b = o4Var;
        this.f9640a = r0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f9641b) {
            this.f9641b.f9552a = false;
            if (!this.f9641b.f9554c.A()) {
                this.f9641b.f9554c.c().Q().a("Connected to remote service");
                this.f9641b.f9554c.F(this.f9640a);
            }
        }
    }
}
