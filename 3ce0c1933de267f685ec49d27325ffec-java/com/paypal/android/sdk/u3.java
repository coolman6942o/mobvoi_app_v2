package com.paypal.android.sdk;

import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.providers.OtaColumn;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class u3 extends v3 {

    /* renamed from: m  reason: collision with root package name */
    public String f22011m;

    /* renamed from: n  reason: collision with root package name */
    private eo f22012n;

    /* renamed from: o  reason: collision with root package name */
    private Map f22013o;

    /* renamed from: p  reason: collision with root package name */
    private t3[] f22014p;

    /* renamed from: q  reason: collision with root package name */
    private String f22015q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f22016r;

    /* renamed from: s  reason: collision with root package name */
    private String f22017s;

    /* renamed from: t  reason: collision with root package name */
    private String f22018t;

    /* renamed from: u  reason: collision with root package name */
    private String f22019u;

    /* renamed from: v  reason: collision with root package name */
    private String f22020v;

    /* renamed from: w  reason: collision with root package name */
    private String f22021w;

    public u3(dc dcVar, s1 s1Var, z zVar, String str, String str2, String str3, eo eoVar, Map map, t3[] t3VarArr, String str4, boolean z10, String str5, String str6, String str7) {
        super(dcVar, s1Var, zVar, str);
        this.f22011m = str3;
        this.f22012n = eoVar;
        this.f22013o = map;
        this.f22014p = t3VarArr;
        this.f22015q = str4;
        this.f22016r = z10;
        this.f22017s = str7;
        if (y1.i(str7)) {
            this.f22017s = "sale";
        }
        this.f22017s = this.f22017s.toLowerCase(Locale.US);
        e("PayPal-Request-Id", str2);
        if (y1.m(str5)) {
            e("PayPal-Partner-Attribution-Id", str5);
        }
        if (y1.m(str6)) {
            e("PayPal-Client-Metadata-Id", str6);
        }
    }

    private static String J(JSONArray jSONArray) {
        JSONArray jSONArray2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (jSONArray == null) {
            return null;
        }
        try {
            JSONObject jSONObject3 = jSONArray.getJSONObject(0);
            if (jSONObject3 == null || (jSONArray2 = jSONObject3.getJSONArray("related_resources")) == null || (jSONObject = jSONArray2.getJSONObject(0)) == null || (jSONObject2 = jSONObject.getJSONObject("authorization")) == null) {
                return null;
            }
            return jSONObject2.optString("id");
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean C() {
        return this.f22016r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final eo D() {
        return this.f22012n;
    }

    public final String E() {
        return this.f22018t;
    }

    public final String F() {
        return this.f22019u;
    }

    public final String G() {
        return this.f22017s;
    }

    public final String H() {
        return this.f22020v;
    }

    public final String I() {
        return this.f22021w;
    }

    abstract void K(JSONObject jSONObject);

    protected abstract JSONArray L();

    protected abstract String M();

    @Override // com.paypal.android.sdk.r1
    public final String h() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.accumulate("intent", this.f22017s);
        JSONObject jSONObject3 = new JSONObject();
        JSONArray L = L();
        if (L != null) {
            jSONObject3.accumulate("funding_instruments", L);
        }
        jSONObject3.accumulate("payment_method", M());
        jSONObject2.accumulate("payer", jSONObject3);
        eo eoVar = this.f22012n;
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.accumulate("currency", eoVar.b().getCurrencyCode());
        jSONObject4.accumulate("total", eoVar.a().toPlainString());
        Map map = this.f22013o;
        if (map != null && !map.isEmpty()) {
            Map map2 = this.f22013o;
            if (map2 == null || map2.isEmpty()) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject();
                if (this.f22013o.containsKey("shipping")) {
                    jSONObject.accumulate("shipping", this.f22013o.get("shipping"));
                }
                if (this.f22013o.containsKey("subtotal")) {
                    jSONObject.accumulate("subtotal", this.f22013o.get("subtotal"));
                }
                if (this.f22013o.containsKey("tax")) {
                    jSONObject.accumulate("tax", this.f22013o.get("tax"));
                }
            }
            jSONObject4.accumulate("details", jSONObject);
        }
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.accumulate("amount", jSONObject4);
        jSONObject5.accumulate(OtaColumn.COLUMN_DESCRIPTION, this.f22015q);
        t3[] t3VarArr = this.f22014p;
        if (t3VarArr != null && t3VarArr.length > 0) {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.accumulate("items", t3.a(this.f22014p));
            jSONObject5.accumulate("item_list", jSONObject6);
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject5);
        K(jSONObject5);
        jSONObject2.accumulate("transactions", jSONArray);
        return jSONObject2.toString();
    }

    @Override // com.paypal.android.sdk.r1
    public final void j() {
        JSONObject u10 = u();
        try {
            this.f22018t = u10.getString("state");
            this.f22019u = u10.optString("id");
            this.f22020v = u10.optString(WearPath.RecorderV2.MAP_KEY_CREATE_TIME);
            this.f22021w = J(u10.getJSONArray("transactions"));
        } catch (JSONException unused) {
            l();
        }
    }

    @Override // com.paypal.android.sdk.r1
    public final void l() {
        B(u());
    }
}
