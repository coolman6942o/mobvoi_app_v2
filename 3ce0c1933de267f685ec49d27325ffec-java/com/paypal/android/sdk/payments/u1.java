package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class u1 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PaymentConfirmActivity f21812a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u1(PaymentConfirmActivity paymentConfirmActivity) {
        this.f21812a = paymentConfirmActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.f21812a.onBackPressed();
    }
}
