package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class z implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ LoginActivity f21852a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(LoginActivity loginActivity) {
        this.f21852a = loginActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.f21852a.onBackPressed();
    }
}
