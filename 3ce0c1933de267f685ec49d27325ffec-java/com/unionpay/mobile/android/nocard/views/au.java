package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class au implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ at f23633a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar) {
        this.f23633a = atVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a aVar;
        String str;
        a aVar2;
        a aVar3;
        com.unionpay.mobile.android.upwidget.a aVar4;
        com.unionpay.mobile.android.upwidget.a aVar5;
        boolean z10;
        com.unionpay.mobile.android.upwidget.a aVar6;
        com.unionpay.mobile.android.upwidget.a aVar7;
        com.unionpay.mobile.android.upwidget.a aVar8;
        com.unionpay.mobile.android.upwidget.a aVar9;
        a aVar10;
        a aVar11;
        if (!this.f23633a.n()) {
            aVar = this.f23633a.A;
            if (aVar != null) {
                aVar10 = this.f23633a.A;
                aVar10.d();
                aVar11 = this.f23633a.A;
                a.C0266a b10 = aVar11.b();
                if (!b10.a()) {
                    this.f23633a.a(b10.f23995b);
                    return;
                }
                str = b10.f23995b;
            } else {
                str = "";
            }
            aVar2 = this.f23633a.B;
            aVar2.d();
            aVar3 = this.f23633a.B;
            a.C0266a b11 = aVar3.b();
            if (!b11.a()) {
                this.f23633a.a(b11.f23995b);
                return;
            }
            aVar4 = this.f23633a.f23631y;
            if (aVar4 != null) {
                aVar8 = this.f23633a.f23631y;
                if (!aVar8.e()) {
                    at atVar = this.f23633a;
                    aVar9 = atVar.f23631y;
                    atVar.a(aVar9.b());
                    return;
                }
            }
            aVar5 = this.f23633a.f23630x;
            if (aVar5 != null) {
                aVar6 = this.f23633a.f23630x;
                if (!aVar6.e()) {
                    at atVar2 = this.f23633a;
                    aVar7 = atVar2.f23630x;
                    atVar2.a(aVar7.b());
                    return;
                }
            }
            String str2 = b11.f23995b;
            if (b.b(str)) {
                str2 = str2 + "," + str;
            }
            this.f23633a.f23640b.a(c.bD.U);
            at atVar3 = this.f23633a;
            String str3 = atVar3.f23655q;
            String str4 = atVar3.f23639a.E;
            if (str4 == null || str4.length() <= 0) {
                this.f23633a.e(str2);
                return;
            }
            at atVar4 = this.f23633a;
            z10 = atVar4.C;
            at.a(atVar4, z10, str2);
        }
    }
}
