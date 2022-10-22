package com.mobvoi.qr;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import com.huawei.agconnect.exception.AGCServerException;
import com.huawei.hms.ml.camera.CameraConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* compiled from: CameraConfigurationManager.java */
/* loaded from: classes2.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private Point f20355a;

    /* renamed from: b  reason: collision with root package name */
    private Point f20356b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CameraConfigurationManager.java */
    /* loaded from: classes2.dex */
    public class a implements Comparator<Camera.Size> {
        a(b bVar) {
        }

        /* renamed from: a */
        public int compare(Camera.Size size, Camera.Size size2) {
            int i10 = size.height * size.width;
            int i11 = size2.height * size2.width;
            if (i11 < i10) {
                return -1;
            }
            return i11 > i10 ? 1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
    }

    private Rect a(float f10, float f11, float f12, int i10, int i11) {
        int intValue = Float.valueOf(f12 * 700.0f).intValue();
        int intValue2 = Float.valueOf(((f10 / i10) * 2000.0f) - 1000.0f).intValue();
        int intValue3 = Float.valueOf(((f11 / i11) * 2000.0f) - 1000.0f).intValue();
        int i12 = intValue / 2;
        int b10 = b(intValue2 - i12, -1000, 1000);
        int b11 = b(b10 + intValue, -1000, 1000);
        int b12 = b(intValue3 - i12, -1000, 1000);
        return new Rect(b10, b12, b11, b(intValue + b12, -1000, 1000));
    }

    private int b(int i10, int i11, int i12) {
        return i10 > i12 ? i12 : i10 < i11 ? i11 : i10;
    }

    private static String d(Collection<String> collection, String... strArr) {
        String str;
        Log.i("CameraConfiguration", "Supported values: " + collection);
        if (collection != null) {
            int length = strArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                str = strArr[i10];
                if (collection.contains(str)) {
                    break;
                }
            }
        }
        str = null;
        Log.i("CameraConfiguration", "Settable value: " + str);
        return str;
    }

    public Point c(Camera.Parameters parameters, Point point) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            Log.w("CameraConfiguration", "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            return new Point(previewSize.width, previewSize.height);
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new a(this));
        if (Log.isLoggable("CameraConfiguration", 4)) {
            StringBuilder sb2 = new StringBuilder();
            for (Camera.Size size : arrayList) {
                sb2.append(size.width);
                sb2.append('x');
                sb2.append(size.height);
                sb2.append(' ');
            }
            Log.i("CameraConfiguration", "Supported preview sizes: " + ((Object) sb2));
        }
        Point point2 = null;
        float f10 = point.x / point.y;
        float f11 = Float.POSITIVE_INFINITY;
        for (Camera.Size size2 : arrayList) {
            int i10 = size2.width;
            int i11 = size2.height;
            int i12 = i10 * i11;
            if (i12 >= 150400 && i12 <= 921600) {
                boolean z10 = i10 > i11;
                int i13 = z10 ? i11 : i10;
                int i14 = z10 ? i10 : i11;
                if (i13 == point.x && i14 == point.y) {
                    Point point3 = new Point(i10, i11);
                    Log.i("CameraConfiguration", "Found preview size exactly matching screen size: " + point3);
                    return point3;
                }
                float abs = Math.abs((i13 / i14) - f10);
                if (abs < f11) {
                    point2 = new Point(i10, i11);
                    f11 = abs;
                }
            }
        }
        if (point2 == null) {
            Camera.Size previewSize2 = parameters.getPreviewSize();
            point2 = new Point(previewSize2.width, previewSize2.height);
            Log.i("CameraConfiguration", "No suitable preview sizes, using default: " + point2);
        }
        Log.i("CameraConfiguration", "Found best approximate preview size: " + point2);
        return point2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point e() {
        return this.f20356b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Camera camera, int i10, int i11) {
        Camera.Parameters parameters = camera.getParameters();
        this.f20355a = new Point(i10, i11);
        Log.i("CameraConfiguration", "Screen resolution: " + this.f20355a);
        this.f20356b = c(parameters, this.f20355a);
        Log.i("CameraConfiguration", "Camera resolution: " + this.f20356b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Camera camera, boolean z10, int i10, int i11) {
        int zoom;
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            Log.w("CameraConfiguration", "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Log.i("CameraConfiguration", "Initial camera parameters: " + parameters.flatten());
        if (z10) {
            Log.w("CameraConfiguration", "In camera config safe mode -- most settings will not be honored");
        }
        String str = null;
        if (!z10) {
            str = d(parameters.getSupportedFocusModes(), CameraConfig.CAMERA_FOCUS_AUTO, CameraConfig.CAMERA_FOCUS_MACRO, "continuous-picture", "continuous-video", "edof");
        }
        if (str != null) {
            parameters.setFocusMode(str);
        }
        Rect a10 = a(i10 / 2, i11 / 2, 1.0f, i10, i11);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Camera.Area(a10, AGCServerException.UNKNOW_EXCEPTION));
        parameters.setFocusAreas(arrayList);
        if (parameters.getMaxNumMeteringAreas() > 0) {
            parameters.setMeteringAreas(arrayList);
        }
        Point point = this.f20356b;
        parameters.setPreviewSize(point.x, point.y);
        if (parameters.isZoomSupported() && (zoom = parameters.getZoom() + 5) < parameters.getMaxZoom()) {
            parameters.setZoom(zoom);
        }
        camera.setParameters(parameters);
    }
}
