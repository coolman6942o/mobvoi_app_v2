package com.pingplusplus.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: o  reason: collision with root package name */
    public static ValueCallback<Uri> f22096o;

    /* renamed from: p  reason: collision with root package name */
    public static ValueCallback<Uri[]> f22097p;

    /* renamed from: a  reason: collision with root package name */
    private WebView f22098a;

    /* renamed from: b  reason: collision with root package name */
    private PaymentActivity f22099b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f22100c;

    /* renamed from: d  reason: collision with root package name */
    private String f22101d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f22102e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f22103f;

    /* renamed from: g  reason: collision with root package name */
    private ProgressBar f22104g;

    /* renamed from: h  reason: collision with root package name */
    private FrameLayout f22105h;

    /* renamed from: i  reason: collision with root package name */
    private View f22106i;

    /* renamed from: j  reason: collision with root package name */
    private String f22107j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f22108k;

    /* renamed from: l  reason: collision with root package name */
    private String f22109l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f22110m = true;

    /* renamed from: n  reason: collision with root package name */
    private boolean f22111n;

    public g(Activity activity, JSONObject jSONObject, String str, byte[] bArr) {
        this.f22098a = new WebView(activity);
        this.f22099b = (PaymentActivity) activity;
        this.f22101d = str;
        this.f22102e = bArr;
        this.f22100c = jSONObject;
        this.f22106i = LayoutInflater.from(activity).inflate(activity.getResources().getIdentifier("activity_pingpp_payment", "layout", activity.getPackageName()), (ViewGroup) null);
        this.f22098a = (WebView) this.f22106i.findViewById(activity.getResources().getIdentifier("pingpp_webView", "id", activity.getPackageName()));
        this.f22104g = (ProgressBar) this.f22106i.findViewById(activity.getResources().getIdentifier("pingpp_progressbar", "id", activity.getPackageName()));
        this.f22105h = (FrameLayout) this.f22106i.findViewById(activity.getResources().getIdentifier("pingpp_title", "id", activity.getPackageName()));
        ImageView imageView = (ImageView) this.f22106i.findViewById(activity.getResources().getIdentifier("pingpp_back", "id", activity.getPackageName()));
        this.f22103f = imageView;
        imageView.setOnClickListener(new h(this));
        p();
        this.f22109l = jSONObject.optString("channel");
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ValueCallback<Uri[]> valueCallback) {
        f22097p = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        Intent intent2 = new Intent("android.intent.action.CHOOSER");
        intent2.putExtra("android.intent.extra.INTENT", intent);
        intent2.putExtra("android.intent.extra.TITLE", "Image Chooser");
        this.f22099b.startActivityForResult(intent2, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            this.f22099b.startActivity(intent);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void n() {
        if ("cmb_wallet".equals(this.f22109l)) {
            try {
                CookieSyncManager.createInstance(this.f22099b.getApplicationContext());
                CookieManager.getInstance().removeAllCookie();
                CookieSyncManager.getInstance().sync();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        j();
        this.f22098a.setWebViewClient(new k(this, null));
        this.f22098a.setWebChromeClient(new j(this, null));
    }

    @TargetApi(11)
    private void p() {
        WebSettings settings = this.f22098a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setSupportZoom(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setUserAgentString(String.format("%s; %s/%s", settings.getUserAgentString(), "PingppAndroidSDK", "2.1.4"));
        this.f22098a.addJavascriptInterface(new l(this, this.f22099b), "PingppAndroidSDK");
        this.f22098a.addJavascriptInterface(new l(this, this.f22099b), "PingppSDK");
        this.f22098a.addJavascriptInterface(new i(this), "local_obj");
        this.f22098a.removeJavascriptInterface("searchBoxJavaBridge_");
    }

    public g c(boolean z10) {
        ImageView imageView;
        int i10;
        if (z10) {
            imageView = this.f22103f;
            i10 = 8;
        } else {
            imageView = this.f22103f;
            i10 = 0;
        }
        imageView.setVisibility(i10);
        return this;
    }

    public void d() {
        String str;
        WebView webView;
        this.f22099b.setContentView(this.f22106i);
        byte[] bArr = this.f22102e;
        if (bArr == null) {
            if (this.f22109l.equals("jdpay_wap") || this.f22109l.equals("bfb_wap") || this.f22109l.equals("fqlpay_wap")) {
                webView = this.f22098a;
                str = "file:///android_asset/pingpp_web.html";
            } else {
                webView = this.f22098a;
                str = this.f22101d;
            }
            webView.loadUrl(str);
            return;
        }
        this.f22098a.postUrl(this.f22101d, bArr);
    }

    public void j() {
        FrameLayout frameLayout;
        Resources resources;
        String packageName;
        String str;
        if ("fqlpay_wap".equals(this.f22109l)) {
            frameLayout = this.f22105h;
            resources = this.f22099b.getResources();
            packageName = this.f22099b.getPackageName();
            str = "fqlpay_wap_color";
        } else if ("mmdpay_wap".equals(this.f22109l)) {
            frameLayout = this.f22105h;
            resources = this.f22099b.getResources();
            packageName = this.f22099b.getPackageName();
            str = "mmdpay_wap_color";
        } else if ("qgbc_wap".equals(this.f22109l)) {
            frameLayout = this.f22105h;
            resources = this.f22099b.getResources();
            packageName = this.f22099b.getPackageName();
            str = "qgbc_wap_color";
        } else {
            return;
        }
        frameLayout.setBackgroundResource(resources.getIdentifier(str, "color", packageName));
    }
}
