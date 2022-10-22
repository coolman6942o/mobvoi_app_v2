package com.unionpay;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.unionpay.utils.j;
/* loaded from: classes2.dex */
final class x extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebViewJavascriptBridge f24595a;

    private x(WebViewJavascriptBridge webViewJavascriptBridge) {
        this.f24595a = webViewJavascriptBridge;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x(WebViewJavascriptBridge webViewJavascriptBridge, byte b10) {
        this(webViewJavascriptBridge);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        j.a("test", "onPageFinished");
    }
}
