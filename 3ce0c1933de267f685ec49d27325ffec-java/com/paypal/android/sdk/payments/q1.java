package com.paypal.android.sdk.payments;

import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q1 extends x3 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q1(Intent intent, PayPalConfiguration payPalConfiguration) {
        super(intent, payPalConfiguration);
    }

    @Override // com.paypal.android.sdk.payments.x3
    protected final String a() {
        return PaymentActivity.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d() {
        r1 r1Var = new r1(this.f21847a);
        boolean z10 = r1Var.a() != null && r1Var.a().p();
        b(z10, "PaymentActivity.EXTRA_PAYMENT");
        return z10;
    }
}
