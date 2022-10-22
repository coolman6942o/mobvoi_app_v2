package com.mobvoi.mcuwatch.engine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.ml.camera.CameraConfig;
import com.mobvoi.companion.health.viewholder.FitnessCardViewHolder;
import com.unionpay.tsmservice.mi.data.Constant;
import ei.h;
import gn.q;
import io.j;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.collections.a0;
import kotlin.collections.d0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
import nj.k;
import nj.r;
/* compiled from: NotificationMessageManager.kt */
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences f19167b;

    /* renamed from: c  reason: collision with root package name */
    private static r f19168c;

    /* renamed from: d  reason: collision with root package name */
    private static Handler f19169d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile boolean f19170e;

    /* renamed from: f  reason: collision with root package name */
    private static Queue<g> f19171f;

    /* renamed from: h  reason: collision with root package name */
    private static final Map<Integer, Integer> f19173h;

    /* renamed from: j  reason: collision with root package name */
    private static int f19175j;

    /* renamed from: a  reason: collision with root package name */
    public static final l f19166a = new l();

    /* renamed from: g  reason: collision with root package name */
    private static final ExecutorService f19172g = Executors.newCachedThreadPool();

    /* renamed from: i  reason: collision with root package name */
    private static final BroadcastReceiver f19174i = new c();

    /* renamed from: k  reason: collision with root package name */
    private static final a f19176k = new a();

    /* compiled from: NotificationMessageManager.kt */
    /* loaded from: classes2.dex */
    public static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Handler handler = l.f19169d;
            if (handler != null) {
                handler.removeCallbacks(this);
                l.f19166a.t(false);
                return;
            }
            i.u("handler");
            throw null;
        }
    }

    /* compiled from: NotificationMessageManager.kt */
    /* loaded from: classes2.dex */
    public static final class b implements Callable<byte[]> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19177a;

        b(String str) {
            this.f19177a = str;
        }

        /* renamed from: a */
        public byte[] call() {
            InputStream g10 = k.g(this.f19177a);
            if (g10 == null) {
                return null;
            }
            byte[] c10 = oo.a.c(g10);
            g10.close();
            return c10;
        }
    }

    /* compiled from: NotificationMessageManager.kt */
    /* loaded from: classes2.dex */
    public static final class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            i.f(context, "context");
            i.f(intent, "intent");
            String action = intent.getAction();
            if (action != null) {
                int i10 = 2;
                boolean z10 = false;
                switch (action.hashCode()) {
                    case -2078681236:
                        if (action.equals("com.mobvoi.ticpod.service.ACTION_IN_COMING_CALL")) {
                            int intExtra = intent.getIntExtra("IN_COMING_CALL_TYPE", 1);
                            String stringExtra = intent.getStringExtra("TITLE");
                            if (intExtra == 1) {
                                l.f19166a.w(stringExtra);
                                return;
                            } else if (intExtra != 3) {
                                if (4 <= intExtra && intExtra <= 52) {
                                    z10 = true;
                                }
                                if (z10) {
                                    l.f19166a.k(intent, intExtra, stringExtra);
                                    return;
                                }
                                return;
                            } else if (n.f19178a.F()) {
                                l.f19166a.x(intent, intExtra, stringExtra);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    case -124655702:
                        if (action.equals("com.mobvoi.ticpod.service.ACTION_UPDATE_USER_SETTING_GOAL")) {
                            int intExtra2 = intent.getIntExtra("step_goal", 10001);
                            if (intExtra2 != 10001) {
                                n.f19178a.i0(intExtra2);
                            }
                            int intExtra3 = intent.getIntExtra("tmp_unit", 3);
                            int intExtra4 = intent.getIntExtra("distance_unit", 3);
                            if (intExtra3 != 3) {
                                u uVar = u.f19202a;
                                n nVar = n.f19178a;
                                f.s(uVar, nVar.j(), nVar.t(), 5, nVar.r(), nVar.C(), true, 150, nVar.i(), nVar.b(), false, true, 50, intExtra3, true);
                                com.mobvoi.android.common.utils.k.c("NotificationMsgManager", "修改个人信息了 height:%d  weight:%d age:%d gender:%b stepsGoal:%d tempUnit:%d", Integer.valueOf(nVar.j()), Integer.valueOf(nVar.t()), Integer.valueOf(nVar.b()), Boolean.valueOf(nVar.i()), Integer.valueOf(nVar.r()), Integer.valueOf(intExtra3));
                                return;
                            } else if (intExtra4 != 3) {
                                int a10 = n.f19178a.a();
                                f.x(u.f19202a, intExtra4, a10);
                                com.mobvoi.android.common.utils.k.c("NotificationMsgManager", "修改个人信息了 disUnit:%d  SettingSP.get24UnitType():%d", Integer.valueOf(intExtra4), Integer.valueOf(a10));
                                return;
                            } else {
                                int intExtra5 = intent.getIntExtra("gender", 1);
                                int intExtra6 = intent.getIntExtra(Constant.KEY_HEIGHT, CameraConfig.CAMERA_THIRD_DEGREE);
                                int intExtra7 = intent.getIntExtra("weight", 70);
                                int intExtra8 = intent.getIntExtra("age", 20);
                                boolean z11 = intExtra5 != 0;
                                int i11 = !com.mobvoi.companion.base.settings.a.isTempCelsius(context) ? 1 : 0;
                                n nVar2 = n.f19178a;
                                com.mobvoi.android.common.utils.k.c("NotificationMsgManager", "修改个人信息了 gender:%d height:%d  weight:%d age:%d tempUnit:%d stepsGoal:%d", Integer.valueOf(intExtra5), Integer.valueOf(intExtra6), Integer.valueOf(intExtra7), Integer.valueOf(intExtra8), Integer.valueOf(i11), Integer.valueOf(nVar2.r()));
                                f.s(u.f19202a, intExtra6, intExtra7, 5, intExtra2, nVar2.C(), true, 150, z11, intExtra8, false, true, 50, i11, true);
                                return;
                            }
                        } else {
                            return;
                        }
                    case -124239333:
                        if (action.equals("com.mobvoi.ticpod.service.ACTION_UPDATE_USER_SETTING_UNIT")) {
                            int intExtra9 = intent.getIntExtra("distance_unit", 1);
                            int a11 = n.f19178a.a();
                            if (intExtra9 == 1) {
                                i10 = 1;
                            }
                            f.x(u.f19202a, i10, a11);
                            return;
                        }
                        return;
                    case 613467881:
                        if (action.equals(FitnessCardViewHolder.ACTION_SYNC_MCU_WATCH_SPORT) && ci.a.b().e()) {
                            h.a().r();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    static {
        Map<Integer, Integer> h10;
        h10 = d0.h(j.a(5, 1), j.a(6, 2), j.a(7, 2), j.a(8, 4), j.a(9, 4), j.a(10, 4), j.a(11, 4), j.a(12, 4), j.a(13, 4), j.a(14, 4), j.a(15, 4), j.a(16, 4), j.a(17, 4), j.a(18, 4), j.a(19, 4), j.a(20, 4), j.a(21, 4), j.a(22, 4), j.a(23, 4), j.a(24, 4), j.a(4, 4), j.a(25, 7), j.a(26, 5), j.a(27, 9), j.a(33, 6), j.a(28, 13), j.a(29, 4), j.a(30, 14), j.a(31, 11), j.a(32, 19), j.a(34, 10), j.a(35, 23), j.a(36, 17), j.a(37, 4), j.a(38, 4), j.a(39, 8), j.a(40, 22), j.a(41, 21), j.a(42, 12), j.a(43, 4), j.a(44, 4), j.a(45, 4), j.a(46, 4), j.a(47, 4), j.a(48, 4), j.a(49, 4), j.a(50, 4), j.a(51, 4), j.a(52, 4));
        f19173h = h10;
    }

    private l() {
    }

    private final void A() {
        f19172g.execute(i.f19163a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B() {
        while (true) {
            try {
                Queue<g> queue = f19171f;
                if (queue != null) {
                    if (!(!queue.isEmpty())) {
                        break;
                    }
                    s sVar = s.f19186a;
                    if (sVar.c()) {
                        Thread.sleep(1000L);
                    } else {
                        if (!sVar.d() && !k.f31276a) {
                            Queue<g> queue2 = f19171f;
                            if (queue2 != null) {
                                g poll = queue2.poll();
                                if (poll == null) {
                                    break;
                                }
                                sVar.q(poll.c(), poll.b());
                                if (poll.a() != 3) {
                                    continue;
                                } else {
                                    SharedPreferences sharedPreferences = f19167b;
                                    if (sharedPreferences != null) {
                                        sharedPreferences.edit().putString("sms_received_number", poll.d()).apply();
                                    } else {
                                        i.u("settingSp");
                                        throw null;
                                    }
                                }
                            } else {
                                i.u("messageQueue");
                                throw null;
                            }
                        }
                        Thread.sleep(10000L);
                    }
                } else {
                    i.u("messageQueue");
                    throw null;
                }
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }
        f19170e = false;
    }

    private final void j(Context context, byte[] bArr) {
        int a10;
        if (bArr != null) {
            if (!(bArr.length == 0)) {
                n nVar = n.f30086a;
                String format = String.format("%x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[0])}, 1));
                i.e(format, "java.lang.String.format(format, *args)");
                a10 = kotlin.text.b.a(16);
                byte parseInt = (byte) Integer.parseInt(format, a10);
                if (parseInt == -91) {
                    if (bArr.length > 4) {
                        r(bArr);
                    }
                } else if (parseInt == -89) {
                    if (bArr.length > 1) {
                        q(bArr);
                    }
                } else if (bArr.length % 15 == 0) {
                    v.f19226a.e(context, bArr, 15);
                } else if (bArr.length % 13 == 0) {
                    v.f19226a.e(context, bArr, 13);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Intent intent, int i10, String str) {
        String stringExtra = intent.getStringExtra("CONTENT");
        if (!(i10 == 5 || i10 == 25 || i10 == 27 || i10 == 29 || i10 == 38)) {
            switch (i10) {
            }
            String e10 = k.e(k.d(stringExtra));
            Map<Integer, Integer> map = f19173h;
            y(new g("", e10, ((Number) a0.f(map, Integer.valueOf(i10))).intValue(), 2));
            com.mobvoi.android.common.utils.k.c("NotificationMsgManager", "来应用消息了 :%d title:%s content:%s appType:%d", Integer.valueOf(i10), str, e10, a0.f(map, Integer.valueOf(i10)));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) str);
        sb2.append(':');
        sb2.append((Object) stringExtra);
        stringExtra = sb2.toString();
        String e102 = k.e(k.d(stringExtra));
        Map<Integer, Integer> map2 = f19173h;
        y(new g("", e102, ((Number) a0.f(map2, Integer.valueOf(i10))).intValue(), 2));
        com.mobvoi.android.common.utils.k.c("NotificationMsgManager", "来应用消息了 :%d title:%s content:%s appType:%d", Integer.valueOf(i10), str, e102, a0.f(map2, Integer.valueOf(i10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(g gVar, g gVar2) {
        if (gVar == null || gVar2 == null) {
            return 0;
        }
        gVar.a();
        gVar2.a();
        return 0;
    }

    private final void p() {
        r rVar = f19168c;
        if (rVar != null) {
            rVar.e();
        }
    }

    private final void r(byte[] bArr) {
        Handler handler = f19169d;
        if (handler != null) {
            handler.removeCallbacks(f19176k);
            if (bArr[3] == 0) {
                r rVar = f19168c;
                if (rVar != null) {
                    rVar.b();
                }
                t(true);
                return;
            }
            return;
        }
        i.u("handler");
        throw null;
    }

    private final void s(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.mobvoi.ticpod.service.ACTION_UPDATE_USER_SETTING_GOAL");
        intentFilter.addAction("com.mobvoi.ticpod.service.ACTION_UPDATE_USER_SETTING_UNIT");
        intentFilter.addAction("com.mobvoi.ticpod.service.ACTION_IN_COMING_CALL");
        intentFilter.addAction(FitnessCardViewHolder.ACTION_SYNC_MCU_WATCH_SPORT);
        context.getApplicationContext().registerReceiver(f19174i, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(boolean z10) {
        if (!k.f31276a && f19168c != null) {
            if (f19175j < 5) {
                Handler handler = f19169d;
                if (handler != null) {
                    handler.postDelayed(f19176k, 50000L);
                } else {
                    i.u("handler");
                    throw null;
                }
            }
            if (z10) {
                f19175j = 0;
                Handler handler2 = f19169d;
                if (handler2 != null) {
                    handler2.removeCallbacks(f19176k);
                    p();
                    return;
                }
                i.u("handler");
                throw null;
            }
            f19175j++;
            r rVar = f19168c;
            if (rVar != null) {
                rVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(byte[] byteArray) {
        if (byteArray != null) {
            i.e(byteArray, "byteArray");
            f19168c = new r(byteArray);
            if (ci.a.b().e()) {
                Byte b10 = null;
                for (byte b11 : byteArray) {
                    if (b10 == null) {
                        b10 = Byte.valueOf(b11);
                    } else {
                        b10 = Byte.valueOf((byte) (b10.byteValue() ^ b11));
                    }
                }
                f.h(u.f19202a, byteArray.length, b10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(String str) {
        if (n.f19178a.y() && !TextUtils.isEmpty(str) && str != null) {
            l lVar = f19166a;
            String e10 = k.e(k.d(str));
            i.e(e10, "filterEmoji(\n                            McuStringUtil.filterBrackets(title)\n                        )");
            lVar.y(new g("", e10, 0, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(Intent intent, int i10, String str) {
        String e10 = k.e(k.d(intent.getStringExtra("CONTENT")));
        String filterTitle = k.e(k.d(str));
        i.e(filterTitle, "filterTitle");
        y(new g(filterTitle, e10, 3, 3));
        com.mobvoi.android.common.utils.k.c("NotificationMsgManager", " comingType:%d title:%s content:%s appType:%d", Integer.valueOf(i10), filterTitle, e10, 3);
    }

    private final void y(final g gVar) {
        f19172g.execute(new Runnable() { // from class: com.mobvoi.mcuwatch.engine.h
            @Override // java.lang.Runnable
            public final void run() {
                l.z(g.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(g message) {
        i.f(message, "$message");
        Queue<g> queue = f19171f;
        if (queue != null) {
            queue.offer(message);
            if (!f19170e) {
                l lVar = f19166a;
                f19170e = true;
                lVar.A();
                return;
            }
            return;
        }
        i.u("messageQueue");
        throw null;
    }

    public final void l(Context context, byte[] bArr) {
        i.f(context, "context");
        j(context, bArr);
    }

    public final void m(boolean z10) {
        Handler handler = f19169d;
        if (handler != null) {
            handler.removeCallbacks(f19176k);
            t(z10);
            return;
        }
        i.u("handler");
        throw null;
    }

    public final void n(Context ctx) {
        Queue<g> queue;
        i.f(ctx, "ctx");
        SharedPreferences sharedPreferences = ctx.getApplicationContext().getSharedPreferences(q.f27582a, 0);
        i.e(sharedPreferences, "ctx.applicationContext.getSharedPreferences(GlobalVariable.SettingSP, 0)");
        f19167b = sharedPreferences;
        f19169d = new Handler(Looper.getMainLooper());
        s(ctx);
        if (Build.VERSION.SDK_INT >= 24) {
            queue = new PriorityBlockingQueue<>(100, j.f19164a);
        } else {
            queue = new LinkedBlockingQueue<>();
        }
        f19171f = queue;
    }

    public final void q(byte[] data) {
        i.f(data, "data");
        Handler handler = f19169d;
        if (handler != null) {
            handler.removeCallbacks(f19176k);
            byte b10 = data[1];
            r rVar = f19168c;
            if (rVar != null) {
                rVar.b();
            }
            if (b10 != 0) {
                t(true);
                return;
            }
            f19168c = null;
            com.mobvoi.android.common.utils.k.a("NotificationMsgManager", "parseNotificationEnd success");
            return;
        }
        i.u("handler");
        throw null;
    }

    public final void u(String url) {
        i.f(url, "url");
        if (!k.f31276a) {
            rx.c.x(new b(url)).Z(cq.a.c()).H(xp.a.b()).X(k.f19165a);
        }
    }
}
