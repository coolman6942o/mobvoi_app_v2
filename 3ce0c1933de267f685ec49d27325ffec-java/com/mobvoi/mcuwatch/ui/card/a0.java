package com.mobvoi.mcuwatch.ui.card;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.x;
import com.mobvoi.apollo.client.c0;
import com.mobvoi.apollo.client.q;
import com.mobvoi.companion.BrowserActivity;
import com.mobvoi.companion.R;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.companion.ui.e;
import com.mobvoi.mcuwatch.ui.arty.ArtyCenterActivity;
import com.mobvoi.mcuwatch.ui.contacts.ContactsActivity;
import com.mobvoi.mcuwatch.ui.lpa.SimOpenBaseActivity;
import com.mobvoi.mcuwatch.ui.onlinedial.OnlineDialActivity;
import com.mobvoi.mcuwatch.ui.onlinedial.apollo.ApolloOnlineDialActivity;
import com.mobvoi.mcuwatch.ui.settings.ApolloSettingActivity;
import com.mobvoi.mcuwatch.ui.settings.SettingActivity;
import com.mobvoi.mcuwatch.ui.settings.SmartModeActivity;
import com.mobvoi.mcuwatch.ui.settings.apollo.CloudPushActivity;
import com.mobvoi.mcuwatch.ui.settings.other.OtherActivity;
import com.mobvoi.mcuwatch.ui.settings.remind.SmartRemindActivity;
import com.mobvoi.mcuwatch.ui.workout.WorkoutActivity;
import com.mobvoi.mcuwatch.welcome.WelcomeActivity;
import java.util.ArrayList;
import java.util.List;
import nj.g;
import nj.i;
import sh.f;
import sh.k;
import vi.e;
/* compiled from: WatchLiteMcuFragment.java */
/* loaded from: classes2.dex */
public class a0 extends e {
    e A;
    e B;
    e C;
    e D;
    e E;
    e F;
    e G;
    e H;
    e I;
    e J;
    int K;
    vi.e L;
    private final BroadcastReceiver M = new b();

    /* renamed from: w  reason: collision with root package name */
    e f19472w;

    /* renamed from: x  reason: collision with root package name */
    e f19473x;

    /* renamed from: y  reason: collision with root package name */
    e f19474y;

    /* renamed from: z  reason: collision with root package name */
    e f19475z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WatchLiteMcuFragment.java */
    /* loaded from: classes2.dex */
    public class a extends c0 {
        a(a0 a0Var) {
        }

        @Override // com.mobvoi.apollo.client.c0
        public void m(byte[] bArr) {
            q.f15504a.r();
        }
    }

