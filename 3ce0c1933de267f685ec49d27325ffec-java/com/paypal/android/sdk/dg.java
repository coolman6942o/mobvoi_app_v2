package com.paypal.android.sdk;

import java.util.Collection;
import java.util.HashSet;
/* loaded from: classes2.dex */
public enum dg {
    GET_FUNDING_OPTIONS("https://uri.paypal.com/services/payments/funding-options"),
    PAYMENT_CODE("https://uri.paypal.com/services/pos/payments"),
    MIS_CUSTOMER("https://uri.paypal.com/services/mis/customer"),
    FINANCIAL_INSTRUMENTS("https://uri.paypal.com/services/wallet/financial-instruments/view"),
    SEND_MONEY("https://uri.paypal.com/services/wallet/sendmoney"),
    REQUEST_MONEY("https://uri.paypal.com/services/wallet/money-request/requests"),
    LOYALTY("https://uri.paypal.com/services/loyalty/memberships/update"),
    EXPRESS_CHECKOUT("https://uri.paypal.com/services/expresscheckout");
    

    /* renamed from: i  reason: collision with root package name */
    public static final Collection f21133i = new HashSet() { // from class: com.paypal.android.sdk.e2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            for (dg dgVar : dg.values()) {
                add(dgVar.a());
            }
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private String f21135j;

    dg(String str) {
        this.f21135j = str;
    }

    public final String a() {
        return this.f21135j;
    }
}
