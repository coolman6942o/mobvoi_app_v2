package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class g2 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PaymentConfirmActivity f21726a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g2(PaymentConfirmActivity paymentConfirmActivity) {
        this.f21726a = paymentConfirmActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.f21726a.m(true);
    }
}
