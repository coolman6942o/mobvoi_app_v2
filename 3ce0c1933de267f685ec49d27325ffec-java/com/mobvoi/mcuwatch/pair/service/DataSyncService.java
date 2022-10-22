package com.mobvoi.mcuwatch.pair.service;

import aa.b;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import ci.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.mcuwatch.engine.u;
import com.mobvoi.mcuwatch.pair.service.DataSyncService;
import com.mobvoi.mcuwatch.utils.BleConnectFailException;
import com.tendcloud.tenddata.ab;
import hi.d;
import java.util.concurrent.atomic.AtomicInteger;
import nj.t;
import rx.c;
import rx.i;
import rx.j;
import sh.f;
import yp.g;
/* loaded from: classes2.dex */
public class DataSyncService extends Service implements b.AbstractC0085b, di.a, di.b, s.a {

    /* renamed from: a  reason: collision with root package name */
    private u f19241a;

    /* renamed from: e  reason: collision with root package name */
    private j f19245e;

    /* renamed from: b  reason: collision with root package name */
    private dq.b f19242b = new dq.b();

    /* renamed from: c  reason: collision with root package name */
    private final s f19243c = new s(this);

    /* renamed from: d  reason: collision with root package name */
    private String f19244d = "";

    /* renamed from: f  reason: collision with root package name */
    private AtomicInteger f19246f = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    private Object f19247g = new Object();

