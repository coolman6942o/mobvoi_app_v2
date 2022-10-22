package com.unionpay;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;
/* loaded from: classes2.dex */
final class w extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebViewJavascriptBridge f24594a;

    private w(WebViewJavascriptBridge webViewJavascriptBridge) {
        this.f24594a = webViewJavascriptBridge;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(WebViewJavascriptBridge webViewJavascriptBridge, byte b10) {
        this(webViewJavascriptBridge);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.cancel();
        Toast.makeText(this.f24594a.mContext, str2, 0).show();
        return true;
    }
}
