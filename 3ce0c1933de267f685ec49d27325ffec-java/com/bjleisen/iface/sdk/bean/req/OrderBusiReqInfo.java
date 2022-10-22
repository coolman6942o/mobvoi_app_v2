package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class OrderBusiReqInfo extends BaseBusiReqInfo {
    private String instanceAid;
    private int page;
    private int queryOrderType;
    private int rows;

    public String getInstanceAid() {
        return this.instanceAid;
    }

    public int getPage() {
        return this.page;
    }

    public int getQueryOrderType() {
        return this.queryOrderType;
    }

    public int getRows() {
        return this.rows;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
    }

    public void setPage(int i10) {
        this.page = i10;
    }

    public void setQueryOrderType(int i10) {
        this.queryOrderType = i10;
    }

    public void setRows(int i10) {
        this.rows = i10;
    }
}
