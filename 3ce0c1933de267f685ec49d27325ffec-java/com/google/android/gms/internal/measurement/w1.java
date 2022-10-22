package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.huawei.hms.ml.camera.CameraConfig;
/* loaded from: classes.dex */
final class w1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ d2 f9764a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ long f9765b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Bundle f9766c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Context f9767d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ z0 f9768e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ BroadcastReceiver.PendingResult f9769f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w1(u1 u1Var, d2 d2Var, long j10, Bundle bundle, Context context, z0 z0Var, BroadcastReceiver.PendingResult pendingResult) {
        this.f9764a = d2Var;
        this.f9765b = j10;
        this.f9766c = bundle;
        this.f9767d = context;
        this.f9768e = z0Var;
        this.f9769f = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long a10 = this.f9764a.L().f9437j.a();
        long j10 = this.f9765b;
        if (a10 > 0 && (j10 >= a10 || j10 <= 0)) {
            j10 = a10 - 1;
        }
        if (j10 > 0) {
            this.f9766c.putLong("click_timestamp", j10);
        }
        this.f9766c.putString("_cis", "referrer broadcast");
        AppMeasurement.getInstance(this.f9767d).logEventInternal(CameraConfig.CAMERA_FOCUS_AUTO, "_cmp", this.f9766c);
        this.f9768e.R().a("Install campaign recorded");
        BroadcastReceiver.PendingResult pendingResult = this.f9769f;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}
