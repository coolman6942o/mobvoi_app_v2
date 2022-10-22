package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.tsmservice.data.Constant;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ar implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f23622a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar) {
        this.f23622a = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f23622a.i();
        ao aoVar = this.f23622a;
        aoVar.f23639a.I.f23866f = Constant.CASH_LOAD_CANCEL;
        aoVar.u();
        this.f23622a.j();
    }
}
