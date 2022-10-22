package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f23744a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(o oVar) {
        this.f23744a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a aVar;
        a aVar2;
        com.unionpay.mobile.android.upwidget.a aVar3;
        a aVar4;
        String str;
        a aVar5;
        com.unionpay.mobile.android.upwidget.a aVar6;
        com.unionpay.mobile.android.upwidget.a aVar7;
        if (!this.f23744a.n()) {
            aVar = this.f23744a.f23718t;
            aVar.d();
            aVar2 = this.f23744a.f23718t;
            a.C0266a b10 = aVar2.b();
            if (!b10.a()) {
                this.f23744a.a(b10.f23995b);
                return;
            }
            aVar3 = this.f23744a.C;
            if (aVar3 != null) {
                aVar6 = this.f23744a.C;
                if (!aVar6.e()) {
                    o oVar = this.f23744a;
                    aVar7 = oVar.C;
                    oVar.a(aVar7.b());
                    return;
                }
            }
            aVar4 = this.f23744a.D;
            if (aVar4 != null) {
                aVar5 = this.f23744a.D;
                a.C0266a b11 = aVar5.b();
                if (!b11.a()) {
                    this.f23744a.a(b11.f23995b);
                    return;
                }
                str = b11.f23995b;
            } else {
                str = "";
            }
            String str2 = b10.f23995b;
            if (b.b(str)) {
                str2 = str2 + "," + str;
            }
            this.f23744a.f23640b.a(c.bD.U);
            o oVar2 = this.f23744a;
            String str3 = oVar2.f23655q;
            o.b(oVar2, str2);
        }
    }
}
