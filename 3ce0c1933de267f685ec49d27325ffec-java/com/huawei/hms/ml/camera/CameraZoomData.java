package com.huawei.hms.ml.camera;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CameraZoomData {
    private List<Integer> allZoomRations;
    private int currentZoom;
    private int maxZoom;

    public CameraZoomData(int i10, int i11, List<Integer> list) {
        this.maxZoom = i10;
        this.currentZoom = i11;
        this.allZoomRations = new ArrayList(list);
    }

    public List<Integer> getAllZoomRations() {
        return this.allZoomRations;
    }

    public int getCurrentZoomIndex() {
        return this.currentZoom;
    }

    public int getMaxZoomIndex() {
        return this.maxZoom;
    }
}
