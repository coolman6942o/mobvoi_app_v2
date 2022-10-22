package com.paypal.android.sdk.payments;

import android.view.View;
/* loaded from: classes2.dex */
final class e0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ LoginActivity f21715a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(LoginActivity loginActivity) {
        this.f21715a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LoginActivity.x(this.f21715a, view);
    }
}
