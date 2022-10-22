package com.unionpay.mobile.android.views.order;

import android.view.View;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.views.order.CViewMethods;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f24217a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ CViewMethods f24218b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(CViewMethods cViewMethods, int i10) {
        this.f24218b = cViewMethods;
        this.f24217a = i10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CViewMethods.a aVar;
        CViewMethods.a aVar2;
        k.c("uppay", " touched " + this.f24217a);
        aVar = this.f24218b.f24186j;
        if (aVar != null) {
            aVar2 = this.f24218b.f24186j;
            aVar2.c(this.f24217a);
        }
    }
}
