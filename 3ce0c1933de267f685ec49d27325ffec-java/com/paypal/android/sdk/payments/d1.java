package com.paypal.android.sdk.payments;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d1 implements g1 {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ PayPalService f21694a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d1(PayPalService payPalService) {
        this.f21694a = payPalService;
    }

    @Override // com.paypal.android.sdk.payments.g1
    public final void a() {
        PayPalConfiguration payPalConfiguration;
        payPalConfiguration = this.f21694a.f21592c;
        if (!payPalConfiguration.m()) {
            PayPalService payPalService = this.f21694a;
            if (payPalService.f21608s != null) {
                payPalService.T(payPalService.N().f21000b.b(), this.f21694a.f21608s.h());
                PayPalService payPalService2 = this.f21694a;
                payPalService2.f21608s = null;
                payPalService2.m0();
            }
        }
    }

    @Override // com.paypal.android.sdk.payments.g1
    public final void a(h1 h1Var) {
    }
}
