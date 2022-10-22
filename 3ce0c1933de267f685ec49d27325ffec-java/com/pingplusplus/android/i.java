package com.pingplusplus.android;

import android.webkit.JavascriptInterface;
import com.unionpay.tsmservice.data.Constant;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f22113a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f22113a = gVar;
    }

    @JavascriptInterface
    public void showSource(String str) {
        PaymentActivity paymentActivity;
        PaymentActivity paymentActivity2;
        if (str.contains("支付成功")) {
            this.f22113a.f22111n = true;
            paymentActivity2 = this.f22113a.f22099b;
            paymentActivity2.f22079d = Constant.CASH_LOAD_SUCCESS;
        }
        if (str.contains("您已购买成功") || str.contains("本次消费已计入您的账单")) {
            this.f22113a.f22111n = true;
            paymentActivity = this.f22113a.f22099b;
            paymentActivity.f22079d = Constant.CASH_LOAD_SUCCESS;
        }
    }
}
