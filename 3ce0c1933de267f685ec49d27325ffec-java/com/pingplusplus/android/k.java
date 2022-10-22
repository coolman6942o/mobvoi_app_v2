package com.pingplusplus.android;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import cmb.pb.util.CMBKeyboardFunc;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONException;
import org.json.JSONObject;
import vk.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f22115a;

    private k(g gVar) {
        this.f22115a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(g gVar, h hVar) {
        this(gVar);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        String str2;
        ProgressBar progressBar;
        boolean z10;
        PaymentActivity paymentActivity;
        boolean z11;
        WebView webView2;
        String str3;
        ImageView imageView;
        str2 = this.f22115a.f22109l;
        if ("fqlpay_wap".equals(str2) && str.contains("http://m.mall.fenqile.com/app/order/result/")) {
            imageView = this.f22115a.f22103f;
            imageView.setVisibility(0);
            webView.loadUrl("javascript:window.local_obj.showSource('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");
        }
        if (str.equals("file:///android_asset/pingpp_web.html")) {
            z11 = this.f22115a.f22110m;
            if (z11) {
                this.f22115a.f22110m = false;
                webView2 = this.f22115a.f22098a;
                str3 = this.f22115a.f22101d;
                webView2.loadUrl(str3);
                super.onPageFinished(webView, str);
            }
        }
        if (str.equals("file:///android_asset/pingpp_web.html")) {
            z10 = this.f22115a.f22110m;
            if (!z10) {
                paymentActivity = this.f22115a.f22099b;
                paymentActivity.onBackPressed();
                super.onPageFinished(webView, str);
            }
        }
        if (!str.equals("file:///android_asset/pingpp_web.html")) {
            progressBar = this.f22115a.f22104g;
            progressBar.setVisibility(8);
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        PaymentActivity paymentActivity;
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        if ("https://m.baifubao.com/".equals(str)) {
            paymentActivity = this.f22115a.f22099b;
            paymentActivity.onBackPressed();
        }
        super.onPageStarted(webView, str, bitmap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0091, code lost:
        if (r11.contains(r0) != false) goto L63;
     */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        JSONObject jSONObject;
        String str2;
        PaymentActivity paymentActivity;
        PaymentActivity paymentActivity2;
        JSONObject jSONObject2;
        PaymentActivity paymentActivity3;
        JSONObject jSONObject3;
        String str3;
        String str4;
        PaymentActivity paymentActivity4;
        WebView webView2;
        PaymentActivity paymentActivity5;
        WebView webView3;
        PaymentActivity paymentActivity6;
        WebView webView4;
        PaymentActivity paymentActivity7;
        PaymentActivity paymentActivity8;
        boolean z10;
        String str5;
        boolean z11;
        PaymentActivity paymentActivity9;
        PaymentActivity paymentActivity10;
        CharSequence charSequence;
        PaymentActivity paymentActivity11;
        PaymentActivity paymentActivity12;
        PaymentActivity paymentActivity13;
        PaymentActivity paymentActivity14;
        PaymentActivity unused;
        PaymentActivity unused2;
        jSONObject = this.f22115a.f22100c;
        if (str.contains(jSONObject.optJSONObject("credential").optString("page_url")) && str.contains("pay_result=1")) {
            paymentActivity13 = this.f22115a.f22099b;
            paymentActivity13.f22079d = Constant.CASH_LOAD_SUCCESS;
            paymentActivity14 = this.f22115a.f22099b;
            paymentActivity14.d(Constant.CASH_LOAD_SUCCESS);
        } else if (str.contains("pay_result=-1")) {
            paymentActivity11 = this.f22115a.f22099b;
            paymentActivity11.f22079d = Constant.CASH_LOAD_FAIL;
            paymentActivity12 = this.f22115a.f22099b;
            paymentActivity12.d(Constant.CASH_LOAD_FAIL);
        } else {
            if (!"https://www.baifubao.com/wap/0/wallet/0/transaction/0".equals(str)) {
                unused = this.f22115a.f22099b;
                if (!str.contains("https://ok.yeepay.com/paymobile/query/pay/success?")) {
                    unused2 = this.f22115a.f22099b;
                    if (!str.contains("http://mobiletest.yeepay.com/paymobile/query/pay/success?")) {
                        if (!"https://m.baifubao.com/".equals(str)) {
                            z10 = this.f22115a.f22108k;
                            if (z10) {
                                charSequence = this.f22115a.f22107j;
                            }
                            if (str.contains("http://wappass.baidu.com/passport/reg?") || str.contains("http://wappass.baidu.com/passport/getpass?") || str.contains("http://wappass.baidu.com/passport/agreement?") || "https://www.jdpay.com/".equals(str) || "http://wapzt.189.cn/pages/login/login_userLogin.html#/pages/password/passwordNoLogin.html".equals(str) || "https://uac.10010.com/cust/resetpwd/inputName".equals(str) || "http://bj.ac.10086.cn/login".equals(str) || str.startsWith("tel:")) {
                                this.f22115a.h(str);
                                return true;
                            } else if (str.startsWith("intent://")) {
                                return true;
                            } else {
                                if ("http://pingxx/?payResult=success".equals(str)) {
                                    paymentActivity10 = this.f22115a.f22099b;
                                    paymentActivity10.d(Constant.CASH_LOAD_SUCCESS);
                                    return true;
                                } else if (("http://m.mall.fenqile.com/".equals(str) || "http://m.fenqile.com/".equals(str)) && !str.contains("http://m.mall.fenqile.com/app/order/result/")) {
                                    paymentActivity9 = this.f22115a.f22099b;
                                    paymentActivity9.onBackPressed();
                                    return true;
                                } else {
                                    str5 = this.f22115a.f22109l;
                                    if ("fqlpay_wap".equals(str5)) {
                                        z11 = this.f22115a.f22111n;
                                        if (z11 && !str.contains("http://m.mall.fenqile.com/app/order/result/")) {
                                            this.f22115a.h(str);
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                        paymentActivity8 = this.f22115a.f22099b;
                        paymentActivity8.onBackPressed();
                    }
                }
            }
            paymentActivity7 = this.f22115a.f22099b;
            paymentActivity7.f22079d = Constant.CASH_LOAD_SUCCESS;
        }
        Object obj = null;
        try {
            jSONObject3 = this.f22115a.f22100c;
            JSONObject jSONObject4 = jSONObject3.getJSONObject("extra");
            str3 = this.f22115a.f22109l;
            if ("jdpay_wap".equals(str3)) {
                String string = jSONObject4.getString("success_url");
                String string2 = jSONObject4.getString("fail_url");
                c.c("jdPay url: " + str);
                c.c("jdPay successUrl: " + string);
                c.c("jdPay fail_url: " + string2);
                if (str.contains(string)) {
                    paymentActivity6 = this.f22115a.f22099b;
                    paymentActivity6.d(Constant.CASH_LOAD_SUCCESS);
                    webView4 = this.f22115a.f22098a;
                    webView4.destroy();
                    this.f22115a.f22098a = null;
                    c.c("jdPay success");
                    return true;
                } else if (str.contains(string2)) {
                    paymentActivity5 = this.f22115a.f22099b;
                    paymentActivity5.d(Constant.CASH_LOAD_FAIL);
                    webView3 = this.f22115a.f22098a;
                    webView3.destroy();
                    this.f22115a.f22098a = null;
                    c.c("jdPay fail");
                    return true;
                }
            } else {
                str4 = this.f22115a.f22109l;
                if ("yeepay_wap".equals(str4) && str.contains(jSONObject4.optString("result_url"))) {
                    paymentActivity4 = this.f22115a.f22099b;
                    paymentActivity4.d(Constant.CASH_LOAD_SUCCESS);
                    webView2 = this.f22115a.f22098a;
                    webView2.destroy();
                    this.f22115a.f22098a = null;
                    return true;
                }
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
            paymentActivity3 = this.f22115a.f22099b;
            paymentActivity3.f22079d = Constant.CASH_LOAD_FAIL;
        }
        str2 = this.f22115a.f22109l;
        if ("cmb_wallet".equals(str2)) {
            paymentActivity = this.f22115a.f22099b;
            if (new CMBKeyboardFunc(paymentActivity).HandleUrlCall(webView, str)) {
                return true;
            }
            try {
                jSONObject2 = this.f22115a.f22100c;
                obj = jSONObject2.optJSONObject("credential").optJSONObject("cmb_wallet").optString("MerchantRetUrl");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            if (str.equals(obj)) {
                this.f22115a.f22111n = true;
                paymentActivity2 = this.f22115a.f22099b;
                paymentActivity2.f22079d = Constant.CASH_LOAD_SUCCESS;
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
