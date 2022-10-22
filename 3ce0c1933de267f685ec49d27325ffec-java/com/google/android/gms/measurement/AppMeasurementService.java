package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.u4;
import com.google.android.gms.internal.measurement.y4;
import y0.a;
/* loaded from: classes.dex */
public final class AppMeasurementService extends Service implements y4 {

    /* renamed from: a  reason: collision with root package name */
    private u4<AppMeasurementService> f10140a;

    private final u4<AppMeasurementService> d() {
        if (this.f10140a == null) {
            this.f10140a = new u4<>(this);
        }
        return this.f10140a;
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final boolean a(int i10) {
        return stopSelfResult(i10);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void b(JobParameters jobParameters, boolean z10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void c(Intent intent) {
        a.c(intent);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return d().a(intent);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        d().b();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        d().c();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        d().d(intent);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i10, int i11) {
        return d().e(intent, i10, i11);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return d().g(intent);
    }
}
