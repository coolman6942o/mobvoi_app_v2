package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.a2;
import com.paypal.android.sdk.y1;
import com.paypal.android.sdk.z3;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        String a10 = a2.a().c().a();
        return (y1.i(a10) || a10.equalsIgnoreCase("US")) ? "https://www.paypal.com/webapps/accountrecovery/passwordrecovery" : String.format("https://www.paypal.com/%s/cgi-bin/webscr?cmd=_account-recovery&from=%s&locale.x=%s", a10.toLowerCase(), "PayPalMPL", z3.d(a10));
    }
}
