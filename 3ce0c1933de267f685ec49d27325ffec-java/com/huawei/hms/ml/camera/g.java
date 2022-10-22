package com.huawei.hms.ml.camera;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.huawei.hms.mlkit.common.ha.HianalyticsLog;
import com.huawei.hms.mlkit.common.ha.HianalyticsLogProvider;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* compiled from: HiAnalyticsThread.java */
/* loaded from: classes2.dex */
public final class g extends Thread {

    /* renamed from: a  reason: collision with root package name */
    Handler f14020a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Context> f14021b;

    public g(Context context) {
        this.f14021b = new WeakReference<>(context);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Looper.prepare();
        this.f14020a = new a(this.f14021b);
        Looper.loop();
    }

    /* compiled from: HiAnalyticsThread.java */
    /* loaded from: classes2.dex */
    static class a extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<Context> f14023b;

        /* renamed from: a  reason: collision with root package name */
        private boolean f14022a = true;

        /* renamed from: c  reason: collision with root package name */
        private HashMap<String, HianalyticsLog> f14024c = new HashMap<>();

        public a(WeakReference<Context> weakReference) {
            this.f14023b = weakReference;
        }

        private HianalyticsLog a(String str) {
            if (HianalyticsLogProvider.getInstance().sdkForbiddenHiLog(this.f14023b.get())) {
                return null;
            }
            return HianalyticsLogProvider.getInstance().logBegin(this.f14023b.get(), new com.huawei.hms.ml.camera.a(this.f14023b.get()).a()).setModuleName(str).setApiName(str).setApkVersion("2.0.3.300");
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (this.f14022a) {
                int i10 = message.what;
                if (i10 == R.id.mlkit_camera_preview_ha_begin) {
                    this.f14024c.put("preview", a((String) message.obj));
                } else if (i10 == R.id.mlkit_camera_preview_ha_end) {
                    a(this.f14024c.get("preview"));
                    this.f14024c.put("preview", null);
                } else if (i10 == R.id.mlkit_camera_picture_ha_begin) {
                    this.f14024c.put("picture", a((String) message.obj));
                } else if (i10 == R.id.mlkit_camera_picture_ha_end) {
                    a(this.f14024c.get("picture"));
                    this.f14024c.put("picture", null);
                } else if (i10 == R.id.mlkit_camera_ha_quit) {
                    this.f14022a = false;
                    Looper.myLooper().quit();
                } else {
                    Log.w("CameraManager", "HiAnalyticsThread::handleMessage unknown message");
                }
            }
        }

        private static void a(HianalyticsLog hianalyticsLog) {
            if (hianalyticsLog != null) {
                HianalyticsLogProvider.getInstance().logEnd(hianalyticsLog);
            }
        }
    }
}
