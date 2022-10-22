package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.u1;
import com.google.android.gms.internal.measurement.x1;
/* loaded from: classes.dex */
public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements x1 {

    /* renamed from: a  reason: collision with root package name */
    private u1 f10137a;

    @Override // com.google.android.gms.internal.measurement.x1
    public final void a(Context context, Intent intent) {
    }

    @Override // com.google.android.gms.internal.measurement.x1
    public final BroadcastReceiver.PendingResult b() {
        return goAsync();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f10137a == null) {
            this.f10137a = new u1(this);
        }
        this.f10137a.a(context, intent);
    }
}
