package com.pingplusplus.android;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.unionpay.tsmservice.data.Constant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    WeakReference<PaymentActivity> f22089a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PaymentActivity paymentActivity) {
        this.f22089a = new WeakReference<>(paymentActivity);
    }

    private int a(String str) {
        return Integer.parseInt(b(str.replace("{", "").replace("}", ""), "resultStatus=", ";memo"));
    }

    private String b(String str, String str2, String str3) {
        int indexOf = str.indexOf(str2) + str2.length();
        return str3 != null ? str.substring(indexOf, str.indexOf(str3)) : str.substring(indexOf);
    }

    @Override // android.os.Handler
    @TargetApi(11)
    public void handleMessage(Message message) {
        JSONObject jSONObject;
        PaymentActivity paymentActivity = this.f22089a.get();
        int i10 = message.what;
        if (i10 == 1) {
            String str = (String) message.obj;
            try {
                int a10 = a(str);
                if (a10 == 9000) {
                    paymentActivity.d(Constant.CASH_LOAD_SUCCESS);
                } else if (a10 == 6001) {
                    paymentActivity.e(Constant.CASH_LOAD_CANCEL, "user_cancelled");
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("resultStatus");
                    arrayList.add(String.valueOf(a10));
                    paymentActivity.f(Constant.CASH_LOAD_FAIL, "channel_returns_fail", TextUtils.join(ContainerUtils.KEY_VALUE_DELIMITER, arrayList));
                }
            } catch (Exception unused) {
                paymentActivity.f(Constant.CASH_LOAD_FAIL, "channel_returns_fail", str);
            }
        } else if (i10 == 2) {
            paymentActivity.d(Constant.CASH_LOAD_SUCCESS);
        } else if (i10 == 3) {
        } else {
            if (i10 != 4) {
                paymentActivity.e(Constant.CASH_LOAD_FAIL, "testmode_notify_failed");
                return;
            }
            jSONObject = paymentActivity.f22080e;
            new g(paymentActivity, jSONObject, (String) message.obj, null).c(true).d();
        }
    }
}
