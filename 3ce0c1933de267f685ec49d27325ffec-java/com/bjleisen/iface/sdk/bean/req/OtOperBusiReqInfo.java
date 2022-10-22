package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class OtOperBusiReqInfo extends BaseBusiReqInfo {
    private String cplc;
    private String euid;
    private String instanceAid;
    private int otType;

    public String getCplc() {
        return this.cplc;
    }

    public String getEuid() {
        return this.euid;
    }

    public String getInstanceAid() {
        return this.instanceAid;
    }

    public int getOtType() {
        return this.otType;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public void setEuid(String str) {
        this.euid = str;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
    }

    public void setOtType(int i10) {
        this.otType = i10;
    }
}
