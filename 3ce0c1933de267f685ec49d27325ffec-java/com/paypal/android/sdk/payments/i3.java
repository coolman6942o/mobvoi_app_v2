package com.paypal.android.sdk.payments;

import android.content.Context;
import com.paypal.android.sdk.i2;
import com.paypal.android.sdk.n0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i3 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, PayPalService payPalService) {
        if (n0.e(payPalService.W())) {
            payPalService.W();
            return false;
        } else if (!payPalService.p0()) {
            return false;
        } else {
            i2 i2Var = new i2();
            return i2Var.e(context, payPalService.q0()) && i2Var.d(context, "com.paypal.android.p2pmobile.Sdk", "com.paypal.android.lib.authenticator.activity.SdkActivity");
        }
    }
}
