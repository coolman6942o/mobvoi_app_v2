package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.nocard.utils.c;
import com.unionpay.mobile.android.views.order.l;
/* loaded from: classes2.dex */
final class ax implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ at f23636a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(at atVar) {
        this.f23636a = atVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        at atVar = this.f23636a;
        int a10 = c.a(atVar.f23642d, atVar.f23639a);
        Integer num = l.f24229c;
        if (a10 == num.intValue()) {
            this.f23636a.m();
            this.f23636a.m();
            return;
        }
        this.f23636a.m();
        at atVar2 = this.f23636a;
        if (atVar2.f23639a.J) {
            atVar2.m();
            this.f23636a.f23639a.J = false;
        }
        this.f23636a.f23639a.aP = num.intValue();
        this.f23636a.d(2);
    }
}
