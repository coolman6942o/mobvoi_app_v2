package com.huawei.hms.ml.camera;

import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import com.huawei.hms.ml.camera.CameraMeteringData;
import java.util.ArrayList;
import java.util.List;
/* compiled from: CameraMeteringManager.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private Camera f14018a;

    public final synchronized void a(Camera camera) {
        this.f14018a = camera;
    }

    public final synchronized CameraMeteringData a() {
        int i10;
        Rect rect;
        RuntimeException e10;
        try {
            i10 = this.f14018a.getParameters().getMaxNumMeteringAreas();
        } catch (RuntimeException e11) {
            e10 = e11;
            i10 = 0;
        }
        try {
            rect = this.f14018a.getParameters().getMeteringAreas().get(0).rect;
        } catch (RuntimeException e12) {
            e10 = e12;
            Log.w("CameraManager", "CameraMeteringManager::getCameraMeteringData failed: " + e10.getMessage());
            rect = null;
            return new CameraMeteringData(i10, rect);
        }
        return new CameraMeteringData(i10, rect);
    }

    public final synchronized void a(List<CameraMeteringData.Area> list) {
        Camera camera = this.f14018a;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                arrayList.add(new Camera.Area(list.get(i10).rect, list.get(i10).weight));
            }
            parameters.setMeteringAreas(arrayList);
            try {
                this.f14018a.setParameters(parameters);
            } catch (RuntimeException e10) {
                Log.w("CameraManager", "CameraMeteringManager::setCameraMeteringArea failed: " + e10.getMessage());
            }
        }
    }
}
