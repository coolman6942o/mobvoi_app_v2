package com.google.android.gms.internal.measurement;

import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f9698a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9699b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ long f9700c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Bundle f9701d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ boolean f9702e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ boolean f9703f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ boolean f9704g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ String f9705h;

    /* renamed from: i  reason: collision with root package name */
    private final /* synthetic */ c3 f9706i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u3(c3 c3Var, String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        this.f9706i = c3Var;
        this.f9698a = str;
        this.f9699b = str2;
        this.f9700c = j10;
        this.f9701d = bundle;
        this.f9702e = z10;
        this.f9703f = z11;
        this.f9704g = z12;
        this.f9705h = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9706i.i0(this.f9698a, this.f9699b, this.f9700c, this.f9701d, this.f9702e, this.f9703f, this.f9704g, this.f9705h);
    }
}
