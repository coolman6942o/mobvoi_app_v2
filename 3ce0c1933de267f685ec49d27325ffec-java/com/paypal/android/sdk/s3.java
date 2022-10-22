package com.paypal.android.sdk;

import android.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class s3 extends q1 {

    /* renamed from: m  reason: collision with root package name */
    public String f21938m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f21939n;

    /* renamed from: o  reason: collision with root package name */
    public Map f21940o;

    public s3(dc dcVar, s1 s1Var, z zVar, String str) {
        super(new x1(dcVar), s1Var, zVar, str);
        e("Accept", "application/json; charset=utf-8");
        e("Accept-Language", "en_US");
        e("Content-Type", "application/x-www-form-urlencoded");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String B(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        return y1.c(jSONArray.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String C(String str, String str2) {
        String str3;
        StringBuilder sb2 = new StringBuilder("Basic ");
        if (!n0.a(str) || str2 != null) {
            str3 = new String(Base64.encode(str2.getBytes(), 2)) + ":";
        } else {
            str3 = "mock:";
        }
        sb2.append(str3);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D(JSONObject jSONObject) {
        String string = jSONObject.getString("error");
        String optString = jSONObject.optString("error_description");
        if (jSONObject.has("nonce")) {
            this.f21938m = jSONObject.getString("nonce");
        }
        if (jSONObject.has("2fa_enabled") && jSONObject.getBoolean("2fa_enabled")) {
            this.f21939n = true;
            this.f21940o = new LinkedHashMap();
            if (jSONObject.has("2fa_token_identifier")) {
                JSONArray jSONArray = jSONObject.getJSONArray("2fa_token_identifier");
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                    String string2 = jSONObject2.getString("type");
                    String string3 = jSONObject2.getString("token_identifier");
                    String string4 = jSONObject2.getString("token_identifier_display");
                    if ("sms_otp".equals(string2)) {
                        this.f21940o.put(string3, string4);
                    }
                }
            }
        }
        f(string, optString, null);
    }
}
