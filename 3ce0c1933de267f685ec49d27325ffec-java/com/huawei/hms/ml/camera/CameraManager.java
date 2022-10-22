package com.huawei.hms.ml.camera;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.huawei.hms.ml.camera.CameraMeteringData;
import com.huawei.hms.mlkit.common.ha.HianalyticsLogProvider;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes2.dex */
public class CameraManager {
    private static final String CAMERA_MODULE_NAME = "MLKitCamera";
    private static final String TAG = "CameraManager";
    private d autoFocusManager;
    private Camera camera;
    private CameraSizeListener cameraSizeListener;
    private CameraStatusListener cameraStatusListener;
    private b configImpl;
    private c exposureManager;
    private g hiAnalyticsThread;
    private e meteringManager;
    private Camera.PictureCallback pictureCallback;
    private Camera.PreviewCallback previewCallback;
    private CameraConfig setting;
    private String torchStatus;
    private WeakReference<Context> weakContext;
    private f zoomManager;
    private CameraState cameraState = CameraState.CAMERA_CLOSED;
    private boolean isHiAnalyticsThreadStarted = false;
    private int lastDelayTime = -1;

    /* loaded from: classes2.dex */
    public interface CameraSizeListener {
        void postPreviewSize(Point point);
    }

    /* loaded from: classes2.dex */
    public enum CameraState {
        CAMERA_CLOSED(1),
        CAMERA_OPENED(2),
        CAMERA_INITIALED(3),
        PREVIEW_STARTED(4),
        PREVIEW_STOPPED(5);
        
        private final int value;

        CameraState(int i10) {
            this.value = i10;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public interface CameraStatusListener {
        void onClosed();

        void onFailed();

        void onOpened();
    }

    /* loaded from: classes2.dex */
    public interface FrameCallback {
        void onFrame(byte[] bArr);
    }

    /* loaded from: classes2.dex */
    public interface ImageCallback {
        void onImage(byte[] bArr);
    }

    /* loaded from: classes2.dex */
    static class NativePreviewCallback implements Camera.PreviewCallback {
        private NativePreviewCallback() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
        }
    }

    public CameraManager(Context context, CameraConfig cameraConfig) {
        if (context == null || cameraConfig == null) {
            throw new IllegalArgumentException("CameraManager constructor param invalid");
        }
        this.weakContext = new WeakReference<>(context);
        this.setting = cameraConfig;
        this.torchStatus = cameraConfig.getTorchMode();
        this.configImpl = new b();
        this.exposureManager = new c();
        this.zoomManager = new f();
        this.meteringManager = new e();
        this.hiAnalyticsThread = new g(context);
        initialHaTimer();
    }

    private void closeHaTimer() {
        if (!HianalyticsLogProvider.getInstance().sdkForbiddenHiLog(this.weakContext.get())) {
            HianalyticsLogProvider.getInstance().reportAndCancelTimer(CAMERA_MODULE_NAME);
            if (this.isHiAnalyticsThreadStarted) {
                Handler handler = this.hiAnalyticsThread.f14020a;
                if (handler != null) {
                    Message.obtain(handler, R.id.mlkit_camera_ha_quit).sendToTarget();
                }
                this.isHiAnalyticsThreadStarted = false;
                return;
            }
            return;
        }
        Log.w(TAG, "CameraManager::closeHaTimer failed");
    }

    private int findCameraId(int i10) {
        if (!(i10 == 0 || i10 == 1)) {
            return 0;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i11 = 0; i11 < numberOfCameras; i11++) {
            Camera.getCameraInfo(i11, cameraInfo);
            if (cameraInfo.facing == i10) {
                Log.i(TAG, "findCameraId: ".concat(String.valueOf(i11)));
                return i11;
            }
        }
        return 0;
    }

    private void initialHaTimer() {
        if (!HianalyticsLogProvider.getInstance().sdkForbiddenHiLog(this.weakContext.get())) {
            HianalyticsLogProvider.getInstance().initTimer(CAMERA_MODULE_NAME);
            if (!this.isHiAnalyticsThreadStarted) {
                this.hiAnalyticsThread.start();
                this.isHiAnalyticsThreadStarted = true;
                return;
            }
            return;
        }
        Log.w(TAG, "CameraManager::initialHaTimer failed");
    }

