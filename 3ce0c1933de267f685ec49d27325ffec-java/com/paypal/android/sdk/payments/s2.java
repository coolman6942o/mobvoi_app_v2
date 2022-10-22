package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class s2 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PaymentMethodActivity f21804a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s2(PaymentMethodActivity paymentMethodActivity) {
        this.f21804a = paymentMethodActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        PayPalService payPalService;
        payPalService = this.f21804a.f21639h;
        payPalService.m0();
        this.f21804a.h();
    }
}
