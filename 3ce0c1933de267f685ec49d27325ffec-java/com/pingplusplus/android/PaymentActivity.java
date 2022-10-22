package com.pingplusplus.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.app.a;
import androidx.core.content.b;
import com.baidu.paysdk.api.BaiduPay;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.openpay.api.IOpenApi;
import com.tencent.mobileqq.openpay.data.pay.PayApi;
import com.unionpay.UPPayAssistEx;
import com.unionpay.tsmservice.data.Constant;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
import vk.c;
import vk.d;
import vk.i;
/* loaded from: classes2.dex */
public class PaymentActivity extends Activity {

    /* renamed from: j  reason: collision with root package name */
    private static final String[] f22075j = {"alipay", "wx", "upacp", "upmp", "bfb", "yeepay_wap", "jdpay_wap", "bfb_wap", "qpay", "mmdpay_wap", "fqlpay_wap", "qgbc_wap", "cmb_wallet"};

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f22080e;

    /* renamed from: a  reason: collision with root package name */
    private String f22076a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f22077b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f22078c = 0;

    /* renamed from: d  reason: collision with root package name */
    protected String f22079d = Constant.CASH_LOAD_CANCEL;

    /* renamed from: f  reason: collision with root package name */
    private m f22081f = null;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22082g = false;

    /* renamed from: h  reason: collision with root package name */
    int f22083h = 1;

    /* renamed from: i  reason: collision with root package name */
    private Handler f22084i = new d(this);

    private void g(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("alipay");
        c.c("PaymentActivity start alipay credential : " + jSONObject);
        new a(this, jSONObject2.getString("orderInfo")).start();
    }

    @TargetApi(11)
    private void h(JSONObject jSONObject, String str) {
        String optString = jSONObject.optString(str);
        if ("fqlpay_wap".equals(str)) {
            new g(this, this.f22080e, optString, null).c(true).d();
        } else {
            new g(this, this.f22080e, optString, null).d();
        }
    }

