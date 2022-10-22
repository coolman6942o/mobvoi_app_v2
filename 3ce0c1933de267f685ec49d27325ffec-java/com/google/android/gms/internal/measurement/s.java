package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f9648a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ long f9649b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ r f9650c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, String str, long j10) {
        this.f9650c = rVar;
        this.f9648a = str;
        this.f9649b = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9650c.y(this.f9648a, this.f9649b);
    }
}
