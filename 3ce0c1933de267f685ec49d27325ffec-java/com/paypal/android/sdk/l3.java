package com.paypal.android.sdk;

import com.mobvoi.wear.providers.OtaColumn;
import com.mobvoi.wear.util.AppUpdateUtil;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import pi.a;
/* loaded from: classes2.dex */
public final class l3 extends v3 {
    private String A;
    private String B;

    /* renamed from: m  reason: collision with root package name */
    private String f21431m;

    /* renamed from: n  reason: collision with root package name */
    private String f21432n;

    /* renamed from: o  reason: collision with root package name */
    private JSONArray f21433o;

    /* renamed from: p  reason: collision with root package name */
    private JSONObject f21434p;

    /* renamed from: q  reason: collision with root package name */
    private JSONArray f21435q;

    /* renamed from: r  reason: collision with root package name */
    private eo f21436r;

    /* renamed from: s  reason: collision with root package name */
    private Map f21437s;

    /* renamed from: t  reason: collision with root package name */
    private t3[] f21438t;

    /* renamed from: u  reason: collision with root package name */
    private String f21439u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f21440v;

    /* renamed from: w  reason: collision with root package name */
    private String f21441w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f21442x;

    /* renamed from: y  reason: collision with root package name */
    private String f21443y;

    /* renamed from: z  reason: collision with root package name */
    private String f21444z;

    public l3(s1 s1Var, z zVar, String str, String str2, String str3, eo eoVar, Map map, t3[] t3VarArr, String str4, boolean z10, String str5, String str6, String str7, boolean z11) {
        super(dc.CreateSfoPaymentRequest, s1Var, zVar, str);
        this.f21436r = eoVar;
        this.f21437s = map;
        this.f21438t = t3VarArr;
        this.f21439u = str4;
        this.f21442x = z11;
        this.f21441w = str7;
        if (y1.i(str7)) {
            this.f21441w = "sale";
        }
        this.f21441w = this.f21441w.toLowerCase(Locale.US);
        e("PayPal-Request-Id", str2);
        if (y1.m(str5)) {
            e("PayPal-Partner-Attribution-Id", str5);
        }
        if (y1.m(str6)) {
            e("PayPal-Client-Metadata-Id", str6);
        }
    }

    public final l3 C(boolean z10) {
        this.f21440v = z10;
        return this;
    }

    public final l3 D(String str) {
        this.f21443y = str;
        return this;
    }

    public final l3 E(String str) {
        this.f21444z = str;
        return this;
    }

    public final l3 F(String str) {
        this.A = str;
        return this;
    }

    public final l3 G(String str) {
        this.B = str;
        return this;
    }

    public final String H() {
        return this.f21431m;
    }

    public final String I() {
        return this.f21432n;
    }

    public final JSONArray J() {
        return this.f21433o;
    }

    public final JSONObject K() {
        return this.f21434p;
    }

    public final JSONArray L() {
        return this.f21435q;
    }

