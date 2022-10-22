package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class u0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PayPalProfileSharingActivity f21811a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u0(PayPalProfileSharingActivity payPalProfileSharingActivity) {
        this.f21811a = payPalProfileSharingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        PayPalService payPalService;
        payPalService = this.f21811a.f21584c;
        payPalService.x(PayPalProfileSharingActivity.b(this.f21811a), true);
    }
}
