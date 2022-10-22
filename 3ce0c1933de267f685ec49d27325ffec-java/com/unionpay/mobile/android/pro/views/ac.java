package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.nocard.utils.c;
import com.unionpay.mobile.android.views.order.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f23917a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(y yVar) {
        this.f23917a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        context = ((com.unionpay.mobile.android.nocard.views.b) this.f23917a).f23642d;
        bVar = ((com.unionpay.mobile.android.nocard.views.b) this.f23917a).f23639a;
        int a10 = c.a(context, bVar);
        Integer num = l.f24229c;
        if (a10 == num.intValue()) {
            this.f23917a.m();
            this.f23917a.m();
            return;
        }
        this.f23917a.m();
        bVar2 = ((com.unionpay.mobile.android.nocard.views.b) this.f23917a).f23639a;
        if (bVar2.J) {
            this.f23917a.m();
            bVar4 = ((com.unionpay.mobile.android.nocard.views.b) this.f23917a).f23639a;
            bVar4.J = false;
        }
        bVar3 = ((com.unionpay.mobile.android.nocard.views.b) this.f23917a).f23639a;
        bVar3.aP = num.intValue();
        this.f23917a.d(2);
    }
}
