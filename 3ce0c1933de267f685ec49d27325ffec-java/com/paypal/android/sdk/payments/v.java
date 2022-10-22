package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class v implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ LoginActivity f21815a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(LoginActivity loginActivity) {
        this.f21815a = loginActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        LoginActivity.C(this.f21815a);
    }
}
