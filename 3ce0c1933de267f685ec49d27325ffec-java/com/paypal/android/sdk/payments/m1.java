package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m1 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PaymentActivity f21776a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m1(PaymentActivity paymentActivity) {
        this.f21776a = paymentActivity;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        PayPalService payPalService;
        String unused;
        String unused2;
        unused = PaymentActivity.f21609f;
        if (this.f21776a.isFinishing()) {
            unused2 = PaymentActivity.f21609f;
            return;
        }
        this.f21776a.f21612c = ((f1) iBinder).f21723a;
        payPalService = this.f21776a.f21612c;
        if (payPalService.E(new n1(this))) {
            PaymentActivity.h(this.f21776a);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        String unused;
        this.f21776a.f21612c = null;
        unused = PaymentActivity.f21609f;
    }
}
