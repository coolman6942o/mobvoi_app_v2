package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class u implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ LoginActivity f21810a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(LoginActivity loginActivity) {
        this.f21810a = loginActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        LoginActivity.C(this.f21810a);
    }
}
