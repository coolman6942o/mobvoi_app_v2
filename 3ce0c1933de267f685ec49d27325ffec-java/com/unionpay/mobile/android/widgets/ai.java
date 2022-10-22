package com.unionpay.mobile.android.widgets;

import android.view.View;
import com.unionpay.mobile.android.widgets.ah;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ai implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ah f24298a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.f24298a = ahVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ah.a aVar;
        ah.a aVar2;
        String str;
        aVar = this.f24298a.f24295c;
        if (aVar != null) {
            this.f24298a.s();
            aVar2 = this.f24298a.f24295c;
            str = this.f24298a.f24297p;
            aVar2.e(str);
        }
    }
}
