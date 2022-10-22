package com.paypal.android.sdk.payments;

import android.view.View;
/* loaded from: classes2.dex */
final class d0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ LoginActivity f21693a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(LoginActivity loginActivity) {
        this.f21693a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LoginActivity.u(this.f21693a, view);
    }
}
