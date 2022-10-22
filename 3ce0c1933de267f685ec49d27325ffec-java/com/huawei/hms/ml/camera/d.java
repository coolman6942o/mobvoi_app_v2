package com.huawei.hms.ml.camera;

import android.hardware.Camera;
import android.os.AsyncTask;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
/* compiled from: CameraFocusManager.java */
/* loaded from: classes2.dex */
public final class d implements Camera.AutoFocusCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f14010a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f14011b;

    /* renamed from: c  reason: collision with root package name */
    private Camera f14012c;

    /* renamed from: d  reason: collision with root package name */
    private AsyncTask<?, ?, ?> f14013d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14014e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14015f = false;

    /* renamed from: g  reason: collision with root package name */
    private int f14016g = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CameraFocusManager.java */
    /* loaded from: classes2.dex */
    public static class a extends AsyncTask<Object, Object, Object> {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<d> f14017a;

        a(d dVar) {
            this.f14017a = new WeakReference<>(dVar);
        }

        @Override // android.os.AsyncTask
        protected final Object doInBackground(Object... objArr) {
            d dVar = this.f14017a.get();
            if (dVar == null) {
                return null;
            }
            dVar.a();
            try {
                Thread.sleep(dVar.c());
            } catch (InterruptedException unused) {
                Log.e("CameraManager", "CameraFocusManager::doInBackground InterruptedException");
            }
            return null;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f14010a = hashSet;
        hashSet.add(CameraConfig.CAMERA_FOCUS_AUTO);
        hashSet.add(CameraConfig.CAMERA_FOCUS_MACRO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Camera camera) {
        this.f14012c = camera;
        boolean contains = f14010a.contains(camera.getParameters().getFocusMode());
        this.f14011b = contains;
        Log.i("CameraManager", "CameraFocusManager useAutoFocus： " + contains);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int c() {
        return this.f14016g;
    }

    private synchronized void d() {
        AsyncTask<?, ?, ?> asyncTask = this.f14013d;
        if (asyncTask != null) {
            if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                this.f14013d.cancel(true);
            }
            this.f14013d = null;
        }
    }

    private synchronized void e() {
        if (!this.f14014e && this.f14013d == null) {
            a aVar = new a(this);
            try {
                aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.f14013d = aVar;
            } catch (RejectedExecutionException e10) {
                Log.w("CameraManager", "CameraFocusManager::autoFocusAgainLater RejectedExecutionException: " + e10.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void b() {
        this.f14014e = true;
        if (this.f14011b) {
            d();
            try {
                this.f14012c.cancelAutoFocus();
            } catch (RuntimeException e10) {
                Log.w("CameraManager", "Unexpected exception while cancelling focusing" + e10.getMessage());
            }
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public final synchronized void onAutoFocus(boolean z10, Camera camera) {
        this.f14015f = false;
        e();
    }

    public final synchronized void a() {
        if (this.f14011b) {
            this.f14013d = null;
            if (!this.f14014e && !this.f14015f) {
                try {
                    this.f14012c.autoFocus(this);
                    this.f14015f = true;
                } catch (RuntimeException e10) {
                    Log.w("CameraManager", "Unexpected exception while focusing" + e10.getMessage());
                    e();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(int i10) {
        this.f14016g = i10;
    }
}
