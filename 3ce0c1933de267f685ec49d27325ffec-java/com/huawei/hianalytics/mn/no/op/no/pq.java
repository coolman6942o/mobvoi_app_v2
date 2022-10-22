package com.huawei.hianalytics.mn.no.op.no;

import android.text.TextUtils;
import com.huawei.hianalytics.mn.no.mn.no;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class pq implements rs {

    /* renamed from: mn  reason: collision with root package name */
    private String f13585mn;

    /* renamed from: no  reason: collision with root package name */
    private String f13586no;

    /* renamed from: op  reason: collision with root package name */
    private String f13587op;
    private String pq;
    private String qr;
    private String rs;

    public String mn() {
        return this.f13585mn;
    }

    public void mn(String str) {
        this.f13585mn = str;
    }

    public void mn(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f13586no = jSONObject.optString("event");
            this.f13587op = jSONObject.optString("properties");
            this.f13587op = no.mn().mn(no.mn.AES).mn(com.huawei.hianalytics.mn.no.st.no.mn().op(), this.f13587op);
            this.f13585mn = jSONObject.optString("type");
            this.pq = jSONObject.optString("eventtime");
            this.qr = jSONObject.optString("event_session_name");
            this.rs = jSONObject.optString("first_session_event");
        }
    }

    public String no() {
        return this.pq;
    }

    public void no(String str) {
        this.f13586no = str;
    }

    @Override // com.huawei.hianalytics.mn.no.op.no.rs
    public JSONObject op() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.f13585mn);
        jSONObject.put("eventtime", this.pq);
        jSONObject.put("event", this.f13586no);
        jSONObject.put("event_session_name", this.qr);
        jSONObject.put("first_session_event", this.rs);
        if (TextUtils.isEmpty(this.f13587op)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.f13587op));
        return jSONObject;
    }

    public void op(String str) {
        this.f13587op = str;
    }

    public JSONObject pq() {
        JSONObject op2 = op();
        op2.put("properties", no.mn().mn(no.mn.AES).no(com.huawei.hianalytics.mn.no.st.no.mn().op(), this.f13587op));
        return op2;
    }

    public void pq(String str) {
        this.pq = str;
    }

    public void qr(String str) {
        this.qr = str;
    }

    public void rs(String str) {
        this.rs = str;
    }
}
