package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class r2 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PaymentMethodActivity f21800a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r2(PaymentMethodActivity paymentMethodActivity) {
        this.f21800a = paymentMethodActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        PayPalService payPalService;
        PayPalService payPalService2;
        payPalService = this.f21800a.f21639h;
        payPalService.a0();
        payPalService2 = this.f21800a.f21639h;
        payPalService2.N().a();
        this.f21800a.h();
    }
}
