package com.paypal.android.sdk.payments;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class u3 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ k3 f21814a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u3(k3 k3Var) {
        this.f21814a = k3Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        k3.q(this.f21814a);
    }
}
