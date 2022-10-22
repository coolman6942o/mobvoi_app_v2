package com.paypal.android.sdk.payments;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q2 extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PaymentMethodActivity f21796a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q2(PaymentMethodActivity paymentMethodActivity) {
        this.f21796a = paymentMethodActivity;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        PayPalService payPalService;
        this.f21796a.removeDialog(3);
        PaymentMethodActivity paymentMethodActivity = this.f21796a;
        k2 k2Var = k2.PayPal;
        payPalService = paymentMethodActivity.f21639h;
        PaymentConfirmActivity.e(paymentMethodActivity, 2, k2Var, null, payPalService.S());
    }
}
