package com.huawei.hianalytics.mn.no.a.no;

import com.huawei.hianalytics.mn.mn.no;
import com.huawei.hianalytics.mn.no.a.op.mn;
import com.huawei.hianalytics.mn.no.b.qr;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
public class pq implements mn {

    /* renamed from: mn  reason: collision with root package name */
    private String f13523mn;

    /* renamed from: no  reason: collision with root package name */
    private String f13524no;

    /* renamed from: op  reason: collision with root package name */
    private String f13525op;
    private List<com.huawei.hianalytics.mn.no.op.no.pq> pq;

    public pq(List<com.huawei.hianalytics.mn.no.op.no.pq> list, String str, String str2, String str3) {
        this.f13523mn = str;
        this.f13524no = str2;
        this.f13525op = str3;
        this.pq = list;
    }

    private void mn() {
        com.huawei.hianalytics.mn.no.uv.mn.mn(no.a(), "backup_event", qr.mn(this.f13523mn, this.f13525op, this.f13524no));
    }

    @Override // java.lang.Runnable
    public void run() {
        List<com.huawei.hianalytics.mn.no.op.no.pq> list = this.pq;
        if (list == null || list.size() == 0) {
            com.huawei.hianalytics.mn.no.qr.mn.no("FailedEventHandlerTask", "failed events is empty");
            return;
        }
        if (com.huawei.hianalytics.mn.no.b.no.mn(no.a(), "cached_v2_1", no.uv() * 1048576)) {
            com.huawei.hianalytics.mn.no.qr.mn.op("FailedEventHandlerTask", "The cacheFile is full,Can not writing data! reqID:" + this.f13524no);
            return;
        }
        String mn2 = qr.mn(this.f13523mn, this.f13525op);
        List<com.huawei.hianalytics.mn.no.op.no.pq> list2 = com.huawei.hianalytics.mn.no.pq.qr.no(no.a(), "cached_v2_1", mn2).get(mn2);
        if (!(list2 == null || list2.size() == 0)) {
            this.pq.addAll(list2);
        }
        JSONArray jSONArray = new JSONArray();
        for (com.huawei.hianalytics.mn.no.op.no.pq pqVar : this.pq) {
            try {
                jSONArray.put(pqVar.pq());
            } catch (JSONException unused) {
                com.huawei.hianalytics.mn.no.qr.mn.op("FailedEventHandlerTask", "event to json error");
            }
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2.length() > no.tu() * 1048576) {
            com.huawei.hianalytics.mn.no.qr.mn.op("FailedEventHandlerTask", "this failed data is too long,can not writing it");
            this.pq = null;
            return;
        }
        com.huawei.hianalytics.mn.no.qr.mn.no("FailedEventHandlerTask", "data send failed, write to cache file...reqID:" + this.f13524no);
        com.huawei.hianalytics.mn.no.uv.mn.mn(no.a(), "cached_v2_1", mn2, jSONArray2);
        mn();
    }
}
