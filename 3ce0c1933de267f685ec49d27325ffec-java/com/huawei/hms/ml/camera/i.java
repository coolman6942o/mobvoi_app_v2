package com.huawei.hms.ml.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.ml.camera.CameraManager;
/* compiled from: PreviewCallbackProxy.java */
/* loaded from: classes2.dex */
public final class i implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    private CameraManager.FrameCallback f14027a;

    /* renamed from: b  reason: collision with root package name */
    private g f14028b;

    public i(g gVar, CameraManager.FrameCallback frameCallback) {
        this.f14027a = frameCallback;
        this.f14028b = gVar;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        Handler handler = this.f14028b.f14020a;
        if (handler == null) {
            this.f14027a.onFrame(bArr);
            return;
        }
        Message.obtain(handler, R.id.mlkit_camera_preview_ha_begin, "MLKitCamera").sendToTarget();
        this.f14027a.onFrame(bArr);
        Message.obtain(handler, R.id.mlkit_camera_preview_ha_end).sendToTarget();
    }
}
