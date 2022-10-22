package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.internal.measurement.u4;
import com.google.android.gms.internal.measurement.y4;
@TargetApi(24)
/* loaded from: classes.dex */
public final class AppMeasurementJobService extends JobService implements y4 {

    /* renamed from: a  reason: collision with root package name */
    private u4<AppMeasurementJobService> f10138a;

    private final u4<AppMeasurementJobService> d() {
        if (this.f10138a == null) {
            this.f10138a = new u4<>(this);
        }
        return this.f10138a;
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final boolean a(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.measurement.y4
    @TargetApi(24)
    public final void b(JobParameters jobParameters, boolean z10) {
        jobFinished(jobParameters, false);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void c(Intent intent) {
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

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return d().f(jobParameters);
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return d().g(intent);
    }
}
