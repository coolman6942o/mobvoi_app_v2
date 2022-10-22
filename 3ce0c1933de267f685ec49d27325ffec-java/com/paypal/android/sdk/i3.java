package com.paypal.android.sdk;

import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.util.AppUpdateUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pi.a;
/* loaded from: classes2.dex */
public final class i3 extends v3 {

    /* renamed from: m  reason: collision with root package name */
    private final String f21351m;

    /* renamed from: n  reason: collision with root package name */
    private final String f21352n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f21353o;

    /* renamed from: p  reason: collision with root package name */
    private final JSONObject f21354p;

    /* renamed from: q  reason: collision with root package name */
    private final JSONObject f21355q;

    /* renamed from: r  reason: collision with root package name */
    private JSONObject f21356r;

    /* renamed from: s  reason: collision with root package name */
    private String f21357s;

    /* renamed from: t  reason: collision with root package name */
    private String f21358t;

    /* renamed from: u  reason: collision with root package name */
    private String f21359u;

    /* renamed from: v  reason: collision with root package name */
    private String f21360v;

    public i3(s1 s1Var, z zVar, String str, String str2, boolean z10, String str3, String str4, String str5, String str6, JSONObject jSONObject, JSONObject jSONObject2) {
        super(dc.ApproveAndExecuteSfoPaymentRequest, s1Var, zVar, str);
        this.f21353o = z10;
        this.f21351m = str5;
        this.f21352n = str6;
        this.f21354p = jSONObject;
        this.f21355q = jSONObject2;
        e("PayPal-Request-Id", str2);
        if (y1.m(str3)) {
            e("PayPal-Partner-Attribution-Id", str3);
        }
        if (y1.m(str4)) {
            e("PayPal-Client-Metadata-Id", str4);
        }
    }

    private static String C(JSONArray jSONArray) {
        JSONObject jSONObject;
        JSONArray jSONArray2;
        JSONObject jSONObject2;
        if (jSONArray == null) {
            return null;
        }
        try {
            jSONObject = jSONArray.getJSONObject(0);
        } catch (JSONException unused) {
        }
        if (jSONObject == null || (jSONArray2 = jSONObject.getJSONArray("related_resources")) == null || (jSONObject2 = jSONArray2.getJSONObject(0)) == null) {
            return null;
        }
        JSONObject optJSONObject = jSONObject2.optJSONObject("authorization");
        if (optJSONObject != null) {
            return optJSONObject.optString("id");
        }
        JSONObject optJSONObject2 = jSONObject2.optJSONObject("order");
        if (optJSONObject2 != null) {
            return optJSONObject2.optString("id");
        }
        return null;
    }

    public final String D() {
        return this.f21351m;
    }

    public final boolean E() {
        return this.f21353o;
    }

    public final String F() {
        return this.f21357s;
    }

    public final String G() {
        return this.f21358t;
    }

    public final String H() {
        return this.f21359u;
    }

    public final String I() {
        return this.f21360v;
    }

    @Override // com.paypal.android.sdk.r1
    public final String h() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.accumulate("payment_id", this.f21351m);
        jSONObject.accumulate("session_id", this.f21352n);
        JSONObject jSONObject2 = this.f21355q;
        if (jSONObject2 != null) {
            jSONObject.accumulate("funding_option", jSONObject2);
        }
        JSONObject jSONObject3 = this.f21354p;
        if (jSONObject3 != null) {
            jSONObject.accumulate("shipping_address", jSONObject3);
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.accumulate(a.TAB_NAME, y1.c(x2.a().toString()));
        jSONObject4.accumulate(AppUpdateUtil.APP_INFO, y1.c(t2.b().toString()));
        jSONObject4.accumulate("risk_data", y1.c(t.c().n().toString()));
        jSONObject.accumulate("client_info", jSONObject4);
        return jSONObject.toString();
    }

    @Override // com.paypal.android.sdk.r1
    public final void j() {
        try {
            JSONObject jSONObject = u().getJSONObject("payment");
            this.f21356r = jSONObject;
            this.f21357s = jSONObject.optString("state");
            this.f21358t = this.f21356r.optString(WearPath.RecorderV2.MAP_KEY_CREATE_TIME);
            this.f21359u = this.f21356r.optString("intent");
            this.f21360v = C(this.f21356r.getJSONArray("transactions"));
        } catch (JSONException unused) {
            l();
        }
    }

    @Override // com.paypal.android.sdk.r1
    public final void l() {
        B(u());
    }

    @Override // com.paypal.android.sdk.r1
    public final String m() {
        return "{     \"payment\": {         \"id\": \"PAY-6PU626847B294842SKPEWXHY\",         \"transactions\": [             {                 \"amount\": {                     \"total\": \"2.85\",                     \"details\": {                         \"subtotal\": \"2.85\"                     },                     \"currency\": \"USD\"                 },                 \"description\": \"Awesome Sauce\",                 \"related_resources\": [                     {                         \"sale\": {                             \"amount\": {                                 \"total\": \"2.85\",                                 \"currency\": \"USD\"                             },                             \"id\": \"5LR21373K59921925\",                             \"parent_payment\": \"PAY-6PU626847B294842SKPEWXHY\",                             \"update_time\": \"2014-07-18T18:47:06Z\",                             \"state\": \"completed\",                             \"create_time\": \"2014-07-18T18:46:55Z\",                             \"links\": [                                 {                                     \"method\": \"GET\",                                     \"rel\": \"self\",                                     \"href\": \"https://www.stage2std019.stage.\"                                 },                                 {                                     \"method\": \"POST\",                                     \"rel\": \"refund\",                                     \"href\": \"https://www.stage2std019.stage. \"                                 },                                 {                                     \"method\": \"GET\",                                     \"rel\": \"parent_payment\",                                     \"href\": \"https://www.stage2std019.stage.PEWXHY \"                                 }                             ]                         }                     }                 ]             }         ],         \"update_time\": \"2014-07-18T18:47:06Z\",         \"payer\": {             \"payer_info\": {                 \"shipping_address\": {                                      }             },             \"payment_method\": \"paypal\"         },         \"state\": \"approved\",         \"create_time\": \"2014-07-18T18:46:55Z\",         \"links\": [             {                 \"method\": \"GET\",                 \"rel\": \"self\",                 \"href\": \"https://www.stage2std019.stage.paypal.\"             }         ],         \"intent\": \"sale\"     } } ";
    }

    @Override // com.paypal.android.sdk.r1
    public final void t() {
        t.c().w();
    }
}
