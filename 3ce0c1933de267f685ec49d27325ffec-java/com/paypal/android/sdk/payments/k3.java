package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.BulletSpan;
import android.text.style.URLSpan;
import android.util.Log;
import com.paypal.android.sdk.Cdo;
import com.paypal.android.sdk.ak;
import com.paypal.android.sdk.b4;
import com.paypal.android.sdk.dg;
import com.paypal.android.sdk.dp;
import com.paypal.android.sdk.ez;
import com.paypal.android.sdk.ft;
import com.paypal.android.sdk.i2;
import com.paypal.android.sdk.p3;
import com.paypal.android.sdk.y1;
import com.paypal.android.sdk.z3;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes2.dex */
abstract class k3 extends Activity {

    /* renamed from: k  reason: collision with root package name */
    private static final String f21758k = "k3";

    /* renamed from: l  reason: collision with root package name */
    private static final Map f21759l = new m3();

    /* renamed from: a  reason: collision with root package name */
    protected PayPalService f21760a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21761b;

    /* renamed from: c  reason: collision with root package name */
    protected PayPalOAuthScopes f21762c;

    /* renamed from: d  reason: collision with root package name */
    private h3 f21763d;

    /* renamed from: e  reason: collision with root package name */
    protected b4 f21764e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f21765f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f21766g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f21767h;

    /* renamed from: i  reason: collision with root package name */
    private du f21768i;

    /* renamed from: j  reason: collision with root package name */
    private final ServiceConnection f21769j = new s3(this);

    private void b(int i10, PayPalAuthorization payPalAuthorization) {
        Intent intent = new Intent();
        intent.putExtra("com.paypal.android.sdk.authorization", payPalAuthorization);
        setResult(i10, intent);
    }

    private void c(int i10, String str, String str2, i iVar) {
        SpannableString spannableString = new SpannableString(Html.fromHtml(str2 + str));
        if (iVar != null) {
            URLSpan[] uRLSpanArr = (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class);
            if (uRLSpanArr.length > 0) {
                URLSpan uRLSpan = uRLSpanArr[0];
                spannableString.setSpan(new b(uRLSpan, this, FuturePaymentInfoActivity.class, new l3(this), iVar), spannableString.getSpanStart(uRLSpan), spannableString.getSpanEnd(uRLSpan), 33);
                spannableString.removeSpan(uRLSpan);
            }
        } else {
            d(spannableString);
        }
        spannableString.setSpan(new BulletSpan(15), 0, spannableString.length(), 0);
        this.f21764e.f21019d[i10].setVisibility(0);
        this.f21764e.f21019d[i10].setFocusable(true);
        int i11 = i10 + 100;
        this.f21764e.f21019d[i10].setNextFocusLeftId(i11 - 1);
        this.f21764e.f21019d[i10].setNextFocusRightId(i11 + 1);
        this.f21764e.f21019d[i10].setText(spannableString);
    }

    private void d(SpannableString spannableString) {
        URLSpan[] uRLSpanArr;
        for (URLSpan uRLSpan : (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class)) {
            spannableString.setSpan(new eb(uRLSpan, new n3(this)), spannableString.getSpanStart(uRLSpan), spannableString.getSpanEnd(uRLSpan), 33);
            spannableString.removeSpan(uRLSpan);
        }
    }

