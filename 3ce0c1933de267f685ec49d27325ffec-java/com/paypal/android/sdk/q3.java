package com.paypal.android.sdk;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class q3 extends s3 {

    /* renamed from: p  reason: collision with root package name */
    private final String f21859p;

    /* renamed from: q  reason: collision with root package name */
    private final String f21860q;

    public q3(s1 s1Var, z zVar, String str, String str2, String str3, String str4) {
        super(dc.LoginChallengeRequest, s1Var, zVar, s3.C(str, str2));
        this.f21859p = str3;
        this.f21860q = str4;
    }

    @Override // com.paypal.android.sdk.r1
    public final String h() {
        HashMap hashMap = new HashMap();
        hashMap.put("authn_schemes", "2fa_pre_login");
        hashMap.put("nonce", this.f21859p);
        JSONObject jSONObject = new JSONObject();
        jSONObject.accumulate("authn_scheme", "security_key_sms_token");
        jSONObject.accumulate("token_identifier", this.f21860q);
        hashMap.put("2fa_token_identifiers", s3.B(jSONObject));
        return y1.d(hashMap);
    }

    @Override // com.paypal.android.sdk.r1
    public final void j() {
        JSONObject u10 = u();
        try {
            this.f21938m = u10.getString("nonce");
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
        return "{\"nonce\": \"mock-login-challenge-nonce\"}";
    }
}
