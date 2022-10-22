package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class s3 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k3 f21805a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s3(k3 k3Var) {
        this.f21805a = k3Var;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String unused;
        unused = k3.f21758k;
        k3 k3Var = this.f21805a;
        PayPalService payPalService = ((f1) iBinder).f21723a;
        k3Var.f21760a = payPalService;
        if (payPalService.E(new t3(this))) {
            k3.o(this.f21805a);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f21805a.f21760a = null;
    }
}
