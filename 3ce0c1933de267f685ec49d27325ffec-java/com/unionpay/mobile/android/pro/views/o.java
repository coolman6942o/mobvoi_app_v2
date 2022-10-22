package com.unionpay.mobile.android.pro.views;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f23954a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.f23954a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = (String) view.getTag();
        this.f23954a.P = str;
        this.f23954a.Q = 5;
        this.f23954a.d(str, "");
    }
}
