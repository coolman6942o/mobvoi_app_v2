package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.PopupWindow;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class al implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aj f24315a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar) {
        this.f24315a = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        int intValue = ((Integer) view.getTag()).intValue();
        this.f24315a.s();
        String[] strArr = o.f24166h;
        j.b(this.f24315a.f24302o, intValue);
        this.f24315a.a(intValue, 0, "label");
        this.f24315a.a(intValue, 0);
        popupWindow = this.f24315a.f24303p;
        if (popupWindow != null) {
            popupWindow2 = this.f24315a.f24303p;
            popupWindow2.dismiss();
        }
    }
}
