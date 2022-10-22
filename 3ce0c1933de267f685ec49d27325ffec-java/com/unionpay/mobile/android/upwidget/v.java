package com.unionpay.mobile.android.upwidget;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.upwidget.UPScrollView;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class v extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPScrollView f24131a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(UPScrollView uPScrollView) {
        this.f24131a = uPScrollView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10;
        WeakReference weakReference;
        WeakReference weakReference2;
        WeakReference weakReference3;
        Handler handler;
        Handler handler2;
        int scrollY = this.f24131a.getScrollY();
        i10 = this.f24131a.f24017b;
        if (i10 != scrollY) {
            this.f24131a.f24017b = scrollY;
            handler = this.f24131a.f24019d;
            handler2 = this.f24131a.f24019d;
            handler.sendMessageDelayed(handler2.obtainMessage(), 5L);
        }
        weakReference = this.f24131a.f24016a;
        if (weakReference != null) {
            weakReference2 = this.f24131a.f24016a;
            if (weakReference2.get() != null) {
                weakReference3 = this.f24131a.f24016a;
                ((UPScrollView.a) weakReference3.get()).e(scrollY);
            }
        }
    }
}
