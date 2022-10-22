package com.unionpay.mobile.android.pro.views;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ab implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f23916a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar) {
        this.f23916a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = (String) view.getTag();
        this.f23916a.B = str;
        this.f23916a.f23968v = 5;
        this.f23916a.d(str, "");
    }
}
