package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ml.camera.CameraConfig;
/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(14)
/* loaded from: classes.dex */
public final class v3 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ c3 f9744a;

    private v3(c3 c3Var) {
        this.f9744a = c3Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v3(c3 c3Var, d3 d3Var) {
        this(c3Var);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Uri data;
        try {
            this.f9744a.c().R().a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (!(intent == null || (data = intent.getData()) == null || !data.isHierarchical())) {
                if (bundle == null) {
                    Bundle A = this.f9744a.p().A(data);
                    this.f9744a.p();
                    String str = r5.p0(intent) ? "gs" : CameraConfig.CAMERA_FOCUS_AUTO;
                    if (A != null) {
                        this.f9744a.G(str, "_cmp", A);
                    }
                }
                String queryParameter = data.getQueryParameter("referrer");
                if (!TextUtils.isEmpty(queryParameter)) {
                    if (!(queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content")))) {
                        this.f9744a.c().Q().a("Activity created with data 'referrer' param without gclid and at least one utm field");
                        return;
                    }
                    this.f9744a.c().Q().d("Activity created with referrer", queryParameter);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        this.f9744a.P(CameraConfig.CAMERA_FOCUS_AUTO, "_ldl", queryParameter);
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e10) {
            this.f9744a.c().K().d("Throwable caught in onActivityCreated", e10);
        }
        this.f9744a.m().z(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.f9744a.m().A(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.f9744a.m().B(activity);
        z4 q5 = this.f9744a.q();
        q5.d().J(new d5(q5, q5.b().c()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.f9744a.m().C(activity);
        z4 q5 = this.f9744a.q();
        q5.d().J(new c5(q5, q5.b().c()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f9744a.m().D(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