    private boolean i(JSONObject jSONObject, String str, String str2) {
        return (str2 == null || str2.equals(str)) && jSONObject.has(str) && !jSONObject.getString(str).equals("[]") && !jSONObject.getString(str).equals("{}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpsURLConnection j(String str) {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setRequestMethod("GET");
        return httpsURLConnection;
    }

    @TargetApi(11)
    private void l(String str, String str2) {
        c.c("模拟支付页面: 支付渠道 " + str2);
        String format = String.format("http://sissi.pingxx.com/mock.php?ch_id=%s&channel=%s", str, str2);
        c.b(format);
        new g(this, this.f22080e, format, null).d();
    }

    private void m(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("wx");
        c.c("PaymentActivity start wx credential : " + jSONObject);
        String string = jSONObject2.getString("appId");
        d.a().f35804a = string;
        try {
            this.f22081f = new m(this, string);
            d a10 = d.a();
            m mVar = this.f22081f;
            a10.f35806c = mVar;
            if (!mVar.d()) {
                e("invalid", "wx_app_not_installed");
                return;
            }
            if (this.f22081f.e() >= 570425345) {
                this.f22077b = 1;
                this.f22081f.c(jSONObject2);
                return;
            }
            e(Constant.CASH_LOAD_FAIL, "wx_app_not_support");
        } catch (NoClassDefFoundError e10) {
            e10.printStackTrace();
            String str = d.a().f35805b;
            f(Constant.CASH_LOAD_FAIL, "channel_sdk_not_included:" + str, "不支持该渠道: " + str + "。缺少微信的 SDK。");
        }
    }

    private void n(JSONObject jSONObject) {
        String str;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("qpay");
            c.c("PaymentActivity start qpay credential : " + jSONObject);
            String string = jSONObject2.getString("app_id");
            d.a().f35807d = f.a(this, string);
            IOpenApi b10 = d.a().f35807d.b();
            if (!b10.isMobileQQInstalled()) {
                e("invalid", "qq_app_not_installed");
            } else if (!b10.isMobileQQSupportApi("pay")) {
                e(Constant.CASH_LOAD_FAIL, "qq_app_not_support");
            } else {
                PayApi payApi = new PayApi();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                int i10 = this.f22083h;
                this.f22083h = i10 + 1;
                sb2.append(i10);
                payApi.serialNumber = sb2.toString();
                if (d.a().f35811h == null) {
                    str = "qwallet" + string;
                } else {
                    str = d.a().f35811h;
                }
                payApi.callbackScheme = str;
                payApi.pubAcc = "";
                payApi.pubAccHint = "";
                payApi.timeStamp = System.currentTimeMillis() / 1000;
                payApi.sigType = "HMAC-SHA1";
                payApi.bargainorId = jSONObject2.optString("bargainor_id");
                payApi.appId = string;
                payApi.nonce = jSONObject2.optString("nonce");
                payApi.sig = jSONObject2.optString("sign");
                payApi.tokenId = jSONObject2.optString("token_id");
                if (payApi.checkParams()) {
                    b10.execApi(payApi);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void o(JSONObject jSONObject) {
        if (Build.VERSION.SDK_INT >= 23) {
            c.c("Checking permissions...");
            try {
                if (b.a(this, "android.permission.READ_PHONE_STATE") != 0) {
                    if (a.w(this, "android.permission.READ_PHONE_STATE")) {
                        Toast.makeText(this, "使用银联支付，请接受以下权限", 0).show();
                    }
                    a.s(this, new String[]{"android.permission.READ_PHONE_STATE"}, 101);
                    return;
                }
            } catch (NoClassDefFoundError e10) {
                e10.printStackTrace();
                f(Constant.CASH_LOAD_FAIL, "client_error", "请使用最新的 Android v4 Support Library，Android 6.0 以上需要申请权限");
                return;
            }
        }
        p(jSONObject);
    }

    private void p(JSONObject jSONObject) {
        String str;
        StringBuilder sb2;
        JSONObject jSONObject2;
        if (jSONObject.has("upacp")) {
            jSONObject2 = jSONObject.getJSONObject("upacp");
            sb2 = new StringBuilder();
            str = "PaymentActivity start upacp credential : ";
        } else {
            jSONObject2 = jSONObject.getJSONObject("upmp");
            sb2 = new StringBuilder();
            str = "PaymentActivity start upmp credential : ";
        }
        sb2.append(str);
        sb2.append(jSONObject);
        c.c(sb2.toString());
        try {
            UPPayAssistEx.startPay(this, null, null, jSONObject2.getString("tn"), jSONObject2.getString("mode"));
        } catch (NoClassDefFoundError e10) {
            e10.printStackTrace();
            String str2 = d.a().f35805b;
            f(Constant.CASH_LOAD_FAIL, "channel_sdk_not_included:" + str2, "不支持该渠道: " + str2 + "。缺少银联的 SDK。");
        }
    }

    private void q(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("bfb");
        c.c("PaymentActivity start bfb credential : " + jSONObject);
        try {
            BaiduPay.getInstance();
            HashMap hashMap = new HashMap();
            hashMap.put("cashier_type", "0");
            ArrayList arrayList = new ArrayList();
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(next);
                arrayList2.add(jSONObject2.getString(next));
                arrayList.add(TextUtils.join(ContainerUtils.KEY_VALUE_DELIMITER, arrayList2));
            }
            if (arrayList.size() == 0) {
                e(Constant.CASH_LOAD_FAIL, "invalid_credential");
                return;
            }
            String join = TextUtils.join(ContainerUtils.FIELD_DELIMITER, arrayList);
            this.f22078c = 1;
            BaiduPay.getInstance().doPay(this, join, new b(this), hashMap);
        } catch (NoClassDefFoundError e10) {
            e10.printStackTrace();
            String str = d.a().f35805b;
            f(Constant.CASH_LOAD_FAIL, "channel_sdk_not_included:" + str, "不支持该渠道: " + str + "。缺少百度钱包的 SDK。");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    @TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void r(JSONObject jSONObject) {
        String str;
        String str2;
        UnsupportedEncodingException e10;
        JSONObject jSONObject2 = jSONObject.getJSONObject("yeepay_wap");
        c.c("PaymentActivity start yeepay_wap credential : " + jSONObject);
        String string = jSONObject2.getString("merchantaccount");
        try {
            str = URLEncoder.encode(jSONObject2.getString("encryptkey"), "UTF-8");
            try {
                str2 = URLEncoder.encode(jSONObject2.getString("data"), "UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e10 = e11;
                e10.printStackTrace();
                str2 = null;
                new g(this, this.f22080e, String.format(!"live".equals(jSONObject2.getString("mode")) ? "https://ok.yeepay.com/paymobile/api/pay/request?merchantaccount=%s&encryptkey=%s&data=%s" : "http://mobiletest.yeepay.com/paymobile/api/pay/request?merchantaccount=%s&encryptkey=%s&data=%s", string, str, str2), null).d();
            }
        } catch (UnsupportedEncodingException e12) {
            e10 = e12;
            str = null;
        }
        new g(this, this.f22080e, String.format(!"live".equals(jSONObject2.getString("mode")) ? "https://ok.yeepay.com/paymobile/api/pay/request?merchantaccount=%s&encryptkey=%s&data=%s" : "http://mobiletest.yeepay.com/paymobile/api/pay/request?merchantaccount=%s&encryptkey=%s&data=%s", string, str, str2), null).d();
    }

    @TargetApi(11)
    private void s(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("bfb_wap");
        String optString = jSONObject2.optString("url");
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!"url".equals(next)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(next);
                arrayList2.add(jSONObject2.getString(next));
                arrayList.add(TextUtils.join(ContainerUtils.KEY_VALUE_DELIMITER, arrayList2));
            }
        }
        if (arrayList.size() == 0) {
            e(Constant.CASH_LOAD_FAIL, "invalid_credential");
            return;
        }
        String join = TextUtils.join(ContainerUtils.FIELD_DELIMITER, arrayList);
        JSONObject jSONObject3 = this.f22080e;
        new g(this, jSONObject3, optString + "?" + join, null).c(true).d();
    }

    private void t(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("qgbc_wap");
        if (optJSONObject != null) {
            new Thread(new c(this, optJSONObject.optString("url"))).start();
        }
    }

    @TargetApi(11)
    private void u(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("jdpay_wap");
        c.c("PaymentActivity start jdpay_wap credential : " + jSONObject);
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(next);
            try {
                arrayList2.add(URLEncoder.encode(jSONObject2.getString(next), "UTF-8"));
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
            }
            arrayList.add(TextUtils.join(ContainerUtils.KEY_VALUE_DELIMITER, arrayList2));
        }
        if (arrayList.size() == 0) {
            e(Constant.CASH_LOAD_FAIL, "invalid_credential");
            return;
        }
        String join = TextUtils.join(ContainerUtils.FIELD_DELIMITER, arrayList);
        c.c("jdPay orderInfo: " + join);
        JSONObject jSONObject3 = this.f22080e;
        new g(this, jSONObject3, "https://m.jdpay.com/wepay/web/pay?" + join, null).c(true).d();
    }

    private void v(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("cmb_wallet");
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = optJSONObject.keys();
        String str = null;
        while (keys.hasNext()) {
            String next = keys.next();
            if ("ChannelUrl".equalsIgnoreCase(next)) {
                str = optJSONObject.optString(next);
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(next);
                try {
                    arrayList2.add(URLEncoder.encode(optJSONObject.getString(next), "UTF-8"));
                } catch (UnsupportedEncodingException e10) {
                    e10.printStackTrace();
                }
                arrayList.add(TextUtils.join(ContainerUtils.KEY_VALUE_DELIMITER, arrayList2));
            }
        }
        if (arrayList.size() == 0) {
            e(Constant.CASH_LOAD_FAIL, "invalid_credential");
            return;
        }
        String join = TextUtils.join(ContainerUtils.FIELD_DELIMITER, arrayList);
        new g(this, this.f22080e, str + "?" + join, null).c(false).d();
    }

    public void c() {
        int i10 = d.a().f35808e;
        if (i10 == 0) {
            d(Constant.CASH_LOAD_SUCCESS);
        } else if (i10 == -2) {
            e(Constant.CASH_LOAD_CANCEL, "user_cancelled");
        } else {
            f(Constant.CASH_LOAD_FAIL, "channel_returns_fail", "wx_err_code:" + i10);
        }
        d.a().f35808e = -10;
    }

    public void d(String str) {
        e(str, "");
    }

    public void e(String str, String str2) {
        f(str, str2, "");
    }

    public void f(String str, String str2, String str3) {
        c.b("setResultAndFinish result=" + str + " isWXPayEntryActivity=" + this.f22082g);
        d.a().f35805b = null;
        d.a().f35806c = null;
        Intent intent = new Intent();
        intent.putExtra("pay_result", str);
        intent.putExtra("error_msg", str2);
        intent.putExtra("extra_msg", str3);
        setResult(-1, intent);
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i10, int i11, Intent intent) {
        String str;
        if (i10 == 1) {
            if (g.f22096o != null) {
                g.f22096o.onReceiveValue((intent == null || i11 != -1) ? null : intent.getData());
                g.f22096o = null;
            } else {
                return;
            }
        } else if (i10 == 2) {
            if (g.f22097p != null) {
                Uri data = (intent == null || i11 != -1) ? null : intent.getData();
                if (data != null) {
                    g.f22097p.onReceiveValue(new Uri[]{data});
                } else {
                    g.f22097p.onReceiveValue(new Uri[0]);
                }
                g.f22097p = null;
            } else {
                return;
            }
        }
        if (i10 == 16) {
            d(Constant.CASH_LOAD_SUCCESS);
        }
        super.onActivityResult(i10, i11, intent);
        if (d.a().f35805b != null && !d.a().f35805b.equalsIgnoreCase("upmp") && !d.a().f35805b.equalsIgnoreCase("upacp")) {
            return;
        }
        if (intent == null) {
            e(Constant.CASH_LOAD_FAIL, "");
            return;
        }
        String string = intent.getExtras().getString("pay_result");
        if (string == null) {
            d(Constant.CASH_LOAD_FAIL);
        } else if (string.equalsIgnoreCase(Constant.CASH_LOAD_SUCCESS)) {
            d(Constant.CASH_LOAD_SUCCESS);
        } else {
            if (string.equalsIgnoreCase(Constant.CASH_LOAD_FAIL)) {
                str = "channel_returns_fail";
            } else if (string.equalsIgnoreCase(Constant.CASH_LOAD_CANCEL)) {
                e(Constant.CASH_LOAD_CANCEL, "user_cancelled");
                return;
            } else {
                str = "unknown_error";
            }
            e(Constant.CASH_LOAD_FAIL, str);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        d.a().f35805b = null;
        Intent intent = new Intent();
        intent.putExtra("pay_result", this.f22079d);
        setResult(-1, intent);
        super.onBackPressed();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b9  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onCreate(Bundle bundle) {
        JSONObject jSONObject;
        super.onCreate(bundle);
        c.b("onCreate");
        if (bundle == null) {
            this.f22080e = null;
            String stringExtra = getIntent().getStringExtra("com.pingplusplus.android.PaymentActivity.CHARGE");
            if (stringExtra != null) {
                c.c("PaymentActivity received charge: " + stringExtra);
                try {
                    this.f22080e = new JSONObject(stringExtra);
                    if (d.a().f35810g) {
                        d.a().f35809f.b(e.ONE);
                        d.a().f35809f.d(this.f22080e);
                    } else {
                        vk.b bVar = new vk.b(this);
                        bVar.d(this.f22080e);
                        bVar.b(e.SDK);
                        bVar.m();
                    }
                } catch (JSONException unused) {
                    e(Constant.CASH_LOAD_FAIL, "invalid_charge_json_decode_fail");
                }
                if (this.f22080e.has("credential")) {
                    this.f22076a = this.f22080e.getString("channel");
                    if (!this.f22080e.has("livemode") || this.f22080e.getBoolean("livemode")) {
                        jSONObject = this.f22080e.getJSONObject("credential");
                        if (jSONObject == null) {
                            d.a().f35805b = this.f22076a;
                            c.c("PaymentActivity received channel: " + this.f22076a);
                            if (!Arrays.asList(f22075j).contains(this.f22076a)) {
                                d.a().f35805b = null;
                                e(Constant.CASH_LOAD_FAIL, "invalid_charge_no_such_channel");
                                return;
                            }
                            try {
                                if (!i(jSONObject, "upmp", this.f22076a) && !i(jSONObject, "upacp", this.f22076a)) {
                                    if (i(jSONObject, "wx", this.f22076a)) {
                                        m(jSONObject);
                                    } else if (i(jSONObject, "alipay", this.f22076a)) {
                                        g(jSONObject);
                                    } else if (i(jSONObject, "bfb", this.f22076a)) {
                                        q(jSONObject);
                                    } else if (i(jSONObject, "bfb_wap", this.f22076a)) {
                                        s(jSONObject);
                                    } else if (i(jSONObject, "yeepay_wap", this.f22076a)) {
                                        r(jSONObject);
                                    } else if (i(jSONObject, "jdpay_wap", this.f22076a)) {
                                        u(jSONObject);
                                    } else if (i(jSONObject, "qpay", this.f22076a)) {
                                        n(jSONObject);
                                    } else {
                                        if (!i(jSONObject, "mmdpay_wap", this.f22076a) && !i(jSONObject, "fqlpay_wap", this.f22076a)) {
                                            if (i(jSONObject, "qgbc_wap", this.f22076a)) {
                                                t(jSONObject);
                                            } else if (i(jSONObject, "cmb_wallet", this.f22076a)) {
                                                v(jSONObject);
                                            } else {
                                                d.a().f35805b = null;
                                                e(Constant.CASH_LOAD_FAIL, "invalid_credential");
                                            }
                                        }
                                        h(jSONObject, this.f22076a);
                                    }
                                    return;
                                }
                                o(jSONObject);
                                return;
                            } catch (JSONException unused2) {
                                d.a().f35805b = null;
                                e(Constant.CASH_LOAD_FAIL, "invalid_credential");
                                return;
                            }
                        } else if (d.a().f35804a != null) {
                            c.b("isWXPayEntryActivity");
                            this.f22082g = true;
                            m mVar = d.a().f35806c;
                            this.f22081f = mVar;
                            if (mVar != null) {
                                mVar.b(this);
                                this.f22081f.a(getIntent());
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else {
                        l(this.f22080e.getString("id"), this.f22076a);
                        return;
                    }
                } else {
                    e(Constant.CASH_LOAD_FAIL, "invalid_charge_no_credential");
                }
            }
            jSONObject = null;
            if (jSONObject == null) {
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        if (d.a().f35807d != null) {
            d.a().f35807d.c();
            d.a().f35811h = null;
        }
        super.onDestroy();
        c.b("onDestroy isWXPayEntryActivity=" + this.f22082g);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        c.b("onNewIntent isWXPayEntryActivity=" + this.f22082g);
        if (this.f22081f != null) {
            setIntent(intent);
            this.f22081f.a(getIntent());
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.f22077b == 1) {
            this.f22077b = 2;
        } else if (this.f22078c == 1 && d.a().f35805b != null && d.a().f35805b.equalsIgnoreCase("bfb")) {
            this.f22078c = 2;
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (i10 == 101) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                f(Constant.CASH_LOAD_FAIL, "permission_denied", "银联渠道所需权限被用户拒绝");
                return;
            }
            i.e(this).j(this);
            try {
                p(this.f22080e.getJSONObject("credential"));
            } catch (JSONException e10) {
                e10.printStackTrace();
                e(Constant.CASH_LOAD_FAIL, "invalid_charge_no_credential");
            }
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        c.b("onResume wxPayStatus=" + this.f22077b + " isWXPayEntryActivity=" + this.f22082g);
        int i10 = this.f22077b;
        if (i10 == 2 || this.f22078c == 2) {
            e(Constant.CASH_LOAD_CANCEL, "user_cancelled");
        } else if (i10 == 0 && d.a().f35808e != -10 && d.a().f35805b.equals("wx")) {
            c();
        }
    }
}
