package com.paypal.android.sdk.payments;

import android.view.View;
/* loaded from: classes2.dex */
final class n2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PaymentMethodActivity f21781a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n2(PaymentMethodActivity paymentMethodActivity) {
        this.f21781a = paymentMethodActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f21781a.showDialog(1);
    }
}