    @Override // com.paypal.android.sdk.r1
    public final String h() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.accumulate("intent", this.f21441w);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.accumulate("payment_method", "paypal");
        jSONObject2.accumulate("payer", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.accumulate("cancel_url", "http://cancelurl");
        jSONObject4.accumulate("return_url", "http://returnurl");
        jSONObject2.accumulate("redirect_urls", jSONObject4);
        eo eoVar = this.f21436r;
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.accumulate("currency", eoVar.b().getCurrencyCode());
        jSONObject5.accumulate("total", eoVar.a().toPlainString());
        Map map = this.f21437s;
        if (map != null && !map.isEmpty()) {
            Map map2 = this.f21437s;
            if (map2 == null || map2.isEmpty()) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject();
                if (this.f21437s.containsKey("shipping")) {
                    jSONObject.accumulate("shipping", this.f21437s.get("shipping"));
                }
                if (this.f21437s.containsKey("subtotal")) {
                    jSONObject.accumulate("subtotal", this.f21437s.get("subtotal"));
                }
                if (this.f21437s.containsKey("tax")) {
                    jSONObject.accumulate("tax", this.f21437s.get("tax"));
                }
            }
            jSONObject5.accumulate("details", jSONObject);
        }
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.accumulate("amount", jSONObject5);
        jSONObject6.accumulate(OtaColumn.COLUMN_DESCRIPTION, this.f21439u);
        t3[] t3VarArr = this.f21438t;
        if (t3VarArr != null && t3VarArr.length > 0) {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.accumulate("items", t3.a(this.f21438t));
            jSONObject6.accumulate("item_list", jSONObject7);
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject6);
        jSONObject2.accumulate("transactions", jSONArray);
        if (y1.m(this.f21443y)) {
            jSONObject6.accumulate("invoice_number", this.f21443y);
        }
        if (y1.m(this.f21444z)) {
            jSONObject6.accumulate("custom", this.f21444z);
        }
        if (y1.m(this.A)) {
            jSONObject6.accumulate("soft_descriptor", this.A);
        }
        if (y1.m(this.B)) {
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.accumulate("email", this.B);
            jSONObject6.accumulate("payee", jSONObject8);
        }
        JSONObject jSONObject9 = new JSONObject();
        jSONObject9.accumulate(a.TAB_NAME, y1.c(x2.a().toString()));
        jSONObject9.accumulate(AppUpdateUtil.APP_INFO, y1.c(t2.b().toString()));
        jSONObject9.accumulate("risk_data", y1.c(t.c().n().toString()));
        JSONObject jSONObject10 = new JSONObject();
        jSONObject10.accumulate("payment", jSONObject2);
        jSONObject10.accumulate("client_info", jSONObject9);
        if (this.f21442x) {
            jSONObject10.accumulate("retrieve_shipping_addresses", Boolean.TRUE);
        }
        jSONObject10.accumulate("no_shipping", Boolean.valueOf(this.f21440v));
        return jSONObject10.toString();
    }

    @Override // com.paypal.android.sdk.r1
    public final void j() {
        JSONObject u10 = u();
        this.f21431m = u10.optString("payment_id");
        this.f21432n = u10.getString("session_id");
        this.f21433o = u10.optJSONArray("addresses");
        JSONObject optJSONObject = u10.optJSONObject("funding_options");
        if (optJSONObject != null) {
            this.f21434p = optJSONObject.optJSONObject("default_option");
            this.f21435q = optJSONObject.optJSONArray("alternate_options");
        }
    }

    @Override // com.paypal.android.sdk.r1
    public final void l() {
        B(u());
    }

    @Override // com.paypal.android.sdk.r1
    public final String m() {
        return "{    \"session_id\":\"7N0112287V303050T\",    \"payment_id\":\"PAY-18X32451H0459092JKO7KFUI\",    \"addresses\": [          {             \"city\": \"Columbia\",              \"line2\": \"6073 2nd Street\",              \"line1\": \"Suite 222\",              \"recipient_name\": \"Beverly Jello\",             \"state\": \"MD\",              \"postal_code\": \"21045\",             \"default_address\": false,              \"country_code\": \"US\",              \"type\": \"HOME_OR_WORK\",              \"id\": \"366853\"          },          {             \"city\": \"Austin\",              \"line2\": \"Apt. 222\",              \"line1\": \"52 North Main St. \",              \"recipient_name\": \"Michael Chassen\",             \"state\": \"TX\",              \"postal_code\": \"78729\",             \"default_address\": true,              \"country_code\": \"US\",              \"type\": \"HOME_OR_WORK\",              \"id\": \"366852\"          },          {             \"city\": \"Austin\",              \"line1\": \"202 South State St. \",              \"recipient_name\": \"Sam Stone\",             \"state\": \"TX\",              \"postal_code\": \"78729\",             \"default_address\": true,              \"country_code\": \"US\",              \"type\": \"HOME_OR_WORK\",              \"id\": \"366852\"          }     ],     \"funding_options\":{       \"default_option\":{          \"id\":\"1\",          \"backup_funding_instrument\":{             \"payment_card\":{                \"number\":\"8029\",                \"type\":\"VISA\"             }          },          \"funding_sources\":[             {                \"amount\":{                   \"value\":\"216.85\",                   \"currency\":\"USD\"                },                \"funding_instrument_type\":\"BANK_ACCOUNT\",                \"funding_mode\":\"INSTANT_TRANSFER\",                \"bank_account\":{                   \"bank_name\":\"SunTrust\",                   \"account_number\":\"7416\",                   \"account_number_type\":\"BBAN\",                   \"country_code\":\"US\",                   \"account_type\":\"CHECKING\"                }             },             {                \"amount\":{                   \"value\":\"6.00\",                   \"currency\":\"USD\"                },                \"funding_instrument_type\":\"CREDIT\",                \"funding_mode\":\"INSTANT_TRANSFER\",                \"credit\":{                   \"type\":\"BILL_ME_LATER\",                   \"id\":\"mock-id\"                }             }          ]       },       \"alternate_options\":[          {             \"id\":\"2\",             \"funding_sources\":[                {                   \"amount\":{                      \"value\":\"216.85\",                      \"currency\":\"USD\"                   },                   \"funding_instrument_type\":\"PAYMENT_CARD\",                   \"payment_card\":{                      \"number\":\"8029\",                      \"type\":\"VISA\"                   },                   \"funding_mode\":\"INSTANT_TRANSFER\"                },                {                   \"amount\":{                      \"value\":\"6.00\",                      \"currency\":\"USD\"                   },                   \"funding_instrument_type\":\"BALANCE\",                   \"funding_mode\":\"INSTANT_TRANSFER\"                }             ]          },          {             \"id\":\"3\",             \"funding_sources\":[                {                   \"amount\":{                      \"value\":\"216.85\",                      \"currency\":\"USD\"                   },                   \"funding_instrument_type\":\"PAYMENT_CARD\",                   \"payment_card\":{                      \"number\":\"8011\",                      \"type\":\"VISA\"                   },                   \"funding_mode\":\"INSTANT_TRANSFER\"                },                {                   \"amount\":{                      \"value\":\"6.00\",                      \"currency\":\"USD\"                   },                   \"funding_instrument_type\":\"BALANCE\",                   \"funding_mode\":\"INSTANT_TRANSFER\"                }             ]          }       ]    } }";
    }
}
