package com.laser.tsm.sdk.business;
/* loaded from: classes2.dex */
public class SSDOperBusinessForReq extends BaseBusinessForReq {
    private String cin;
    private String iin;
    private int operType;
    private String ssdAid;

    public String getCin() {
        return this.cin;
    }

    public String getIin() {
        return this.iin;
    }

    public int getOperType() {
        return this.operType;
    }

    public String getSsdAid() {
        return this.ssdAid;
    }

    public void setCin(String str) {
        this.cin = str;
    }

    public void setIin(String str) {
        this.iin = str;
    }

    public void setOperType(int i10) {
        this.operType = i10;
    }

    public void setSsdAid(String str) {
        this.ssdAid = str;
    }
}
