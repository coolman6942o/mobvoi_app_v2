package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.ft;
import com.paypal.android.sdk.p3;
import com.paypal.android.sdk.z3;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q3 implements e1 {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ k3 f21797a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q3(k3 k3Var) {
        this.f21797a = k3Var;
    }

    @Override // com.paypal.android.sdk.payments.e1
    public final void a(h1 h1Var) {
        this.f21797a.dismissDialog(2);
        if (h1Var.f21731b.equals("invalid_nonce")) {
            this.f21797a.f21764e.f21025j.setEnabled(false);
            c2.q(this.f21797a, z3.a(ft.SESSION_EXPIRED_MESSAGE), 4);
            return;
        }
        this.f21797a.f21764e.f21025j.setEnabled(true);
        c2.q(this.f21797a, z3.b(h1Var.f21731b), 1);
    }

    @Override // com.paypal.android.sdk.payments.e1
    public final void a(Object obj) {
        if (obj instanceof p3) {
            k3.h(this.f21797a, (p3) obj);
        } else {
            this.f21797a.v();
        }
    }
}
