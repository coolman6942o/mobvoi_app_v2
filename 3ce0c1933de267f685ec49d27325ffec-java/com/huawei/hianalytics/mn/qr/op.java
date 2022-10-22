package com.huawei.hianalytics.mn.qr;

import android.os.Build;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class op extends com.huawei.hianalytics.mn.no.op.no.op {
    String rs;
    String st;
    private String tu;

    @Override // com.huawei.hianalytics.mn.no.op.no.rs
    public JSONObject op() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", this.tu);
        jSONObject.put("_emui_ver", this.f13582mn);
        jSONObject.put("_model", Build.MODEL);
        jSONObject.put("_mcc", this.rs);
        jSONObject.put("_mnc", this.st);
        jSONObject.put("_package_name", this.f13583no);
        jSONObject.put("_app_ver", this.f13584op);
        jSONObject.put("_lib_ver", "2.2.0.304");
        jSONObject.put("_channel", this.pq);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.qr);
        return jSONObject;
    }

    public void rs(String str) {
        this.rs = str;
    }

    public void st(String str) {
        this.st = str;
    }

    public void tu(String str) {
        this.tu = str;
    }
}
