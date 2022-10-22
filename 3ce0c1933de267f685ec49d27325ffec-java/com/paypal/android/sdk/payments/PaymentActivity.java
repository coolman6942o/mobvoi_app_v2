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
public final class PaymentActivity extends Activity {

    /* renamed from: f  reason: collision with root package name */
    private static final String f21609f = "PaymentActivity";

    /* renamed from: a  reason: collision with root package name */
    private Timer f21610a;

    /* renamed from: b  reason: collision with root package name */
    private Date f21611b;

    /* renamed from: c  reason: collision with root package name */
    private PayPalService f21612c;

    /* renamed from: d  reason: collision with root package name */
    private final ServiceConnection f21613d = new m1(this);

    /* renamed from: e  reason: collision with root package name */
    private boolean f21614e;

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        PaymentMethodActivity.c(this, 1, this.f21612c.S());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g1 g() {
        return new o1(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(PaymentActivity paymentActivity) {
        if (paymentActivity.f21612c.S() == null) {
            Log.e(f21609f, "Service state invalid.  Did you start the PayPalService?");
            paymentActivity.setResult(2);
            paymentActivity.finish();
            return;
        }
        q1 q1Var = new q1(paymentActivity.getIntent(), paymentActivity.f21612c.S());
        if (!q1Var.c()) {
            Log.e(f21609f, "Service extras invalid.  Please see the docs.");
            paymentActivity.setResult(2);
            paymentActivity.finish();
        } else if (!q1Var.d()) {
            Log.e(f21609f, "Extras invalid.  Please see the docs.");
            paymentActivity.setResult(2);
            paymentActivity.finish();
        } else {
            paymentActivity.f21612c.e0();
            paymentActivity.f21612c.N().a();
            if (paymentActivity.f21612c.b0()) {
                paymentActivity.f();
                return;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.add(13, 1);
            paymentActivity.f21611b = calendar.getTime();
            paymentActivity.f21612c.x(paymentActivity.g(), false);
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
        String str2 = f21609f;
        if (i10 == 1) {
            if (i11 == -1) {
                if (intent != null) {
                    PaymentConfirmation paymentConfirmation = (PaymentConfirmation) intent.getParcelableExtra("com.paypal.android.sdk.paymentConfirmation");
                    if (paymentConfirmation != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("com.paypal.android.sdk.paymentConfirmation", paymentConfirmation);
                        setResult(-1, intent2);
                    } else {
                        str = "result was OK, have data, but no payment state in bundle, oops";
                    }
                } else {
                    str = "result was OK, no intent data, oops";
                }
                Log.e(str2, str);
            } else if (i11 != 0) {
                Log.wtf("paypal.sdk", "unexpected request code " + i10 + " call it a cancel");
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new x4(this).a();
        new w4(this).a();
        new v4(this).a(Arrays.asList(PaymentActivity.class.getName(), LoginActivity.class.getName(), PaymentMethodActivity.class.getName(), PaymentConfirmActivity.class.getName()));
        this.f21614e = bindService(c2.u(this), this.f21613d, 1);
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
        return i10 != 2 ? i10 != 3 ? c2.e(this, ft.UNAUTHORIZED_DEVICE_TITLE, bundle, i10) : c2.e(this, ft.UNAUTHORIZED_MERCHANT_TITLE, bundle, i10) : c2.c(this, new l1(this));
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        PayPalService payPalService = this.f21612c;
        if (payPalService != null) {
            payPalService.h0();
            this.f21612c.n0();
        }
        if (this.f21614e) {
            unbindService(this.f21613d);
            this.f21614e = false;
        }
        super.onDestroy();
    }
}
