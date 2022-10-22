package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f24444a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.f24444a = pVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.f24444a.f24434q;
        if (popupWindow != null) {
            popupWindow2 = this.f24444a.f24434q;
            popupWindow2.dismiss();
        }
    }
}
