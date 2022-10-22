package com.laser.tsm.sdk.business;
/* loaded from: classes2.dex */
public class AppletOperBusinessForReq extends BaseBusinessForReq {
    private String appAid;
    private String appletVersion;
    private int operType;

    public String getAppAid() {
        return this.appAid;
    }

    public String getAppletVersion() {
        return this.appletVersion;
    }

    public int getOperType() {
        return this.operType;
    }

    public void setAppAid(String str) {
        this.appAid = str;
    }

    public void setAppletVersion(String str) {
        this.appletVersion = str;
    }

    public void setOperType(int i10) {
        this.operType = i10;
    }
}
