package com.huawei.hianalytics.mn.no.a.no;

import android.content.Context;
import android.util.Pair;
import com.huawei.hianalytics.mn.mn.no;
import com.huawei.hianalytics.mn.no.a.op.mn;
import com.huawei.hianalytics.mn.no.b.qr;
import com.huawei.hianalytics.mn.no.op.no.pq;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class op implements mn {

    /* renamed from: mn  reason: collision with root package name */
    private Context f13520mn = no.a();

    /* renamed from: no  reason: collision with root package name */
    private String f13521no;

    /* renamed from: op  reason: collision with root package name */
    private String f13522op;
    private String pq;

    public op(String str, String str2, String str3) {
        this.f13521no = str;
        this.f13522op = str2;
        this.pq = str3;
    }

    private void mn(String str, List<pq> list) {
        Pair<String, String> mn2 = qr.mn(str);
        new com.huawei.hianalytics.mn.no.pq.no(list, (String) mn2.first, (String) mn2.second, this.pq).mn();
    }

    @Override // java.lang.Runnable
    public void run() {
        com.huawei.hianalytics.mn.no.qr.mn.no("EventReportTask", "eventReportTask is running");
        boolean mn2 = com.huawei.hianalytics.mn.no.b.no.mn(this.f13520mn);
        if (mn2) {
            com.huawei.hianalytics.mn.no.qr.mn.no("EventReportTask", "workKey is refresh,begin report all data");
            this.f13522op = "alltype";
        }
        Map<String, List<pq>> mn3 = com.huawei.hianalytics.mn.no.pq.qr.mn(this.f13520mn, this.f13521no, this.f13522op);
        if (mn3.size() == 0) {
            com.huawei.hianalytics.mn.no.qr.mn.mn("EventReportTask", "no have events to report: tag:%s : type:%s", this.f13521no, this.f13522op);
            return;
        }
        for (Map.Entry<String, List<pq>> entry : mn3.entrySet()) {
            mn(entry.getKey(), entry.getValue());
        }
        if ("alltype".equals(this.f13522op)) {
            com.huawei.hianalytics.mn.no.uv.mn.mn(this.f13520mn, "stat_v2_1", new String[0]);
            com.huawei.hianalytics.mn.no.uv.mn.mn(this.f13520mn, "cached_v2_1", new String[0]);
        } else {
            String mn4 = qr.mn(this.f13521no, this.f13522op);
            com.huawei.hianalytics.mn.no.uv.mn.mn(this.f13520mn, "stat_v2_1", mn4);
            com.huawei.hianalytics.mn.no.uv.mn.mn(this.f13520mn, "cached_v2_1", mn4);
        }
        if (mn2) {
            com.huawei.hianalytics.mn.no.qr.mn.no("EventReportTask", "refresh local key");
            com.huawei.hianalytics.mn.no.st.no.mn().no();
            com.huawei.hianalytics.mn.no.pq.mn.mn().mn(com.huawei.hianalytics.mn.no.pq.mn.mn().no());
        }
    }
}
