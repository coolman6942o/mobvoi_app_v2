package com.paypal.android.sdk.payments;

import android.os.AsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class v2 extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PaymentMethodActivity f21818a;

    private v2(PaymentMethodActivity paymentMethodActivity) {
        this.f21818a = paymentMethodActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v2(PaymentMethodActivity paymentMethodActivity, byte b10) {
        this(paymentMethodActivity);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        String unused;
        String unused2;
        boolean unused3;
        long currentTimeMillis = System.currentTimeMillis();
        unused = PaymentMethodActivity.f21631k;
        this.f21818a.f21635d = c2.x();
        unused2 = PaymentMethodActivity.f21631k;
        unused3 = this.f21818a.f21635d;
        Long.toString(System.currentTimeMillis() - currentTimeMillis);
        this.f21818a.runOnUiThread(new w2(this));
        return null;
    }
}
