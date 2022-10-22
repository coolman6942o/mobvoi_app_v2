package com.pingplusplus.android;

import android.content.Intent;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import org.json.JSONObject;
import vk.c;
/* loaded from: classes2.dex */
public class m implements IWXAPIEventHandler {

    /* renamed from: a  reason: collision with root package name */
    private PaymentActivity f22117a;

    /* renamed from: b  reason: collision with root package name */
    private IWXAPI f22118b;

    public m(PaymentActivity paymentActivity, String str) {
        this.f22118b = null;
        this.f22117a = paymentActivity;
        this.f22118b = WXAPIFactory.createWXAPI(paymentActivity.getApplicationContext(), str);
    }

    public void a(Intent intent) {
        this.f22118b.handleIntent(intent, this);
    }

    public void b(PaymentActivity paymentActivity) {
        if (!paymentActivity.equals(this.f22117a)) {
            c.b("wxPayEnActivity not equals paymentActivity");
        }
    }

    public void c(JSONObject jSONObject) {
        String str;
        String string = jSONObject.getString("appId");
        this.f22118b.registerApp(string);
        this.f22118b.handleIntent(this.f22117a.getIntent(), this);
        PayReq payReq = new PayReq();
        payReq.appId = string;
        payReq.partnerId = jSONObject.getString("partnerId");
        payReq.prepayId = jSONObject.getString("prepayId");
        payReq.nonceStr = jSONObject.getString("nonceStr");
        if (jSONObject.get("timeStamp") instanceof String) {
            str = jSONObject.getString("timeStamp");
        } else {
            str = jSONObject.getInt("timeStamp") + "";
        }
        payReq.timeStamp = str;
        payReq.packageValue = jSONObject.getString("packageValue");
        payReq.sign = jSONObject.getString("sign");
        this.f22118b.sendReq(payReq);
    }

    public boolean d() {
        return this.f22118b.isWXAppInstalled();
    }

    public int e() {
        return this.f22118b.getWXAppSupportAPI();
    }
}
