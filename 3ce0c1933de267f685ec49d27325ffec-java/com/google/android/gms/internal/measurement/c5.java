package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class c5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f9202a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ z4 f9203b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c5(z4 z4Var, long j10) {
        this.f9203b = z4Var;
        this.f9202a = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9203b.B(this.f9202a);
    }
}
