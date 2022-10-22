package com.huawei.hms.ml.camera;

import android.graphics.Point;
import android.hardware.Camera;
import android.util.Log;
import java.util.List;
/* compiled from: CameraConfigImpl.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    Point f14006a;

    /* renamed from: b  reason: collision with root package name */
    private CameraConfig f14007b;

    /* renamed from: c  reason: collision with root package name */
    private Point f14008c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Camera camera, CameraConfig cameraConfig) {
        if (camera == null || cameraConfig == null) {
            throw new IllegalArgumentException("initCameraParameters param is invalid");
        }
        Camera.Parameters parameters = camera.getParameters();
        this.f14007b = cameraConfig;
        this.f14006a = a(parameters, cameraConfig.getCameraExpectSize(), false);
        Log.d("CameraManager", "initCameraParameters previewCameraSize: " + this.f14006a.toString());
        if (cameraConfig.getCameraMode() == 0) {
            this.f14008c = a(parameters, cameraConfig.getCameraExpectSize(), true);
            Log.d("CameraManager", "initCameraParameters pictureCameraSize: " + this.f14008c.toString());
        }
        Point point = this.f14006a;
        Point point2 = this.f14008c;
        if (this.f14007b != null) {
            Camera.Parameters parameters2 = camera.getParameters();
            parameters2.setPreviewSize(point.x, point.y);
            if (this.f14007b.getCameraMode() == 0) {
                parameters2.setPictureSize(point2.x, point2.y);
            }
            CameraConfig cameraConfig2 = this.f14007b;
            if (cameraConfig2 != null) {
                String torchMode = cameraConfig2.getTorchMode();
                if (!torchMode.equals(CameraConfig.CAMERA_TORCH_OFF) && !torchMode.equals(CameraConfig.CAMERA_TORCH_ON)) {
                    torchMode = CameraConfig.CAMERA_TORCH_OFF;
                }
                parameters2.setFlashMode(torchMode);
            }
            a(parameters2);
            if (parameters2.isZoomSupported()) {
                parameters2.setZoom(1);
            } else {
                Log.w("CameraManager", "initCameraParameters::setDefaultZoom not support zoom");
            }
            if (this.f14007b.getRecordingHint()) {
                parameters2.setRecordingHint(true);
            }
            camera.setParameters(parameters2);
        }
    }

    private static Point a(Camera.Parameters parameters, Point point, boolean z10) {
        List<Camera.Size> list;
        if (!z10) {
            list = parameters.getSupportedPreviewSizes();
        } else {
            list = parameters.getSupportedPictureSizes();
        }
        if (list != null && !list.isEmpty()) {
            return a(list, point);
        }
        Log.e("CameraManager", "CameraConfigImpl::findCameraResolution camera not support");
        return new Point(0, 0);
    }

    private static Point a(List<Camera.Size> list, Point point) {
        double d10 = point.x / point.y;
        int i10 = 0;
        double d11 = Double.MAX_VALUE;
        int i11 = 0;
        for (Camera.Size size : list) {
            int i12 = size.width;
            int i13 = size.height;
            if (i12 == point.x && i13 == point.y) {
                return new Point(i12, i13);
            }
            if (i12 * i13 >= 153600.0d) {
                double d12 = (i12 / i13) - d10;
                if (Math.abs(d12) < d11) {
                    d11 = Math.abs(d12);
                    i11 = i13;
                    i10 = i12;
                }
            }
        }
        return new Point(i10, i11);
    }

    private static void a(Camera.Parameters parameters) {
        String str;
        String[] strArr = {"continuous-picture", "continuous-video", CameraConfig.CAMERA_FOCUS_AUTO};
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes == null) {
            Log.w("CameraManager", "setFocusMode failed, use default");
            return;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= 3) {
                str = null;
                break;
            }
            str = strArr[i10];
            if (supportedFocusModes.contains(str)) {
                break;
            }
            i10++;
        }
        if (str != null) {
            Log.i("CameraManager", "setFocusMode: ".concat(str));
            parameters.setFocusMode(str);
        }
    }
}
