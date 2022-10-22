package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.unionpay.mobile.android.upviews.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class am implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f23608a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar) {
        this.f23608a = akVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a aVar;
        com.unionpay.mobile.android.upwidget.a aVar2;
        com.unionpay.mobile.android.upwidget.a aVar3;
        aVar = this.f23608a.f23604v;
        aVar.d();
        ((InputMethodManager) this.f23608a.f23642d.getSystemService("input_method")).hideSoftInputFromWindow(this.f23608a.getWindowToken(), 0);
        ak akVar = this.f23608a;
        String str = akVar.f23655q;
        aVar2 = akVar.f23602t;
        String d10 = aVar2.d();
        aVar3 = this.f23608a.f23602t;
        akVar.a(d10, aVar3.c());
    }
}
