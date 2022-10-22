package com.paypal.android.sdk.payments;

import android.view.View;
/* loaded from: classes2.dex */
final class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ FuturePaymentInfoActivity f21728a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FuturePaymentInfoActivity futurePaymentInfoActivity) {
        this.f21728a = futurePaymentInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f21728a.finish();
    }
}
