package com.paypal.android.sdk.payments;

import android.content.Context;
import android.content.Intent;
import com.paypal.android.sdk.a;
import com.paypal.android.sdk.d2;
import com.paypal.android.sdk.f2;
import com.paypal.android.sdk.t2;
import com.paypal.android.sdk.x2;
import com.paypal.android.sdk.y1;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Context f21853a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0(Context context) {
        this.f21853a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String unused;
        String unused2;
        unused = PayPalService.f21587t;
        Context context = this.f21853a;
        new c2();
        a aVar = new a(context, "AndroidBasePrefs", new y1());
        t2.c(aVar);
        x2.b(aVar);
        for (String str : new a1(this)) {
            f2 f2Var = new f2(aVar, str);
            f2Var.e();
            f2Var.f();
            d2.c(str);
        }
        c.a(this.f21853a).e(new Intent("com.paypal.android.sdk.clearAllUserData"));
        unused2 = PayPalService.f21587t;
    }
}
