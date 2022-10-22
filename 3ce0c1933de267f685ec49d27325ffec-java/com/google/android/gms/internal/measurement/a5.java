package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.huawei.hms.ml.camera.CameraConfig;
/* loaded from: classes.dex */
final class a5 extends h0 {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ z4 f9166e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a5(z4 z4Var, a3 a3Var) {
        super(a3Var);
        this.f9166e = z4Var;
    }

    @Override // com.google.android.gms.internal.measurement.h0
    public final void c() {
        z4 z4Var = this.f9166e;
        z4Var.e();
        z4Var.c().R().d("Session started, time", Long.valueOf(z4Var.b().c()));
        z4Var.r().f9448u.b(false);
        z4Var.i().Y(CameraConfig.CAMERA_FOCUS_AUTO, "_s", new Bundle());
        z4Var.r().f9449v.b(z4Var.b().b());
    }
}
