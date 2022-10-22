package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.paypal.android.sdk.Cdo;
import com.paypal.android.sdk.a2;
import com.paypal.android.sdk.d4;
import com.paypal.android.sdk.dp;
import com.paypal.android.sdk.dq;
import com.paypal.android.sdk.dt;
import com.paypal.android.sdk.e4;
import com.paypal.android.sdk.eo;
import com.paypal.android.sdk.ez;
import com.paypal.android.sdk.ft;
import com.paypal.android.sdk.i2;
import com.paypal.android.sdk.j4;
import com.paypal.android.sdk.l3;
import com.paypal.android.sdk.q4;
import com.paypal.android.sdk.r4;
import com.paypal.android.sdk.v2;
import com.paypal.android.sdk.y1;
import com.paypal.android.sdk.z3;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class PaymentConfirmActivity extends Activity {

    /* renamed from: m  reason: collision with root package name */
    private static final String f21615m = "PaymentConfirmActivity";

    /* renamed from: a  reason: collision with root package name */
    private j2 f21616a;

    /* renamed from: b  reason: collision with root package name */
    private dx f21617b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21618c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21619d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21620e;

    /* renamed from: f  reason: collision with root package name */
    private j4 f21621f;

    /* renamed from: g  reason: collision with root package name */
    private r1 f21622g;

    /* renamed from: h  reason: collision with root package name */
    private k2 f21623h;

    /* renamed from: i  reason: collision with root package name */
    private Parcelable f21624i;

    /* renamed from: j  reason: collision with root package name */
    private PayPalService f21625j;

    /* renamed from: k  reason: collision with root package name */
    private final ServiceConnection f21626k = new y1(this);

    /* renamed from: l  reason: collision with root package name */
    private boolean f21627l;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
        if (y() == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C() {
        int[] iArr = w1.f21822a;
        int i10 = iArr[this.f21623h.ordinal()];
        boolean z10 = false;
        if (i10 != 1) {
            if ((i10 == 2 || i10 == 3) && !this.f21625j.b0()) {
                showDialog(2);
                Objects.toString(this.f21625j.N().f21000b);
                this.f21625j.x(D(), true);
            }
            z10 = true;
        }
        if (z10) {
            showDialog(2);
            r1 r1Var = this.f21622g;
            if (r1Var == null || r1Var.a() == null || (this.f21623h == k2.PayPal && this.f21622g.b() == null)) {
                onBackPressed();
                return;
            }
            PayPalPayment a10 = this.f21622g.a();
            eo a11 = a(a10);
            Map o10 = o(a10);
            String d10 = a10.d();
            boolean m10 = this.f21625j.S().m();
            int i11 = iArr[this.f21623h.ordinal()];
            if (i11 == 1) {
                dx b10 = this.f21622g.b();
                this.f21625j.B(m10, b10.i(), b10.j(), b10.p() ? b10.s() : null, b10.o() ? b10.r() : null, a10.g());
            } else if (i11 == 2) {
                dq l02 = this.f21625j.l0();
                String h10 = this.f21625j.h(l02.a());
                PayPalService payPalService = this.f21625j;
                payPalService.y(payPalService.N().b(), l02.h(), a11, o10, a10.k(), d10, m10, h10, a10.g(), a10.e().toString(), a10.l(), a10.r(), a10.s());
            } else if (i11 == 3) {
                PayPalService payPalService2 = this.f21625j;
                payPalService2.z(payPalService2.N().b(), c2.v(this.f21624i).name().toLowerCase(Locale.US), c2.m(this.f21624i, "cardNumber"), c2.m(this.f21624i, "cvv"), c2.t(this.f21624i, "expiryMonth"), c2.t(this.f21624i, "expiryYear"), a11, o10, a10.k(), d10, m10, a10.g(), a10.e().toString(), a10.l(), a10.r(), a10.s());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g1 D() {
        return new v1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        PayPalService payPalService = this.f21625j;
        if (payPalService != null && payPalService.N().f21005g != null) {
            showDialog(2);
            PayPalPayment a10 = this.f21622g.a();
            this.f21625j.n(a(a10), o(a10), a10.k(), a10.d(), this.f21625j.S().m(), a10.g(), a10.e().toString(), a10.m(), a10.l(), a10.r(), a10.s(), a10.o(), a10.h());
            this.f21620e = true;
            k(this.f21625j.k0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        try {
            dismissDialog(2);
        } catch (IllegalArgumentException unused) {
        }
    }

    private static eo a(PayPalPayment payPalPayment) {
        return new eo(new BigDecimal(v2.a(payPalPayment.a().doubleValue(), payPalPayment.f()).trim()), payPalPayment.f());
    }

    private void d(int i10) {
        setResult(i10, new Intent());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Activity activity, int i10, k2 k2Var, Parcelable parcelable, PayPalConfiguration payPalConfiguration) {
        f(activity, 2, k2Var, null, payPalConfiguration, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(Activity activity, int i10, k2 k2Var, Parcelable parcelable, PayPalConfiguration payPalConfiguration, boolean z10) {
        Intent intent = new Intent(activity, PaymentConfirmActivity.class);
        intent.putExtras(activity.getIntent());
        intent.putExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_PAYMENT_KIND", k2Var);
        intent.putExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_CREDIT_CARD", parcelable);
        intent.putExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_RESET_PP_REQUEST_ID", z10);
        intent.putExtra("com.paypal.android.sdk.paypalConfiguration", payPalConfiguration);
        activity.startActivityForResult(intent, i10);
    }

    private void g(Bundle bundle) {
        String string = bundle.getString("authAccount");
        String string2 = bundle.getString("authtoken");
        String string3 = bundle.getString("scope");
        long j10 = bundle.getLong("valid_until");
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                String.format("%s:null", str);
            } else {
                String.format("%s:%s (%s)", str, obj.toString(), obj.getClass().getName());
            }
        }
        dt dtVar = new dt(string2, string3, j10, false);
        if (this.f21625j == null) {
            this.f21616a = new j2(this, string, dtVar);
        } else {
            l(string, dtVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(PaymentConfirmActivity paymentConfirmActivity, l3 l3Var) {
        paymentConfirmActivity.f21617b = new dx(l3Var, paymentConfirmActivity.f21622g.a().j());
        paymentConfirmActivity.getIntent().putExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_PAYMENT_INFO", paymentConfirmActivity.f21617b);
        paymentConfirmActivity.p();
        paymentConfirmActivity.H();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(PaymentConfirmActivity paymentConfirmActivity, List list, int i10) {
        paymentConfirmActivity.f21622g.b().d(i10);
        paymentConfirmActivity.f21621f.b(paymentConfirmActivity, (d4) list.get(i10));
    }

    private void k(String str) {
        this.f21621f.f(str);
    }

    private void l(String str, dt dtVar) {
        this.f21625j.N().f21001c = str;
        k(str);
        this.f21625j.N().f21005g = dtVar;
        if (this.f21623h != k2.PayPal) {
            this.f21621f.l(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z10) {
        if (i3.a(this, this.f21625j)) {
            Intent f10 = new i2().f(this.f21625j.S().o(), z10 ? Cdo.PROMPT_LOGIN : Cdo.USER_REQUIRED, dp.token, this.f21625j.G().d().i());
            f10.putExtra("scope", "https://uri.paypal.com/services/payments/basic");
            f10.toString();
            Log.w("paypal.sdk", "requesting " + f10.getStringExtra("response_type") + " with scope={" + f10.getStringExtra("scope") + "} from Authenticator.");
            startActivityForResult(f10, 2);
            return;
        }
        LoginActivity.e(this, 1, this.f21625j.j0(), false, z10, "https://uri.paypal.com/services/payments/basic", this.f21625j.S());
    }

    private static Map o(PayPalPayment payPalPayment) {
        if (payPalPayment == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        PayPalPaymentDetails i10 = payPalPayment.i();
        if (i10 != null) {
            if (i10.a() != null) {
                hashMap.put("shipping", v2.a(i10.a().doubleValue(), payPalPayment.f()));
            }
            if (i10.b() != null) {
                hashMap.put("subtotal", v2.a(i10.b().doubleValue(), payPalPayment.f()));
            }
            if (i10.c() != null) {
                hashMap.put("tax", v2.a(i10.c().doubleValue(), payPalPayment.f()));
            }
        }
        if (!hashMap.isEmpty()) {
            return hashMap;
        }
        return null;
    }

    private void p() {
        dx dxVar = this.f21617b;
        if (dxVar != null) {
            JSONObject jSONObject = null;
            if (dxVar.e() != null) {
                jSONObject = this.f21617b.e().d();
            }
            int l10 = this.f21617b.l();
            ArrayList b10 = q4.b(jSONObject, this.f21617b.c(), this.f21617b.m());
            if (this.f21622g.a().o() || b10 == null || b10.size() <= 0) {
                this.f21621f.r().setClickable(false);
                this.f21621f.r().setVisibility(8);
            } else {
                this.f21621f.r().setVisibility(0);
                this.f21621f.r().setClickable(true);
                this.f21621f.c(getApplicationContext(), (q4) b10.get(l10));
                r4 r4Var = new r4(this, b10, l10);
                new ListView(this).setAdapter((ListAdapter) r4Var);
                this.f21621f.p(new d2(this, r4Var, b10));
            }
            int k10 = this.f21617b.k();
            ArrayList b11 = d4.b(this.f21617b.g(), this.f21617b.h());
            if (b11 == null || b11.size() <= 0) {
                this.f21621f.q().setClickable(false);
                this.f21621f.q().setVisibility(8);
            } else {
                this.f21621f.q().setVisibility(0);
                this.f21621f.q().setClickable(true);
                this.f21621f.b(getApplicationContext(), (d4) b11.get(k10));
                e4 e4Var = new e4(this, b11, k10);
                new ListView(this).setAdapter((ListAdapter) e4Var);
                this.f21621f.n(new a2(this, e4Var, b11));
            }
            this.f21621f.l(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void q(PaymentConfirmActivity paymentConfirmActivity) {
        k2 k2Var = paymentConfirmActivity.f21623h;
        k2 k2Var2 = k2.PayPal;
        if (k2Var.equals(k2Var2)) {
            paymentConfirmActivity.f21621f.d(y1.k(paymentConfirmActivity.f21625j.S().a()));
        } else {
            paymentConfirmActivity.f21621f.d(null);
        }
        j2 j2Var = paymentConfirmActivity.f21616a;
        if (j2Var != null) {
            paymentConfirmActivity.l(j2Var.f21749a, j2Var.f21750b);
            paymentConfirmActivity.f21616a = null;
        }
        if (paymentConfirmActivity.getIntent().getBooleanExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_RESET_PP_REQUEST_ID", false)) {
            paymentConfirmActivity.f21625j.N().a();
        }
        boolean y10 = paymentConfirmActivity.y();
        if (!paymentConfirmActivity.f21618c) {
            paymentConfirmActivity.f21618c = true;
            paymentConfirmActivity.f21625j.o(ez.ConfirmPaymentWindow);
        }
        paymentConfirmActivity.z();
        paymentConfirmActivity.f21625j.M(new f2(paymentConfirmActivity));
        if (k2Var2 == paymentConfirmActivity.f21623h && !y10 && !paymentConfirmActivity.f21620e && paymentConfirmActivity.f21617b == null) {
            paymentConfirmActivity.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void r(PaymentConfirmActivity paymentConfirmActivity, List list, int i10) {
        paymentConfirmActivity.f21622g.b().f(i10);
        paymentConfirmActivity.f21621f.c(paymentConfirmActivity, (q4) list.get(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.f21625j.N().f21005g != null && !this.f21625j.N().f21005g.c()) {
            this.f21625j.N().f21005g = null;
            this.f21625j.N().f21001c = null;
        }
    }

    private void w() {
        this.f21627l = bindService(c2.u(this), this.f21626k, 1);
    }

    private boolean y() {
        if (!this.f21623h.equals(k2.PayPal) || this.f21625j.c0() || this.f21619d) {
            return false;
        }
        this.f21619d = true;
        m(false);
        return true;
    }

    private void z() {
        Enum r52;
        int i10;
        int i11;
        String str;
        PayPalPayment a10 = this.f21622g.a();
        this.f21621f.h(a10.d(), v2.e(Locale.getDefault(), a2.a().c().a(), a10.a().doubleValue(), a10.f(), true));
        k2 k2Var = this.f21623h;
        if (k2Var == k2.PayPal) {
            this.f21621f.i(true);
            k(this.f21625j.k0());
        } else {
            k2 k2Var2 = k2.CreditCard;
            if (k2Var == k2Var2 || k2Var == k2.CreditCardToken) {
                this.f21621f.i(false);
                if (this.f21623h == k2Var2) {
                    str = dq.b(c2.l(this.f21624i));
                    i11 = c2.t(this.f21624i, "expiryMonth");
                    i10 = c2.t(this.f21624i, "expiryYear");
                    r52 = c2.v(this.f21624i);
                } else {
                    dq l02 = this.f21625j.l0();
                    str = l02.g();
                    i11 = l02.i();
                    i10 = l02.j();
                    r52 = c2.j(l02);
                }
                this.f21621f.g(str, c2.h(this, r52), String.format(Locale.getDefault(), "%02d / %04d", Integer.valueOf(i11), Integer.valueOf(i10)));
            } else {
                String str2 = f21615m;
                Log.wtf(str2, "Unknown payment type: " + this.f21623h.toString());
                c2.q(this, "The payment is not a valid type. Please try again.", 3);
            }
        }
        c2.r(this.f21621f.o(), this.f21625j.W());
    }

    @Override // android.app.Activity
    public final void finish() {
        super.finish();
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        String str = f21615m;
        Objects.toString(intent);
        if (i10 == 1) {
            this.f21619d = false;
            if (i11 == -1) {
                j4 j4Var = this.f21621f;
                if (j4Var != null) {
                    j4Var.l(false);
                }
                if (this.f21625j != null) {
                    G();
                    return;
                }
                return;
            }
        } else if (i10 != 2) {
            Log.e(str, "unhandled requestCode " + i10);
            return;
        } else {
            this.f21619d = false;
            if (i11 == -1) {
                this.f21621f.l(true);
                g(intent.getExtras());
                if (this.f21625j != null) {
                    G();
                    return;
                }
                return;
            }
        }
        d(i11);
        finish();
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        this.f21625j.o(ez.ConfirmPaymentCancel);
        u();
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w();
        boolean z10 = false;
        if (bundle == null) {
            if (!c2.s(this)) {
                finish();
            }
            this.f21618c = false;
        } else {
            this.f21618c = bundle.getBoolean("pageTrackingSent");
            this.f21619d = bundle.getBoolean("isLoginActivityInProgress");
            this.f21620e = bundle.getBoolean("isSFOPaymentRequestInProgress");
        }
        if (getIntent().getExtras() == null) {
            onBackPressed();
            return;
        }
        this.f21623h = (k2) getIntent().getSerializableExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_PAYMENT_KIND");
        this.f21624i = getIntent().getParcelableExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_CREDIT_CARD");
        this.f21622g = new r1(getIntent());
        setTheme(16973934);
        requestWindowFeature(8);
        k2 k2Var = this.f21623h;
        k2 k2Var2 = k2.PayPal;
        if (k2Var == k2Var2) {
            z10 = true;
        }
        j4 j4Var = new j4(this, z10);
        this.f21621f = j4Var;
        setContentView(j4Var.a());
        c2.o(this, this.f21621f.j(), ft.CONFIRM);
        this.f21621f.k(new s1(this));
        this.f21621f.e(new x1(this));
        if (k2Var2 == this.f21623h) {
            this.f21617b = (dx) getIntent().getParcelableExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_PAYMENT_INFO");
            p();
        }
    }

    @Override // android.app.Activity
    protected final Dialog onCreateDialog(int i10, Bundle bundle) {
        if (i10 == 1) {
            return c2.d(this, ft.PAY_FAILED_ALERT_TITLE, bundle);
        }
        if (i10 == 2) {
            return c2.g(this, ft.PROCESSING, ft.ONE_MOMENT);
        }
        if (i10 == 3) {
            return c2.e(this, ft.INTERNAL_ERROR, bundle, i10);
        }
        if (i10 == 4) {
            return c2.f(this, ft.SESSION_EXPIRED_TITLE, bundle, new g2(this));
        }
        if (i10 != 5) {
            return null;
        }
        ft ftVar = ft.UNEXPECTED_PAYMENT_FLOW;
        z3.a(ftVar);
        if (bundle == null || !y1.m(bundle.getString("BUNDLE_ERROR_CODE"))) {
            ft ftVar2 = ft.WE_ARE_SORRY;
            ft ftVar3 = ft.TRY_AGAIN;
            ft ftVar4 = ft.CANCEL;
            t1 t1Var = new t1(this);
            return new AlertDialog.Builder(this).setIcon(17301543).setTitle(z3.a(ftVar2)).setMessage(z3.a(ftVar)).setPositiveButton(z3.a(ftVar3), t1Var).setNegativeButton(z3.a(ftVar4), new u1(this)).create();
        }
        String string = bundle.getString("BUNDLE_ERROR_CODE");
        ft ftVar5 = ft.WE_ARE_SORRY;
        String b10 = z3.b(string);
        ft ftVar6 = ft.TRY_AGAIN;
        ft ftVar7 = ft.CANCEL;
        h2 h2Var = new h2(this);
        return new AlertDialog.Builder(this).setIcon(17301543).setTitle(z3.a(ftVar5)).setMessage(b10).setPositiveButton(z3.a(ftVar6), h2Var).setNegativeButton(z3.a(ftVar7), new i2(this)).create();
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        PayPalService payPalService = this.f21625j;
        if (payPalService != null) {
            payPalService.f0();
        }
        if (this.f21627l) {
            unbindService(this.f21626k);
            this.f21627l = false;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        w();
    }

    @Override // android.app.Activity
    protected final void onResume() {
        super.onResume();
        if (this.f21625j != null) {
            z();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("pageTrackingSent", this.f21618c);
        bundle.putBoolean("isLoginActivityInProgress", this.f21619d);
        bundle.putBoolean("isSFOPaymentRequestInProgress", this.f21620e);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        this.f21621f.m();
    }
}
