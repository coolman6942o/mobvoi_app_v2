package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.a2;
import com.paypal.android.sdk.z3;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c3 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        String a10 = a2.a().c().a();
        return String.format("https://www.paypal.com/signup/account?country.x=%s&locale.x=%s", a10, z3.d(a10));
    }
}
