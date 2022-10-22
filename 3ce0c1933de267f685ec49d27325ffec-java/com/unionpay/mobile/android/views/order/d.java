package com.unionpay.mobile.android.views.order;

import android.view.View;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f24213a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f24213a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.f24213a.f24195m;
        if (popupWindow != null) {
            popupWindow2 = this.f24213a.f24195m;
            popupWindow2.dismiss();
        }
    }
}
