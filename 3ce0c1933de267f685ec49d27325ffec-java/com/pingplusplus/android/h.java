package com.pingplusplus.android;

import android.view.View;
import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f22112a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f22112a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebView webView;
        PaymentActivity paymentActivity;
        WebView webView2;
        boolean z10;
        WebView webView3;
        webView = this.f22112a.f22098a;
        if (webView != null) {
            webView2 = this.f22112a.f22098a;
            if (webView2.canGoBack()) {
                z10 = this.f22112a.f22111n;
                if (!z10) {
                    webView3 = this.f22112a.f22098a;
                    webView3.goBack();
                    return;
                }
            }
        }
        paymentActivity = this.f22112a.f22099b;
        paymentActivity.onBackPressed();
    }
}
