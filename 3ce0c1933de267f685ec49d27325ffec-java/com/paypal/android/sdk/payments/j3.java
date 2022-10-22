package com.paypal.android.sdk.payments;

import android.os.Bundle;
import com.paypal.android.sdk.dv;
/* loaded from: classes2.dex */
class j3 {
    public static h3 a(Bundle bundle) {
        String string = bundle.getString("authAccount");
        String string2 = bundle.getString("code");
        String string3 = bundle.getString("nonce");
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                String.format("%s:null", str);
            } else {
                String.format("%s:%s (%s)", str, obj.toString(), obj.getClass().getName());
            }
        }
        return new h3(string3, new dv(string2, null), string);
    }
}