    public synchronized void cancelAutoFocus() {
        d dVar = this.autoFocusManager;
        if (dVar != null) {
            dVar.b();
            this.autoFocusManager = null;
        }
    }

    public synchronized void captureImage() {
        if (this.setting.getCameraMode() != 0) {
            Log.w(TAG, "CameraManager::captureImage camera mode is not CAMERA_PICTURE_MODE");
        } else if (this.cameraState != CameraState.PREVIEW_STARTED) {
            Log.w(TAG, "CameraManager::captureImage camera is not start preview yet");
        } else {
            Camera camera = this.camera;
            if (camera != null) {
                camera.takePicture(null, null, this.pictureCallback);
            }
            this.cameraState = CameraState.PREVIEW_STOPPED;
        }
    }

    public synchronized CameraExposureData getCameraExposureData() {
        if (!(this.camera == null || this.cameraState.getValue() == CameraState.CAMERA_CLOSED.getValue())) {
            return this.exposureManager.a();
        }
        return null;
    }

    public synchronized String getCameraFocusMode() {
        if (!(this.camera == null || this.cameraState.getValue() == CameraState.CAMERA_CLOSED.getValue())) {
            return this.camera.getParameters().getFocusMode();
        }
        return null;
    }

    public synchronized CameraMeteringData getCameraMeteringData() {
        if (!(this.camera == null || this.cameraState.getValue() == CameraState.CAMERA_CLOSED.getValue())) {
            return this.meteringManager.a();
        }
        return null;
    }

    public synchronized int getCameraOrientation() {
        return this.setting.getCameraOrientation();
    }

    public synchronized Point getCameraSize() {
        return this.configImpl.f14006a;
    }

    public synchronized CameraState getCameraState() {
        return this.cameraState;
    }

    public synchronized CameraZoomData getCameraZoomData() {
        if (!(this.camera == null || this.cameraState.getValue() == CameraState.CAMERA_CLOSED.getValue())) {
            return this.zoomManager.a();
        }
        return null;
    }

    public synchronized String getTorchStatus() {
        return this.torchStatus;
    }

    public synchronized void initCamera(SurfaceHolder surfaceHolder) throws IOException {
        if (surfaceHolder != null) {
            if (this.cameraState.getValue() != CameraState.CAMERA_OPENED.getValue()) {
                Log.w(TAG, "CameraManager::initCamera camera is not opened yet");
                onResume();
            }
            this.exposureManager.a(this.camera);
            this.zoomManager.a(this.camera);
            this.meteringManager.a(this.camera);
            Camera camera = this.camera;
            if (camera != null) {
                camera.setPreviewDisplay(surfaceHolder);
            }
            this.configImpl.a(this.camera, this.setting);
            Camera camera2 = this.camera;
            if (camera2 != null) {
                camera2.setDisplayOrientation(this.setting.getCameraOrientation());
            }
            CameraSizeListener cameraSizeListener = this.cameraSizeListener;
            if (cameraSizeListener != null) {
                cameraSizeListener.postPreviewSize(this.configImpl.f14006a);
            }
            this.cameraState = CameraState.CAMERA_INITIALED;
        } else {
            throw new IllegalArgumentException("CameraManager::initCamera SurfaceHolder is null");
        }
    }

    public synchronized void initScanCamera(SurfaceHolder surfaceHolder) throws IOException {
        initCamera(surfaceHolder);
    }

    public synchronized boolean isSupportZoom() {
        return this.zoomManager.b();
    }

    public synchronized void onDestroy() {
        closeHaTimer();
        this.cameraSizeListener = null;
    }

    public synchronized void onPause() {
        try {
            if (this.cameraState.getValue() == CameraState.PREVIEW_STARTED.getValue()) {
                cancelAutoFocus();
                stopPreview();
                this.cameraState = CameraState.PREVIEW_STOPPED;
            }
            if (getTorchStatus().equals(CameraConfig.CAMERA_TORCH_ON)) {
                setTorchStatus(CameraConfig.CAMERA_TORCH_OFF);
            }
            if (this.cameraState.getValue() >= CameraState.CAMERA_OPENED.getValue()) {
                this.cameraState = CameraState.CAMERA_CLOSED;
                Camera camera = this.camera;
                if (camera != null) {
                    camera.release();
                    this.camera = null;
                }
                CameraStatusListener cameraStatusListener = this.cameraStatusListener;
                if (cameraStatusListener != null) {
                    cameraStatusListener.onClosed();
                }
            }
        } catch (RuntimeException unused) {
            Log.e(TAG, "CameraManager::onPause failed");
        }
    }

