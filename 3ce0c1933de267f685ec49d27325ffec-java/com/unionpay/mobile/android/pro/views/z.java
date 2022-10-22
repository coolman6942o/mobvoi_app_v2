package com.unionpay.mobile.android.pro.views;

import android.view.View;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.widgets.m;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f23973a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.f23973a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean n10;
        a aVar;
        a aVar2;
        com.unionpay.mobile.android.upwidget.a aVar3;
        com.unionpay.mobile.android.upwidget.a aVar4;
        m mVar;
        b bVar;
        b bVar2;
        b bVar3;
        a aVar5;
        b bVar4;
        a aVar6;
        com.unionpay.mobile.android.upwidget.a aVar7;
        com.unionpay.mobile.android.upwidget.a aVar8;
        com.unionpay.mobile.android.upwidget.a aVar9;
        com.unionpay.mobile.android.upwidget.a aVar10;
        String unused;
        n10 = this.f23973a.n();
        if (!n10) {
            aVar = this.f23973a.A;
            aVar.d();
            aVar2 = this.f23973a.A;
            a.C0266a a10 = aVar2.a();
            if (!a10.a()) {
                this.f23973a.a(a10.f23995b);
                return;
            }
            aVar3 = this.f23973a.f23970x;
            if (aVar3 != null) {
                aVar9 = this.f23973a.f23970x;
                if (!aVar9.e()) {
                    y yVar = this.f23973a;
                    aVar10 = yVar.f23970x;
                    yVar.a(aVar10.b());
                    return;
                }
            }
            aVar4 = this.f23973a.f23969w;
            if (aVar4 != null) {
                aVar7 = this.f23973a.f23969w;
                if (!aVar7.e()) {
                    y yVar2 = this.f23973a;
                    aVar8 = yVar2.f23969w;
                    yVar2.a(aVar8.b());
                    return;
                }
            }
            mVar = ((com.unionpay.mobile.android.nocard.views.b) this.f23973a).f23640b;
            mVar.a(c.bD.U);
            unused = ((com.unionpay.mobile.android.nocard.views.b) this.f23973a).f23655q;
            bVar = ((com.unionpay.mobile.android.nocard.views.b) this.f23973a).f23639a;
            if (bVar.br) {
                y yVar3 = this.f23973a;
                bVar4 = ((com.unionpay.mobile.android.nocard.views.b) yVar3).f23639a;
                com.unionpay.mobile.android.model.c cVar = bVar4.bs;
                aVar6 = this.f23973a.A;
                y.a(yVar3, cVar, aVar6.a().f23995b, y.i(this.f23973a));
                return;
            }
            y yVar4 = this.f23973a;
            bVar2 = ((com.unionpay.mobile.android.nocard.views.b) yVar4).f23639a;
            List<com.unionpay.mobile.android.model.c> list = bVar2.f23541q;
            bVar3 = ((com.unionpay.mobile.android.nocard.views.b) this.f23973a).f23639a;
            aVar5 = this.f23973a.A;
            y.a(yVar4, list.get(bVar3.N), aVar5.a().f23995b, y.i(this.f23973a));
        }
    }
}
