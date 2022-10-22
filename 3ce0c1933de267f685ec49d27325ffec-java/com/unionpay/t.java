package com.unionpay;
/* loaded from: classes2.dex */
final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f24470a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f24471b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ z f24472c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ WebViewJavascriptBridge f24473d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(WebViewJavascriptBridge webViewJavascriptBridge, y yVar, String str, z zVar) {
        this.f24473d = webViewJavascriptBridge;
        this.f24470a = yVar;
        this.f24471b = str;
        this.f24472c = zVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        y yVar = this.f24470a;
        if (yVar != null) {
            yVar.a(this.f24471b, this.f24472c);
        }
    }
}
