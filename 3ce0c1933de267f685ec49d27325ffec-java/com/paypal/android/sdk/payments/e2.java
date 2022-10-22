package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class e2 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ d2 f21716a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e2(d2 d2Var) {
        this.f21716a = d2Var;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.f21716a.f21695a.b(i10);
        d2 d2Var = this.f21716a;
        PaymentConfirmActivity.r(d2Var.f21697c, d2Var.f21696b, i10);
    }
}
