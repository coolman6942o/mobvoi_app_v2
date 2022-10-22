package com.unionpay.mobile.android.widgets;

import android.view.View;
import com.unionpay.mobile.android.widgets.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aq implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ap f24322a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar) {
        this.f24322a = apVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ap.a aVar;
        ap.a aVar2;
        aVar = this.f24322a.f24318c;
        if (aVar != null) {
            this.f24322a.s();
            aVar2 = this.f24322a.f24318c;
            aVar2.a(this.f24322a);
        }
    }
}
