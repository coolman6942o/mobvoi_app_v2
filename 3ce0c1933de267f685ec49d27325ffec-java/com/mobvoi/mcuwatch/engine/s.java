package com.mobvoi.mcuwatch.engine;

import android.content.Intent;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import b1.a;
import com.alipay.sdk.app.PayTask;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.mcuwatch.bean.AlarmBean;
import com.mobvoi.mcuwatch.ui.card.e0;
import eg.k;
import gn.h;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import jj.b;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.jvm.internal.i;
import nj.j;
import nj.u;
/* compiled from: SyncWatchDataMsgManager.kt */
/* loaded from: classes2.dex */
public final class s implements s.a {

    /* renamed from: a  reason: collision with root package name */
    public static final s f19186a;

    /* renamed from: b  reason: collision with root package name */
    private static com.mobvoi.android.common.utils.s f19187b;

    /* renamed from: e  reason: collision with root package name */
    private static List<? extends AlarmBean> f19190e;

    /* renamed from: f  reason: collision with root package name */
    private static int f19191f;

    /* renamed from: h  reason: collision with root package name */
    private static int f19193h;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f19194i;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f19195j;

    /* renamed from: k  reason: collision with root package name */
    private static long f19196k;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f19197l;

    /* renamed from: c  reason: collision with root package name */
    private static Queue<Integer> f19188c = new LinkedBlockingQueue();

    /* renamed from: d  reason: collision with root package name */
    private static b f19189d = b.g();

    /* renamed from: g  reason: collision with root package name */
    private static int f19192g = -1;

    /* renamed from: m  reason: collision with root package name */
    private static final Calendar f19198m = Calendar.getInstance();

    /* renamed from: n  reason: collision with root package name */
    private static final Map<Integer, List<Integer>> f19199n = new LinkedHashMap();

    /* renamed from: o  reason: collision with root package name */
    private static final Runnable f19200o = q.f19184a;

    static {
        s sVar = new s();
        f19186a = sVar;
        HandlerThread handlerThread = new HandlerThread("syncWatchData");
        handlerThread.start();
        f19187b = new com.mobvoi.android.common.utils.s(sVar, handlerThread.getLooper());
        sVar.l();
    }

