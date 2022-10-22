package com.paypal.android.sdk.payments;

import android.view.View;
/* loaded from: classes2.dex */
final class x1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PaymentConfirmActivity f21846a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x1(PaymentConfirmActivity paymentConfirmActivity) {
        this.f21846a = paymentConfirmActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f21846a.onBackPressed();
    }
}
