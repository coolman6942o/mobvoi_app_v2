package com.paypal.android.sdk.payments;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class v3 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ k3 f21819a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v3(k3 k3Var) {
        this.f21819a = k3Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        view.setEnabled(false);
        k3.s(this.f21819a);
    }
}
