package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f24401a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f24401a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.f24401a.f24396r;
        if (popupWindow != null) {
            popupWindow2 = this.f24401a.f24396r;
            popupWindow2.dismiss();
        }
    }
}
