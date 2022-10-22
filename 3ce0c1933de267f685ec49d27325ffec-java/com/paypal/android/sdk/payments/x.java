package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class x implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ LoginActivity f21844a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(LoginActivity loginActivity) {
        this.f21844a = loginActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        this.f21844a.o(r1.f21522h.a() ? bg.EMAIL : bg.PIN);
    }
}
