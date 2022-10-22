package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class b2 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ a2 f21668a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b2(a2 a2Var) {
        this.f21668a = a2Var;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.f21668a.f21660a.a(i10);
        a2 a2Var = this.f21668a;
        PaymentConfirmActivity.j(a2Var.f21662c, a2Var.f21661b, i10);
    }
}
