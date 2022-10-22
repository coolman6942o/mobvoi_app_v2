package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.upwidget.a;
/* loaded from: classes2.dex */
final class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f23738a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.f23738a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a aVar;
        a aVar2;
        o oVar = this.f23738a;
        String str = oVar.f23655q;
        aVar = oVar.C;
        String d10 = aVar.d();
        aVar2 = this.f23738a.C;
        oVar.a(d10, aVar2.c());
    }
}
