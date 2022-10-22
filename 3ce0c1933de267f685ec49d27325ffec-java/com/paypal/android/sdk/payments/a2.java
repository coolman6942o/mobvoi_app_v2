package com.paypal.android.sdk.payments;

import android.app.AlertDialog;
import android.view.View;
import com.paypal.android.sdk.e4;
import com.paypal.android.sdk.ft;
import com.paypal.android.sdk.z3;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e4 f21660a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f21661b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ PaymentConfirmActivity f21662c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a2(PaymentConfirmActivity paymentConfirmActivity, e4 e4Var, ArrayList arrayList) {
        this.f21662c = paymentConfirmActivity;
        this.f21660a = e4Var;
        this.f21661b = arrayList;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle(z3.a(ft.PREFERRED_PAYMENT_METHOD)).setAdapter(this.f21660a, new b2(this));
        builder.create().show();
    }
}
