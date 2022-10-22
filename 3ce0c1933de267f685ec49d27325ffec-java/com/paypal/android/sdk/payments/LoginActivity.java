package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.paypal.android.sdk.a2;
import com.paypal.android.sdk.b3;
import com.paypal.android.sdk.dj;
import com.paypal.android.sdk.ef;
import com.paypal.android.sdk.em;
import com.paypal.android.sdk.es;
import com.paypal.android.sdk.ez;
import com.paypal.android.sdk.ft;
import com.paypal.android.sdk.i4;
import com.paypal.android.sdk.m4;
import com.paypal.android.sdk.n0;
import com.paypal.android.sdk.z3;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class LoginActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private bg f21515a;

    /* renamed from: b  reason: collision with root package name */
    private String f21516b;

    /* renamed from: c  reason: collision with root package name */
    private String f21517c;

    /* renamed from: d  reason: collision with root package name */
    private String f21518d;

    /* renamed from: e  reason: collision with root package name */
    private String f21519e;

    /* renamed from: f  reason: collision with root package name */
    private String f21520f;

    /* renamed from: g  reason: collision with root package name */
    private String f21521g;

    /* renamed from: h  reason: collision with root package name */
    private em f21522h;

    /* renamed from: i  reason: collision with root package name */
    private String f21523i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f21524j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f21525k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f21526l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f21527m;

    /* renamed from: n  reason: collision with root package name */
    private int f21528n;

    /* renamed from: o  reason: collision with root package name */
    private i4 f21529o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f21530p;

    /* renamed from: q  reason: collision with root package name */
    private PayPalService f21531q;

    /* renamed from: r  reason: collision with root package name */
    private final ServiceConnection f21532r = new r(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void A(LoginActivity loginActivity, View view) {
        loginActivity.o(bg.TWO_FA_LOGIN_OTP_IN_PROGRESS);
        loginActivity.f21531q.l(loginActivity.b(loginActivity.f21515a), loginActivity.f21529o.f21375o.getText().toString(), loginActivity.f21525k, loginActivity.k(), loginActivity.r(), loginActivity.f21523i);
    }

    private void B() {
        if (this.f21515a == bg.PIN) {
            this.f21518d = this.f21529o.f21363c.getText().toString();
            this.f21520f = this.f21529o.f21365e.getText().toString();
            return;
        }
        this.f21516b = this.f21529o.f21363c.getText().toString();
        this.f21517c = this.f21529o.f21365e.getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void C(LoginActivity loginActivity) {
        int i10 = a0.f21658a[loginActivity.f21515a.ordinal()];
        if (i10 == 8) {
            loginActivity.o(bg.EMAIL);
        } else if (i10 == 9) {
            loginActivity.o(bg.PIN);
        } else if (i10 == 11) {
            loginActivity.o(bg.TWO_FA_ENTER_OTP);
        } else if (i10 != 13) {
            Objects.toString(loginActivity.f21515a);
        } else {
            loginActivity.o(bg.TWO_FA_ENTER_OTP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        String obj = this.f21529o.f21363c.getText().toString();
        String obj2 = this.f21529o.f21365e.getText().toString();
        boolean z10 = true;
        z10 = false;
        if (this.f21515a != bg.PIN ? !b3.a(obj) || !b3.c(obj2) : !b3.d(obj) || !b3.b(obj2)) {
        }
        this.f21529o.f21370j.setEnabled(z10);
        this.f21529o.f21370j.setFocusable(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        this.f21529o.f21376p.setEnabled(6 == this.f21529o.f21375o.getText().toString().length());
    }

    private void G() {
        this.f21529o.f21378r.f21468a.setVisibility(8);
        this.f21529o.f21374n.setEnabled(false);
        this.f21529o.f21374n.setVisibility(8);
        this.f21529o.f21378r.f21474g.setVisibility(8);
        this.f21529o.f21376p.setEnabled(false);
        this.f21529o.f21376p.setVisibility(8);
        this.f21529o.f21375o.setEnabled(false);
        this.f21529o.f21375o.setVisibility(8);
    }

    private void H() {
        c2.o(this, null, ft.TWO_FACTOR_AUTH_TITLE);
        this.f21529o.f21374n.setEnabled(true);
        this.f21529o.f21374n.setVisibility(0);
        Objects.toString(this.f21531q.N().f21004f.f21501a);
        ArrayList arrayList = new ArrayList(this.f21531q.N().f21004f.f21501a.values());
        this.f21529o.f21378r.a((String) arrayList.get(this.f21528n));
        this.f21529o.f21378r.f21468a.setVisibility(0);
        if (arrayList.size() > 1) {
            this.f21529o.f21378r.b(true);
            m4 m4Var = new m4(this, arrayList, this.f21528n);
            new ListView(this).setAdapter((ListAdapter) m4Var);
            this.f21529o.f21378r.f21470c.setOnClickListener(new p(this, m4Var, arrayList));
        } else {
            this.f21529o.f21378r.b(false);
        }
        this.f21529o.f21378r.f21474g.setVisibility(0);
    }

    private void I() {
        this.f21529o.f21370j.setEnabled(false);
        this.f21529o.f21370j.setVisibility(8);
        this.f21529o.f21363c.setEnabled(false);
        this.f21529o.f21363c.setVisibility(8);
        this.f21529o.f21365e.setEnabled(false);
        this.f21529o.f21365e.setVisibility(8);
        this.f21529o.f21366f.setEnabled(false);
        this.f21529o.f21366f.setVisibility(8);
    }

    private void J() {
        c2.o(this, null, ft.LOG_IN_TO_PAYPAL);
        this.f21529o.f21363c.setVisibility(0);
        this.f21529o.f21363c.setText(this.f21516b);
        this.f21529o.f21363c.setHint(z3.a(ft.EMAIL));
        this.f21529o.f21363c.setInputType(33);
        this.f21529o.f21365e.setVisibility(0);
        this.f21529o.f21365e.setText(this.f21517c);
        this.f21529o.f21365e.setHint(z3.a(ft.PASSWORD));
        this.f21529o.f21365e.setInputType(129);
        if (this.f21529o.f21363c.getText().length() > 0 && this.f21529o.f21365e.getText().length() == 0) {
            this.f21529o.f21365e.requestFocus();
        }
        this.f21529o.f21363c.setContentDescription("Email");
        this.f21529o.f21365e.setContentDescription("Password");
        this.f21529o.f21370j.setVisibility(0);
        this.f21529o.f21366f.setVisibility(0);
        this.f21529o.f21367g.setVisibility(0);
        this.f21529o.f21368h.setVisibility(0);
        this.f21529o.f21373m.setText(z3.a(ft.LOGIN_WITH_PHONE));
    }

    private void K() {
        c2.o(this, null, ft.LOG_IN_TO_PAYPAL);
        this.f21529o.f21363c.setVisibility(0);
        this.f21529o.f21363c.setText(this.f21518d);
        this.f21529o.f21363c.setHint(z3.a(ft.PHONE));
        this.f21529o.f21363c.setInputType(3);
        this.f21529o.f21365e.setVisibility(0);
        this.f21529o.f21365e.setText(this.f21520f);
        this.f21529o.f21365e.setHint(z3.a(ft.PIN));
        this.f21529o.f21365e.setInputType(18);
        if (this.f21529o.f21363c.getText().length() > 0 && this.f21529o.f21365e.getText().length() == 0) {
            this.f21529o.f21365e.requestFocus();
        }
        this.f21529o.f21363c.setContentDescription("Phone");
        this.f21529o.f21365e.setContentDescription("Pin");
        this.f21529o.f21370j.setVisibility(0);
        this.f21529o.f21366f.setVisibility(0);
        this.f21529o.f21367g.setVisibility(0);
        this.f21529o.f21368h.setVisibility(4);
        this.f21529o.f21373m.setText(z3.a(ft.LOGIN_WITH_EMAIL));
    }

    private void L() {
        int i10 = a0.f21658a[this.f21515a.ordinal()];
        if (i10 == 1) {
            o(bg.EMAIL_LOGIN_FAILED);
        } else if (i10 == 2) {
            o(bg.PIN_LOGIN_FAILED);
        } else if (i10 == 3 || i10 == 4) {
            o(bg.TWO_FA_SEND_SMS_FAILED);
        } else if (i10 != 5) {
            Objects.toString(this.f21515a);
        } else {
            o(bg.TWO_FA_LOGIN_OTP_FAILED);
        }
    }

    private em b(bg bgVar) {
        B();
        if (bgVar != bg.PIN) {
            return bgVar == bg.EMAIL ? new em(this.f21516b, this.f21517c) : this.f21522h;
        }
        a2 a10 = a2.a();
        return new em(this.f21519e == null ? new es(a10, this.f21518d) : new es(a10, new ef(this.f21519e), this.f21518d), this.f21520f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Activity activity, int i10, dj djVar, boolean z10, boolean z11, String str, PayPalConfiguration payPalConfiguration) {
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtras(activity.getIntent());
        intent.putExtra("com.paypal.android.sdk.payments.persistedLogin", djVar);
        intent.putExtra("com.paypal.android.sdk.payments.useResponseTypeCode", z10);
        intent.putExtra("com.paypal.android.sdk.payments.forceLogin", z11);
        intent.putExtra("com.paypal.android.sdk.payments.requestedScopes", str);
        intent.putExtra("com.paypal.android.sdk.paypalConfiguration", payPalConfiguration);
        activity.startActivityForResult(intent, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(LoginActivity loginActivity, View view) {
        bg bgVar;
        em b10 = loginActivity.b(loginActivity.f21515a);
        if (loginActivity.f21515a == bg.PIN) {
            loginActivity.f21522h = new em(b10.d(), (String) null);
            bgVar = bg.PIN_LOGIN_IN_PROGRESS;
        } else {
            loginActivity.f21522h = new em(b10.b(), (String) null);
            bgVar = bg.EMAIL_LOGIN_IN_PROGRESS;
        }
        loginActivity.o(bgVar);
        loginActivity.f21531q.m(b10, loginActivity.f21525k, loginActivity.k(), loginActivity.r(), loginActivity.f21523i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(LoginActivity loginActivity, h1 h1Var) {
        if (h1Var.b()) {
            loginActivity.s();
            return;
        }
        if (h1Var.a() && h1Var.f21731b.equals("invalid_user")) {
            loginActivity.L();
            c2.q(loginActivity, z3.a(ft.TWO_FACTOR_AUTH_INVALID_ONE_TIME_PASSWORD), 3);
        } else if (h1Var.c()) {
            loginActivity.L();
            c2.q(loginActivity, z3.b(h1Var.f21731b), 3);
        } else {
            boolean equals = "invalid_nonce".equals(h1Var.f21731b);
            loginActivity.f21521g = null;
            loginActivity.L();
            if (equals) {
                c2.q(loginActivity, z3.a(ft.SESSION_EXPIRED_MESSAGE), 5);
            } else {
                c2.q(loginActivity, z3.b(h1Var.f21731b), 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(LoginActivity loginActivity, String str) {
        loginActivity.f21517c = null;
        loginActivity.f21520f = null;
        loginActivity.L();
        c2.q(loginActivity, z3.b(str), 1);
    }

    private String k() {
        return r() ? "code" : "token";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void m(LoginActivity loginActivity, View view) {
        loginActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(g.a())));
        loginActivity.f21531q.p(ez.LoginForgotPassword, Boolean.valueOf(loginActivity.f21525k));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(LoginActivity loginActivity, String str) {
        String b10;
        int i10;
        loginActivity.L();
        if ("invalid_nonce".equals(str)) {
            b10 = z3.a(ft.SESSION_EXPIRED_MESSAGE);
            i10 = 5;
        } else {
            b10 = z3.b(str);
            i10 = 2;
        }
        c2.q(loginActivity, b10, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void o(bg bgVar) {
        PayPalService payPalService;
        e1 h0Var;
        Button button;
        ft ftVar;
        Objects.toString(bgVar);
        if (bgVar != null) {
            this.f21515a = bgVar;
        } else {
            Objects.toString(this.f21515a);
        }
        try {
            dismissDialog(20);
            dismissDialog(21);
        } catch (IllegalArgumentException unused) {
        }
        int[] iArr = a0.f21658a;
        switch (iArr[this.f21515a.ordinal()]) {
            case 1:
                showDialog(20);
                G();
                J();
                this.f21529o.f21363c.setEnabled(false);
                this.f21529o.f21365e.setEnabled(false);
                this.f21529o.f21370j.setEnabled(false);
                break;
            case 2:
                showDialog(20);
                G();
                K();
                this.f21529o.f21370j.setEnabled(false);
                break;
            case 3:
                showDialog(21);
                I();
                H();
                button = this.f21529o.f21378r.f21474g;
                ftVar = ft.TWO_FACTOR_AUTH_SEND_SMS_AGAIN;
                button.setText(z3.a(ftVar));
                this.f21529o.f21375o.setEnabled(false);
                this.f21529o.f21375o.setVisibility(8);
                this.f21529o.f21376p.setEnabled(false);
                this.f21529o.f21376p.setVisibility(8);
                break;
            case 4:
                showDialog(21);
                I();
                H();
                this.f21529o.f21378r.f21474g.setText(z3.a(ft.TWO_FACTOR_AUTH_SEND_SMS_AGAIN));
                this.f21529o.f21375o.setEnabled(false);
                this.f21529o.f21375o.setVisibility(0);
                this.f21529o.f21376p.setEnabled(false);
                this.f21529o.f21376p.setVisibility(0);
                break;
            case 5:
                showDialog(20);
                I();
                H();
                this.f21529o.f21378r.f21474g.setText(z3.a(ft.TWO_FACTOR_AUTH_SEND_SMS_AGAIN));
                this.f21529o.f21375o.setEnabled(false);
                this.f21529o.f21375o.setVisibility(0);
                this.f21529o.f21376p.setEnabled(false);
                this.f21529o.f21376p.setVisibility(0);
                break;
            case 6:
                G();
                J();
                this.f21529o.f21363c.setEnabled(true);
                this.f21529o.f21365e.setEnabled(true);
                D();
                break;
            case 7:
                G();
                K();
                this.f21529o.f21363c.setEnabled(true);
                this.f21529o.f21365e.setEnabled(true);
                D();
                break;
            case 8:
                G();
                J();
                this.f21529o.f21363c.setEnabled(false);
                this.f21529o.f21365e.setEnabled(false);
                this.f21529o.f21370j.setEnabled(false);
                break;
            case 9:
                G();
                K();
                this.f21529o.f21370j.setEnabled(false);
                break;
            case 10:
                I();
                H();
                button = this.f21529o.f21378r.f21474g;
                ftVar = ft.TWO_FACTOR_AUTH_SEND_SMS;
                button.setText(z3.a(ftVar));
                this.f21529o.f21375o.setEnabled(false);
                this.f21529o.f21375o.setVisibility(8);
                this.f21529o.f21376p.setEnabled(false);
                this.f21529o.f21376p.setVisibility(8);
                break;
            case 11:
            case 13:
                I();
                H();
                this.f21529o.f21378r.f21474g.setText(z3.a(ft.TWO_FACTOR_AUTH_SEND_SMS_AGAIN));
                this.f21529o.f21375o.setEnabled(false);
                this.f21529o.f21375o.setVisibility(0);
                this.f21529o.f21376p.setEnabled(false);
                this.f21529o.f21376p.setVisibility(0);
                break;
            case 12:
                I();
                H();
                this.f21529o.f21378r.f21474g.setText(z3.a(ft.TWO_FACTOR_AUTH_SEND_SMS_AGAIN));
                this.f21529o.f21375o.setEnabled(true);
                this.f21529o.f21375o.setVisibility(0);
                EditText editText = this.f21529o.f21375o;
                editText.requestFocus();
                new Handler().postDelayed(new o(this, editText), 200L);
                this.f21529o.f21376p.setVisibility(0);
                F();
                break;
        }
        int i10 = iArr[this.f21515a.ordinal()];
        if (i10 == 1 || i10 == 2) {
            payPalService = this.f21531q;
            h0Var = new h0(this);
        } else if (i10 == 3 || i10 == 4) {
            payPalService = this.f21531q;
            h0Var = new m(this);
        } else if (i10 == 5) {
            this.f21531q.w(new n(this));
            return;
        } else {
            return;
        }
        payPalService.w(h0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void q(LoginActivity loginActivity, View view) {
        loginActivity.B();
        bg bgVar = loginActivity.f21515a;
        bg bgVar2 = bg.PIN;
        if (bgVar == bgVar2) {
            loginActivity.o(bg.EMAIL);
        } else {
            loginActivity.o(bgVar2);
        }
        loginActivity.z();
        loginActivity.f21529o.a(loginActivity.f21515a == bg.EMAIL);
    }

    private boolean r() {
        return getIntent().getBooleanExtra("com.paypal.android.sdk.payments.useResponseTypeCode", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.f21531q.N().f21004f.f21501a.isEmpty()) {
            L();
            c2.q(this, z3.a(ft.TWO_FACTOR_AUTH_NO_ACTIVE_TOKENS_ERROR), 10);
            return;
        }
        o(bg.TWO_FA_SEND_FIRST_SMS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void u(LoginActivity loginActivity, View view) {
        loginActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(c3.a())));
        loginActivity.f21531q.p(ez.SignUp, Boolean.valueOf(loginActivity.f21525k));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void x(LoginActivity loginActivity, View view) {
        loginActivity.o(loginActivity.f21515a == bg.TWO_FA_ENTER_OTP ? bg.TWO_FA_SEND_ANOTHER_SMS_IN_PROGRESS : bg.TWO_FA_SEND_FIRST_SMS_IN_PROGRESS);
        loginActivity.f21529o.f21375o.setText("");
        loginActivity.f21531q.i(loginActivity.f21528n);
    }

    private void z() {
        c2.r(this.f21529o.f21364d.f21087c, this.f21531q.W());
        o(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        bg bgVar;
        PayPalConfiguration S = this.f21531q.S();
        if (z3.f22069a) {
            this.f21529o.f21365e.setGravity(5);
            this.f21529o.f21363c.setGravity(5);
            this.f21529o.f21375o.setGravity(5);
        }
        if (!b3.f(Locale.getDefault().getCountry().toLowerCase(Locale.US)) || !this.f21531q.N().f21007i) {
            this.f21529o.f21373m.setVisibility(4);
        }
        if (this.f21526l) {
            this.f21526l = false;
            this.f21516b = S.d();
            String f10 = S.f();
            if (f10 != null) {
                this.f21518d = f10;
            }
            String g10 = S.g();
            if (g10 != null) {
                this.f21519e = g10;
            }
            if (S.i() && !n0.c(S.c())) {
                this.f21517c = S.j();
                this.f21520f = S.k();
            }
        }
        if (getIntent().getBooleanExtra("com.paypal.android.sdk.payments.forceLogin", false) && !this.f21527m) {
            this.f21527m = true;
            this.f21531q.a0();
        }
        if (!this.f21531q.c0()) {
            if (!this.f21524j) {
                this.f21524j = true;
                this.f21531q.p(ez.LoginWindow, Boolean.valueOf(this.f21525k));
            }
            if (this.f21515a == null) {
                dj djVar = (dj) getIntent().getParcelableExtra("com.paypal.android.sdk.payments.persistedLogin");
                if (djVar != null) {
                    this.f21525k = true;
                    if (TextUtils.isEmpty(this.f21516b) && !TextUtils.isEmpty(djVar.e())) {
                        this.f21516b = djVar.e();
                    }
                    if (this.f21518d == null && djVar.a() != null) {
                        this.f21518d = djVar.a().c(a2.a());
                    }
                    int i10 = a0.f21659b[djVar.f().ordinal()];
                    if (i10 != 1) {
                        if (i10 == 2) {
                            bgVar = bg.PIN;
                            o(bgVar);
                        }
                    }
                }
                bgVar = bg.EMAIL;
                o(bgVar);
            }
            z();
            return;
        }
        w();
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        this.f21531q.p(ez.LoginCancel, Boolean.valueOf(this.f21525k));
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f21523i = getIntent().getExtras().getString("com.paypal.android.sdk.payments.requestedScopes");
        this.f21530p = bindService(c2.u(this), this.f21532r, 1);
        setTheme(16973934);
        requestWindowFeature(8);
        i4 i4Var = new i4(this);
        this.f21529o = i4Var;
        setContentView(i4Var.f21361a);
        this.f21529o.f21367g.setText(z3.a(ft.SIGN_UP));
        this.f21529o.f21368h.setText(z3.a(ft.FORGOT_PASSWORD));
        TextView textView = this.f21529o.f21371k;
        ft ftVar = ft.LOG_IN;
        textView.setText(z3.a(ftVar));
        this.f21529o.f21371k.setHint(z3.a(ftVar));
        this.f21529o.f21374n.setText(z3.a(ft.TWO_FACTOR_AUTH_SUBTITLE));
        this.f21529o.f21375o.setHint(z3.a(ft.TWO_FACTOR_AUTH_ENTER_SECURITY_CODE));
        this.f21529o.f21377q.setText(z3.a(ftVar));
        this.f21529o.f21378r.c(z3.a(ft.TWO_FACTOR_AUTH_ENTER_MOBILE_NUMBER));
        l lVar = new l(this);
        this.f21529o.f21363c.addTextChangedListener(lVar);
        this.f21529o.f21365e.addTextChangedListener(lVar);
        this.f21529o.f21370j.setOnClickListener(new y(this));
        this.f21529o.f21368h.setOnClickListener(new b0(this));
        this.f21529o.f21373m.setOnClickListener(new c0(this));
        this.f21529o.f21367g.setOnClickListener(new d0(this));
        this.f21529o.f21378r.f21474g.setOnClickListener(new e0(this));
        this.f21529o.f21375o.addTextChangedListener(new f0(this));
        this.f21529o.f21376p.setOnClickListener(new g0(this));
        if (bundle == null) {
            this.f21524j = false;
            this.f21526l = true;
        } else {
            this.f21526l = false;
            this.f21524j = bundle.getBoolean("PP_PageTrackingSent");
            this.f21515a = (bg) bundle.getParcelable("PP_LoginType");
            this.f21516b = bundle.getString("PP_SavedEmail");
            this.f21518d = bundle.getString("PP_SavedPhone");
            this.f21519e = bundle.getString("PP_savedPhoneCountryCode");
            this.f21517c = bundle.getString("PP_SavedPassword");
            this.f21520f = bundle.getString("PP_SavedPIN");
            this.f21525k = bundle.getBoolean("PP_IsReturningUser");
            this.f21527m = bundle.getBoolean("PP_IsClearedLogin");
            this.f21523i = bundle.getString("PP_RequestedScopes");
            this.f21521g = bundle.getString("PP_SavedOTP");
            this.f21522h = (em) bundle.getParcelable("PP_OriginalLoginData");
            this.f21528n = bundle.getInt("PP_TwoFaSelectedPhoneNumberIndex");
        }
        this.f21529o.f21375o.setText(this.f21521g);
    }

    @Override // android.app.Activity
    protected final Dialog onCreateDialog(int i10, Bundle bundle) {
        if (i10 == 1) {
            return c2.f(this, ft.LOGIN_FAILED_ALERT_TITLE, bundle, new t(this));
        }
        if (i10 == 2) {
            return c2.f(this, ft.WE_ARE_SORRY, bundle, new u(this));
        }
        if (i10 == 3) {
            return c2.f(this, ft.LOGIN_FAILED_ALERT_TITLE, bundle, new v(this));
        }
        if (i10 == 4) {
            return c2.f(this, ft.LOGIN_FAILED_ALERT_TITLE, bundle, new w(this));
        }
        if (i10 == 5) {
            return c2.f(this, ft.SESSION_EXPIRED_TITLE, bundle, new x(this));
        }
        if (i10 == 10) {
            return c2.f(this, ft.LOGIN_FAILED_ALERT_TITLE, bundle, new z(this));
        }
        if (i10 == 20) {
            return c2.g(this, ft.AUTHENTICATING, ft.ONE_MOMENT);
        }
        if (i10 != 21) {
            return null;
        }
        return c2.g(this, ft.TWO_FACTOR_AUTH_SENDING_DIALOG, ft.ONE_MOMENT);
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        PayPalService payPalService = this.f21531q;
        if (payPalService != null) {
            payPalService.g0();
        }
        if (this.f21530p) {
            unbindService(this.f21532r);
            this.f21530p = false;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onResume() {
        super.onResume();
        if (this.f21531q != null) {
            z();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        B();
        bundle.putParcelable("PP_LoginType", this.f21515a);
        bundle.putString("PP_SavedEmail", this.f21516b);
        bundle.putString("PP_SavedPhone", this.f21518d);
        bundle.putString("PP_savedPhoneCountryCode", this.f21519e);
        bundle.putString("PP_SavedPassword", this.f21517c);
        bundle.putString("PP_SavedPIN", this.f21520f);
        bundle.putBoolean("PP_IsReturningUser", this.f21525k);
        bundle.putBoolean("PP_PageTrackingSent", this.f21524j);
        bundle.putBoolean("PP_IsClearedLogin", this.f21527m);
        bundle.putString("PP_RequestedScopes", this.f21523i);
        bundle.putString("PP_SavedOTP", this.f21521g);
        bundle.putParcelable("PP_OriginalLoginData", this.f21522h);
        bundle.putInt("PP_TwoFaSelectedPhoneNumberIndex", this.f21528n);
    }
}
