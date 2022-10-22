package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.unionpay.mobile.android.nocard.views.b;
import com.unionpay.mobile.android.upviews.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f23957a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(k kVar) {
        this.f23957a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a aVar;
        Context context;
        com.unionpay.mobile.android.upwidget.a aVar2;
        com.unionpay.mobile.android.upwidget.a aVar3;
        Context unused;
        String unused2;
        aVar = this.f23957a.f23948y;
        aVar.d();
        context = ((b) this.f23957a).f23642d;
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(this.f23957a.getWindowToken(), 0);
        unused = ((b) this.f23957a).f23642d;
        unused2 = ((b) this.f23957a).f23655q;
        k kVar = this.f23957a;
        aVar2 = kVar.L;
        String d10 = aVar2.d();
        aVar3 = this.f23957a.L;
        kVar.a(d10, aVar3.c());
    }
}
