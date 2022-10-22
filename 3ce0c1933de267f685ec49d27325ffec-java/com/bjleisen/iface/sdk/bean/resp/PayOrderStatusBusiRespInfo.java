package com.bjleisen.iface.sdk.bean.resp;
/* loaded from: classes.dex */
public class PayOrderStatusBusiRespInfo extends BaseBusiRespInfo {
    private String orderDate;
    private String orderId;
    private int orderMoney;
    private int orderStatus;
    private String transNumber;
    private int transStatus;

    public String getOrderDate() {
        return this.orderDate;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public int getOrderMoney() {
        return this.orderMoney;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public String getTransNumber() {
        return this.transNumber;
    }

    public int getTransStatus() {
        return this.transStatus;
    }

    public void setOrderDate(String str) {
        this.orderDate = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOrderMoney(int i10) {
        this.orderMoney = i10;
    }

    public void setOrderStatus(int i10) {
        this.orderStatus = i10;
    }

    public void setTransNumber(String str) {
        this.transNumber = str;
    }

    public void setTransStatus(int i10) {
        this.transStatus = i10;
    }
}
