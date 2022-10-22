package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f9670a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ long f9671b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ r f9672c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar, String str, long j10) {
        this.f9672c = rVar;
        this.f9670a = str;
        this.f9671b = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9672c.B(this.f9670a, this.f9671b);
    }
}
