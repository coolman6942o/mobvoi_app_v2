package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.upviews.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f23702a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f23702a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a aVar;
        com.unionpay.mobile.android.upwidget.a aVar2;
        com.unionpay.mobile.android.upwidget.a aVar3;
        aVar = this.f23702a.f23696v;
        aVar.d();
        g gVar = this.f23702a;
        String str = gVar.f23655q;
        aVar2 = gVar.f23694t;
        String d10 = aVar2.d();
        aVar3 = this.f23702a.f23694t;
        gVar.a(d10, aVar3.c());
    }
}
