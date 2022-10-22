package com.mobvoi.companion.aw.ui.main;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.aw.R;
/* loaded from: classes2.dex */
public class StoreTabFragment extends com.mobvoi.companion.aw.ui.main.b {

    /* renamed from: b  reason: collision with root package name */
    private WebView f16293b;
    @BindView
    FrameLayout mFrameLayout;
    @BindView
    ProgressBar mProgressBar;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("http:") || str.startsWith("https:")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (StoreTabFragment.this.isDetached()) {
                return false;
            }
            try {
                StoreTabFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } catch (ActivityNotFoundException unused) {
                k.a("StoreTabFragment", "Can not find activity to handle this uri.");
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
            ProgressBar progressBar = StoreTabFragment.this.mProgressBar;
            if (progressBar != null) {
                progressBar.setProgress(i10);
                if (i10 == 100) {
                    StoreTabFragment.this.mProgressBar.setVisibility(8);
                } else {
                    StoreTabFragment.this.mProgressBar.setVisibility(0);
                }
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void a0() {
        k.h("StoreTabFragment", " initView ");
        WebView webView = new WebView(getActivity());
        this.f16293b = webView;
        this.mFrameLayout.addView(webView);
        this.f16293b.requestFocus();
        this.f16293b.setHorizontalScrollBarEnabled(false);
        this.f16293b.setVerticalScrollBarEnabled(false);
        WebSettings settings = this.f16293b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 21) {
            settings.setMixedContentMode(0);
        }
        this.f16293b.setWebViewClient(new a());
        this.f16293b.setWebChromeClient(new b());
        this.f16293b.setOnKeyListener(new View.OnKeyListener() { // from class: com.mobvoi.companion.aw.ui.main.q
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i11, KeyEvent keyEvent) {
                boolean b02;
                b02 = StoreTabFragment.this.b0(view, i11, keyEvent);
                return b02;
            }
        });
        String string = getArguments().getString("store_args");
        k.h("StoreTabFragment", " initView storeUrl = " + string);
        if (TextUtils.isEmpty(string)) {
            string = "https://www.mobvoi.com?utm_source=mobvoiapp&utm_medium=app&utm_campaign=mobvoiapp";
        }
        if (i10 < 21) {
            CookieSyncManager.createInstance(getActivity());
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.removeAllCookie();
            String s10 = ta.a.s();
            if (!TextUtils.isEmpty(s10)) {
                cookieManager.setCookie(string, "ww_token=" + s10);
            }
            CookieSyncManager.getInstance().sync();
        }
        this.f16293b.loadUrl(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b0(View view, int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return false;
        }
        getActivity().finish();
        return true;
    }

    @Override // com.mobvoi.companion.aw.ui.main.b
    protected int Y() {
        return R.layout.fragment_store_tab;
    }

    @Override // com.mobvoi.companion.aw.ui.main.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        WebView webView = this.f16293b;
        if (webView != null) {
            webView.removeAllViews();
            this.f16293b.clearHistory();
            this.f16293b.clearCache(false);
            this.f16293b.pauseTimers();
            this.f16293b.destroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a0();
    }
}
