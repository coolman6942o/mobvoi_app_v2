package com.huawei.hianalytics.mn.no.a.no;

import android.content.Context;
import com.huawei.hianalytics.mn.mn.op;
import com.huawei.hianalytics.mn.no.a.op.mn;
import com.huawei.hianalytics.mn.no.b.qr;
import com.huawei.hianalytics.mn.no.op.no.pq;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class no implements mn {

    /* renamed from: mn  reason: collision with root package name */
    private Context f13517mn = com.huawei.hianalytics.mn.mn.no.a();

    /* renamed from: no  reason: collision with root package name */
    private String f13518no;

    /* renamed from: op  reason: collision with root package name */
    private JSONObject f13519op;
    private String pq;
    private String qr;
    private String rs;
    private String st;
    private Boolean tu;

    public no(String str, JSONObject jSONObject, String str2, String str3, long j10) {
        this.f13518no = str;
        this.f13519op = jSONObject;
        this.pq = str2;
        this.qr = str3;
        this.rs = String.valueOf(j10);
        if (com.huawei.hianalytics.mn.mn.mn.qr(str2, "oper")) {
            com.huawei.hianalytics.mn.no.tu.no mn2 = com.huawei.hianalytics.mn.no.tu.mn.mn().mn(str2, j10);
            this.st = mn2.mn();
            this.tu = Boolean.valueOf(mn2.no());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        com.huawei.hianalytics.mn.no.qr.mn.no("EventRecordTask", "Begin to run EventRecordTask...");
        int tu = com.huawei.hianalytics.mn.mn.no.tu();
        int tu2 = op.tu(this.pq, this.qr);
        if (com.huawei.hianalytics.mn.no.b.no.mn(this.f13517mn, "stat_v2_1", tu * 1048576)) {
            com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "stat sp file reach max limited size, discard new event");
            com.huawei.hianalytics.mn.no.a.mn.mn.mn().mn("", "alltype");
            return;
        }
        pq pqVar = new pq();
        pqVar.no(this.f13518no);
        pqVar.op(this.f13519op.toString());
        pqVar.mn(this.qr);
        pqVar.pq(this.rs);
        pqVar.qr(this.st);
        Boolean bool = this.tu;
        pqVar.rs(bool == null ? null : String.valueOf(bool));
        try {
            JSONObject pq = pqVar.pq();
            String mn2 = qr.mn(this.pq, this.qr);
            try {
                jSONArray = new JSONArray(com.huawei.hianalytics.mn.no.uv.mn.no(this.f13517mn, "stat_v2_1", mn2, ""));
            } catch (JSONException unused) {
                com.huawei.hianalytics.mn.no.qr.mn.no("EventRecordTask", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put(pq);
            com.huawei.hianalytics.mn.no.uv.mn.mn(this.f13517mn, "stat_v2_1", mn2, jSONArray.toString());
            if (jSONArray.toString().length() > tu2 * 1024) {
                com.huawei.hianalytics.mn.no.a.mn.mn.mn().mn(this.pq, this.qr);
            }
        } catch (JSONException unused2) {
            com.huawei.hianalytics.mn.no.qr.mn.op("EventRecordTask", "eventRecord toJson error! The record failed.");
        }
    }
}
