package com.paypal.android.sdk;

import java.util.GregorianCalendar;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r0 extends q1 {

    /* renamed from: m  reason: collision with root package name */
    private final s0 f21873m;

    public r0(p1 p1Var, s1 s1Var, z zVar, s0 s0Var) {
        super(p1Var, s1Var, zVar, null);
        this.f21873m = s0Var;
        e("Accept", "application/json; charset=utf-8");
        e("Accept-Language", "en_US");
        e("Content-Type", "application/json");
    }

    private static JSONObject B(Map map) {
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            jSONObject.accumulate(str, map.get(str));
        }
        return jSONObject;
    }

    @Override // com.paypal.android.sdk.r1
    public final String a(p1 p1Var) {
        return "https://api.paypal.com/v1/tracking/events";
    }

    @Override // com.paypal.android.sdk.r1
    public final boolean g() {
        return true;
    }

    @Override // com.paypal.android.sdk.r1
    public final String h() {
        String c10 = y1.c(A().d().i());
        String str = this.f21873m.f21934a;
        JSONObject jSONObject = new JSONObject();
        jSONObject.accumulate("tracking_visitor_id", c10);
        jSONObject.accumulate("tracking_visit_id", str);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.accumulate("actor", jSONObject);
        jSONObject2.accumulate("channel", "mobile");
        long currentTimeMillis = System.currentTimeMillis();
        jSONObject2.accumulate("tracking_event", Long.toString(currentTimeMillis));
        this.f21873m.f21935b.put("t", Long.toString(currentTimeMillis - new GregorianCalendar().getTimeZone().getRawOffset()));
        this.f21873m.f21935b.put("dsid", c10);
        this.f21873m.f21935b.put("vid", str);
        jSONObject2.accumulate("event_params", B(this.f21873m.f21935b));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.accumulate("events", jSONObject2);
        return jSONObject3.toString();
    }

    @Override // com.paypal.android.sdk.r1
    public final void j() {
    }

    @Override // com.paypal.android.sdk.r1
    public final void l() {
    }

    @Override // com.paypal.android.sdk.r1
    public final String m() {
        return "mockResponse";
    }
}
