package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.net.c;
import com.unionpay.mobile.android.net.d;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class n extends UPPayEngine {

    /* renamed from: b  reason: collision with root package name */
    private Context f24158b;

    public n(Context context) {
        super(context);
        this.f24158b = context;
    }

    @Override // com.unionpay.mobile.android.nocard.utils.UPPayEngine, com.unionpay.mobile.android.fully.a
    public final String a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("reqtm", UPPayEngine.i());
            str = jSONObject.toString();
        } catch (JSONException unused) {
        }
        k.c("uppay", "post message = " + str);
        String e10 = e(str);
        d d10 = d();
        if (d10 != null) {
            try {
                d10.a(e10);
                HashMap<String, String> hashMap = new HashMap<>(1);
                hashMap.put("sid", f());
                d10.a(hashMap);
                g();
                if (this.f23569a == null) {
                    this.f23569a = new c(d10, this.f24158b);
                }
                int a10 = this.f23569a.a();
                String b10 = this.f23569a.b();
                if (a10 == 0) {
                    String f10 = f(b10);
                    k.a("uppay", "[ response msg ] " + f10);
                    return f10;
                }
                Handler e11 = e();
                if (e11 != null) {
                    Message obtainMessage = e11.obtainMessage(2);
                    obtainMessage.arg1 = a10;
                    e11.sendMessage(obtainMessage);
                }
            } catch (Exception unused2) {
            }
        }
        return null;
    }
}
