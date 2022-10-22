package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f24386a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f24386a = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        this.f24386a.s();
        a.a(this.f24386a, i10);
        popupWindow = this.f24386a.f24271r;
        if (popupWindow != null) {
            popupWindow2 = this.f24386a.f24271r;
            popupWindow2.dismiss();
        }
    }
}
