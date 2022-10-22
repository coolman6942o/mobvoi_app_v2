package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ b3 f9245a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ d2 f9246b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e2(d2 d2Var, b3 b3Var) {
        this.f9246b = d2Var;
        this.f9245a = b3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9246b.j0(this.f9245a);
        this.f9246b.a();
    }
}
