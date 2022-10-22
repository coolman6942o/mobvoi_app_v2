package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import com.unionpay.mobile.android.model.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class as implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f23623a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ao aoVar) {
        this.f23623a = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f23623a.i();
        if (b.f23494bm) {
            ao aoVar = this.f23623a;
            b bVar = aoVar.f23639a;
            aoVar.d(bVar.f23525bp, bVar.f23526bq);
        }
    }
}
