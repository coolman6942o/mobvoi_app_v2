package com.paypal.android.sdk.payments;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import com.huawei.agconnect.exception.AGCServerException;
import com.paypal.android.sdk.a;
import com.paypal.android.sdk.a2;
import com.paypal.android.sdk.b2;
import com.paypal.android.sdk.c2;
import com.paypal.android.sdk.d2;
import com.paypal.android.sdk.dj;
import com.paypal.android.sdk.dl;
import com.paypal.android.sdk.dq;
import com.paypal.android.sdk.dt;
import com.paypal.android.sdk.em;
import com.paypal.android.sdk.eo;
import com.paypal.android.sdk.ez;
import com.paypal.android.sdk.f2;
import com.paypal.android.sdk.f3;
import com.paypal.android.sdk.h1;
import com.paypal.android.sdk.i3;
import com.paypal.android.sdk.k3;
import com.paypal.android.sdk.l3;
import com.paypal.android.sdk.m3;
import com.paypal.android.sdk.n0;
import com.paypal.android.sdk.n1;
import com.paypal.android.sdk.n3;
import com.paypal.android.sdk.o0;
import com.paypal.android.sdk.o2;
import com.paypal.android.sdk.o3;
import com.paypal.android.sdk.p0;
import com.paypal.android.sdk.p1;
import com.paypal.android.sdk.p3;
import com.paypal.android.sdk.q3;
import com.paypal.android.sdk.r1;
import com.paypal.android.sdk.r2;
import com.paypal.android.sdk.r3;
import com.paypal.android.sdk.s0;
import com.paypal.android.sdk.t2;
import com.paypal.android.sdk.t3;
import com.paypal.android.sdk.w1;
import com.paypal.android.sdk.w3;
import com.paypal.android.sdk.x1;
import com.paypal.android.sdk.x2;
import com.paypal.android.sdk.x4;
import com.paypal.android.sdk.y1;
import com.paypal.android.sdk.y3;
import com.paypal.android.sdk.z;
import com.paypal.android.sdk.z3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class PayPalService extends Service {

    /* renamed from: u  reason: collision with root package name */
    private static Intent f21588u;

    /* renamed from: a  reason: collision with root package name */
    private z f21590a;

    /* renamed from: b  reason: collision with root package name */
    private b2 f21591b;

    /* renamed from: c  reason: collision with root package name */
    private PayPalConfiguration f21592c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21593d;

    /* renamed from: h  reason: collision with root package name */
    private String f21597h;

    /* renamed from: i  reason: collision with root package name */
    private p0 f21598i;

    /* renamed from: j  reason: collision with root package name */
    private g1 f21599j;

    /* renamed from: k  reason: collision with root package name */
    private String f21600k;

    /* renamed from: l  reason: collision with root package name */
    private a f21601l;

    /* renamed from: m  reason: collision with root package name */
    private f2 f21602m;

    /* renamed from: s  reason: collision with root package name */
    dq f21608s;

    /* renamed from: t  reason: collision with root package name */
    private static final String f21587t = PayPalService.class.getSimpleName();

    /* renamed from: v  reason: collision with root package name */
    static final ExecutorService f21589v = w1.a();

    /* renamed from: e  reason: collision with root package name */
    private a f21594e = new a();

    /* renamed from: f  reason: collision with root package name */
    private a f21595f = new a();

    /* renamed from: g  reason: collision with root package name */
    private g3 f21596g = new f3(this);

    /* renamed from: n  reason: collision with root package name */
    private List f21603n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private boolean f21604o = true;

    /* renamed from: p  reason: collision with root package name */
    private boolean f21605p = true;

    /* renamed from: q  reason: collision with root package name */
    private final BroadcastReceiver f21606q = new c1(this);

    /* renamed from: r  reason: collision with root package name */
    private final IBinder f21607r = new f1(this);

    private static boolean C(dt dtVar) {
        return dtVar != null && dtVar.a();
    }

    private t3[] F(PayPalItem[] payPalItemArr) {
        if (payPalItemArr == null) {
            return null;
        }
        t3[] t3VarArr = new t3[payPalItemArr.length];
        int i10 = 0;
        for (PayPalItem payPalItem : payPalItemArr) {
            i10++;
            t3VarArr[i10] = new t3(payPalItem.b(), payPalItem.d(), payPalItem.c(), payPalItem.a(), payPalItem.e());
        }
        return t3VarArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h1 I(r1 r1Var) {
        return new h1(this, r1Var.x().b(), r1Var.z(), r1Var.x().a());
    }

    private static String K(Intent intent) {
        if (intent == null) {
            return "Intent = null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Intent{");
        sb2.append("action:" + intent.getAction());
        sb2.append(", cmp:" + intent.getComponent() + ", ");
        if (intent.getExtras() == null) {
            sb2.append("null extras");
        } else {
            sb2.append("extras:");
            for (String str : intent.getExtras().keySet()) {
                sb2.append("(" + str + ":" + intent.getExtras().get(str) + ")");
            }
        }
        sb2.append("}");
        return sb2.toString();
    }

    private void L(ez ezVar, String str, String str2) {
        t(ezVar, false, str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void P(PayPalService payPalService, r1 r1Var) {
        String b10 = r1Var.x().b();
        Log.e("paypal.sdk", b10);
        payPalService.L(ez.ConfirmPayment, b10, r1Var.r());
        payPalService.f21595f.c(payPalService.I(r1Var));
    }

    public static void Q(Context context) {
        Log.w("paypal.sdk", "clearing user data");
        f21589v.submit(new z0(context));
    }

    private boolean a() {
        return (this.f21592c == null || this.f21591b == null) ? false : true;
    }

    private static b2 b() {
        return new b2();
    }

    private void c() {
        x(new d1(this), false);
    }

    private static o0 e(String str, String str2) {
        o0 o0Var = new o0(str, str2);
        if (str2 != null) {
            if (str2.startsWith("https://")) {
                if (!str2.endsWith("/")) {
                    str2 = str2 + "/";
                }
                for (p1 p1Var : x1.d()) {
                    o0Var.c().put(p1Var.a(), str2 + p1Var.c());
                }
            } else {
                throw new RuntimeException(str2 + " does not start with 'https://', ignoring " + str);
            }
        }
        return o0Var;
    }

    private void j(Intent intent) {
        String str;
        f21588u = intent;
        K(intent);
        if (this.f21592c == null) {
            PayPalConfiguration payPalConfiguration = (PayPalConfiguration) intent.getParcelableExtra("com.paypal.android.sdk.paypalConfiguration");
            this.f21592c = payPalConfiguration;
            if (payPalConfiguration == null) {
                throw new RuntimeException("Missing EXTRA_PAYPAL_CONFIGURATION. To avoid this error, set EXTRA_PAYPAL_CONFIGURATION in both PayPalService, and the initializing activity.");
            }
        }
        if (!this.f21592c.x()) {
            throw new RuntimeException("Service extras invalid.  Please check the docs.");
        } else if (!this.f21592c.l() || c2.w()) {
            String c10 = this.f21592c.c();
            if (n0.c(c10)) {
                str = "https://api-m.paypal.com/v1/";
            } else if (n0.b(c10)) {
                str = "https://api-m.sandbox.paypal.com/v1/";
            } else if (n0.a(c10)) {
                str = null;
            } else if (!s0() || !intent.hasExtra("com.paypal.android.sdk.baseEnvironmentUrl")) {
                throw new RuntimeException("Invalid environment selected:" + c10);
            } else {
                str = intent.getStringExtra("com.paypal.android.sdk.baseEnvironmentUrl");
            }
            this.f21602m = new f2(this.f21601l, this.f21592c.c());
            o0 e10 = e(c10, str);
            if (this.f21598i == null) {
                boolean s02 = s0();
                int i10 = AGCServerException.UNKNOW_EXCEPTION;
                if (s02 && intent.hasExtra("com.paypal.android.sdk.mockNetworkDelay")) {
                    i10 = intent.getIntExtra("com.paypal.android.sdk.mockNetworkDelay", AGCServerException.UNKNOW_EXCEPTION);
                }
                boolean booleanExtra = (!s0() || !intent.hasExtra("com.paypal.android.sdk.mockEnable2fa")) ? false : intent.getBooleanExtra("com.paypal.android.sdk.mockEnable2fa", false);
                boolean z10 = true;
                int intExtra = (!s0() || !intent.hasExtra("com.paypal.android.sdk.mock2faPhoneNumberCount")) ? 1 : intent.getIntExtra("com.paypal.android.sdk.mock2faPhoneNumberCount", 1);
                this.f21604o = true;
                if (s0() && intent.hasExtra("com.paypal.android.sdk.enableAuthenticator")) {
                    this.f21604o = intent.getBooleanExtra("com.paypal.android.sdk.enableAuthenticator", true);
                }
                if (s0() && intent.hasExtra("com.paypal.android.sdk.enableAuthenticatorSecurity")) {
                    this.f21605p = intent.getBooleanExtra("com.paypal.android.sdk.enableAuthenticatorSecurity", true);
                }
                if (s0() && intent.hasExtra("com.paypal.android.sdk.enableStageSsl")) {
                    z10 = intent.getBooleanExtra("com.paypal.android.sdk.enableStageSsl", true);
                }
                boolean z11 = z10;
                p0 p0Var = new p0(this.f21601l, e10, d());
                this.f21598i = p0Var;
                p0Var.h(new r2(new i1(this, (byte) 0)));
                this.f21598i.i(new n1(this.f21598i, n0.a(this.f21592c.c()) ? new y3(this.f21598i, i10, booleanExtra, intExtra) : new h1(this.f21601l, this.f21592c.c(), d(), this.f21598i, 90, z11, Collections.singletonList(new c2(d().c())))));
            }
            z3.c(this.f21592c.a());
            if (this.f21591b == null) {
                this.f21591b = b();
            }
            if (!this.f21592c.m()) {
                Q(this.f21601l.j());
            }
            this.f21597h = intent.getComponent().getPackageName();
            o(ez.PreConnect);
            c();
        } else {
            throw new RuntimeException("Credit Cards cannot be accepted without card.io dependency. Please check the docs.");
        }
    }

    private void k(r1 r1Var) {
        this.f21598i.k(r1Var);
    }

    private static boolean s0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(ez ezVar, boolean z10, String str, String str2, String str3) {
        this.f21596g.c(ezVar, z10, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void u(PayPalService payPalService, r1 r1Var) {
        payPalService.f21591b.f21000b = null;
        r1Var.v();
        String b10 = r1Var.x().b();
        Log.e("paypal.sdk", b10);
        payPalService.L(ez.DeviceCheck, b10, r1Var.r());
        g1 g1Var = payPalService.f21599j;
        if (g1Var != null) {
            g1Var.a(payPalService.I(r1Var));
            payPalService.f21599j = null;
        }
        payPalService.f21593d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void A(List list) {
        this.f21598i.k(new k3(this.f21598i, d(), this.f21598i.c(), this.f21592c.o(), this.f21591b.f21003e.a(), this.f21591b.f21008j, list));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void B(boolean z10, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3) {
        this.f21598i.k(new i3(this.f21598i, d(), this.f21591b.f21005g.b(), this.f21591b.b(), z10, str3, this.f21600k, str, str2, jSONObject, jSONObject2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean E(j1 j1Var) {
        if (a()) {
            return true;
        }
        this.f21603n.add(j1Var);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final p0 G() {
        return this.f21598i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void M(e1 e1Var) {
        this.f21595f.b(e1Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b2 N() {
        return this.f21591b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PayPalConfiguration S() {
        return this.f21592c;
    }

    public final void T(String str, String str2) {
        k(new n3(this.f21598i, d(), str, str2));
    }

    public final void U(s0 s0Var) {
        k(new o3(this.f21598i, d(), f3.a(s0Var)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String W() {
        return this.f21592c.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String Y() {
        return this.f21592c.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Z() {
        m0();
        a0();
        this.f21602m.e();
        n0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a0() {
        this.f21591b.f21005g = null;
        d2.c(this.f21592c.c());
        b2 b2Var = this.f21591b;
        b2Var.f21002d = null;
        b2Var.f21001c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b0() {
        return this.f21591b.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c0() {
        dt dtVar = this.f21591b.f21005g;
        return dtVar != null && dtVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final z d() {
        if (this.f21590a == null) {
            this.f21590a = new c2();
        }
        return this.f21590a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d0() {
        b2 b2Var = this.f21591b;
        return (b2Var.f21003e == null || b2Var.f21008j == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e0() {
        dj a10 = this.f21602m.a();
        if (a10 == null) {
            a0();
            return;
        }
        dt dtVar = this.f21591b.f21005g;
        dt a11 = d2.a(this.f21592c.c());
        if (!C(dtVar) && C(a11)) {
            this.f21591b.f21005g = a11;
        }
        this.f21591b.f21001c = a10.g() ? a10.f().equals(dl.EMAIL) ? a10.e() : a10.a().c(a2.a()) : null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f0() {
        this.f21595f.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g0() {
        this.f21594e.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String h(String str) {
        return this.f21601l.g(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h0() {
        this.f21599j = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(int i10) {
        this.f21598i.k(new q3(this.f21598i, d(), this.f21598i.c(), this.f21592c.o(), this.f21591b.f21008j, (String) new ArrayList(this.f21591b.f21004f.f21501a.keySet()).get(i10)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i0() {
        this.f21598i.k(new p3(this.f21598i, d(), this.f21598i.c(), this.f21591b.f21000b.b(), this.f21592c.o()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final dj j0() {
        return this.f21602m.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String k0() {
        return this.f21591b.f21001c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l(em emVar, String str, boolean z10, String str2, boolean z11, String str3) {
        this.f21598i.k(new r3(this.f21598i, d(), this.f21598i.c(), this.f21592c.o(), emVar, str, this.f21591b.f21008j, z10, str2, z11, str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final dq l0() {
        return this.f21602m.b(this.f21592c.o());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(em emVar, boolean z10, String str, boolean z11, String str2) {
        this.f21598i.k(new r3(this.f21598i, d(), this.f21598i.c(), this.f21592c.o(), emVar, z10, str, z11, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m0() {
        dt dtVar;
        this.f21608s = l0();
        this.f21602m.f();
        if (this.f21608s != null && (dtVar = this.f21591b.f21000b) != null) {
            T(dtVar.b(), this.f21608s.h());
            this.f21608s = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n(eo eoVar, Map map, PayPalItem[] payPalItemArr, String str, boolean z10, String str2, String str3, boolean z11, String str4, String str5, String str6, boolean z12, String str7) {
        this.f21598i.k(new l3(this.f21598i, d(), this.f21591b.f21005g.b(), this.f21591b.b(), null, eoVar, map, F(payPalItemArr), str, z10, str2, this.f21600k, str3, z11).D(str4).E(str5).F(str6).C(z12).G(str7));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n0() {
        PayPalConfiguration payPalConfiguration = this.f21592c;
        if (payPalConfiguration != null && payPalConfiguration.x()) {
            this.f21591b = b();
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void o(ez ezVar) {
        t(ezVar, false, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String o0() {
        return this.f21597h;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        K(intent);
        if (!a()) {
            Intent intent2 = f21588u;
            if (intent2 == null) {
                j(intent);
            } else {
                j(intent2);
            }
        }
        return this.f21607r;
    }

    @Override // android.app.Service
    public final void onCreate() {
        Log.w("paypal.sdk", PayPalService.class.getSimpleName() + " created. API:" + Build.VERSION.SDK_INT + " " + d().b());
        new c2();
        a aVar = new a(this, "AndroidBasePrefs", new y1());
        this.f21601l = aVar;
        t2.c(aVar);
        x2.b(this.f21601l);
        this.f21600k = o2.b(f21589v, this, this.f21601l.i(), "2.15.1", null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.paypal.android.sdk.clearAllUserData");
        c.a(this).c(this.f21606q, intentFilter);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        p0 p0Var = this.f21598i;
        if (p0Var != null) {
            p0Var.f();
            this.f21598i.j();
            this.f21598i = null;
        }
        try {
            c.a(this).b(this.f21606q);
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        super.onRebind(intent);
        K(intent);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i10, int i11) {
        K(intent);
        if (!a()) {
            new x4(this).a();
            if (intent == null || intent.getExtras() == null) {
                throw new RuntimeException("Service extras required. Please see the docs.");
            }
            j(intent);
        }
        if (this.f21603n.size() <= 0) {
            return 3;
        }
        for (j1 j1Var : this.f21603n) {
            j1Var.a();
        }
        this.f21603n.clear();
        return 3;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        K(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void p(ez ezVar, Boolean bool) {
        t(ezVar, bool.booleanValue(), null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean p0() {
        return this.f21604o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q(ez ezVar, Boolean bool, String str) {
        t(ezVar, bool.booleanValue(), null, str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean q0() {
        return this.f21605p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r(ez ezVar, String str) {
        t(ezVar, false, null, str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s(ez ezVar, String str, String str2) {
        t(ezVar, false, null, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void w(e1 e1Var) {
        this.f21594e.b(e1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void x(g1 g1Var, boolean z10) {
        if (z10) {
            this.f21591b.f21000b = null;
        }
        this.f21599j = g1Var;
        if (!this.f21593d && !this.f21591b.c()) {
            this.f21593d = true;
            o(ez.DeviceCheck);
            this.f21598i.k(new w3(this.f21592c.c(), this.f21598i, d(), this.f21592c.o()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void y(String str, String str2, eo eoVar, Map map, PayPalItem[] payPalItemArr, String str3, boolean z10, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f21598i.k(new m3(this.f21598i, d(), this.f21591b.f21000b.b(), str, str2, str4, eoVar, map, F(payPalItemArr), str3, z10, str5, this.f21600k, str6).N(str7).O(str8).P(str9));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void z(String str, String str2, String str3, String str4, int i10, int i11, eo eoVar, Map map, PayPalItem[] payPalItemArr, String str5, boolean z10, String str6, String str7, String str8, String str9, String str10) {
        this.f21598i.k(new m3(this.f21598i, d(), this.f21591b.f21000b.b(), str, str2, (!str3.equalsIgnoreCase("4111111111111111") || !n0.b(this.f21592c.c())) ? str3 : "4444333322221111", str4, i10, i11, null, eoVar, map, F(payPalItemArr), str5, z10, str6, this.f21600k, str7).N(str8).O(str9).P(str10));
    }
}
