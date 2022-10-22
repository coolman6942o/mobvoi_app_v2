package com.huawei.hms.ml.camera;

import android.graphics.Rect;
/* loaded from: classes2.dex */
public class CameraMeteringData {
    private int maxNumMeteringAreas;
    private Rect meteringArea;

    /* loaded from: classes2.dex */
    public static class Area {
        public Rect rect;
        public int weight;

        public Area(Rect rect, int i10) {
            this.rect = rect;
            this.weight = i10;
        }
    }

    public CameraMeteringData(int i10, Rect rect) {
        this.maxNumMeteringAreas = i10;
        this.meteringArea = new Rect(rect);
    }

    public int getMaxNumMeteringAreas() {
        return this.maxNumMeteringAreas;
    }

    public Rect getMeteringArea() {
        return this.meteringArea;
    }
}
