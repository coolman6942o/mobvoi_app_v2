package com.paypal.android.sdk.payments;

import android.app.AlertDialog;
import android.view.View;
import com.paypal.android.sdk.ft;
import com.paypal.android.sdk.r4;
import com.paypal.android.sdk.z3;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r4 f21695a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f21696b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ PaymentConfirmActivity f21697c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d2(PaymentConfirmActivity paymentConfirmActivity, r4 r4Var, ArrayList arrayList) {
        this.f21697c = paymentConfirmActivity;
        this.f21695a = r4Var;
        this.f21696b = arrayList;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle(z3.a(ft.SHIPPING_ADDRESS)).setAdapter(this.f21695a, new e2(this));
        builder.create().show();
    }
}