    /* renamed from: h  reason: collision with root package name */
    private boolean f19248h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends i<Boolean> {
        a(DataSyncService dataSyncService) {
        }

        /* renamed from: b */
        public void onNext(Boolean bool) {
            if (bool.booleanValue()) {
                k.d("DataSyncService", "发起重连请求成功");
            } else {
                k.d("DataSyncService", "需要重新发起重连请求");
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.d("DataSyncService", "重连失败");
        }
    }

    private void A(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            Notification b10 = new b.a(this, "bluetooth").u(f.f34582r1).j(str).l(-1).b();
            if (((NotificationManager) getSystemService("notification")) != null) {
                startForeground(1001, b10);
                this.f19248h = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ c g(String str, Boolean bool) {
        ci.a.b().g(new fi.a(2, str));
        k.f("DataSyncService", "startConnect（）中第%d次重连开始", Integer.valueOf(this.f19246f.get()));
        k.d("DataSyncService", "aBoolean:" + bool);
        if (bool.booleanValue()) {
            this.f19243c.removeMessages(1000);
            this.f19243c.sendEmptyMessageDelayed(1000, ab.Y);
            return c.A(bool);
        }
        this.f19246f.getAndAdd(1);
        throw new BleConnectFailException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean h(Object obj) {
        return Boolean.valueOf(obj instanceof fi.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ fi.a i(Object obj) {
        return (fi.a) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(fi.a aVar) {
        A(nj.k.f(this, aVar));
    }

    public static void l(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("mac_address", str);
        intent.putExtra("watch_lite_command", 0);
        intent.setClass(context, DataSyncService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    private void m(final String str) {
        if (ci.a.b().f(str)) {
            ci.a.b().g(new fi.a(1, str));
            A(getString(sh.k.T));
            return;
        }
        this.f19244d = str;
        this.f19242b.b();
        x();
        if (this.f19246f.get() >= t.f31293c.length) {
            this.f19246f.set(0);
        }
        j V = this.f19241a.A(str).v(new g() { // from class: hi.b
            @Override // yp.g
            public final Object call(Object obj) {
                c g10;
                g10 = DataSyncService.this.g(str, (Boolean) obj);
                return g10;
            }
        }).S(new t(this.f19246f.get())).Z(cq.a.c()).H(xp.a.b()).V(new a(this));
        this.f19245e = V;
        this.f19242b.a(V);
        this.f19243c.removeMessages(1000);
        this.f19243c.sendEmptyMessageDelayed(1000, ab.Y);
        A(getString(sh.k.f34837m4));
        ci.a.b().g(new fi.a(2, str));
    }

    public static void n(Context context) {
        q(context, 4);
    }

    private void o() {
        this.f19241a.m0();
        A(getString(sh.k.f34899y4));
    }

    public static void p(Context context) {
        q(context, 2);
    }

    private static void q(Context context, int i10) {
        Intent intent = new Intent();
        intent.putExtra("watch_lite_command", i10);
        intent.setClass(context, DataSyncService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    private void r() {
        if (!this.f19248h) {
            A("");
        }
        this.f19242b.b();
        this.f19241a.B();
        this.f19241a.b0();
        z();
        stopSelf();
    }

    public static void s(Context context) {
        q(context, 1);
    }

    private void t() {
        if (!this.f19248h) {
            A("");
        }
        z();
    }

    public static void u(Context context) {
        q(context, 5);
    }

    private void v() {
        if (!this.f19248h) {
            A("");
        }
        this.f19241a.p0();
        this.f19241a.c0();
        z();
        stopSelf();
    }

    public static void w(Context context) {
        q(context, 3);
    }

    private void x() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f19242b.a(ci.a.b().c().u(hi.c.f27865a).D(d.f27866a).X(new yp.b() { // from class: hi.a
                @Override // yp.b
                public final void call(Object obj) {
                    DataSyncService.this.j((fi.a) obj);
                }
            }));
        }
    }

    private void z() {
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
            this.f19248h = false;
        }
    }

    @Override // di.b
    public void a(pk.f fVar) {
        k.c("DataSyncService", "onDeviceScan %s", fVar.toString());
        ci.a.b().g(fVar);
    }

    @Override // di.a
    public void b(fi.a aVar, String str) {
        this.f19243c.removeMessages(1000);
        if (aVar.c() == 0) {
            k(str);
            return;
        }
        if (1 == aVar.c()) {
            this.f19246f.set(0);
            k.a("DataSyncService", "蓝牙连接成功");
            this.f19243c.removeCallbacksAndMessages(null);
            s sVar = this.f19243c;
            sVar.sendMessageDelayed(sVar.obtainMessage(1002, aVar.b()), 2000L);
        }
        ci.a.b().g(new fi.a(aVar.c(), aVar.b()));
    }

    @Override // com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message message) {
        fi.a aVar;
        switch (message.what) {
            case 1000:
                if (!ci.a.b().e()) {
                    k.a("DataSyncService", "一次连接请求超时了");
                    this.f19242b.b();
                    this.f19241a.B();
                    if (this.f19241a == null || (aVar = u.f19214m) == null || TextUtils.isEmpty(aVar.b())) {
                        ci.a.b().g(new fi.a(0, ""));
                        return;
                    } else {
                        k(u.f19214m.b());
                        return;
                    }
                } else {
                    return;
                }
            case 1001:
                k.f("DataSyncService", "onConnectStateChange中第%d次重连开始", Integer.valueOf(this.f19246f.get()));
                m((String) message.obj);
                return;
            case 1002:
                ci.a.b().g(new fi.a(1, (String) message.obj));
                return;
            default:
                return;
        }
    }

    public void k(String str) {
        synchronized (this.f19247g) {
            this.f19246f.getAndAdd(1);
            int i10 = this.f19246f.get();
            int[] iArr = t.f31293c;
            if (i10 >= iArr.length) {
                this.f19246f.set(0);
            }
            ci.a.b().g(new fi.a(0, str));
            k.c("DataSyncService", "蓝牙连接失败回调，将等待%d分钟开始回连", Integer.valueOf(iArr[this.f19246f.get()]));
            this.f19243c.removeCallbacksAndMessages(null);
            s sVar = this.f19243c;
            sVar.sendMessageDelayed(sVar.obtainMessage(1001, str), iArr[this.f19246f.get()] * 1000 * 60);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        u uVar = u.f19202a;
        this.f19241a = uVar;
        uVar.e0(this);
        this.f19241a.h0(this);
        ci.b.e().b(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f19243c.removeCallbacksAndMessages(null);
        this.f19242b.b();
        ci.b.e().g(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        k.f("DataSyncService", "onStartCommand startId:%s, mCount:%s", Integer.valueOf(i11), Integer.valueOf(this.f19246f.get()));
        if (intent == null) {
            return super.onStartCommand(null, i10, i11);
        }
        int intExtra = intent.getIntExtra("watch_lite_command", -1);
        k.c("DataSyncService", "onStartCommand %d", Integer.valueOf(intExtra));
        if (intExtra == 0) {
            String stringExtra = intent.getStringExtra("mac_address");
            if (!TextUtils.isEmpty(stringExtra)) {
                m(stringExtra);
            }
        } else if (intExtra == 1) {
            r();
        } else if (intExtra == 2) {
            o();
        } else if (intExtra == 3) {
            v();
        } else if (intExtra == 4) {
            A(getString(sh.k.I4));
        } else if (intExtra == 5) {
            t();
        }
        return super.onStartCommand(intent, i10, i11);
    }

    @Override // ci.b.AbstractC0085b
    public void y(boolean z10) {
        if (mi.a.a() == null) {
            ci.a.b().g(new fi.a(0, this.f19244d));
        } else if (!z10) {
            ci.a.b().g(new fi.a(0, this.f19244d));
            k.a("DataSyncService", "onStatusChange,enable:" + z10);
            r();
        }
    }
}
