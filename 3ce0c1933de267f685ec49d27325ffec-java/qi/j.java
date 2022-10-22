package qi;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.apollo.client.r;
import com.mobvoi.companion.WearableModule;
import com.mobvoi.companion.health.a4;
import com.mobvoi.companion.health.k1;
import com.mobvoi.companion.health.z3;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.health.companion.system.WearDevices;
import com.mobvoi.mcuwatch.settings.persistence.DeviceDataSourceImpl;
import com.mobvoi.mcuwatch.ui.card.e0;
import com.mobvoi.wear.common.base.TicwatchModels;
import ei.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import nj.q;
import pc.g;
import qk.a;
import qk.c;
import qk.d;
import yp.b;
/* compiled from: TicWatchLiteBaseDeviceManager.java */
/* loaded from: classes2.dex */
public abstract class j implements a {

    /* renamed from: f  reason: collision with root package name */
    public static String f33166f = "action.LOGIN";

    /* renamed from: g  reason: collision with root package name */
    public static String f33167g = "action.LOGOUT";

    /* renamed from: a  reason: collision with root package name */
    protected final List<c> f33168a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<d> f33169b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    protected volatile boolean f33170c = false;

    /* renamed from: d  reason: collision with root package name */
    protected final Context f33171d;

    /* renamed from: e  reason: collision with root package name */
    private gi.a f33172e;

    public j(final Application application) {
        this.f33171d = application;
        ni.a deviceDataSourceImpl = DeviceDataSourceImpl.getInstance();
        deviceDataSourceImpl.queryDevices().p(new b() { // from class: qi.e
            @Override // yp.b
            public final void call(Object obj) {
                j.this.y((List) obj);
            }
        }).u(i.f33165a).H(xp.a.b()).X(new b() { // from class: qi.g
            @Override // yp.b
            public final void call(Object obj) {
                j.this.A(application, (List) obj);
            }
        });
        deviceDataSourceImpl.dataChange().H(xp.a.b()).X(new b() { // from class: qi.f
            @Override // yp.b
            public final void call(Object obj) {
                j.this.B(application, (pi.a) obj);
            }
        });
        deviceDataSourceImpl.deviceDel().X(new b() { // from class: qi.d
            @Override // yp.b
            public final void call(Object obj) {
                j.this.C((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(Application application, List list) {
        if (e()) {
            s(application);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(Application application, pi.a aVar) {
        boolean z10;
        k.a("WatchLiteDeviceManager", "dataChange " + aVar.macAddress);
        Iterator<c> it = this.f33168a.iterator();
        while (true) {
            if (it.hasNext()) {
                if (TextUtils.equals(aVar.macAddress, ((g) it.next()).f32755d)) {
                    z10 = true;
                    break;
                }
            } else {
                z10 = false;
                break;
            }
        }
        if (z10) {
            return;
        }
        if (!"TicWatch GTW".equals(q.i(aVar.name)) || !r.f15521b.a().isEmpty()) {
            g q5 = q(aVar);
            this.f33168a.add(q5);
            if (e()) {
                if (this.f33170c) {
                    u(application);
                } else {
                    s(application);
                }
                q.g().A(true);
                r(application, q5.f32752a);
            }
            D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(String str) {
        k.a("WatchLiteDeviceManager", "deviceDel changed " + str);
        for (c cVar : this.f33168a) {
            g gVar = (g) cVar;
            if (TextUtils.equals(str, gVar.f32755d)) {
                this.f33168a.remove(cVar);
                String str2 = gVar.f32754c;
                if (str2.contains("TicWatch GTH Pro")) {
                    CompanionSetting.setArtyEnable(false);
                    b1.a.b(this.f33171d).d(new Intent("action.UPDATE_MCU_WATCH_DATA"));
                } else if (str2.contains("TicWatch GTA")) {
                    aj.a.f215a.a();
                }
                k.a("WatchLiteDeviceManager", "device deleted size=" + this.f33168a.size());
                return;
            }
        }
    }

    private void D() {
        k.a("WatchLiteDeviceManager", "notifyDataSetChanged" + this.f33169b.size());
        for (d dVar : this.f33169b) {
            dVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(z3 z3Var) {
        List<String> asList = Arrays.asList(this.f33171d.getResources().getStringArray(sh.b.v_res_0x7f030048));
        if (!this.f33168a.isEmpty()) {
            for (c cVar : this.f33168a) {
                z3Var.b(WearDevices.DeviceType.TicLite, cVar.getId(), cVar.getModel(), asList);
            }
        }
    }

    private g q(pi.a aVar) {
        g gVar = new g();
        String str = aVar.name;
        gVar.f32753b = str;
        gVar.f32754c = str;
        if ("TicWatch GTW".equals(q.i(str))) {
            gVar.f32752a = r.f15521b.a();
            gVar.f32753b = TicwatchModels.TICWATCH_GTW_eSIM;
        } else {
            gVar.f32752a = aVar.macAddress;
        }
        gVar.f32755d = aVar.macAddress;
        return gVar;
    }

    private void t() {
        ci.b.e().f();
        this.f33172e = new gi.a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        com.mobvoi.android.common.utils.b.e().registerReceiver(this.f33172e, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.mobvoi.action.notification.bin");
        intentFilter2.addAction(f33166f);
        intentFilter2.addAction(f33167g);
        b1.a.b(com.mobvoi.android.common.utils.b.e()).c(this.f33172e, intentFilter2);
    }

    private void u(Application application) {
        WearableModule.init(application, WearableModule.WearableType.TicLite);
        k1.a(new a4() { // from class: qi.a
            @Override // com.mobvoi.companion.health.a4
            public final void a(z3 z3Var) {
                j.this.p(z3Var);
            }
        });
        if (q.g().p(3)) {
            q.g().n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String v(String str) throws Exception {
        return ig.b.J().l(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean w(String str) {
        return Boolean.valueOf(!TextUtils.isEmpty(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(Context context, String str) {
        b1.a.b(context).d(new Intent("action.UPDATE_MCU_WATCH_DATA"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(List list) {
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                pi.a aVar = (pi.a) it.next();
                k.i("WatchLiteDeviceManager", "queryDevices %s", aVar.macAddress);
                this.f33168a.add(q(aVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean z(List list) {
        return Boolean.valueOf(!list.isEmpty());
    }

    @Override // qk.a
    public Bundle a() {
        if (!e()) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("mac_address", ((g) this.f33168a.get(0)).f32755d);
        return bundle;
    }

    @Override // qk.a
    public rk.a b() {
        return null;
    }

    @Override // qk.a
    public List<c> d() {
        return this.f33168a;
    }

    public void r(final Context context, final String str) {
        rx.c.x(new Callable() { // from class: qi.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String v10;
                v10 = j.v(str);
                return v10;
            }
        }).u(h.f33164a).Z(cq.a.d()).H(xp.a.b()).X(new b() { // from class: qi.c
            @Override // yp.b
            public final void call(Object obj) {
                j.x(context, (String) obj);
            }
        });
    }

    @SuppressLint({"MissingPermission"})
    public void s(Application application) {
        t();
        u(application);
        this.f33170c = true;
        h.a().p(application);
        ic.b.a((ic.c) kc.b.b().a(ic.c.class));
        nj.j.e();
        e0.g().m();
    }
}
