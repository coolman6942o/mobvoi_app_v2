package com.huawei.hianalytics.mn.no.pq;

import android.text.TextUtils;
import com.huawei.hianalytics.mn.no.b.no;
import com.huawei.hianalytics.mn.no.op.no.pq;
import com.huawei.hianalytics.mn.no.op.no.qr;
import com.huawei.hianalytics.mn.no.qr.mn;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class op {

    /* renamed from: mn  reason: collision with root package name */
    private String f13597mn;

    /* renamed from: no  reason: collision with root package name */
    private String f13598no;

    /* renamed from: op  reason: collision with root package name */
    private String f13599op;
    private List<pq> pq;
    private String qr;

    public op(String str, String str2, String str3, List<pq> list, String str4) {
        this.f13597mn = str;
        this.f13598no = str2;
        this.f13599op = str3;
        this.pq = list;
        this.qr = str4;
    }

    private String mn(String str, String str2) {
        String str3;
        String op2 = com.huawei.hianalytics.mn.mn.op.op(str, str2);
        if (TextUtils.isEmpty(op2)) {
            mn.mn("DataReportHandler", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if ("oper".equals(str2)) {
            str3 = "{url}/common/hmshioperqrt";
        } else if ("maint".equals(str2)) {
            str3 = "{url}/common/hmshimaintqrt";
        } else if (!"diffprivacy".equals(str2)) {
            return "";
        } else {
            str3 = "{url}/common/common2";
        }
        return str3.replace("{url}", op2);
    }

    private byte[] mn(qr qrVar) {
        String str;
        try {
            JSONObject op2 = qrVar.op();
            if (op2 != null) {
                return com.huawei.hianalytics.mn.no.b.pq.mn(op2.toString().getBytes("UTF-8"));
            }
            mn.op("DataReportHandler", "uploadEvents is null");
            return new byte[0];
        } catch (UnsupportedEncodingException unused) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            mn.op("DataReportHandler", str);
            return new byte[0];
        } catch (JSONException unused2) {
            str = "uploadEvents to json error";
            mn.op("DataReportHandler", str);
            return new byte[0];
        }
    }

    private JSONArray no() {
        JSONArray jSONArray = new JSONArray();
        for (pq pqVar : this.pq) {
            try {
                jSONArray.put(pqVar.pq());
            } catch (JSONException unused) {
                mn.no("DataReportHandler", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    private void op() {
        if (no.mn(com.huawei.hianalytics.mn.mn.no.a(), "backup_event", 5242880)) {
            mn.no("DataReportHandler", "backup file reach max limited size, discard new event ");
            return;
        }
        JSONArray no2 = no();
        String mn2 = com.huawei.hianalytics.mn.no.b.qr.mn(this.f13597mn, this.f13598no, this.qr);
        mn.no("DataReportHandler", "Update data cached into backup,spKey: ".concat(String.valueOf(mn2)));
        com.huawei.hianalytics.mn.no.uv.mn.mn(com.huawei.hianalytics.mn.mn.no.a(), "backup_event", mn2, no2.toString());
    }

    private qr pq() {
        return com.huawei.hianalytics.mn.pq.mn.mn(this.pq, this.f13597mn, this.f13598no, this.qr, this.f13599op);
    }

    public void mn() {
        String mn2 = mn(this.f13597mn, this.f13598no);
        if (!TextUtils.isEmpty(mn2) || "preins".equals(this.f13598no)) {
            if (!"_hms_config_tag".equals(this.f13597mn) && !"_openness_config_tag".equals(this.f13597mn)) {
                op();
            }
            qr pq = pq();
            if (pq != null) {
                byte[] mn3 = mn(pq);
                if (mn3.length == 0) {
                    mn.op("DataReportHandler", "request body is empty");
                    return;
                }
                com.huawei.hianalytics.mn.no.a.op.no.no().mn(new com.huawei.hianalytics.mn.no.a.no.mn(mn3, mn2, this.f13597mn, this.f13598no, this.qr, this.pq));
                return;
            }
            com.huawei.hianalytics.mn.no.a.op.no.mn().mn(new com.huawei.hianalytics.mn.no.a.no.pq(this.pq, this.f13597mn, this.qr, this.f13598no));
            return;
        }
        mn.op("DataReportHandler", "collectUrl is empty");
    }
}
