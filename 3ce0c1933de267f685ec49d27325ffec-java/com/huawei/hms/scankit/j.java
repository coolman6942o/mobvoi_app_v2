package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
import com.huawei.hms.ml.camera.CameraExposureData;
import com.huawei.hms.ml.camera.CameraManager;
import com.huawei.hms.ml.camera.CameraMeteringData;
import com.huawei.hms.ml.camera.CameraZoomData;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.p.AbstractC0619pb;
import com.huawei.hms.scankit.p.Ta;
import com.huawei.hms.scankit.util.c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* compiled from: DecodeHandler.java */
/* loaded from: classes2.dex */
final class j extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static long f14381a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f14382b;

    /* renamed from: c  reason: collision with root package name */
    private final CameraManager f14383c;

    /* renamed from: d  reason: collision with root package name */
    private final HandlerC0549a f14384d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14385e = true;

    /* renamed from: f  reason: collision with root package name */
    private int f14386f = 50;

    /* renamed from: g  reason: collision with root package name */
    private a f14387g;

    /* renamed from: h  reason: collision with root package name */
    private Rect f14388h;

    /* renamed from: i  reason: collision with root package name */
    private int f14389i;

    /* renamed from: j  reason: collision with root package name */
    private IRemoteFrameDecoderDelegate f14390j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f14391k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeHandler.java */
    /* loaded from: classes2.dex */
    public static class a extends AsyncTask<Object, Object, Object> {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<j> f14392a;

        /* renamed from: e  reason: collision with root package name */
        private List<CameraMeteringData.Area> f14396e;

        /* renamed from: b  reason: collision with root package name */
        private boolean f14393b = true;

        /* renamed from: c  reason: collision with root package name */
        private boolean f14394c = false;

        /* renamed from: d  reason: collision with root package name */
        private int f14395d = 0;

        /* renamed from: f  reason: collision with root package name */
        private int f14397f = 0;

        public a(j jVar) {
            this.f14392a = new WeakReference<>(jVar);
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            Log.i("ScankitDecode", "doInBackground: ");
            while (!this.f14394c) {
                if (this.f14393b) {
                    try {
                        Thread.sleep(400L);
                    } catch (InterruptedException unused) {
                        com.huawei.hms.scankit.util.a.c("ScankitDecode", "doInBackground  get InterruptedException  error!!!");
                    }
                    this.f14393b = false;
                } else {
                    j jVar = this.f14392a.get();
                    int i10 = this.f14397f;
                    if (i10 == 0) {
                        this.f14393b = true;
                    } else if (jVar != null) {
                        try {
                            jVar.a(this.f14395d / i10, this.f14396e);
                            a();
                            this.f14393b = true;
                        } catch (RuntimeException e10) {
                            com.huawei.hms.scankit.util.a.b("DecodeHandler", "RuntimeException: " + e10.getMessage());
                        } catch (Exception unused2) {
                            com.huawei.hms.scankit.util.a.b("DecodeHandler", "Exception");
                        }
                    }
                }
            }
            return null;
        }

        public void a(int i10) {
            this.f14395d += i10;
            this.f14397f++;
        }

        public void a(List<Rect> list, int i10, int i11, boolean z10) {
            if (list == null) {
                com.huawei.hms.scankit.util.a.a("ScankitDecode", "areas is null");
            } else if (list.size() == 0) {
                this.f14396e = Collections.singletonList(new CameraMeteringData.Area(new Rect(-100, -100, 100, 100), 1000));
            } else {
                this.f14396e = new ArrayList();
                if (z10) {
                    int i12 = (i11 > i10 ? i11 - i10 : i10 - i11) >> 1;
                    for (Rect rect : list) {
                        int centerY = (((rect.centerY() + i12) * 2000) / i10) - 1000;
                        int centerX = ((rect.centerX() * 2000) / i11) - 1000;
                        int height = ((rect.height() * 2000) / i10) / 2;
                        int width = ((rect.width() * 2000) / i11) / 2;
                        this.f14396e.add(new CameraMeteringData.Area(new Rect(centerY - (height / 2), centerX - (width / 2), centerY + height, centerX + width), 1000 / list.size()));
                    }
                    return;
                }
                for (Rect rect2 : list) {
                    int centerX2 = ((rect2.centerX() * 2000) / i10) - 1000;
                    int centerY2 = ((rect2.centerY() * 2000) / i11) - 1000;
                    int width2 = ((rect2.width() * 2000) / i10) / 2;
                    int height2 = ((rect2.height() * 2000) / i11) / 2;
                    this.f14396e.add(new CameraMeteringData.Area(new Rect(centerX2 - (width2 / 2), centerY2 - (height2 / 2), centerX2 + width2, centerY2 + height2), 1000 / list.size()));
                }
                list.clear();
            }
        }

        private void a() {
            this.f14395d = 0;
            this.f14397f = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, CameraManager cameraManager, HandlerC0549a aVar, Map<EnumC0553d, Object> map, Rect rect, boolean z10) {
        this.f14391k = false;
        this.f14382b = context;
        this.f14383c = cameraManager;
        this.f14384d = aVar;
        this.f14388h = rect;
        if (this.f14387g == null) {
            a aVar2 = new a(this);
            this.f14387g = aVar2;
            aVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
        this.f14389i = 0;
        this.f14391k = z10;
        a(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049 A[Catch: RemoteException -> 0x0061, TryCatch #0 {RemoteException -> 0x0061, blocks: (B:19:0x0045, B:21:0x0049, B:23:0x0056, B:25:0x005a), top: B:29:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0056 A[Catch: RemoteException -> 0x0061, TryCatch #0 {RemoteException -> 0x0061, blocks: (B:19:0x0045, B:21:0x0049, B:23:0x0056, B:25:0x005a), top: B:29:0x0045 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context) {
        Object obj;
        try {
            try {
                if (this.f14391k) {
                    Log.d("ScankitDecode", "use local decoder");
                    obj = DecoderCreator.class.newInstance();
                } else {
                    Log.d("ScankitDecode", "use remote decoder");
                    try {
                        context = com.huawei.hms.hmsscankit.j.d(context);
                    } catch (NoSuchMethodException | InvocationTargetException unused) {
                    }
                    Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.hms.scankit.DecoderCreator");
                    context.getClassLoader().loadClass("com.huawei.hms.scankit.aiscan.common.BarcodeFormat");
                    obj = loadClass.newInstance();
                }
            } catch (ClassNotFoundException unused2) {
                com.huawei.hms.scankit.util.a.a("ScankitDecode", "ClassNotFoundException");
                obj = null;
                if (!(obj instanceof IBinder)) {
                }
            } catch (IllegalAccessException unused3) {
                com.huawei.hms.scankit.util.a.a("ScankitDecode", "IllegalAccessException");
                obj = null;
                if (!(obj instanceof IBinder)) {
                }
            } catch (InstantiationException unused4) {
                com.huawei.hms.scankit.util.a.a("ScankitDecode", "InstantiationException");
                obj = null;
                if (!(obj instanceof IBinder)) {
                }
            }
            if (!(obj instanceof IBinder)) {
                this.f14390j = IRemoteDecoderCreator.Stub.asInterface((IBinder) obj).newRemoteFrameDecoderDelegate();
            } else if (this.f14390j == null) {
                this.f14390j = s.a();
            }
        } catch (RemoteException unused5) {
            com.huawei.hms.scankit.util.a.a("ScankitDecode", "RemoteException");
        }
    }

    private boolean c() {
        Context context = this.f14382b;
        if (context == null) {
            return true;
        }
        Object systemService = context.getSystemService("window");
        if (systemService instanceof WindowManager) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            return point.x < point.y;
        }
        com.huawei.hms.scankit.util.a.c("ScankitDecode", "isScreenPortrait  getSystemService  WINDOW_SERVICE  error!!!");
        return true;
    }

    public boolean b(float f10) {
        List<Integer> allZoomRations;
        boolean z10;
        HandlerC0549a aVar = this.f14384d;
        if (aVar != null && aVar.a()) {
            return false;
        }
        try {
            CameraZoomData cameraZoomData = this.f14383c.getCameraZoomData();
            if (cameraZoomData == null) {
                com.huawei.hms.scankit.util.a.c("ScankitDecode", "Zoom not supported,data is null");
                return false;
            }
            int maxZoomIndex = cameraZoomData.getMaxZoomIndex();
            int currentZoomIndex = cameraZoomData.getCurrentZoomIndex();
            float intValue = ((allZoomRations.get(currentZoomIndex).intValue() * 1.0f) / 100.0f) * f10;
            if (((int) (intValue * 100.0f)) > cameraZoomData.getAllZoomRations().get(maxZoomIndex).intValue()) {
                intValue = (maxZoomIndex * 1.0f) / 100.0f;
            }
            if (this.f14383c.isSupportZoom()) {
                int a10 = a(intValue);
                if (a10 > currentZoomIndex) {
                    this.f14383c.setCameraZoomValue(a10);
                    z10 = true;
                } else {
                    this.f14383c.setCameraZoomValue(currentZoomIndex);
                    z10 = false;
                }
                this.f14383c.setCameraMeteringArea(Collections.singletonList(new CameraMeteringData.Area(new Rect(-150, -150, 150, 150), 1000)));
                return z10;
            }
            com.huawei.hms.scankit.util.a.c("ScankitDecode", "Zoom not supported");
            return false;
        } catch (RuntimeException unused) {
            com.huawei.hms.scankit.util.a.b("ScankitDecode", "Zoom not supported,RuntimeException happen");
            return false;
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b("ScankitDecode", "Zoom not supported,Exception happen");
            return false;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null && this.f14385e) {
            int i10 = message.what;
            if (i10 == R.id.scankit_decode) {
                int i11 = this.f14389i;
                if (i11 <= 1) {
                    this.f14389i = i11 + 1;
                    this.f14384d.sendEmptyMessage(R.id.scankit_decode_failed);
                    return;
                }
                Object obj = message.obj;
                if (obj instanceof byte[]) {
                    a((byte[]) obj, c());
                }
            } else if (i10 == R.id.scankit_quit) {
                this.f14385e = false;
                a aVar = this.f14387g;
                if (aVar != null) {
                    aVar.f14394c = true;
                    this.f14387g.cancel(true);
                }
                Looper.myLooper().quit();
            } else {
                com.huawei.hms.scankit.util.a.c("ScankitDecode", "handleMessage  message.what:" + message.what);
            }
        }
    }

    public float b() {
        List<Integer> a10 = a();
        if (a10 == null) {
            return 1.0f;
        }
        return Math.round(a10.get(a10.size() - 1).intValue() / 100.0f);
    }

    private void a(byte[] bArr, boolean z10) {
        x[] xVarArr;
        int i10 = this.f14383c.getCameraSize().x;
        int i11 = this.f14383c.getCameraSize().y;
        Context context = this.f14382b;
        int rotation = (context == null || !(context instanceof Activity)) ? 0 : ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
        if (this.f14384d != null) {
            Ta.a a10 = C0559e.f14348b != null ? C0559e.f14348b.a(false, i10 * i11) : null;
            Bundle bundle = new Bundle();
            bundle.putParcelable("Rect", this.f14388h);
            Point a11 = c.a(this.f14382b);
            if (a11 != null) {
                bundle.putParcelable("Screen", a11);
            }
            try {
                xVarArr = this.f14390j.decode(bArr, i10, i11, rotation, this.f14384d.b(), ObjectWrapper.wrap(bundle));
            } catch (RemoteException unused) {
                Log.e("ScankitDecode", "RemoteException");
                xVarArr = null;
            }
            if (xVarArr == null || xVarArr.length <= 0 || xVarArr[0] == null) {
                this.f14384d.sendEmptyMessage(R.id.scankit_decode_failed);
                if (C0559e.f14348b != null) {
                    C0559e.f14348b.a((HmsScan[]) null, a10);
                    return;
                }
                return;
            }
            if (this.f14384d.d() && xVarArr[0].h() != 1.0f && System.currentTimeMillis() - f14381a > 1000) {
                com.huawei.hms.scankit.util.a.c("ScankitDecode", "need to zoom" + xVarArr[0].h());
                if (a(xVarArr[0].h(), xVarArr, a10)) {
                    f14381a = System.currentTimeMillis();
                    return;
                }
            }
            if (xVarArr[0].g() == null) {
                com.huawei.hms.scankit.util.a.c("ScankitDecode", "need to exposure" + xVarArr[0].d());
                this.f14387g.a(xVarArr[0].d());
                this.f14387g.a(xVarArr[0].c(), i10, i11, z10);
            }
            a(xVarArr, bArr, i10, i11, a10);
        }
    }

    private boolean a(float f10, x[] xVarArr, Ta.a aVar) {
        if (!b(f10)) {
            return false;
        }
        Message obtain = Message.obtain();
        obtain.what = R.id.scankit_decode_succeeded;
        HmsScan[] a10 = AbstractC0619pb.a(xVarArr);
        obtain.obj = a10;
        if (C0559e.f14348b != null) {
            C0559e.f14348b.a(a10, aVar);
        }
        this.f14384d.sendMessage(obtain);
        return true;
    }

    private void a(x[] xVarArr, byte[] bArr, int i10, int i11, Ta.a aVar) {
        if (this.f14384d != null) {
            HmsScan[] a10 = AbstractC0619pb.a(xVarArr);
            Message obtain = Message.obtain(this.f14384d, R.id.scankit_decode_succeeded, a10);
            Log.d("ScankitDecode", "scankit decode succeed msg");
            if (C0559e.f14348b != null) {
                C0559e.f14348b.a(a10, aVar);
            }
            if (this.f14384d.c()) {
                Bundle bundle = new Bundle();
                a(bArr, i10, i11, bundle);
                obtain.setData(bundle);
            }
            obtain.sendToTarget();
        }
    }

    private static void a(byte[] bArr, int i10, int i11, Bundle bundle) {
        if (bArr != null && bArr.length != 0) {
            YuvImage yuvImage = new YuvImage(bArr, 17, i10, i11, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, i10, i11), 100, byteArrayOutputStream);
            bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
            bundle.putFloat("barcode_scaled_factor", 1.0f);
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
                Log.e("ScankitDecode", "RemoteException");
            }
        }
    }

    public void a(int i10, List<CameraMeteringData.Area> list) {
        CameraExposureData cameraExposureData = this.f14383c.getCameraExposureData();
        int maxValue = cameraExposureData.getMaxValue();
        int minValue = cameraExposureData.getMinValue();
        int currentValue = cameraExposureData.getCurrentValue();
        if (i10 != 0) {
            int i11 = currentValue + i10;
            if (i11 <= maxValue) {
                maxValue = i11 < minValue ? minValue : i11;
            }
            this.f14383c.setCameraExposureValue(maxValue);
            CameraMeteringData cameraMeteringData = this.f14383c.getCameraMeteringData();
            Rect meteringArea = cameraMeteringData.getMeteringArea();
            if (cameraMeteringData.getMaxNumMeteringAreas() <= 0) {
                return;
            }
            if (cameraMeteringData.getMaxNumMeteringAreas() == 1) {
                int centerX = meteringArea.centerX();
                int centerY = meteringArea.centerY();
                if (Math.sqrt(((centerX - list.get(0).rect.centerX()) * (centerX - list.get(0).rect.centerX())) + (centerY - list.get(0).rect.centerY()) + (centerY - list.get(0).rect.centerY())) > this.f14386f) {
                    list.set(0, new CameraMeteringData.Area(list.get(0).rect, 1000));
                    this.f14383c.setCameraMeteringArea(list.subList(0, 1));
                    return;
                }
                return;
            }
            this.f14383c.setCameraMeteringArea(list);
        }
    }

    public int a(float f10) {
        List<Integer> a10 = a();
        if (a10 == null) {
            return -3;
        }
        if (a10.size() <= 0) {
            return -4;
        }
        if (f10 == 1.0f) {
            return 0;
        }
        if (f10 == b()) {
            return a10.size() - 1;
        }
        for (int i10 = 1; i10 < a10.size(); i10++) {
            float f11 = 100.0f * f10;
            if (a10.get(i10).intValue() >= f11 && a10.get(i10 - 1).intValue() <= f11) {
                return i10;
            }
        }
        return -1;
    }

    public List<Integer> a() {
        return this.f14383c.getCameraZoomData().getAllZoomRations();
    }
}
