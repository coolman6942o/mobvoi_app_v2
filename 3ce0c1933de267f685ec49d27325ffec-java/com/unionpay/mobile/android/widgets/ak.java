package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ak implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aj f24314a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.f24314a = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.f24314a.f24303p;
        if (popupWindow != null) {
            popupWindow2 = this.f24314a.f24303p;
            popupWindow2.dismiss();
        }
    }
}
