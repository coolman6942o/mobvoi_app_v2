package com.paypal.android.sdk.payments;

import android.view.View;
/* loaded from: classes2.dex */
final class b0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ LoginActivity f21667a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(LoginActivity loginActivity) {
        this.f21667a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LoginActivity.m(this.f21667a, view);
    }
}
