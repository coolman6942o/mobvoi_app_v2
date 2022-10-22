package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class d5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f9231a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ z4 f9232b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d5(z4 z4Var, long j10) {
        this.f9232b = z4Var;
        this.f9231a = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9232b.C(this.f9231a);
    }
}
