package com.paypal.android.sdk.payments;

import android.view.View;
/* loaded from: classes2.dex */
final class p2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PaymentMethodActivity f21793a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p2(PaymentMethodActivity paymentMethodActivity) {
        this.f21793a = paymentMethodActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f21793a.showDialog(2);
    }
}
