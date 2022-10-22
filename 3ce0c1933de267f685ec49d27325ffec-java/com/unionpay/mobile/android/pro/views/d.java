package com.unionpay.mobile.android.pro.views;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f23928a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f23928a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = (String) view.getTag();
        this.f23928a.E = str;
        this.f23928a.D = 5;
        this.f23928a.e(str, "");
    }
}
