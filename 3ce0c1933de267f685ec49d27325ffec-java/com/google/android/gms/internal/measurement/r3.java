package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f9638a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c3 f9639b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r3(c3 c3Var, boolean z10) {
        this.f9639b = c3Var;
        this.f9638a = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9639b.n0(this.f9638a);
    }
}
