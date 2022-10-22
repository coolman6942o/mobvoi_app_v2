package com.paypal.android.sdk;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class m3 extends u3 {
    private int A;
    private int B;
    private String C;
    private String D;
    private String E;
    private String F;

    /* renamed from: x  reason: collision with root package name */
    private String f21458x;

    /* renamed from: y  reason: collision with root package name */
    private String f21459y;

    /* renamed from: z  reason: collision with root package name */
    private String f21460z;

    public m3(s1 s1Var, z zVar, String str, String str2, String str3, String str4, eo eoVar, Map map, t3[] t3VarArr, String str5, boolean z10, String str6, String str7, String str8) {
        super(dc.CreditCardPaymentRequest, s1Var, zVar, str, str2, str4, eoVar, map, t3VarArr, str5, z10, str6, str7, str8);
        this.C = str3;
    }

    public m3(s1 s1Var, z zVar, String str, String str2, String str3, String str4, String str5, int i10, int i11, String str6, eo eoVar, Map map, t3[] t3VarArr, String str7, boolean z10, String str8, String str9, String str10) {
        super(dc.CreditCardPaymentRequest, s1Var, zVar, str, str2, null, eoVar, map, t3VarArr, str7, z10, str8, str9, str10);
        this.f21458x = str3;
        this.f21459y = str4;
        this.f21460z = str5;
        this.A = i10;
        this.B = i11;
    }

    @Override // com.paypal.android.sdk.u3
    final void K(JSONObject jSONObject) {
        if (y1.m(this.D)) {
            jSONObject.accumulate("invoice_number", this.D);
        }
        if (y1.m(this.E)) {
            jSONObject.accumulate("custom", this.E);
        }
        if (y1.m(this.F)) {
            jSONObject.accumulate("soft_descriptor", this.F);
        }
    }

    @Override // com.paypal.android.sdk.u3
    protected final JSONArray L() {
        String str;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONArray jSONArray = new JSONArray();
        if (this.f21458x != null) {
            jSONObject2 = new JSONObject();
            jSONObject2.accumulate("cvv2", this.f21460z);
            jSONObject2.accumulate("expire_month", Integer.valueOf(this.A));
            jSONObject2.accumulate("expire_year", Integer.valueOf(this.B));
            jSONObject2.accumulate("number", this.f21459y);
            jSONObject2.accumulate("type", this.f21458x);
            jSONObject = new JSONObject();
            str = "credit_card";
        } else {
            jSONObject2 = new JSONObject();
            jSONObject2.accumulate("payer_id", this.f22011m);
            jSONObject2.accumulate("credit_card_id", this.C);
            jSONObject = new JSONObject();
            str = "credit_card_token";
        }
        jSONObject.accumulate(str, jSONObject2);
        jSONArray.put(jSONObject);
        return jSONArray;
    }

    @Override // com.paypal.android.sdk.u3
    protected final String M() {
        return "credit_card";
    }

    public final m3 N(String str) {
        this.D = str;
        return this;
    }

    public final m3 O(String str) {
        this.E = str;
        return this;
    }

    public final m3 P(String str) {
        this.F = str;
        return this;
    }

    public final String Q() {
        return this.f21459y;
    }

    public final String R() {
        return this.f21458x;
    }

    public final String S() {
        return this.f21460z;
    }

    public final int T() {
        return this.A;
    }

    public final int U() {
        return this.B;
    }

    @Override // com.paypal.android.sdk.r1
    public final String m() {
        String str;
        String c10 = v2.c(D().a().doubleValue(), D().b());
        StringBuilder sb2 = new StringBuilder("{\"id\":\"PAY-6RV70583SB702805EKEYSZ6Y\",\"intent\":\"sale\",\"create_time\": \"2014-02-12T22:29:49Z\",\"update_time\": \"2014-02-12T22:29:50Z\",\"payer\":{\"funding_instruments\":[{\"credit_card\":{\"expire_month\":\"");
        sb2.append(this.A);
        sb2.append("\",\"expire_year\":\"");
        sb2.append(this.B);
        sb2.append("\",\"number\":\"");
        if (this.f21458x != null) {
            String str2 = this.f21459y;
            str = str2.substring(str2.length() - 4);
        } else {
            str = "xxxxxxxxxx1111";
        }
        sb2.append(str);
        sb2.append("\",\"type\":\"VISA\"}}],\"payment_method\":\"credit_card\"},\"state\":\"approved\",\"transactions\":[{\"amount\":{\"currency\":\"USD\",\"total\":\"");
        sb2.append(c10);
        sb2.append("\"},\"description\":\"I am a sanity check payment.\",\"item_list\":{},\"payee\":{\"merchant_id\":\"PKKPTJKL75YDS\"},\"related_resources\":[{\"sale\":{\"amount\":{\"currency\":\"USD\",\"total\":\"");
        sb2.append(c10);
        sb2.append("\"},\"id\":\"0EW02334X44816642\",\"parent_payment\":\"PAY-123456789012345689\",\"state\":\"completed\"}}]}]}");
        return sb2.toString();
    }
}
