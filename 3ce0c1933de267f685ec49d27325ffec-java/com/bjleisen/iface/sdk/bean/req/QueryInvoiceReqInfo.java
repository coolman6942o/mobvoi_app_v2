package com.bjleisen.iface.sdk.bean.req;
/* loaded from: classes.dex */
public class QueryInvoiceReqInfo extends BaseBusiReqInfo {
    private int invoiceType;
    private String orderId;

    public int getInvoiceType() {
        return this.invoiceType;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setInvoiceType(int i10) {
        this.invoiceType = i10;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }
}
