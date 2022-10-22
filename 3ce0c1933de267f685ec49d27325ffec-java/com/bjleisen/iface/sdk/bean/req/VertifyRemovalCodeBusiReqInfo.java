package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class VertifyRemovalCodeBusiReqInfo extends BaseBusiReqInfo {
    private String instanceAid;
    private String removalCode;

    public String getInstanceAid() {
        return this.instanceAid;
    }

    public String getRemovalCode() {
        return this.removalCode;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
    }

    public void setRemovalCode(String str) {
        this.removalCode = str;
    }
}
