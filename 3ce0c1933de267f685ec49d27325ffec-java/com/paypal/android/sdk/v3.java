package com.paypal.android.sdk;

import com.mobvoi.wear.contacts.ContactConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class v3 extends j3 {
    public v3(dc dcVar, s1 s1Var, z zVar, String str) {
        super(dcVar, s1Var, zVar, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B(JSONObject jSONObject) {
        String str;
        String str2;
        String str3 = "";
        String string = jSONObject.getString(ContactConstant.CallsRecordKeys.NAME);
        String string2 = jSONObject.getString("message");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONArray("details").getJSONObject(0);
            str = jSONObject2.getString("field");
            try {
                str3 = jSONObject2.getString("issue");
                if (string.equals("VALIDATION_ERROR")) {
                    if (str.contains("amount.currency")) {
                        string = "pp_service_error_bad_currency";
                    }
                }
            } catch (JSONException unused) {
                str2 = str3;
                str3 = str;
                str = str3;
                str3 = str2;
                f(string, string2, "field:" + str + ", issue:" + str3);
            }
        } catch (JSONException unused2) {
            str2 = str3;
        }
        f(string, string2, "field:" + str + ", issue:" + str3);
    }
}
