package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class l0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PayPalFuturePaymentActivity f21771a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(PayPalFuturePaymentActivity payPalFuturePaymentActivity) {
        this.f21771a = payPalFuturePaymentActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        PayPalService payPalService;
        g1 g10;
        payPalService = this.f21771a.f21554c;
        g10 = this.f21771a.g();
        payPalService.x(g10, true);
    }
}
