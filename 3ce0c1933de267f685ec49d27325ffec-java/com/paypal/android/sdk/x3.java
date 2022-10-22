package com.paypal.android.sdk;

import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class x3 extends v3 {

    /* renamed from: m  reason: collision with root package name */
    public final String f22057m;

    /* renamed from: n  reason: collision with root package name */
    private final String f22058n;

    /* renamed from: o  reason: collision with root package name */
    private final String f22059o;

    /* renamed from: p  reason: collision with root package name */
    private final String f22060p;

    /* renamed from: q  reason: collision with root package name */
    private final int f22061q;

    /* renamed from: r  reason: collision with root package name */
    private final int f22062r;

    /* renamed from: s  reason: collision with root package name */
    private String f22063s;

    /* renamed from: t  reason: collision with root package name */
    private String f22064t;

    /* renamed from: u  reason: collision with root package name */
    private Date f22065u;

    public x3(s1 s1Var, z zVar, String str, String str2, String str3, String str4, String str5, int i10, int i11) {
        super(dc.TokenizeCreditCardRequest, s1Var, zVar, str);
        this.f22057m = str2;
        this.f22058n = str3;
        if (str4 != null) {
            this.f22059o = str4;
            this.f22060p = str5;
            this.f22061q = i10;
            this.f22062r = i11;
            return;
        }
        throw new RuntimeException("cardNumber should not be null.  If it is, then you're probably trying to tokenize a card that's already been tokenized.");
    }

    public final String C() {
        return this.f22063s;
    }

    public final String D() {
        return this.f22064t;
    }

    public final Date E() {
        return this.f22065u;
    }

    public final String F() {
        return this.f22058n;
    }

    public final int G() {
        return this.f22061q;
    }

    public final int H() {
        return this.f22062r;
    }

    @Override // com.paypal.android.sdk.r1
    public final String h() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.accumulate("payer_id", this.f22057m);
        jSONObject.accumulate("cvv2", this.f22060p);
        jSONObject.accumulate("expire_month", Integer.valueOf(this.f22061q));
        jSONObject.accumulate("expire_year", Integer.valueOf(this.f22062r));
        jSONObject.accumulate("number", this.f22059o);
        jSONObject.accumulate("type", this.f22058n);
        return jSONObject.toString();
    }

    @Override // com.paypal.android.sdk.r1
    public final void j() {
        JSONObject u10 = u();
        try {
            this.f22063s = u10.getString("id");
            String string = u10.getString("number");
            String str = this.f22064t;
            if (str == null || !str.endsWith(string.substring(string.length() - 4))) {
                this.f22064t = string;
            }
            this.f22065u = eu.a(u10.getString("valid_until"));
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
        StringBuilder sb2 = new StringBuilder("{\"id\":\"CARD-50Y58962PH1899901KFFBSDA\",\"valid_until\":\"2016-03-19T00:00:00.000Z\",\"state\":\"ok\",\"type\":\"visa\",\"number\":\"xxxxxxxxxxxx");
        String str = this.f22059o;
        sb2.append(str.substring(str.length() - 4));
        sb2.append("\",\"expire_month\":\"");
        sb2.append(this.f22061q);
        sb2.append("\",\"expire_year\":\"");
        sb2.append(this.f22062r);
        sb2.append("\",\"links\":[{\"href\":\"https://api.sandbox.paypal.com/v1/vault/credit-card/CARD-50Y58962PH1899901KFFBSDA\",\"rel\":\"self\",\"method\":\"GET\"}]}");
        return sb2.toString();
    }
}
