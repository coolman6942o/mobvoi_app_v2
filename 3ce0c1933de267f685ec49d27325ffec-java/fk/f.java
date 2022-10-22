package fk;

import ak.h;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import bd.a;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.ticcare.common.model.bean.TicCareDeviceInfo;
import com.mobvoi.ticcare.common.model.bean.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qk.c;
import qk.d;
import zn.g;
/* compiled from: TicCareDeviceManager.java */
/* loaded from: classes2.dex */
public class f implements qk.a {

    /* renamed from: h  reason: collision with root package name */
    private static volatile f f27071h;

    /* renamed from: a  reason: collision with root package name */
    private final Context f27072a;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27076e;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<TicCareDeviceInfo> f27073b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final List<c> f27074c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final List<d> f27075d = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final BroadcastReceiver f27078g = new a();

    /* renamed from: f  reason: collision with root package name */
    private final xn.a f27077f = new xn.a();

    /* compiled from: TicCareDeviceManager.java */
    /* loaded from: classes2.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            k.h("TicCareDeviceManager", " BroadcastReceiver  action = " + action);
            action.hashCode();
            char c10 = 65535;
            switch (action.hashCode()) {
                case -441406848:
                    if (action.equals("action.bind_ticcare_device")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -149952446:
                    if (action.equals("action.LOGOUT")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 410804625:
                    if (action.equals("action.LOGIN")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 723585351:
                    if (action.equals("action.unbind_ticcare_device")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 1555093873:
                    if (action.equals("action.app_foregound")) {
                        c10 = 4;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                case 3:
                case 4:
                    f.this.p();
                    return;
                case 1:
                    f.this.f27076e = false;
                    f.this.f27073b.clear();
                    f.this.f27074c.clear();
                    return;
                case 2:
                    if (!f.this.f27076e) {
                        f.this.p();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TicCareDeviceManager.java */
    /* loaded from: classes2.dex */
    public class b implements a.b {
        b(f fVar) {
        }

        @Override // bd.a.b
        public void a(Activity activity) {
            k.a("TicCareDeviceManager", "onEnterForeground");
            h.a().b(true);
        }

        @Override // bd.a.b
        public void b() {
            k.a("TicCareDeviceManager", "onEnterBackground");
        }
    }

    private f(Context context) {
        this.f27072a = context.getApplicationContext();
        s(com.mobvoi.android.common.utils.b.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        k.h("TicCareDeviceManager", " getDeviceFromServer ");
        String s10 = ta.a.s();
        if (!TextUtils.isEmpty(s10)) {
            this.f27076e = false;
            this.f27077f.b(gk.a.k().g(s10).map(e.f27070a).retryWhen(new lk.c(5, 5000)).subscribe(new g() { // from class: fk.d
                @Override // zn.g
                public final void accept(Object obj) {
                    f.this.v((List) obj);
                }
            }, new g() { // from class: fk.c
                @Override // zn.g
                public final void accept(Object obj) {
                    f.this.w((Throwable) obj);
                }
            }));
        }
    }

    public static f q(Context context) {
        if (f27071h == null) {
            synchronized (f.class) {
                if (f27071h == null) {
                    f27071h = new f(context);
                }
            }
        }
        return f27071h;
    }

    private void t(Application application) {
        bd.a.i(application);
        bd.a.g().e(new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List u(com.mobvoi.ticcare.common.model.bean.b bVar) throws Exception {
        ArrayList arrayList = new ArrayList();
        k.h("TicCareDeviceManager", " response.data = " + bVar.data);
        List<b.a> list = bVar.data;
        if (list != null) {
            for (b.a aVar : list) {
                arrayList.add(TicCareDeviceInfo.b(aVar));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(List list) throws Exception {
        k.h("TicCareDeviceManager", " devices = " + list);
        if (list != null) {
            this.f27074c.clear();
            this.f27073b.clear();
            this.f27073b.addAll(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f27074c.add(new fk.b((TicCareDeviceInfo) it.next()));
            }
            x();
            this.f27076e = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(Throwable th2) throws Exception {
        k.d("TicCareDeviceManager", " queryMyCareWatchResult err from serv throwable = " + th2);
        this.f27076e = false;
    }

    private void x() {
        for (d dVar : this.f27075d) {
            dVar.d();
        }
    }

    @Override // qk.a
    public Bundle a() {
        if (this.f27073b.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("extra.device_list", this.f27073b);
        return bundle;
    }

    @Override // qk.a
    public rk.a b() {
        return null;
    }

    @Override // qk.a
    public Class<?> c() {
        if (!this.f27074c.isEmpty()) {
            return kk.a.class;
        }
        return null;
    }

    @Override // qk.a
    public List<c> d() {
        return this.f27074c;
    }

    @Override // qk.a
    public boolean e() {
        k.a("TicCareDeviceManager", " isAdded " + this.f27076e);
        return true;
    }

    @Override // qk.a
    public void f(int i10) {
    }

    @Override // qk.a
    public String getDeviceType() {
        return "tic_care";
    }

    public void o(d dVar) {
        if (!this.f27075d.contains(dVar)) {
            this.f27075d.add(dVar);
        }
    }

    public List<TicCareDeviceInfo> r() {
        return this.f27073b;
    }

    public void s(Application application) {
        k.a("TicCareDeviceManager", "init");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.app_foregound");
        intentFilter.addAction("action.bind_ticcare_device");
        intentFilter.addAction("action.unbind_ticcare_device");
        intentFilter.addAction("action.LOGIN");
        intentFilter.addAction("action.LOGOUT");
        b1.a.b(this.f27072a).c(this.f27078g, intentFilter);
        t(application);
        p();
    }
}
