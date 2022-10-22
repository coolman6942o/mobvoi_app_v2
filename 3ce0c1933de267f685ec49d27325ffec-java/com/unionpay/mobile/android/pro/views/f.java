package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.widgets.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f23930a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.f23930a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean n10;
        a aVar;
        boolean z10;
        b bVar;
        a aVar2;
        m mVar;
        b bVar2;
        Context unused;
        String unused2;
        n10 = this.f23930a.n();
        if (!n10) {
            aVar = this.f23930a.f23912x;
            aVar.d();
            z10 = this.f23930a.F;
            if (z10) {
                a.p(this.f23930a);
                return;
            }
            bVar = ((com.unionpay.mobile.android.nocard.views.b) this.f23930a).f23639a;
            if (bVar.f23540p != null) {
                aVar2 = this.f23930a.f23912x;
                a.C0266a a10 = aVar2.a();
                if (!a10.a()) {
                    this.f23930a.a(a10.f23995b);
                    return;
                }
                unused = ((com.unionpay.mobile.android.nocard.views.b) this.f23930a).f23642d;
                unused2 = ((com.unionpay.mobile.android.nocard.views.b) this.f23930a).f23655q;
                mVar = ((com.unionpay.mobile.android.nocard.views.b) this.f23930a).f23640b;
                mVar.a(c.bD.U);
                this.f23930a.f23909u = 101;
                a aVar3 = this.f23930a;
                bVar2 = ((com.unionpay.mobile.android.nocard.views.b) aVar3).f23639a;
                aVar3.a(bVar2.f23540p);
            }
        }
    }
}
