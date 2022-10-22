package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.paypal.android.sdk.ft;
import com.paypal.android.sdk.s4;
import com.paypal.android.sdk.v4;
import com.paypal.android.sdk.w4;
import com.paypal.android.sdk.x4;
import com.paypal.android.sdk.z3;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
/* loaded from: classes2.dex */
public final class PayPalFuturePaymentActivity extends Activity {

    /* renamed from: f  reason: collision with root package name */
    private static final String f21551f = "PayPalFuturePaymentActivity";

    /* renamed from: a  reason: collision with root package name */
    private Date f21552a;

    /* renamed from: b  reason: collision with root package name */
    private Timer f21553b;

    /* renamed from: c  reason: collision with root package name */
    private PayPalService f21554c;

    /* renamed from: d  reason: collision with root package name */
    private final ServiceConnection f21555d = new m0(this);

    /* renamed from: e  reason: collision with root package name */
    private boolean f21556e;

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        FuturePaymentConsentActivity.y(this, 1, this.f21554c.S());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g1 g() {
        return new o0(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(PayPalFuturePaymentActivity payPalFuturePaymentActivity) {
        if (payPalFuturePaymentActivity.f21554c.S() == null) {
            Log.e(f21551f, "Service state invalid.  Did you start the PayPalService?");
            payPalFuturePaymentActivity.setResult(2);
            payPalFuturePaymentActivity.finish();
            return;
        }
        y0 y0Var = new y0(payPalFuturePaymentActivity.getIntent(), payPalFuturePaymentActivity.f21554c.S(), false);
        if (!y0Var.c()) {
            Log.e(f21551f, "Service extras invalid.  Please see the docs.");
            payPalFuturePaymentActivity.setResult(2);
            payPalFuturePaymentActivity.finish();
        } else if (!y0Var.e()) {
            Log.e(f21551f, "Extras invalid.  Please see the docs.");
            payPalFuturePaymentActivity.setResult(2);
            payPalFuturePaymentActivity.finish();
        } else if (payPalFuturePaymentActivity.f21554c.b0()) {
            payPalFuturePaymentActivity.f();
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.add(13, 1);
            payPalFuturePaymentActivity.f21552a = calendar.getTime();
            payPalFuturePaymentActivity.f21554c.x(payPalFuturePaymentActivity.g(), false);
        }
    }

    @Override // android.app.Activity
    public final void finish() {
        super.finish();
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i10, int i11, Intent intent) {
        String str;
        super.onActivityResult(i10, i11, intent);
        String str2 = f21551f;
        if (i10 == 1) {
            if (i11 == -1) {
                if (intent != null) {
                    PayPalAuthorization payPalAuthorization = (PayPalAuthorization) intent.getParcelableExtra("com.paypal.android.sdk.authorization");
                    if (payPalAuthorization != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("com.paypal.android.sdk.authorization", payPalAuthorization);
                        setResult(-1, intent2);
                    } else {
                        str = "result was OK, have data, but no authorization state in bundle, oops";
                    }
                } else {
                    str = "result was OK, no intent data, oops";
                }
                Log.e(str2, str);
            } else if (i11 != 0) {
                Log.wtf(str2, "unexpected request code " + i10 + " call it a cancel");
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new x4(this).a();
        new w4(this).a();
        new v4(this).a(Arrays.asList(PayPalFuturePaymentActivity.class.getName(), LoginActivity.class.getName(), FuturePaymentInfoActivity.class.getName(), FuturePaymentConsentActivity.class.getName()));
        this.f21556e = bindService(c2.u(this), this.f21555d, 1);
        setTheme(16973934);
        requestWindowFeature(8);
        s4 s4Var = new s4(this);
        setContentView(s4Var.f21941a);
        TextView textView = s4Var.f21943c;
        ft ftVar = ft.CHECKING_DEVICE;
        textView.setText(z3.a(ftVar));
        c2.o(this, null, ftVar);
    }

    @Override // android.app.Activity
    protected final Dialog onCreateDialog(int i10, Bundle bundle) {
        return i10 != 2 ? i10 != 3 ? c2.e(this, ft.UNAUTHORIZED_DEVICE_TITLE, bundle, i10) : c2.e(this, ft.UNAUTHORIZED_MERCHANT_TITLE, bundle, i10) : c2.c(this, new l0(this));
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        PayPalService payPalService = this.f21554c;
        if (payPalService != null) {
            payPalService.h0();
            this.f21554c.n0();
        }
        if (this.f21556e) {
            unbindService(this.f21555d);
            this.f21556e = false;
        }
        super.onDestroy();
    }
}
