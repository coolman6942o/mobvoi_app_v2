package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.Intent;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: classes2.dex */
public final class FuturePaymentConsentActivity extends k3 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void y(Activity activity, int i10, PayPalConfiguration payPalConfiguration) {
        Intent intent = new Intent(activity, FuturePaymentConsentActivity.class);
        intent.putExtras(activity.getIntent());
        intent.putExtra("com.paypal.android.sdk.paypalConfiguration", payPalConfiguration);
        activity.startActivityForResult(intent, 1);
    }

    @Override // com.paypal.android.sdk.payments.k3
    protected final void a() {
        this.f21762c = new PayPalOAuthScopes(new HashSet(Arrays.asList(PayPalOAuthScopes.f21563b)));
    }
}
