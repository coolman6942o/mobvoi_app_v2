package com.huawei.hms.ml.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.ml.camera.CameraManager;
/* compiled from: PictureCallbackProxy.java */
/* loaded from: classes2.dex */
public final class h implements Camera.PictureCallback {

    /* renamed from: a  reason: collision with root package name */
    private CameraManager.ImageCallback f14025a;

    /* renamed from: b  reason: collision with root package name */
    private g f14026b;

    public h(g gVar, CameraManager.ImageCallback imageCallback) {
        this.f14025a = imageCallback;
        this.f14026b = gVar;
    }

    @Override // android.hardware.Camera.PictureCallback
    public final void onPictureTaken(byte[] bArr, Camera camera) {
        Handler handler = this.f14026b.f14020a;
        if (handler == null) {
            this.f14025a.onImage(bArr);
            return;
        }
        Message.obtain(handler, R.id.mlkit_camera_picture_ha_begin, "MLKitCamera").sendToTarget();
        this.f14025a.onImage(bArr);
        Message.obtain(handler, R.id.mlkit_camera_picture_ha_end).sendToTarget();
    }
}
