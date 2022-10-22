package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import b6.i;
import com.google.android.gms.internal.measurement.y4;
import com.mobvoi.wear.util.TelephonyUtil;
/* loaded from: classes.dex */
public final class u4<T extends Context & y4> {

    /* renamed from: a  reason: collision with root package name */
    private final T f9707a;

    public u4(T t10) {
        i.k(t10);
        this.f9707a = t10;
    }

    public static boolean j(Context context, boolean z10) {
        i.k(context);
        return r5.c0(context, Build.VERSION.SDK_INT >= 24 ? "com.google.android.gms.measurement.AppMeasurementJobService" : "com.google.android.gms.measurement.AppMeasurementService");
    }

    private final void k(Runnable runnable) {
        d2 t02 = d2.t0(this.f9707a);
        t02.d().J(new x4(this, t02, runnable));
    }

    private final z0 l() {
        return d2.t0(this.f9707a).c();
    }

    public final IBinder a(Intent intent) {
        if (intent == null) {
            l().K().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new f2(d2.t0(this.f9707a));
        }
        l().N().d("onBind received unknown action", action);
        return null;
    }

    public final void b() {
        d2.t0(this.f9707a).c().R().a("Local AppMeasurementService is starting up");
    }

    public final void c() {
        d2.t0(this.f9707a).c().R().a("Local AppMeasurementService is shutting down");
    }

    public final void d(Intent intent) {
        if (intent == null) {
            l().K().a("onRebind called with null intent");
            return;
        }
        l().R().d("onRebind called. action", intent.getAction());
    }

    public final int e(final Intent intent, int i10, final int i11) {
        final z0 c10 = d2.t0(this.f9707a).c();
        if (intent == null) {
            c10.N().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        c10.R().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i11), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            k(new Runnable(this, i11, c10, intent) { // from class: com.google.android.gms.internal.measurement.v4

                /* renamed from: a  reason: collision with root package name */
                private final u4 f9745a;

                /* renamed from: b  reason: collision with root package name */
                private final int f9746b;

                /* renamed from: c  reason: collision with root package name */
                private final z0 f9747c;

                /* renamed from: d  reason: collision with root package name */
                private final Intent f9748d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f9745a = this;
                    this.f9746b = i11;
                    this.f9747c = c10;
                    this.f9748d = intent;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f9745a.h(this.f9746b, this.f9747c, this.f9748d);
                }
            });
        }
        return 2;
    }

    @TargetApi(24)
    public final boolean f(final JobParameters jobParameters) {
        final z0 c10 = d2.t0(this.f9707a).c();
        String string = jobParameters.getExtras().getString(TelephonyUtil.KEY_SIM_ACTION);
        c10.R().d("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        k(new Runnable(this, c10, jobParameters) { // from class: com.google.android.gms.internal.measurement.w4

            /* renamed from: a  reason: collision with root package name */
            private final u4 f9776a;

            /* renamed from: b  reason: collision with root package name */
            private final z0 f9777b;

            /* renamed from: c  reason: collision with root package name */
            private final JobParameters f9778c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f9776a = this;
                this.f9777b = c10;
                this.f9778c = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f9776a.i(this.f9777b, this.f9778c);
            }
        });
        return true;
    }

    public final boolean g(Intent intent) {
        if (intent == null) {
            l().K().a("onUnbind called with null intent");
            return true;
        }
        l().R().d("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void h(int i10, z0 z0Var, Intent intent) {
        if (this.f9707a.a(i10)) {
            z0Var.R().d("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i10));
            l().R().a("Completed wakeful intent.");
            this.f9707a.c(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i(z0 z0Var, JobParameters jobParameters) {
        z0Var.R().a("AppMeasurementJobService processed last upload request.");
        this.f9707a.b(jobParameters, false);
    }
}
