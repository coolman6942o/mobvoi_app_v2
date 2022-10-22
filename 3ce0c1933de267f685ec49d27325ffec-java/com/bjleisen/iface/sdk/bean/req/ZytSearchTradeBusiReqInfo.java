package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class ZytSearchTradeBusiReqInfo extends BaseBusiReqInfo {
    private String cardNo;
    private String endDate;
    private String instanceAid;
    private int rtnindNo;
    private int rtning;
    private String startDate;
    private String tranDate;
    private String tranTime;

    public String getCardNo() {
        return this.cardNo;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getInstanceAid() {
        return this.instanceAid;
    }

    public int getRtnindNo() {
        return this.rtnindNo;
    }

    public int getRtning() {
        return this.rtning;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getTranDate() {
        return this.tranDate;
    }

    public String getTranTime() {
        return this.tranTime;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }

    public void setEndDate(String str) {
        this.endDate = str;
    }

    public void setInstanceAid(String str) {
        this.instanceAid = str;
    }

    public void setRtnindNo(int i10) {
        this.rtnindNo = i10;
    }

    public void setRtning(int i10) {
        this.rtning = i10;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public void setTranDate(String str) {
        this.tranDate = str;
    }

    public void setTranTime(String str) {
        this.tranTime = str;
    }
}
