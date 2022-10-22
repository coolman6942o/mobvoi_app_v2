package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.languages.c;
/* loaded from: classes2.dex */
final class ah implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f23595a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ af f23596b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar, String str) {
        this.f23596b = afVar;
        this.f23595a = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f23596b.a(c.bD.f23477s, this.f23595a);
    }
}
