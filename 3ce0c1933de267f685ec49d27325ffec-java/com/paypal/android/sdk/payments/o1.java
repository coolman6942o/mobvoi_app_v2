package com.paypal.android.sdk.payments;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o1 implements g1 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PaymentActivity f21785a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o1(PaymentActivity paymentActivity) {
        this.f21785a = paymentActivity;
    }

    @Override // com.paypal.android.sdk.payments.g1
    public final void a() {
        Date date;
        Date date2;
        Timer timer;
        String unused;
        Date time = Calendar.getInstance().getTime();
        date = this.f21785a.f21611b;
        if (date.compareTo(time) > 0) {
            date2 = this.f21785a.f21611b;
            long time2 = date2.getTime() - time.getTime();
            unused = PaymentActivity.f21609f;
            this.f21785a.f21610a = new Timer();
            timer = this.f21785a.f21610a;
            timer.schedule(new p1(this), time2);
            return;
        }
        this.f21785a.f();
    }

    @Override // com.paypal.android.sdk.payments.g1
    public final void a(h1 h1Var) {
        c2.p(this.f21785a, h1Var, 1, 2, 3);
    }
}
