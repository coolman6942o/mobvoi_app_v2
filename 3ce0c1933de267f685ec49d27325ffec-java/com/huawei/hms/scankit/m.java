package com.huawei.hms.scankit;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import com.huawei.hms.ml.camera.CameraManager;
import com.huawei.hms.scankit.aiscan.common.A;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.util.a;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecodeThread.java */
/* loaded from: classes2.dex */
public final class m extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private Context f14416a;

    /* renamed from: b  reason: collision with root package name */
    private final CameraManager f14417b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<EnumC0553d, Object> f14418c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f14419d;

    /* renamed from: e  reason: collision with root package name */
    private HandlerC0549a f14420e;

    /* renamed from: g  reason: collision with root package name */
    private Rect f14422g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14423h = true;

    /* renamed from: f  reason: collision with root package name */
    private final CountDownLatch f14421f = new CountDownLatch(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Context context, CameraManager cameraManager, HandlerC0549a aVar, Collection<BarcodeFormat> collection, Map<EnumC0553d, ?> map, String str, A a10) {
        this.f14416a = context;
        this.f14417b = cameraManager;
        this.f14420e = aVar;
        EnumMap enumMap = new EnumMap(EnumC0553d.class);
        this.f14418c = enumMap;
        if (map != null) {
            enumMap.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            collection = EnumSet.noneOf(BarcodeFormat.class);
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_product", true)) {
                collection.addAll(i.f14373a);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_industrial", true)) {
                collection.addAll(i.f14374b);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_QR", true)) {
                collection.addAll(i.f14376d);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Data_Matrix", true)) {
                collection.addAll(i.f14377e);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Aztec", false)) {
                collection.addAll(i.f14378f);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_PDF417", false)) {
                collection.addAll(i.f14379g);
            }
        }
        enumMap.put((EnumMap) EnumC0553d.POSSIBLE_FORMATS, (EnumC0553d) collection);
        if (str != null) {
            enumMap.put((EnumMap) EnumC0553d.CHARACTER_SET, (EnumC0553d) str);
        }
        enumMap.put((EnumMap) EnumC0553d.NEED_RESULT_POINT_CALLBACK, (EnumC0553d) a10);
        a.c("DecodeThread", "Hints: " + enumMap);
    }

    public void a(Rect rect) {
        this.f14422g = rect;
    }

    public void b() {
        this.f14416a = null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f14419d = new j(this.f14416a, this.f14417b, this.f14420e, this.f14418c, this.f14422g, this.f14423h);
        this.f14421f.countDown();
        Looper.loop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler a() {
        try {
            this.f14421f.await();
        } catch (InterruptedException unused) {
            a.b("exception", "InterruptedException");
        }
        return this.f14419d;
    }

    public void a(boolean z10) {
        this.f14423h = z10;
    }
}
