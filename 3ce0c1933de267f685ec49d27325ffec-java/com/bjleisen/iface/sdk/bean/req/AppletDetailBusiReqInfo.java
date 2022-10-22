package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class AppletDetailBusiReqInfo extends BaseBusiReqInfo {
    private String appletVersion;
    private String instanceAid;
    private int tranStatus;

    public String getAppletVersion() {
        return this.appletVersion;
    }

    public String getInstanceAid() {
        return this.instanceAid;
    }

    public int getTranStatus() {
        return this.tranStatus;
    }

    public void setAppletVersion(String str) {
        this.appletVersion = str;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
    }

    public void setTranStatus(int i10) {
        this.tranStatus = i10;
    }
}
