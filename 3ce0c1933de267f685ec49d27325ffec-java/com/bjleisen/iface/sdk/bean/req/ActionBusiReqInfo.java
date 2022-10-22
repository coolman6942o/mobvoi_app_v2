package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class ActionBusiReqInfo extends BaseBusiReqInfo {
    private String instanceAid;
    private int tranStatus;

    public String getInstanceAid() {
        return this.instanceAid;
    }

    public int getTranStatus() {
        return this.tranStatus;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
    }

    public void setTranStatus(int i10) {
        this.tranStatus = i10;
    }
}
