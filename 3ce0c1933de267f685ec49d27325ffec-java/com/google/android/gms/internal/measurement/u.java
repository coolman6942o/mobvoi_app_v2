package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f9685a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ r f9686b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j10) {
        this.f9686b = rVar;
        this.f9685a = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9686b.D(this.f9685a);
    }
}
