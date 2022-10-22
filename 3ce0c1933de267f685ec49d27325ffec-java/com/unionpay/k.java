package com.unionpay;

import android.content.DialogInterface;
import com.unionpay.tsmservice.data.Constant;
/* loaded from: classes2.dex */
final class k implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f23306a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f23306a = jVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        UPPayWapActivity.a(this.f23306a.f23305a, Constant.CASH_LOAD_CANCEL, (String) null);
    }
}
