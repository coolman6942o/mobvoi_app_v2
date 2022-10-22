package com.mobvoi.qr;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import com.google.zxing.e;
import com.mobvoi.android.common.utils.k;
import java.io.IOException;
/* compiled from: CameraManager.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20357a;

    /* renamed from: b  reason: collision with root package name */
    private final b f20358b;

    /* renamed from: c  reason: collision with root package name */
    private Camera f20359c;

    /* renamed from: d  reason: collision with root package name */
    private com.mobvoi.qr.a f20360d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f20361e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f20362f;

    /* compiled from: CameraManager.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();
    }

    public c(Context context) {
        this.f20357a = context;
        this.f20358b = new b(context);
    }

    public e a(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10) {
        return new e(bArr, i10, i11, i12, i13, i14, i15, z10);
    }

    public synchronized void b() {
        Camera camera = this.f20359c;
        if (camera != null) {
            camera.release();
            this.f20359c = null;
        }
    }

    public Camera c() {
        return this.f20359c;
    }

    public Point d() {
        return this.f20358b.e();
    }

    public synchronized void e(SurfaceHolder surfaceHolder, int i10, int i11) throws IOException {
        this.f20359c.setPreviewDisplay(surfaceHolder);
        if (!this.f20361e) {
            this.f20361e = true;
            this.f20358b.f(this.f20359c, i10, i11);
        }
        Camera.Parameters parameters = this.f20359c.getParameters();
        String flatten = parameters == null ? null : parameters.flatten();
        try {
            this.f20358b.g(this.f20359c, false, i10, i11);
        } catch (RuntimeException unused) {
            k.a("CameraManager", "Camera rejected parameters. Setting only minimal safe-mode parameters");
            k.a("CameraManager", "Resetting to saved camera params: " + flatten);
            if (flatten != null) {
                Camera.Parameters parameters2 = this.f20359c.getParameters();
                parameters2.unflatten(flatten);
                try {
                    this.f20359c.setParameters(parameters2);
                    this.f20358b.g(this.f20359c, true, i10, i11);
                } catch (RuntimeException unused2) {
                    k.a("CameraManager", "Camera rejected even safe-mode parameters! No configuration");
                }
            }
        }
    }

    public synchronized void f(a aVar) {
        k.a("CameraManager", "openDriver()");
        if (this.f20359c == null) {
            k.a("CameraManager", "camera is null, start to open camera.");
            try {
                Camera a10 = new oj.c().b().a();
                this.f20359c = a10;
                if (a10 != null) {
                    k.a("CameraManager", "camera open success.");
                    aVar.b();
                } else {
                    k.a("CameraManager", "camera open fail.");
                    aVar.a();
                }
            } catch (Exception e10) {
                k.a("CameraManager", "camera open fail:" + e10.toString());
                aVar.a();
            }
        } else {
            k.a("CameraManager", "camera is not null.");
            aVar.b();
        }
    }

    public synchronized void g() {
        Camera camera = this.f20359c;
        if (camera != null && !this.f20362f) {
            camera.startPreview();
            this.f20362f = true;
            this.f20360d = new com.mobvoi.qr.a(this.f20357a, this.f20359c);
        }
    }

    public synchronized void h() {
        com.mobvoi.qr.a aVar = this.f20360d;
        if (aVar != null) {
            aVar.c();
            this.f20360d = null;
        }
        Camera camera = this.f20359c;
        if (camera != null && this.f20362f) {
            camera.stopPreview();
            this.f20362f = false;
        }
    }
}
