package com.paypal.android.sdk;

import com.mobvoi.wear.util.AppUpdateUtil;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pi.a;
/* loaded from: classes2.dex */
public final class w3 extends s3 {

    /* renamed from: p  reason: collision with root package name */
    public String f22045p;

    /* renamed from: q  reason: collision with root package name */
    public String f22046q;

    /* renamed from: r  reason: collision with root package name */
    public long f22047r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f22048s;

    public w3(String str, s1 s1Var, z zVar, String str2) {
        super(dc.PreAuthRequest, s1Var, zVar, s3.C(str, str2));
    }

    @Override // com.paypal.android.sdk.r1
    public final String h() {
        HashMap hashMap = new HashMap();
        hashMap.put("response_type", "token");
        hashMap.put("grant_type", "client_credentials");
        hashMap.put("return_authn_schemes", "true");
        hashMap.put(a.TAB_NAME, y1.c(x2.a().toString()));
        hashMap.put(AppUpdateUtil.APP_INFO, y1.c(t2.b().toString()));
        hashMap.put("risk_data", y1.c(t.c().n().toString()));
        return y1.d(hashMap);
    }

    @Override // com.paypal.android.sdk.r1
    public final void j() {
        JSONObject u10 = u();
        try {
            this.f22045p = u10.getString("access_token");
            this.f22046q = u10.getString("scope");
            this.f22047r = u10.getLong("expires_in");
            JSONArray jSONArray = u10.getJSONArray("supported_authn_schemes");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                if (jSONArray.get(i10).equals("phone_pin")) {
                    this.f22048s = true;
                }
            }
        } catch (JSONException unused) {
            D(u10);
        }
    }

    @Override // com.paypal.android.sdk.r1
    public final void l() {
        D(u());
    }

    @Override // com.paypal.android.sdk.r1
    public final String m() {
        return "{\"scope\":\"https://api.paypal.com/v1/payments/.* https://api.paypal.com/v1/vault/credit-card https://api.paypal.com/v1/vault/credit-card/.* openid\",\"access_token\":\"iPVzWUwTo1fEG6n.2sTZCahv8wa2b8uGpBs1KZ-6XxA\",\"token_type\":\"Bearer\",\"expires_in\":900,\"supported_authn_schemes\": [ \"email_password\", \"phone_pin\" ]}";
    }
}
