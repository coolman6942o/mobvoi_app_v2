package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class SyncBusiReqInfo extends BaseBusiReqInfo {
    private int appStatus;
    private int appType;
    private String appletVersion;
    private String instanceAid;

    public int getAppStatus() {
        return this.appStatus;
    }

    public int getAppType() {
        return this.appType;
    }

    public String getAppletVersion() {
        return this.appletVersion;
    }

    public String getInstanceAid() {
        return this.instanceAid;
    }

    public void setAppStatus(int i10) {
        this.appStatus = i10;
    }

    public void setAppType(int i10) {
        this.appType = i10;
    }

    public void setAppletVersion(String str) {
        this.appletVersion = str;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
    }
}
