package com.pingplusplus.android;

import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f22114a;

    private j(g gVar) {
        this.f22114a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(g gVar, h hVar) {
        this(gVar);
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        PaymentActivity paymentActivity;
        super.onCloseWindow(webView);
        webView.destroy();
        paymentActivity = this.f22114a.f22099b;
        paymentActivity.onBackPressed();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        this.f22114a.e(valueCallback);
        return true;
    }
}