    private s() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        f19186a.j();
    }

    private final void j() {
        f19187b.removeMessages(0);
        Integer poll = f19188c.poll();
        if (poll == null) {
            if (f19194i) {
                f19194i = false;
            }
            if (f19195j) {
                f19195j = false;
            }
            Intent intent = new Intent("action.UPDATE_MCU_WATCH_DATA");
            intent.putExtra("extra.SYNC_MCU_WATCH_FINISH", true);
            a.b(com.mobvoi.android.common.utils.b.e()).d(intent);
        } else if (!ci.a.b().e()) {
            f19188c.clear();
        } else {
            f19193h = 0;
            int intValue = poll.intValue();
            f19192g = intValue;
            f19187b.sendEmptyMessage(intValue);
            f19187b.sendEmptyMessageDelayed(0, PayTask.f6879j);
        }
    }

    private final void k() {
        int i10 = f19193h;
        if (i10 == 0) {
            f19193h = i10 + 1;
            f19187b.sendEmptyMessage(f19192g);
            f19187b.sendEmptyMessageDelayed(0, PayTask.f6879j);
            return;
        }
        j();
    }

    private final void l() {
        List<Integer> b10;
        List<Integer> b11;
        List<Integer> j10;
        List<Integer> b12;
        List<Integer> b13;
        List<Integer> b14;
        List<Integer> j11;
        List<Integer> j12;
        List<Integer> b15;
        List<Integer> b16;
        List<Integer> j13;
        List<Integer> b17;
        List<Integer> b18;
        List<Integer> b19;
        List<Integer> b20;
        List<Integer> b21;
        List<Integer> b22;
        List<Integer> b23;
        List<Integer> b24;
        List<Integer> b25;
        List<Integer> b26;
        Map<Integer, List<Integer>> map = f19199n;
        b10 = l.b(7);
        map.put(1, b10);
        b11 = l.b(147);
        map.put(2, b11);
        j10 = m.j(175, 176);
        map.put(3, j10);
        b12 = l.b(125);
        map.put(4, b12);
        b13 = l.b(107);
        map.put(5, b13);
        b14 = l.b(134);
        map.put(7, b14);
        j11 = m.j(85, 84);
        map.put(8, j11);
        j12 = m.j(29, 30, 31);
        map.put(9, j12);
        map.put(10, j12);
        map.put(11, j12);
        b15 = l.b(8);
        map.put(12, b15);
        b16 = l.b(27);
        map.put(13, b16);
        j13 = m.j(25, 26);
        map.put(14, j13);
        b17 = l.b(10);
        map.put(15, b17);
        b18 = l.b(2);
        map.put(16, b18);
        b19 = l.b(5);
        map.put(17, b19);
        b20 = l.b(82);
        map.put(18, b20);
        b21 = l.b(110);
        map.put(19, b21);
        b22 = l.b(124);
        map.put(20, b22);
        b23 = l.b(77);
        map.put(21, b23);
        b24 = l.b(109);
        map.put(6, b24);
        b25 = l.b(68);
        map.put(22, b25);
        b26 = l.b(51);
        map.put(23, b26);
    }

    private final boolean m() {
        String d10 = q.d(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "last_sync_sleep_mills", "20200603");
        if (TextUtils.equals(d10, "20200603")) {
            return true;
        }
        long c10 = k.c(d10);
        Calendar calendar = f19198m;
        calendar.setTime(new Date(c10));
        return System.currentTimeMillis() - c10 > 600000 - ((long) (((calendar.get(12) % 10) * 60) * 1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n() {
        f19186a.r(false);
    }

    private final void o() {
        f19188c.offer(15);
        f19188c.offer(16);
        if (m()) {
            f19188c.offer(17);
            f19188c.offer(18);
            if (j.d(8)) {
                f19188c.offer(19);
            }
            if (j.d(64)) {
                f19188c.offer(20);
            }
            f19188c.offer(23);
        }
        if (CompanionSetting.isArtyAuthorize() && nj.q.g().p(3)) {
            f19188c.offer(22);
        }
    }

    private final void s() {
        if (!f19194i) {
            o();
            f19194i = true;
            if (!f19195j) {
                j();
            }
        }
    }

    private final void u() {
        f19188c.offer(21);
        f19195j = true;
        if (f19194i) {
            f19188c.offer(16);
        } else {
            j();
        }
    }

    public final boolean c() {
        return f19197l;
    }

    public final boolean d() {
        return f19194i;
    }

    public final void e(int i10) {
        f19187b.removeCallbacks(f19200o);
        f19197l = false;
        int i11 = i10 == 37 ? 5 : 1;
        if (n.f19178a.I()) {
            f.n(u.f19202a, i11);
        }
    }

    public final void f(int i10, int i11) {
        if (f19192g == 21) {
            if (i10 == 90) {
                f19191f = i11;
            } else {
                f19191f--;
            }
            if (f19191f <= 0) {
                f19187b.sendEmptyMessageDelayed(102, 100L);
            } else {
                p(103);
            }
        }
    }

    public final void g() {
        f19187b.removeMessages(0);
        f19187b.sendEmptyMessageDelayed(0, PayTask.f6879j);
    }

    public final void h(int i10) {
        List<Integer> list = f19199n.get(Integer.valueOf(f19192g));
        if (list != null && list.contains(Integer.valueOf(i10))) {
            if (i10 == 2) {
                f19187b.sendEmptyMessage(105);
                if (f19188c.peek() == null) {
                    f19187b.postDelayed(r.f19185a, 200L);
                    return;
                }
            } else if (i10 == 5) {
                f19187b.sendEmptyMessage(106);
            } else if (i10 == 7) {
                f19187b.sendEmptyMessage(112);
            } else if (i10 == 82) {
                f19187b.sendEmptyMessage(107);
            } else if (i10 == 110) {
                f19187b.sendEmptyMessage(108);
            } else if (i10 == 124) {
                f19187b.sendEmptyMessage(109);
            }
            j();
        }
    }

    @Override // com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message msg) {
        i.f(msg, "msg");
        com.mobvoi.android.common.utils.k.a("SyncWatchDataMsgManager", i.n(" handleMessage ", Integer.valueOf(msg.what)));
        int i10 = msg.what;
        switch (i10) {
            case 0:
                k();
                return;
            case 1:
                f.w(u.f19202a);
                return;
            case 2:
                f.J(u.f19202a);
                return;
            case 3:
                f.i(u.f19202a, n.f19178a.x());
                return;
            case 4:
                f.E(u.f19202a, n.f19178a.B(), 10);
                return;
            case 5:
                f.L(u.f19202a, n.f19178a.H(), 10);
                return;
            case 6:
                f.C(u.f19202a, true, 37.3f, 35.0f);
                return;
            case 7:
                f.B(u.f19202a, n.f19178a.w(), 10);
                return;
            case 8:
                n nVar = n.f19178a;
                long p10 = nVar.p();
                int c10 = u.c(p10, 11);
                int c11 = u.c(p10, 12);
                long g10 = nVar.g();
                f.k(u.f19202a, nVar.A(), c10, c11, u.c(g10, 11), u.c(g10, 12));
                return;
            case 9:
                b bVar = f19189d;
                List<? extends AlarmBean> list = f19190e;
                if (list != null) {
                    bVar.m(list.get(0));
                    return;
                } else {
                    i.u("mAlarmBeanList");
                    throw null;
                }
            case 10:
                b bVar2 = f19189d;
                List<? extends AlarmBean> list2 = f19190e;
                if (list2 != null) {
                    bVar2.m(list2.get(1));
                    return;
                } else {
                    i.u("mAlarmBeanList");
                    throw null;
                }
            case 11:
                b bVar3 = f19189d;
                List<? extends AlarmBean> list3 = f19190e;
                if (list3 != null) {
                    bVar3.m(list3.get(2));
                    return;
                } else {
                    i.u("mAlarmBeanList");
                    throw null;
                }
            case 12:
                f.t(u.f19202a, 0, 0, 0, 0, false, false, 0, false, 0, false, false, 0, !com.mobvoi.companion.base.settings.a.isTempCelsius(com.mobvoi.android.common.utils.b.e()) ? 1 : 0, false, 12287, null);
                return;
            case 13:
                int i11 = i.b("imperial", com.mobvoi.companion.base.settings.a.getUnit(com.mobvoi.android.common.utils.b.e())) ? 2 : 1;
                if (n.f19178a.u()) {
                    f.x(u.f19202a, i11, 1);
                    return;
                } else {
                    f.x(u.f19202a, i11, 2);
                    return;
                }
            case 14:
                n nVar2 = n.f19178a;
                long q5 = nVar2.q();
                int c12 = u.c(q5, 11);
                int c13 = u.c(q5, 12);
                long h10 = nVar2.h();
                f.r(u.f19202a, nVar2.D() ? 1 : 0, c12, c13, u.c(h10, 11), u.c(h10, 12), nVar2.E(), 0, 64, null);
                return;
            case 15:
                f.v(u.f19202a);
                return;
            case 16:
                f19196k = System.currentTimeMillis();
                f.I(u.f19202a);
                return;
            case 17:
                f.G(u.f19202a);
                return;
            case 18:
                f.F(u.f19202a);
                return;
            case 19:
                f.K(u.f19202a);
                return;
            case 20:
                f.D(u.f19202a);
                return;
            case 21:
                f.H(u.f19202a);
                return;
            case 22:
                v.f19226a.l();
                return;
            case 23:
                if (e0.g().j()) {
                    f19187b.removeMessages(0);
                    f19187b.sendEmptyMessageDelayed(0, 6000L);
                }
                e0.g().m();
                return;
            default:
                switch (i10) {
                    case 100:
                        t();
                        return;
                    case 101:
                        s();
                        return;
                    case 102:
                        v.f19226a.i();
                        if (f19194i || f19195j) {
                            h(77);
                            return;
                        }
                        break;
                    case 103:
                        if (f19194i || f19195j) {
                            g();
                            break;
                        }
                        break;
                    case 104:
                        v vVar = v.f19226a;
                        String c14 = h.c(0);
                        i.e(c14, "getCalendar(0)");
                        vVar.m(c14);
                        break;
                    case 105:
                        v.f19226a.j(f19196k);
                        break;
                    case 106:
                        v.f19226a.h();
                        break;
                    case 107:
                        v.f19226a.g();
                        break;
                    case 108:
                        v.f19226a.k();
                        break;
                    case 109:
                        v.f19226a.f();
                        break;
                    case 110:
                        f.u(u.f19202a, msg.obj.toString(), msg.arg1);
                        f19187b.postDelayed(f19200o, 7000L);
                        break;
                    case 111:
                        u();
                        break;
                    case 112:
                        j.e();
                        break;
                }
                return;
        }
    }

    public final void p(int i10) {
        f19187b.sendEmptyMessage(i10);
    }

    public final void q(String content, int i10) {
        i.f(content, "content");
        f19197l = true;
        Message obtainMessage = f19187b.obtainMessage();
        obtainMessage.what = 110;
        obtainMessage.arg1 = i10;
        obtainMessage.obj = content;
        obtainMessage.sendToTarget();
    }

    public final void r(boolean z10) {
        f19197l = z10;
    }

    public final void t() {
        f19189d.k();
        List<AlarmBean> f10 = f19189d.f();
        i.e(f10, "mAlarmDataManager.alarmDataList");
        f19190e = f10;
        f19188c.clear();
        f19188c.offer(1);
        if (j.d(256)) {
            f19188c.offer(2);
        }
        f19188c.offer(3);
        if (j.d(64)) {
            f19188c.offer(4);
        }
        if (j.d(8)) {
            f19188c.offer(5);
            f19188c.offer(6);
        }
        f19188c.offer(7);
        f19188c.offer(8);
        List<? extends AlarmBean> list = f19190e;
        if (list != null) {
            int size = list.size();
            if (size == 1) {
                f19188c.offer(9);
            } else if (size == 2) {
                f19188c.offer(9);
                f19188c.offer(10);
            } else if (size == 3) {
                f19188c.offer(9);
                f19188c.offer(10);
                f19188c.offer(11);
            }
            f19188c.offer(12);
            f19188c.offer(13);
            f19188c.offer(14);
            if (j.d(1)) {
                f19188c.offer(21);
            }
            o();
            f19194i = true;
            j();
            return;
        }
        i.u("mAlarmBeanList");
        throw null;
    }
}
