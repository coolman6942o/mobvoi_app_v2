package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.ak;
import java.util.HashMap;
/* loaded from: classes2.dex */
final class m3 extends HashMap {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m3() {
        put(w3.openid_connect, ak.OPENID);
        w3 w3Var = w3.oauth_fullname;
        ak akVar = ak.PROFILE;
        put(w3Var, akVar);
        put(w3.oauth_gender, akVar);
        put(w3.oauth_date_of_birth, akVar);
        put(w3.oauth_timezone, akVar);
        put(w3.oauth_locale, akVar);
        put(w3.oauth_language, akVar);
        w3 w3Var2 = w3.oauth_age_range;
        ak akVar2 = ak.PAYPAL_ATTRIBUTES;
        put(w3Var2, akVar2);
        put(w3.oauth_account_verified, akVar2);
        put(w3.oauth_account_type, akVar2);
        put(w3.oauth_account_creation_date, akVar2);
        put(w3.oauth_email, ak.EMAIL);
        w3 w3Var3 = w3.oauth_street_address1;
        ak akVar3 = ak.ADDRESS;
        put(w3Var3, akVar3);
        put(w3.oauth_street_address2, akVar3);
        put(w3.oauth_city, akVar3);
        put(w3.oauth_state, akVar3);
        put(w3.oauth_country, akVar3);
        put(w3.oauth_zip, akVar3);
        put(w3.oauth_phone_number, ak.PHONE);
    }
}
