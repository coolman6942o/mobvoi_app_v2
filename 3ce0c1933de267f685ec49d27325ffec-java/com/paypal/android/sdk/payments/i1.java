package com.paypal.android.sdk.payments;

import android.util.Log;
import com.paypal.android.sdk.a;
import com.paypal.android.sdk.a2;
import com.paypal.android.sdk.d2;
import com.paypal.android.sdk.dj;
import com.paypal.android.sdk.dl;
import com.paypal.android.sdk.dq;
import com.paypal.android.sdk.dt;
import com.paypal.android.sdk.dv;
import com.paypal.android.sdk.em;
import com.paypal.android.sdk.ez;
import com.paypal.android.sdk.f2;
import com.paypal.android.sdk.i3;
import com.paypal.android.sdk.k3;
import com.paypal.android.sdk.l3;
import com.paypal.android.sdk.m3;
import com.paypal.android.sdk.n3;
import com.paypal.android.sdk.p2;
import com.paypal.android.sdk.p3;
import com.paypal.android.sdk.q2;
import com.paypal.android.sdk.q3;
import com.paypal.android.sdk.r3;
import com.paypal.android.sdk.w3;
import com.paypal.android.sdk.x3;
import java.util.UUID;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i1 implements q2 {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PayPalService f21741a;

    private i1(PayPalService payPalService) {
        this.f21741a = payPalService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i1(PayPalService payPalService, byte b10) {
        this(payPalService);
    }

    private static dt t(String str, String str2, long j10) {
        return new dt(str, str2, System.currentTimeMillis() + (j10 * 1000), true);
    }

    @Override // com.paypal.android.sdk.q2
    public final void a() {
        String unused;
        unused = PayPalService.f21587t;
    }

    @Override // com.paypal.android.sdk.q2
    public final void a(w3 w3Var) {
        g1 g1Var;
        g1 g1Var2;
        String unused;
        String unused2;
        unused = PayPalService.f21587t;
        this.f21741a.r(ez.DeviceCheck, w3Var.r());
        this.f21741a.N().f21000b = t(w3Var.f22045p, w3Var.f22046q, w3Var.f22047r);
        this.f21741a.N().f21007i = w3Var.f22048s;
        this.f21741a.f21593d = false;
        g1Var = this.f21741a.f21599j;
        if (g1Var != null) {
            unused2 = PayPalService.f21587t;
            g1Var2 = this.f21741a.f21599j;
            g1Var2.a();
            this.f21741a.f21599j = null;
        }
    }

    @Override // com.paypal.android.sdk.q2
    public final void b(n3 n3Var) {
        String unused;
        String b10 = n3Var.x().b();
        unused = PayPalService.f21587t;
        Log.e("paypal.sdk", b10);
    }

    @Override // com.paypal.android.sdk.q2
    public final void c(m3 m3Var) {
        String unused;
        m3Var.x().b();
        unused = PayPalService.f21587t;
        PayPalService.P(this.f21741a, m3Var);
    }

    @Override // com.paypal.android.sdk.q2
    public final void d(m3 m3Var) {
        a aVar;
        a aVar2;
        String unused;
        unused = PayPalService.f21587t;
        this.f21741a.s(ez.PaymentSuccessful, m3Var.r(), m3Var.F());
        aVar = this.f21741a.f21595f;
        aVar.d(c2.k(m3Var));
        if (m3Var.Q() == null || !m3Var.C()) {
            if (!m3Var.C()) {
                this.f21741a.m0();
            }
            aVar2 = this.f21741a.f21595f;
            aVar2.a();
            return;
        }
        this.f21741a.G().k(new x3(this.f21741a.G(), this.f21741a.d(), this.f21741a.N().f21000b.b(), UUID.randomUUID().toString(), m3Var.R(), m3Var.Q(), m3Var.S(), m3Var.T(), m3Var.U()));
    }

    @Override // com.paypal.android.sdk.q2
    public final void e(l3 l3Var) {
        a aVar;
        h1 I;
        String unused;
        String b10 = l3Var.x().b();
        unused = PayPalService.f21587t;
        Log.e("paypal.sdk", b10);
        aVar = this.f21741a.f21595f;
        I = this.f21741a.I(l3Var);
        aVar.c(I);
    }

    @Override // com.paypal.android.sdk.q2
    public final void f(k3 k3Var) {
        a aVar;
        h1 I;
        String unused;
        String b10 = k3Var.x().b();
        unused = PayPalService.f21587t;
        Log.e("paypal.sdk", b10);
        aVar = this.f21741a.f21595f;
        I = this.f21741a.I(k3Var);
        aVar.c(I);
    }

    @Override // com.paypal.android.sdk.q2
    public final void g(l3 l3Var) {
        a aVar;
        a aVar2;
        String unused;
        unused = PayPalService.f21587t;
        aVar = this.f21741a.f21595f;
        aVar.d(l3Var);
        aVar2 = this.f21741a.f21595f;
        aVar2.a();
    }

    @Override // com.paypal.android.sdk.q2
    public final void h(k3 k3Var) {
        a aVar;
        a aVar2;
        String unused;
        unused = PayPalService.f21587t;
        this.f21741a.r(ez.AuthorizationSuccessful, k3Var.r());
        aVar = this.f21741a.f21595f;
        aVar.d(k3Var.f21406p);
        aVar2 = this.f21741a.f21595f;
        aVar2.a();
    }

    @Override // com.paypal.android.sdk.q2
    public final void i(r3 r3Var) {
        f2 f2Var;
        a aVar;
        h1 I;
        String unused;
        String b10 = r3Var.x().b();
        unused = PayPalService.f21587t;
        Log.e("paypal.sdk", b10);
        this.f21741a.a0();
        em emVar = r3Var.f21887p;
        this.f21741a.t(emVar.a() ? ez.LoginPassword : ez.LoginPIN, r3Var.f21888q, b10, r3Var.r(), null);
        f2Var = this.f21741a.f21602m;
        f2Var.e();
        if (r3Var.f21939n) {
            this.f21741a.N().f21008j = r3Var.f21938m;
            this.f21741a.N().f21004f = new p2(r3Var.f21940o);
        }
        aVar = this.f21741a.f21594e;
        I = this.f21741a.I(r3Var);
        aVar.c(I);
    }

    @Override // com.paypal.android.sdk.q2
    public final void j(i3 i3Var) {
        String unused;
        i3Var.x().b();
        unused = PayPalService.f21587t;
        PayPalService.P(this.f21741a, i3Var);
    }

    @Override // com.paypal.android.sdk.q2
    public final void k(q3 q3Var) {
        a aVar;
        h1 I;
        String unused;
        String b10 = q3Var.x().b();
        unused = PayPalService.f21587t;
        Log.e("paypal.sdk", b10);
        aVar = this.f21741a.f21594e;
        I = this.f21741a.I(q3Var);
        aVar.c(I);
    }

    @Override // com.paypal.android.sdk.q2
    public final void l(r3 r3Var) {
        dl dlVar;
        ez ezVar;
        PayPalService payPalService;
        a aVar;
        String unused;
        unused = PayPalService.f21587t;
        long j10 = r3Var.f21897z;
        if (j10 > 840) {
            j10 = 840;
        }
        if (r3Var.f21894w == null) {
            this.f21741a.N().f21005g = t(r3Var.f21895x, r3Var.f21896y, j10);
        } else {
            this.f21741a.N().f21008j = r3Var.f21938m;
            this.f21741a.N().f21003e = new dv(r3Var.f21894w, r3Var.f21896y);
        }
        this.f21741a.N().f21004f = null;
        dj djVar = new dj();
        if (r3Var.f21887p.a()) {
            djVar.d(r3Var.f21887p.b());
            dlVar = dl.EMAIL;
        } else {
            djVar.c(r3Var.f21887p.d());
            dlVar = dl.PHONE;
        }
        djVar.b(dlVar);
        this.f21741a.N().f21002d = djVar;
        if (r3Var.f21887p.a()) {
            this.f21741a.N().f21001c = r3Var.f21887p.b();
            payPalService = this.f21741a;
            ezVar = ez.LoginPassword;
        } else {
            this.f21741a.N().f21001c = r3Var.f21887p.d().c(a2.a());
            payPalService = this.f21741a;
            ezVar = ez.LoginPIN;
        }
        payPalService.q(ezVar, Boolean.valueOf(r3Var.f21888q), r3Var.r());
        aVar = this.f21741a.f21594e;
        aVar.a();
    }

    @Override // com.paypal.android.sdk.q2
    public final void m(i3 i3Var) {
        a aVar;
        a aVar2;
        f2 f2Var;
        String unused;
        unused = PayPalService.f21587t;
        this.f21741a.s(ez.PaymentSuccessful, i3Var.r(), i3Var.D());
        if (!i3Var.E() || (this.f21741a.N().f21005g != null && !this.f21741a.N().f21005g.c())) {
            this.f21741a.a0();
        } else {
            d2.b(this.f21741a.N().f21005g, this.f21741a.W());
            if (this.f21741a.N().f21002d != null) {
                f2Var = this.f21741a.f21602m;
                f2Var.c(this.f21741a.N().f21002d);
            }
        }
        aVar = this.f21741a.f21595f;
        aVar.d(c2.k(i3Var));
        aVar2 = this.f21741a.f21595f;
        aVar2.a();
    }

    @Override // com.paypal.android.sdk.q2
    public final void n(p3 p3Var) {
        a aVar;
        h1 I;
        String unused;
        String b10 = p3Var.x().b();
        unused = PayPalService.f21587t;
        Log.e("paypal.sdk", b10);
        aVar = this.f21741a.f21595f;
        I = this.f21741a.I(p3Var);
        aVar.c(I);
    }

    @Override // com.paypal.android.sdk.q2
    public final void o(q3 q3Var) {
        a aVar;
        String unused;
        unused = PayPalService.f21587t;
        this.f21741a.N().f21008j = q3Var.f21938m;
        aVar = this.f21741a.f21594e;
        aVar.a();
    }

    @Override // com.paypal.android.sdk.q2
    public final void p(x3 x3Var) {
        a aVar;
        String unused;
        String b10 = x3Var.x().b();
        unused = PayPalService.f21587t;
        Log.e("paypal.sdk", b10);
        aVar = this.f21741a.f21595f;
        aVar.a();
    }

    @Override // com.paypal.android.sdk.q2
    public final void q(p3 p3Var) {
        a aVar;
        a aVar2;
        String unused;
        unused = PayPalService.f21587t;
        aVar = this.f21741a.f21595f;
        aVar.d(p3Var);
        aVar2 = this.f21741a.f21595f;
        aVar2.a();
    }

    @Override // com.paypal.android.sdk.q2
    public final void r(x3 x3Var) {
        a aVar;
        f2 f2Var;
        PayPalConfiguration payPalConfiguration;
        a aVar2;
        String unused;
        unused = PayPalService.f21587t;
        aVar = this.f21741a.f21601l;
        dq dqVar = new dq(aVar, x3Var.C(), x3Var.f22057m, x3Var.E(), x3Var.D(), x3Var.F(), x3Var.G(), x3Var.H());
        f2Var = this.f21741a.f21602m;
        payPalConfiguration = this.f21741a.f21592c;
        f2Var.d(dqVar, payPalConfiguration.o());
        aVar2 = this.f21741a.f21595f;
        aVar2.a();
    }

    @Override // com.paypal.android.sdk.q2
    public final void s(w3 w3Var) {
        PayPalService.u(this.f21741a, w3Var);
    }
}
