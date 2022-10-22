package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f24402a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f24402a = gVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        this.f24402a.s();
        this.f24402a.a(i10);
        popupWindow = this.f24402a.f24396r;
        if (popupWindow != null) {
            popupWindow2 = this.f24402a.f24396r;
            popupWindow2.dismiss();
        }
    }
}
