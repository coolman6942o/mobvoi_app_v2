package com.mobvoi.qr;

import android.content.Context;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.util.Log;
import com.huawei.hms.ml.camera.CameraConfig;
import java.util.ArrayList;
import java.util.Collection;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoFocusManager.java */
/* loaded from: classes2.dex */
public final class a implements Camera.AutoFocusCallback {

    /* renamed from: f  reason: collision with root package name */
    private static final String f20347f = a.class.getSimpleName();

    /* renamed from: g  reason: collision with root package name */
    private static final Collection<String> f20348g;

    /* renamed from: a  reason: collision with root package name */
    private boolean f20349a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f20350b;

    /* renamed from: c  reason: collision with root package name */
    private final Camera f20351c;

    /* renamed from: d  reason: collision with root package name */
    private b f20352d;

    /* renamed from: e  reason: collision with root package name */
    private pj.a f20353e = new pj.b().b();

    /* compiled from: AutoFocusManager.java */
    /* loaded from: classes2.dex */
    private final class b extends AsyncTask<Object, Object, Object> {
        private b() {
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException unused) {
            }
            synchronized (a.this) {
                if (a.this.f20349a) {
                    a.this.b();
                }
            }
            return null;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(5);
        f20348g = arrayList;
        arrayList.add(CameraConfig.CAMERA_FOCUS_AUTO);
        arrayList.add(CameraConfig.CAMERA_FOCUS_MACRO);
        arrayList.add("continuous-picture");
        arrayList.add("continuous-video");
        arrayList.add("edof");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, Camera camera) {
        this.f20351c = camera;
        String focusMode = camera.getParameters().getFocusMode();
        this.f20350b = f20348g.contains(focusMode);
        String str = f20347f;
        Log.i(str, "Current focus mode '" + focusMode + "'; use auto focus? " + this.f20350b);
        b();
    }

    synchronized void b() {
        if (this.f20350b) {
            this.f20349a = true;
            try {
                this.f20351c.autoFocus(this);
            } catch (RuntimeException e10) {
                Log.w(f20347f, "Unexpected exception while focusing", e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c() {
        if (this.f20350b) {
            try {
                this.f20351c.cancelAutoFocus();
            } catch (RuntimeException e10) {
                Log.w(f20347f, "Unexpected exception while cancelling focusing", e10);
            }
        }
        b bVar = this.f20352d;
        if (bVar != null) {
            bVar.cancel(true);
            this.f20352d = null;
        }
        this.f20349a = false;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z10, Camera camera) {
        if (this.f20349a) {
            b bVar = new b();
            this.f20352d = bVar;
            this.f20353e.a(bVar, new Object[0]);
        }
    }
}
