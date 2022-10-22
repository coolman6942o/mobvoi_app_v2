package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class x4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ j5 f9799a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Runnable f9800b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x4(u4 u4Var, j5 j5Var, Runnable runnable) {
        this.f9799a = j5Var;
        this.f9800b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9799a.b0();
        this.f9799a.I(this.f9800b);
        this.f9799a.W();
    }
}
