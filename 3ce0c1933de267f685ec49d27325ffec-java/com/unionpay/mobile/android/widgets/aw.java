package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.view.ViewTreeObserver;
import com.unionpay.mobile.android.utils.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aw implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPWidget f24329a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(UPWidget uPWidget) {
        this.f24329a = uPWidget;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View x10;
        View x11;
        int i10;
        int i11;
        k.a("uppay", "onGlobalLayout() +++");
        x10 = this.f24329a.x();
        int height = x10.getRootView().getHeight();
        x11 = this.f24329a.x();
        int height2 = height - x11.getHeight();
        i10 = UPWidget.f24254o;
        if (height2 <= i10) {
            i11 = UPWidget.f24254o;
            if (height2 <= i11) {
                this.f24329a.l();
            }
        }
        k.a("uppay", "onGlobalLayout() ---");
    }
}
