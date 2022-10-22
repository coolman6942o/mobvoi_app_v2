package com.paypal.android.sdk.payments;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h0 implements e1 {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ LoginActivity f21729a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(LoginActivity loginActivity) {
        this.f21729a = loginActivity;
    }

    @Override // com.paypal.android.sdk.payments.e1
    public final void a(h1 h1Var) {
        if (h1Var.b()) {
            this.f21729a.s();
        } else {
            LoginActivity.j(this.f21729a, h1Var.f21731b);
        }
    }

    @Override // com.paypal.android.sdk.payments.e1
    public final void a(Object obj) {
        this.f21729a.w();
    }
}
