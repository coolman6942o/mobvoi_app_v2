package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class y1 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PaymentConfirmActivity f21851a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y1(PaymentConfirmActivity paymentConfirmActivity) {
        this.f21851a = paymentConfirmActivity;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        PayPalService payPalService;
        String unused;
        unused = PaymentConfirmActivity.f21615m;
        this.f21851a.f21625j = ((f1) iBinder).f21723a;
        payPalService = this.f21851a.f21625j;
        if (payPalService.E(new z1(this))) {
            PaymentConfirmActivity.q(this.f21851a);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f21851a.f21625j = null;
    }
}
