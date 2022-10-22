package com.laser.tsm.sdk.bean;
/* loaded from: classes2.dex */
public class OperAppletReqParams {
    private String appletAid;
    private String appletVersion;

    public OperAppletReqParams(String str, String str2) {
        this.appletAid = str;
        this.appletVersion = str2;
    }

    public String getAppletAid() {
        return this.appletAid;
    }

    public String getAppletVersion() {
        return this.appletVersion;
    }

    public void setAppletAid(String str) {
        this.appletAid = str;
    }

    public void setAppletVersion(String str) {
        this.appletVersion = str;
    }
}
