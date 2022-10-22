package com.paypal.android.sdk.payments;

import android.app.AlertDialog;
import android.view.View;
import com.paypal.android.sdk.ft;
import com.paypal.android.sdk.m4;
import com.paypal.android.sdk.z3;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m4 f21788a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ List f21789b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ LoginActivity f21790c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(LoginActivity loginActivity, m4 m4Var, List list) {
        this.f21790c = loginActivity;
        this.f21788a = m4Var;
        this.f21789b = list;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle(z3.a(ft.TWO_FACTOR_AUTH_ENTER_MOBILE_NUMBER)).setAdapter(this.f21788a, new q(this));
        builder.create().show();
    }
}
