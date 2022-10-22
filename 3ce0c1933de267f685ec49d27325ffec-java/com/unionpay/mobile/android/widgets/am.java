package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class am implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aj f24316a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.f24316a = ajVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        int intValue = ((Integer) view.getTag()).intValue();
        this.f24316a.s();
        String[] strArr = o.f24166h;
        j.b(this.f24316a.f24302o, intValue);
        this.f24316a.a(intValue, i10, "label");
        this.f24316a.a(intValue, i10);
        popupWindow = this.f24316a.f24303p;
        if (popupWindow != null) {
            popupWindow2 = this.f24316a.f24303p;
            popupWindow2.dismiss();
        }
    }
}
