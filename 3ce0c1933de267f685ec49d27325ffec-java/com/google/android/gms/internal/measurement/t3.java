package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f9677a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c3 f9678b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t3(c3 c3Var, long j10) {
        this.f9678b = c3Var;
        this.f9677a = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9678b.r().f9447t.b(this.f9677a);
        this.f9678b.c().Q().d("Session timeout duration set", Long.valueOf(this.f9677a));
    }
}
