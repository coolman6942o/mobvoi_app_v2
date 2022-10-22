package com.paypal.android.sdk.payments;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class n implements e1 {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ LoginActivity f21778a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LoginActivity loginActivity) {
        this.f21778a = loginActivity;
    }

    @Override // com.paypal.android.sdk.payments.e1
    public final void a(h1 h1Var) {
        LoginActivity.i(this.f21778a, h1Var);
    }

    @Override // com.paypal.android.sdk.payments.e1
    public final void a(Object obj) {
        this.f21778a.w();
    }
}
