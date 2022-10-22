package com.huawei.hms.scankit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.ml.camera.CameraManager;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.aiscan.common.A;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.z;
import com.huawei.hms.scankit.p.AbstractC0619pb;
import com.huawei.hms.scankit.util.a;
import com.huawei.hms.scankit.util.c;
import java.util.Collection;
import java.util.Map;
/* compiled from: CaptureHandler.java */
/* renamed from: com.huawei.hms.scankit.a  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class HandlerC0549a extends Handler implements A {

    /* renamed from: a  reason: collision with root package name */
    private final B f14119a;

    /* renamed from: b  reason: collision with root package name */
    private final m f14120b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14121c;

    /* renamed from: d  reason: collision with root package name */
    private EnumC0180a f14122d = EnumC0180a.SUCCESS;

    /* renamed from: e  reason: collision with root package name */
    private Context f14123e;

    /* renamed from: f  reason: collision with root package name */
    private final CameraManager f14124f;

    /* renamed from: g  reason: collision with root package name */
    private final ViewfinderView f14125g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14126h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14127i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14128j;

    /* renamed from: k  reason: collision with root package name */
    private A f14129k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14130l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CaptureHandler.java */
    /* renamed from: com.huawei.hms.scankit.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0180a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC0549a(Context context, ViewfinderView viewfinderView, B b10, Collection<BarcodeFormat> collection, Map<EnumC0553d, ?> map, String str, CameraManager cameraManager, Rect rect, int i10, boolean z10, boolean z11) {
        this.f14125g = viewfinderView;
        this.f14119a = b10;
        this.f14121c = i10;
        this.f14123e = context;
        m mVar = new m(context, cameraManager, this, collection, map, str, this);
        this.f14120b = mVar;
        mVar.a(rect);
        mVar.a(z11);
        mVar.start();
        this.f14130l = z10;
        cameraManager.setFrameCallback(new C(mVar));
        this.f14124f = cameraManager;
        cameraManager.startPreview();
        a.a("scan-time", "start preview time:" + System.currentTimeMillis());
        f();
        AbstractC0619pb.c(null);
    }

    public void a(A a10) {
        this.f14129k = a10;
    }

    public int b() {
        return this.f14121c;
    }

    public void c(boolean z10) {
        this.f14126h = z10;
    }

    public boolean d() {
        return this.f14128j;
    }

    public void e() {
        this.f14122d = EnumC0180a.DONE;
        this.f14124f.stopPreview();
        Message.obtain(this.f14120b.a(), R.id.scankit_quit).sendToTarget();
        try {
            this.f14120b.b();
            this.f14120b.join(50L);
        } catch (InterruptedException unused) {
            a.d("CaptureHandler", "quitSynchronously   wait interrupt");
        }
        removeMessages(R.id.scankit_decode_succeeded);
        removeMessages(R.id.scankit_decode_failed);
    }

    public void f() {
        if (this.f14122d == EnumC0180a.SUCCESS) {
            this.f14122d = EnumC0180a.PREVIEW;
            this.f14124f.requestPreviewFrame();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == R.id.scankit_restart_preview) {
            f();
        } else if (i10 == R.id.scankit_decode_succeeded) {
            this.f14122d = EnumC0180a.SUCCESS;
            Object obj = message.obj;
            if (obj instanceof HmsScan[]) {
                HmsScan[] hmsScanArr = (HmsScan[]) obj;
                if (hmsScanArr.length <= 0 || hmsScanArr[0] == null || TextUtils.isEmpty(hmsScanArr[0].originalValue)) {
                    a.c("CaptureHandler", "retrieve  HmsScan lenth is 0");
                } else {
                    a.c("CaptureHandler", "scan successful");
                    Bitmap bitmap = null;
                    float f10 = 0.0f;
                    if (this.f14127i) {
                        a.c("CaptureHandler", "scan successful & return bitmap");
                        Bundle data = message.getData();
                        if (data != null) {
                            byte[] byteArray = data.getByteArray("barcode_bitmap");
                            f10 = data.getFloat("barcode_scaled_factor", 0.0f);
                            if (byteArray != null && byteArray.length > 0) {
                                bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                            }
                        }
                        this.f14119a.a(hmsScanArr, bitmap, f10);
                    } else {
                        this.f14119a.a(hmsScanArr, null, 0.0f);
                    }
                    if (!this.f14130l) {
                        return;
                    }
                }
                f();
            }
        } else if (i10 == R.id.scankit_decode_failed) {
            this.f14122d = EnumC0180a.PREVIEW;
            this.f14124f.requestPreviewFrame();
        }
    }

    private z b(z zVar) {
        float f10;
        float f11;
        int i10;
        Point a10 = c.a(this.f14123e);
        Point cameraSize = this.f14124f.getCameraSize();
        int i11 = a10.x;
        int i12 = a10.y;
        if (i11 < i12) {
            float f12 = (i12 * 1.0f) / cameraSize.x;
            f11 = (zVar.b() * ((i11 * 1.0f) / cameraSize.y)) - (Math.max(a10.x, cameraSize.y) / 2.0f);
            f10 = zVar.c() * f12;
            i10 = Math.min(a10.y, cameraSize.x);
        } else {
            float f13 = (i12 * 1.0f) / cameraSize.y;
            f11 = (zVar.b() * ((i11 * 1.0f) / cameraSize.x)) - (Math.min(a10.y, cameraSize.y) / 2.0f);
            f10 = zVar.c() * f13;
            i10 = Math.max(a10.x, cameraSize.x);
        }
        return new z(f11, f10 - (i10 / 2.0f));
    }

    public boolean a() {
        A a10 = this.f14129k;
        if (a10 != null) {
            return a10.a();
        }
        return false;
    }

    public boolean c() {
        return this.f14127i;
    }

    @Override // com.huawei.hms.scankit.aiscan.common.A
    public void a(z zVar) {
        if (this.f14125g != null) {
            this.f14125g.a(b(zVar));
        }
    }

    public void a(boolean z10) {
        this.f14127i = z10;
    }

    public void b(boolean z10) {
        this.f14128j = z10;
    }
}
