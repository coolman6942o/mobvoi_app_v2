package com.paypal.android.sdk;

import com.unionpay.tsmservice.data.Constant;
/* loaded from: classes2.dex */
public enum ez {
    PreConnect("preconnect", "", false, false),
    DeviceCheck("devicecheck", "", false, false),
    PaymentMethodWindow("selectpaymentmethod", "", false, false),
    PaymentMethodCancel("selectpaymentmethod", Constant.CASH_LOAD_CANCEL, false, true),
    SelectPayPalPayment("selectpaymentmethod", "paypal", false, true),
    SelectCreditCardPayment("selectpaymentmethod", "card", false, true),
    ConfirmPaymentWindow("confirmpayment", "", false, false),
    ConfirmPayment("confirmpayment", "confirm", false, false),
    ConfirmPaymentCancel("confirmpayment", Constant.CASH_LOAD_CANCEL, false, true),
    PaymentSuccessful("paymentsuccessful", "", false, false),
    LoginWindow("login", "password", true, false),
    LoginPassword("login", "password", true, true),
    LoginPIN("login", "PIN", true, true),
    SignUp("login", "password", true, true),
    LoginForgotPassword("login", "password", true, true),
    LoginCancel("login", Constant.CASH_LOAD_CANCEL, true, true),
    ConsentWindow("authorizationconsent", "", false, false),
    ConsentAgree("authorizationconsent", "agree", false, true),
    ConsentCancel("authorizationconsent", Constant.CASH_LOAD_CANCEL, false, true),
    ConsentMerchantUrl("authorizationconsent", "merchanturl", false, true),
    ConsentPayPalPrivacyUrl("authorizationconsent", "privacy", false, true),
    AuthorizationSuccessful("authorizationsuccessful", "", false, false),
    LegalTextWindow("legaltext", "", false, false);
    
    private boolean A;

    /* renamed from: x  reason: collision with root package name */
    private String f21216x;

    /* renamed from: y  reason: collision with root package name */
    private String f21217y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f21218z;

    ez(String str, String str2, boolean z10, boolean z11) {
        this.f21216x = str;
        this.f21217y = str2;
        this.f21218z = z10;
        this.A = z11;
    }

    public final String a() {
        return this.f21216x + "::" + this.f21217y;
    }

    public final String a(String str, boolean z10) {
        String str2 = this.f21218z ? z10 ? "returnuser" : "newuser" : "";
        return g3.f21311a + ":" + str + ":" + str2;
    }

    public final boolean b() {
        return this.A;
    }
}
