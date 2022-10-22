package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class ApplyInvoiceReqInfo extends BaseBusiReqInfo {
    private String invoicesAddress;
    private int invoicesType;
    private String orderId;

    public String getInvoicesAddress() {
        return this.invoicesAddress;
    }

    public int getInvoicesType() {
        return this.invoicesType;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setInvoicesAddress(String str) {
        this.invoicesAddress = str;
    }

    public void setInvoicesType(int i10) {
        this.invoicesType = i10;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }
}
