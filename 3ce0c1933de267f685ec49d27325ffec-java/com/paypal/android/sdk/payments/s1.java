package com.paypal.android.sdk.payments;

import android.view.View;
/* loaded from: classes2.dex */
final class s1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PaymentConfirmActivity f21803a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s1(PaymentConfirmActivity paymentConfirmActivity) {
        this.f21803a = paymentConfirmActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        view.setEnabled(false);
        this.f21803a.C();
    }
}
