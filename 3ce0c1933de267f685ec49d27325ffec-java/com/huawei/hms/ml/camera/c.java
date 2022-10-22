package com.huawei.hms.ml.camera;

import android.hardware.Camera;
import android.util.Log;
/* compiled from: CameraExposureManager.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private Camera f14009a;

    public final synchronized void a(Camera camera) {
        this.f14009a = camera;
    }

    public final synchronized CameraExposureData a() {
        return new CameraExposureData(this.f14009a.getParameters().getMaxExposureCompensation(), this.f14009a.getParameters().getMinExposureCompensation(), this.f14009a.getParameters().getExposureCompensation(), this.f14009a.getParameters().getExposureCompensationStep());
    }

    public final synchronized void a(int i10) {
        Camera camera = this.f14009a;
        if (camera != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                parameters.setExposureCompensation(i10);
                this.f14009a.setParameters(parameters);
            } catch (RuntimeException unused) {
                Log.w("CameraManager", "CameraExposureManager::setCompensation failed");
            }
        }
    }
}
