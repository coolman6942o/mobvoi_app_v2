package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
/* loaded from: classes.dex */
final class s4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ o4 f9657a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s4(o4 o4Var) {
        this.f9657a = o4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9657a.f9554c.B(new ComponentName(this.f9657a.f9554c.getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
