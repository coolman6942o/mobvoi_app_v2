package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f9378a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i1 f9379b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j1(i1 i1Var, boolean z10) {
        this.f9379b = i1Var;
        this.f9378a = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j5 j5Var;
        j5Var = this.f9379b.f9356a;
        j5Var.f0(this.f9378a);
    }
}
