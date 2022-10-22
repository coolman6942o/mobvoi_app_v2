package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class t2 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PaymentMethodActivity f21808a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t2(PaymentMethodActivity paymentMethodActivity) {
        this.f21808a = paymentMethodActivity;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        PayPalService payPalService;
        String unused;
        String unused2;
        unused = PaymentMethodActivity.f21631k;
        if (this.f21808a.isFinishing()) {
            unused2 = PaymentMethodActivity.f21631k;
            return;
        }
        this.f21808a.f21639h = ((f1) iBinder).f21723a;
        payPalService = this.f21808a.f21639h;
        if (payPalService.E(new u2(this))) {
            PaymentMethodActivity.p(this.f21808a);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f21808a.f21639h = null;
    }
}
