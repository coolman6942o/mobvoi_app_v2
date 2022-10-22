package com.huawei.hms.ml.camera;

import android.graphics.Point;
/* loaded from: classes2.dex */
public class CameraConfig {
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    public static final int CAMERA_FIRST_DEGREE = 0;
    public static final String CAMERA_FOCUS_AUTO = "auto";
    public static final String CAMERA_FOCUS_MACRO = "macro";
    public static final int CAMERA_FOURTH_DEGREE = 270;
    public static final int CAMERA_ID = 0;
    public static final int CAMERA_PICTURE_MODE = 0;
    public static final int CAMERA_PREVIEW_MULTI_SHOT = 2;
    public static final int CAMERA_PREVIEW_ONE_SHOT = 1;
    public static final int CAMERA_SECOND_DEGREE = 90;
    public static final int CAMERA_THIRD_DEGREE = 180;
    public static final String CAMERA_TORCH_OFF = "off";
    public static final String CAMERA_TORCH_ON = "torch";
    private Point cameraExpectSize;
    private int cameraFacing;
    private int cameraMode;
    private int cameraOrientation;
    private boolean isRecordingHint;
    private String torchMode;

    /* loaded from: classes2.dex */
    public static class Factory {
        private Point screenSize;
        private int cameraFacing = 0;
        private int cameraMode = 1;
        private int cameraOrientation = 0;
        private String torchMode = CameraConfig.CAMERA_TORCH_OFF;
        private boolean isRecordingHint = true;

        public CameraConfig create() {
            return new CameraConfig(this.cameraFacing, this.cameraMode, this.cameraOrientation, this.torchMode, this.screenSize, this.isRecordingHint);
        }

        public Factory setCameraExpectSize(Point point) {
            this.screenSize = point;
            return this;
        }

        public Factory setCameraFacing(int i10) {
            this.cameraFacing = i10;
            return this;
        }

        public Factory setCameraMode(int i10) {
            this.cameraMode = i10;
            return this;
        }

        public Factory setCameraOrientation(int i10) {
            this.cameraOrientation = i10;
            return this;
        }

        public Factory setRecordingHint(boolean z10) {
            this.isRecordingHint = z10;
            return this;
        }

        public Factory setTorchMode(String str) {
            this.torchMode = str;
            return this;
        }
    }

    public Point getCameraExpectSize() {
        return this.cameraExpectSize;
    }

    public int getCameraFacing() {
        return this.cameraFacing;
    }

    public int getCameraMode() {
        return this.cameraMode;
    }

    public int getCameraOrientation() {
        return this.cameraOrientation;
    }

    public boolean getRecordingHint() {
        return this.isRecordingHint;
    }

    public String getTorchMode() {
        return this.torchMode;
    }

    public void setCameraOrientation(int i10) {
        this.cameraOrientation = i10;
    }

    private CameraConfig(int i10, int i11, int i12, String str, Point point, boolean z10) {
        this.cameraFacing = i10;
        this.cameraMode = i11;
        this.cameraOrientation = i12;
        this.torchMode = str;
        this.cameraExpectSize = point;
        this.isRecordingHint = z10;
    }
}
