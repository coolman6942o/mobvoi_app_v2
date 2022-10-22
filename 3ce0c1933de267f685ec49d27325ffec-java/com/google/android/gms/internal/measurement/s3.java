package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f9655a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c3 f9656b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s3(c3 c3Var, long j10) {
        this.f9656b = c3Var;
        this.f9655a = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9656b.r().f9446s.b(this.f9655a);
        this.f9656b.c().Q().d("Minimum session duration set", Long.valueOf(this.f9655a));
    }
}
