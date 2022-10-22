package com.paypal.android.sdk.payments;

import android.content.Intent;
import com.paypal.android.sdk.ak;
import com.paypal.android.sdk.dg;
import com.paypal.android.sdk.y1;
import java.net.MalformedURLException;
import java.net.URL;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class y0 extends x3 {

    /* renamed from: c  reason: collision with root package name */
    private boolean f21850c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y0(Intent intent, PayPalConfiguration payPalConfiguration, boolean z10) {
        super(intent, payPalConfiguration);
        this.f21850c = z10;
    }

    private static boolean d(String str) {
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    @Override // com.paypal.android.sdk.payments.x3
    protected final String a() {
        return PayPalFuturePaymentActivity.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e() {
        boolean m10 = y1.m(this.f21848b.p());
        b(m10, "merchantName");
        boolean z10 = this.f21848b.r() != null && y1.j(PayPalFuturePaymentActivity.class.getSimpleName(), this.f21848b.r().toString(), "merchantPrivacyPolicyUrl") && d(this.f21848b.r().toString());
        b(z10, "merchantPrivacyPolicyUrl");
        boolean z11 = this.f21848b.v() != null && y1.j(PayPalFuturePaymentActivity.class.getSimpleName(), this.f21848b.v().toString(), "merchantUserAgreementUrl") && d(this.f21848b.v().toString());
        b(z11, "merchantUserAgreementUrl");
        boolean z12 = this.f21850c;
        boolean z13 = !z12;
        if (z12) {
            PayPalOAuthScopes payPalOAuthScopes = (PayPalOAuthScopes) this.f21847a.getParcelableExtra("com.paypal.android.sdk.requested_scopes");
            if (payPalOAuthScopes != null && payPalOAuthScopes.a() != null && payPalOAuthScopes.a().size() > 0) {
                for (String str : payPalOAuthScopes.a()) {
                    if (ak.f20986i.contains(str) || dg.f21133i.contains(str)) {
                    }
                }
                z13 = true;
            }
            z13 = false;
            break;
        }
        b(z13, "paypalScopes");
        return m10 && z10 && z11 && z13;
    }
}
