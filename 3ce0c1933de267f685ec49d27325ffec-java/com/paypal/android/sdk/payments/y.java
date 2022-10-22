package com.paypal.android.sdk.payments;

import android.view.View;
/* loaded from: classes2.dex */
final class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ LoginActivity f21849a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(LoginActivity loginActivity) {
        this.f21849a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LoginActivity.g(this.f21849a, view);
    }
}