    /* compiled from: WatchLiteMcuFragment.java */
    /* loaded from: classes2.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() != null) {
                String action = intent.getAction();
                action.hashCode();
                if (!action.equals("action.UPDATE_MCU_WATCH_DATA")) {
                    if (action.equals("com.mobvoi.ACTION_SHOW_ARTY_AUTH")) {
                        a0.this.n1();
                    }
                } else if (intent.getBooleanExtra("extra.SYNC_MCU_WATCH_FINISH", false)) {
                    i.a().b(a0.this.getActivity());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WatchLiteMcuFragment.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a();
    }

    private List<e> Q0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f19472w);
        arrayList.add(this.F);
        arrayList.add(this.I);
        arrayList.add(this.E);
        arrayList.add(this.D);
        arrayList.add(this.C);
        arrayList.add(this.B);
        arrayList.add(this.G);
        arrayList.add(this.A);
        return arrayList;
    }

    private List<e> R0(int i10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f19472w);
        arrayList.add(this.f19473x);
        arrayList.add(this.f19474y);
        arrayList.add(this.f19475z);
        arrayList.add(this.A);
        if (i10 != 1) {
            arrayList.add(this.J);
        }
        if (i10 == 3) {
            arrayList.add(this.H);
        }
        return arrayList;
    }

    private void S0() {
        e eVar = new e(k.L3, f.R, true, m1(new c() { // from class: com.mobvoi.mcuwatch.ui.card.l
            @Override // com.mobvoi.mcuwatch.ui.card.a0.c
            public final void a() {
                a0.this.a1();
            }
        }));
        this.f19472w = eVar;
        eVar.isWatchFace = true;
        this.f19473x = new e(k.I3, f.W, m1(new c() { // from class: com.mobvoi.mcuwatch.ui.card.x
            @Override // com.mobvoi.mcuwatch.ui.card.a0.c
            public final void a() {
                a0.this.b1();
            }
        }));
        this.f19474y = new e(k.J3, f.X, m1(new c() { // from class: com.mobvoi.mcuwatch.ui.card.p
            @Override // com.mobvoi.mcuwatch.ui.card.a0.c
            public final void a() {
                a0.this.c1();
            }
        }));
        this.f19475z = new e(k.K3, f.f34542e0, m1(new c() { // from class: com.mobvoi.mcuwatch.ui.card.y
            @Override // com.mobvoi.mcuwatch.ui.card.a0.c
            public final void a() {
                a0.this.d1();
            }
        }));
        this.A = new e(k.f34890x0, f.f34548g0, new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.card.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a0.this.e1(view);
            }
        });
        this.B = new e(k.M3, f.f34581r0, m1(new c() { // from class: com.mobvoi.mcuwatch.ui.card.m
            @Override // com.mobvoi.mcuwatch.ui.card.a0.c
            public final void a() {
                a0.this.f1();
            }
        }));
        this.C = new e(k.S4, f.C0, new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.card.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a0.this.g1(view);
            }
        });
        this.D = new e(k.X0, f.f34536c0, m1(new c() { // from class: com.mobvoi.mcuwatch.ui.card.w
            @Override // com.mobvoi.mcuwatch.ui.card.a0.c
            public final void a() {
                a0.this.T0();
            }
        }));
        this.E = new e(k.W0, f.Z, m1(new c() { // from class: com.mobvoi.mcuwatch.ui.card.o
            @Override // com.mobvoi.mcuwatch.ui.card.a0.c
            public final void a() {
                a0.this.U0();
            }
        }));
        this.F = new e(k.f34823k0, f.f34539d0, new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.card.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a0.this.V0(view);
            }
        });
        this.G = new e(k.U2, f.f34533b0, new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.card.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a0.this.W0(view);
            }
        });
        this.H = new e(k.B_res_0x7f140113, f.f34530a0, m1(new c() { // from class: com.mobvoi.mcuwatch.ui.card.k
            @Override // com.mobvoi.mcuwatch.ui.card.a0.c
            public final void a() {
                a0.this.X0();
            }
        }));
        this.I = new e(k.B0, f.f34595w, m1(new c() { // from class: com.mobvoi.mcuwatch.ui.card.z
            @Override // com.mobvoi.mcuwatch.ui.card.a0.c
            public final void a() {
                a0.this.Y0();
            }
        }));
        e eVar2 = new e(k.F1, f.f34579q1, m1(new c() { // from class: com.mobvoi.mcuwatch.ui.card.n
            @Override // com.mobvoi.mcuwatch.ui.card.a0.c
            public final void a() {
                a0.this.Z0();
            }
        }));
        this.J = eVar2;
        eVar2.isBeta = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0() {
        Context requireContext = requireContext();
        CompanionSetting.setTicpayPlatform(CompanionSetting.TICPAY_PLATFORM_APOLLO);
        Intent intent = new Intent("com.mobvoi.action.PAY_CENTER");
        intent.putExtra("extra_index", 1);
        intent.setPackage(requireContext.getPackageName());
        requireContext.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0() {
        b1.a.b(requireContext()).d(new Intent("action.GTW_ACCESS_CARD"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(View view) {
        startActivity(new Intent(getContext(), CloudPushActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0(View view) {
        q.f15504a.K(6, null, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0() {
        if (!CompanionSetting.isArtyAuthorize()) {
            n1();
        } else if (!CompanionSetting.getArtyGuidePageShowFinished()) {
            startActivity(new Intent(getContext(), WelcomeActivity.class));
        } else {
            startActivity(new Intent(getContext(), ArtyCenterActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y0() {
        startActivity(new Intent(getContext(), ContactsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z0() {
        startActivity(new Intent(getContext(), WorkoutActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a1() {
        if (this.K == 5) {
            startActivity(new Intent(getContext(), ApolloOnlineDialActivity.class));
        } else {
            startActivity(new Intent(getContext(), OnlineDialActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b1() {
        startActivity(new Intent(getContext(), SmartModeActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1() {
        SmartRemindActivity.start(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d1() {
        OtherActivity.start(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e1(View view) {
        if (this.K == 5) {
            ApolloSettingActivity.start(requireContext());
        } else {
            SettingActivity.Y(getContext(), this.f19485r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f1() {
        Intent intent = new Intent(getContext(), BrowserActivity.class);
        boolean c10 = yd.b.c(getContext());
        switch (this.K) {
            case 1:
                intent.putExtra("url", c10 ? "http://activities.chumenwenwen.com/vpa/ticwatch-gtx-oversea/index.html" : "https://www.ticstore.com/products/GTX");
                break;
            case 2:
                intent.putExtra("url", c10 ? "https://activities.chumenwenwen.com/vpa/ticwatch-gth/index-en.html" : "https://www.ticstore.com/products/TicWatch%20GTH");
                break;
            case 3:
                intent.putExtra("url", "https://www.mobvoi.com/pages/ticwatchgthpro");
                break;
            case 4:
                intent.putExtra("url", "https://www.ticstore.com/products/gta");
                break;
            case 5:
                intent.putExtra("url", "https://activities.chumenwenwen.com/vpa/gtw/pages/index.html");
                break;
            case 6:
            case 7:
                intent.putExtra("url", "https://www.ticstore.com/products/gtk");
                break;
        }
        intent.putExtra(BasicBrowserActivity.KEY_FLAG_GOBACK, true);
        intent.putExtra(BasicBrowserActivity.KEY_TITLE, getString(R.string.title_help_center));
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g1(View view) {
        startActivity(new Intent(getContext(), SimOpenBaseActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h1(Boolean bool) {
        if (!bool.booleanValue()) {
            Toast.makeText(requireContext(), getString(CompanionSetting.isArtyAuthorize() ? k.M : k.f34878v), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i1(c cVar, View view) {
        if (!p0()) {
            cVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j1() {
        this.f19484q.H(true);
    }

    private void k1() {
        if (nj.q.g().p(3)) {
            this.f19484q.I().i(this, new x() { // from class: com.mobvoi.mcuwatch.ui.card.v
                @Override // androidx.lifecycle.x
                public final void a(Object obj) {
                    a0.this.h1((Boolean) obj);
                }
            });
            if (nj.q.g().f()) {
                nj.q.g().A(false);
                if (!CompanionSetting.isArtyAuthorize()) {
                    n1();
                }
            }
        }
    }

    private void l1() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.mobvoi.ACTION_SHOW_ARTY_AUTH");
        intentFilter.addAction("action.UPDATE_MCU_WATCH_DATA");
        b1.a.b(getContext()).c(this.M, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1() {
        vi.e eVar = this.L;
        if (eVar == null) {
            vi.e eVar2 = new vi.e(requireContext());
            this.L = eVar2;
            eVar2.k(new e.a() { // from class: com.mobvoi.mcuwatch.ui.card.q
                @Override // vi.e.a
                public final void a() {
                    a0.this.j1();
                }
            });
        } else {
            eVar.e();
        }
        if (!this.L.isShowing()) {
            this.L.show();
        }
    }

    private void o1() {
        b1.a.b(getContext()).e(this.M);
    }

    @Override // com.mobvoi.mcuwatch.ui.card.e
    protected List<com.mobvoi.companion.ui.e> m0() {
        this.K = nj.q.g().l();
        if (nj.q.g().o()) {
            return Q0();
        }
        return R0(this.K);
    }

    public View.OnClickListener m1(final c cVar) {
        return new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.card.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a0.this.i1(cVar, view);
            }
        };
    }

    @Override // com.mobvoi.mcuwatch.ui.card.e, com.mobvoi.companion.ui.d, com.mobvoi.companion.ui.a, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        S0();
        a0();
        l1();
        k1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        o1();
    }

    @Override // com.mobvoi.companion.ui.d, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!bi.b.g().f5161d) {
            bi.b.g().h();
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.card.e, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        g.f(this);
    }
}
