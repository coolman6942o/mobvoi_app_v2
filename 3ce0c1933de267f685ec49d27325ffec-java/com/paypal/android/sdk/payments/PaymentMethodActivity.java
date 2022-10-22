package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import com.paypal.android.sdk.a2;
import com.paypal.android.sdk.dq;
import com.paypal.android.sdk.ez;
import com.paypal.android.sdk.ft;
import com.paypal.android.sdk.k4;
import com.paypal.android.sdk.u1;
import com.paypal.android.sdk.v2;
import com.paypal.android.sdk.z3;
import java.util.Locale;
import java.util.Timer;
/* loaded from: classes2.dex */
public final class PaymentMethodActivity extends Activity {

    /* renamed from: k  reason: collision with root package name */
    private static final String f21631k = "PaymentMethodActivity";

    /* renamed from: a  reason: collision with root package name */
    private Timer f21632a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21633b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21634c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21635d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21636e;

    /* renamed from: f  reason: collision with root package name */
    private k4 f21637f;

    /* renamed from: g  reason: collision with root package name */
    private r1 f21638g;

    /* renamed from: h  reason: collision with root package name */
    private PayPalService f21639h;

    /* renamed from: i  reason: collision with root package name */
    private final ServiceConnection f21640i = new t2(this);

    /* renamed from: j  reason: collision with root package name */
    private boolean f21641j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Activity activity, int i10, PayPalConfiguration payPalConfiguration) {
        Intent intent = new Intent(activity, PaymentMethodActivity.class);
        intent.putExtras(activity.getIntent());
        intent.putExtra("com.paypal.android.sdk.paypalConfiguration", payPalConfiguration);
        activity.startActivityForResult(intent, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(PaymentMethodActivity paymentMethodActivity) {
        paymentMethodActivity.f21639h.o(ez.SelectPayPalPayment);
        PaymentConfirmActivity.f(paymentMethodActivity, 2, k2.PayPal, null, paymentMethodActivity.f21639h.S(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f21635d && !this.f21634c) {
            this.f21637f.f21422n.setImageBitmap(u1.B("iVBORw0KGgoAAAANSUhEUgAAADcAAAAsCAYAAADByiAeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAohJREFUeNrcWYGRgjAQJMwXQAl0IFbwWMFrBS8VvHYAFagVoBVIB2IFaAV8B08H/GUm/GA+CUouBL2ZTByEwCZ3m70LcRCsrusQutDBswranhBSOTYNgC1rM1ZA82yD+6nN2Urn21xNYAF0Jmf33Ro45DhDH9+1ObN3mMe84yVXTusd7ojjTds7iIzeoZtAU7mE1/E/5p536fj/yvbFb+VmDK2sn9c27b2RcKuVOs9vdJVnVN0QBsyHrjAQQ9RNMmhn5j5tC1g8zQ0A3AK4dbNqKbJ7nJjevIeYKN3HBpSOjy2h6DjznuxLQR4xpZvbYj4MX5+CO2S9aJvGCCEL+LnGEgBv2EEsWRXqIj4HJpeA3ML9FRq5IbhioEiHCsVz6V9s/H9WlwdiDHArSfycHpicpWSM0ia4UvJRRY+xlsiJcKwrnBPBtbSnLEt594b427O9cvisgL2cr6XobMobwbWdDXAitvvUTW8E5JTbAHcWXMOQUiHnHRcb4CrBXoYhBiYSjTooOH5GfSRB4I8BnI/xAV0eoTNxaOCUWfBjdh0DOFFsZAjgMkGtZnBCCTH3pIb2BewY2gDn8bkbU/q5xpgJ5t6pK7++BNcWHdUqmUV8GsQUj72irGD1KNvNHgQY8VJOIccGz+c8ybhxR9pyVOSCsW4+11S/asOZeMCIwWvdnyvuxygzJhgrh3pYiHiYqZ3P8XXI4t6SniTJ3WAWhjHBNUripKqNKNyQFoVXmB+DFXOqWDyw/tLEGItBCv6DpUkmTouSBlyJqOrHYlHjlocXA0Y9JGvAbSWpxrPajoaAy6mKVwBIDyHjG7ZkanyqKXxtu+IacEQ3bCmgZt8gixlhZdEBzK8AAwBIvuGtI5K/kgAAAABJRU5ErkJggg==", this));
            this.f21637f.f21422n.setVisibility(0);
            this.f21637f.f21422n.setContentDescription(z3.a(ft.SCAN_CARD_ICON_DESCRIPTION));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h() {
        if (i3.a(this, this.f21639h)) {
            this.f21639h.a0();
        }
        PayPalPayment a10 = this.f21638g.a();
        String e10 = v2.e(Locale.getDefault(), a2.a().c().a(), a10.a().doubleValue(), a10.f(), true);
        this.f21637f.f21411c.f21509d.setText(a10.d());
        this.f21637f.f21411c.f21508c.setText(e10);
        if (this.f21639h.c0() && this.f21639h.N().f21005g.c()) {
            String k02 = this.f21639h.k0();
            if (!TextUtils.isEmpty(k02)) {
                this.f21637f.f21412d.setText(k02);
                this.f21637f.f21412d.setVisibility(0);
                this.f21637f.f21410b.setVisibility(0);
                if (!this.f21639h.S().l()) {
                    new v2(this, (byte) 0).execute(new Void[0]);
                    dq l02 = this.f21639h.l0();
                    if (l02 == null || !l02.d()) {
                        this.f21637f.f21416h.setVisibility(8);
                        this.f21637f.f21414f.setText(z3.a(ft.PAY_WITH_CARD));
                        this.f21637f.f21420l.setVisibility(8);
                    } else {
                        this.f21634c = true;
                        this.f21637f.f21422n.setVisibility(8);
                        this.f21637f.f21414f.setText(l02.g());
                        Enum j10 = c2.j(l02);
                        this.f21637f.f21416h.setImageBitmap(c2.h(this, j10));
                        this.f21637f.f21416h.setContentDescription(j10.toString());
                        this.f21637f.f21416h.setVisibility(0);
                        this.f21637f.f21420l.setText(z3.a(ft.CLEAR_CREDIT_CARD_INFO));
                        this.f21637f.f21420l.setVisibility(0);
                        this.f21637f.f21417i.setVisibility(0);
                        this.f21637f.f21420l.setVisibility(0);
                    }
                    f();
                } else {
                    this.f21637f.f21417i.setVisibility(8);
                    this.f21637f.f21420l.setVisibility(8);
                }
                c2.r(this.f21637f.f21418j.f21087c, this.f21639h.S().c());
            }
        }
        this.f21637f.f21412d.setVisibility(8);
        this.f21637f.f21410b.setVisibility(8);
        if (!this.f21639h.S().l()) {
        }
        c2.r(this.f21637f.f21418j.f21087c, this.f21639h.S().c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(PaymentMethodActivity paymentMethodActivity) {
        paymentMethodActivity.f21639h.o(ez.SelectCreditCardPayment);
        dq l02 = paymentMethodActivity.f21639h.l0();
        if (l02 == null || !l02.d()) {
            String a10 = paymentMethodActivity.f21639h.S().a();
            Intent intent = new Intent(paymentMethodActivity, c2.i("io.card.payment.CardIOActivity"));
            intent.putExtra(c2.n("io.card.payment.CardIOActivity", "EXTRA_LANGUAGE_OR_LOCALE"), a10);
            intent.putExtra(c2.n("io.card.payment.CardIOActivity", "EXTRA_REQUIRE_EXPIRY"), true);
            intent.putExtra(c2.n("io.card.payment.CardIOActivity", "EXTRA_REQUIRE_CVV"), true);
            intent.toString();
            paymentMethodActivity.startActivityForResult(intent, 1);
            return;
        }
        PaymentConfirmActivity.e(paymentMethodActivity, 2, k2.CreditCardToken, null, paymentMethodActivity.f21639h.S());
    }

    private void j() {
        this.f21641j = bindService(c2.u(this), this.f21640i, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p(PaymentMethodActivity paymentMethodActivity) {
        if (!paymentMethodActivity.f21636e) {
            paymentMethodActivity.f21636e = true;
            paymentMethodActivity.f21639h.o(ez.PaymentMethodWindow);
        }
        boolean z10 = !paymentMethodActivity.f21633b && (!paymentMethodActivity.f21639h.S().l() || paymentMethodActivity.f21639h.l0() == null);
        if (!i3.a(paymentMethodActivity, paymentMethodActivity.f21639h) && ((!paymentMethodActivity.f21639h.S().l() && !paymentMethodActivity.f21633b) || (z10 && paymentMethodActivity.f21639h.c0() && paymentMethodActivity.f21639h.N().f21005g.c()))) {
            paymentMethodActivity.showDialog(3);
            paymentMethodActivity.f21633b = true;
            Timer timer = new Timer();
            paymentMethodActivity.f21632a = timer;
            timer.schedule(new q2(paymentMethodActivity), 1000L);
            paymentMethodActivity.f21633b = true;
        }
        paymentMethodActivity.h();
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 != 1) {
            if (i10 == 2) {
                if (i11 == -1) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("com.paypal.android.sdk.paymentConfirmation", (PaymentConfirmation) intent.getParcelableExtra("com.paypal.android.sdk.paymentConfirmation"));
                    setResult(i11, intent2);
                    finish();
                } else if (i11 == 0) {
                    this.f21633b = true;
                }
            }
        } else if (intent != null && intent.hasExtra(c2.n("io.card.payment.CardIOActivity", "EXTRA_SCAN_RESULT"))) {
            PaymentConfirmActivity.f(this, 2, k2.CreditCard, intent.getParcelableExtra(c2.n("io.card.payment.CardIOActivity", "EXTRA_SCAN_RESULT")), (PayPalConfiguration) getIntent().getParcelableExtra("com.paypal.android.sdk.paypalConfiguration"), true);
        }
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        PayPalService payPalService = this.f21639h;
        if (payPalService != null) {
            payPalService.o(ez.PaymentMethodCancel);
        }
        Timer timer = this.f21632a;
        if (timer != null) {
            timer.cancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        boolean z10;
        super.onCreate(bundle);
        setTheme(16973934);
        requestWindowFeature(8);
        j();
        this.f21637f = new k4(this);
        this.f21638g = new r1(getIntent());
        setContentView(this.f21637f.f21409a);
        c2.o(this, this.f21637f.f21421m, ft.YOUR_ORDER);
        this.f21637f.f21415g.setText(z3.a(ft.PAY_WITH));
        this.f21637f.f21410b.setText(z3.a(ft.LOG_OUT_BUTTON));
        this.f21637f.f21419k.setOnClickListener(new m2(this));
        this.f21637f.f21410b.setOnClickListener(new n2(this));
        this.f21637f.f21417i.setOnClickListener(new o2(this));
        this.f21637f.f21420l.setOnClickListener(new p2(this));
        if (bundle == null) {
            if (!c2.s(this)) {
                finish();
            }
            z10 = false;
        } else {
            this.f21633b = bundle.getBoolean("PP_PreventAutoLogin");
            z10 = bundle.getBoolean("PP_PageTrackingSent");
        }
        this.f21636e = z10;
        this.f21632a = null;
    }

    @Override // android.app.Activity
    protected final Dialog onCreateDialog(int i10, Bundle bundle) {
        if (i10 == 1) {
            return c2.a(this, ft.LOG_OUT, ft.CONFIRM_LOG_OUT, new r2(this));
        }
        if (i10 == 2) {
            return c2.a(this, ft.CLEAR_CC_ALERT_TITLE, ft.CONFIRM_CLEAR_CREDIT_CARD_INFO, new s2(this));
        }
        if (i10 != 3) {
            return null;
        }
        return c2.g(this, ft.AUTHENTICATING, ft.ONE_MOMENT);
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        if (this.f21641j) {
            unbindService(this.f21640i);
            this.f21641j = false;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        j();
    }

    @Override // android.app.Activity
    protected final void onResume() {
        super.onResume();
        if (this.f21639h != null) {
            h();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("PP_PreventAutoLogin", this.f21633b);
        bundle.putBoolean("PP_PageTrackingSent", this.f21636e);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        this.f21637f.f21411c.a();
    }
}
