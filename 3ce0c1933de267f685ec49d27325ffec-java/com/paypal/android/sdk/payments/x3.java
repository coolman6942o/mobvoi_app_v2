package com.paypal.android.sdk.payments;

import android.content.Intent;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class x3 {

    /* renamed from: a  reason: collision with root package name */
    Intent f21847a;

    /* renamed from: b  reason: collision with root package name */
    PayPalConfiguration f21848b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x3(Intent intent, PayPalConfiguration payPalConfiguration) {
        this.f21847a = intent;
        this.f21848b = payPalConfiguration;
        if (!intent.hasExtra("com.paypal.android.sdk.paypalConfiguration")) {
            Log.w(a(), "Please add PayPalService.EXTRA_PAYPAL_CONFIGURATION to this activity for restart resiliency.");
        }
    }

    abstract String a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(boolean z10, String str) {
        if (!z10) {
            String a10 = a();
            Log.e(a10, str + " is invalid.  Please see the docs.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c() {
        if (this.f21848b.x()) {
            return true;
        }
        Log.e(a(), "Service extra invalid.");
        return false;
    }
}
