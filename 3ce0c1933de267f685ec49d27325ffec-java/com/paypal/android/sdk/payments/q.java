package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import com.paypal.android.sdk.i4;
/* loaded from: classes2.dex */
final class q implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ p f21795a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.f21795a = pVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        i4 i4Var;
        this.f21795a.f21790c.f21528n = i10;
        this.f21795a.f21788a.a(i10);
        i4Var = this.f21795a.f21790c.f21529o;
        i4Var.f21378r.a((String) this.f21795a.f21789b.get(i10));
    }
}
