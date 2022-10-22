package com.google.android.gms.internal.measurement;

import com.google.android.gms.measurement.AppMeasurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AppMeasurement.ConditionalUserProperty f9382a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c3 f9383b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j3(c3 c3Var, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.f9383b = c3Var;
        this.f9382a = conditionalUserProperty;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9383b.h0(this.f9382a);
    }
}
