package com.paypal.android.sdk;

import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class p3 extends q1 {

    /* renamed from: m  reason: collision with root package name */
    private Map f21502m;

    /* renamed from: n  reason: collision with root package name */
    private String f21503n;

    /* renamed from: o  reason: collision with root package name */
    private String f21504o;

    /* renamed from: p  reason: collision with root package name */
    private String f21505p;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public p3(s1 s1Var, z zVar, String str, String str2, String str3) {
        super(r1, s1Var, zVar, r4, "/" + str3);
        x1 x1Var = new x1(dc.GetAppInfoRequest);
        StringBuilder sb2 = new StringBuilder("Bearer ");
        if (n0.a(str) && str2 == null) {
            str2 = "mock_euat";
        }
        sb2.append(str2);
        String sb3 = sb2.toString();
        this.f21502m = new HashMap();
        e("Content-Type", "application/x-www-form-urlencoded");
    }

    private static void B(JSONArray jSONArray, Map map) {
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (jSONObject != null) {
                    String optString = jSONObject.optString(ContactConstant.CallsRecordKeys.NAME);
                    String optString2 = jSONObject.optString(HealthDataProviderContracts.NAME_VALUE);
                    if (y1.m(optString) && y1.m(optString2)) {
                        map.put(optString, optString2);
                    }
                }
            }
        }
    }

    public final Map C() {
        return this.f21502m;
    }

    public final String D() {
        return this.f21503n;
    }

    public final String E() {
        return this.f21504o;
    }

    public final String F() {
        return this.f21505p;
    }

    @Override // com.paypal.android.sdk.r1
    public final String h() {
        return "";
    }

    @Override // com.paypal.android.sdk.r1
    public final void j() {
        JSONObject jSONObject;
        JSONObject u10 = u();
        JSONArray optJSONArray = u10.optJSONArray("capabilities");
        if (optJSONArray != null) {
            int i10 = 0;
            while (true) {
                if (i10 >= optJSONArray.length()) {
                    jSONObject = null;
                    break;
                }
                jSONObject = optJSONArray.getJSONObject(i10);
                if (jSONObject != null && "PAYPAL_ACCESS".equals(jSONObject.optString(ContactConstant.CallsRecordKeys.NAME))) {
                    break;
                }
                i10++;
            }
            if (jSONObject != null) {
                B(jSONObject.optJSONArray("attributes"), this.f21502m);
                this.f21502m.toString();
            }
        }
        JSONArray optJSONArray2 = u10.optJSONArray("attributes");
        if (optJSONArray2 != null) {
            HashMap hashMap = new HashMap();
            B(optJSONArray2, hashMap);
            this.f21503n = (String) hashMap.get("privacy_policy_url");
            this.f21504o = (String) hashMap.get("user_agreement_url");
            this.f21505p = (String) hashMap.get("display_name");
        }
    }

    @Override // com.paypal.android.sdk.r1
    public final void l() {
    }

    @Override // com.paypal.android.sdk.r1
    public final String m() {
        return " {\n     \"attributes\": [\n         {\n             \"name\": \"display_name\",\n             \"value\": \"Example Merchant\"\n         },\n         {\n             \"name\": \"privacy_policy_url\",\n             \"value\": \"http://www.example.com/privacy-policy\"\n         },\n         {\n             \"name\": \"user_agreement_url\",\n             \"value\": \"http://www.example.com/user-agreement\"\n         }\n     ],\n     \"name\": \"LiveTestApp\",\n     \"capabilities\": [\n         {\n             \"scopes\": [],\n             \"name\": \"PAYPAL_ACCESS\",\n             \"attributes\": [\n                 {\n                     \"name\": \"openid_connect\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_date_of_birth\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_fullname\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_gender\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_zip\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_language\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_city\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_country\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_timezone\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_email\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_street_address1\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_street_address2\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_phone_number\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_locale\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_state\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_age_range\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_account_verified\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_account_creation_date\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_account_type\",\n                     \"value\": \"Y\"\n                 }\n             ]\n         },\n         {\n             \"scopes\": [\n                 \"https://api.paypal.com/v1/payments/.*\",\n                 \"https://api.paypal.com/v1/vault/credit-card\",\n                 \"https://api.paypal.com/v1/vault/credit-card/.*\"\n             ],\n             \"name\": \"PAYMENT\",\n             \"features\": [\n                 {\n                     \"status\": \"ACTIVE\",\n                     \"name\": \"ACCEPT_CARD\"\n                 },\n                 {\n                     \"status\": \"ACTIVE\",\n                     \"name\": \"ACCEPT_PAYPAL\"\n                 }\n             ]\n         }\n     ]\n }    ";
    }
}
