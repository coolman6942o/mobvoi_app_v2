package com.paypal.android.sdk;
/* loaded from: classes2.dex */
public final class n3 extends v3 {

    /* renamed from: m  reason: collision with root package name */
    private String f21467m;

    public n3(s1 s1Var, z zVar, String str, String str2) {
        super(dc.DeleteCreditCardRequest, s1Var, zVar, str);
        this.f21467m = str2;
    }

    @Override // com.paypal.android.sdk.r1
    public final String h() {
        return this.f21467m;
    }

    @Override // com.paypal.android.sdk.r1
    public final void j() {
    }

    @Override // com.paypal.android.sdk.r1
    public final void l() {
        B(u());
    }

    @Override // com.paypal.android.sdk.r1
    public final String m() {
        return "mockDeleteCreditCardResponse";
    }
}
