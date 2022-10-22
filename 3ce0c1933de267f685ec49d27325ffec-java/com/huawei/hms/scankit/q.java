package com.huawei.hms.scankit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;
import com.huawei.hms.ml.camera.CameraConfig;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.Ta;
import com.huawei.hms.scankit.util.a;
import com.huawei.hms.scankit.util.b;
import com.mobvoi.wear.info.IntentInfo;
/* compiled from: IRemoteCustomedViewDelegateImpl.java */
/* loaded from: classes2.dex */
public class q extends IRemoteViewDelegate.Stub implements A, SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15047a = "q";

    /* renamed from: b  reason: collision with root package name */
    protected static boolean f15048b = false;

    /* renamed from: d  reason: collision with root package name */
    protected int f15050d;

    /* renamed from: e  reason: collision with root package name */
    protected Context f15051e;

    /* renamed from: f  reason: collision with root package name */
    protected ProviderRemoteView f15052f;

    /* renamed from: g  reason: collision with root package name */
    protected TextureView f15053g;

    /* renamed from: h  reason: collision with root package name */
    protected C0559e f15054h;

    /* renamed from: i  reason: collision with root package name */
    protected IOnResultCallback f15055i;

    /* renamed from: j  reason: collision with root package name */
    protected SensorManager f15056j;

    /* renamed from: k  reason: collision with root package name */
    protected View.OnClickListener f15057k;

    /* renamed from: n  reason: collision with root package name */
    protected Boolean f15060n;

    /* renamed from: o  reason: collision with root package name */
    protected AlertDialog f15061o;

    /* renamed from: p  reason: collision with root package name */
    protected Rect f15062p;

    /* renamed from: q  reason: collision with root package name */
    private IObjectWrapper f15063q;

    /* renamed from: r  reason: collision with root package name */
    protected boolean f15064r;

    /* renamed from: s  reason: collision with root package name */
    private OrientationEventListener f15065s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f15066t;

    /* renamed from: u  reason: collision with root package name */
    protected boolean f15067u;

    /* renamed from: v  reason: collision with root package name */
    protected IOnLightCallback f15068v;

    /* renamed from: w  reason: collision with root package name */
    protected LinearLayout f15069w;

    /* renamed from: c  reason: collision with root package name */
    private volatile Ta f15049c = null;

    /* renamed from: l  reason: collision with root package name */
    protected boolean f15058l = false;

    /* renamed from: m  reason: collision with root package name */
    protected final Float f15059m = Float.valueOf(40.0f);

    /* renamed from: x  reason: collision with root package name */
    boolean f15070x = false;

    public q(Context context, int i10, Object obj, IObjectWrapper iObjectWrapper, boolean z10, boolean z11, boolean z12) {
        this.f15050d = 0;
        this.f15064r = false;
        this.f15051e = context;
        this.f15050d = i10;
        this.f15063q = iObjectWrapper;
        if (obj instanceof Rect) {
            this.f15062p = (Rect) obj;
        } else {
            this.f15062p = null;
        }
        this.f15064r = z10;
        this.f15066t = z11;
        this.f15067u = z12;
    }

    protected boolean b() {
        try {
            return this.f15054h.a().getTorchStatus().equals(CameraConfig.CAMERA_TORCH_ON);
        } catch (RuntimeException unused) {
            a.b(f15047a, "getFlashStatusRuntimeException");
            return false;
        } catch (Exception unused2) {
            a.b(f15047a, "getFlashStatusException");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        Object systemService = this.f15051e.getSystemService("sensor");
        if (systemService instanceof SensorManager) {
            SensorManager sensorManager = (SensorManager) systemService;
            this.f15056j = sensorManager;
            for (Sensor sensor : sensorManager.getSensorList(-1)) {
                if (5 == sensor.getType()) {
                    this.f15058l = true;
                    return;
                }
            }
        }
    }

    protected ProviderRemoteView d() {
        return new ProviderRemoteView(DynamicModuleInitializer.getContext() == null ? this.f15051e : DynamicModuleInitializer.getContext(), true);
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Bundle bundle;
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            bundle = new Bundle();
        } else {
            bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (this.f15049c == null) {
            try {
                this.f15049c = new Ta(bundle, DetailRect.PHOTO_MODE);
            } catch (RuntimeException unused) {
                a.b(f15047a, "RuntimeException");
            } catch (Exception unused2) {
                a.b(f15047a, "Exception");
            }
        }
        return a(iObjectWrapper, iObjectWrapper2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        try {
            if (this.f15051e.getSystemService("window") != null) {
                a(a(this.f15051e));
            }
        } catch (NullPointerException unused) {
            a.d(f15047a, "initSurfaceView: nullpoint");
        } catch (Exception unused2) {
            a.d(f15047a, "initSurfaceView: Exception");
        }
    }

    protected void f() {
        ProviderRemoteView d10 = d();
        this.f15052f = d10;
        TextureView textureView = (TextureView) d10.findViewById(R.id.surfaceView);
        this.f15053g = textureView;
        C0559e eVar = new C0559e(this.f15051e, textureView, null, this.f15062p, this.f15050d, this.f15063q, this.f15064r, "CustomizedView", true);
        this.f15054h = eVar;
        eVar.b(this.f15067u);
        c();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        try {
            C0559e eVar = this.f15054h;
            if (eVar != null && eVar.a() != null) {
                this.f15054h.a().setTorchStatus(CameraConfig.CAMERA_TORCH_OFF);
            }
        } catch (RuntimeException unused) {
            a.b(f15047a, "offFlashRuntimeException");
        } catch (Exception unused2) {
            a.b(f15047a, "offFlashException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public boolean getLightStatus() throws RemoteException {
        return b();
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public IObjectWrapper getView() {
        return ObjectWrapper.wrap(this.f15052f);
    }

    public void h() {
        try {
            C0559e eVar = this.f15054h;
            if (eVar != null && eVar.a() != null) {
                this.f15054h.a().setTorchStatus(CameraConfig.CAMERA_TORCH_ON);
            }
        } catch (RuntimeException unused) {
            a.b(f15047a, "openFlashRuntimeException");
        } catch (Exception unused2) {
            a.b(f15047a, "openFlashException");
        }
    }

    protected void i() {
        AlertDialog create = new AlertDialog.Builder(this.f15051e).create();
        this.f15061o = create;
        create.show();
        View inflate = LayoutInflater.from(DynamicModuleInitializer.getContext() == null ? this.f15051e : DynamicModuleInitializer.getContext()).inflate(R.layout.scankit_dialog_layout, (ViewGroup) null);
        Window window = this.f15061o.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = 60;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setContentView(inflate);
        window.setGravity(80);
        inflate.findViewById(R.id.dialog_sure_btn).setOnClickListener(new p(this));
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onCreate(Bundle bundle) {
        Context context = this.f15051e;
        if ((context instanceof Activity) && ((Activity) context).getWindow() != null) {
            ((Activity) this.f15051e).getWindow().setFlags(IntentInfo.FLAG_RECEIVER_INCLUDE_BACKGROUND, IntentInfo.FLAG_RECEIVER_INCLUDE_BACKGROUND);
        }
        f();
        this.f15054h.a(this);
        this.f15052f.setOnTouchListener(new n(this));
        IOnResultCallback iOnResultCallback = this.f15055i;
        if (iOnResultCallback != null) {
            this.f15054h.a(iOnResultCallback);
        }
        this.f15054h.a(this.f15066t);
        this.f15054h.b();
        if (Build.VERSION.SDK_INT >= 24) {
            Context context2 = this.f15051e;
            if ((context2 instanceof Activity) && ((Activity) context2).isInMultiWindowMode()) {
                o oVar = new o(this, this.f15051e);
                this.f15065s = oVar;
                if (oVar.canDetectOrientation()) {
                    this.f15065s.enable();
                } else {
                    this.f15065s.disable();
                }
            }
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onDestroy() {
        try {
            this.f15054h.c();
            OrientationEventListener orientationEventListener = this.f15065s;
            if (orientationEventListener != null && orientationEventListener.canDetectOrientation()) {
                this.f15065s.disable();
            }
        } catch (RuntimeException unused) {
            a.b(f15047a, "onDestroyRuntimeException");
        } catch (Exception unused2) {
            a.b(f15047a, "onDestroyException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onPause() {
        try {
            this.f15054h.d();
            this.f15056j.unregisterListener(this);
        } catch (RuntimeException unused) {
            a.b(f15047a, "onPauseRuntimeException");
        } catch (Exception unused2) {
            a.b(f15047a, "onPauseException");
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onResume() {
        try {
            this.f15054h.e();
            SensorManager sensorManager = this.f15056j;
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(5), 2);
        } catch (RuntimeException e10) {
            a.b(f15047a, "onResumeRuntimeException");
            e10.printStackTrace();
        } catch (Exception e11) {
            a.b(f15047a, "onResumeException");
            e11.printStackTrace();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Context context = this.f15051e;
        boolean hasSystemFeature = (context == null || context.getPackageManager() == null) ? true : this.f15051e.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
        if (this.f15058l && sensorEvent.sensor.getType() == 5 && hasSystemFeature) {
            Boolean valueOf = Boolean.valueOf(sensorEvent.values[0] > this.f15059m.floatValue());
            this.f15060n = valueOf;
            if (!valueOf.booleanValue()) {
                LinearLayout linearLayout = this.f15069w;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                IOnLightCallback iOnLightCallback = this.f15068v;
                if (iOnLightCallback != null) {
                    try {
                        iOnLightCallback.onVisibleChanged(true);
                    } catch (RemoteException unused) {
                        a.d(f15047a, "onSensorChanged RemoteException");
                    }
                }
            } else if (sensorEvent.values[0] > 600.0f) {
                if (this.f15069w != null && !b()) {
                    this.f15069w.setVisibility(8);
                }
                IOnLightCallback iOnLightCallback2 = this.f15068v;
                if (iOnLightCallback2 != null) {
                    try {
                        iOnLightCallback2.onVisibleChanged(false);
                    } catch (RemoteException unused2) {
                        a.d(f15047a, "onSensorChanged RemoteException");
                    }
                }
            }
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStart() {
        try {
            this.f15054h.f();
        } catch (RuntimeException e10) {
            a.b(f15047a, "onStartRuntimeException");
            e10.printStackTrace();
        } catch (Exception e11) {
            a.b(f15047a, "onStartException");
            e11.printStackTrace();
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStop() {
        try {
            this.f15054h.g();
        } catch (RuntimeException e10) {
            a.b(f15047a, "onStopRuntimeException");
            e10.printStackTrace();
        } catch (Exception e11) {
            a.b(f15047a, "onStopException");
            e11.printStackTrace();
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void pauseContinuouslyScan() throws RemoteException {
        C0559e eVar = this.f15054h;
        if (eVar != null) {
            eVar.h();
        }
        this.f15070x = true;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void resumeContinuouslyScan() throws RemoteException {
        this.f15070x = false;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnClickListener(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.f15057k = (View.OnClickListener) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnErrorCallback(IOnErrorCallback iOnErrorCallback) throws RemoteException {
        C0559e eVar = this.f15054h;
        if (eVar != null) {
            eVar.a(iOnErrorCallback);
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnLightVisbleCallBack(IOnLightCallback iOnLightCallback) throws RemoteException {
        this.f15068v = iOnLightCallback;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnResultCallback(IOnResultCallback iOnResultCallback) {
        this.f15055i = iOnResultCallback;
        C0559e eVar = this.f15054h;
        if (eVar != null) {
            eVar.a(iOnResultCallback);
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOffLight() throws RemoteException {
        g();
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOnLight() throws RemoteException {
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10) {
        C0559e eVar = this.f15054h;
        if (eVar != null && eVar.a() != null && i10 != this.f15054h.a().getCameraOrientation()) {
            this.f15054h.a().refreshCameraOrientation(i10);
            if (!b.b(this.f15051e) || b.b((Activity) this.f15051e)) {
                e();
            } else if (b.c((Activity) this.f15051e)) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15053g.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = (int) ((a(this.f15051e).x / 1080.0f) * 1920.0f);
                layoutParams.gravity = 17;
            } else {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f15053g.getLayoutParams();
                layoutParams2.gravity = 17;
                layoutParams2.height = -1;
                layoutParams2.width = (int) ((a(this.f15051e).x / 1080.0f) * 1920.0f);
                layoutParams2.gravity = 17;
            }
        }
    }

    private static Point a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (b.b(context)) {
            Log.i(f15047a, "initSurfaceView: is in MultiWindowMode");
            defaultDisplay.getSize(point);
        } else {
            defaultDisplay.getRealSize(point);
        }
        return point;
    }

    protected void a(Point point) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15053g.getLayoutParams();
        float f10 = point.x;
        float f11 = point.y;
        if (!b.c((Activity) this.f15051e)) {
            f15048b = true;
            float f12 = f10 / 1920.0f;
            float f13 = f11 / 1080.0f;
            if (f12 > f13) {
                layoutParams.width = -1;
                layoutParams.height = (int) (f12 * 1080.0f);
                layoutParams.gravity = 17;
                return;
            }
            layoutParams.height = -1;
            layoutParams.width = (int) (f13 * 1920.0f);
            layoutParams.gravity = 17;
            return;
        }
        f15048b = false;
        float f14 = f10 / 1080.0f;
        float f15 = f11 / 1920.0f;
        if (f14 > f15) {
            layoutParams.width = -1;
            layoutParams.height = (int) (f14 * 1920.0f);
            layoutParams.gravity = 17;
            return;
        }
        layoutParams.height = -1;
        layoutParams.width = (int) (f15 * 1080.0f);
        layoutParams.gravity = 17;
    }

    @Override // com.huawei.hms.scankit.A
    public boolean a(HmsScan[] hmsScanArr) {
        AlertDialog alertDialog;
        if (hmsScanArr == null || hmsScanArr.length <= 0 || (alertDialog = this.f15061o) == null || !alertDialog.isShowing()) {
            return false;
        }
        this.f15061o.dismiss();
        return false;
    }

    @Override // com.huawei.hms.scankit.A
    public boolean a() {
        return this.f15070x;
    }

    private HmsScan[] a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z10;
        int i10;
        if (iObjectWrapper == null) {
            a.b("ScankitRemoteS", "bitmap is null");
            return new HmsScan[0];
        }
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z10 = false;
            i10 = 0;
        } else {
            i10 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            int i11 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i11;
            z10 = i11 >= 2;
            if (z10) {
                i10 = b.b(i10);
            }
        }
        HmsScan[] b10 = D.a().b((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), i10, true, this.f15049c);
        if (!z10) {
            b10 = b.a(b10);
        }
        if (b10.length == 0) {
            i();
        } else if (b10[0] != null && TextUtils.isEmpty(b10[0].originalValue)) {
            i();
        }
        return b10;
    }
}
