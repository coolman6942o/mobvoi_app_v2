package com.unionpay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f24575a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ WebViewJavascriptBridge f24576b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(WebViewJavascriptBridge webViewJavascriptBridge, String str) {
        this.f24576b = webViewJavascriptBridge;
        this.f24575a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f24576b.mWebView.loadUrl(this.f24575a);
    }
}
