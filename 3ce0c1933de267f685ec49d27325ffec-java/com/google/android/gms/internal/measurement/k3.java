package com.google.android.gms.internal.measurement;

import com.google.android.gms.measurement.AppMeasurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AppMeasurement.ConditionalUserProperty f9454a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c3 f9455b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k3(c3 c3Var, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.f9455b = c3Var;
        this.f9454a = conditionalUserProperty;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9455b.k0(this.f9454a);
    }
}
