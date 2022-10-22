package com.huawei.hms.ml.camera;

import android.hardware.Camera;
import android.util.Log;
/* compiled from: CameraZoomManager.java */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private Camera f14019a;

    public final synchronized void a(Camera camera) {
        this.f14019a = camera;
    }

    public final synchronized boolean b() {
        Camera camera = this.f14019a;
        if (camera == null) {
            return false;
        }
        return camera.getParameters().isZoomSupported();
    }

    public final synchronized CameraZoomData a() {
        return new CameraZoomData(this.f14019a.getParameters().getMaxZoom(), this.f14019a.getParameters().getZoom(), this.f14019a.getParameters().getZoomRatios());
    }

    public final synchronized void a(int i10) {
        Camera camera = this.f14019a;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setZoom(i10);
            try {
                this.f14019a.setParameters(parameters);
            } catch (RuntimeException e10) {
                Log.e("CameraManager", "CameraZoomManager::setCameraZoomIndex failed: " + e10.getMessage());
            }
        }
    }
}
