package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.mobvoi.wear.util.TelephonyUtil;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.utils.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f23701a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f23701a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a aVar;
        a aVar2;
        com.unionpay.mobile.android.upwidget.a aVar3;
        boolean z10;
        com.unionpay.mobile.android.upwidget.a aVar4;
        com.unionpay.mobile.android.upwidget.a aVar5;
        if (!this.f23701a.n()) {
            aVar = this.f23701a.f23696v;
            aVar.d();
            aVar2 = this.f23701a.f23696v;
            a.C0266a b10 = aVar2.b();
            if (!b10.a()) {
                this.f23701a.a(b10.f23995b);
                return;
            }
            aVar3 = this.f23701a.f23694t;
            if (aVar3 != null) {
                aVar4 = this.f23701a.f23694t;
                if (!aVar4.e()) {
                    g gVar = this.f23701a;
                    aVar5 = gVar.f23694t;
                    gVar.a(aVar5.b());
                    return;
                }
            }
            this.f23701a.f23640b.a(c.bD.U);
            g gVar2 = this.f23701a;
            String str = gVar2.f23655q;
            z10 = gVar2.f23697w;
            if (!z10) {
                this.f23701a.f23643e.c(j.a(this.f23701a.f23639a.C, TelephonyUtil.KEY_SIM_ACTION), b10.f23995b);
                this.f23701a.f23693s = 102;
                return;
            }
            this.f23701a.s();
            this.f23701a.f23693s = 104;
        }
    }
}
