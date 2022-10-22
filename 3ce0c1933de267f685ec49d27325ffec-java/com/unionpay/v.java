package com.unionpay;
/* loaded from: classes2.dex */
final class v implements z {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebViewJavascriptBridge f24592a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24593b;

    public v(WebViewJavascriptBridge webViewJavascriptBridge, String str) {
        this.f24592a = webViewJavascriptBridge;
        this.f24593b = str;
    }

    @Override // com.unionpay.z
    public final void a(String str) {
        this.f24592a._callbackJs(this.f24593b, str);
    }
}
