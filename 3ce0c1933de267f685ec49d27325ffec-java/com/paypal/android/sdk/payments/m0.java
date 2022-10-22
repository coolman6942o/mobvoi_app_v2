package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PayPalFuturePaymentActivity f21775a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0(PayPalFuturePaymentActivity payPalFuturePaymentActivity) {
        this.f21775a = payPalFuturePaymentActivity;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        PayPalService payPalService;
        String unused;
        String unused2;
        unused = PayPalFuturePaymentActivity.f21551f;
        if (this.f21775a.isFinishing()) {
            unused2 = PayPalFuturePaymentActivity.f21551f;
            return;
        }
        this.f21775a.f21554c = ((f1) iBinder).f21723a;
        payPalService = this.f21775a.f21554c;
        if (payPalService.E(new n0(this))) {
            PayPalFuturePaymentActivity.h(this.f21775a);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        String unused;
        this.f21775a.f21554c = null;
        unused = PayPalFuturePaymentActivity.f21551f;
    }
}
