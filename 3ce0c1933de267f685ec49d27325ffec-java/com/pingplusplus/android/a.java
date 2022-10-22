package com.pingplusplus.android;

import android.os.Handler;
import android.os.Message;
import com.alipay.sdk.app.PayTask;
import com.unionpay.tsmservice.data.Constant;
import vk.c;
import vk.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f22085a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ PaymentActivity f22086b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PaymentActivity paymentActivity, String str) {
        this.f22086b = paymentActivity;
        this.f22085a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        try {
            PayTask payTask = new PayTask(this.f22086b);
            c.c("alipaysdk version: " + payTask.getVersion());
            String pay = payTask.pay(this.f22085a, true);
            c.c("PaymentActivity alipay result: " + pay);
            Message message = new Message();
            message.what = 1;
            message.obj = pay;
            handler = this.f22086b.f22084i;
            handler.sendMessage(message);
        } catch (NoClassDefFoundError e10) {
            e10.printStackTrace();
            String str = d.a().f35805b;
            this.f22086b.f(Constant.CASH_LOAD_FAIL, "channel_sdk_not_included:" + str, "不支持该渠道: " + str + "。缺少支付宝的 SDK。");
        }
    }
}
