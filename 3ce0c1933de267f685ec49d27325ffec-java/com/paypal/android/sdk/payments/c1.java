package com.paypal.android.sdk.payments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
/* loaded from: classes2.dex */
final class c1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PayPalService f21691a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c1(PayPalService payPalService) {
        this.f21691a = payPalService;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.paypal.android.sdk.clearAllUserData")) {
            this.f21691a.Z();
            Log.w("paypal.sdk", "active service user data cleared");
        }
    }
}
