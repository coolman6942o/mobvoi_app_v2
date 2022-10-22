package com.paypal.android.sdk;

import android.os.Build;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class r3 extends s3 {

    /* renamed from: p  reason: collision with root package name */
    public em f21887p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f21888q;

    /* renamed from: r  reason: collision with root package name */
    private String f21889r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f21890s;

    /* renamed from: t  reason: collision with root package name */
    private final String f21891t;

    /* renamed from: u  reason: collision with root package name */
    private String f21892u;

    /* renamed from: v  reason: collision with root package name */
    private String f21893v;

    /* renamed from: w  reason: collision with root package name */
    public String f21894w;

    /* renamed from: x  reason: collision with root package name */
    public String f21895x;

    /* renamed from: y  reason: collision with root package name */
    public String f21896y;

    /* renamed from: z  reason: collision with root package name */
    public long f21897z;

    public r3(s1 s1Var, z zVar, String str, String str2, em emVar, String str3, String str4, boolean z10, String str5, boolean z11, String str6) {
        this(s1Var, zVar, str, str2, emVar, z10, str5, z11, str6);
        this.f21892u = str3;
        this.f21893v = str4;
    }

    public r3(s1 s1Var, z zVar, String str, String str2, em emVar, boolean z10, String str3, boolean z11, String str4) {
        super(dc.LoginRequest, s1Var, zVar, s3.C(str, str2));
        this.f21887p = emVar;
        this.f21888q = z10;
        this.f21889r = str3;
        this.f21890s = z11;
        this.f21891t = str4;
    }

    public final boolean E() {
        return this.f21892u != null;
    }

    @Override // com.paypal.android.sdk.r1
    public final String h() {
        String e10;
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("response_type", this.f21889r);
        String str2 = this.f21889r;
        if (str2 != null && str2.equals("token")) {
            hashMap.put("scope_consent_context", "access_token");
            if (!y1.i(this.f21891t)) {
                hashMap.put("scope", this.f21891t);
            }
        }
        hashMap.put("risk_data", y1.c(t.c().n().toString()));
        if (this.f21892u != null) {
            hashMap.put("grant_type", "urn:paypal:params:oauth2:grant_type:otp");
            hashMap.put("nonce", this.f21893v);
            JSONObject jSONObject = new JSONObject();
            jSONObject.accumulate("token_identifier", "otp");
            jSONObject.accumulate("token_value", this.f21892u);
            e10 = s3.B(jSONObject);
            str = "2fa_token_claims";
        } else {
            boolean a10 = this.f21887p.a();
            hashMap.put("grant_type", "password");
            if (a10) {
                hashMap.put("email", y1.c(this.f21887p.b()));
                hashMap.put("password", y1.c(this.f21887p.c()));
                hashMap.put("device_name", y1.c(Build.DEVICE));
                hashMap.put("redirect_uri", y1.c("urn:ietf:wg:oauth:2.0:oob"));
                return y1.d(hashMap);
            }
            this.f21887p.d().f();
            hashMap.put(SharedWearInfoHelper.PhoneInfo.TABLE, y1.c("+" + this.f21887p.d().f() + " " + this.f21887p.d().b()));
            e10 = this.f21887p.e();
            str = Constant.KEY_PIN;
        }
        hashMap.put(str, e10);
        hashMap.put("device_name", y1.c(Build.DEVICE));
        hashMap.put("redirect_uri", y1.c("urn:ietf:wg:oauth:2.0:oob"));
        return y1.d(hashMap);
    }

    @Override // com.paypal.android.sdk.r1
    public final void j() {
        JSONObject u10 = u();
        try {
            u10.getString("scope");
            this.f21896y = u10.getString("scope");
            if (this.f21890s) {
                this.f21894w = u10.getString("code");
                this.f21938m = u10.getString("nonce");
                return;
            }
            this.f21895x = u10.getString("access_token");
            this.f21897z = u10.getLong("expires_in");
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
        return "{ \"access_token\": \"mock_access_token\", \"code\": \"mock_code_EJhi9jOPswug9TDOv93qg4Y28xIlqPDpAoqd7biDLpeGCPvORHjP1Fh4CbFPgKMGCHejdDwe9w1uDWnjPCp1lkaFBjVmjvjpFtnr6z1YeBbmfZYqa9faQT_71dmgZhMIFVkbi4yO7hk0LBHXt_wtdsw\", \"scope\": \"https://api.paypal.com/v1/payments/.*\", \"nonce\": \"mock_nonce\", \"token_type\": \"Bearer\",\"expires_in\":28800,\"visitor_id\":\"zVxjDBTRRNfYXdOb19-lcTblxm-6bzXGvSlP76ZiHOudKaAvoxrW8Cg5pA6EjIPpiz4zlw\" }";
    }
}
