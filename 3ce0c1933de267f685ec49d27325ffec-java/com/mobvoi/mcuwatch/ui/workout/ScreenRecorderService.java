package com.mobvoi.mcuwatch.ui.workout;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Toast;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.mcuwatch.ui.workout.ScreenRecorderService;
import cq.a;
import ic.b;
import ic.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import rx.c;
import sh.f;
import sh.k;
import yp.g;
/* loaded from: classes2.dex */
public class ScreenRecorderService extends Service implements s.a {

    /* renamed from: a  reason: collision with root package name */
    private int f20241a;

    /* renamed from: b  reason: collision with root package name */
    private int f20242b;

    /* renamed from: c  reason: collision with root package name */
    private int f20243c;

    /* renamed from: d  reason: collision with root package name */
    private MediaProjectionManager f20244d;

    /* renamed from: e  reason: collision with root package name */
    private ImageReader f20245e;

    /* renamed from: f  reason: collision with root package name */
    private MediaProjection f20246f;

    /* renamed from: g  reason: collision with root package name */
    private VirtualDisplay f20247g;

    /* renamed from: h  reason: collision with root package name */
    private s f20248h = new s(this);

    private void e() {
        this.f20247g = this.f20246f.createVirtualDisplay("ScreenShot", this.f20241a, this.f20242b, this.f20243c, 16, this.f20245e.getSurface(), null, null);
        this.f20248h.sendEmptyMessageDelayed(2, 150L);
    }

    private void f() {
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        builder.setSmallIcon(f.f34582r1).setContentText(getString(k.f34786c5)).setWhen(System.currentTimeMillis());
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("notification_id");
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("notification_id", "notification_name", 2));
        }
        Notification build = builder.build();
        build.defaults = -1;
        startForeground(110, build);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
        if (r1 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap g() {
        Bitmap bitmap = null;
        try {
            try {
                Image acquireLatestImage = this.f20245e.acquireLatestImage();
                int width = acquireLatestImage.getWidth();
                int height = acquireLatestImage.getHeight();
                Image.Plane[] planes = acquireLatestImage.getPlanes();
                ByteBuffer buffer = planes[0].getBuffer();
                int pixelStride = planes[0].getPixelStride();
                Bitmap createBitmap = Bitmap.createBitmap(((planes[0].getRowStride() - (pixelStride * width)) / pixelStride) + width, height, Bitmap.Config.ARGB_8888);
                createBitmap.copyPixelsFromBuffer(buffer);
                bitmap = Bitmap.createBitmap(createBitmap, 0, 0, width, height);
                acquireLatestImage.close();
            } catch (Exception e10) {
                e10.printStackTrace();
                ImageReader imageReader = this.f20245e;
                if (imageReader != null) {
                    imageReader.close();
                }
                MediaProjection mediaProjection = this.f20246f;
                if (mediaProjection != null) {
                    mediaProjection.stop();
                }
                VirtualDisplay virtualDisplay = this.f20247g;
            }
        } finally {
            ImageReader imageReader2 = this.f20245e;
            if (imageReader2 != null) {
                imageReader2.close();
            }
            MediaProjection mediaProjection2 = this.f20246f;
            if (mediaProjection2 != null) {
                mediaProjection2.stop();
            }
            VirtualDisplay virtualDisplay2 = this.f20247g;
            if (virtualDisplay2 != null) {
                virtualDisplay2.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(Throwable th2) {
        Toast.makeText(this, getString(k.f34792d5), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        try {
            File a10 = d.a(this);
            if (!a10.exists() && !a10.createNewFile()) {
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(a10);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Bitmap bitmap) {
        b.b(this);
    }

    private void k() {
        c.x(new Callable() { // from class: mj.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Bitmap g10;
                g10 = ScreenRecorderService.this.g();
                return g10;
            }
        }).u(new g() { // from class: mj.g
            @Override // yp.g
            public final Object call(Object obj) {
                boolean i10;
                i10 = ScreenRecorderService.this.i((Bitmap) obj);
                return Boolean.valueOf(i10);
            }
        }).Z(a.c()).H(xp.a.b()).Y(new yp.b() { // from class: mj.e
            @Override // yp.b
            public final void call(Object obj) {
                ScreenRecorderService.this.j((Bitmap) obj);
            }
        }, new yp.b() { // from class: mj.f
            @Override // yp.b
            public final void call(Object obj) {
                ScreenRecorderService.this.h((Throwable) obj);
            }
        });
    }

    @Override // com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            e();
        } else if (i10 == 2) {
            k();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    @SuppressLint({"WrongConstant"})
    public void onCreate() {
        super.onCreate();
        this.f20244d = (MediaProjectionManager) getSystemService("media_projection");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        this.f20241a = displayMetrics.widthPixels;
        this.f20242b = displayMetrics.heightPixels;
        this.f20243c = displayMetrics.densityDpi;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    @SuppressLint({"WrongConstant"})
    public int onStartCommand(Intent intent, int i10, int i11) {
        f();
        this.f20246f = this.f20244d.getMediaProjection(-1, (Intent) intent.getParcelableExtra("result_data"));
        this.f20245e = ImageReader.newInstance(this.f20241a, this.f20242b, 1, 2);
        this.f20248h.sendEmptyMessageDelayed(1, 5L);
        return 2;
    }
}
