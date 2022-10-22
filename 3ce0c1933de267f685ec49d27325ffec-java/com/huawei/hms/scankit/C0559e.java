package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TextureView;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.ml.camera.CameraConfig;
import com.huawei.hms.ml.camera.CameraManager;
import com.huawei.hms.ml.camera.CameraMeteringData;
import com.huawei.hms.ml.camera.CameraZoomData;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.p.Qa;
import com.huawei.hms.scankit.p.Ta;
import com.huawei.hms.scankit.util.a;
import com.huawei.hms.scankit.util.b;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
/* compiled from: CaptureHelper.java */
/* renamed from: com.huawei.hms.scankit.e  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0559e implements AbstractC0560f, AbstractC0562h, AbstractC0561g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14347a = "e";

    /* renamed from: b  reason: collision with root package name */
    public static volatile Ta f14348b;
    private IObjectWrapper A;
    private A B;
    private IOnResultCallback C;
    private boolean F;
    private IOnErrorCallback G;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f14350d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14351e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f14352f;

    /* renamed from: g  reason: collision with root package name */
    private Context f14353g;

    /* renamed from: h  reason: collision with root package name */
    private HandlerC0549a f14354h;

    /* renamed from: i  reason: collision with root package name */
    private B f14355i;

    /* renamed from: j  reason: collision with root package name */
    private CameraManager f14356j;

    /* renamed from: k  reason: collision with root package name */
    private ViewfinderView f14357k;

    /* renamed from: l  reason: collision with root package name */
    private TextureView f14358l;

    /* renamed from: m  reason: collision with root package name */
    private TextureView.SurfaceTextureListener f14359m;

    /* renamed from: n  reason: collision with root package name */
    private Collection<BarcodeFormat> f14360n;

    /* renamed from: o  reason: collision with root package name */
    private Map<EnumC0553d, ?> f14361o;

    /* renamed from: p  reason: collision with root package name */
    private String f14362p;

    /* renamed from: r  reason: collision with root package name */
    private String f14364r;

    /* renamed from: t  reason: collision with root package name */
    private float f14366t;

    /* renamed from: x  reason: collision with root package name */
    private boolean f14370x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f14371y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f14372z;

    /* renamed from: c  reason: collision with root package name */
    public volatile Qa f14349c = null;

    /* renamed from: s  reason: collision with root package name */
    private boolean f14365s = true;

    /* renamed from: u  reason: collision with root package name */
    private boolean f14367u = true;

    /* renamed from: v  reason: collision with root package name */
    private boolean f14368v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f14369w = true;
    private boolean D = false;
    private boolean E = false;
    private boolean H = true;

    /* renamed from: q  reason: collision with root package name */
    private boolean f14363q = false;

    public C0559e(Context context, TextureView textureView, ViewfinderView viewfinderView, Rect rect, int i10, IObjectWrapper iObjectWrapper, boolean z10, String str, boolean z11) {
        this.F = false;
        this.f14353g = context;
        this.f14357k = viewfinderView;
        this.A = iObjectWrapper;
        this.f14358l = textureView;
        this.f14350d = rect;
        this.f14351e = i10;
        this.f14352f = z10;
        this.f14364r = str;
        this.F = false;
        this.f14371y = z11;
    }

    private void i() {
        HandlerC0549a aVar = this.f14354h;
        if (aVar != null) {
            aVar.e();
            this.f14354h = null;
        }
        if (!this.f14363q) {
            this.f14358l.setSurfaceTextureListener(null);
        }
        this.f14356j.onPause();
    }

    public void e() {
        TextureView textureView;
        TextureView textureView2;
        this.F = false;
        try {
            this.f14349c = new Qa((Bundle) ObjectWrapper.unwrap(this.A), this.f14364r);
            this.f14349c.b();
        } catch (RuntimeException unused) {
            a.b(f14347a, "RuntimeException");
        } catch (Exception unused2) {
            a.b(f14347a, "Exception");
        }
        if (!this.D && !this.f14363q && (textureView2 = this.f14358l) != null) {
            textureView2.setSurfaceTextureListener(this.f14359m);
            if (this.f14363q) {
                a(this.f14358l);
            } else {
                this.f14358l.setSurfaceTextureListener(this.f14359m);
            }
        }
        if (this.E && this.f14353g.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0 && (textureView = this.f14358l) != null) {
            this.E = false;
            a(textureView);
        }
    }

    public void f() {
        this.F = false;
        TextureView textureView = this.f14358l;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(this.f14359m);
            this.D = true;
            if (this.f14363q) {
                a(this.f14358l);
            } else {
                this.f14358l.setSurfaceTextureListener(this.f14359m);
            }
        }
    }

    public void g() {
        this.F = true;
        if (this.f14349c != null) {
            this.f14349c.c();
        }
        this.f14349c = null;
        if (this.D) {
            i();
        }
    }

    public void h() {
        try {
            CameraManager cameraManager = this.f14356j;
            if (cameraManager != null) {
                cameraManager.setCameraZoomValue(1);
            }
        } catch (RuntimeException unused) {
            a.b(f14347a, "RuntimeException in reset zoomValue");
        } catch (Exception unused2) {
            a.b(f14347a, "Exception in reset zoomValue");
        }
    }

    public void c() {
        this.F = true;
        this.f14356j.onDestroy();
        f14348b = null;
    }

    public void d() {
        this.F = true;
        if (!this.D) {
            i();
        }
    }

    public void b() {
        this.F = false;
        try {
            f14348b = new Ta((Bundle) ObjectWrapper.unwrap(this.A), this.f14364r);
            f14348b.a("single");
        } catch (RuntimeException unused) {
            a.b(f14347a, "RuntimeException");
        } catch (Exception unused2) {
            a.b(f14347a, "Exception");
        }
        CameraConfig a10 = a(this.f14353g);
        Log.i(f14347a, "onCreate: CameraManageOncreate");
        CameraManager cameraManager = new CameraManager(this.f14353g, a10);
        this.f14356j = cameraManager;
        cameraManager.setCameraStatusListener(new C0556b(this));
        this.f14359m = new TextureView$SurfaceTextureListenerC0557c(this);
        this.f14355i = new C0558d(this);
    }

    public boolean a(MotionEvent motionEvent) {
        if (!this.f14365s || this.f14356j.getCameraState().getValue() < CameraManager.CameraState.CAMERA_OPENED.getValue() || motionEvent.getPointerCount() <= 1) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 2) {
            float b10 = b(motionEvent);
            float f10 = this.f14366t;
            if (b10 > f10 + 6.0f) {
                a(true, this.f14356j);
            } else if (b10 < f10 - 6.0f) {
                a(false, this.f14356j);
            } else {
                a.c("CaptureHelper", "MotionEvent.ACTION_MOVE no handleZoom");
            }
            this.f14366t = b10;
        } else if (action == 5) {
            this.f14366t = b(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextureView textureView) {
        if (textureView == null || textureView.getSurfaceTexture() == null) {
            a.d(f14347a, "initCamera() no surface view");
            return;
        }
        try {
            this.f14356j.initCamera(textureView);
            this.f14356j.setCameraMeteringArea(Collections.singletonList(new CameraMeteringData.Area(new Rect(-150, -150, 150, 150), 1000)));
            this.f14356j.setCameraExposureValue(1);
            try {
                this.f14356j.preSetCameraCallback();
            } catch (Exception e10) {
                a.b(f14347a, "initCamera() get exception");
                e10.printStackTrace();
            }
            if (this.f14354h == null) {
                HandlerC0549a aVar = new HandlerC0549a(this.f14353g, this.f14357k, this.f14355i, this.f14360n, this.f14361o, this.f14362p, this.f14356j, this.f14350d, this.f14351e, this.f14371y, this.H);
                this.f14354h = aVar;
                aVar.c(this.f14370x);
                this.f14354h.a(this.f14372z);
                this.f14354h.b(this.f14367u);
                this.f14354h.a(this.B);
            }
        } catch (Exception e11) {
            if (this.f14349c != null) {
                this.f14349c.c(-1002);
            }
            a.a(f14347a, "initCamera IOException", e11);
            e11.printStackTrace();
        }
    }

    private float b(MotionEvent motionEvent) {
        float x10 = motionEvent.getX(0) - motionEvent.getX(1);
        float y10 = motionEvent.getY(0) - motionEvent.getY(1);
        double sqrt = Math.sqrt((x10 * x10) + (y10 * y10));
        if (Double.isInfinite(sqrt) || Double.isNaN(sqrt)) {
            return 0.0f;
        }
        return BigDecimal.valueOf(sqrt).floatValue();
    }

    public void b(boolean z10) {
        this.H = z10;
    }

    private void a(boolean z10, CameraManager cameraManager) {
        try {
            CameraZoomData cameraZoomData = cameraManager.getCameraZoomData();
            if (cameraManager.isSupportZoom()) {
                int maxZoomIndex = cameraZoomData.getMaxZoomIndex();
                int currentZoomIndex = cameraZoomData.getCurrentZoomIndex();
                if (z10 && currentZoomIndex < maxZoomIndex) {
                    currentZoomIndex++;
                } else if (currentZoomIndex > 0) {
                    currentZoomIndex--;
                } else {
                    a.c(f14347a, "handleZoom  zoom not change");
                }
                cameraManager.setCameraZoomValue(currentZoomIndex);
                return;
            }
            a.c(f14347a, "zoom not supported");
        } catch (RuntimeException unused) {
            Log.e(f14347a, "handleZoom: RuntimeException");
        }
    }

    public void a(HmsScan[] hmsScanArr, Bitmap bitmap) {
        a.a("scan-time", "decode time:" + System.currentTimeMillis());
        try {
            String str = f14347a;
            a.c(str, "result onResult");
            if (this.B.a()) {
                a.c(str, "result intercepted");
                return;
            }
            if (this.f14349c != null) {
                this.f14349c.a(hmsScanArr);
            }
            if (!this.f14352f) {
                hmsScanArr = b.a(hmsScanArr);
            }
            if (this.B != null) {
                if (!(this.f14357k == null || hmsScanArr.length <= 0 || hmsScanArr[0] == null)) {
                    a.c(str, "result draw result point");
                    if (this.f14353g instanceof Activity) {
                        this.f14357k.a(hmsScanArr[0].getBorderRect(), b.c((Activity) this.f14353g), this.f14356j.getCameraSize());
                    }
                    this.F = false;
                }
                this.B.a(hmsScanArr);
            }
            if (this.C != null) {
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("result callback end: pauseStatus");
                    sb2.append(this.F);
                    a.c(str, sb2.toString());
                    if (!this.F) {
                        if (this.f14372z && hmsScanArr != null && hmsScanArr.length > 0 && hmsScanArr[0] != null) {
                            Context context = this.f14353g;
                            if (context instanceof Activity) {
                                int rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
                                hmsScanArr[0].originalBitmap = b.a(bitmap, rotation);
                            }
                        }
                        this.C.onResult(hmsScanArr);
                    }
                } catch (RemoteException e10) {
                    if (this.f14349c != null) {
                        this.f14349c.c(-1003);
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("onResult  RemoteException  e:");
                    sb3.append(e10);
                    a.d("CaptureHelper", sb3.toString());
                }
            }
        } catch (RuntimeException e11) {
            String str2 = f14347a;
            Log.e(str2, "onResult:RuntimeException " + e11);
        } catch (Exception e12) {
            String str3 = f14347a;
            Log.e(str3, "onResult:Exception: " + e12);
        }
    }

    public C0559e a(boolean z10) {
        this.f14372z = z10;
        HandlerC0549a aVar = this.f14354h;
        if (aVar != null) {
            aVar.a(z10);
        }
        return this;
    }

    public C0559e a(A a10) {
        this.B = a10;
        return this;
    }

    public void a(IOnResultCallback iOnResultCallback) {
        this.C = iOnResultCallback;
    }

    public CameraManager a() {
        return this.f14356j;
    }

    public void a(IOnErrorCallback iOnErrorCallback) {
        this.G = iOnErrorCallback;
    }

    private CameraConfig a(Context context) {
        int rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
        String str = f14347a;
        Log.i(str, "initCameraConfig:false");
        if (rotation == 0) {
            return new CameraConfig.Factory().setCameraExpectSize(new Point(1920, 1080)).setCameraMode(1).setCameraOrientation(90).setRecordingHint(false).create();
        }
        if (rotation == 1) {
            return new CameraConfig.Factory().setCameraExpectSize(new Point(1920, 1080)).setCameraMode(1).setCameraOrientation(0).setRecordingHint(false).create();
        }
        if (rotation == 2) {
            return new CameraConfig.Factory().setCameraExpectSize(new Point(1920, 1080)).setCameraMode(1).setCameraOrientation(270).setRecordingHint(false).create();
        }
        if (rotation != 3) {
            return new CameraConfig.Factory().setCameraExpectSize(new Point(1920, 1080)).setCameraMode(1).setCameraOrientation(90).setRecordingHint(false).create();
        }
        return new CameraConfig.Factory().setCameraExpectSize(new Point(1920, 1080)).setCameraMode(1).setCameraOrientation(CameraConfig.CAMERA_THIRD_DEGREE).setRecordingHint(false).create();
    }
}
