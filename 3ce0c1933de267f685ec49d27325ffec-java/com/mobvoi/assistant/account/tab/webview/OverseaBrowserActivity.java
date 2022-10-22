package com.mobvoi.assistant.account.tab.webview;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.base.m3.d;
import com.unionpay.tsmservice.data.Constant;
import mb.c;
/* loaded from: classes2.dex */
public class OverseaBrowserActivity extends d {

    /* renamed from: a  reason: collision with root package name */
    private ProgressBar f15653a;

    /* renamed from: b  reason: collision with root package name */
    protected ScrollView f15654b;

    /* renamed from: c  reason: collision with root package name */
    protected FrameLayout f15655c;

    /* renamed from: d  reason: collision with root package name */
    protected WebView f15656d;

    /* renamed from: e  reason: collision with root package name */
    protected String f15657e = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("http:") || str.startsWith("https:")) {
                return false;
            }
            try {
                OverseaBrowserActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } catch (ActivityNotFoundException unused) {
                k.d("OverseaBrowserActivity", "Can not find activity to handle this uri.");
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends WebChromeClient {
        b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            OverseaBrowserActivity.this.f15653a.setProgress(i10);
            if (i10 == 100) {
                OverseaBrowserActivity.this.f15653a.setVisibility(8);
                OverseaBrowserActivity.this.f15654b.setVisibility(0);
                return;
            }
            OverseaBrowserActivity.this.f15653a.setVisibility(0);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            OverseaBrowserActivity.this.setTitle(webView.getTitle());
        }
    }

    public static void J(Context context, String str) {
        K(context, str, false);
    }

    public static void K(Context context, String str, boolean z10) {
        Intent intent = new Intent(context, OverseaBrowserActivity.class);
        intent.putExtra("browser_url", str);
        intent.putExtra(Constant.KEY_PARAMS, z10);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
        String stringExtra = getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f15657e = stringExtra;
        }
        String stringExtra2 = getIntent().getStringExtra("browser_url");
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.f15657e = stringExtra2;
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return mb.d.b_res_0x7f0e0046;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected void initView() {
        this.f15653a = (ProgressBar) findViewById(c.N);
        this.f15654b = (ScrollView) findViewById(c.U);
        this.f15655c = (FrameLayout) findViewById(c.r_res_0x7f0b029f);
        WebView webView = new WebView(this);
        this.f15656d = webView;
        this.f15655c.addView(webView);
        this.f15656d.requestFocus();
        this.f15656d.setHorizontalScrollBarEnabled(false);
        this.f15656d.setVerticalScrollBarEnabled(false);
        this.f15656d.setBackgroundColor(getResources().getColor(mb.a.f30620b));
        WebSettings settings = this.f15656d.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        this.f15656d.setWebViewClient(new a());
        this.f15656d.setWebChromeClient(new b());
        this.f15656d.loadUrl(this.f15657e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        I();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WebView webView = this.f15656d;
        if (webView != null) {
            webView.removeAllViews();
            this.f15656d.clearHistory();
            this.f15656d.clearCache(true);
            this.f15656d.destroy();
        }
    }

    @Override // androidx.appcompat.app.d, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4 || !this.f15656d.canGoBack()) {
            return super.onKeyDown(i10, keyEvent);
        }
        this.f15656d.goBack();
        return true;
    }

    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d
    public boolean onSupportNavigateUp() {
        if (!this.f15656d.canGoBack()) {
            return super.onSupportNavigateUp();
        }
        this.f15656d.goBack();
        return true;
    }
}
