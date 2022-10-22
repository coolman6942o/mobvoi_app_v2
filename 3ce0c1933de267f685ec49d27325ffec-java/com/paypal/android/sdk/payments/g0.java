package com.paypal.android.sdk.payments;

import android.view.View;
/* loaded from: classes2.dex */
final class g0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ LoginActivity f21725a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g0(LoginActivity loginActivity) {
        this.f21725a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LoginActivity.A(this.f21725a, view);
    }
}
