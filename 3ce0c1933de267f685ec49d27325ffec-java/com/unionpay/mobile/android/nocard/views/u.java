package com.unionpay.mobile.android.nocard.views;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f23743a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar) {
        this.f23743a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = (String) view.getTag();
        this.f23743a.F = str;
        this.f23743a.B = 5;
        this.f23743a.d(str, "");
    }
}
