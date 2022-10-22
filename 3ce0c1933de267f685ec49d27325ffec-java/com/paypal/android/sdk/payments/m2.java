package com.paypal.android.sdk.payments;

import android.view.View;
/* loaded from: classes2.dex */
final class m2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PaymentMethodActivity f21777a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m2(PaymentMethodActivity paymentMethodActivity) {
        this.f21777a = paymentMethodActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PaymentMethodActivity.d(this.f21777a);
    }
}
