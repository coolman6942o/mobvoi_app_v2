package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.unionpay.mobile.android.nocard.views.b;
import com.unionpay.mobile.android.upviews.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ae implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f23923a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(y yVar) {
        this.f23923a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a aVar;
        Context context;
        com.unionpay.mobile.android.upwidget.a aVar2;
        com.unionpay.mobile.android.upwidget.a aVar3;
        String unused;
        aVar = this.f23923a.A;
        aVar.d();
        context = ((b) this.f23923a).f23642d;
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(this.f23923a.getWindowToken(), 0);
        unused = ((b) this.f23923a).f23655q;
        y yVar = this.f23923a;
        aVar2 = yVar.f23970x;
        String d10 = aVar2.d();
        aVar3 = this.f23923a.f23970x;
        yVar.a(d10, aVar3.c());
    }
}
