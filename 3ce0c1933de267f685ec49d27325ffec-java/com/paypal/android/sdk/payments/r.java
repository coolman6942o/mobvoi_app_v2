package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f21798a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(LoginActivity loginActivity) {
        this.f21798a = loginActivity;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        PayPalService payPalService;
        this.f21798a.f21531q = ((f1) iBinder).f21723a;
        payPalService = this.f21798a.f21531q;
        if (payPalService.E(new s(this))) {
            this.f21798a.d();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f21798a.f21531q = null;
    }
}
