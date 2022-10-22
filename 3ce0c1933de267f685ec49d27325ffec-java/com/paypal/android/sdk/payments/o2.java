package com.paypal.android.sdk.payments;

import android.view.View;
/* loaded from: classes2.dex */
final class o2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PaymentMethodActivity f21786a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o2(PaymentMethodActivity paymentMethodActivity) {
        this.f21786a = paymentMethodActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PaymentMethodActivity.i(this.f21786a);
    }
}
