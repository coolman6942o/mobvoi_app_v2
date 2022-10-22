package com.unionpay.mobile.android.widgets;

import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import com.unionpay.mobile.android.global.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bc implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bb f24375a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.f24375a = bbVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ScrollView scrollView;
        ScrollView scrollView2;
        int i10;
        ScrollView scrollView3;
        scrollView = this.f24375a.f24370g;
        if (scrollView != null) {
            scrollView2 = this.f24375a.f24370g;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) scrollView2.getLayoutParams();
            marginLayoutParams.bottomMargin = a.f23311b;
            i10 = this.f24375a.f24371h;
            marginLayoutParams.height = i10;
            scrollView3 = this.f24375a.f24370g;
            scrollView3.setLayoutParams(marginLayoutParams);
        }
    }
}
