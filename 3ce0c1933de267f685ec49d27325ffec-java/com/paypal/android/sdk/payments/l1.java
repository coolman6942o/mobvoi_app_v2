package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class l1 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PaymentActivity f21772a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l1(PaymentActivity paymentActivity) {
        this.f21772a = paymentActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        PayPalService payPalService;
        g1 g10;
        payPalService = this.f21772a.f21612c;
        g10 = this.f21772a.g();
        payPalService.x(g10, true);
    }
}
