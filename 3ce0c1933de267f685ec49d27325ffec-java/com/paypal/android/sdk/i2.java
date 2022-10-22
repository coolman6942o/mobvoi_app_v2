package com.paypal.android.sdk;

import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes2.dex */
public class i2 extends n {
    public final Intent f(String str, Cdo doVar, dp dpVar, String str2) {
        Intent c10 = n.c("com.paypal.android.p2pmobile.Sdk", "com.paypal.android.lib.authenticator.activity.SdkActivity");
        Bundle bundle = new Bundle();
        bundle.putString("target_client_id", str);
        if (doVar != null) {
            bundle.putString("token_request_type", doVar.toString());
        }
        if (dpVar != null) {
            bundle.putString("response_type", dpVar.toString());
        }
        bundle.putString("app_guid", str2);
        bundle.toString();
        c10.putExtras(bundle);
        return c10;
    }
}
