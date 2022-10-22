package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.b2;
import com.paypal.android.sdk.p0;
import com.paypal.android.sdk.s0;
import java.util.GregorianCalendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k1 {

    /* renamed from: a  reason: collision with root package name */
    private final PayPalService f21752a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21753b = Integer.toString((new GregorianCalendar().getTimeZone().getRawOffset() / 1000) / 60);

    public k1(PayPalService payPalService) {
        this.f21752a = payPalService;
    }

    public final b2 a() {
        return this.f21752a.N();
    }

    public final void b(s0 s0Var) {
        this.f21752a.U(s0Var);
    }

    public final String c() {
        return this.f21752a.Y();
    }

    public final p0 d() {
        return this.f21752a.G();
    }

    public final String e() {
        return this.f21752a.W();
    }

    public final String f() {
        return this.f21753b;
    }

    public final String g() {
        return this.f21752a.o0();
    }
}
