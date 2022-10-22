package com.unionpay.mobile.android.pro.views;

import android.view.View;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.nocard.views.b;
import com.unionpay.mobile.android.widgets.m;
/* loaded from: classes2.dex */
final class ag implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f23925a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(y yVar) {
        this.f23925a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        m mVar;
        this.f23925a.i();
        mVar = ((b) this.f23925a).f23640b;
        mVar.a(c.bD.U);
        y yVar = this.f23925a;
        y.f(yVar, y.C(yVar));
    }
}
