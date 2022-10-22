package com.bjleisen.iface.sdk.bean;
/* loaded from: classes.dex */
public class Action {
    private String actCode;
    private String actDesc;
    private int actMoney;
    private int actMoneyType;
    private int actType;
    private String endTime;
    private int minLimitMoney;
    private int remainder;
    private String startTime;
    private int totalCount;
    private int transStatus;

    public String getActCode() {
        return this.actCode;
    }

    public String getActDesc() {
        return this.actDesc;
    }

    public int getActMoney() {
        return this.actMoney;
    }

    public int getActMoneyType() {
        return this.actMoneyType;
    }

    public int getActType() {
        return this.actType;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public int getMinLimitMoney() {
        return this.minLimitMoney;
    }

    public int getRemainder() {
        return this.remainder;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTransStatus() {
        return this.transStatus;
    }

    public void setActCode(String str) {
        this.actCode = str;
    }

    public void setActDesc(String str) {
        this.actDesc = str;
    }

    public void setActMoney(int i10) {
        this.actMoney = i10;
    }

    public void setActMoneyType(int i10) {
        this.actMoneyType = i10;
    }

    public void setActType(int i10) {
        this.actType = i10;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setMinLimitMoney(int i10) {
        this.minLimitMoney = i10;
    }

    public void setRemainder(int i10) {
        this.remainder = i10;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setTotalCount(int i10) {
        this.totalCount = i10;
    }

    public void setTransStatus(int i10) {
        this.transStatus = i10;
    }
}
