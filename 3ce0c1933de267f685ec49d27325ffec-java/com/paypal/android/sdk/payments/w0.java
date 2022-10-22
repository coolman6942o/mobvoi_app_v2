package com.paypal.android.sdk.payments;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class w0 implements g1 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PayPalProfileSharingActivity f21821a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0(PayPalProfileSharingActivity payPalProfileSharingActivity) {
        this.f21821a = payPalProfileSharingActivity;
    }

    @Override // com.paypal.android.sdk.payments.g1
    public final void a() {
        Date date;
        Date date2;
        Timer timer;
        String unused;
        Date time = Calendar.getInstance().getTime();
        date = this.f21821a.f21582a;
        if (date.compareTo(time) > 0) {
            date2 = this.f21821a.f21582a;
            long time2 = date2.getTime() - time.getTime();
            unused = PayPalProfileSharingActivity.f21581f;
            this.f21821a.f21583b = new Timer();
            timer = this.f21821a.f21583b;
            timer.schedule(new x0(this), time2);
            return;
        }
        ProfileSharingConsentActivity.y(r0, 1, this.f21821a.f21584c.S());
    }

    @Override // com.paypal.android.sdk.payments.g1
    public final void a(h1 h1Var) {
        c2.p(this.f21821a, h1Var, 1, 2, 3);
    }
}
