package com.huawei.hms.ml.camera;
/* loaded from: classes2.dex */
public class CameraExposureData {
    private float compensationStep;
    private int currentValue;
    private int maxValue;
    private int minValue;

    public CameraExposureData(int i10, int i11, int i12, float f10) {
        this.maxValue = i10;
        this.minValue = i11;
        this.currentValue = i12;
        this.compensationStep = f10;
    }

    public float getCompensationStep() {
        return this.compensationStep;
    }

    public int getCurrentValue() {
        return this.currentValue;
    }

    public int getMaxValue() {
        return this.maxValue;
    }

    public int getMinValue() {
        return this.minValue;
    }
}