    private void e(h3 h3Var) {
        this.f21760a.N().f21008j = h3Var.f21733a;
        this.f21760a.N().f21003e = h3Var.f21734b;
        this.f21760a.N().f21001c = h3Var.f21735c;
        w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(k3 k3Var, p3 p3Var) {
        k3Var.f21768i = new du(p3Var);
        k3Var.getIntent().putExtra("com.paypal.android.sdk.payments.ppAppInfo", k3Var.f21768i);
        k3Var.r();
        k3Var.x();
    }

    private void j(SpannableString spannableString) {
        URLSpan[] uRLSpanArr;
        for (URLSpan uRLSpan : (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class)) {
            spannableString.setSpan(new eb(uRLSpan, new o3(this)), spannableString.getSpanStart(uRLSpan), spannableString.getSpanEnd(uRLSpan), 33);
            spannableString.removeSpan(uRLSpan);
        }
    }

    private void l() {
        if (this.f21760a != null) {
            showDialog(2);
            if (!this.f21760a.b0()) {
                Objects.toString(this.f21760a.N().f21000b);
                this.f21760a.x(new p3(this), true);
                return;
            }
            this.f21760a.i0();
        }
    }

    private void n() {
        this.f21761b = bindService(c2.u(this), this.f21769j, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void o(k3 k3Var) {
        boolean z10;
        Objects.toString(k3Var.f21760a.N().f21005g);
        if (k3Var.f21760a.c0() || k3Var.f21766g) {
            z10 = false;
        } else {
            k3Var.f21766g = true;
            k3Var.p();
            z10 = true;
        }
        b4 b4Var = k3Var.f21764e;
        if (k3Var.f21767h) {
            k3Var.f21767h = false;
            k3Var.w();
        }
        if (!k3Var.f21765f) {
            k3Var.f21765f = true;
            k3Var.f21760a.o(ez.ConsentWindow);
        }
        c2.r(b4Var.f21022g.f21087c, k3Var.f21760a.W());
        k3Var.f21760a.M(new q3(k3Var));
        k3Var.r();
        if (!z10 && k3Var.f21768i == null) {
            k3Var.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (i3.a(this, this.f21760a)) {
            Intent f10 = new i2().f(this.f21760a.S().o(), Cdo.PROMPT_LOGIN, dp.code, this.f21760a.G().d().i());
            Objects.toString(f10);
            Log.w("paypal.sdk", "requesting code with scope=null from Authenticator.");
            startActivityForResult(f10, 2);
            return;
        }
        LoginActivity.e(this, 1, null, true, false, this.f21762c.b(), this.f21760a.S());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void q(k3 k3Var) {
        k3Var.f21760a.o(ez.ConsentCancel);
        k3Var.finish();
    }

    private void r() {
        PayPalService payPalService;
        int i10;
        if (this.f21762c != null && this.f21768i != null && (payPalService = this.f21760a) != null) {
            String p10 = payPalService.S().p();
            if (this.f21768i.e() != null) {
                p10 = this.f21768i.e();
            }
            String uri = this.f21760a.S().r().toString();
            if (this.f21768i.c() != null) {
                uri = this.f21768i.c();
            }
            String uri2 = this.f21760a.S().v().toString();
            if (this.f21768i.d() != null) {
                uri2 = this.f21768i.d();
            }
            String format = String.format(z3.a(ft.CONSENT_AGREEMENT_INTRO), "<b>" + p10 + "</b>");
            String str = z3.f22069a ? "\u200f" : "";
            this.f21764e.f21019d[0].setText(Html.fromHtml(str + format));
            if (z3.f22069a) {
                this.f21764e.f21019d[0].setGravity(5);
            }
            this.f21764e.f21019d[0].setVisibility(0);
            List a10 = this.f21762c.a();
            if (a10.contains(ak.FUTURE_PAYMENTS.a()) || a10.contains(dg.PAYMENT_CODE.a()) || a10.contains(dg.MIS_CUSTOMER.a())) {
                c(1, String.format(z3.a(ft.CONSENT_AGREEMENT_FUTURE_PAYMENTS), "future-payment-consent", "<b>" + p10 + "</b>", "<b>" + p10 + "</b>"), str, i.FUTURE_PAYMENTS);
                i10 = 2;
            } else {
                i10 = 1;
            }
            if (a10.contains(dg.GET_FUNDING_OPTIONS.a())) {
                c(i10, z3.a(ft.CONSENT_AGREEMENT_FUNDING_OPTIONS), str, null);
                i10++;
            }
            if (a10.contains(dg.FINANCIAL_INSTRUMENTS.a())) {
                c(i10, z3.a(ft.CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS), str, i.FINANCIAL_INSTRUMENTS);
                i10++;
            }
            if (a10.contains(dg.SEND_MONEY.a())) {
                c(i10, String.format(z3.a(ft.CONSENT_AGREEMENT_SEND_MONEY), "", p10), str, i.SEND_MONEY);
                i10++;
            }
            if (a10.contains(dg.REQUEST_MONEY.a())) {
                c(i10, String.format(z3.a(ft.CONSENT_AGREEMENT_REQUEST_MONEY), "", p10), str, i.REQUEST_MONEY);
                i10++;
            }
            if (a10.contains(dg.LOYALTY.a())) {
                c(i10, z3.a(ft.CONSENT_AGREEMENT_LOYALTY_CARD), str, null);
                i10++;
            }
            if (a10.contains(dg.EXPRESS_CHECKOUT.a())) {
                c(i10, z3.a(ft.CONSENT_AGREEMENT_EXPRESS_CHECKOUT), str, null);
                i10++;
            }
            if (!Collections.disjoint(a10, ak.f20985h)) {
                if (t().size() > 0) {
                    c(i10, String.format(z3.a(ft.CONSENT_AGREEMENT_ATTRIBUTES), u()), str, null);
                    i10++;
                }
            }
            c(i10, String.format(z3.a(ft.CONSENT_AGREEMENT_MERCHANT_PRIVACY_POLICY), "<b>" + p10 + "</b>", uri, uri2), str, null);
            this.f21764e.f21019d[i10].setNextFocusRightId(2);
            int i11 = i10 + 1;
            String a11 = z3.a(ft.PRIVACY);
            Object[] objArr = new Object[1];
            String lowerCase = Locale.getDefault().getCountry().toLowerCase(Locale.US);
            if (y1.i(lowerCase)) {
                lowerCase = "us";
            }
            objArr[0] = String.format("https://www.paypal.com/%s/cgi-bin/webscr?cmd=p/gen/ua/policy_privacy-outside", lowerCase);
            SpannableString spannableString = new SpannableString(Html.fromHtml(str + String.format(a11, objArr)));
            j(spannableString);
            this.f21764e.f21020e.setText(spannableString);
            this.f21764e.f21020e.setMovementMethod(LinkMovementMethod.getInstance());
            this.f21764e.f21020e.setNextFocusLeftId((i11 + 100) - 1);
            this.f21764e.f21020e.setNextFocusRightId(1);
            SpannableString k10 = y1.k(this.f21760a.S().a());
            if (k10 != null) {
                this.f21764e.f21021f.setText(k10);
                this.f21764e.f21021f.setVisibility(0);
            }
            this.f21764e.f21026k.setText(z3.a(ft.CONSENT_AGREEMENT_AGREE));
            this.f21764e.f21023h.setOnClickListener(new u3(this));
            this.f21764e.f21025j.setOnClickListener(new v3(this));
            this.f21764e.f21025j.setEnabled(true);
            h3 h3Var = this.f21763d;
            if (h3Var != null) {
                e(h3Var);
                this.f21763d = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void s(k3 k3Var) {
        k3Var.f21760a.o(ez.ConsentAgree);
        if (!k3Var.f21760a.d0()) {
            Objects.toString(k3Var.f21760a.N().f21003e);
            String str = k3Var.f21760a.N().f21008j;
            c2.q(k3Var, z3.a(ft.SESSION_EXPIRED_MESSAGE), 4);
            return;
        }
        k3Var.showDialog(2);
        k3Var.f21760a.A(k3Var.f21762c.a());
    }

    private Set t() {
        w3[] values;
        String str;
        ft ftVar;
        List a10 = this.f21762c.a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (w3 w3Var : w3.values()) {
            if (this.f21768i.a().contains(w3Var.name()) && a10.contains(((ak) f21759l.get(w3Var)).a())) {
                if (w3Var == w3.openid_connect) {
                    str = null;
                } else {
                    if (w3Var == w3.oauth_account_creation_date) {
                        ftVar = ft.CONSENT_AGREEMENT_ATTRIBUTE_ACCOUNT_CREATION_DATE;
                    } else if (w3Var == w3.oauth_account_verified) {
                        ftVar = ft.CONSENT_AGREEMENT_ATTRIBUTE_ACCOUNT_STATUS;
                    } else if (w3Var == w3.oauth_account_type) {
                        ftVar = ft.CONSENT_AGREEMENT_ATTRIBUTE_ACCOUNT_TYPE;
                    } else if (w3Var == w3.oauth_street_address1 || w3Var == w3.oauth_street_address2 || w3Var == w3.oauth_city || w3Var == w3.oauth_state || w3Var == w3.oauth_country || w3Var == w3.oauth_zip) {
                        ftVar = ft.CONSENT_AGREEMENT_ATTRIBUTE_ADDRESS;
                    } else if (w3Var == w3.oauth_age_range) {
                        ftVar = ft.CONSENT_AGREEMENT_ATTRIBUTE_AGE_RANGE;
                    } else if (w3Var == w3.oauth_date_of_birth) {
                        ftVar = ft.CONSENT_AGREEMENT_ATTRIBUTE_DATE_OF_BIRTH;
                    } else if (w3Var == w3.oauth_email) {
                        ftVar = ft.CONSENT_AGREEMENT_ATTRIBUTE_EMAIL_ADDRESS;
                    } else if (w3Var == w3.oauth_fullname) {
                        ftVar = ft.CONSENT_AGREEMENT_ATTRIBUTE_FULL_NAME;
                    } else if (w3Var == w3.oauth_gender) {
                        ftVar = ft.CONSENT_AGREEMENT_ATTRIBUTE_GENDER;
                    } else if (w3Var == w3.oauth_language) {
                        ftVar = ft.CONSENT_AGREEMENT_ATTRIBUTE_LANGUAGE;
                    } else if (w3Var == w3.oauth_locale) {
                        ftVar = ft.CONSENT_AGREEMENT_ATTRIBUTE_LOCALE;
                    } else if (w3Var == w3.oauth_phone_number) {
                        ftVar = ft.CONSENT_AGREEMENT_ATTRIBUTE_PHONE;
                    } else if (w3Var == w3.oauth_timezone) {
                        ftVar = ft.CONSENT_AGREEMENT_ATTRIBUTE_TIME_ZONE;
                    } else {
                        str = w3Var.name();
                    }
                    str = z3.a(ftVar);
                }
                if (str != null) {
                    linkedHashSet.add(str);
                }
            }
        }
        return linkedHashSet;
    }

    private String u() {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (String str : t()) {
            if (!z10) {
                sb2.append(", ");
            } else {
                z10 = false;
            }
            sb2.append(str);
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        b(-1, new PayPalAuthorization(this.f21760a.W(), this.f21760a.N().f21003e.a(), this.f21760a.N().f21001c));
        finish();
    }

    private void w() {
        String b10 = this.f21760a.N().f21003e.b();
        if (b10 == null || !Arrays.asList(b10.split(" ")).containsAll(this.f21762c.a())) {
            l();
        } else {
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        try {
            dismissDialog(2);
        } catch (IllegalArgumentException unused) {
        }
    }

    protected abstract void a();

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        String str = f21758k;
        Objects.toString(intent);
        if (i10 != 1) {
            if (i10 != 2) {
                Log.e(str, "unhandled requestCode " + i10);
                return;
            } else if (i11 == -1) {
                h3 a10 = j3.a(intent.getExtras());
                if (this.f21760a == null) {
                    this.f21763d = a10;
                    return;
                } else {
                    e(a10);
                    return;
                }
            }
        } else if (i11 == -1) {
            if (this.f21760a == null) {
                this.f21767h = true;
                return;
            } else {
                w();
                return;
            }
        }
        b(i11, null);
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f21760a.o(ez.ConsentCancel);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            if (!c2.s(this)) {
                finish();
            }
            this.f21765f = false;
        } else {
            this.f21765f = bundle.getBoolean("pageTrackingSent");
            this.f21766g = bundle.getBoolean("isLoginActivityStarted");
        }
        a();
        this.f21768i = (du) getIntent().getParcelableExtra("com.paypal.android.sdk.payments.ppAppInfo");
        n();
        setTheme(16973934);
        requestWindowFeature(8);
        b4 b4Var = new b4(this);
        this.f21764e = b4Var;
        setContentView(b4Var.f21016a);
        c2.o(this, this.f21764e.f21018c, null);
        this.f21764e.f21023h.setText(z3.a(ft.CANCEL));
        this.f21764e.f21023h.setVisibility(0);
        r();
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i10, Bundle bundle) {
        if (i10 == 1) {
            return c2.d(this, ft.CONSENT_FAILED_ALERT_TITLE, bundle);
        }
        if (i10 == 2) {
            return c2.g(this, ft.PROCESSING, ft.ONE_MOMENT);
        }
        if (i10 == 3) {
            return c2.e(this, ft.INTERNAL_ERROR, bundle, i10);
        }
        if (i10 != 4) {
            return null;
        }
        return c2.f(this, ft.SESSION_EXPIRED_TITLE, bundle, new r3(this));
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        PayPalService payPalService = this.f21760a;
        if (payPalService != null) {
            payPalService.f0();
        }
        if (this.f21761b) {
            unbindService(this.f21769j);
            this.f21761b = false;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        n();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("pageTrackingSent", this.f21765f);
        bundle.putBoolean("isLoginActivityStarted", this.f21766g);
    }
}
