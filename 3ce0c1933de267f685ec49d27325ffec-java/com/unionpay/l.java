package com.unionpay;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* loaded from: classes2.dex */
final class l implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f23307a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f23307a = jVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        AlertDialog alertDialog;
        alertDialog = this.f23307a.f23305a.f23252d;
        alertDialog.dismiss();
    }
}
