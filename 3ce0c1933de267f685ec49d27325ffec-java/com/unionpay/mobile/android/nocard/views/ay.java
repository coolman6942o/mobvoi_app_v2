package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.unionpay.mobile.android.upviews.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ay implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ at f23637a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(at atVar) {
        this.f23637a = atVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a aVar;
        com.unionpay.mobile.android.upwidget.a aVar2;
        com.unionpay.mobile.android.upwidget.a aVar3;
        aVar = this.f23637a.B;
        aVar.d();
        ((InputMethodManager) this.f23637a.f23642d.getSystemService("input_method")).hideSoftInputFromWindow(this.f23637a.getWindowToken(), 0);
        at atVar = this.f23637a;
        String str = atVar.f23655q;
        aVar2 = atVar.f23631y;
        String d10 = aVar2.d();
        aVar3 = this.f23637a.f23631y;
        atVar.a(d10, aVar3.c());
    }
}
