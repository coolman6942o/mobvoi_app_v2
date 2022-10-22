package com.paypal.android.sdk;
/* JADX WARN: Init of enum a can be incorrect */
/* JADX WARN: Init of enum b can be incorrect */
/* JADX WARN: Init of enum c can be incorrect */
/* JADX WARN: Init of enum d can be incorrect */
/* JADX WARN: Init of enum e can be incorrect */
/* JADX WARN: Init of enum f can be incorrect */
/* JADX WARN: Init of enum g can be incorrect */
/* JADX WARN: Init of enum h can be incorrect */
/* JADX WARN: Init of enum i can be incorrect */
/* JADX WARN: Init of enum l can be incorrect */
/* loaded from: classes2.dex */
public enum dc {
    FptiRequest(r1, null),
    PreAuthRequest(r1, "oauth2/token"),
    LoginRequest(r1, "oauth2/login"),
    LoginChallengeRequest(r1, "oauth2/login/challenge"),
    ConsentRequest(r1, "oauth2/consent"),
    CreditCardPaymentRequest(r1, "payments/payment"),
    PayPalPaymentRequest(r1, "payments/payment"),
    CreateSfoPaymentRequest(r1, "orchestration/msdk-create-sfo-payment"),
    ApproveAndExecuteSfoPaymentRequest(r1, "orchestration/msdk-approve-and-execute-sfo-payment"),
    TokenizeCreditCardRequest(r1, "vault/credit-card"),
    DeleteCreditCardRequest(ca.DELETE, "vault/credit-card"),
    GetAppInfoRequest(ca.GET, "apis/applications");
    

    /* renamed from: m  reason: collision with root package name */
    private ca f21123m;

    /* renamed from: n  reason: collision with root package name */
    private String f21124n;

    static {
        ca caVar = ca.POST;
    }

    dc(ca caVar, String str) {
        this.f21123m = caVar;
        this.f21124n = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ca a() {
        return this.f21123m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() {
        return this.f21124n;
    }
}
