package com.mobvoi.record.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.paypal.android.sdk.payments.PayPalAuthorization;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import java.math.BigDecimal;
import org.json.JSONException;
/* compiled from: PayPalUtil.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static Activity f20694b;

    /* renamed from: c  reason: collision with root package name */
    private static a f20695c;

    /* renamed from: a  reason: collision with root package name */
    public static PayPalConfiguration f20693a = new PayPalConfiguration().h("live").s("Mobvoi").t(Uri.parse("https://www.example.com/privacy")).u(Uri.parse("https://www.example.com/legal")).e("Ab5gv39YHaXo49AGwq7zr23xqFK95u9SFKLBqUEiTbjFe0OqzIuyo84echv1u0_bSWMY2uC9AGBRbO7w");

    /* renamed from: d  reason: collision with root package name */
    private static final b f20696d = new b();

    /* compiled from: PayPalUtil.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(PaymentConfirmation paymentConfirmation, String str);

        void b();
    }

    private b() {
    }

    public static b a(Activity activity, a aVar) {
        f20694b = activity;
        f20695c = aVar;
        Intent intent = new Intent(f20694b, PayPalService.class);
        intent.putExtra("com.paypal.android.sdk.paypalConfiguration", f20693a);
        f20694b.startService(intent);
        return f20696d;
    }

    public void b(int i10, int i11, Intent intent) {
        PayPalAuthorization payPalAuthorization;
        a aVar;
        if (i10 == 3 && (aVar = f20695c) != null) {
            String str = null;
            if (i11 == -1) {
                PaymentConfirmation paymentConfirmation = (PaymentConfirmation) intent.getParcelableExtra("com.paypal.android.sdk.paymentConfirmation");
                a aVar2 = f20695c;
                if (paymentConfirmation == null) {
                    str = "payment result is null.";
                }
                aVar2.a(paymentConfirmation, str);
            } else if (i11 == 0) {
                aVar.a(null, "user canceled.");
            } else if (i11 == 2) {
                aVar.a(null, "An invalid Payment or PayPalConfiguration was submitted");
            } else {
                aVar.a(null, "unknow error.");
            }
        } else if (i10 == 2 && f20695c != null && i11 == -1 && (payPalAuthorization = (PayPalAuthorization) intent.getParcelableExtra("com.paypal.android.sdk.authorization")) != null) {
            try {
                Log.i("FuturePaymentExample", payPalAuthorization.b().toString(4));
                String a10 = payPalAuthorization.a();
                a aVar3 = f20695c;
                if (!(aVar3 == null || a10 == null)) {
                    aVar3.b();
                }
                Log.i("FuturePaymentExample", a10);
            } catch (JSONException e10) {
                Log.e("FuturePaymentExample", "an extremely unlikely failure occurred: ", e10);
            }
        }
    }

    public void c() {
        Activity activity = f20694b;
        if (activity != null) {
            activity.stopService(new Intent(f20694b, PayPalService.class));
        }
        f20694b = null;
        f20695c = null;
    }

    public void d(BigDecimal bigDecimal, String str, String str2) {
        PayPalPayment payPalPayment = new PayPalPayment(bigDecimal, str, str2, "sale");
        Intent intent = new Intent(f20694b, PaymentActivity.class);
        intent.putExtra("com.paypal.android.sdk.paypalConfiguration", f20693a);
        intent.putExtra("com.paypal.android.sdk.payment", payPalPayment);
        f20694b.startActivityForResult(intent, 3);
    }
}
