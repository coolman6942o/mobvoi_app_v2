package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.u1;
import com.google.android.gms.internal.measurement.x1;
import y0.a;
/* loaded from: classes.dex */
public final class AppMeasurementReceiver extends a implements x1 {

    /* renamed from: c  reason: collision with root package name */
    private u1 f10139c;

    @Override // com.google.android.gms.internal.measurement.x1
    public final void a(Context context, Intent intent) {
        a.d(context, intent);
    }

    @Override // com.google.android.gms.internal.measurement.x1
    public final BroadcastReceiver.PendingResult b() {
        return goAsync();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f10139c == null) {
            this.f10139c = new u1(this);
        }
        this.f10139c.a(context, intent);
    }
}
