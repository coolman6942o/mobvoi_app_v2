package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.tsmservice.data.Constant;
/* loaded from: classes2.dex */
final class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f23741a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.f23741a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f23741a.i();
        o oVar = this.f23741a;
        oVar.f23639a.I.f23866f = Constant.CASH_LOAD_CANCEL;
        oVar.j();
    }
}
