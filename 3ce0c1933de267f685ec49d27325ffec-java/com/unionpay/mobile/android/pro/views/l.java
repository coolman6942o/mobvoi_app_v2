package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.widgets.m;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f23950a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f23950a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean n10;
        a aVar;
        com.unionpay.mobile.android.upwidget.a aVar2;
        com.unionpay.mobile.android.upwidget.a aVar3;
        b bVar;
        a aVar4;
        m mVar;
        a aVar5;
        HashMap t10;
        com.unionpay.mobile.android.upwidget.a aVar6;
        com.unionpay.mobile.android.upwidget.a aVar7;
        com.unionpay.mobile.android.upwidget.a aVar8;
        com.unionpay.mobile.android.upwidget.a aVar9;
        Context unused;
        String unused2;
        n10 = this.f23950a.n();
        if (!n10) {
            aVar = this.f23950a.f23948y;
            aVar.d();
            aVar2 = this.f23950a.L;
            if (aVar2 != null) {
                aVar8 = this.f23950a.L;
                if (!aVar8.e()) {
                    k kVar = this.f23950a;
                    aVar9 = kVar.L;
                    kVar.a(aVar9.b());
                    return;
                }
            }
            aVar3 = this.f23950a.K;
            if (aVar3 != null) {
                aVar6 = this.f23950a.K;
                if (!aVar6.e()) {
                    k kVar2 = this.f23950a;
                    aVar7 = kVar2.K;
                    kVar2.a(aVar7.b());
                    return;
                }
            }
            bVar = ((com.unionpay.mobile.android.nocard.views.b) this.f23950a).f23639a;
            if (bVar.f23540p != null) {
                aVar4 = this.f23950a.f23948y;
                a.C0266a a10 = aVar4.a();
                if (!a10.a()) {
                    this.f23950a.a(a10.f23995b);
                    return;
                }
                unused = ((com.unionpay.mobile.android.nocard.views.b) this.f23950a).f23642d;
                unused2 = ((com.unionpay.mobile.android.nocard.views.b) this.f23950a).f23655q;
                mVar = ((com.unionpay.mobile.android.nocard.views.b) this.f23950a).f23640b;
                mVar.a(c.bD.U);
                this.f23950a.f23945v = 101;
                k kVar3 = this.f23950a;
                aVar5 = kVar3.f23948y;
                String str = aVar5.a().f23995b;
                t10 = this.f23950a.t();
                kVar3.b(str, t10);
            }
        }
    }
}
