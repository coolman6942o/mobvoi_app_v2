package com.unionpay.mobile.android.pro.views;

import android.view.View;
import com.unionpay.mobile.android.model.b;
import com.unionpay.tsmservice.data.Constant;
/* loaded from: classes2.dex */
final class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f23961a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(k kVar) {
        this.f23961a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b bVar;
        this.f23961a.i();
        bVar = ((com.unionpay.mobile.android.nocard.views.b) this.f23961a).f23639a;
        bVar.I.f23866f = Constant.CASH_LOAD_CANCEL;
        this.f23961a.j();
    }
}
