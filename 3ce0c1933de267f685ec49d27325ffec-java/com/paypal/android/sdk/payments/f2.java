package com.paypal.android.sdk.payments;

import android.content.Intent;
import android.os.Bundle;
import com.paypal.android.sdk.ft;
import com.paypal.android.sdk.j4;
import com.paypal.android.sdk.l3;
import com.paypal.android.sdk.z3;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f2 implements e1 {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PaymentConfirmActivity f21724a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f2(PaymentConfirmActivity paymentConfirmActivity) {
        this.f21724a = paymentConfirmActivity;
    }

    @Override // com.paypal.android.sdk.payments.e1
    public final void a(h1 h1Var) {
        PayPalService payPalService;
        k2 k2Var;
        j4 j4Var;
        k2 k2Var2;
        PayPalService payPalService2;
        PayPalService payPalService3;
        g1 D;
        String unused;
        payPalService = this.f21724a.f21625j;
        payPalService.N().a();
        this.f21724a.H();
        if (!h1Var.a() || "UNAUTHORIZED_PAYMENT".equals(h1Var.f21731b)) {
            int[] iArr = w1.f21822a;
            k2Var = this.f21724a.f21623h;
            int i10 = iArr[k2Var.ordinal()];
            if (i10 == 1) {
                this.f21724a.f21620e = false;
                Bundle bundle = new Bundle();
                bundle.putString("BUNDLE_ERROR_CODE", h1Var.f21731b);
                this.f21724a.showDialog(5, bundle);
            } else if (i10 == 2 || i10 == 3) {
                j4Var = this.f21724a.f21621f;
                j4Var.l(true);
                c2.q(this.f21724a, z3.b(h1Var.f21731b), 1);
            }
        } else {
            int[] iArr2 = w1.f21822a;
            k2Var2 = this.f21724a.f21623h;
            int i11 = iArr2[k2Var2.ordinal()];
            if (i11 == 1) {
                c2.q(this.f21724a, z3.a(ft.SESSION_EXPIRED_MESSAGE), 4);
            } else if (i11 == 2 || i11 == 3) {
                this.f21724a.showDialog(2);
                unused = PaymentConfirmActivity.f21615m;
                payPalService2 = this.f21724a.f21625j;
                Objects.toString(payPalService2.N().f21000b);
                payPalService3 = this.f21724a.f21625j;
                D = this.f21724a.D();
                payPalService3.x(D, true);
            }
        }
    }

    @Override // com.paypal.android.sdk.payments.e1
    public final void a(Object obj) {
        PayPalService payPalService;
        r1 r1Var;
        if (obj instanceof ProofOfPayment) {
            payPalService = this.f21724a.f21625j;
            String W = payPalService.W();
            r1Var = this.f21724a.f21622g;
            PaymentConfirmation paymentConfirmation = new PaymentConfirmation(W, r1Var.a(), (ProofOfPayment) obj);
            Intent intent = this.f21724a.getIntent();
            intent.putExtra("com.paypal.android.sdk.paymentConfirmation", paymentConfirmation);
            this.f21724a.u();
            this.f21724a.setResult(-1, intent);
            this.f21724a.finish();
        } else if (obj instanceof l3) {
            this.f21724a.f21620e = false;
            PaymentConfirmActivity.i(this.f21724a, (l3) obj);
        }
    }
}
