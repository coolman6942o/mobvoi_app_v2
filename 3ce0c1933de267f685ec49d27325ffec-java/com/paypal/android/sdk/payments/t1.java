package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class t1 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PaymentConfirmActivity f21807a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t1(PaymentConfirmActivity paymentConfirmActivity) {
        this.f21807a = paymentConfirmActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.f21807a.G();
    }
}
