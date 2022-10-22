package com.huawei.hianalytics.mn.no.pq;

import com.huawei.hianalytics.mn.no.op.no.pq;
import com.huawei.hianalytics.mn.no.qr.mn;
import com.huawei.hianalytics.mn.no.tu.no;
import java.util.ArrayList;
import java.util.UUID;
/* loaded from: classes.dex */
public class rs {

    /* renamed from: mn  reason: collision with root package name */
    private String f13600mn;

    /* renamed from: no  reason: collision with root package name */
    private String f13601no;

    /* renamed from: op  reason: collision with root package name */
    private String f13602op;
    private String pq;
    private long qr;

    public rs(String str, String str2, String str3, String str4, long j10) {
        this.f13600mn = str;
        this.f13601no = str2;
        this.f13602op = str3;
        this.pq = str4;
        this.qr = j10;
    }

    public void mn() {
        mn.no("StreamEventHandler", "Begin to handle stream events...");
        pq pqVar = new pq();
        pqVar.no(this.f13602op);
        pqVar.mn(this.f13601no);
        pqVar.op(this.pq);
        pqVar.pq(String.valueOf(this.qr));
        if ("oper".equals(this.f13601no) && com.huawei.hianalytics.mn.mn.mn.qr(this.f13600mn, "oper")) {
            no mn2 = com.huawei.hianalytics.mn.no.tu.mn.mn().mn(this.f13600mn, this.qr);
            String mn3 = mn2.mn();
            Boolean valueOf = Boolean.valueOf(mn2.no());
            pqVar.qr(mn3);
            pqVar.rs(String.valueOf(valueOf));
        }
        String replace = UUID.randomUUID().toString().replace("-", "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(pqVar);
        new op(this.f13600mn, this.f13601no, com.huawei.hianalytics.mn.mn.no.rs(), arrayList, replace).mn();
    }
}
