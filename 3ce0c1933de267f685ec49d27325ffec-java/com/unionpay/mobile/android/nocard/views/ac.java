package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.widget.PopupWindow;
import com.unionpay.mobile.android.nocard.views.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o.b f23587a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(o.b bVar) {
        this.f23587a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        popupWindow = this.f23587a.f23726b;
        if (popupWindow != null) {
            popupWindow2 = this.f23587a.f23726b;
            popupWindow2.dismiss();
        }
    }
}
