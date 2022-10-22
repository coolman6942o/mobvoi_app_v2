package com.pingplusplus.android;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.unionpay.tsmservice.data.Constant;
/* loaded from: classes2.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f22116a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar, Context context) {
        this.f22116a = gVar;
    }

    @JavascriptInterface
    public void paymentResult(String str) {
        PaymentActivity paymentActivity;
        PaymentActivity paymentActivity2;
        PaymentActivity paymentActivity3;
        if (str == null) {
            paymentActivity3 = this.f22116a.f22099b;
            paymentActivity3.e(Constant.CASH_LOAD_FAIL, "unknown_error");
        } else if (str.equals(Constant.CASH_LOAD_SUCCESS)) {
            paymentActivity2 = this.f22116a.f22099b;
            paymentActivity2.d(Constant.CASH_LOAD_SUCCESS);
        } else {
            paymentActivity = this.f22116a.f22099b;
            paymentActivity.e(Constant.CASH_LOAD_FAIL, "unknown_error");
        }
    }

    @JavascriptInterface
    public void setResult(String str) {
        PaymentActivity paymentActivity;
        PaymentActivity paymentActivity2;
        PaymentActivity paymentActivity3;
        if (str == null) {
            paymentActivity3 = this.f22116a.f22099b;
            paymentActivity3.e(Constant.CASH_LOAD_FAIL, "unknown_error");
        } else if (str.equals(Constant.CASH_LOAD_SUCCESS)) {
            paymentActivity2 = this.f22116a.f22099b;
            paymentActivity2.d(Constant.CASH_LOAD_SUCCESS);
        } else {
            paymentActivity = this.f22116a.f22099b;
            paymentActivity.e(Constant.CASH_LOAD_FAIL, "unknown_error");
        }
    }

    @JavascriptInterface
    public void testmodeResult(String str) {
        PaymentActivity paymentActivity;
        PaymentActivity paymentActivity2;
        PaymentActivity paymentActivity3;
        PaymentActivity paymentActivity4;
        String str2 = "unknown_error";
        if (str == null) {
            paymentActivity4 = this.f22116a.f22099b;
            paymentActivity4.e(Constant.CASH_LOAD_FAIL, str2);
        } else if (str.equals(Constant.CASH_LOAD_SUCCESS)) {
            paymentActivity3 = this.f22116a.f22099b;
            paymentActivity3.d(Constant.CASH_LOAD_SUCCESS);
        } else if (str.equals(Constant.CASH_LOAD_CANCEL)) {
            paymentActivity2 = this.f22116a.f22099b;
            paymentActivity2.e(Constant.CASH_LOAD_CANCEL, "user_cancelled");
        } else {
            if (str.equals(Constant.CASH_LOAD_FAIL)) {
                paymentActivity = this.f22116a.f22099b;
                str2 = "channel_returns_fail";
            } else if (str.equals("error")) {
                paymentActivity = this.f22116a.f22099b;
                str2 = "testmode_notify_failed";
            } else {
                paymentActivity = this.f22116a.f22099b;
            }
            paymentActivity.e(Constant.CASH_LOAD_FAIL, str2);
        }
    }
}
