package com.unionpay.mobile.android.widgets;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class t implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f24447a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.f24447a = pVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        AlertDialog alertDialog;
        this.f24447a.a(i10);
        alertDialog = this.f24447a.f24433p;
        alertDialog.dismiss();
    }
}
