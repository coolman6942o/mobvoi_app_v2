package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.j4;
import com.paypal.android.sdk.z3;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class v1 implements g1 {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PaymentConfirmActivity f21817a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v1(PaymentConfirmActivity paymentConfirmActivity) {
        this.f21817a = paymentConfirmActivity;
    }

    @Override // com.paypal.android.sdk.payments.g1
    public final void a() {
        String unused;
        unused = PaymentConfirmActivity.f21615m;
        this.f21817a.C();
    }

    @Override // com.paypal.android.sdk.payments.g1
    public final void a(h1 h1Var) {
        k2 k2Var;
        j4 j4Var;
        this.f21817a.H();
        c2.q(this.f21817a, z3.b(h1Var.f21731b), 1);
        k2Var = this.f21817a.f21623h;
        if (k2Var != k2.PayPal) {
            j4Var = this.f21817a.f21621f;
            j4Var.l(true);
        }
    }
}
