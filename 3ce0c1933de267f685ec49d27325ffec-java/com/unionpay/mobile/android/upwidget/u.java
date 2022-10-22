package com.unionpay.mobile.android.upwidget;

import android.os.Handler;
import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class u implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPScrollView f24130a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(UPScrollView uPScrollView) {
        this.f24130a = uPScrollView;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Handler handler;
        Handler handler2;
        handler = this.f24130a.f24019d;
        handler2 = this.f24130a.f24019d;
        handler.sendMessageDelayed(handler2.obtainMessage(), 5L);
    }
}
