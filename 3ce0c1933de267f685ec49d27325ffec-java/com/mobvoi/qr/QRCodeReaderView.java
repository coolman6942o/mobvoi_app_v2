package com.mobvoi.qr;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.f;
import com.google.zxing.h;
import com.huawei.hms.ml.camera.CameraConfig;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.qr.c;
/* loaded from: classes2.dex */
public class QRCodeReaderView extends SurfaceView implements SurfaceHolder.Callback, Camera.PreviewCallback, c.a {

    /* renamed from: a  reason: collision with root package name */
    private b f20339a;

    /* renamed from: b  reason: collision with root package name */
    private d9.a f20340b;

    /* renamed from: c  reason: collision with root package name */
    private int f20341c;

    /* renamed from: d  reason: collision with root package name */
    private int f20342d;

    /* renamed from: e  reason: collision with root package name */
    private SurfaceHolder f20343e;

    /* renamed from: f  reason: collision with root package name */
    private c f20344f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f20345g = true;

    /* loaded from: classes2.dex */
    class a extends Thread {
        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            QRCodeReaderView.this.f20344f.f(QRCodeReaderView.this);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void E(String str, byte[] bArr, Camera.Parameters parameters);

        void P();

        void R();
    }

    public QRCodeReaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    private boolean d(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera") || context.getPackageManager().hasSystemFeature("android.hardware.camera.front") || context.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    private void e() {
        if (d(getContext())) {
            this.f20344f = new c(getContext());
            SurfaceHolder holder = getHolder();
            this.f20343e = holder;
            holder.addCallback(this);
            this.f20343e.setType(3);
            return;
        }
        Log.e("QRCodeReaderView", "Error: Camera not found");
        b bVar = this.f20339a;
        if (bVar != null) {
            bVar.R();
        }
    }

    public static void f(Context context, Camera camera) {
        int i10;
        if (Build.VERSION.SDK_INT >= 9) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            int i11 = 0;
            Camera.getCameraInfo(0, cameraInfo);
            int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i11 = 90;
                } else if (rotation == 2) {
                    i11 = CameraConfig.CAMERA_THIRD_DEGREE;
                } else if (rotation == 3) {
                    i11 = 270;
                }
            }
            if (cameraInfo.facing == 1) {
                i10 = (360 - ((cameraInfo.orientation + i11) % 360)) % 360;
            } else {
                i10 = ((cameraInfo.orientation - i11) + 360) % 360;
            }
            camera.setDisplayOrientation(i10);
        }
    }

    @Override // com.mobvoi.qr.c.a
    public void a() {
        k.a("QRCodeReaderView", "cameraOpenFail()");
        this.f20344f.b();
        b bVar = this.f20339a;
        if (bVar != null) {
            bVar.R();
        }
    }

    @Override // com.mobvoi.qr.c.a
    public void b() {
        k.a("QRCodeReaderView", "cameraHasOpened()");
        try {
            this.f20344f.e(getHolder(), getWidth(), getHeight());
            this.f20340b = new d9.a();
            this.f20341c = this.f20344f.d().x;
            this.f20342d = this.f20344f.d().y;
            this.f20344f.h();
            this.f20344f.c().setPreviewCallback(this);
            this.f20344f.c().setDisplayOrientation(90);
            f(getContext(), this.f20344f.c());
            this.f20344f.g();
        } catch (Exception e10) {
            k.a("QRCodeReaderView", "Can not openDriver: " + e10.getMessage());
            this.f20344f.b();
            b bVar = this.f20339a;
            if (bVar != null) {
                bVar.R();
            }
        }
    }

    public c getCameraManager() {
        return this.f20344f;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        int min = Math.min(this.f20341c, this.f20342d);
        int i10 = min - ((int) ((min / 720.0f) * 212.0f));
        c cVar = this.f20344f;
        int i11 = this.f20341c;
        int i12 = this.f20342d;
        com.google.zxing.b bVar = new com.google.zxing.b(new f(cVar.a(bArr, i11, i12, (i11 - i10) / 2, (i12 - i10) / 2, i10, i10, false)));
        try {
            try {
                try {
                    try {
                        if (this.f20345g) {
                            h b10 = this.f20340b.b(bVar);
                            if (!(this.f20339a == null || b10 == null || TextUtils.isEmpty(b10.f()))) {
                                this.f20339a.E(b10.f(), bArr, camera.getParameters());
                            }
                        }
                    } catch (FormatException e10) {
                        Log.d("QRCodeReaderView", "FormatException");
                        e10.printStackTrace();
                    }
                } catch (NotFoundException unused) {
                    b bVar2 = this.f20339a;
                    if (bVar2 != null) {
                        bVar2.P();
                    }
                }
            } catch (ChecksumException e11) {
                Log.d("QRCodeReaderView", "ChecksumException");
                e11.printStackTrace();
            }
        } finally {
            this.f20340b.e();
        }
    }

    public void setCanScan(boolean z10) {
        this.f20345g = z10;
        if (z10) {
            this.f20344f.g();
            Camera c10 = this.f20344f.c();
            if (c10 != null) {
                c10.setPreviewCallback(this);
                return;
            }
            return;
        }
        this.f20344f.h();
    }

    public void setOnQRCodeReadListener(b bVar) {
        this.f20339a = bVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        Log.d("QRCodeReaderView", "surfaceChanged");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        k.a("QRCodeReaderView", "surfaceCreated()");
        new a().start();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.d("QRCodeReaderView", "surfaceDestroyed");
        this.f20344f.h();
        Camera c10 = this.f20344f.c();
        if (c10 != null) {
            c10.setPreviewCallback(null);
            c10.stopPreview();
            c10.release();
        }
        this.f20344f.b();
    }
}
