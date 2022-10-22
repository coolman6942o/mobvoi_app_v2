package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.Intent;
/* loaded from: classes2.dex */
public final class ProfileSharingConsentActivity extends k3 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void y(Activity activity, int i10, PayPalConfiguration payPalConfiguration) {
        Intent intent = new Intent(activity, ProfileSharingConsentActivity.class);
        intent.putExtras(activity.getIntent());
        intent.putExtra("com.paypal.android.sdk.paypalConfiguration", payPalConfiguration);
        activity.startActivityForResult(intent, 1);
    }

    @Override // com.paypal.android.sdk.payments.k3
    protected final void a() {
        this.f21762c = (PayPalOAuthScopes) getIntent().getParcelableExtra("com.paypal.android.sdk.requested_scopes");
    }
}
