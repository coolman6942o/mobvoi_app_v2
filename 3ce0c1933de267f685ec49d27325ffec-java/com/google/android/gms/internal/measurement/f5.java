package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import com.mobvoi.wear.util.TelephonyUtil;
/* loaded from: classes.dex */
public final class f5 extends i5 {

    /* renamed from: d  reason: collision with root package name */
    private final AlarmManager f9270d = (AlarmManager) getContext().getSystemService("alarm");

    /* renamed from: e  reason: collision with root package name */
    private final h0 f9271e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f9272f;

    /* JADX INFO: Access modifiers changed from: protected */
    public f5(j5 j5Var) {
        super(j5Var);
        this.f9271e = new g5(this, j5Var.e0(), j5Var);
    }

    private final int A() {
        if (this.f9272f == null) {
            String valueOf = String.valueOf(getContext().getPackageName());
            this.f9272f = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.f9272f.intValue();
    }

    private final PendingIntent B() {
        Intent className = new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(getContext(), 0, className, 0);
    }

    @TargetApi(24)
    private final void D() {
        c().R().d("Cancelling job. JobID", Integer.valueOf(A()));
        ((JobScheduler) getContext().getSystemService("jobscheduler")).cancel(A());
    }

    public final void C(long j10) {
        w();
        if (!u1.b(getContext())) {
            c().Q().a("Receiver not registered/enabled");
        }
        if (!u4.j(getContext(), false)) {
            c().Q().a("Service not registered/enabled");
        }
        z();
        long c10 = b().c() + j10;
        if (j10 < Math.max(0L, p0.f9584z.a().longValue()) && !this.f9271e.e()) {
            c().R().a("Scheduling upload with DelayedRunnable");
            this.f9271e.f(j10);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            c().R().a("Scheduling upload with JobScheduler");
            JobInfo.Builder builder = new JobInfo.Builder(A(), new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementJobService"));
            builder.setMinimumLatency(j10);
            builder.setOverrideDeadline(j10 << 1);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString(TelephonyUtil.KEY_SIM_ACTION, "com.google.android.gms.measurement.UPLOAD");
            builder.setExtras(persistableBundle);
            JobInfo build = builder.build();
            c().R().d("Scheduling job. JobID", Integer.valueOf(A()));
            ((JobScheduler) getContext().getSystemService("jobscheduler")).schedule(build);
            return;
        }
        c().R().a("Scheduling upload with AlarmManager");
        this.f9270d.setInexactRepeating(2, c10, Math.max(p0.f9579u.a().longValue(), j10), B());
    }

    @Override // com.google.android.gms.internal.measurement.i5
    protected final boolean x() {
        this.f9270d.cancel(B());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        D();
        return false;
    }

    public final void z() {
        w();
        this.f9270d.cancel(B());
        this.f9271e.a();
        if (Build.VERSION.SDK_INT >= 24) {
            D();
        }
    }
}
