package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.tsmservice.data.Constant;
/* loaded from: classes2.dex */
final class bk implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bi f23683a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bi biVar) {
        this.f23683a = biVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f23683a.i();
        bi biVar = this.f23683a;
        biVar.f23639a.I.f23866f = Constant.CASH_LOAD_CANCEL;
        biVar.j();
    }
}
