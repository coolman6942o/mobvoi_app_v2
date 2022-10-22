package com.huawei.hianalytics.mn.no.op.no;

import android.text.TextUtils;
import com.huawei.hianalytics.mn.no.b.pq;
import com.huawei.hianalytics.mn.no.mn.no;
import com.huawei.hianalytics.mn.qr.mn;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class qr implements rs {

    /* renamed from: mn  reason: collision with root package name */
    private List<pq> f13588mn;

    /* renamed from: no  reason: collision with root package name */
    private no f13589no;

    /* renamed from: op  reason: collision with root package name */
    private op f13590op;
    private rs pq;
    private String qr = "";
    private String rs;

    public qr(String str) {
        this.rs = str;
    }

    public void mn(no noVar) {
        this.f13589no = noVar;
    }

    public void mn(op opVar) {
        this.f13590op = opVar;
    }

    public void mn(mn mnVar) {
        this.pq = mnVar;
    }

    public void mn(String str) {
        if (str != null) {
            this.qr = str;
        }
    }

    public void mn(List<pq> list) {
        this.f13588mn = list;
    }

    @Override // com.huawei.hianalytics.mn.no.op.no.rs
    public JSONObject op() {
        String str;
        List<pq> list = this.f13588mn;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.f13589no == null || this.f13590op == null || this.pq == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.f13589no.op());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject op2 = this.pq.op();
            op2.put("properties", this.f13590op.op());
            try {
                op2.put("events_global_properties", new JSONObject(this.qr));
            } catch (JSONException unused) {
                op2.put("events_global_properties", this.qr);
            }
            jSONObject2.put("events_common", op2);
            JSONArray jSONArray = new JSONArray();
            for (pq pqVar : this.f13588mn) {
                JSONObject op3 = pqVar.op();
                if (op3 != null) {
                    jSONArray.put(op3);
                } else {
                    com.huawei.hianalytics.mn.no.qr.mn.op("EventUploadModel", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put("events", jSONArray);
            try {
                String mn2 = no.mn().mn(no.mn.AES).mn(this.rs, pq.mn(jSONObject2.toString().getBytes("UTF-8")));
                if (TextUtils.isEmpty(mn2)) {
                    com.huawei.hianalytics.mn.no.qr.mn.op("EventUploadModel", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", mn2);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        com.huawei.hianalytics.mn.no.qr.mn.op("EventUploadModel", str);
        return null;
    }
}
