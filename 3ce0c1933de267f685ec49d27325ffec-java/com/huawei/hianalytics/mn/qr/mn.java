package com.huawei.hianalytics.mn.qr;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class mn extends com.huawei.hianalytics.mn.no.op.no.mn {
    private String st;

    /* renamed from: op  reason: collision with root package name */
    private String f13640op = "";
    private String pq = "";
    private String qr = "";
    private String rs = "";

    /* renamed from: no  reason: collision with root package name */
    protected String f13639no = "";

    public void no(String str) {
        this.f13640op = str;
    }

    @Override // com.huawei.hianalytics.mn.no.op.no.rs
    public JSONObject op() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.f13578mn);
        jSONObject.put("oaid", this.st);
        jSONObject.put("uuid", this.f13639no);
        jSONObject.put("upid", this.rs);
        jSONObject.put("imei", this.f13640op);
        jSONObject.put("sn", this.pq);
        jSONObject.put("udid", this.qr);
        return jSONObject;
    }

    public void op(String str) {
        this.pq = str;
    }

    public void pq(String str) {
        this.rs = str;
    }

    public void qr(String str) {
        this.qr = str;
    }

    public void rs(String str) {
        this.f13639no = str;
    }

    public void st(String str) {
        this.st = str;
    }
}
