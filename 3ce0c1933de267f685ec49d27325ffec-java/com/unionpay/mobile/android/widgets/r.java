package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.unionpay.mobile.android.utils.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f24445a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.f24445a = pVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        this.f24445a.s();
        String[] strArr = o.f24164f;
        this.f24445a.a(i10);
        popupWindow = this.f24445a.f24434q;
        if (popupWindow != null) {
            popupWindow2 = this.f24445a.f24434q;
            popupWindow2.dismiss();
        }
    }
}
