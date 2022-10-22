package com.paypal.android.sdk.payments;

import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r1 {

    /* renamed from: a  reason: collision with root package name */
    private Intent f21799a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r1(Intent intent) {
        this.f21799a = intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PayPalPayment a() {
        return (PayPalPayment) this.f21799a.getParcelableExtra("com.paypal.android.sdk.payment");
    }

    public final dx b() {
        return (dx) this.f21799a.getParcelableExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_PAYMENT_INFO");
    }
}
