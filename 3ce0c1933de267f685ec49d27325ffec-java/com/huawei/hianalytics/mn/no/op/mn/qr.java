package com.huawei.hianalytics.mn.no.op.mn;

import com.huawei.hianalytics.mn.no.qr.mn;
/* loaded from: classes.dex */
public class qr {

    /* renamed from: mn  reason: collision with root package name */
    private op f13575mn;

    /* renamed from: no  reason: collision with root package name */
    private op f13576no;

    /* renamed from: op  reason: collision with root package name */
    private op f13577op;
    private op pq;
    private String qr;

    public qr(String str) {
        this.qr = str;
    }

    public op mn() {
        return this.f13575mn;
    }

    public op mn(String str) {
        if (str.equals("oper")) {
            return no();
        }
        if (str.equals("maint")) {
            return mn();
        }
        if (str.equals("diffprivacy")) {
            return pq();
        }
        if (str.equals("preins")) {
            return op();
        }
        mn.op("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: ".concat(str));
        return null;
    }

    public void mn(op opVar) {
        this.f13575mn = opVar;
    }

    public op no() {
        return this.f13576no;
    }

    public void no(op opVar) {
        this.f13576no = opVar;
    }

    public op op() {
        return this.pq;
    }

    public void op(op opVar) {
        this.pq = opVar;
    }

    public op pq() {
        return this.f13577op;
    }

    public void pq(op opVar) {
        this.f13577op = opVar;
    }
}
