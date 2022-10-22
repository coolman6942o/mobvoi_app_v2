package com.paypal.android.sdk.payments;

import com.huawei.agconnect.exception.AGCServerException;
import com.paypal.android.sdk.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h1 {

    /* renamed from: a  reason: collision with root package name */
    Integer f21730a;

    /* renamed from: b  reason: collision with root package name */
    String f21731b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h1(PayPalService payPalService, String str, Integer num, String str2) {
        this.f21731b = str;
        this.f21730a = num;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        Integer num = this.f21730a;
        return num != null && num.equals(Integer.valueOf((int) AGCServerException.TOKEN_INVALID));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        return a() && this.f21731b.equals("2fa_required");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c() {
        return this.f21731b.equals(by.SERVER_COMMUNICATION_ERROR.toString());
    }
}
