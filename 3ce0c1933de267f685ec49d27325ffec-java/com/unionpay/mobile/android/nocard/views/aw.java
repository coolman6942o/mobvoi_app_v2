package com.unionpay.mobile.android.nocard.views;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aw implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ at f23635a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(at atVar) {
        this.f23635a = atVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = (String) view.getTag();
        this.f23635a.E = str;
        this.f23635a.f23629w = 5;
        this.f23635a.d(str, "");
    }
}
