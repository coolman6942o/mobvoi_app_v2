package com.bjleisen.iface.sdk.bean;
/* loaded from: classes.dex */
public class Invoice {
    private String endTime;
    private String invoiceCode;
    private int invoicesMoney;
    private int invoicesType;
    private String startTime;

    public String getEndTime() {
        return this.endTime;
    }

    public String getInvoiceCode() {
        return this.invoiceCode;
    }

    public int getInvoicesMoney() {
        return this.invoicesMoney;
    }

    public int getInvoicesType() {
        return this.invoicesType;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setInvoiceCode(String str) {
        this.invoiceCode = str;
    }

    public void setInvoicesMoney(int i10) {
        this.invoicesMoney = i10;
    }

    public void setInvoicesType(int i10) {
        this.invoicesType = i10;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }
}
