package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f24343a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f24343a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.f24343a.f24271r;
        if (popupWindow != null) {
            popupWindow2 = this.f24343a.f24271r;
            popupWindow2.dismiss();
        }
    }
}
