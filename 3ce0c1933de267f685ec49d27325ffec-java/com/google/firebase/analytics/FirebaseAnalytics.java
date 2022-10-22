package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import b6.i;
import com.google.android.gms.internal.measurement.d2;
import com.mobvoi.wear.providers.OtaColumn;
@Keep
/* loaded from: classes.dex */
public final class FirebaseAnalytics {
    private final d2 zzacw;

    /* loaded from: classes.dex */
    public static class a {
    }

    /* loaded from: classes.dex */
    public static class b {
    }

    /* loaded from: classes.dex */
    public static class c {
    }

    public FirebaseAnalytics(d2 d2Var) {
        i.k(d2Var);
        this.zzacw = d2Var;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        return d2.t0(context).z0();
    }

    public final com.google.android.gms.tasks.b<String> getAppInstanceId() {
        return this.zzacw.o0().B();
    }

    public final void logEvent(String str, Bundle bundle) {
        this.zzacw.y0().logEvent(str, bundle);
    }

    public final void resetAnalyticsData() {
        this.zzacw.o0().I();
    }

    public final void setAnalyticsCollectionEnabled(boolean z10) {
        this.zzacw.y0().setMeasurementEnabled(z10);
    }

    @Keep
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        this.zzacw.r0().E(activity, str, str2);
    }

    public final void setMinimumSessionDuration(long j10) {
        this.zzacw.y0().setMinimumSessionDuration(j10);
    }

    public final void setSessionTimeoutDuration(long j10) {
        this.zzacw.y0().setSessionTimeoutDuration(j10);
    }

    public final void setUserId(String str) {
        this.zzacw.y0().setUserPropertyInternal(OtaColumn.COLUMN_APP, "_id", str);
    }

    public final void setUserProperty(String str, String str2) {
        this.zzacw.y0().setUserProperty(str, str2);
    }
}
