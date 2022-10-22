package com.huawei.hianalytics.mn.qr;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class no extends com.huawei.hianalytics.mn.no.op.no.no {
    private String st = "";

    @Override // com.huawei.hianalytics.mn.no.op.no.rs
    public JSONObject op() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", "1");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.pq);
        jSONObject.put("appid", this.f13579mn);
        jSONObject.put("hmac", this.st);
        jSONObject.put("chifer", this.rs);
        jSONObject.put("timestamp", this.f13580no);
        jSONObject.put("servicetag", this.f13581op);
        jSONObject.put("requestid", this.qr);
        return jSONObject;
    }

    public void st(String str) {
        this.st = str;
    }
}
