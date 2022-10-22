package com.paypal.android.sdk.payments;

import android.view.View;
/* loaded from: classes2.dex */
final class c0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ LoginActivity f21690a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(LoginActivity loginActivity) {
        this.f21690a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LoginActivity.q(this.f21690a, view);
    }
}
