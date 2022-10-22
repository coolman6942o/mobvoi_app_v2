package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.languages.c;
/* loaded from: classes2.dex */
final class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f23739a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ o f23740b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, String str) {
        this.f23740b = oVar;
        this.f23739a = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f23740b.a(c.bD.f23477s, this.f23739a);
    }
}
