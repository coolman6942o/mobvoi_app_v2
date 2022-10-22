package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f9247a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9248b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Object f9249c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ long f9250d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ c3 f9251e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e3(c3 c3Var, String str, String str2, Object obj, long j10) {
        this.f9251e = c3Var;
        this.f9247a = str;
        this.f9248b = str2;
        this.f9249c = obj;
        this.f9250d = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9251e.c0(this.f9247a, this.f9248b, this.f9249c, this.f9250d);
    }
}
