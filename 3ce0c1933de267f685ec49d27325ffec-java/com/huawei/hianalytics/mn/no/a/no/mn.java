package com.huawei.hianalytics.mn.no.a.no;

import com.huawei.hianalytics.mn.no.op.no.pq;
import com.huawei.hianalytics.mn.no.rs.no;
import com.huawei.hianalytics.mn.no.rs.op;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class mn implements com.huawei.hianalytics.mn.no.a.op.mn {

    /* renamed from: mn  reason: collision with root package name */
    private byte[] f13514mn;

    /* renamed from: no  reason: collision with root package name */
    private String f13515no;

    /* renamed from: op  reason: collision with root package name */
    private String f13516op;
    private String pq;
    private String qr;
    private List<pq> rs;

    public mn(byte[] bArr, String str, String str2, String str3, String str4, List<pq> list) {
        this.f13514mn = (byte[]) bArr.clone();
        this.f13515no = str;
        this.f13516op = str2;
        this.qr = str3;
        this.pq = str4;
        this.rs = list;
    }

    private op mn(Map<String, String> map) {
        return no.mn(this.f13515no, this.f13514mn, map);
    }

    private Map<String, String> mn() {
        return com.huawei.hianalytics.mn.pq.mn.op(this.f13516op, this.qr, this.pq);
    }

    private void no() {
        com.huawei.hianalytics.mn.no.a.op.no.mn().mn(new pq(this.rs, this.f13516op, this.pq, this.qr));
    }

    @Override // java.lang.Runnable
    public void run() {
        com.huawei.hianalytics.mn.no.qr.mn.no("DataSendTask", "send data running");
        int mn2 = mn(mn()).mn();
        if (mn2 != 200) {
            no();
            return;
        }
        com.huawei.hianalytics.mn.no.qr.mn.mn("DataSendTask", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.pq, this.qr, this.f13516op, Integer.valueOf(mn2));
    }
}