    public synchronized void onResume() {
        CameraState cameraState = this.cameraState;
        if (cameraState == CameraState.CAMERA_CLOSED || cameraState == CameraState.PREVIEW_STOPPED) {
            try {
                this.camera = Camera.open(findCameraId(this.setting.getCameraFacing()));
            } catch (RuntimeException e10) {
                Log.e(TAG, "CameraManager::Camera open failed, " + e10.getMessage());
            }
            if (this.camera == null) {
                Log.e(TAG, "CameraManager::initCamera failed");
                CameraStatusListener cameraStatusListener = this.cameraStatusListener;
                if (cameraStatusListener != null) {
                    cameraStatusListener.onFailed();
                }
            } else {
                CameraStatusListener cameraStatusListener2 = this.cameraStatusListener;
                if (cameraStatusListener2 != null) {
                    cameraStatusListener2.onOpened();
                }
                this.cameraState = CameraState.CAMERA_OPENED;
            }
        }
    }

    public synchronized void preSetCameraCallback() {
        Camera camera;
        if (this.cameraState.getValue() >= CameraState.CAMERA_OPENED.getValue()) {
            if (!(this.setting.getCameraMode() == 0 || (camera = this.camera) == null)) {
                camera.setPreviewCallback(new NativePreviewCallback());
            }
        }
    }

    public synchronized void refreshCameraOrientation(int i10) {
        if (!(this.setting == null || this.camera == null || this.cameraState.getValue() < CameraState.CAMERA_OPENED.getValue())) {
            this.setting.setCameraOrientation(i10);
            this.camera.setDisplayOrientation(i10);
        }
    }

    public synchronized void requestFocus(int i10) {
        if (this.cameraState != CameraState.PREVIEW_STARTED) {
            Log.w(TAG, "CameraManager::requestFocus camera is not start preview yet");
        } else if (i10 != this.lastDelayTime) {
            this.lastDelayTime = i10;
            d dVar = this.autoFocusManager;
            if (dVar == null) {
                d dVar2 = new d(this.camera);
                this.autoFocusManager = dVar2;
                dVar2.a(i10);
                this.autoFocusManager.a();
                return;
            }
            dVar.a(i10);
        }
    }

    public synchronized void requestPreviewFrame() {
        if (this.setting.getCameraMode() == 1) {
            Log.d(TAG, "CameraManager::requestPreviewFrame PREVIEW_ONE_SHOT");
            if (this.cameraState != CameraState.PREVIEW_STOPPED) {
                Camera camera = this.camera;
                if (camera != null) {
                    camera.setOneShotPreviewCallback(this.previewCallback);
                }
            }
        } else if (this.setting.getCameraMode() == 0) {
            Log.d(TAG, "CameraManager::requestPreviewFrame PICTURE_MODE");
            if (this.cameraState == CameraState.PREVIEW_STOPPED) {
                startPreview();
            }
        } else if (this.setting.getCameraMode() == 2) {
            Log.d(TAG, "CameraManager::requestPreviewFrame PREVIEW_MULTI_SHOT");
            if (this.cameraState != CameraState.PREVIEW_STOPPED) {
                Camera camera2 = this.camera;
                if (camera2 != null) {
                    camera2.setPreviewCallback(this.previewCallback);
                }
            }
        } else {
            Log.w(TAG, "CameraManager::requestPreviewFrame unknown mode");
        }
    }

    public synchronized void setCameraExposureValue(int i10) {
        if (!(this.camera == null || this.cameraState.getValue() == CameraState.CAMERA_CLOSED.getValue())) {
            this.exposureManager.a(i10);
        }
    }

    public synchronized void setCameraMeteringArea(List<CameraMeteringData.Area> list) {
        if (!(this.camera == null || this.cameraState.getValue() == CameraState.CAMERA_CLOSED.getValue())) {
            this.meteringManager.a(list);
        }
    }

