package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ w3 f9849a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ x3 f9850b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z3(x3 x3Var, w3 w3Var) {
        this.f9850b = x3Var;
        this.f9849a = w3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9850b.G(this.f9849a);
        x3 x3Var = this.f9850b;
        x3Var.f9794c = null;
        x3Var.l().N(null);
    }
}
