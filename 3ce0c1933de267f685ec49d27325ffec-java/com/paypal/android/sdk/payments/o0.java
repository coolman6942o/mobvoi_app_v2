package com.paypal.android.sdk.payments;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o0 implements g1 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PayPalFuturePaymentActivity f21784a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(PayPalFuturePaymentActivity payPalFuturePaymentActivity) {
        this.f21784a = payPalFuturePaymentActivity;
    }

    @Override // com.paypal.android.sdk.payments.g1
    public final void a() {
        Date date;
        Date date2;
        Timer timer;
        String unused;
        Date time = Calendar.getInstance().getTime();
        date = this.f21784a.f21552a;
        if (date.compareTo(time) > 0) {
            date2 = this.f21784a.f21552a;
            long time2 = date2.getTime() - time.getTime();
            unused = PayPalFuturePaymentActivity.f21551f;
            this.f21784a.f21553b = new Timer();
            timer = this.f21784a.f21553b;
            timer.schedule(new p0(this), time2);
            return;
        }
        this.f21784a.f();
    }

    @Override // com.paypal.android.sdk.payments.g1
    public final void a(h1 h1Var) {
        c2.p(this.f21784a, h1Var, 1, 2, 3);
    }
}
