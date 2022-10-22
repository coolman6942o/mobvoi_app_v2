package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class al implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f23607a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.f23607a = akVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a aVar;
        a aVar2;
        com.unionpay.mobile.android.upwidget.a aVar3;
        com.unionpay.mobile.android.upwidget.a aVar4;
        com.unionpay.mobile.android.upwidget.a aVar5;
        if (!this.f23607a.n()) {
            aVar = this.f23607a.f23604v;
            aVar.d();
            aVar2 = this.f23607a.f23604v;
            a.C0266a b10 = aVar2.b();
            if (!b10.a()) {
                this.f23607a.a(b10.f23995b);
                return;
            }
            aVar3 = this.f23607a.f23602t;
            if (aVar3 != null) {
                aVar4 = this.f23607a.f23602t;
                if (!aVar4.e()) {
                    ak akVar = this.f23607a;
                    aVar5 = akVar.f23602t;
                    akVar.a(aVar5.b());
                    return;
                }
            }
            String str = b10.f23995b;
            this.f23607a.f23640b.a(c.bD.U);
            this.f23607a.f23643e.k(str);
            this.f23607a.f23600r = 102;
        }
    }
}
