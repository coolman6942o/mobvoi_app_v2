package com.unionpay.mobile.android.widgets;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f24446a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.f24446a = pVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        p.b(this.f24446a).show();
    }
}