    public synchronized void setCameraSizeListener(CameraSizeListener cameraSizeListener) {
        if (cameraSizeListener != null) {
            this.cameraSizeListener = cameraSizeListener;
        } else {
            throw new IllegalArgumentException("CameraManager::setCameraSizeListener param invalid");
        }
    }

    public synchronized void setCameraStatusListener(CameraStatusListener cameraStatusListener) {
        if (cameraStatusListener != null) {
            this.cameraStatusListener = cameraStatusListener;
        } else {
            throw new IllegalArgumentException("CameraManager::setCameraStatusListener param invalid");
        }
    }

    public synchronized void setCameraZoomValue(int i10) {
        if (!(this.camera == null || this.cameraState.getValue() == CameraState.CAMERA_CLOSED.getValue())) {
            this.zoomManager.a(i10);
        }
    }

    public synchronized void setFrameCallback(FrameCallback frameCallback) {
        if (frameCallback != null) {
            this.previewCallback = new i(this.hiAnalyticsThread, frameCallback);
        } else {
            throw new IllegalArgumentException("CameraManager::setFrameCallback param invalid");
        }
    }

    public synchronized void setImageCallback(ImageCallback imageCallback) {
        if (imageCallback != null) {
            this.pictureCallback = new h(this.hiAnalyticsThread, imageCallback);
        } else {
            throw new IllegalArgumentException("CameraManager::setImageCallback param invalid");
        }
    }

    public synchronized void setTorchStatus(String str) {
        try {
            if (!(this.camera == null || this.cameraState.getValue() == CameraState.CAMERA_CLOSED.getValue())) {
                if (CameraConfig.CAMERA_TORCH_OFF.equals(str) || CameraConfig.CAMERA_TORCH_ON.equals(str)) {
                    Camera.Parameters parameters = this.camera.getParameters();
                    parameters.setFlashMode(str);
                    this.camera.setParameters(parameters);
                    this.torchStatus = str;
                }
            }
        } catch (RuntimeException unused) {
            Log.w(TAG, "CameraManager::setTorchStatus error");
        }
    }

    public synchronized void startPreview() {
        try {
            if (this.cameraState.getValue() < CameraState.CAMERA_INITIALED.getValue()) {
                Log.w(TAG, "CameraManager::startPreview camera is not initialed yet");
                return;
            }
            Camera camera = this.camera;
            if (camera != null) {
                camera.startPreview();
                this.cameraState = CameraState.PREVIEW_STARTED;
            }
        } catch (RuntimeException unused) {
            Log.w(TAG, "stopPreview error");
        }
    }

    public synchronized void stopPreview() {
        try {
            if (this.cameraState.getValue() < CameraState.PREVIEW_STARTED.getValue()) {
                Log.w(TAG, "CameraManager::startPreview camera is not startPreview yet");
                return;
            }
            Camera camera = this.camera;
            if (camera != null) {
                camera.setPreviewCallback(null);
                this.camera.stopPreview();
                this.cameraState = CameraState.PREVIEW_STOPPED;
            }
        } catch (RuntimeException unused) {
            Log.w(TAG, "stopPreview error");
        }
    }

    public synchronized void initCamera(TextureView textureView) throws IOException {
        if (textureView != null) {
            if (this.cameraState.getValue() != CameraState.CAMERA_OPENED.getValue()) {
                Log.w(TAG, "CameraManager::initCamera camera is not opened yet");
                onResume();
            }
            this.exposureManager.a(this.camera);
            this.zoomManager.a(this.camera);
            this.meteringManager.a(this.camera);
            Camera camera = this.camera;
            if (camera != null) {
                camera.setPreviewTexture(textureView.getSurfaceTexture());
            }
            this.configImpl.a(this.camera, this.setting);
            Camera camera2 = this.camera;
            if (camera2 != null) {
                camera2.setDisplayOrientation(this.setting.getCameraOrientation());
            }
            CameraSizeListener cameraSizeListener = this.cameraSizeListener;
            if (cameraSizeListener != null) {
                cameraSizeListener.postPreviewSize(this.configImpl.f14006a);
            }
            this.cameraState = CameraState.CAMERA_INITIALED;
        } else {
            throw new IllegalArgumentException("CameraManager::initCamera SurfaceHolder is null");
        }
    }
}
