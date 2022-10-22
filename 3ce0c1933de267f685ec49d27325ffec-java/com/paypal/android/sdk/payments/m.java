package com.paypal.android.sdk.payments;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m implements e1 {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ LoginActivity f21774a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LoginActivity loginActivity) {
        this.f21774a = loginActivity;
    }

    @Override // com.paypal.android.sdk.payments.e1
    public final void a(h1 h1Var) {
        LoginActivity.n(this.f21774a, h1Var.f21731b);
    }

    @Override // com.paypal.android.sdk.payments.e1
    public final void a(Object obj) {
        this.f21774a.o(bg.TWO_FA_ENTER_OTP);
    }
}
