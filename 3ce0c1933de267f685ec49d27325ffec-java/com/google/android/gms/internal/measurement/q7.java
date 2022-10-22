package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.crash.FirebaseCrash;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public final class q7 {

    /* renamed from: a  reason: collision with root package name */
    private final AppMeasurement f9631a;

    private q7(AppMeasurement appMeasurement) {
        this.f9631a = appMeasurement;
    }

    public static q7 c(Context context) {
        try {
            return new q7(AppMeasurement.getInstance(context));
        } catch (NoClassDefFoundError e10) {
            String valueOf = String.valueOf(e10);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 50);
            sb2.append("Unable to log event, missing measurement library: ");
            sb2.append(valueOf);
            Log.w("FirebaseCrashAnalytics", sb2.toString());
            return null;
        }
    }

    public final void a(Context context, ExecutorService executorService, FirebaseCrash.a aVar) {
        this.f9631a.registerOnMeasurementEventListener(new p7(context, executorService, aVar));
    }

    public final void b(boolean z10, long j10) {
        Bundle bundle = new Bundle();
        bundle.putInt("fatal", z10 ? 1 : 0);
        bundle.putLong("timestamp", j10);
        this.f9631a.logEventInternal(AppMeasurement.CRASH_ORIGIN, "_ae", bundle);
    }
}
