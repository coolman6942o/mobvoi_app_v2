package com.bjleisen.iface.sdk.bean;
/* loaded from: classes.dex */
public class TradeDetail {
    private int amttrans;
    private String sysDate;
    private String sysTime;
    private int trancode;

    public int getAmttrans() {
        return this.amttrans;
    }

    public String getSysDate() {
        return this.sysDate;
    }

    public String getSysTime() {
        return this.sysTime;
    }

    public int getTrancode() {
        return this.trancode;
    }

    public void setAmttrans(int i10) {
        this.amttrans = i10;
    }

    public void setSysDate(String str) {
        this.sysDate = str;
    }

    public void setSysTime(String str) {
        this.sysTime = str;
    }

    public void setTrancode(int i10) {
        this.trancode = i10;
    }
}
